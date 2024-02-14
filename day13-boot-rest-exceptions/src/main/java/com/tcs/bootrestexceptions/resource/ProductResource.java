package com.tcs.bootrestexceptions.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.bootrestexceptions.exceptions.InvalidValueException;

@RestController
public class ProductResource {

	@GetMapping
	public String message(String str) throws InvalidValueException, Exception
	{
		if(str==null)
			throw new NullPointerException("value not provided");
		
		boolean isNum = str.chars().allMatch(x->Character.isDigit(x));
		if(isNum)
		{
			throw new InvalidValueException("Expected String, but found int");
			
		}
			
		
		if(str.length()<=1)
			throw new Exception("value must be provided with length greater than 1");
		
		
		return "Hello " + str;
	}
}
