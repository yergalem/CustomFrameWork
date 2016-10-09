package di.library;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import di.frwk.Koin;
import di.lib.Book;
import di.lib.BookCopy;
import di.lib.DBHelper;
import di.lib.IAccount;

public class LibraryFrame extends javax.swing.JFrame implements ActionListener {
	private static final long serialVersionUID = -281321034122568665L;

	protected static DefaultTableModel acctTableModel;

	public LibraryFrame(String title) {
		super(title);
        
		acctTableModel = new DefaultTableModel();
		populateTableHeader();
		populateTableData();
		

		accountTable = new JTable();
		getContentPane().setLayout(new BorderLayout(0, 0));
		setSize(725, 340);
		setBounds(300, 100, 725, 340);
		setVisible(false);
		JPanel1.setLayout(null);
		getContentPane().add(BorderLayout.CENTER, JPanel1);
		JPanel1.setBounds(0, 0, 705, 340);

		/*
		 * /Add five buttons on the pane /for Adding personal account, Adding
		 * company account /Deposit, Withdraw and Exit from the system
		 */
		JScrollPane1 = new JScrollPane();

		JPanel1.add(JScrollPane1);
		JScrollPane1.setBounds(22, 92, 550, 167);
		JScrollPane1.getViewport().add(accountTable);
		// JTable1.setBounds(10, 20, 620, 0);
		accountTable.setModel(acctTableModel);
		accountTable.setMinimumSize(new Dimension(600, 350));
		accountTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		
		PerAC.setText("Add Book");
		JPanel1.add(PerAC);
		PerAC.setBounds(24, 20, 192, 33);
		CompAC.setText("Add Book copy");
		CompAC.setActionCommand("jbutton");
		JPanel1.add(CompAC);
		CompAC.setBounds(240, 20, 192, 33);
		Deposit.setText("Check In");
		JPanel1.add(Deposit);
		Deposit.setBounds(588, 94, 96, 33);
		Withdraw.setText("Check Out");
		JPanel1.add(Withdraw);
		Withdraw.setBounds(588, 160, 96, 33);
		Addinterest.setBounds(448, 20, 106, 33);
		Addinterest.setText("Penalty");
		JPanel1.add(Addinterest);
		Exit.setText("Exit");
		JPanel1.add(Exit);
		Exit.setBounds(588, 224, 96, 31);

		PerAC.setActionCommand("jbutton");
		
		ActionSelector lSymAction = new ActionSelector();
		Exit.addActionListener(lSymAction);
		PerAC.addActionListener(lSymAction);
		CompAC.addActionListener(lSymAction);
		Deposit.addActionListener(lSymAction);
		Withdraw.addActionListener(lSymAction);
		Addinterest.addActionListener(lSymAction);

		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	protected static JTable accountTable;
	private JScrollPane JScrollPane1;
	
	protected javax.swing.JPanel JPanel1 = new javax.swing.JPanel();

	JButton PerAC = new JButton();
	JButton CompAC = new JButton();
	JButton Deposit  = new JButton();
	protected javax.swing.JButton Withdraw = new JButton();
	JButton Addinterest = new JButton();
	JButton Exit = new JButton();

	
	class ActionSelector implements ActionListener {
		public void actionPerformed( ActionEvent event) {
			Object object = event.getSource();
			if (object == Exit)
				Exit_actionPerformed(event);
			else if (object == PerAC)
				PerAcct_actionPerformed(event);
			else if (object == CompAC)
				CompAcct_actionPerformed(event);
			else if (object == Deposit)
				Deposit_actionPerformed(event);
			else if (object == Withdraw)
				Withdraw_actionPerformed(event);
			else if (object == Addinterest)
				AddInterest_actionPerformed(event);

		}
	}

	
	void Exit_actionPerformed(java.awt.event.ActionEvent event) {
		System.exit(0);
	}

	protected void PerAcct_actionPerformed(java.awt.event.ActionEvent event) {
		JDialog addBook = new AddBookFrame();
		addBook.setBounds(450, 20, 300, 330);
		addBook.setVisible(true);
	}

	protected void CompAcct_actionPerformed(java.awt.event.ActionEvent event) {
		
		int selection = getAccountTable().getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			Book book = DBHelper.getBooks().get(selection);
			
			JDialog dep = new AddBookCopyFrame(book, selection);
            
			dep.setTitle("Deposit Entry");

			dep.setBounds(480, 145, 325, 200);
			dep.setVisible(true);
			
			System.out.println("hjkfddgghfggggggggggggg");
		}
		
	}

