package com.abhi.service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.model.Admin;
import com.abhi.model.Cart;
import com.abhi.model.Ordered;
import com.abhi.repository.CartRepository;
import com.abhi.repository.OrderedRepository;

@Service
public class OrderedServiceImpl implements OrderedService{

	@Autowired
	CartRepository cartRepository;
	
	@Autowired 
	OrderedRepository orderedRepository;
	
	@Override
	public boolean createOrdered(String emailId) {
		try {
			List<Cart> allCart = cartRepository.findAll();
			int totalQunatity = 0;
			float totalPrice = 0;
			for (Cart cartData : allCart) {
				totalPrice += cartData.getPrice();
				totalQunatity += cartData.getQuantity();
			}
			java.sql.Date currentDate = new java.sql.Date(new java.util.Date().getTime());
			int randomWithMathRandom = (int) ((Math.random() * (9999 - 2222)) + 2222);
			Ordered ordered = new Ordered(totalQunatity, totalPrice, emailId, currentDate, randomWithMathRandom);
			orderedRepository.save(ordered);
			cartRepository.deleteAll();
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public List<Ordered> getCustomerOrdered(String emailId) {
		try {
			return orderedRepository.searchByEmail(emailId);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}

	@Override
	public List<Ordered> getAllOrdered() {
		try {
			return orderedRepository.findAll();
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
}
