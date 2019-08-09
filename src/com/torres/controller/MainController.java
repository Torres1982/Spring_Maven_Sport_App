package com.torres.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.torres.model.Footballer;

@Controller
public class MainController {
	@RequestMapping({"/", "/home"})
	public String showIndexPage( ) {
		return "home";
	}
	
	@RequestMapping("/showRegistrationForm")
	public String showRegistrationForm(Model model) {
		model.addAttribute("footballer", new Footballer());
		return "registration_form";
	}
	
	@RequestMapping("/processRegistrationForm")
	public String processRegistrationForm(@ModelAttribute("footballer") Footballer footballer) {
		System.out.println("New Footballer Registered: " + footballer.getFirstName() + " " + footballer.getLastName());
		return "confirmation";
	}
}
