package com.example.movieCollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.movieCollection.domain.Movie;
import com.example.movieCollection.domain.MovieRepository;

@SpringBootApplication
public class MovieCollectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieCollectionApplication.class, args);
	}

	@Bean
	public CommandLineRunner movieShow(MovieRepository repository) {

		return new CommandLineRunner() {
			@Override
			public void run(String... arg0) throws Exception {
				//Let's create the database with 5 movies
				repository.save(new Movie(1L, "tt0103064", "Terminator 2: Judgment Day", "James Cameron", 1991, "http://www.imdb.com/title/tt0103064/"));
				repository.save(new Movie(2L, "tt0082694", "Mad Max 2: The Road Warrior", "George Miller", 1981, "http://www.imdb.com/title/tt0082694/"));
				repository.save(new Movie(3L, "tt0100403", "Predator 2", "Stephen Hopkins", 1990, "http://www.imdb.com/title/tt0100403/"));
				repository.save(new Movie(4L, "tt0090605", "Aliens", "James Cameron", 1986, "http://www.imdb.com/title/tt0090605/"));
				repository.save(new Movie(5L, "tt0083658", "Blade Runner", "Ridley Scott", 1982, "http://www.imdb.com/title/tt0083658/"));
								
				for (Movie movie : repository.findAll()) {
					System.out.println(movie.toString());
				}
			};
		};
	}
}
