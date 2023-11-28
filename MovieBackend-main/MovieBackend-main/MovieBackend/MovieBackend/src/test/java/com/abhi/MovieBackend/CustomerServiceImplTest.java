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

import com.abhi.model.Customer;
import com.abhi.repository.CustomerRepository;
import com.abhi.service.CustomerServiceImpl;

public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddNewCustomer_Success() {
        // Arrange
        Customer customer = new Customer();
        when(customerRepository.save(any())).thenReturn(customer);

        // Act
        boolean result = customerService.addNewCustomer(customer);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testCustomerLogin_ValidCredentials_ReturnsTrue() {
        // Arrange
        String emailId = "customer@example.com";
        String password = "customer123";

        Customer customer = new Customer();
        customer.setEmailId(emailId);
        customer.setPassword(password);
        List<Customer> customerList = new ArrayList<>();
        customerList.add(customer);

        when(customerRepository.findAll()).thenReturn(customerList);

        // Act
        boolean result = customerService.CustomerLogin(emailId, password);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testUpdateCustomer_Success() {
        // Arrange
        Customer customer = new Customer();
        when(customerRepository.saveAndFlush(any())).thenReturn(customer);

        // Act
        boolean result = customerService.updateCustomer(customer);

        // Assert
        assertTrue(result);
    }

    @Test
    public void testDeleteCustomer_Success() {
        // Arrange
        String emailId = "customer@example.com";
        
        // Act
        doNothing().when(customerRepository).deleteById(emailId);
        boolean result = customerService.deleteCustomer(emailId);
        
        // Assert
        assertTrue(result);
    }

    @Test
    public void testViewAllCustomer_Success() {
        // Arrange
        List<Customer> customerList = new ArrayList<>();
        when(customerRepository.findAll()).thenReturn(customerList);
        
        // Act
        List<Customer> result = customerService.viewAllCustomer();
        
        // Assert
        assertEquals(customerList, result);
    }

    @Test
    public void testViewSearchKeywordCustomer_Success() {
        // Arrange
        String searchKeyword = "example";
        List<Customer> customerList = new ArrayList<>();
        when(customerRepository.searchCustomerByKeyword(searchKeyword)).thenReturn(customerList);
        
        // Act
        List<Customer> result = customerService.viewSearchKeywordCustomer(searchKeyword);
        
        // Assert
        assertEquals(customerList, result);
    }

    @Test
    public void testSearchCustomerByEmail_Success() {
        // Arrange
        String emailId = "customer@example.com";
        Optional<Customer> customer = Optional.of(new Customer());
        when(customerRepository.findById(emailId)).thenReturn(customer);
        
        // Act
        Optional<Customer> result = customerService.searchCustomerByEmail(emailId);
        
        // Assert
        assertEquals(customer, result);
    }

}

