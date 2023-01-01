package com.martinso.bankapp.services;

import com.martinso.bankapp.data.model.Account;
import com.martinso.bankapp.data.model.BankUserDetails;
import com.martinso.bankapp.data.repostories.AccountRepositories;
import com.martinso.bankapp.dtos.request.DepositRequest;
import com.martinso.bankapp.dtos.request.TransferRequest;
import com.martinso.bankapp.dtos.request.WithdrawRequest;
import com.martinso.bankapp.dtos.response.DepositResponse;
import com.martinso.bankapp.dtos.response.TransferResponse;
import com.martinso.bankapp.dtos.response.WithdrawResponse;
import com.martinso.bankapp.exception.AccountUserExecption;
import com.martinso.bankapp.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountException;
import java.math.BigDecimal;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountRepositories accountRepositories;
	private final ModelMapper modelMapper = new ModelMapper();
	@Override
	public DepositResponse deposit(DepositRequest request) {
		Optional<Account> user =
			accountRepositories.FindByAccName(request.getOwnersName());
		if (user.isEmpty()){
			throw new AccountUserExecption("Account cannot be found");
		}
		Account account = modelMapper.mapAccount(request);
		Account depositAccount = accountRepositories.save(account);
		return new DepositResponse("Deposit successfully", depositAccount.getOwnersName());
	}

	@Override
	public WithdrawResponse withdraw(WithdrawRequest request) {
		Optional<Account> accAmount =
			accountRepositories.FindByAccName(request.getOwnersName());
		if (accAmount.isEmpty()){
			throw new AccountUserExecption("Account cannot be found");
		}
		Account account = modelMapper.mapAccount(request);
		Account withdrawAmount = accountRepositories.save(account);
		return new WithdrawResponse("Withdraw succcessfully", withdrawAmount.getOwnersName());
	}

	@Override
	public TransferResponse transfer(TransferRequest request) {
		Optional<Account> withdraw =
			accountRepositories.FindByAccName(request.getOwnersName());
		if(withdraw.isEmpty()) {
			throw new AccountUserExecption("Account cannot be found");
		}
		Account account = modelMapper.mapAccount(request);
		Account transfer = accountRepositories.save(account);
		return new TransferResponse("Transfer succcessfully", transfer.getOwnersName());
	}

}
