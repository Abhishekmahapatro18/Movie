package com.abhi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.model.Admin;
import com.abhi.model.Customer;
import com.abhi.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	CustomerRepository customerRepository;
	
	@Override
	public boolean addNewCustomer(Customer customer) {
		try {
			Customer customerResult = customerRepository.save(customer);
			if(customerResult != null) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	@Override
	public boolean CustomerLogin(String emailId, String password) {
		try {
			List<Customer> allCustomerData = customerRepository.findAll();

			for (Customer customerData : allCustomerData) {
				if ((customerData.getEmailId()).equals(emailId)
						&& (customerData.getPassword()).equals(password)) {
					return true;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		try {
			if(customer != null) {
				customerRepository.saveAndFlush(customer);
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(String emailId) {
		try {
			customerRepository.deleteById(emailId);
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public List<Customer> viewAllCustomer() {
		try {
			return customerRepository.findAll();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Customer> viewSearchKeywordCustomer(String searchKeyword) {
		try {
			return customerRepository.searchCustomerByKeyword(searchKeyword);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public Optional<Customer> searchCustomerByEmail(String emailId) {
		try {
			return customerRepository.findById(emailId);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public boolean updateCustomerPassword(String emailId, String password) {
		try {
			List<Customer> allCustomerData = customerRepository.findAll();

			for (Customer customerData : allCustomerData) {
				if ((customerData.getEmailId()).equals(emailId)) {
					customerData.setPassword(password);
					customerRepository.saveAndFlush(customerData);
					return true;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}
}
