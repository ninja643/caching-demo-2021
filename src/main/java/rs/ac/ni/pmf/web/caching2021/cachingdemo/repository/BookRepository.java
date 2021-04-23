package rs.ac.ni.pmf.web.caching2021.cachingdemo.repository;

import org.springframework.cache.annotation.Cacheable;
import rs.ac.ni.pmf.web.caching2021.cachingdemo.model.Book;

public interface BookRepository
{
	Book add(Book book);

	Book getByIsbn(String isbn);

	Book update(String isbn, String title);

	void delete(String isbn);

	int size();

	void clearCache();
}
