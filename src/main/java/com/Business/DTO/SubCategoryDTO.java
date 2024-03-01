package com.Business.DTO;

public class SubCategoryDTO {
	
	private String catagoryName;
	private String subCatagoryName;
	
	public String getCatagoryName() {
		return catagoryName;
	}
	public void setCatagoryName(String catagoryName) {
		this.catagoryName = catagoryName;
	}
	public String getSubCatagoryName() {
		return subCatagoryName;
	}
	public void setSubCatagoryName(String subCatagoryName) {
		this.subCatagoryName = subCatagoryName;
	}
	@Override
	public String toString() {
		return "SubCategoryDTO [catagoryName=" + catagoryName + ", subCatagoryName=" + subCatagoryName + "]";
	}
	
	
	

}
