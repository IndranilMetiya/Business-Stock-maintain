package com.Business.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customerData")
public class Customer {
	
	@Id
	@Column(name = "customer_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int customeId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phoneNumber")
	private String phNo;
	
	@Column(name = "address")
	private String address;



	public int getCustomeId() {
		return customeId;
	}

	public void setCustomeId(int customeId) {
		this.customeId = customeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhNo() {
		return phNo;
	}

	public void setPhNo(String phNo) {
		this.phNo = phNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customeId=" + customeId + ", name=" + name + ", phNo=" + phNo + ", address=" + address + "]";
	}
	
	

}
