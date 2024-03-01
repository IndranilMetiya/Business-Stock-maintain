package com.Business.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Business.entity.PriceTrackerUpdate;

@Repository
public interface PriceTrackerUpdateRepo extends JpaRepository<PriceTrackerUpdate, Integer> {

	List<PriceTrackerUpdate> findByPropertyName(String propertyName);

}
