package com.torres.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
	@NotNull(message = "Date Must Be Selected")
	private String dob;
	@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	private String strength;
	@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	@Size(min = 1, message = "At Least One Checkbox Mus Be Selected")
	private String positions [];
	
	@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	@Min(value = 0, message = "Must Be Greater Than or Equal To 0")
	@Max(value = 100, message = "Must Be Less Than or Equal To 100")
	private Integer rating;
	
	private LinkedHashMap<String, String> strengthOptions;
	private ArrayList<String> strengthsArray = new ArrayList<String>() {
		private static final long serialVersionUID = 1L; {
		add("Agility"); add("Balance and Coordination"); add("Ball Possession"); add("Catching Ball"); add("crossing");
		add("Dribbling"); add("Finishing"); add("Free Kicks"); add("Heading"); add("Jump"); add("Long Throw");
		add("Long Passing"); add("Passing"); add("Penalties Saving"); add("Power and Strength"); add("Shot Stopping");
		add("Speed"); add("Stamina"); add("Tackling");
	}};
	
	// User-Defined Constructor
	public Footballer() {
		// Populate Strength Options
		strengthOptions = new LinkedHashMap<String, String>();
		strengthOptions.put("", "Select Main Strength:");
		
		for (String strength : strengthsArray) {
			strengthOptions.put(strength, strength);
		}
	}

	public String getFirstName() {return firstName;}
	public void setFirstName(String firstName) {this.firstName = firstName;}
	public String getLastName() {return lastName;}
	public void setLastName(String lastName) {this.lastName = lastName;}
	public String getClub() {return club;}
	public void setClub(String club) {this.club = club;}
	public String getCountry() {return country;}
	public void setCountry(String country) {this.country = country;}
	public String getDob() {return dob;}
	public void setDob(String dob) {this.dob = dob;}
	public String getStrength() {return strength;}
	public void setStrength(String strength) {this.strength = strength;}
	public LinkedHashMap<String, String> getStrengthOptions() {return strengthOptions;}
	public String[] getPositions() {return positions;}
	public void setPositions(String[] positions) {this.positions = positions;}
	public Integer getRating() {return rating;}
	public void setRating(Integer rating) {this.rating = rating;}	
}
