package com.tka.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Driver {
	@Id
	@Column(name="Id")
	private int id;
	
	@Column(name="Name")
	private String name;
	
	@Column(name="DateOfBirth")
	private Date dateOfBirth;
	
	@Column(name="Contact")
	private	String contact;
	
	@Column(name="Address")
	private	String address;
	
	@OneToOne(mappedBy = "driver" ,cascade = CascadeType.ALL)
	@JoinColumn(name="licenseId",referencedColumnName = "LicenseId")
	private DriverLicense driverLicense;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public DriverLicense getDriverLicense() {
		return driverLicense;
	}

	public void setDriverLicense(DriverLicense driverLicense) {
		this.driverLicense = driverLicense;
	}

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Driver(int id, String name, Date dateOfBirth, String contact, String address, DriverLicense driverLicense) {
		super();
		this.id = id;
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.contact = contact;
		this.address = address;
		this.driverLicense = driverLicense;
	}

	
}
