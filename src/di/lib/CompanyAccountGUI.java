package di.lib;

public class CompanyAccountGUI extends javax.swing.JDialog {
	private static final long serialVersionUID = 6896307053396115556L;

	public CompanyAccountGUI() {
		
		setTitle("Add Personal Account");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(283, 303);
		setBounds(470, 125, 283, 303);
		setVisible(false);
		
		JLabel1.setText("Name");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(30, 74, 58, 24);
		JLabel2.setText("Street");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(30, 98, 58, 24);
		JLabel3.setText("City");
		getContentPane().add(JLabel3);
		JLabel3.setForeground(java.awt.Color.black);
		JLabel3.setBounds(30, 122, 48, 24);
		JLabel4.setText("State");
		getContentPane().add(JLabel4);
		JLabel4.setForeground(java.awt.Color.black);
		JLabel4.setBounds(30, 146, 48, 24);
		JLabel5.setText("Zip");
		getContentPane().add(JLabel5);
		JLabel5.setForeground(java.awt.Color.black);
		JLabel5.setBounds(30, 170, 48, 24);
		JLabel6.setText("No. Emp");
		getContentPane().add(JLabel6);
		JLabel6.setForeground(java.awt.Color.black);
		JLabel6.setBounds(30, 194, 96, 24);
		JLabel7.setText("Email");
		getContentPane().add(JLabel7);
		JLabel7.setForeground(java.awt.Color.black);
		JLabel7.setBounds(30, 218, 48, 24);
		
		
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(104, 74, 156, 20);
		getContentPane().add(JTextField_CT);
		JTextField_CT.setBounds(104, 122, 156, 20);
		getContentPane().add(JTextField_ST);
		JTextField_ST.setBounds(104, 146, 156, 20);
		getContentPane().add(JTextField_STR);
		JTextField_STR.setBounds(104, 98, 156, 20);
		getContentPane().add(JTextField_ZIP);
		JTextField_ZIP.setBounds(104, 170, 156, 20);
		getContentPane().add(JTextField_NE);
		JTextField_NE.setBounds(104, 194, 156, 20);
		
		getContentPane().add(JTextField_EM);
		JTextField_EM.setBounds(104, 218, 156, 20);
		


		
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(48, 254, 84, 24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156, 254, 84, 24);
		
//		getContentPane().add(JTextField_ACNR);
//		JTextField_ACNR.setBounds(104, 50, 156, 20);
//		JTextField_ACNR.setText(MainFrame.generateAccountNumber().toString());
//		JTextField_ACNR.setEditable(false);
//		JLabel8.setText("Acc Nr");
//		getContentPane().add(JLabel8);
//		JLabel8.setForeground(java.awt.Color.black);
//		JLabel8.setBounds(30, 50, 68, 24);
		// }}

		// {{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
		// }}
	}

	// {{DECLARE_CONTROLS
	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel3 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel4 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel5 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel6 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel7 = new javax.swing.JLabel();
	javax.swing.JLabel JLabelNE = new javax.swing.JLabel();
	protected javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_CT = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_ST = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_STR = new javax.swing.JTextField();
	protected javax.swing.JTextField JTextField_ZIP = new javax.swing.JTextField();

	protected javax.swing.JTextField JTextField_EM = new javax.swing.JTextField();
	protected javax.swing.JButton JButton_OK = new javax.swing.JButton();
	protected javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
	protected javax.swing.JTextField JTextField_ACNR = new javax.swing.JTextField();
	protected javax.swing.JLabel JLabel8 = new javax.swing.JLabel();
	
	protected javax.swing.JTextField JTextField_NE = new javax.swing.JTextField();
	
	// }}

	class SymAction implements java.awt.event.ActionListener {
		public void actionPerformed(java.awt.event.ActionEvent event) {
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	protected void JButtonOK_actionPerformed(java.awt.event.ActionEvent event) {
		
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event) {
		// make this frame invisible if Cancel button is clicked
		dispose();
	}
	
  public void cleaner(){
	  JTextField_NAME.setText(""); 
	  JTextField_CT.setText(""); 
	  JTextField_ST.setText(""); 
	  JTextField_STR.setText(""); 
	  JTextField_ZIP.setText(""); 
	  JTextField_ACNR.setText(""); 
	  JTextField_EM.setText(""); 
	  JTextField_NE.setText(""); 
  }
  
//  public static Long generateAccountNumber() {
//		System.out.println(DBHelper.getMaxAccountNumber());
//		return DBHelper.getMaxAccountNumber() + 1;	
//	}
    
}
