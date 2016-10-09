package di.bank;

import com.google.inject.Guice;
import com.google.inject.Injector;

import di.frwk.Koin;

public class Bank extends Koin {

	@Override
	protected void init() {
		title = "MedWest Bank";
		rootDir = "di.bank";	
	}

	

	@Override
    public String[] getColumns(){	
		return new String[]{"Accout No.","Cust. Name", "City","Zip","Cust. Type","Acct Type","Balance"};
	}
	
	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new BnkConfig());
		Koin bnk = injector.getInstance(Koin.class);
		bnk.start();
	}
}
