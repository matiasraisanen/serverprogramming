package com.example.movieCollection.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.movieCollection.domain.Movie;
import com.example.movieCollection.domain.MovieRepository;

@Controller
public class MovieController {
	@Autowired
	private MovieRepository repository;

	@RequestMapping(value = "/index")
	public String movies(Model model) {

		Movie movie1 = new Movie("tt0103064", "Terminator 2: Judgment Day", "James Cameron", 1991, "http://www.imdb.com/title/tt0103064/");
		Movie movie2 = new Movie("tt0082694", "Mad Max 2: The Road Warrior", "George Miller", 1981, "http://www.imdb.com/title/tt0082694/");
		Movie movie3 = new Movie("tt0100403", "Predator 2", "Stephen Hopkins", 1990, "http://www.imdb.com/title/tt0100403/");
		Movie movie4 = new Movie("tt0090605", "Aliens", "James Cameron", 1986, "http://www.imdb.com/title/tt0090605/");
		List<Movie> movielist = new ArrayList<>();
		movielist.add(movie1);
		movielist.add(movie2);
		movielist.add(movie3);
		movielist.add(movie4);
		model.addAttribute("movies", movielist);

		return "index";
	}

	@RequestMapping(value = "/movielist")
	public String movielist(Model model) {

		List<Movie> movies = (List<Movie>) repository.findAll();

		model.addAttribute("movies", movies);

		return "movielist";
	}

	@RequestMapping(value = "/addmovie")
	public String addmovie(Model model) {
		return "addmovie";
	}

}
