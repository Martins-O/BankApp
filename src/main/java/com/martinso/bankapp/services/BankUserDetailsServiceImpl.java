package com.martinso.bankapp.services;

import com.martinso.bankapp.data.model.BankUserDetails;
import com.martinso.bankapp.data.repostories.BankUserDetailsRepository;
import com.martinso.bankapp.dtos.request.*;
import com.martinso.bankapp.dtos.response.*;
import com.martinso.bankapp.exception.EmailAlreadyExistsException;
import com.martinso.bankapp.exception.UpdateException;
import com.martinso.bankapp.exception.UserNotFoundException;
import com.martinso.bankapp.utils.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankUserDetailsServiceImpl implements BankUserDetailsService{
	@Autowired
	private BankUserDetailsRepository userDetailsRepository;
	private final ModelMapper modelMapper = new ModelMapper();
	@Override
	public RegisterResponse register(RegisterRequest request) {
		Optional<BankUserDetails> existingUser =
			userDetailsRepository.findByEmail(request.getEmail());
		if(existingUser.isPresent()) {
			throw new EmailAlreadyExistsException("This email is already exists by another user");
		}
		BankUserDetails userDetails = modelMapper.mapUser(request);
		BankUserDetails savedDetails = userDetailsRepository.save(userDetails);
		return new RegisterResponse("Registration successfully", savedDetails.getEmail(), savedDetails.getAccountNumber());
	}

	@Override
	public LoginResponse login(LoginRequest request) {
		BankUserDetails bankUserDetails = modelMapper.mapUser(request);
		BankUserDetails updatedUser = userDetailsRepository.save(bankUserDetails);
		return new LoginResponse("Login successfully", updatedUser.getEmail());
	}

	@Override
	public UpdateResponse update(UpdateRequest request) {
		Optional<BankUserDetails> existingUser =
			userDetailsRepository.findByEmail(request.getEmail());
		if(existingUser.isEmpty()) {
			throw new UpdateException("This user does not exist");
		}
		BankUserDetails bankUserDetails = modelMapper.mapUser(request);
		BankUserDetails updatedUser = userDetailsRepository.save(bankUserDetails);
		return new UpdateResponse("Updated successfully!", updatedUser.getEmail());
	}

	@Override
	public ResetPasswordResponse resetPassword(ResetPasswordRequest request) {
		Optional<BankUserDetails> existingUser =
			userDetailsRepository.findByEmail(request.getEmail());
		if(existingUser.isEmpty()){
			throw new UserNotFoundException("please enter a valid user mail or register!");
		}
		BankUserDetails details = modelMapper.mapUser(request);
		BankUserDetails resetPassword = userDetailsRepository.save(details);
		return new ResetPasswordResponse("Password reset successfully", resetPassword.getEmail());
	}

	@Override
	public ChangePasswordResponse changePassword(ChangePasswordRequest request) {
		Optional<BankUserDetails> existingUser =
			userDetailsRepository.findByEmail(request.getEmail());
		BankUserDetails details = modelMapper.mapUser(request);
		BankUserDetails changePassword = userDetailsRepository.save(details);
		return new ChangePasswordResponse("Password change successfully!", changePassword.getEmail());
	}

}
