package com.martinso.bankapp.controllers;

import com.martinso.bankapp.dtos.request.RegisterRequest;
import com.martinso.bankapp.dtos.response.RegisterResponse;
import com.martinso.bankapp.exception.EmailAlreadyExistsException;
import com.martinso.bankapp.services.BankUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("details/")
public class BankUserDetailsController {

	private final BankUserDetailsService details;

	@PostMapping("register/")
	public ResponseEntity<?> register(@RequestBody RegisterRequest request){
		try {
			RegisterResponse response = details.register(request);
			return new ResponseEntity<>(response, HttpStatus.CREATED);
		}
		catch(EmailAlreadyExistsException ex){
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
