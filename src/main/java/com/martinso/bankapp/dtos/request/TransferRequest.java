package com.martinso.bankapp.dtos.request;

import com.martinso.bankapp.data.model.BankUserDetails;
import lombok.Getter;

@Getter
public class TransferRequest {
	private String accountNumber;
	private BankUserDetails ownersName;
	private String amount;
	private String accountBalance;
}
