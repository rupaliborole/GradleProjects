package com.capgemini.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.capgemini.exceptions.InsufficientInitialBalanceException;
import com.capgemini.model.Account;
import com.capgemini.repository.AccountRepository;
import com.capgemini.service.AccountService;
import com.capgemini.service.AccountServiceImpl;

import junit.framework.Assert;

public class AccountTest {

	@Mock
	AccountRepository accountRepository;
	
	AccountService accountService;
	
	@Before
	public void setUp()
	{
		MockitoAnnotations.initMocks(this);
		accountService = new AccountServiceImpl(accountRepository);
	}
	
	@Test (expected = InsufficientInitialBalanceException.class)
	public void insufficientBalExceptionTest() throws InsufficientInitialBalanceException
	{
		accountService.createAccount(123456, 100);
		
	}
	@Test
	public void createAccountTest() throws InsufficientInitialBalanceException
	{
		Account account =  new Account();
		account.setAmount(12000);
		account.setAccountNumber(123456);
		
		Mockito.when(accountRepository.save(account)).thenReturn(true);

		Assert.assertEquals(account, accountService.createAccount(123456, 12000));
	}
}
