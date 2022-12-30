package com.martinso.bankapp.dtos.request;

import com.martinso.bankapp.utils.Address;
import com.martinso.bankapp.utils.Gender;
import lombok.Getter;
import org.springframework.data.annotation.Id;
@Getter
public class UpdateRequest {
	private String firstName;
	private String lastName;
	private String phoneNumber;
	private String dateOfBirth;
	private Address address;
	private String email;

}
