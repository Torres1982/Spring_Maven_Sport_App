package com.torres.model;

import java.util.ArrayList;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;

import com.torres.util.Constants;
import com.torres.validation.FootballerCategory;

@Component("footballer")
@Entity
@Table(name = "footballer")
public class Footballer {
	@Id
	@Column(name = "id")
	private int id;
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
	@NotNull(message = "Formation Must Be Selected")
	private String position;
	@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	@Min(value = 0, message = "Must Be Greater Than or Equal To 0")
	@Max(value = 100, message = "Must Be Less Than or Equal To 100")
	private Integer rating;
	@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	@FootballerCategory(value = {"GK", "DEF", "MID", "ATT"}, message = "Must Start with 'GK' or 'DEF' or 'MID' or 'ATT'")
	private String category;
	
	private LinkedHashMap<String, String> strengthOptions;
	private ArrayList<String> strengthsArray = new ArrayList<String>() {
		private static final long serialVersionUID = 1L; {
		add("Agility"); add("Balance and Coordination"); add("Ball Possession"); add("Catching Ball"); add("Crossing");
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
	public String getPosition() {return position;}
	public void setPositions(String position) {this.position = position;}
	public Integer getRating() {return rating;}
	public void setRating(Integer rating) {this.rating = rating;}
	public String getCategory() {return category;}
	public void setCategory(String category) {this.category = category;}
}
