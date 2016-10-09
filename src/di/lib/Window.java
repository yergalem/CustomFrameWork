package di.lib;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import di.bank.Bank;
import di.cc.CCard;
import di.frwk.Koin;
import di.library.Library;
import di.library.LibraryFrame;

public class Window extends javax.swing.JFrame implements ActionListener {

	public void actionPerformed(ActionEvent ae) {
		Command comd = (Command) ae.getSource();
		comd.execute();
	}
	
    
	public void display(String title) {
		setTitle(title);
		
		if(Koin.getActiveApp() instanceof Library )
			new di.library.LibraryFrame(title);
		else if(Koin.getActiveApp() instanceof Bank )
			new di.bank.form.UserLoginForm();
		else if(Koin.getActiveApp() instanceof CCard )
			new di.cc.form.UserLoginForm();		
		
		
	}
	//@Inject
	//private void openWin(Home home) {}

}
