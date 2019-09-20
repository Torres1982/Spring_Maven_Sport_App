package com.torres.controller;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.torres.model.AppUser;
import com.torres.validation.UserValidator;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private UserDetailsManager userDetailsManager;
	@Autowired
	private UserValidator userValidator;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	private Logger logger = Logger.getLogger(getClass().getName());
	
    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.addValidators(userValidator);
    }
	
	@GetMapping("/showAppUserRegistrationForm")
	public String showAppUserRegistrationForm(Model model) {
		AppUser appUser = new AppUser();
		model.addAttribute("appUser", appUser);
		
		return "user_registration_form";
	}

	@PostMapping("/processAppUserRegistrationForm")
	public String processAppUserRegistrationForm(@Valid @ModelAttribute("appUser") AppUser appUser, BindingResult result, Model model) {
		String username = appUser.getUserName();
		String plainPassword = appUser.getPassword();
		String userRole = appUser.getUserRole();
		String userRegistrationError = "Provide Correct Username, Password and Select the Role!";
		
		userValidator.validate(appUser, result);
		
//		if (username.length() == 0 || plainPassword.length() == 0) {
//			userRegistrationError = "User Name/Password cannot be Empty!";
//		} else if (username.length() < 2) {
//			userRegistrationError = "User Name Must Contain at Least 2 Characters!" + username.length();
//		} else if (plainPassword.length() < 4) {
//			userRegistrationError = "Password Must Contain at Least 4 Characters!" + plainPassword.length();
//		} else {
//			userRegistrationError = "Registration Error!";
//		}
			
		if (isUserFoundInDatabase(username)) {
			userRegistrationError = "User Already Exists!";
		}
		
		if ((result.hasErrors()) || (isUserFoundInDatabase(username))) {			
			AppUser appUserError = new AppUser();
			model.addAttribute("appUser", appUserError);
			model.addAttribute("userRegistrationError", userRegistrationError);
			
			logger.info("*** Binding Result: *** " + result);
			
			return "user_registration_form";
		} else {
			String appUserMessage = username + ", Role: " + userRole + " - New Application User Created Successfully!";
			model.addAttribute("appUserMessage", appUserMessage);
			String encodedPassword = "{bcrypt}" + passwordEncoder.encode(plainPassword);
			List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList(userRole);
			
			if (userRole != "ROLE_USER") {
				authorities = AuthorityUtils.createAuthorityList("ROLE_USER", userRole);
			}
			
			User newAppUser = new User(username, encodedPassword, authorities);
			userDetailsManager.createUser(newAppUser);
			logger.info("*** " + appUserMessage);
			
			return "confirmation";
		}
	}
	
	// Check the DB if the Application User already exists
	public boolean isUserFoundInDatabase(String userName) {		
		boolean isUserFound = userDetailsManager.userExists(userName);		
		logger.info("*** " + userName + " Found: " + isUserFound);
		
		return isUserFound;
	}
	
	@ModelAttribute("roleSelection")
	public LinkedHashMap<String, String> rolesOptions() {
		LinkedHashMap<String, String> rolesOptions;
		final ArrayList<String> rolesArray = new ArrayList<String>() {
			private static final long serialVersionUID = 1L; {
			add("ROLE_USER");
			add("ROLE_MANAGER");
			add("ROLE_ADMIN");
		}};
		
		// Populate Strength Options
		rolesOptions = new LinkedHashMap<String, String>();
		rolesOptions.put("", "----- Select Role -----");
		
		for (String strength : rolesArray) {
			rolesOptions.put(strength, strength);
		}
		return rolesOptions;
	}
}
