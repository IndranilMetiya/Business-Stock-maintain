package com.Business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Business.entity.Category;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Integer> {

	Category findByCategoryName(String categoryName);

}
