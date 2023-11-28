package com.abhi.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.model.Customer;
import com.abhi.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/customer/")  //http://localhost:9093/api/customer/
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@PostMapping(value = "/addCustomer")
	public boolean addCustomer(@RequestBody Customer customer) {
		try {
			if(customerService.addNewCustomer(customer)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	@GetMapping(value = "/viewAll")
	public List<Customer> vieAllCustomer() {
		try {
			return customerService.viewAllCustomer();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@PostMapping(value = "/login")
	public boolean customerLogin(@RequestBody Map adminLoginCredentials) {
		try {
			String emaiId = (String) adminLoginCredentials.get("emailId");
			String password = (String) adminLoginCredentials.get("password");
			return customerService.CustomerLogin(emaiId, password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	@PutMapping(value = "/updateCustomer")
	public boolean updateCustomer(@RequestBody Customer customer) {
		try {
			if(customerService.updateCustomer(customer)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	@DeleteMapping(value = "/deleteCustomer/{customerEmailId}")
	public boolean deleteCustomer(@PathVariable String customerEmailId) {
		try {
			if(customerService.deleteCustomer(customerEmailId)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	@GetMapping(value = "/viewAllBy/{searchKeyword}")
	public List<Customer> vieAllCustomerBySearchKeyword(@PathVariable String searchKeyword) {
		try {
			return customerService.viewSearchKeywordCustomer(searchKeyword);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@GetMapping(value = "/viewBy/{emailId}")
	public Optional<Customer> viewCustomerByEmailId(@PathVariable String emailId) {
		try {
			return customerService.searchCustomerByEmail(emailId);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@PutMapping(value = "/updatePassword")
	public boolean updateCustomerPassword(@RequestBody Map adminUpdatePassword) {
		try {
			String emaiId = (String) adminUpdatePassword.get("emailId");
			String password = (String) adminUpdatePassword.get("password");
			System.out.println(emaiId + "  "+password);
			return customerService.updateCustomerPassword(emaiId, password);
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
