package com.example.movieCollection.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
public class Movie {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	//Database ID. Primary key and autonumber
	@NotNull
	private String imdb_id;	//Identifier in IMDB.com
	@NotNull
	private String title;	// Movie title
	@NotNull
	private String director;	// Movie director
	@NotNull
	@Min(1)
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
		this.imdb_url = "http://www.imdb.com/title/" + imdb_id; //This will construct the IMDB-url to be saved into the database.
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
		//This will construct the IMDB rating plugin script, using the IMDB-ID provided by the user.
		imdb_url = "<span class='imdbRatingPlugin' data-user='ur85273547' data-title='" +this.imdb_id + "' data-style='p2'><a href='https://www.imdb.com/title/"+this.imdb_id+"/?ref_=plg_rt_1'><img src='https://ia.media-imdb.com/images/G/01/imdb/plugins/rating/images/imdb_38x18.png' alt='Movie on IMDb' /></a></span><script>(function(d,s,id){var js,stags=d.getElementsByTagName(s)[0];if(d.getElementById(id)){return;}js=d.createElement(s);js.id=id;js.src='https://ia.media-imdb.com/images/G/01/imdb/plugins/rating/js/rating.js';stags.parentNode.insertBefore(js,stags);})(document,'script','imdb-rating-api');</script>"; 
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
