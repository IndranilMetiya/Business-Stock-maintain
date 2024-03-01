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
@Table(name = "property")
public class Property {
	
	@Id
	@Column(name = "property_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int propertyId;
	
	@Column(name = "property_name")
	private String propertyName;     //will be generate by FE
	
	@Column(name = "unitType")
	private String unitType;
	
	@Column(name = "categoryName")
	private String categoryName;
	
	@JoinColumn(name = "subcatagory_id")
	@ManyToOne
	private SubCategory subCategory;
	
	@Column(name = "productType")   //beam
	private String productType;
	
	@Column(name = "height")
	private String height;
	
	@Column(name = "width")
	private String width;
	
	@Column(name = "weight")
	private String weight;
	
	@Column(name = "remarks")
	private String remarks;

	public int getPropertyId() {
		return propertyId;
	}

	public void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
	}

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

	public SubCategory getSubCategory() {
		return subCategory;
	}

	public void setSubCategory(SubCategory subCategory) {
		this.subCategory = subCategory;
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

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Property [propertyId=" + propertyId + ", propertyName=" + propertyName + ", unitType=" + unitType
				+ ", categoryName=" + categoryName + ", subCategory=" + subCategory + ", productType=" + productType
				+ ", height=" + height + ", width=" + width + ", weight=" + weight + ", remarks=" + remarks + "]";
	}
	
	
	
	

}
