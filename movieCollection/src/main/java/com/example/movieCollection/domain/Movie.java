package com.example.movieCollection.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id
	private String imdb_number;
	private String title;
	private String director;
	private int year;
	private String imdb_rating_url;
	
	public Movie(){}

	
	


	public Movie(String imdb_number, String title, String director, int year,
			String imdb_rating_url) {
		super();
		this.imdb_number = imdb_number;
		this.title = title;
		this.director = director;
		this.year = year;
		this.imdb_rating_url = imdb_rating_url;
	}





	public String getImdb_number() {
		return imdb_number;
	}
	
	public void setImdb_number(String imdb_number) {
		this.imdb_number = imdb_number;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	
	
	public String getImdb_rating_url() {
		return imdb_rating_url;
	}


	public void setImdb_rating_url(String imdb_rating_url) {
		this.imdb_rating_url = imdb_rating_url;
	}



	@Override
	public String toString() {
		return "Movie [imdb_number=" + imdb_number + ", title=" + title
				+ ", director=" + director + ", year=" + year
				+ ", imdb_rating_url=" + imdb_rating_url + "]";
	}
	
	
	

}
