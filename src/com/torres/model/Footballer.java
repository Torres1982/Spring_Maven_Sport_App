package com.torres.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
public class Footballer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	@Column(name = "first_name")
	private String firstName;
	@NotNull(message  = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	@Size(min = 2, message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_LENGTH)
	@Column(name = "last_name")
	private String lastName;
	@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	@Size(min = 2, message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_LENGTH)
	@Column(name = "club")
	private String club;
	@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	@Size(min = 2, message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_LENGTH)
	@Column(name = "country")
	private String country;
	@NotNull(message = "Date Must Be Selected")
	@Column(name = "date_of_birth")
	private String dob;
	@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	@Column(name = "strength")
	private String strength;
	@NotNull(message = "Formation Must Be Selected")
	@Column(name = "position")
	private String position;
	@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	@Min(value = 0, message = "Must Be Greater Than or Equal To 0")
	@Max(value = 100, message = "Must Be Less Than or Equal To 100")
	@Column(name = "rating")
	private Integer rating;
	@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	@FootballerCategory(value = {"GK", "DEF", "MID", "ATT"}, message = "Must Start with 'GK' or 'DEF' or 'MID' or 'ATT'")
	@Column(name = "category")
	private String category;
		
	// Default Constructor
	public Footballer() {}
	
	// User-Defined Constructor
	public Footballer(String firstName, String lastName, String club, String country, String dob, String strength, String position, Integer rating, String category) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.club = club;
		this.country = country;
		this.dob = dob;
		this.strength = strength;
		this.position = position;
		this.rating = rating;
		this.category = category;
	}

	public int getId() {return id;}
	public void setId(int id) {this.id = id;}
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
	public String getPosition() {return position;}
	public void setPosition(String position) {this.position = position;}
	public Integer getRating() {return rating;}
	public void setRating(Integer rating) {this.rating = rating;}
	public String getCategory() {return category;}
	public void setCategory(String category) {this.category = category;}
}
