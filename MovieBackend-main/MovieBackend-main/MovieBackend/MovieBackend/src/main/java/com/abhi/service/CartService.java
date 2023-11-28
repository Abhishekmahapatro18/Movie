package com.abhi.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import com.abhi.model.Cart;

public interface CartService {
	//add product to cart
	public Cart addMoviesToCart(Cart cart, HttpSession session);
	
	//get all cart
	public List<Cart> getAllCartItems();
	
	//plus in cart 
	public boolean plusOneCartItem(Cart cart);
	
	//minus in cart 
	public boolean minusOneCartItem(Cart cart);
	
	//delete one Cart
	public boolean deleteCart(Long cartId);
}
