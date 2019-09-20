package com.torres.model;

//import javax.validation.constraints.NotNull;
//import javax.validation.constraints.Size;
//import org.springframework.stereotype.Component;
//import com.torres.util.Constants;

public class AppUser {
	//@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	//@Size(min = 2, message = Constants.AppUserValidation.ERROR_APP_USER_REGISTRATION_FORM_LENGTH)
	private String userName;
	//@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	//@Size(min = 4, message = Constants.AppUserValidation.ERROR_APP_USER_REGISTRATION_FORM_LENGTH)
	private String password;
	//@NotNull(message = Constants.Validation.ERROR_FOOTBALLER_REGISTRATION_FORM_NULL)
	private String userRole;
	
	// Default Constructor
	public AppUser() {}
	
	// User-Defined Constructor
	public AppUser(String username, String password) {
		this.userName = username;
		this.password = password;
	}
	
	public String getUserName() {return userName;}
	public void setUserName(String username) {this.userName = username;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public String getUserRole() {return userRole;}
	public void setUserRole(String userRole) {this.userRole = userRole;}
}