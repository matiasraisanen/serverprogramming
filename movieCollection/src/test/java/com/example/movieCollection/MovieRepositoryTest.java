package com.example.movieCollection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;

import com.example.movieCollection.domain.Movie;
import com.example.movieCollection.domain.MovieRepository;

@RunWith(SpringRunner.class)
@DataJpaTest
public class MovieRepositoryTest {
	
	@Autowired
	private MovieRepository repository;
	
	@Test
	public void addNewMovie() {
		Movie movie = new Movie(1L, "tt1234567" , "Titanic", "James Cameron", 1991, "http://www.imdb.com");
		repository.save(movie);
		
		assertThat(movie.getId()).isNotNull();
		assertThat(movie.getTitle()).isEqualTo("Titanic");
		assertThat(movie.getDirector()).isEqualTo("James Cameron");
		
	}

}
