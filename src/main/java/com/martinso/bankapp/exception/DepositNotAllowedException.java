package com.martinso.bankapp.exception;

public class DepositNotAllowedException extends BankAppException{
	public DepositNotAllowedException(String message) {
		super(message);
	}
}
