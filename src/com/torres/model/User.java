//package com.torres.model;
//
//import java.io.Serializable;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Table;
//
//import org.springframework.stereotype.Component;
//
//@Component("user")
//@Entity
//@Table(name = "users")
//public class User implements Serializable {
//	private static final long serialVersionUID = 1L;
//	
//	@Column(name = "username")
//	private String username;
//	@Column(name = "password")
//	private String password;
//	@Column(name = "enabled")
//	private Integer enabled;
//	
//	// Default Constructor
//	public User() {}
//	
//	// User-Defined Constructor
//	public User(String username, String password, int enabled) {
//		this.username = username;
//		this.password = password;
//		this.enabled = enabled;
//	}
//	
//	public String getUsername() {return username;}
//	public void setUsername(String username) {this.username = username;}
//	public String getPassword() {return password;}
//	public void setPassword(String password) {this.password = password;}
//	public Integer getEnabled() {return enabled;}
//	public void setEnabled(Integer enabled) {this.enabled = enabled;}
//}