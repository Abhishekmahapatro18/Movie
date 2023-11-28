package com.abhi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
public class Cart {
	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private float price;

	@OneToOne
	private Movie movie;

	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cart(long id, int quantity, float price, Movie movie) {
		super();
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.movie = movie;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

}
