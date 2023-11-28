package com.abhi.service;

import java.util.List;

import com.abhi.model.Movie;

public interface MovieService {
	// Method to add new Movie
	public Movie addNewMovie(Movie movie);

	// Method to view all Movie
	public List<Movie> viewAllMovie();

	// Method to get movie by id
	public Movie getMovieById(int movieId);
	
	// Method to update movie by id
	public Movie updateMovieById(Movie movie);
	
	// Method to delete movie by id
	public boolean deleteMovieById(int movieId);
	
	//Method to serach Movie By Keyword
	public List<Movie> searchMovieByKeyword(String serachMovieKeyword);
	
	//Method to serach Movie By MovieAction
	public List<Movie> searchMovieByAction(String serachByMovieAction);
}
