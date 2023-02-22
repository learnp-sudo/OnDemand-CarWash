package com.green.car.wash.company.customer.models;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection ="washers")
public class WasherProfile {
	private  String email;
	private String Password;
	private String fullName;
	private String status;
	private String phoneNunmber;
	public WasherProfile()
	{

	}
	public WasherProfile(String email, String password, String fullName, String status, String phoneNunmber) {
		super();
		this.email = email;
		Password = password;
		this.fullName = fullName;
		this.status = status;
		this.phoneNunmber = phoneNunmber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
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
	@Override
	public String toString() {
		return "WasherProfile [email=" + email + ", Password=" + Password + ", fullName=" + fullName + ", status="
				+ status + ", phoneNunmber=" + phoneNunmber + "]";
	}

}
