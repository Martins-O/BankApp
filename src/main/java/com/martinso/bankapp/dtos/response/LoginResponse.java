package com.martinso.bankapp.dtos.response;

public class LoginResponse {

	private String message;
	private String email;

	public LoginResponse(String message, String email) {
		this.message = message;
		this.email = email;
	}
}
