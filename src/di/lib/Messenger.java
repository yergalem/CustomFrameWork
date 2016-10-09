package di.lib;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

import com.google.inject.Inject;

import di.frwk.AppConfigModule;

interface Command {
	void execute();
}

public interface Messenger { //Messenger {
	void registerDisplay(LblMessage d);
	
	public void registerAddPAcct(BtnAddPersonalAccnt v);
    public void registerDepoist(BtnDeposit d) ;
    public void registerWithdraw(BtnWithdraw b);
    public void registerCAcct(BtnAddCompanyAccnt c) ;
    
    public void addPersonalAccount();
    public void addCustomerAccount();
    public void withdraw();
    public void deposit();
    
}

class AccountMessenger implements Messenger {

	BtnAddPersonalAccnt btnAddPAcct;
	BtnDeposit btnDepoist;
	BtnWithdraw btnWithdraw;
	BtnAddCompanyAccnt btnCAcct;
    LblMessage msgLbl;

  
    public void registerAddPAcct(BtnAddPersonalAccnt v) {
    	btnAddPAcct = v;
    }

    public void registerDepoist(BtnDeposit d) {
    	btnDepoist = d;
    }

    public void registerWithdraw(BtnWithdraw b) {
    	btnWithdraw = b;
    }
 
    public void registerCAcct(BtnAddCompanyAccnt c) {
    	btnCAcct = c;
    }

    public void registerDisplay(LblMessage d) {
    	msgLbl = d;
    }

	@Override
	public void addPersonalAccount() {
		msgLbl.setText(" Personal Account Added!");
	}

	@Override
	public void addCustomerAccount() {
		msgLbl.setText(" Company Account Added! ");
	}

	@Override
	public void withdraw() {
		msgLbl.setText(" You're Withdrawing! Select from the data below");
	}

	@Override
	public void deposit() {
		msgLbl.setText(" You're Depositing! Select from the data below");
	}

 
    
}


class BtnView extends JButton implements Command {

	// Mediator med;

	BtnView(ActionListener al) {
		super("View");
		addActionListener(al);
		// med = m;
		// med.registerView(this);
	}

	public void execute() {
		// med.view();
	}

}

class BtnSearch extends JButton implements Command {

	// Mediator med;

	BtnSearch(ActionListener al, Messenger m) {
		super("Search");
		addActionListener(al);
		// med = m;
		// med.registerSearch(this);
	}

	public void execute() {
		// med.search();
	}

}

class BtnAcctCreate extends JButton implements Command {

	Account acct;

	BtnAcctCreate(ActionListener al, Account _acct) {
		super("New Account");
		addActionListener(al);
		acct = _acct;
	}

	public void execute() {
		acct.createAccount();
	}

}

class BtnAcctSelect extends JRadioButton implements Command {

	Account acct;

	BtnAcctSelect(ActionListener al, Account _acct) {

		addActionListener(al);
		acct = _acct;
	}

	public void execute() {
		acct.createAccount();
	}

}

class BtnTxt extends JRadioButton implements Command {

	Account acct;

	BtnTxt(ActionListener al, Account _acct) {

		addActionListener(al);
		acct = _acct;
	}

	public void execute() {
		acct.createAccount();
	}

}

class BtnAddPersonalAccnt extends JButton implements Command {

	static PersonalAccountGUI addAcctFrm;
	Messenger med;
	
	BtnAddPersonalAccnt(ActionListener a1, Messenger m) {
		AppConfigModule.getInjector().getInstance(BtnAddPersonalAccnt.class);
		addActionListener(a1);
		med = m;
		med.registerAddPAcct(this);

	}

	@Inject
	public BtnAddPersonalAccnt(PersonalAccountGUI _addAcctFrame) {
		addAcctFrm = _addAcctFrame;
	}

	BtnAddPersonalAccnt() {
		setText(" Create Personal Account");

	}

