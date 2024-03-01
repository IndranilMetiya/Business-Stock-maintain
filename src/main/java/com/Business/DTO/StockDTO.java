package com.Business.DTO;

public class StockDTO {
	
	private String propertyName;
	private int qantityAal;
	private int stockId;
	
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public int getQantityAal() {
		return qantityAal;
	}
	public void setQantityAal(int qantityAal) {
		this.qantityAal = qantityAal;
	}
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	@Override
	public String toString() {
		return "StockDTO [propertyName=" + propertyName + ", qantityAal=" + qantityAal + ", stockId=" + stockId + "]";
	}
	
	

}
