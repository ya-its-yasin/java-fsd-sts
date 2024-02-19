package com.tcs.investment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.investment.model.Investor;
import com.tcs.investment.model.Transaction;
import com.tcs.investment.repository.TransactionRepository;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository repo;

	public String addTransaction(Transaction trans) {
		repo.save(trans);		
		return "Successfully addedd Transaction";
	}

	public Optional<Transaction> getTransaction(int id) {
		Optional<Transaction> trans = repo.findById(id);
		return trans;
	}

	public void deleteTransaction(int id) {
		repo.deleteById(id);
	}

}
