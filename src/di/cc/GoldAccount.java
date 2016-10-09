package di.cc;

import java.util.List;

import di.lib.Account;
import di.lib.AccountType;
import di.lib.ICustomer;
import di.lib.IEntry;

public class GoldAccount extends Account {
	public static AccountType acctType; /// Defined by Specialized Accounts
	
	public GoldAccount( ) {
		acctType = AccountType.GOLD;
	}
	
	@Override
	public void createAccount(){
		
		System.out.println("Creating Checking Account");
	}

	public GoldAccount(Long accNumber, List<IEntry> entries, boolean isActive, ICustomer customer) {
		super(accNumber, entries, isActive, customer);
		
	}

	@Override
	public AccountType getAcctType() {
		return acctType;
	}
	@Override
	public double getInterestRate() {
		
		return 0.35;
	}

	

}
