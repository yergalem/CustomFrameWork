package di.cc;

import java.util.List;

import di.lib.Account;
import di.lib.AccountType;
import di.lib.ICustomer;
import di.lib.IEntry;

public class SilverAccount extends Account {
	public static AccountType acctType; /// Defined by Specialized Accounts
	
	public SilverAccount() {
		acctType = AccountType.SILVER;
	}

	public SilverAccount(Long accNumber, List<IEntry> entries, boolean isActive, ICustomer customer) {
		super(accNumber, entries, isActive, customer);
		
	}
	
	@Override
	public double getInterestRate() {
		
		return 0.25;
	}

	@Override
	public AccountType getAcctType() {
		
		return acctType;
	}
}
