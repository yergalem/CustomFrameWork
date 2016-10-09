package di.cc;

import com.google.inject.Guice;
import com.google.inject.Injector;

import di.frwk.Koin;

public class CCard extends Koin {

	@Override
	protected void init() {
		title = "MicroFinance Project";
	}

	
	@Override
	 public String[] getColumns(){	
			return new String[]{"Accout No.","Cust. Name", "City","Zip","Cust. Type","Acct Type","Balance"};
	}

	public static void main(String[] args) {
		Injector injector = Guice.createInjector(new CreditConfig());
		Koin temp = injector.getInstance(Koin.class);
		temp.start();
	}
}
