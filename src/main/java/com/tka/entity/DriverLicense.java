package com.tka.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class DriverLicense {
	@Id
	@Column(name="LicenseId")
	private int licenseId;
	
	@Column(name="LicenseNumber")
	private String licenseNumber;
	
	@Column(name="IssueDate")
	private Date issueDate;
	
	@Column(name="ExpiryDate")
	private Date expiryDate;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="id",referencedColumnName = "ID")
	private Driver driver;

	public int getLicenseId() {
		return licenseId;
	}

	public void setLicenseId(int licenseId) {
		this.licenseId = licenseId;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public Driver getDriver() {
		return driver;
	}

	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	public DriverLicense() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getLicanceId() {
		return licenseId;
	}

	public void setLicanceId(int licanceId) {
		this.licenseId = licanceId;
	}

	public String getLicanceNumber() {
		return licenseNumber;
	}

	public void setLicanceNumber(String licanceNumber) {
		this.licenseNumber = licanceNumber;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

//	public Driver getDriver() {
//		return driver;
//	}
//
//	public void setDriver(Driver driver) {
//		this.driver = driver;
//	}

	public DriverLicense(int licanceId, String licanceNumber, Date issueDate, Date expiryDate) {
		super();
		this.licenseId = licanceId;
		this.licenseNumber = licanceNumber;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
	}

	
	
}
