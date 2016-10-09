/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package di.lib;

import java.util.List;

public class AccountFacade {

	IAccount account;
	ICustomer customer;

	public AccountFacade() {
		account = new Account();
		customer = new Person();

	}

	public static ICustomer findCutomerByAccount(Long accountNo) {
		
		 IAccount accountFound  = Account.searchAccount(accountNo);
		 
		 return accountFound.getCustomer();
		 
	}
	
	public static String getCustomerCategory(Long accountNo ) {
		
		 IAccount accountFound  = Account.searchAccount(accountNo);
		 
		 ICustomer customer = accountFound.getCustomer();
		 
		 return customer.getType();
		 
	}

	public IEntry addEntry(double amount) {
		return account.addEntry(amount);
	}

	public List<IEntry> getEntries() {
		return account.getEntries();
	}

	public void deposit(double amount) {
		account.deposit(amount);
	}

	public void withdraw(double amount) {
		account.withdraw(amount);
	}

	public double getBalance() {
		return account.getBalance();
	}

	public double getInterestRate() {
		return account.getInterestRate();
	}

	public AccountType getAcctType() {
		return account.getAcctType();
	}

}
