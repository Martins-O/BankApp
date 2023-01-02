package com.martinso.bankapp.controllers;

import com.martinso.bankapp.dtos.request.DepositRequest;
import com.martinso.bankapp.dtos.response.DepositResponse;
import com.martinso.bankapp.exception.DepositNotAllowedException;
import com.martinso.bankapp.services.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("account/")
public class AccountController {

	@Autowired
	private final AccountService account;

	@PostMapping("deposit/")
	public ResponseEntity<?> deposit(@RequestBody DepositRequest request){
		try {
			DepositResponse response = account.deposit(request);
			return new ResponseEntity<>(response, HttpStatus.OK);
		}catch(DepositNotAllowedException dex){
			return new ResponseEntity<>(dex.getMessage(), HttpStatus.FORBIDDEN);
		}
	}
}
