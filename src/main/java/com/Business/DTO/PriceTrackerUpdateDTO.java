package com.Business.DTO;

public class PriceTrackerUpdateDTO {
	
	private int priceTrackerId;
	private String currentSellingPrice;
	private String currentBuyingPrice;
	private String date;
	private String propertyName;
	
	public int getPriceTrackerId() {
		return priceTrackerId;
	}
	public void setPriceTrackerId(int priceTrackerId) {
		this.priceTrackerId = priceTrackerId;
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
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	@Override
	public String toString() {
		return "PriceTrackerUpdateDTO [priceTrackerId=" + priceTrackerId + ", currentSellingPrice="
				+ currentSellingPrice + ", currentBuyingPrice=" + currentBuyingPrice + ", date=" + date
				+ ", propertyName=" + propertyName + "]";
	}
	
	

}
