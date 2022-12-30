package com.martinso.bankapp.exception;

public class LoginAlreadyExistsException extends BankAppException{
	public LoginAlreadyExistsException(String message) {
		super(message);
	}
}
