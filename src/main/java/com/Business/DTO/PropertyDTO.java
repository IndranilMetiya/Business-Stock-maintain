package com.Business.DTO;

public class PropertyDTO {
	
	private String propertyName; 
	private String unitType;
	private String categoryName;
	private String subCategoryName;
	private String productType;
	private String height;
	private String width;
	private String weight;
	private String remarks;
	public String getPropertyName() {
		return propertyName;
	}
	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getUnitType() {
		return unitType;
	}
	public void setUnitType(String unitType) {
		this.unitType = unitType;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getSubCategoryName() {
		return subCategoryName;
	}
	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getWidth() {
		return width;
	}
	public void setWidth(String width) {
		this.width = width;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "PropertyDTO [propertyName=" + propertyName + ", unitType=" + unitType + ", categoryName=" + categoryName
				+ ", subCategoryName=" + subCategoryName + ", productType=" + productType + ", height=" + height
				+ ", width=" + width + ", weight=" + weight + ", remarks=" + remarks + "]";
	}
	
	
	
	
	

}
