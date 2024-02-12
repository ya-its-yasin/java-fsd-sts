package com.tcs.boot.day11springboot;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class FormRegistrationController {

	@PostMapping
	public String processForm(@RequestParam String lastName,
			@RequestParam String mobileNum,
			@RequestParam String emailId, Model model)
	{
		model.addAttribute("name", lastName);
		model.addAttribute("mobile", mobileNum);
		model.addAttribute("email", emailId);
		
		return "home";
	}
}
