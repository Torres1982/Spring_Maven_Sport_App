package com.torres.controller;

import org.apache.log4j.Logger;

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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.torres.user.AppUser;

@Controller
@RequestMapping("/register")
public class RegisterController {
	@Autowired
	private UserDetailsManager userDetailsManager;
	private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@GetMapping("/showAppUserRegistrationForm")
	public String showAppUserRegistrationForm(Model model) {
		AppUser appUser = new AppUser();
		model.addAttribute("appUser", appUser);
		
		return "user_registration_form";
	}

	@PostMapping("/processAppUserRegistrationForm")
	public String processAppUserRegistrationForm(@Valid @ModelAttribute("appUser") AppUser appUser, BindingResult result, Model model) {
		String username = appUser.getUserName();
		String userRegistrationError = "";
		
		if (result.hasErrors()) {
			userRegistrationError = "User Name/Password cannot be Empty!";
		} else if (isUserFoundInDatabase(username)) {
			userRegistrationError = "User Already Exists!";
		}
		
		if ((result.hasErrors()) || (isUserFoundInDatabase(username))) {			
			AppUser appUserError = new AppUser();
			model.addAttribute("appUser", appUserError);
			model.addAttribute("userRegistrationError", userRegistrationError);
			
			logger.info("Binding Result: " + result);
			
			return "user_registration_form";
		} else {
			String encodedPassword = "{bcrypt}" + passwordEncoder.encode(appUser.getPassword());
			List<GrantedAuthority> authorities = AuthorityUtils.createAuthorityList("ROLE_USER");
			User newAppUser = new User(username, encodedPassword, authorities);
			userDetailsManager.createUser(newAppUser);
			logger.info("Successfully Created New User: " + username);
			
			return "confirmation";
		}
	}
	
	// Check the DB if the Application User already exists
	public boolean isUserFoundInDatabase(String userName) {		
		boolean isUserFound = userDetailsManager.userExists(userName);		
		logger.info("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&" + userName + " Found: " + isUserFound);
		
		return isUserFound;
	}
}