	public void execute() {

		addAcctFrm.setTitle(" Create Personal Account");
		addAcctFrm.setSize(new Dimension(310, 400));
		addAcctFrm.setModal(true);
		addAcctFrm.setVisible(true);
		med.addPersonalAccount();
	}

}

class BtnAddCompanyAccnt extends JButton implements Command {

	static CompanyAccountGUI addAcctFrm;
	Messenger med;
	
	BtnAddCompanyAccnt(ActionListener a1, Messenger m) {
		AppConfigModule.getInjector().getInstance(BtnAddCompanyAccnt.class);
		addActionListener(a1);
        med = m;
        med.registerCAcct(this);
	}

	@Inject
	public BtnAddCompanyAccnt(CompanyAccountGUI _addAcctFrame) {
		addAcctFrm = _addAcctFrame;
	}

	BtnAddCompanyAccnt() {
		setText("Add Company Account");

	}

	public void execute() {

		addAcctFrm.setTitle(" Create Company Account");
		addAcctFrm.setSize(new Dimension(310, 400));
		addAcctFrm.setModal(true);
		addAcctFrm.setVisible(true);
		med.addCustomerAccount();
	}

}

class BtnDeposit extends JButton implements Command {

	Messenger med;
	
	@Inject
	public BtnDeposit(ActionListener al, Messenger m) {
		addActionListener(al);
		med = m;
		med.registerDepoist(this);
	}

	BtnDeposit() {
		setText("Deposit");

	}

	public void execute() {

		int selection = HomeGUI.getAccountTable().getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			IAccount account = DBHelper.getAllAccounts().get(selection);
			JDialog dep = new DepositFrame(account, selection);

			dep.setTitle("Deposit Entry");

			dep.setBounds(480, 145, 325, 200);
			dep.setVisible(true);
		}
		
		med.deposit();
	}
}

class BtnWithdraw extends JButton implements Command {

	Messenger med;
	
	//@Inject
	public BtnWithdraw(ActionListener al , Messenger m) {
		addActionListener(al);
		med = m;
		med.registerWithdraw(this);
	}

	BtnWithdraw() {
		setText("Withdraw");

	}

	public void execute() {

		int selection = HomeGUI.getAccountTable().getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			IAccount account = DBHelper.getAllAccounts().get(selection);
			JDialog dep = new WithdrawFrame(account, selection);

			dep.setTitle("Withdraw Entry");

			dep.setBounds(480, 145, 325, 200);
			dep.setVisible(true);
		}
		
		med.withdraw();
	}
}

class BtnAddInterest extends JButton implements Command {

	Messenger med;
	@Inject
	public BtnAddInterest(ActionListener al) {
		addActionListener(al);
	}

	BtnAddInterest() {
		setText("Withdraw");

	}

	public void execute() {

		int selection = HomeGUI.getAccountTable().getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			IAccount account = DBHelper.getAllAccounts().get(selection);
			if (account.getBalance() > 0) {
				account.addInterest();
				HomeGUI.refreshRows();
				JOptionPane.showMessageDialog(this, "Successfully Interest added", "Add Interest",
						JOptionPane.WARNING_MESSAGE);
			} else
				JOptionPane.showMessageDialog(this,
						"Sorry, Interest is not added \n Your Balance is " + account.getBalance(), "Add Interest",
						JOptionPane.WARNING_MESSAGE);
		}
	}
}


class BtnExit extends JButton implements Command {

	@Inject
	public BtnExit(ActionListener al) {
		addActionListener(al);
	}

	BtnExit() {
		setText("Exit");

	}

	public void execute() {
		System.exit(0);
	}
}

class LblMessage extends JLabel {

	Messenger med;
    static StatusLabel lblMsg = new LblMessageDecorator ( (new PlainStatusLabel()));
    static String msg = lblMsg.getDescription();
    
	LblMessage(Messenger m) {
		
		super(msg);
		 med = m;
		 med.registerDisplay(this);
		 setFont(new Font("Arial", Font.BOLD, 14));
	}

}
