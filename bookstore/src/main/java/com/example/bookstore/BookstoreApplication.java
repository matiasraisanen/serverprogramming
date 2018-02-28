package com.example.bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;
import com.example.bookstore.domain.Category;
import com.example.bookstore.domain.CategoryRepository;
import com.example.bookstore.domain.User;
import com.example.bookstore.domain.UserRepository;

@SpringBootApplication
public class BookstoreApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookShow(BookRepository repository, CategoryRepository crepository, UserRepository urepository) {
		
		return new CommandLineRunner() {
			@Override
			public void run(String... arg0) throws Exception {
				
				crepository.save(new Category("Fantasy"));
				crepository.save(new Category("Comedy"));
				crepository.save(new Category("Drama"));
				crepository.save(new Category("Horror"));
				crepository.save(new Category("Adventure"));
				crepository.save(new Category("Romance"));
				crepository.save(new Category("Tragedy"));
				crepository.save(new Category("Biography"));
				crepository.save(new Category("SciFi"));
				crepository.save(new Category("Thriller"));
				
				repository.save(new Book(1L, "978-1-59853-164-0", "Tarzan of the Apes", "Edgar Rice Burroughs", 1912, 19.99, crepository.findByName("Adventure").get(0)));
				repository.save(new Book(2L, "0-330-25864-8", "The Hitchhiker's Guide to the Galaxy", "Douglas Adams" ,1979, 5.50, crepository.findByName("SciFi").get(0)));
				repository.save(new Book(3L, "978-0-00-734388-1", "The Woodcutter", "Reginald Hill" , 2010, 12.99, crepository.findByName("Thriller").get(0)));
				repository.save(new Book(4L, "978-1-7802-2135-9", "Gone Girl", "Gillian Flynn" , 2012, 7.99, crepository.findByName("Thriller").get(0)));
				repository.save(new Book(5L, "951-1-15369-2", "Seitsemän Veljestä", "Aleksis Kivi" , 1870, 15.00, crepository.findByName("Drama").get(0)));
				
				User user1 = new User("user",
						"$2a$04$mxoXUkYt0qfJoEiiwSb3nuVIhyAXgFHuKPbMFkc9vin1TjM57M9sK", "USER"); //password: userpassword
						User user2 = new User("admin",
						"$2a$04$1f8vFr5XakBdIxsZNlIY1O1vlr0uP.i5XRy9AfE1HJ2DaBL3WTB1W", "ADMIN"); //password: adminpassword
						urepository.save(user1);
						urepository.save(user2);

				
				
			
				
				for (Book book: repository.findAll()){
					System.out.println(book.toString());
				}
			};
		};
	}
}
