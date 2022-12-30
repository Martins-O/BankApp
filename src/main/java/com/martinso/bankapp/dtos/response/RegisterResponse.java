package com.martinso.bankapp.dtos.response;

import lombok.Data;

@Data
public class RegisterResponse {
	private String message;
	private String email;

	public RegisterResponse(String message, String email) {
		this.message = message;
		this.email = email;
	}
}
