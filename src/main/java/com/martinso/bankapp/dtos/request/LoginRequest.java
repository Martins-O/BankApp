package com.martinso.bankapp.dtos.request;

import lombok.Data;
import lombok.Getter;

@Getter
public class LoginRequest {
	private String email;
	private String password;
}
