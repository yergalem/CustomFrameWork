package di.bank.form;


import com.google.inject.Injector;

import di.bank.BankAccount;
import di.frwk.AppConfigModule;
import di.lib.Account;
import di.lib.CompanyAccountGUI;
import di.lib.Address;
import di.lib.DBHelper;
import di.lib.HomeGUI;
import di.lib.Organization;

public class CompanyAccount extends CompanyAccountGUI {
	private static final long serialVersionUID = 7926689701576982786L;

	public CompanyAccount() {
		
		
		
		JLabel_AccountType.setText("Account Type ");
		getContentPane().add(JLabel_AccountType);
		JLabel_AccountType.setForeground(java.awt.Color.black);
		JLabel_AccountType.setBounds(30, 10, 108, 24);
		
		JRadioButton_Chk.setText("Checkings");
		JRadioButton_Chk.setActionCommand("Checkings");
		JRadioButton_Chk.setSelected(true);
		getContentPane().add(JRadioButton_Chk);
		JRadioButton_Chk.setBounds(120, 10, 104, 24);
		JRadioButton_Sav.setText("Savings");
		JRadioButton_Sav.setActionCommand("Savings");
		getContentPane().add(JRadioButton_Sav);
		JRadioButton_Sav.setBounds(120, 34, 104, 24);
		
		SymMouse aSymMouse = new SymMouse();
		JRadioButton_Chk.addMouseListener(aSymMouse);
		JRadioButton_Sav.addMouseListener(aSymMouse);
	}
	
	javax.swing.JLabel JLabel_AccountType = new javax.swing.JLabel();
	javax.swing.JRadioButton JRadioButton_Chk = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Sav = new javax.swing.JRadioButton();

	class SymMouse extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			Object object = event.getSource();
			if (object == JRadioButton_Chk)
				JRadioButtonChk_mouseClicked(event);
			else if (object == JRadioButton_Sav)
				JRadioButtonSav_mouseClicked(event);
		}
	}

	void JRadioButtonChk_mouseClicked(java.awt.event.MouseEvent event) {
		// When Checking radio is clicked make this radio on
		// and make Saving account radio off
		JRadioButton_Chk.setSelected(true);
		JRadioButton_Sav.setSelected(false);
	}

	void JRadioButtonSav_mouseClicked(java.awt.event.MouseEvent event) {
		// When Saving radio is clicked make this radio on
		// and make Checking account radio off
		JRadioButton_Chk.setSelected(false);
		JRadioButton_Sav.setSelected(true);

	}
    @Override
	protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		Long accountnr = HomeGUI.generateAccountNumber();//Long.valueOf(JTextField_ACNR.getText());
		String name = JTextField_NAME.getText();
		String street = JTextField_STR.getText();
		String city = JTextField_CT.getText();
		int zip = Integer.parseInt(JTextField_ZIP.getText());
		String state = JTextField_ST.getText();
		String email = JTextField_EM.getText();
		int numberOfEmployees= Integer.parseInt(JTextField_NE.getText());
		String accountTypeBeanId = JRadioButton_Chk.isSelected() ? "checking" : "saving";
	
		
		Injector injector = AppConfigModule.getInjector();
		Organization customer = injector.getInstance(Organization.class);
		
		Address addr = injector.getInstance(Address.class);
		Account acct = BankAccount.createAccount(accountTypeBeanId);;
			
		addr.setCity(city);
		addr.setState(state);
		addr.setZip(zip);
		addr.setStreet(street);
		
		acct.setAccNumber(accountnr);
		acct.setIsActive(true);
	    
		customer.setAddress(addr);
		customer.setName(name);
		customer.setEmail(email);
		customer.setIsActive(true);
		customer.setNumberOfEmployees(numberOfEmployees);
		customer.addAccount(acct);
		
		acct.setCustomer(customer);
		
		DBHelper.getDBHelperInstance();
		DBHelper.addCustomer(customer);
				

		HomeGUI.populateTableData();
		
		// Cleaner
		JRadioButton_Chk.setSelected(true);
		JRadioButton_Sav.setSelected(false);
		cleaner();
		dispose();
	}
	
    public static String[] getColumns() {

		return new String[] { "Accout No.", "Customer Name", "City", "No Employee", "Customer Type", "Account Type","Balance"};
	}

}