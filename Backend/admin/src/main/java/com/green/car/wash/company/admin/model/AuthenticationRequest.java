package com.green.car.wash.company.admin.model;

public class AuthenticationRequest {
private String username;
private String password;
private String email;
private String role;
public AuthenticationRequest() {


}


public AuthenticationRequest(String username, String password, String email, String role) {
	super();
	this.username = username;
	this.password = password;
	this.email = email;
	this.role = role;
}


public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}
@Override
public String toString() {
	return "AuthenticationRequest [username=" + username + ", password=" + password + ", role=" + role + "]";
}


}
