package com.tcs.investment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tcs.investment.model.Investor;
import com.tcs.investment.repository.InvestorRepository;

@Service
public class InvestorService {

	@Autowired
	InvestorRepository repository;
	
	public String addInvestor(Investor investor) {
		repository.save(investor);		
		return "Successfully addedd Investor";
	}

}
