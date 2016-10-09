package di.frwk;

import com.google.inject.AbstractModule;

import di.lib.PersonalAccountGUI;
import di.lib.IAccount;
import di.lib.IAddress;
import di.lib.ICustomer;

public class CCAccountModule extends AbstractModule {

	  @Override
	  protected void configure() {
//	    bind(Mediator.class).to(di.lib.BankAccountMediator.class);
		bind(IAccount.class).to(di.lib.Account.class);
	    bind(IAddress.class).to(di.lib.Address.class);
	    bind(ICustomer.class).to(di.lib.Person.class);
	    bind(PersonalAccountGUI.class).to(di.bank.form.PersonalAccount.class);
	   
	  }
	}
