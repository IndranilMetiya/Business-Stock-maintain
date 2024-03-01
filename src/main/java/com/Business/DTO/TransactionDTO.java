package com.Business.DTO;

public class TransactionDTO {

	private String propertyName;
	private String transactionType;
	private int quantity;
	private String pricePerUnit;
	private String date;
	private String customerName;
	private String customerAddress;
	private String customerPhNo;
	private String transactionIdfromFE;
	private String remarks;
	private String currentBuyPriceFromFE;
	
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
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
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	public String getCustomerPhNo() {
		return customerPhNo;
	}
	public void setCustomerPhNo(String customerPhNo) {
		this.customerPhNo = customerPhNo;
	}
	public String getTransactionIdfromFE() {
		return transactionIdfromFE;
	}
	public void setTransactionIdfromFE(String transactionIdfromFE) {
		this.transactionIdfromFE = transactionIdfromFE;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getCurrentBuyPriceFromFE() {
		return currentBuyPriceFromFE;
	}
	public void setCurrentBuyPriceFromFE(String currentBuyPriceFromFE) {
		this.currentBuyPriceFromFE = currentBuyPriceFromFE;
	}
	@Override
	public String toString() {
		return "TransactionDTO [propertyName=" + propertyName + ", transactionType=" + transactionType + ", quantity="
				+ quantity + ", pricePerUnit=" + pricePerUnit + ", date=" + date + ", customerName=" + customerName
				+ ", customerAddress=" + customerAddress + ", customerPhNo=" + customerPhNo + ", transactionIdfromFE="
				+ transactionIdfromFE + ", remarks=" + remarks + ", currentBuyPriceFromFE=" + currentBuyPriceFromFE
				+ "]";
	}
	
	
	
	
}
