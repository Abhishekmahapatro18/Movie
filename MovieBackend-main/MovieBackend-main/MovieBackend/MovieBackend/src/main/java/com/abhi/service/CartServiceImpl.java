package com.abhi.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.model.Cart;
import com.abhi.repository.CartRepository;

@Service
public class CartServiceImpl implements CartService {
	@Autowired
	CartRepository cartRepository;

	@Override
	public Cart addMoviesToCart(Cart cart, HttpSession session) {
		try {
			float totalCartAmount = 0;
			if (session.getAttribute("totalCartAmount") == null) {
				totalCartAmount = 0;
			} else {
				totalCartAmount = (float) session.getAttribute("totalCartAmount");
			}
			List<Cart> cartList = cartRepository.findAll();
			for (Cart tempCart : cartList) {
				if (tempCart.getMovie().getMovieId() == cart.getMovie().getMovieId()) {
					int tempCartQuantity = 1 + tempCart.getQuantity();
					totalCartAmount = totalCartAmount + tempCart.getPrice();
					session.setAttribute("totalCartAmount", totalCartAmount);
					tempCart.setQuantity(tempCartQuantity);
					tempCart.setPrice((tempCart.getMovie().getMovieTicketPrice() * tempCartQuantity));
					return cartRepository.save(tempCart);
				}
			}
			int min = 222;
			int max = 999;
			int ramdonNum = (int) (Math.random() * (max - min + 1) + min);
			cart.setId(ramdonNum);
			cart.setQuantity(1);
			cart.setPrice(cart.getMovie().getMovieTicketPrice());
			totalCartAmount = totalCartAmount + cart.getMovie().getMovieTicketPrice();
			session.setAttribute("totalCartAmount", totalCartAmount);
			return cartRepository.save(cart);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public List<Cart> getAllCartItems() {
		try {
			return cartRepository.findAll();
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}

	@Override
	public boolean plusOneCartItem(Cart cart) {
		try {
			int cartCurrentQunatity = cart.getQuantity();
			int quant = cartCurrentQunatity + 1;
			cart.setQuantity(quant);
			cart.setPrice(quant * cart.getMovie().getMovieTicketPrice());
			cartRepository.save(cart);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean minusOneCartItem(Cart cart) {
		try {
			int cartCurrentQunatity = cart.getQuantity();
			cart.setQuantity(cartCurrentQunatity - 1);
			cart.setPrice((cartCurrentQunatity-1) * cart.getMovie().getMovieTicketPrice());
			cartRepository.save(cart);
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

	@Override
	public boolean deleteCart(Long cartId) {
		try {
			cartRepository.deleteById(cartId);
			return true;
		} catch (Exception e) {
			System.out.println(e);
		}
		return false;
	}

}
