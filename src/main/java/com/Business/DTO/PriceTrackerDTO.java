package com.Business.DTO;

public class PriceTrackerDTO {
	
	private String propertyName;
	private String currentSellingPrice;
	private String currentBuyingPrice;
	private String date;
	
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
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
		return "PriceTrackerDTO [propertyName=" + propertyName + ", currentSellingPrice=" + currentSellingPrice
				+ ", currentBuyingPrice=" + currentBuyingPrice + ", date=" + date + "]";
	}
	
	

}
