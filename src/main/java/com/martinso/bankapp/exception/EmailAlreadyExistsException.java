package com.martinso.bankapp.exception;

public class EmailAlreadyExistsException extends BankAppException {
	public EmailAlreadyExistsException(String message) {
		super(message);
	}
}
