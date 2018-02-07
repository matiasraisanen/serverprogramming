package com.example.bookstore;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@SpringBootApplication
public class BookstoreApplication {
	


	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner bookShow(BookRepository repository) {
		
		return new CommandLineRunner() {
			@Override
			public void run(String... arg0) throws Exception {
				repository.save(new Book("King Kong", "John Smith", 1999, "ABC-1234", 19.99));
				repository.save(new Book("Cooking with dirt", "Rachel Ruffian" , 1980, "LOL-123", 5.50));
				repository.save(new Book("The Lion King", "Peter Griffin" , 1994, "1ASDF-1234", 25.50));
				
				for (Book book: repository.findAll()){
					System.out.println(book.toString());
				}
			};
		};
	}
}
