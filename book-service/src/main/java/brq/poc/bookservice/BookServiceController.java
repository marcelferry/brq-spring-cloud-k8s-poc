package brq.poc.bookservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/books")
public class BookServiceController {
	
	@Autowired
	BookRepository bookRepository;
	
	@Autowired
	RestTemplate restTemplate;


//	@GetMapping("/")
	public List<Book> findAllBooks() {
		return bookRepository.findAll();
	}

//	@GetMapping("/{bookId}")
	public Book findBook(@PathVariable Long bookId) {
		Book book = bookRepository.findOne(bookId);
		return book;
	}
	
	@GetMapping("/{bookId}/ratings")
	public Book findBookFull(@PathVariable Long bookId) {
		Book book = bookRepository.findOne(bookId);
		PagedResources<Rating> result = restTemplate.exchange( "http://RATING-SERVICE/ratings/search/findByBookId?bookId={bookId}", HttpMethod.GET, null,  new ParameterizedTypeReference<PagedResources<Rating>>() {}, bookId).getBody();
		book.setRatings( new ArrayList<Rating>( result.getContent() ) );
		return book;
	}

}
