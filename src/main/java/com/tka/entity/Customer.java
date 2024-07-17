package com.tka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Customer {
	@Id
	@Column(name="Customer_Id")
	private int cust_Id;
	@Column(name="Customer_Name")
	private String cust_Name;
	@Column(name="Address")
	private String address;
	
	public Customer() {
		super();
	}

	public Customer(int cust_Id, String cust_Name, String address) {
		super();
		this.cust_Id = cust_Id;
		this.cust_Name = cust_Name;
		this.address = address;
	}

	public int getCust_Id() {
		return cust_Id;
	}

	public void setCust_Id(int cust_Id) {
		this.cust_Id = cust_Id;
	}

	public String getCust_Name() {
		return cust_Name;
	}

	public void setCust_Name(String cust_Name) {
		this.cust_Name = cust_Name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
