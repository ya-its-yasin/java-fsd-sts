package com.tcs.investment.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.investment.model.Transaction;
import com.tcs.investment.service.TransactionService;

@RestController
@RequestMapping("/trans")
public class TransactionController {

	@Autowired
	TransactionService service;
	
	@PostMapping
	public String addTransaction(@RequestBody Transaction trans) {
		return service.addTransaction(trans);
	}
	
	@GetMapping("/{id}")
	public Optional<Transaction> getTransaction(@PathVariable int id) {
		return service.getTransaction(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTransaction(@PathVariable int id) {
		service.deleteTransaction(id);
	}
		
}
