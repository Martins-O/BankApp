package com.martinso.bankapp.services;

import com.martinso.bankapp.dtos.request.*;
import com.martinso.bankapp.dtos.response.*;

public interface BankUserDetailsService {

	RegisterResponse register(RegisterRequest request);

	LoginResponse login(LoginRequest request);

	UpdateResponse update(UpdateRequest request);

	ResetPasswordResponse resetPassword(ResetPasswordRequest request);

	ChangePasswordResponse changePassword(ChangePasswordRequest request);
}
