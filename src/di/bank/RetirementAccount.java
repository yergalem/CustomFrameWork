package di.bank;

import java.util.List;

import di.lib.Account;
import di.lib.AccountType;
import di.lib.ICustomer;
import di.lib.IEntry;


public class RetirementAccount extends Account {
	public static AccountType acctType; /// Defined by Specialized Accounts
	
	public RetirementAccount() {
		acctType = AccountType.RETIREMENT;
	}

	public RetirementAccount(Long accNumber, List<IEntry> entries, boolean isActive, ICustomer customer) {
		super(accNumber, entries, isActive, customer);
		
	}
	
	@Override
	public double getInterestRate() {
		
		return 0.5;
	}

	@Override
	public AccountType getAcctType() {
		
		return acctType;
	}
}