	protected void Deposit_actionPerformed(java.awt.event.ActionEvent event) {
		

		int selection = getAccountTable().getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			Book book = DBHelper.getBooks().get(selection);
		            
			BookCopy bk=new BookCopy();
			
			BookCopy[] newArr = new BookCopy[book.getCopies().length + 1];
			System.arraycopy(book.getCopies(), 0, newArr, 0, book.getCopies().length);
			newArr[book.getCopies().length] = new BookCopy(book, book.getCopies().length +1, true);
		     book.setCopies(newArr);	
		     
		     refreshRows();
		     JOptionPane.showMessageDialog(this, "Successfully Checked In the book Isbn: "+book.getIsbn(), "CheckIn",
						JOptionPane.INFORMATION_MESSAGE);
		}

	}

	protected void Withdraw_actionPerformed(java.awt.event.ActionEvent event) {
		
		int selection = getAccountTable().getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			Book book = DBHelper.getBooks().get(selection);
		    
			if(book.getNumCopies()>0){
		 			
			BookCopy[] newArr = new BookCopy[book.getCopies().length-1];
			System.arraycopy(book.getCopies(), 1, newArr, 0, book.getCopies().length-1);
		     book.setCopies(newArr);	
		     
		     refreshRows();
		     JOptionPane.showMessageDialog(this, "Successfully Checkout book Isbn :"+book.getIsbn(), "Checkout",
						JOptionPane.INFORMATION_MESSAGE);
		  }
			else
			  JOptionPane.showMessageDialog(this, "Sorry, There is no enough book copies", "Checkout",
						JOptionPane.ERROR_MESSAGE);
		}

	}

	void AddInterest_actionPerformed(java.awt.event.ActionEvent event) {
		int selection = getAccountTable().getSelectionModel().getMinSelectionIndex();
		if (selection >= 0) {
			Book book = DBHelper.getBooks().get(selection);
			
			JDialog dep = new AddBookCopyFrame(book, selection);

			dep.setTitle("Add Book Copy Entry");

			dep.setBounds(480, 145, 325, 200);
			dep.setVisible(true);
			
			if (book.getPrice() > 0) {
				book.addPrice();
				refreshRows();
				JOptionPane.showMessageDialog(this, "Successfully Price added", "Add Price",
						JOptionPane.WARNING_MESSAGE);
			} else
				JOptionPane.showMessageDialog(this,
						"Sorry, Price is not added \n Your Price is " + book.getPrice(), "Add Price",
						JOptionPane.WARNING_MESSAGE);
		}
		
		
		
	}

	
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		//Command comd = (Command) ae.getSource();
		//comd.execute();
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

		Iterator itr = DBHelper.getBooks().iterator();
	
		while (itr.hasNext()) {

			Book b = (Book) itr.next();
			addRow(b);
		
		}
	}
	
	public static void addRow(Book book) {
		//ICustomer customer = account.getCustomer();
		//IAddress address = customer.getAddress();
		
		DefaultTableModel tblModel = LibraryFrame.getAcctTableModel();
		Object rowdata[] = new Object[tblModel.getColumnCount()];
		rowdata[0] = book.getIsbn();
		rowdata[1] = book.getTitle();
		rowdata[2] = book.getAuthors();
		rowdata[3] = book.getPublisher();
		rowdata[4] = book.getNumCopies();
		rowdata[5] = book.getBorrowedDate();
		rowdata[6] = book.getPrice();
		tblModel.addRow(rowdata);
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
	
	
}