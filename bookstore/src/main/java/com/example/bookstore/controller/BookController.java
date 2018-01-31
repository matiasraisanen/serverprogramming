package com.example.bookstore.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.bookstore.domain.Book;

@Controller
public class BookController {
	@RequestMapping(value="/index")
	public String books(Model model) {
		
		Book book1 = new Book("King Kong", "John Smith", 1999, "ABC-1234", 19.99);
		Book book2 = new Book("Cooking with dirt", "Rachel Ruffian" , 1980, "LOL-123", 5.50);
		
		List<Book> booklist = new ArrayList<>();
		booklist.add(book1);
		booklist.add(book2);
		
		model.addAttribute("books", booklist);
		
		return "index";
	}

}
