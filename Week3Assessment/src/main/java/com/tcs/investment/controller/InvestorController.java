package com.tcs.investment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.investment.model.Investor;
import com.tcs.investment.service.InvestorService;

@RestController
@RequestMapping("/inv")
public class InvestorController {
	
	@Autowired
	InvestorService service;

	@PostMapping
	public String addInvestor(@RequestBody Investor investor)
	{
		return service.addInvestor(investor);
	}
}
