package com.martinso.bankapp.dtos.response;

public class ResetPasswordResponse {
	private String message;
	private String email;

	public ResetPasswordResponse(String message, String email) {
		this.message = message;
		this.email = email;
	}
}
