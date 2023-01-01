package com.martinso.bankapp.dtos.request;

import com.martinso.bankapp.data.model.BankUserDetails;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class WithdrawRequest {


	private BankUserDetails ownersName;
	private BigDecimal amount;
	private BigDecimal accountBalance;
}
