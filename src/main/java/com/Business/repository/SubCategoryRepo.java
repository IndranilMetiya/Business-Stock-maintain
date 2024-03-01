package com.Business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Business.entity.Category;
import com.Business.entity.SubCategory;

@Repository
public interface SubCategoryRepo extends JpaRepository<SubCategory, Integer> {

	 SubCategory findBySubCatagoryName(String subCatagoryName) ;

	List<SubCategory> findByCategory(Category category);
		

}
