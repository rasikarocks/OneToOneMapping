package com.tka.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class CustomerOrders {
	@Id
	@Column(name="ID")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Temporal(TemporalType.DATE)
	@Column(name="Order_Date")
	private Date orderDate;
	
	@Column(name="OrderItem")
	private String orderItem;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cust_Id", nullable = false)
	private Customer customer;

	public CustomerOrders() {
		super();
	}


	public CustomerOrders(Date orderDate, String orderItem, Customer customer) {
		super();
		this.orderDate = orderDate;
		this.orderItem = orderItem;
		this.customer = customer;
	}


	public CustomerOrders(int id, Date orderDate, String orderItem, Customer customer) {
		super();
		this.id = id;
		this.orderDate = orderDate;
		this.orderItem = orderItem;
		this.customer = customer;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getOrderItem() {
		return orderItem;
	}

	public void setOrderItem(String orderItem) {
		this.orderItem = orderItem;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
}
