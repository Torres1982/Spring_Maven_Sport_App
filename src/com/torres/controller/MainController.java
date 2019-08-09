package com.torres.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	public String processRegistrationForm(@Valid @ModelAttribute("footballer") Footballer footballer, BindingResult result) {
		System.out.println("New Footballer Registered - Success: " + footballer.getFirstName() + " " + footballer.getLastName());
		
		if (result.hasErrors()) {
			return "registration_form";
		} else {
			return "confirmation";
		}
	}
}
