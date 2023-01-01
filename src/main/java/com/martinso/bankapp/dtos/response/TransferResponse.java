package com.martinso.bankapp.dtos.response;

import com.martinso.bankapp.data.model.BankUserDetails;
import lombok.Data;

@Data
public class TransferResponse {
	private String message;
	private BankUserDetails ownersName;

	public TransferResponse(String message, BankUserDetails ownersName) {
		this.message = message;
		this.ownersName = ownersName;
	}
}
