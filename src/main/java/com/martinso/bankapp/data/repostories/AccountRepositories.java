package com.martinso.bankapp.data.repostories;

import com.martinso.bankapp.data.model.Account;
import com.martinso.bankapp.data.model.BankUserDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface AccountRepositories extends MongoRepository<Account, String> {
	Optional<Account> FindByAccName(BankUserDetails ownersName);
}
