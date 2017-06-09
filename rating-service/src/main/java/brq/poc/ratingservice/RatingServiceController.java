package brq.poc.ratingservice;

import java.util.Arrays;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@RestController
//@RequestMapping("/ratings")
public class RatingServiceController {
	
	@Resource
	RatingRepository ratingRepository;

	private List<Rating> ratingList = Arrays.asList(new Rating(1L, 1L, 2), new Rating(2L, 1L, 3), new Rating(3L, 2L, 4),
			new Rating(4L, 2L, 5));

	@GetMapping("/{bookId}")
	public List<Rating> findRatingsByBookId(@PathVariable Long bookId) {
		return ratingRepository.findByBookId(bookId);//bookId == null || bookId.equals(0L) ? Collections.emptyList()
				//: ratingList.stream().filter(r -> r.getBookId().equals(bookId)).collect(Collectors.toList());
	}

	@GetMapping("/all")
	public List<Rating> findAllRatings() {
		return ratingRepository.findAll(); //ratingList;
	}

}
