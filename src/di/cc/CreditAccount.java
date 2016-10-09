package di.cc;

import di.lib.Account;

public class CreditAccount extends Account {

private static Account acctCat;
	

	public static Account createAccount(String acct) {

		switch (acct) {
		
		case "goldAccount":
			acctCat = new GoldAccount();
			break;

		case "silverAccount":
			acctCat = new SilverAccount();
			break;
		case "bronzeAccount":
			acctCat = new BronzeAccount();
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
