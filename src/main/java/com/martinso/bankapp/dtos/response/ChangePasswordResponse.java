package com.martinso.bankapp.dtos.response;

import lombok.Data;

@Data
public class ChangePasswordResponse {
	private String message;
	private String email;

	public ChangePasswordResponse(String message, String email) {
		this.message = message;
		this.email = email;
	}
}
