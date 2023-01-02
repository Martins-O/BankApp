package com.martinso.bankapp.data.model;

import com.martinso.bankapp.utils.Address;
import com.martinso.bankapp.utils.Gender;
import lombok.*;
import org.springframework.data.annotation.Id;

import java.security.SecureRandom;

@Data
@AllArgsConstructor

@NoArgsConstructor
public class BankUserDetails {
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@Id
	private String email;
	private String phoneNumber;
	private String dateOfBirth;
	private Gender gender;
	private Address address;
	private String password;
	private String passwordConfirmation;
	@NonNull
	private  String accountNumber;
	private String generateAccountNumber() {
		SecureRandom random = new SecureRandom();
		long accountNumber = random.nextLong();
		accountNumber = Math.abs(accountNumber % 100000000000L);
		return String.format("%010d", accountNumber);
	}

	public String getAccountNumber() {
		String acct = generateAccountNumber();
		this.accountNumber = String.valueOf(acct);
		return accountNumber;
	}

	public BankUserDetails(String firstName, String lastName, String accountNumber){
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountNumber = accountNumber;
	}


}
