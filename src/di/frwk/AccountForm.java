package di.frwk;

import com.google.inject.Inject;

import di.lib.Messenger;

public class AccountForm {

	Messenger manager;
	
	@Inject
	public AccountForm(Messenger _manager) {
		manager = _manager;
	}
	
}
