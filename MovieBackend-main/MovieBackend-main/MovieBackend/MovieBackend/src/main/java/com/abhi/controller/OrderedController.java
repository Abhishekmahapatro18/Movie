package com.abhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.model.Ordered;
import com.abhi.service.OrderedService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api/ordered/") // http://localhost:9093/api/ordered/
public class OrderedController {

	@Autowired
	OrderedService orderedService;
	
	@GetMapping(value = "/createOrder/{emailId}")
	public boolean AdminLogin(@PathVariable("emailId") String emailId) {
		try {
			return orderedService.createOrdered(emailId);
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	@GetMapping("/viewCustomersOrder/{emailId}")
	public List<Ordered> getCustomerOrderedItems(@PathVariable("emailId") String emailId) {
		try {
			return orderedService.getCustomerOrdered(emailId);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@GetMapping("/viewAllOrders")
	public List<Ordered> getOrderedItems() {
		try {
			return orderedService.getAllOrdered();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}
