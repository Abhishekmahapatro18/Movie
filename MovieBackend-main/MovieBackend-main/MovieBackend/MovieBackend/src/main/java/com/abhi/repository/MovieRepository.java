package com.abhi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abhi.model.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
	
	@Query("SELECT m FROM Movie m WHERE ((m.movieName LIKE %?1%) OR (m.movieDescription LIKE %?1%))")
	public List<Movie> searchMovieByKeyWord(String serachMovieKeyword);
	
	@Query("SELECT m FROM Movie m WHERE (m.movieActionType LIKE %?1%)")
	public List<Movie> searchMovieByAction(String serachMovieByAction);
}
