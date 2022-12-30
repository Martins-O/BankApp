package com.martinso.bankapp.dtos.response;

public class UpdateResponse {
	private String message;
	private String email;

	public UpdateResponse(String message, String email) {
		this.message = message;
		this.email = email;
	}
}
