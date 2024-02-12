package com.tcs.boot.day11springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WelcomeController {

	@GetMapping("/")
	public String invite(Model map)
	{
		System.out.println("from welcome controller");
		map.addAttribute("location", "Chennai1");
		return "registration-form";
	}
	
}
