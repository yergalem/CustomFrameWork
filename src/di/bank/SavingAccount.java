package di.bank;

import java.util.List;

import di.lib.Account;
import di.lib.AccountType;
import di.lib.ICustomer;
import di.lib.IEntry;

public class SavingAccount extends Account {
	public static AccountType acctType; /// Defined by Specialized Accounts
	
	public SavingAccount() {
		acctType = AccountType.SAVING;
	}
	
	public SavingAccount(Long accNumber, List<IEntry> entries, boolean isActive, ICustomer customer) {
		super(accNumber, entries, isActive, customer);
		
	}
	
	@Override
	public void createAccount(){
		
		System.out.println("Creating Saving Account");
	}

	@Override
	public double getInterestRate() {
		
		return 0.3;
	}

	@Override
	public AccountType getAcctType() {
		
		return acctType;
	}
	
}
