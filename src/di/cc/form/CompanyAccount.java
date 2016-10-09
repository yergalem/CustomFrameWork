package di.cc.form;

import java.util.Iterator;

import javax.swing.table.DefaultTableModel;

import com.google.inject.Guice;
import com.google.inject.Injector;

import di.cc.CreditAccount;
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

		// Helper.pushControls(this, 40);
		
		JLabel_AccountType.setText("Account Type ");
		getContentPane().add(JLabel_AccountType);
		JLabel_AccountType.setForeground(java.awt.Color.black);
		JLabel_AccountType.setBounds(30, 10, 108, 24);

		JLabel8.setText("CC Number");

		JRadioButton_Gold.setText("Gold");
		JRadioButton_Gold.setActionCommand("Gold");
		JRadioButton_Gold.setSelected(true);
		getContentPane().add(JRadioButton_Gold);
		JRadioButton_Gold.setBounds(36, 10, 84, 24);

		JRadioButton_Silver.setText("Silver");
		JRadioButton_Silver.setActionCommand("Silver");
		getContentPane().add(JRadioButton_Silver);
		JRadioButton_Silver.setBounds(126, 10, 84, 24);

		JRadioButton_Bronze.setText("Bronze");
		JRadioButton_Bronze.setActionCommand("Bronze");
		getContentPane().add(JRadioButton_Bronze);
		JRadioButton_Bronze.setBounds(216, 10, 84, 24);

		JButton_OK.setBounds(48, 284, 84, 24);
		JButton_Cancel.setBounds(156, 284, 84, 24);

		SymMouse aSymMouse = new SymMouse();
		JRadioButton_Gold.addMouseListener(aSymMouse);
		JRadioButton_Silver.addMouseListener(aSymMouse);
		JRadioButton_Bronze.addMouseListener(aSymMouse);
	}

	javax.swing.JLabel JLabel_AccountType = new javax.swing.JLabel();
	javax.swing.JRadioButton JRadioButton_Gold = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Silver = new javax.swing.JRadioButton();
	javax.swing.JRadioButton JRadioButton_Bronze = new javax.swing.JRadioButton();
	javax.swing.JTextField JTextField_ExpDate = new javax.swing.JTextField();
	javax.swing.JLabel JLabel_Email = new javax.swing.JLabel();

	class SymMouse extends java.awt.event.MouseAdapter {
		public void mouseClicked(java.awt.event.MouseEvent event) {
			Object object = event.getSource();
			if (object == JRadioButton_Gold)
				JRadioButton_Gold_mouseClicked(event);
			else if (object == JRadioButton_Silver)
				JRadioButton_Silver_mouseClicked(event);
			else if (object == JRadioButton_Bronze)
				JRadioButton_Bronze_mouseClicked(event);
		}
	}

	void JRadioButton_Gold_mouseClicked(java.awt.event.MouseEvent event) {
		JRadioButton_Gold.setSelected(true);
		JRadioButton_Silver.setSelected(false);
		JRadioButton_Bronze.setSelected(false);
	}

	void JRadioButton_Silver_mouseClicked(java.awt.event.MouseEvent event) {
		JRadioButton_Silver.setSelected(true);
		JRadioButton_Gold.setSelected(false);
		JRadioButton_Bronze.setSelected(false);
	}

	void JRadioButton_Bronze_mouseClicked(java.awt.event.MouseEvent event) {
		JRadioButton_Bronze.setSelected(true);
		JRadioButton_Silver.setSelected(false);
		JRadioButton_Gold.setSelected(false);
	}

	@Override
	protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		Long accountnr = Long.valueOf(JTextField_ACNR.getText());
		String name = JTextField_NAME.getText();
		String street = JTextField_STR.getText();
		String city = JTextField_CT.getText();
		int zip = Integer.parseInt(JTextField_ZIP.getText());
		String state = JTextField_ST.getText();
		String email = JTextField_EM.getText();
		int numberOfEmployees= Integer.parseInt(JTextField_NE.getText());

		String accountTypeBeanId = JRadioButton_Gold.isSelected() ? "goldAccount"
				: JRadioButton_Silver.isSelected() ? "silverAccount" : "bronzeAccount";
		

		Injector injector = AppConfigModule.getInjector();
		Organization customer = injector.getInstance(Organization.class);

		Address addr = injector.getInstance(Address.class);
		Account acct = CreditAccount.createAccount(accountTypeBeanId);
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

		DBHelper.getDBHelperInstance().addCustomer(customer);
		
		Iterator itr = new Account().iterator();
		DefaultTableModel tblModel = HomeGUI.getAcctTableModel();
		
		for(int i=tblModel.getRowCount()-1;i>=0;i--)
		     tblModel.removeRow(i);
		while ( itr.hasNext() ) {
		 
			Object[] data = (Object[]) itr.next();
			tblModel.addRow(data);
		}

		// Cleaner
		JRadioButton_Gold.setSelected(true);
		JRadioButton_Silver.setSelected(false);
		JRadioButton_Bronze.setSelected(false);
		cleaner();
		dispose();
	}

}