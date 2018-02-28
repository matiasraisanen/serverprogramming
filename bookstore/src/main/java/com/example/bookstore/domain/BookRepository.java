package com.example.bookstore.domain;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource
public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findByCategory(@Param("category") String category);
	List<Book> findByAuthor(@Param("author") String author);
	//Test with http://localhost:8080/api/books/search/findByAuthor?author=Douglas%20Adams
	
}
