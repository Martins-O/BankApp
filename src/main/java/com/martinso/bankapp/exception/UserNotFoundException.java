package com.martinso.bankapp.exception;

public class UserNotFoundException extends BankAppException{
	public UserNotFoundException(String message) {
		super(message);
	}
}
