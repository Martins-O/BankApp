package com.martinso.bankapp.dtos.response;

public class ChangePasswordResponse {
	private String message;
	private String email;

	public ChangePasswordResponse(String message, String email) {
		this.message = message;
		this.email = email;
	}
}
