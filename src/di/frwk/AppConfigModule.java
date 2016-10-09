package di.frwk;

import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import di.bank.Bank;
import di.cc.CCard;
import di.lib.Account;
import di.lib.CompanyAccountGUI;
import di.lib.PersonalAccountGUI;
import di.lib.Address;
import di.lib.IAccount;
import di.lib.IAddress;
import di.lib.ICustomer;
import di.lib.Person;
import di.library.Library;

public class AppConfigModule extends AbstractModule {

	public static Injector injector = null;
    
	private  AppConfigModule() { }
	
	@Override
	protected void configure() {
		
		bind(IAccount.class).to(Account.class);
		bind(IAddress.class).to(Address.class);
		bind(ICustomer.class).to(Person.class);
		
		if (Koin.getActiveApp() instanceof Bank) {

			bind(PersonalAccountGUI.class).to(di.bank.form.PersonalAccount.class);
			bind(CompanyAccountGUI.class).to(di.bank.form.CompanyAccount.class);
			
		} else if (Koin.getActiveApp() instanceof CCard) {

			bind(PersonalAccountGUI.class).to(di.cc.form.PersonalAccount.class);
			bind(CompanyAccountGUI.class).to(di.cc.form.CompanyAccount.class);
			
		}
	}

	public static Injector getInjector() {
		if (injector == null) {
			synchronized (AppConfigModule.class) {
				if (injector == null)
					injector = Guice.createInjector(new AppConfigModule());
			}
		}

		return injector;
	}
}