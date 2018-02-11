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
				//THIS IS NOT INDEX.HTML
				repository.save(new Movie("tt0103064", "Terminator 2: Judgment Day", "James Cameron", 1991, "http://www.imdb.com/title/tt0103064/"));

				for (Movie movie : repository.findAll()) {
					System.out.println(movie.toString());
				}
			};
		};
	}
}
