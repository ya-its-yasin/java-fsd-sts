package com.tcs.mvcjsp;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("/go")
	public String login(Model map)
	{
		ArrayList<String> products = new ArrayList<>();
		products.add("Television");
		products.add("Laptop");
		products.add("SmartPhone");
		products.add("SmartWatch");
		products.add("SmartGoggles");
		
		map.addAttribute("products", products);
		
		return "success";
	}
}
