package com.example.movieCollection.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.movieCollection.domain.Movie;
import com.example.movieCollection.domain.MovieRepository;

@Controller
public class MovieController {
	@Autowired
	private MovieRepository repository;

	// Fetch all movies from the database and create a list
	@RequestMapping(value = "/index")
	public String movies(Model model) {
		List<Movie> movies = (List<Movie>) repository.findAll();
		model.addAttribute("movies", movies);
		return "index";
	}
	
	@RequestMapping(value = "/testpage")
	public String testpage(Model model) {
		return "testpage";
	}

	// Not really used, left for testing purposes. Connect to /index instead.
	@RequestMapping(value = "/movielist")
	public String movielist(Model model) {
		List<Movie> movies = (List<Movie>) repository.findAll();
		model.addAttribute("movies", movies);
		return "movielist";
	}

	// Create a new Movie object
	@RequestMapping(value = "/add")
	public String addMovie(Model model) {
		model.addAttribute("movie", new Movie("http://www.imdb.com/title/"));
		return "addmovie";
	}
	
	@RequestMapping(value = "/edit/{id}")
	public String addMovie(@PathVariable("id") Long movieId, Model model){
		model.addAttribute("movie", repository.findOne(movieId));
		return "editmovie";
	}
	
	// Save an added or edited movie to database
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(Movie movie){
		repository.save(movie);
		return "redirect:index";
	}
	
	// Delete a movie by its ID
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteMovie(@PathVariable("id") Long movieId, Model model) {
		repository.delete(movieId);
		return "redirect:../index";
	}
}
