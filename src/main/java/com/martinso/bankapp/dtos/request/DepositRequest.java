package com.martinso.bankapp.dtos.request;

import com.martinso.bankapp.data.model.BankUserDetails;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Getter
@NoArgsConstructor
public class DepositRequest {
	private BankUserDetails ownersName;
	private BigDecimal amount;
	private BigDecimal accountBalance;

}
