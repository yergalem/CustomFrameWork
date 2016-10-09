package di.cc;

import java.util.List;

import di.lib.Account;
import di.lib.AccountType;
import di.lib.ICustomer;
import di.lib.IEntry;

public class BronzeAccount extends Account {
	public static AccountType acctType; /// Defined by Specialized Accounts
	
	public BronzeAccount() {
		acctType = AccountType.BRONZE;
	}
	
	public BronzeAccount(Long accNumber, List<IEntry> entries, boolean isActive, ICustomer customer) {
		super(accNumber, entries, isActive, customer);
		
	}
	
	@Override
	public void createAccount(){
		
		System.out.println("Creating Saving Account");
	}

	@Override
	public double getInterestRate() {
		
		return 0.2;
	}

	@Override
	public AccountType getAcctType() {
		
		return acctType;
	}
	
}
