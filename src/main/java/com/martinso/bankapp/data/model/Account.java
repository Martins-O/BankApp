package com.martinso.bankapp.data.model;

import com.martinso.bankapp.exception.InavlidAmountException;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {

	private BigDecimal accountBalance;
	@Id
	private BankUserDetails ownersName;
	private BigDecimal amount;

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		if(amount.compareTo(BigDecimal.valueOf(0))>0){
			this.amount = amount;
		}else
			throw new InavlidAmountException("Put positive amount");
	}

}
