package com.green.car.wash.company.admin.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Document(collection ="washers")
public class WasherProfile {
	@Id
	private  String email;
	@JsonIgnore
	private String password;
	private String fullName;
	private String status;
	private String phoneNunmber;
	private String username;

	public WasherProfile()
	{

	}
	public WasherProfile(String email, String password, String fullName, String status, String phoneNunmber,
			String username) {
		super();
		this.email = email;
		this.password = password;
		this.fullName = fullName;
		this.status = status;
		this.phoneNunmber = phoneNunmber;
		this.username = username;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPhoneNunmber() {
		return phoneNunmber;
	}
	public void setPhoneNunmber(String phoneNunmber) {
		this.phoneNunmber = phoneNunmber;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "WasherProfile [email=" + email + ", password=" + password + ", fullName=" + fullName + ", status="
				+ status + ", phoneNunmber=" + phoneNunmber + ", username=" + username + "]";
	}



}
