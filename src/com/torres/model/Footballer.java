package com.torres.model;

import java.util.LinkedHashMap;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.torres.util.Constants;

@Component("footballer")
public class Footballer {	
	private String firstName;
	@NotNull(message  = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	@Size(min = 2, message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_LENGTH)
	private String lastName;
	@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	@Size(min = 2, message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_LENGTH)
	private String club;
	@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	@Size(min = 2, message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_LENGTH)
	private String country;
	@NotNull(message = "Date Must Be Selected!")
	private String dob;
	
//	@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL) // Check Boxes (few)
//	private String position;
	@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL) // Drop-down list (one)
	private String strength;
//	@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL) // Integer
//	@Size(min = 0, max = 100)
//	private int rating;
	
	private LinkedHashMap<String, String> strengthOptions;
	
	public Footballer() {
		// Populate Strengths Options
		strengthOptions = new LinkedHashMap<String, String>();
		strengthOptions.put("", "Select Main Strength:");
		strengthOptions.put("agility", "Agility");
		strengthOptions.put("balance", "Balance and Coordination");
		strengthOptions.put("ball possession", "Ball Possession");
		strengthOptions.put("catch ball", "Catching Ball");
		strengthOptions.put("cross", "Crossing");
		strengthOptions.put("dribble", "Dribbbling");
		strengthOptions.put("finish", "Finishing");
		strengthOptions.put("free kicks", "Free Kicks");
		strengthOptions.put("head", "Heading");
		strengthOptions.put("jump", "Jump");
		strengthOptions.put("throw", "Long Throw");
		strengthOptions.put("long pass", "Long Passing");
		strengthOptions.put("pass", "Passing");
		strengthOptions.put("penalties saver", "Penalties Saving");
		strengthOptions.put("strength", "Power and Strength");
		strengthOptions.put("shot stop", "Shot Stopping");
		strengthOptions.put("speed", "Speed");
		strengthOptions.put("stamina", "Stamina");
		strengthOptions.put("tackle", "Tackling");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getClub() {
		return club;
	}

	public void setClub(String club) {
		this.club = club;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public LinkedHashMap<String, String> getStrengthOptions() {
		return strengthOptions;
	}

//	public String getPosition() {
//		return position;
//	}
//
//	public void setPosition(String position) {
//		this.position = position;
//	}

//	public int getRating() {
//		return rating;
//	}
//
//	public void setRating(int rating) {
//		this.rating = rating;
//	}
	
}
