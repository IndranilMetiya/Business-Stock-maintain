package com.Business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Business.entity.PriceTracker;
import com.Business.entity.Property;

@Repository
public interface PriceTrackerRepo extends JpaRepository<PriceTracker, Integer> {

	PriceTracker findByProperty(Property property);

}
