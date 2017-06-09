package brq.poc.bookservice;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Book {

	@Id
	private Long id;
	private String author;
	private String title;
	
	@Transient
	List<Rating> ratings;
	
	
	public Book(){}

	public Book(Long id, String author, String title) {
		super();
		this.id = id;
		this.author = author;
		this.title = title;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}
	
	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}
	
	public List<Rating> getRatings() {
		return ratings;
	}

}
