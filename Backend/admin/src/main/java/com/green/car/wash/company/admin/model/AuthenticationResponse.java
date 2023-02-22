package com.green.car.wash.company.admin.model;

public class AuthenticationResponse {
private final String jwt;
public AuthenticationResponse(String jwt) {
	super();
	this.jwt = jwt;
}

public String getJwt() {
	return jwt;
}
}
