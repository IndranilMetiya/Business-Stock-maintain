package com.Business.DTO;

public class CategoryDTO {
	
	private String categoryName;
	private String remarks;
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	@Override
	public String toString() {
		return "CategoryDTO [categoryName=" + categoryName + ", remarks=" + remarks + "]";
	}
	public CategoryDTO(String categoryName, String remarks) {
		super();
		this.categoryName = categoryName;
		this.remarks = remarks;
	}
	public CategoryDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

}
