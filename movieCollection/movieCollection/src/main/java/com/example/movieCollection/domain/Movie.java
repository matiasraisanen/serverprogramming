package com.example.movieCollection.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	//Database ID. Primary key and autonumber
	private String imdb_id;	//Identifier in IMDB.com
	private String title;	// Movie title
	private String director;	// Movie director
	private int year;	//Year of release
	private String imdb_url;	//URL to movie's IMDB page
	
	public Movie(){}

	public Movie(Long id, String imdb_id, String title, String director,
			int year, String imdb_url) {
		super();
		this.id = id;
		this.imdb_id = imdb_id;
		this.title = title;
		this.director = director;
		this.year = year;
		this.imdb_url = imdb_url;
	}
	
	public Movie(String imdb_url) {
		this.imdb_url = imdb_url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getImdb_id() {
		return imdb_id;
	}

	public void setImdb_id(String imdb_id) {
		this.imdb_id = imdb_id;
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

	public String getImdb_url() {
		return imdb_url;
	}

	public void setImdb_url(String imdb_url) {
		this.imdb_url = imdb_url;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", imdb_id=" + imdb_id + ", title=" + title
				+ ", director=" + director + ", year=" + year + ", imdb_url="
				+ imdb_url + "]";
	}



}
