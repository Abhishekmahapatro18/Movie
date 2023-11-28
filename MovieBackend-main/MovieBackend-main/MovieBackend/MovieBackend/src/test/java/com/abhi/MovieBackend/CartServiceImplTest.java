package com.abhi.MovieBackend;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.abhi.model.Cart;
import com.abhi.model.Movie;
import com.abhi.repository.CartRepository;
import com.abhi.service.CartServiceImpl;

public class CartServiceImplTest {

    @Mock
    private CartRepository cartRepository;

    @InjectMocks
    private CartServiceImpl cartService;

    @Mock
    private HttpSession session;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddMoviesToCart_NewCart_Success() {
        // Arrange
        Movie movie = new Movie();
        movie.setMovieId(1);
        movie.setMovieTicketPrice(10.0f);
        Cart cart = new Cart();
        cart.setMovie(movie);

        when(cartRepository.findAll()).thenReturn(new ArrayList<>());
        when(session.getAttribute("totalCartAmount")).thenReturn(null);
        when(cartRepository.save(any())).thenReturn(cart);

        // Act
        Cart result = cartService.addMoviesToCart(cart, session);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.getQuantity());
        assertEquals(10.0f, result.getPrice());
    }

    @Test
    public void testPlusOneCartItem_Success() {
        // Arrange
        Cart cart = new Cart();
        cart.setQuantity(2);
        Movie movie = new Movie();
        movie.setMovieTicketPrice(15.0f);
        cart.setMovie(movie);

        when(cartRepository.save(any())).thenReturn(cart);

        // Act
        boolean result = cartService.plusOneCartItem(cart);

        // Assert
        assertTrue(result);
        assertEquals(3, cart.getQuantity());
        assertEquals(45.0f, cart.getPrice());
    }

    @Test
    public void testMinusOneCartItem_Success() {
        // Arrange
        Cart cart = new Cart();
        cart.setQuantity(3);
        Movie movie = new Movie();
        movie.setMovieTicketPrice(10.0f);
        cart.setMovie(movie);

        when(cartRepository.save(any())).thenReturn(cart);

        // Act
        boolean result = cartService.minusOneCartItem(cart);

        // Assert
        assertTrue(result);
        assertEquals(2, cart.getQuantity());
        assertEquals(20.0f, cart.getPrice());
    }

    @Test
    public void testDeleteCart_Success() {
        // Arrange
        Long cartId = 1L;

        // Act
        doNothing().when(cartRepository).deleteById(cartId);
        boolean result = cartService.deleteCart(cartId);

        // Assert
        assertTrue(result);
    }
}

