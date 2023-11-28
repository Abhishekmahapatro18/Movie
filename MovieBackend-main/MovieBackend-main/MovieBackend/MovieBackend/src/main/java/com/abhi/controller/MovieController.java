package com.abhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.model.Movie;
import com.abhi.service.MovieService;

@CrossOrigin
@RestController
@RequestMapping("/api/movie/")  //http://localhost:9093/api/movie/
public class MovieController {
	
	@Autowired
	MovieService movieService;
	
	//get all movie
	@GetMapping(value = "/viewAllMovie")
	public List<Movie> vieAllMovie() {
		try {
			return movieService.viewAllMovie();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	//get movie by id
	@GetMapping("/movieById/{movie_id}")
	public ResponseEntity<Movie> getMovieById(@PathVariable int movie_id) {
		Movie movie = movieService.getMovieById(movie_id);
		return ResponseEntity.ok(movie);
	}
	
	//add movie
	@PostMapping(value = "/addMovie")
	public Movie addMovie(@RequestBody Movie movie) {
		try {
			Movie movieAddResult =  movieService.addNewMovie(movie);
			if(movieAddResult != null) {
				return movieAddResult;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	//update movie
	@PutMapping(value = "/updateMovie")
	public Movie updateMovie(@RequestBody Movie movie) {
		try {
			Movie movieUpdateResult =  movieService.updateMovieById(movie);
			if(movieUpdateResult != null) {
				return movieUpdateResult;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	//delete Movie
	@DeleteMapping("/deleteMovieById/{movie_id}")
	public boolean deleteMovieById(@PathVariable int movie_id) {
		try {
			if(movieService.deleteMovieById(movie_id)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	//get all movie by Search Keyword
	@GetMapping(value = "/searchMovie/{serachKeyword}")
	public List<Movie> serchMovieByKeyword(@PathVariable String serachKeyword) {
		try {
			return movieService.searchMovieByKeyword(serachKeyword);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	//get all movie by action
	@GetMapping(value = "/searchMovieByAction/{movieActionType}")
	public List<Movie> searchMovieByAction(@PathVariable String movieActionType) {
		try {
			return movieService.searchMovieByAction(movieActionType);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
