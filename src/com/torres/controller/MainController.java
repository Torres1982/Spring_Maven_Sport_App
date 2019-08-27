package com.torres.controller;

import java.util.Date;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

import com.torres.model.Footballer;

@Controller
@RequestMapping("/main")
public class MainController {
	// Removes White Spaces from the String
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmer);
	}
	
	@RequestMapping({"/", "/home"})
	public String showIndexPage(Model model) {
		model.addAttribute("todayDate", new Date());
		return "home";
	}
	
	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm(Model model) {
		Footballer footballer = new Footballer();
		model.addAttribute("footballer", footballer);
		
		return "registration_form";
	}
}
