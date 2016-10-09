package di.lib;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import di.frwk.Koin;

public class HomeGUI extends javax.swing.JFrame implements ActionListener {
	private static final long serialVersionUID = -281321034122568665L;

	protected static DefaultTableModel acctTableModel;
    private AccountMessenger  msger = new AccountMessenger();
    
	public HomeGUI(String title) {
		super(title);

		acctTableModel = new DefaultTableModel();
		populateTableHeader();
		populateTableData();
		

		accountTable = new JTable();

		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(725, 370);
		setBounds(300, 100, 725, 370);
		
		getContentPane().add(new LblMessage(msger), "North");
		
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0, 0, 705, 340);

			
		JScrollPane1 = new JScrollPane();

		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(22, 92, 550, 167);
		JScrollPane1.getViewport().add(accountTable);
		accountTable.setModel(acctTableModel);
		accountTable.setMinimumSize(new Dimension(600, 350));
		accountTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		PerAC.setText(" Create Personal Account");
		JPanel1.add(PerAC);
		PerAC.setBounds(24, 20, 192, 33);
		CompAC.setText("Create Company Account");
		CompAC.setActionCommand("jbutton");
		JPanel1.add(CompAC);
		CompAC.setBounds(240, 20, 192, 33);
		Deposit.setText("Deposit");
		JPanel1.add(Deposit);
		Deposit.setBounds(588, 94, 96, 33);
		Withdraw.setText("Withdraw");
		JPanel1.add(Withdraw);
		Withdraw.setBounds(588, 160, 96, 33);
		Addinterest.setBounds(448, 20, 106, 33);
		Addinterest.setText("Add interest");
		JPanel1.add(Addinterest);
		Exit.setText("Exit");
		JPanel1.add(Exit);
		Exit.setBounds(588, 224, 96, 31);

		PerAC.setActionCommand("jbutton");
      
		
		setVisible(true);
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}

	protected static JTable accountTable;
	private JScrollPane JScrollPane1;
	
	protected JPanel JPanel1 = new JPanel();
    
	
	JButton Withdraw = new BtnWithdraw(this, msger);
	JButton Addinterest = new BtnAddInterest(this);
	JButton Exit = new BtnExit(this);
	JButton PerAC = new BtnAddPersonalAccnt(this, msger);
	JButton CompAC = new BtnAddCompanyAccnt(this , msger);
	JButton Deposit  = new BtnDeposit(this , msger);
		
	@Override
	public void actionPerformed(ActionEvent ae) {
		Command comd = (Command) ae.getSource();
		comd.execute();
	}

	public void populateTableHeader() {
		
		String[] cols = Koin.getActiveApp().getColumns();
		for (String header : cols) {
			acctTableModel.addColumn(header);

		}
	}
	
	public static void populateTableData() {
		refreshRows();
	}

	public static DefaultTableModel getAcctTableModel() {
		return acctTableModel;
	}

	public static void refreshRows() {
		if (acctTableModel.getRowCount() > 0) {
			for (int i = acctTableModel.getRowCount() - 1; i > -1; i--) {
				acctTableModel.removeRow(i);
			}
		}

		Iterator itr = new Account().iterator();
		DefaultTableModel tblModel = getAcctTableModel();

		while (itr.hasNext()) {

			Object[] data = (Object[]) itr.next();
			tblModel.addRow(data);

		}
	}

	public static void updateRowAmount(IAccount account, double amount, int rowIndex) {
		int ammountColIndex = acctTableModel.findColumn("Balance");
		double newamount = (double) acctTableModel.getValueAt(rowIndex, ammountColIndex) + amount;
		acctTableModel.setValueAt(newamount, rowIndex, ammountColIndex);
		if (amount < 0 && newamount < 0) {
			JOptionPane
					.showMessageDialog(null,
							" Account " + account.getAccNumber() + " : balance is negative: $"
									+ String.valueOf(newamount) + " !",
							"Warning: negative balance", JOptionPane.WARNING_MESSAGE);
		}
	}

	public static JTable getAccountTable() {
		return accountTable;
	}
	
	public static Long generateAccountNumber() {
			return DBHelper.getMaxAccountNumber() + 1;	
	}

	
}