package com.abhi.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ordered")
public class Ordered {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "oid")
	private long oid;

	@Column(name = "quantity")
	private int quantity;

	@Column(name = "price")
	private float price;

	@Column(name = "email_id")
	private String emailId;
	
	@Column(name = "currdate")
	private Date currDate;
	
	@Column(name = "transaction_id")
	private int transactionId;

	public Ordered() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ordered(int quantity, float price, String emailId, Date currDate, int transactionId) {
		super();
		this.quantity = quantity;
		this.price = price;
		this.emailId = emailId;
		this.currDate = currDate;
		this.transactionId = transactionId;
	}

	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Date getCurrentDate() {
		return currDate;
	}

	public void setCurrentDate(Date currDate) {
		this.currDate = currDate;
	}

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
}
