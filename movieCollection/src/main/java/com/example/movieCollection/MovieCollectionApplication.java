package com.example.movieCollection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

//import com.example.movieCollection.domain.User;
import com.example.movieCollection.domain.UserRepository;
import com.example.movieCollection.domain.Movie;
import com.example.movieCollection.domain.MovieRepository;

@SpringBootApplication
public class MovieCollectionApplication  extends SpringBootServletInitializer{
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder
	application) {
	return application.sources(MovieCollectionApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieCollectionApplication.class, args);
	}

	@Bean
	public CommandLineRunner movieShow(MovieRepository repository, UserRepository urepository) {
		
		

		return new CommandLineRunner() {
			@Override
			public void run(String... arg0) throws Exception {
				/*
				//Here we can add example movies into the database.
				repository.save(new Movie(1L, "tt0103064", "Terminator 2: Judgment Day", "James Cameron", 1991, "http://www.imdb.com/title/tt0103064/"));
				repository.save(new Movie(2L, "tt0082694", "Mad Max 2: The Road Warrior", "George Miller", 1981, "http://www.imdb.com/title/tt0082694/"));
				repository.save(new Movie(3L, "tt0100403", "Predator 2", "Stephen Hopkins", 1990, "http://www.imdb.com/title/tt0100403/"));
				repository.save(new Movie(4L, "tt0090605", "Aliens", "James Cameron", 1986, "http://www.imdb.com/title/tt0090605/"));
				repository.save(new Movie(5L, "tt0083658", "Blade Runner", "Ridley Scott", 1982, "http://www.imdb.com/title/tt0083658/"));
				repository.save(new Movie(6L, "tt0078748", "Alien", "Ridley Scott", 1979, "http://www.imdb.com/title/tt0078748/"));
				repository.save(new Movie(7L, "tt0118583", "Alien: Resurrection", "Jean-Pierre Jeunet", 1982, "http://www.imdb.com/title/tt0118583/"));
				repository.save(new Movie(8L, "tt0103644", "Alien 3", "David Fincher", 1992, "http://www.imdb.com/title/tt0103644/"));
				repository.save(new Movie(9L, "tt0093773", "Predator", "John McTiernan", 1987, "http://www.imdb.com/title/tt0093773/"));
				repository.save(new Movie(10L, "tt0109506", "The Crow", "Alex Proyas", 1992, "http://www.imdb.com/title/tt0109506/"));
				*/
				
				/*
				//Here we can add example users into the database, with a Bcrypt-hashed password:
				User user1 = new User("user",
						"$2a$04$mxoXUkYt0qfJoEiiwSb3nuVIhyAXgFHuKPbMFkc9vin1TjM57M9sK", "USER"); //password: userpass123
				User user2 = new User("admin",
						"$2a$10$dxKYm0h08VPteSRuclDvgeEDXRSfVYFGO98xUSNFiChSZxbKa2K6C", "ADMIN"); //password: adminpass123
				urepository.save(user1);
				urepository.save(user2);
				*/		
				
				for (Movie movie : repository.findAll()) {
					System.out.println(movie.toString());
				}
			};
		};
	}
}
