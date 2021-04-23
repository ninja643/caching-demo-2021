//package rs.ac.ni.pmf.web.caching2021.cachingdemo.controller;
//
//import java.time.ZonedDateTime;
//import java.util.concurrent.TimeUnit;
//import javax.servlet.http.HttpServletResponse;
//import org.springframework.http.*;
//import org.springframework.web.bind.annotation.*;
//import rs.ac.ni.pmf.web.caching2021.cachingdemo.model.Book;
//
//@RestController
//public class BookController
//{
//	@RequestMapping("/book/{isbn}")
//	public Book getBook(@PathVariable final String isbn, HttpServletResponse response)
//	{
//		response.addHeader("Cache-Control", "max-age=60, must-revalidate, no-transform");
//
//		return new Book(isbn, "Book Title");
//	}
//
//	@RequestMapping("/bookentity/{isbn}")
//	public ResponseEntity<Book> getBookEntity(@PathVariable final String isbn)
//	{
//		String version = "1"; // compute version
//
//		if (currentVersion(isbn).equals(version))
//		{
//			return ResponseEntity
//				.status(HttpStatus.NOT_MODIFIED)
//				.build();
//		}
//
//		return ResponseEntity
//			.ok()
//			.eTag(version)
//			.lastModified(ZonedDateTime.now())
//			.cacheControl(CacheControl
//				.maxAge(5, TimeUnit.MINUTES)
//				.mustRevalidate()
//				.noTransform()
//			)
//			.body(new Book(isbn, "Book Title"));
//	}
//
//	private String currentVersion(String isbn)
//	{
//		return "1";
//	}
//}
