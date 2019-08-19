package com.torres.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.torres.model.Footballer;
import com.torres.service.FootballerServiceImpl;
import com.torres.util.DateUtility;

@Controller
@RequestMapping("/footballer")
public class MainController {	
	@Autowired
	private FootballerServiceImpl footballerService;
		
	// Removes White Spaces from the String
	@InitBinder
	public void initBinder(WebDataBinder dataBinder) {
		StringTrimmerEditor stringTrimmer = new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class, stringTrimmer);
	}
	
	@RequestMapping({"/", "/home"})
	public String showIndexPage(ModelMap model) {
		model.addAttribute("todayDate", DateUtility.convertDateToStringByDate(new Date()));
		
		return "home";
	}
	
	@GetMapping("/showRegistrationForm")
	public String showRegistrationForm(Model model) {
		model.addAttribute("footballer", new Footballer());
		
		return "registration_form";
	}
	
	@GetMapping("/showRegistrationFormToUpdate")
	public String showRegistrationFormToUpdate(@RequestParam("footballerId") int id, Model model) {
		Footballer footballer = footballerService.getFootballer(id);
		model.addAttribute("footballer", footballer);
		
		return "registration_form";
	}
	
	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("footballer") Footballer footballer, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println("Some Required Fields are Left Blank!");
			System.out.println("Binding Result: " + result);
			
			return "registration_form";
		} else {
			footballerService.createFootballer(footballer);					
			System.out.println("New Footballer Registered Successfully! Id: " + footballer.getId() + " " + footballer.getFirstName() + " " + footballer.getLastName());

			return "confirmation";
		}
	}
	
	@GetMapping("/showAllPlayers")
	public String showAllRegisteredPlayers(ModelMap model) throws ParseException {
		List<Footballer> listOfFootballersFromDb = footballerService.getAllFootballers();		
		model.addAttribute("players", listOfFootballersFromDb);
		
		return "players";
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

















