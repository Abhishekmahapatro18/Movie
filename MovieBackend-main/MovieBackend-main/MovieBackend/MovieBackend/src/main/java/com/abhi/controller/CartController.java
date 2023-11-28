package com.abhi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.model.Cart;
import com.abhi.service.CartService;

@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
@RestController
@RequestMapping("/api/cart/") // http://localhost:9093/api/cart/
public class CartController {
	@Autowired
	CartService cartService;
	
	@PostMapping("/addToCart")
	public Cart addToCart(@RequestBody Cart cart, HttpSession session) {
		try {
			return cartService.addMoviesToCart(cart, session);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@GetMapping("/viewAllCarts")
	public List<Cart> getCartItems() {
		try {
			return cartService.getAllCartItems();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	
	@PutMapping("/addInCart")
	public boolean addInCart(@RequestBody Cart cart){
		try {
			if(cartService.plusOneCartItem(cart)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	@PutMapping("/minusInCart")
	public boolean minusInCart(@RequestBody Cart cart){
		try {
			if(cartService.minusOneCartItem(cart)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
	
	@DeleteMapping("/deleteCart/{cId}")
	public boolean deleteCart(@PathVariable("cId") Long cId)
	{
		try {
			if(cartService.deleteCart(cId)) {
				return true;
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}
}
