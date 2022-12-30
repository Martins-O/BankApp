package com.martinso.bankapp.exception;

public class PasswordMismatchException extends BankAppException {
	public PasswordMismatchException(String message) {
		super(message);
	}
}
