package com.martinso.bankapp.dtos.request;

import com.martinso.bankapp.exception.PasswordMismatchException;
import com.martinso.bankapp.utils.Address;
import com.martinso.bankapp.utils.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public class RegisterRequest {
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String dateOfBirth;
	private Gender gender;
	private Address address;
	private String password;
	private String passwordConfirmation;

	public String getPasswordConfirmation() {
		if(!passwordConfirmation.equals(password)){
			throw new PasswordMismatchException("Please enter a correct password!");
		}
		return passwordConfirmation;
	}
}
