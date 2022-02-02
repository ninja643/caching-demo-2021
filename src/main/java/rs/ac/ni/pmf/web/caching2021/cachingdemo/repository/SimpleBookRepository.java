package rs.ac.ni.pmf.web.caching2021.cachingdemo.repository;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.*;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import rs.ac.ni.pmf.web.caching2021.cachingdemo.model.Book;

@Slf4j
@Component
@CacheConfig(cacheNames = "books")
public class SimpleBookRepository implements BookRepository, InitializingBean
{
	private final String isbn1 = "123";
	private final String isbn2 = "234";
	private final String isbn3 = "5345332432";

	private final Map<String, Book> _books = new HashMap<>();

	@Override
	public void afterPropertiesSet() throws Exception
	{
		_books.put(isbn1, new Book(isbn1, "Book 1"));
		_books.put(isbn2, new Book(isbn1, "Book 2"));
		_books.put(isbn3, new Book(isbn1, "Book 3"));
	}

	@Override
	public Book add(Book book)
	{
		return null;
	}

	@Override
//	@Cacheable(cacheNames = "books", key = "#isbn", condition = "#isbn.length() < 5", unless = "#isbn.startsWith('1')")
//	@Cacheable(cacheNames = "books", key = "#isbn", unless = "#addToCache == false")
	@Cacheable
	public Book getByIsbn(String isbn)
	{
		log.info("Getting the book '{}'", isbn);
		simulateSlowService();
		return _books.get(isbn);
	}

	@Override
	@CachePut(key = "#isbn")
	public Book update(String isbn, String title)
	{
		final Book book = _books.get(isbn);

		if (book == null)
		{
			log.error("Book {} not found", isbn);
			return null;
		}

//		throw new RuntimeException("Error");

		log.info("Updating title for {}", isbn);
		final Book newBook = new Book(isbn, title);
		_books.put(isbn, newBook);
		log.info("Updated book: {}", newBook);
		return newBook;
	}

	@Override
	@CacheEvict(key = "#isbn")
	public void delete(String isbn)
	{
		_books.remove(isbn);
	}

	@Override
	public int size()
	{
		return _books.size();
	}

	@Override
	@CacheEvict(allEntries = true)
//	@Scheduled(initialDelay = 3000, fixedDelay = 3000)
	public void clearCache()
	{
		log.warn("Clearing the cache...");
	}

	private void simulateSlowService()
	{
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}
