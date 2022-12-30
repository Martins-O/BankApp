package com.martinso.bankapp.data.model;

import com.martinso.bankapp.utils.Address;
import com.martinso.bankapp.utils.Gender;
import lombok.*;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class BankUserDetails {
	@NonNull
	private String firstName;
	@NonNull
	private String lastName;
	@NonNull
	@Id
	private String email;
	@NonNull
	private String phoneNumber;
	@NonNull
	private String dateOfBirth;
	private Gender gender;
	private Address address;
	@NonNull
	private String password;
	@NonNull
	private String passwordConfirmation;
}
