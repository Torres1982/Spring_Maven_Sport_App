package com.torres.controller;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.torres.model.Footballer;

@Controller
public class MainController {	
	// Removes White Spaces from the String
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmer);
	}
	
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
		if (result.hasErrors()) {
			System.out.println("Some Required Fields are Left Blank!");
			System.out.println("Binding Result: " + result);
			return "registration_form";
		} else {
			System.out.println("New Footballer Registered - Success: " + footballer.getFirstName() + " " + footballer.getLastName());
			return "confirmation";
		}
	}
	
	@ModelAttribute("positionSelection")
	public ArrayList<String> positionSelection() {
		ArrayList<String> positionSelection = new ArrayList<String>();
		positionSelection.add("Goalkeeper");
		positionSelection.add("Defender");
		positionSelection.add("Midfielder");
		positionSelection.add("Attacker");
		return positionSelection;
	}
}
