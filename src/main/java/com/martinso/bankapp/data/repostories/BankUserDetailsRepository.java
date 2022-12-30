package com.martinso.bankapp.data.repostories;

import com.martinso.bankapp.data.model.BankUserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface BankUserDetailsRepository extends MongoRepository<BankUserDetails, String> {
	Optional<BankUserDetails> findByEmail(String email);
}
