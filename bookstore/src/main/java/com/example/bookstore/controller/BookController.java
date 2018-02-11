package com.example.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookstore.domain.Book;
import com.example.bookstore.domain.BookRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;

	@RequestMapping(value = "/index")
	public String books(Model model) {

		Book book1 = new Book("King Kong", "John Smith", 1999, "ABC-1234",
				19.99);
		Book book2 = new Book("Cooking with dirt", "Rachel Ruffian", 1980,
				"LOL-123", 5.50);
		Book book3 = new Book("The Lion King", "Peter Griffin", 1994,
				"1ASDF-1234", 25.50);
		Book book4 = new Book("Pogo Stick for Dummies", "Matthew Hopkins",
				2007, "87346R8943", 9.50);

		List<Book> booklist = new ArrayList<>();
		booklist.add(book1);
		booklist.add(book2);
		booklist.add(book3);
		booklist.add(book4);

		model.addAttribute("books", booklist);

		return "index";
	}

	@RequestMapping(value = "/booklist")
	public String booklist(Model model) {

		List<Book> books = (List<Book>) repository.findAll();

		model.addAttribute("books", books);

		return "booklist";
	}
	
	@RequestMapping(value = "/addbook")
	public String addbook(Model model) {
		return "addbook";
	}
	

}
