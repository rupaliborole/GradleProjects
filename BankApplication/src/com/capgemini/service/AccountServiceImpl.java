package com.capgemini.service;

import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.exceptions.InvalidAccountNumberException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;

public class AccountServiceImpl implements AccountService {

	AccountRepository accountRepository;
	
	public AccountServiceImpl(AccountRepository accountRepository)
	{
		this.accountRepository=accountRepository;
	}
	@Override
	public Account createAccount(int accountNumber, int amount) throws InsufficientInitialBalanceException {
		// TODO Auto-generated method stub
		Account account =  new Account();
		account.setAmount(amount);
		account.setAccountNumber(accountNumber);
		
		if(amount <10000)
			throw new InsufficientInitialBalanceException();
		else{
		
			accountRepository.save(account);
			return account;
		}
	}

	@Override
	public int showBalance(int accountNumber) throws InvalidAccountNumberException {
		// TODO Auto-generated method stub
		return 0;
	}

}
