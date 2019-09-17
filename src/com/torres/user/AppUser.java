package com.torres.user;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AppUser {
	@NotNull(message = "User Name is Required")
	@Size(min = 2, message = "Cannot Be Empty")
	private String userName;
	@NotNull(message = "Password is Required")
	@Size(min = 4, message = "Cannot Be Empty")
	private String password;
	
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
}