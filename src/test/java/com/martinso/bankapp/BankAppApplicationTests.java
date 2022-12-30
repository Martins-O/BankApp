package com.martinso.bankapp;

import com.martinso.bankapp.data.model.BankUserDetails;
import com.martinso.bankapp.data.repostories.BankUserDetailsRepository;
import com.martinso.bankapp.dtos.request.RegisterRequest;
import com.martinso.bankapp.services.BankUserDetailsServiceImpl;
import com.martinso.bankapp.utils.Address;
import com.martinso.bankapp.utils.Gender;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BankAppApplicationTests {
	private BankUserDetailsServiceImpl detailsService;
	@Autowired
	private BankUserDetailsRepository detailsRepository;

	@BeforeEach
	public void setUp(){
		detailsService = new BankUserDetailsServiceImpl();
	}

	@Test
	public void registerTest(){
		BankUserDetails details = new BankUserDetails();
		details.setEmail("jojolols@gmail.com");
		details.setFirstName("Martins");
		details.setLastName("Jojolola");
		details.setGender(Gender.MALE);
		details.setPhoneNumber("08146587069");
		details.setDateOfBirth("1998");
		details.setPassword("1998free");
		details.setPasswordConfirmation("1998free");
		Address address = new Address("Nigeria","12","Lagos","Lagos state");
		details.setAddress(address);
		RegisterRequest user = new RegisterRequest();
		user.setAddress(details.getAddress());
		user.setGender(details.getGender());
		user.setEmail(details.getEmail());
		user.setPassword(details.getPassword());
		user.setLastName(details.getLastName());
		user.setPasswordConfirmation(details.getPasswordConfirmation());
		user.setFirstName(details.getFirstName());
		user.setDateOfBirth(details.getDateOfBirth());
		user.setPhoneNumber(details.getPhoneNumber());
		detailsService.register(user);
		assertEquals(1, detailsRepository.count());
	}

	@Test
	void contextLoads() {
	}

}
