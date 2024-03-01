package com.Business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Business.entity.Property;
import com.Business.entity.Stock;

@Repository
public interface StockRepo extends JpaRepository<Stock, Integer> {

	Stock findByProperty(Property property);

}
