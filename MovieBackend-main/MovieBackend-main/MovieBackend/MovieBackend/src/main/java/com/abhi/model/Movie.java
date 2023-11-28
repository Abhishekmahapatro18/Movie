package com.abhi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "movie_id")
	private int movieId;

	@Column(name = "movie_name")
	private String movieName;

	@Column(name = "movie_description")
	private String movieDescription;
	
	@Column(name = "movie_duration")
	private String movieDuration;

	@Column(name = "movie_rating")
	private Float movieRating;

	@Column(name = "movie_ticket_price")
	private Float movieTicketPrice;

	@Column(name = "movie_image")
	private String movieImagePath;

	@Column(name = "movie_action_type")
	private String movieActionType;

	@Column(name = "movie_avilable")
	private boolean movieAvilable;

	public Movie() {

	}

	public Movie(String movieName, String movieDescription, String movieDuration, Float movieRating,
			Float movieTicketPrice, String movieImagePath, String movieActionType, boolean movieAvilable) {
		super();
		this.movieName = movieName;
		this.movieDescription = movieDescription;
		this.movieDuration = movieDuration;
		this.movieRating = movieRating;
		this.movieTicketPrice = movieTicketPrice;
		this.movieImagePath = movieImagePath;
		this.movieActionType = movieActionType;
		this.movieAvilable = movieAvilable;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDescription() {
		return movieDescription;
	}

	public void setMovieDescription(String movieDescription) {
		this.movieDescription = movieDescription;
	}

	public String getMovieDuration() {
		return movieDuration;
	}

	public void setMovieDuration(String movieDuration) {
		this.movieDuration = movieDuration;
	}

	public Float getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(Float movieRating) {
		this.movieRating = movieRating;
	}

	public Float getMovieTicketPrice() {
		return movieTicketPrice;
	}

	public void setMovieTicketPrice(Float movieTicketPrice) {
		this.movieTicketPrice = movieTicketPrice;
	}

	public String getMovieImagePath() {
		return movieImagePath;
	}

	public void setMovieImagePath(String movieImagePath) {
		this.movieImagePath = movieImagePath;
	}

	public String getMovieActionType() {
		return movieActionType;
	}

	public void setMovieActionType(String movieActionType) {
		this.movieActionType = movieActionType;
	}

	public boolean isMovieAvilable() {
		return movieAvilable;
	}

	public void setMovieAvilable(boolean movieAvilable) {
		this.movieAvilable = movieAvilable;
	}
	
}
