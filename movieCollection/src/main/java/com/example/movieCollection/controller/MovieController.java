package com.example.movieCollection.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.movieCollection.domain.Movie;
import com.example.movieCollection.domain.MovieRepository;

@Controller
public class MovieController {
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	public String finalString = null;
	
	@Autowired
	private MovieRepository repository;
	
	// Login page
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	

	// Fetch all movies from the database and create a list
	@RequestMapping(value = {"/index"})
	public String movies(Model model) {
		List<Movie> movies = (List<Movie>) repository.findAll();
		model.addAttribute("movies", movies);
		return "index";
	}

	// RESTful service to get all movies
	@RequestMapping(value = "/movielist", method = RequestMethod.GET)
	public @ResponseBody List<Movie> movieListRest() {
		return (List<Movie>) repository.findAll();
		}
	
	//RESTful service to get one movie by ID.
	@RequestMapping(value="/movie/{id}", method = RequestMethod.GET)
	public @ResponseBody Movie findMovieRest (@PathVariable("id") Long movieId) {
		return repository.findOne(movieId);
	}

	// Create a new Movie object
	@RequestMapping(value = "/add")
	public String addMovie(Model model) {
		model.addAttribute("movie", new Movie());
		return "addmovie";
	}
	
	//Edit a specific movie.
	@RequestMapping(value = "/edit_{id}")
	public String addMovie(@PathVariable("id") Long movieId, Model model){
		model.addAttribute("movie", repository.findOne(movieId));
		return "editmovie";
	}
	
	// Save an added movie to database
	@RequestMapping(value="/save", method = RequestMethod.POST)
	public String save(@ModelAttribute @Valid Movie movie, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()){	//Validate fields for errors. In case of errors, refresh page.
			return "addmovie";
		} else {
		movie.setImdb_url("http://www.imdb.com/title/" + movie.getImdb_id());	//Constructs the IMDb-url using the IMDb ID.
		repository.save(movie);
		return "redirect:index";
		}
	}
	
	// Save an edited movie to database
	@RequestMapping(value="/saveEdit", method = RequestMethod.POST)
	public String saveEdit(@ModelAttribute @Valid Movie movie, BindingResult bindingResult, Model model){
		if (bindingResult.hasErrors()){	//Validate fields for errors. In case of errors, refresh page
			return "editmovie";
		} else {
		movie.setImdb_url("http://www.imdb.com/title/" + movie.getImdb_id());	//Constructs the IMDb-url using the IMDb ID.
		repository.save(movie);
		return "redirect:index";
		}
	}
	
	// Delete a movie by its ID
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteMovie(@PathVariable("id") Long movieId, Model model) {
		repository.delete(movieId);
		return "redirect:../index";
	}
}
