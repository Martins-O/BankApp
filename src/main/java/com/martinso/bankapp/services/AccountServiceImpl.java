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
import com.martinso.bankapp.exception.InavlidAmountException;
import com.martinso.bankapp.exception.UnsupportedDepositException;
import com.martinso.bankapp.exception.UserNotFoundException;
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
		Account depositAccount = new Account();
		depositAccount = accountRepositories.findAccountByOwnersName(depositAccount.getOwnersName());
		verifyThatAccountExists(depositAccount);
		if((request.getAmount().compareTo(BigDecimal.valueOf(1))) <= 0){
			throw new UnsupportedDepositException("Error!!! Amount too low!");
		}
		depositAccount.setAccountBalance(depositAccount.getAccountBalance().
			add(request.getAmount()));
		return new DepositResponse("Deposit successfully",
			depositAccount.getOwnersName());

	}

	private Account verifyThatAccountExists(Account depositAccount) {
		Account account = new Account();
		if(account.getOwnersName() != depositAccount.getOwnersName()) {
			throw new UserNotFoundException("User Not Found");
		}
		return new Account();
	}

	@Override
	public WithdrawResponse withdraw(WithdrawRequest request) {
		Account account = new Account();
		account = accountRepositories.findAccountByOwnersName(account.getOwnersName());
		verifyThatAccountExists(account);
		if(request.getAmount().compareTo(account.getAccountBalance()) > 0){
			throw new InavlidAmountException("Insufficient amount");
		}
		account.setAccountBalance(account.getAccountBalance().subtract(request.getAmount()));
		return new WithdrawResponse("Withdrawal successful", account.getOwnersName());
	}

	@Override
	public TransferResponse transfer(TransferRequest request) {
		Account account = new Account();
		account = accountRepositories.findAccountByOwnersName(account.getOwnersName());
		verifyThatAccountExists(account);
		Account sender = new Account();
		WithdrawRequest requestWithdraw = new WithdrawRequest();
		withdraw(requestWithdraw);
		Account recipient = new Account();
		DepositRequest requestDeposit = new DepositRequest();
		deposit(requestDeposit);
		return new TransferResponse("Transfer done successfully", account.getOwnersName());
	}

}
