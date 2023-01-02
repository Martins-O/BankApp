//package com.martinso.bankapp;
//
//public class JUstOpen {
//	@Override
//	public AccountApiResponse makeDeposit(DepositRequest depositRequest) throws UnsupportedDepositException, AccountNotFoundException {
//		Account depositAccount = accountRepository.findAccountByAccountNumber(depositRequest.getAccountNumber());
//		verifyThatAccountExists(depositAccount);
//		if(!(depositRequest.getAmount() >= 1)){
//			throw new UnsupportedDepositException("Error!!! Amount too low!");
//		}
//
//		if(!( depositRequest.getAmount() <= 1_000_000)){
//			throw new UnsupportedDepositException("Error!!! Amount too high");
//		}
//		depositAccount.setBalance(BigDecimal.valueOf(depositAccount.getBalance().doubleValue() + depositRequest.getAmount()));
//		String transactionDate = generateTransactionDateAndTime();
//		Transaction transaction = Transaction.builder()
//			.id((depositAccount.getTransactionList().size() + 1 )+"")
//			.amount(BigDecimal.valueOf(depositRequest.getAmount()))
//			.transactionType(TransactionType.CREDIT)
//			.narration(depositRequest.getNarration())
//			.remainingBalance(depositAccount.getBalance())
//			.transactDate(transactionDate)
//			.build();
//
//		depositAccount.getTransactionList().add(transaction);
//		return AccountApiResponse.builder()
//			.message("Deposit success")
//			.statusCode(200)
//			.success(true)
//			.build();
//	}
//}
