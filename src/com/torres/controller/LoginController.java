package com.torres.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		
		return "login_page";
	}
	
	@GetMapping("/accessDenied")
	public String showAccessDenied() {
		
		return "access_denied";
	}
}
