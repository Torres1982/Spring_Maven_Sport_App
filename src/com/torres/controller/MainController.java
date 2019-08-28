package com.torres.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@ModelAttribute("positionSelection")
	public ArrayList<String> positionSelection() {
		ArrayList<String> positionSelection = new ArrayList<String>();
		positionSelection.add("Goalkeeper");
		positionSelection.add("Defender");
		positionSelection.add("Midfielder");
		positionSelection.add("Attacker");
		
		return positionSelection;
	}
		
	@ModelAttribute("strengthSelection")
	public LinkedHashMap<String, String> strengthOptions() {
		LinkedHashMap<String, String> strengthOptions;
		final ArrayList<String> strengthsArray = new ArrayList<String>() {
			private static final long serialVersionUID = 1L; {
			add("Agility"); add("Balance and Coordination"); add("Ball Possession"); add("Catching Ball"); add("Crossing");
			add("Dribbling"); add("Finishing"); add("Free Kicks"); add("Heading"); add("Jump"); add("Long Throw");
			add("Long Passing"); add("Passing"); add("Penalties Saving"); add("Power and Strength"); add("Shot Stopping");
			add("Speed"); add("Stamina"); add("Tackling");
		}};
		
		// Populate Strength Options
		strengthOptions = new LinkedHashMap<String, String>();
		strengthOptions.put("", "Select Main Strength:");
		
		for (String strength : strengthsArray) {
			strengthOptions.put(strength, strength);
		}
		return strengthOptions;
	}
}
