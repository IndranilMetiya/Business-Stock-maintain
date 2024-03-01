package com.Business.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "priceTracker")
public class PriceTracker {
	
	@Id
	@Column(name = "priceTracker_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int priceTrackerId;
	
	@JoinColumn(name = "property_id")
	@OneToOne
	private Property property;
	
	@Column(name = "currentSellingPrice")
	private String currentSellingPrice;
	
	@Column(name = "currentBuyingPrice")
	private String currentBuyingPrice;
	
	@Column(name = "date")
	private String date;

	public int getPriceTrackerId() {
		return priceTrackerId;
	}

	public void setPriceTrackerId(int priceTrackerId) {
		this.priceTrackerId = priceTrackerId;
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	public String getCurrentSellingPrice() {
		return currentSellingPrice;
	}

	public void setCurrentSellingPrice(String currentSellingPrice) {
		this.currentSellingPrice = currentSellingPrice;
	}

	public String getCurrentBuyingPrice() {
		return currentBuyingPrice;
	}

	public void setCurrentBuyingPrice(String currentBuyingPrice) {
		this.currentBuyingPrice = currentBuyingPrice;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return "PriceTracker [priceTrackerId=" + priceTrackerId + ", property=" + property + ", currentSellingPrice="
				+ currentSellingPrice + ", currentBuyingPrice=" + currentBuyingPrice + ", date=" + date + "]";
	}
	
	

}
