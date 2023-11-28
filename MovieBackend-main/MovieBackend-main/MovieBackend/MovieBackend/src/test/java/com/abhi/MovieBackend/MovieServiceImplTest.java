package com.abhi.MovieBackend;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.abhi.model.Movie;
import com.abhi.repository.MovieRepository;
import com.abhi.service.MovieServiceImpl;

public class MovieServiceImplTest {

    @Mock
    private MovieRepository movieRepository;

    @InjectMocks
    private MovieServiceImpl movieService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddNewMovie_Success() {
        // Arrange
        Movie movie = new Movie();
        when(movieRepository.save(any())).thenReturn(movie);

        // Act
        Movie result = movieService.addNewMovie(movie);

        // Assert
        assertNotNull(result);
        assertEquals(movie, result);
    }

    @Test
    public void testViewAllMovie_Success() {
        // Arrange
        List<Movie> movieList = new ArrayList<>();
        when(movieRepository.findAll()).thenReturn(movieList);

        // Act
        List<Movie> result = movieService.viewAllMovie();

        // Assert
        assertEquals(movieList, result);
    }

    @Test
    public void testGetMovieById_Success() {
        // Arrange
        int movieId = 1;
        Movie movie = new Movie();
        when(movieRepository.findById(movieId)).thenReturn(Optional.of(movie));

        // Act
        Movie result = movieService.getMovieById(movieId);

        // Assert
        assertNotNull(result);
        assertEquals(movie, result);
    }
    
    @Test
    public void testUpdateMovieById_Success() {
        // Arrange
        Movie movie = new Movie();
        when(movieRepository.saveAndFlush(any())).thenReturn(movie);

        // Act
        Movie result = movieService.updateMovieById(movie);

        // Assert
        assertNotNull(result);
        assertEquals(movie, result);
    }

    @Test
    public void testDeleteMovieById_Success() {
        // Arrange
        int movieId = 1;

        // Act
        doNothing().when(movieRepository).deleteById(movieId);
        boolean result = movieService.deleteMovieById(movieId);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testSearchMovieByKeyword_Success() {
        // Arrange
        String searchKeyword = "example";
        List<Movie> movieList = new ArrayList<>();
        when(movieRepository.searchMovieByKeyWord(searchKeyword)).thenReturn(movieList);

        // Act
        List<Movie> result = movieService.searchMovieByKeyword(searchKeyword);

        // Assert
        assertEquals(movieList, result);
    }

    @Test
    public void testSearchMovieByAction_Success() {
        // Arrange
        String searchByMovieAction = "action";
        List<Movie> movieList = new ArrayList<>();
        when(movieRepository.searchMovieByAction(searchByMovieAction)).thenReturn(movieList);

        // Act
        List<Movie> result = movieService.searchMovieByAction(searchByMovieAction);

        // Assert
        assertEquals(movieList, result);
    }

    // You can add more test methods for different scenarios as needed

}
