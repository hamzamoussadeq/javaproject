package com.retail.user.utility;

public class JwtResponse {
	String token;

	public JwtResponse(String token) {
		super();
		this.token = token;
	}

	public JwtResponse() {

	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "JwtResponse [token=" + token + "]";
	}

}
