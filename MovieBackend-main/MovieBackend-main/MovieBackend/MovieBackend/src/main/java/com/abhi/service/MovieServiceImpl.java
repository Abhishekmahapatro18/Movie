package com.abhi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.exception.ResourceNotFoundException;
import com.abhi.model.Admin;
import com.abhi.model.Movie;
import com.abhi.repository.MovieRepository;

@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieRepository movieRepository;

	@Override
	public Movie addNewMovie(Movie movie) {
		try {
			Movie movieAddResult = movieRepository.save(movie);
			if (movieAddResult != null) {
				return movieAddResult;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Movie> viewAllMovie() {
		try {
			return movieRepository.findAll();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Movie getMovieById(int movieId) {
		try {
			Movie movie = movieRepository.findById(movieId)
					.orElseThrow(() -> new ResourceNotFoundException("Movie not exist with id :" + movieId));
			return movie;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Movie updateMovieById(Movie movie) {
		try {
			movieRepository.saveAndFlush(movie);
			return movie;
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public boolean deleteMovieById(int movieId) {
		try {
			movieRepository.deleteById(movieId);
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public List<Movie> searchMovieByKeyword(String serachMovieKeyword) {
		try {
			return movieRepository.searchMovieByKeyWord(serachMovieKeyword);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Movie> searchMovieByAction(String serachByMovieAction) {
		try {
			return movieRepository.searchMovieByAction(serachByMovieAction);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

}
