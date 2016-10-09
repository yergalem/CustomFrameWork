package di.bank;

import di.cc.BronzeAccount;
import di.cc.GoldAccount;
import di.cc.SilverAccount;
import di.lib.Account;

public class BankAccount extends Account {
	
	private static Account acctCat;
	
	
	public static Account createAccount(String acct) {

		switch (acct) {
		case "saving":
			acctCat = new SavingAccount();
			break;

		case "checking":
			acctCat = new CheckingAccount();
			break;
		case "retirement":
			acctCat = new RetirementAccount();
			break;

		default:
			break;

		}

		return acctCat;
	}

	public static Account getAcctCat() {
		return acctCat;
	}	
}
