package com.Business.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "TransactionData")
public class TransactionData {
	
	@Id
	@Column(name = "transaction_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int transactionId;
	
	@JoinColumn(name = "property_id")
	@ManyToOne
	private Property property;
	
	@Column(name = "transactionType")
	private String transactionType;
	
	@Column(name = "quantity")
	private int quantity;
	
	@Column(name = "pricePerUnit")
	private String pricePerUnit;
	
	@Column(name = "date")
	private String date;
	
	@JoinColumn(name = "customer_id")
	@ManyToOne
	private Customer customer;
	
	@Column(name = "generated_transactionid")
	private String transactionIdfromFE;
	
	
	@Column(name = "remarks")
	private String remarks;
	
	@Column(name = "currentBuyPrice")
	private String currentBuyPrice;

	public int getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(String pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}



	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}


	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getCurrentBuyPrice() {
		return currentBuyPrice;
	}

	public void setCurrentBuyPrice(String currentBuyPrice) {
		this.currentBuyPrice = currentBuyPrice;
	}

	public String getTransactionIdfromFE() {
		return transactionIdfromFE;
	}

	public void setTransactionIdfromFE(String transactionIdfromFE) {
		this.transactionIdfromFE = transactionIdfromFE;
	}

	@Override
	public String toString() {
		return "TransactionData [transactionId=" + transactionId + ", property=" + property + ", transactionType="
				+ transactionType + ", quantity=" + quantity + ", pricePerUnit=" + pricePerUnit + ", date=" + date
				+ ", customer=" + customer + ", transactionIdfromFE=" + transactionIdfromFE + ", remarks=" + remarks
				+ ", currentBuyPrice=" + currentBuyPrice + "]";
	}


	
	
	
	
	
	

}
