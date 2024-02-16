package com.tcs.investment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tcs.investment.model.Transaction;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {

}
