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

import com.abhi.model.Admin;
import com.abhi.repository.AdminRepository;
import com.abhi.service.AdminServiceImpl;

public class AdminServiceImplTest {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminServiceImpl adminService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAdminLogin_ValidCredentials_ReturnsTrue() {
        // Arrange
        String emailId = "admin@example.com";
        String password = "admin123";
        
        Admin admin = new Admin();
        admin.setEmailId(emailId);
        admin.setPassword(password);
        
        List<Admin> adminList = new ArrayList<>();
        adminList.add(admin);
        
        when(adminRepository.findAll()).thenReturn(adminList);

        // Act
        boolean result = adminService.AdminLogin(emailId, password);

        // Assert
        assertTrue(result);
        verify(adminRepository, times(1)).findAll();
    }

    @Test
    public void testAdminLogin_InvalidCredentials_ReturnsFalse() {
        // Arrange
        String emailId = "admin@example.com";
        String password = "admin123";
        
        Admin admin = new Admin();
        admin.setEmailId("another@example.com");
        admin.setPassword("wrongpass");
        
        List<Admin> adminList = new ArrayList<>();
        adminList.add(admin);
        
        when(adminRepository.findAll()).thenReturn(adminList);

        // Act
        boolean result = adminService.AdminLogin(emailId, password);

        // Assert
        assertFalse(result);
        verify(adminRepository, times(1)).findAll();
    }
}

