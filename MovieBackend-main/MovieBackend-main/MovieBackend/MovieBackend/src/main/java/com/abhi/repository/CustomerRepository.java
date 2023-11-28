package com.abhi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abhi.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, String>{
	@Query("SELECT c FROM Customer c WHERE ((c.fullName LIKE %?1%) OR (c.emailId LIKE %?1%) OR (c.phoneNumber LIKE %?1%))") 
	public List<Customer> searchCustomerByKeyword(String searchKeyword);
	
	@Query("SELECT c FROM Customer c WHERE (c.fullName LIKE %?1%)")
	public Customer  findByEmail(String emailId);
}
