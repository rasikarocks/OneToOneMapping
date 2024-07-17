package com.tka.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Membership {
	@Id
	@Column(name="MembershipId")
	private int membershipId;
	
	@Column(name="MembershipType")
	private String mambershipType;
	
	@Column(name="StartDate")
	private Date startDate;
	
	@Column(name="EndDate")
	private	Date  endData;
	
	 @OneToOne(cascade = CascadeType.ALL)
	 @JoinColumn(name="id", referencedColumnName = "ID")
	private Members members ;

	public int getMembershipId() {
		return membershipId;
	}

	public void setMembershipId(int membershipId) {
		this.membershipId = membershipId;
	}

	public String getMambershipType() {
		return mambershipType;
	}

	public void setMambershipType(String mambershipType) {
		this.mambershipType = mambershipType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndData() {
		return endData;
	}

	public void setEndData(Date endData) {
		this.endData = endData;
	}

	public Members getMembers() {
		return members;
	}

	public void setMembers(Members members) {
		this.members = members;
	}

	public Membership() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Membership(int membershipId, String mambershipType, Date startDate, Date endData, Members members) {
		super();
		this.membershipId = membershipId;
		this.mambershipType = mambershipType;
		this.startDate = startDate;
		this.endData = endData;
		this.members = members;
	}

	public Membership(String mambershipType, Date startDate, Date endData, Members members) {
		super();
		this.mambershipType = mambershipType;
		this.startDate = startDate;
		this.endData = endData;
		this.members = members;
	}

	public Membership(int membershipId, String mambershipType, Date startDate, Date endData) {
		super();
		this.membershipId = membershipId;
		this.mambershipType = mambershipType;
		this.startDate = startDate;
		this.endData = endData;
	}

	public Membership(String mambershipType, Date startDate, Date endData) {
		super();
		this.mambershipType = mambershipType;
		this.startDate = startDate;
		this.endData = endData;
	}
	
	 
	 
}
