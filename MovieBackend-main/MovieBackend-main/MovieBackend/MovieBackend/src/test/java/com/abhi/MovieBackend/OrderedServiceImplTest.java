package com.abhi.MovieBackend;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.abhi.model.Cart;
import com.abhi.model.Ordered;
import com.abhi.repository.CartRepository;
import com.abhi.repository.OrderedRepository;
import com.abhi.service.OrderedServiceImpl;

public class OrderedServiceImplTest {

    @Mock
    private CartRepository cartRepository;

    @Mock
    private OrderedRepository orderedRepository;

    @InjectMocks
    private OrderedServiceImpl orderedService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateOrdered_Success() {
        // Arrange
        String emailId = "customer@example.com";
        List<Cart> cartList = new ArrayList<>();
        cartList.add(new Cart());

        when(cartRepository.findAll()).thenReturn(cartList);
        when(orderedRepository.save(any())).thenReturn(new Ordered());

        // Act
        boolean result = orderedService.createOrdered(emailId);

        // Assert
        assertTrue(result);
        verify(cartRepository, times(1)).deleteAll();
    }

    @Test
    public void testGetCustomerOrdered_Success() {
        // Arrange
        String emailId = "customer@example.com";
        List<Ordered> orderedList = new ArrayList<>();
        when(orderedRepository.searchByEmail(emailId)).thenReturn(orderedList);

        // Act
        List<Ordered> result = orderedService.getCustomerOrdered(emailId);

        // Assert
        assertEquals(orderedList, result);
    }

    @Test
    public void testGetAllOrdered_Success() {
        // Arrange
        List<Ordered> orderedList = new ArrayList<>();
        when(orderedRepository.findAll()).thenReturn(orderedList);

        // Act
        List<Ordered> result = orderedService.getAllOrdered();

        // Assert
        assertEquals(orderedList, result);
    }

    @Test
    public void testCreateOrdered_NoCartItems_Success() {
        // Arrange
        String emailId = "customer@example.com";
        List<Cart> emptyCartList = new ArrayList<>();

        when(cartRepository.findAll()).thenReturn(emptyCartList);

        // Act
        boolean result = orderedService.createOrdered(emailId);

        // Assert
        assertTrue(result); // Expecting true because no cart items are present
        verify(cartRepository).deleteAll(); // Verify that cartRepository.deleteAll() is called
    }

    @Test
    public void testCreateOrdered_ExceptionThrown_Failure() {
        // Arrange
        String emailId = "customer@example.com";

        when(cartRepository.findAll()).thenThrow(new RuntimeException());

        // Act
        boolean result = orderedService.createOrdered(emailId);

        // Assert
        assertFalse(result);
        verify(cartRepository, never()).deleteAll();
    }

    @Test
    public void testGetCustomerOrdered_EmptyList_Success() {
        // Arrange
        String emailId = "customer@example.com";
        List<Ordered> emptyOrderedList = new ArrayList<>();

        when(orderedRepository.searchByEmail(emailId)).thenReturn(emptyOrderedList);

        // Act
        List<Ordered> result = orderedService.getCustomerOrdered(emailId);

        // Assert
        assertNotNull(result);
        assertEquals(emptyOrderedList, result);
    }

    @Test
    public void testGetAllOrdered_EmptyList_Success() {
        // Arrange
        List<Ordered> emptyOrderedList = new ArrayList<>();

        when(orderedRepository.findAll()).thenReturn(emptyOrderedList);

        // Act
        List<Ordered> result = orderedService.getAllOrdered();

        // Assert
        assertNotNull(result);
        assertEquals(emptyOrderedList, result);
    }

    // You can continue adding more test methods to cover different scenarios

}

