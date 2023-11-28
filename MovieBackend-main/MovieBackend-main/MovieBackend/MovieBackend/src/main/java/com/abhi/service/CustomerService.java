package com.abhi.service;

import java.util.List;
import java.util.Optional;

import com.abhi.model.Customer;

public interface CustomerService {
	//Methods to add a new customer
	public boolean addNewCustomer(Customer customer);
	
	//Methods to login Customer
	public boolean CustomerLogin(String emailId, String password);
	
	//Method to update Customer
	public boolean updateCustomer(Customer customer);
	
	//Method to delete Customer
	public boolean deleteCustomer(String emailId);
	
	//Method to view all Customer
	public List<Customer> viewAllCustomer();
	
	//Search Customer using keyword
	public List<Customer> viewSearchKeywordCustomer(String searchKeyword);
	
	//find Customer using email
	public Optional<Customer> searchCustomerByEmail(String emailId);
	
	//update customer password
	public boolean updateCustomerPassword(String emailId, String password);	
}
