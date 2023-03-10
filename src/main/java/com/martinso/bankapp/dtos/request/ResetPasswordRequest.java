package com.martinso.bankapp.dtos.request;

import lombok.Getter;

@Getter
public class ResetPasswordRequest {
	private String email;
	private String oldPassword;
	private String newPassword;
	private String newPasswordConfirmation;
}
