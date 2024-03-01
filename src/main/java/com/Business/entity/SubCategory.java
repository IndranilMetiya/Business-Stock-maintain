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
@Table(name = "subCatagory")
public class SubCategory {
	
	@Id
	@Column(name = "subCatagory_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int subCatagoryId;
	
	@Column(name = "subCatagory_name")
	private String subCatagoryName;
	
	@JoinColumn(name = "category_id")
	@ManyToOne
	private Category category;

	public int getSubCatagoryId() {
		return subCatagoryId;
	}

	public void setSubCatagoryId(int subCatagoryId) {
		this.subCatagoryId = subCatagoryId;
	}

	public String getSubCatagoryName() {
		return subCatagoryName;
	}

	public void setSubCatagoryName(String subCatagoryName) {
		this.subCatagoryName = subCatagoryName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "SubCategory [subCatagoryId=" + subCatagoryId + ", subCatagoryName=" + subCatagoryName + ", category="
				+ category + "]";
	}
	
	

}
