package com.Business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Business.entity.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Integer> {

	Customer findByPhNo(String customerPhNo);

}
