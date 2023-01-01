package com.martinso.bankapp.dtos.response;

import com.martinso.bankapp.data.model.BankUserDetails;
import lombok.Data;

@Data
public class WithdrawResponse {
	private String message;
	private BankUserDetails ownersName;

	public WithdrawResponse(String message, BankUserDetails ownersName) {
		this.message = message;
		this.ownersName = ownersName;
	}
}
