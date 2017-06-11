package brq.poc.ratingservice;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingServiceController {

	@Resource
	RatingRepository ratingRepository;

	@GetMapping("/{bookId}")
	public List<Rating> findRatingsByBookId(@PathVariable Long bookId) {
		return ratingRepository.findByBookId(bookId);
	}

	@GetMapping("/")
	public List<Rating> findAllRatings() {
		return ratingRepository.findAll(); // ratingList;
	}

	@PostMapping("/{bookId}/{stars}")
	public List<Rating> saveRatingForBookId(@PathVariable Long bookId, @PathVariable Integer stars) {

		Rating r = new Rating(bookId, stars);
		ratingRepository.save(r);

		return ratingRepository.findByBookId(bookId);
	}

}
