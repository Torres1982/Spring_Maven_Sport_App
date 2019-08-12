package com.torres.model;

import java.util.LinkedHashMap;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Value;
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
	@NotNull(message = "Date Must Be Selected")
	private String dob;
	@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	private String strength;
	@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	@Size(min = 1, message = "At Least One Checkbox Mus Be Selected")
	private String positions [];
	
	@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	@Min(value = 0, message = "Must Be Equal To or Greater Than 0")
	@Max(value = 100, message = "Must Be Equal To or Less Than 100")
	private int rating;
	
	private LinkedHashMap<String, String> strengthOptions;
	
	public Footballer() {
		// Populate Strengths Options
		strengthOptions = new LinkedHashMap<String, String>();
		strengthOptions.put("", "Select Main Strength:");
		strengthOptions.put("Agility", "Agility");
		strengthOptions.put("Balance and Coordination", "Balance and Coordination");
		strengthOptions.put("Ball Possession", "Ball Possession");
		strengthOptions.put("Catching Ball", "Catching Ball");
		strengthOptions.put("Crossing", "Crossing");
		strengthOptions.put("Dribbling", "Dribbbling");
		strengthOptions.put("Finishing", "Finishing");
		strengthOptions.put("Free Kicks", "Free Kicks");
		strengthOptions.put("Heading", "Heading");
		strengthOptions.put("Jump", "Jump");
		strengthOptions.put("Long Throw", "Long Throw");
		strengthOptions.put("Long Passing", "Long Passing");
		strengthOptions.put("Passing", "Passing");
		strengthOptions.put("Penalties Saveing", "Penalties Saving");
		strengthOptions.put("Power and Strength", "Power and Strength");
		strengthOptions.put("Shot Stopping", "Shot Stopping");
		strengthOptions.put("Speed", "Speed");
		strengthOptions.put("Stamina", "Stamina");
		strengthOptions.put("Tackling", "Tackling");
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

	public String[] getPositions() {
		return positions;
	}

	public void setPositions(String[] positions) {
		this.positions = positions;
	}
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}	
}
