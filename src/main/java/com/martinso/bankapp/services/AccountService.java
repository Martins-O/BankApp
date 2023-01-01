package com.martinso.bankapp.services;

import com.martinso.bankapp.dtos.request.DepositRequest;
import com.martinso.bankapp.dtos.request.TransferRequest;
import com.martinso.bankapp.dtos.request.WithdrawRequest;
import com.martinso.bankapp.dtos.response.DepositResponse;
import com.martinso.bankapp.dtos.response.TransferResponse;
import com.martinso.bankapp.dtos.response.WithdrawResponse;

public interface AccountService {

	DepositResponse deposit(DepositRequest request);

	WithdrawResponse withdraw(WithdrawRequest request);

	TransferResponse transfer(TransferRequest request);
}
