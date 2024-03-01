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
@Table(name = "priceTrackerUpdate")
public class PriceTrackerUpdate {
	
	@Id
	@Column(name = "priceTrackerUpdate_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int priceTrackerUpdateId;
		
	@Column(name = "currentSellingPrice")
	private String currentSellingPrice;
	
	@Column(name = "currentBuyingPrice")
	private String currentBuyingPrice;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "propertyName")
	private String propertyName;
	
	@JoinColumn(name = "priceTracker_id")
	@ManyToOne
	private PriceTracker priceTracker;

	public int getPriceTrackerUpdateId() {
		return priceTrackerUpdateId;
	}

	public void setPriceTrackerUpdateId(int priceTrackerUpdateId) {
		this.priceTrackerUpdateId = priceTrackerUpdateId;
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

	public PriceTracker getPriceTracker() {
		return priceTracker;
	}

	public void setPriceTracker(PriceTracker priceTracker) {
		this.priceTracker = priceTracker;
	}

	public String getPropertyName() {
		return propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	@Override
	public String toString() {
		return "PriceTrackerUpdate [priceTrackerUpdateId=" + priceTrackerUpdateId + ", currentSellingPrice="
				+ currentSellingPrice + ", currentBuyingPrice=" + currentBuyingPrice + ", date=" + date
				+ ", propertyName=" + propertyName + ", priceTracker=" + priceTracker + "]";
	}
	
	

}
