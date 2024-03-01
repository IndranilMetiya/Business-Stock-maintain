package com.Business.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Business.entity.Property;
import com.Business.entity.TransactionData;

@Repository
public interface TransactionDataRepo extends JpaRepository<TransactionData, Integer> {

	void deleteByProperty(Property property);

	void deleteByTransactionIdfromFE(String transactionIdfromFE);

}
