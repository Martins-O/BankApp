package com.martinso.bankapp.controllers;

import com.martinso.bankapp.dtos.request.LoginRequest;
import com.martinso.bankapp.dtos.request.RegisterRequest;
import com.martinso.bankapp.dtos.request.UpdateRequest;
import com.martinso.bankapp.dtos.response.LoginResponse;
import com.martinso.bankapp.dtos.response.RegisterResponse;
import com.martinso.bankapp.dtos.response.UpdateResponse;
import com.martinso.bankapp.exception.EmailAlreadyExistsException;
import com.martinso.bankapp.exception.LoginAlreadyExistsException;
import com.martinso.bankapp.exception.UserNotFoundException;
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

	@PostMapping("login/")
	public ResponseEntity<?> login (@RequestBody LoginRequest request){
		try {
			LoginResponse response = details.login(request);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		catch (LoginAlreadyExistsException lex) {
			return new ResponseEntity<>(lex.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@PostMapping("update/")
	public ResponseEntity<?> updateUser (@RequestBody UpdateRequest request){
		try {
			UpdateResponse response = details.update(request);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}
		catch(UserNotFoundException uex){
			return new ResponseEntity<>(uex.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
