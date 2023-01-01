package com.martinso.bankapp.dtos.response;

import com.martinso.bankapp.data.model.BankUserDetails;
import lombok.Data;

@Data
public class DepositResponse {
	private String message;
	private BankUserDetails ownersName;

	public DepositResponse(String message, BankUserDetails ownersName) {
		this.message = message;
		this.ownersName = ownersName;
	}
}
