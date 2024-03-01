package com.Business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.Business.entity.Property;

@Repository
public interface PropertyRepo extends JpaRepository<Property, Integer> {
	
	 @Query(value = "SELECT * FROM property p " +
	            "WHERE p.product_type = :productType " +
	            "AND p.property_name = :propertyName " +
	            "AND p.unit_type = :unitType " +
	            "AND p.subcatagory_id = :subCategoryId " +
	            "AND (:height IS NULL OR p.height = :height) " +
	            "AND (:width IS NULL OR p.width = :width) " +
	            "AND (:weight IS NULL OR p.weight = :weight)", nativeQuery = true)
	    Property findByProductTypeAndPropertyNameAndUnitTypeAndSubCategoryAndDetails(
	            @Param("productType") String productType,
	            @Param("propertyName") String propertyName,
	            @Param("unitType") String unitType,
	            @Param("subCategoryId") int subCategoryId,
	            @Param("height") String height,
	            @Param("width") String width,
	            @Param("weight") String weight);

	Property findByPropertyName(String propertyName);

}
