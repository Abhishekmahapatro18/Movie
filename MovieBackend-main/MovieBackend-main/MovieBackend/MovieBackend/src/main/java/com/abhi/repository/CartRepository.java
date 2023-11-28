package com.abhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.model.Cart;


public interface CartRepository extends JpaRepository<Cart, Long>{

}
