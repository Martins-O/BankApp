package com.martinso.bankapp.utils;

import lombok.*;

@Data
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	@NonNull
	private String country;
	@NonNull
	private String houseNumber;
	@NonNull
	private String city;
	@NonNull
	private String state;
	private String postalCode;
}
