package com.martinso.bankapp.dtos.request;

import lombok.Getter;

@Getter
public class ChangePasswordRequest {
	private String email;
	private String oldPassword;
	private String newPassword;
	private String newPasswordConfirmation;
}
