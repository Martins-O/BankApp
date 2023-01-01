package com.martinso.bankapp.utils;

import com.martinso.bankapp.data.model.Account;
import com.martinso.bankapp.data.model.BankUserDetails;
import com.martinso.bankapp.dtos.request.*;

import java.math.BigDecimal;

public class ModelMapper {

	public BankUserDetails mapUser(RegisterRequest request) {
		BankUserDetails user = new BankUserDetails();
		user.setFirstName(request.getFirstName());
		user.setLastName(request.getLastName());
		user.setEmail(request.getEmail());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setDateOfBirth(request.getDateOfBirth());
		user.setGender(request.getGender());
		user.setPassword(request.getPassword());
		user.setPasswordConfirmation(request.getPasswordConfirmation());
		user.setAddress(request.getAddress());
		user.setDateOfBirth(request.getDateOfBirth());
		user.getAccountNumber();
		return user;
	}

	public BankUserDetails mapUser(LoginRequest request){
		BankUserDetails user = new BankUserDetails();
		user.setEmail(request.getEmail());
		user.setPassword(request.getPassword());
		return user;
	}

	public BankUserDetails mapUser(UpdateRequest request) {
		BankUserDetails user = new BankUserDetails();
		user.setEmail(request.getEmail());
		user.setLastName(request.getLastName());
		user.setPhoneNumber(request.getPhoneNumber());
		user.setAddress(request.getAddress());
		user.setFirstName(request.getFirstName());
		user.setDateOfBirth(request.getDateOfBirth());
		return user;
	}

	public BankUserDetails mapUser(ResetPasswordRequest request) {
		BankUserDetails user = new BankUserDetails();
		user.setEmail(request.getEmail());
		user.setPassword(request.getNewPassword());
		user.setPasswordConfirmation(request.getNewPasswordConfirmation());
		return user;
	}

	public BankUserDetails mapUser(ChangePasswordRequest request) {
		BankUserDetails user = new BankUserDetails();
		user.setEmail(request.getEmail());
		user.setPassword(request.getOldPassword());
		user.setPassword(request.getNewPassword());
		user.setPasswordConfirmation(request.getNewPasswordConfirmation());
		return user;
	}

	public Account mapAccount(DepositRequest request) {
		Account account = new Account();
		account.setOwnersName(request.getOwnersName());
		account.setAmount(request.getAmount());
		BigDecimal newBalance = account.getAccountBalance().add(request.getAmount());
		account.setAccountBalance(newBalance);
		return account;
	}

	public Account mapAccount(WithdrawRequest request) {
		Account account = new Account();
		account.setOwnersName(request.getOwnersName());
		account.setAmount(request.getAmount());
		BigDecimal newBalance = account.getAccountBalance().subtract(request.getAmount());
		account.setAccountBalance(newBalance);
		return account;
	}
	public Account mapAccount(TransferRequest request){
		Account sender = new Account();
		WithdrawRequest requestWithdraw = new WithdrawRequest();
		mapAccount(requestWithdraw);
		Account recipient = new Account();
		DepositRequest requestDeposit = new DepositRequest();
		mapAccount(requestDeposit);
		return sender;
	}
}
