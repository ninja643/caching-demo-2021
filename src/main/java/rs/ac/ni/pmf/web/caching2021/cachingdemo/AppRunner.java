package rs.ac.ni.pmf.web.caching2021.cachingdemo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import rs.ac.ni.pmf.web.caching2021.cachingdemo.model.Book;
import rs.ac.ni.pmf.web.caching2021.cachingdemo.repository.BookRepository;

@Component
@Slf4j
@RequiredArgsConstructor
public class AppRunner implements CommandLineRunner
{
	private final BookRepository _bookRepository;

	@Override
	public void run(String... args) throws Exception
	{
		log.warn("Running...");
		final String isbn1 = "123";
		final String isbn2 = "234";
		final String isbn3 = "5345332432";

		log.info(_bookRepository.getByIsbn(isbn1).toString());
		log.info(_bookRepository.getByIsbn(isbn1).toString());
		try
		{
			_bookRepository.update(isbn1, "Trlalala");
		}
		catch (RuntimeException e)
		{
			// nista...
		}
		log.info(_bookRepository.getByIsbn(isbn1).toString());

//		log.info(_bookRepository.getByIsbn(isbn1).toString());
//
//		_bookRepository.update(isbn1, "New Title");
//
//		log.info(_bookRepository.getByIsbn(isbn1).toString());
//
//		System.out.println(_bookRepository.size());
//		_bookRepository.delete(isbn1);
//		System.out.println(_bookRepository.size());
//
//		final Book byIsbn = _bookRepository.getByIsbn(isbn1);
//		if (byIsbn == null)
//		{
//			log.info("Book not found!");
//		}
//		else
//		{
//			log.info(byIsbn.toString());
//		}


//		log.info(_bookRepository.getByIsbn(isbn1, true).toString());
//		log.info(_bookRepository.getByIsbn(isbn2, true).toString());
//		log.info(_bookRepository.getByIsbn(isbn3, true).toString());
//
//		log.info(_bookRepository.getByIsbn(isbn1, false).toString());
//		log.info(_bookRepository.getByIsbn(isbn2, true).toString());
//		log.info(_bookRepository.getByIsbn(isbn3, true).toString());
//
//		log.info(_bookRepository.getByIsbn(isbn1, true).toString());
//		log.info(_bookRepository.getByIsbn(isbn2, true).toString());
	}
}
