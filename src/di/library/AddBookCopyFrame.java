package di.library;

import javax.swing.JOptionPane;

import di.lib.Book;
import di.lib.BookCopy;
import di.lib.IAccount;
import di.lib.HomeGUI;

public class AddBookCopyFrame extends javax.swing.JDialog  {
	private static final long serialVersionUID = -2546180258672849618L;

	private Book book;
	int rowIndex;
    public AddBookCopyFrame() {
	}
	public AddBookCopyFrame(Book book, int rowIndex) {
		
		this.book = book;
		this.rowIndex = rowIndex;
		setTitle("Add Book Copy");
		setModal(true);
		getContentPane().setLayout(null);
		setSize(268,126);
		setVisible(false);
		JLabel1.setText("Acc Nr");
		getContentPane().add(JLabel1);
		JLabel1.setForeground(java.awt.Color.black);
		JLabel1.setBounds(12,12,48,24);
		JLabel2.setText("No. Copies");
		getContentPane().add(JLabel2);
		JLabel2.setForeground(java.awt.Color.black);
		JLabel2.setBounds(12,48,48,24);
		JTextField_NAME.setEditable(false);
		getContentPane().add(JTextField_NAME);
		JTextField_NAME.setBounds(84,12,144,24);
		JButton_OK.setText("OK");
		JButton_OK.setActionCommand("OK");
		getContentPane().add(JButton_OK);
		JButton_OK.setBounds(36,84,84,24);
		JButton_Cancel.setText("Cancel");
		JButton_Cancel.setActionCommand("Cancel");
		getContentPane().add(JButton_Cancel);
		JButton_Cancel.setBounds(156,84,84,24);
		getContentPane().add(JTextField_Deposit);
		JTextField_Deposit.setBounds(84,48,144,24);
		//}}
	    JTextField_NAME.setText(book.getIsbn().toString());
	    
		//{{REGISTER_LISTENERS
		SymAction lSymAction = new SymAction();
		JButton_OK.addActionListener(lSymAction);
		JButton_Cancel.addActionListener(lSymAction);
		//}}
	}



	//{{DECLARE_CONTROLS
	javax.swing.JLabel JLabel1 = new javax.swing.JLabel();
	javax.swing.JLabel JLabel2 = new javax.swing.JLabel();
	javax.swing.JTextField JTextField_NAME = new javax.swing.JTextField();
	javax.swing.JButton JButton_OK = new javax.swing.JButton();
	javax.swing.JButton JButton_Cancel = new javax.swing.JButton();
	javax.swing.JTextField JTextField_Deposit = new javax.swing.JTextField();
	//}}


	class SymAction implements java.awt.event.ActionListener
	{
		public void actionPerformed(java.awt.event.ActionEvent event)
		{
			Object object = event.getSource();
			if (object == JButton_OK)
				JButtonOK_actionPerformed(event);
			else if (object == JButton_Cancel)
				JButtonCalcel_actionPerformed(event);
		}
	}

	void JButtonOK_actionPerformed(java.awt.event.ActionEvent event)
	{
		int numberOfCopies = Integer.parseInt(JTextField_Deposit.getText());
		
		BookCopy bkcp = new BookCopy(book,numberOfCopies);
		//bkcp.setCopyNum(numberOfCopies);
		BookCopy[] bb= new BookCopy[1];
		bb[0]=bkcp;
		//book.setCopies(bb);
	//	LibraryFrame.updateRowNumberOfCopies(book, numberOfCopies, rowIndex );
		
		
		BookCopy[] newArr = new BookCopy[book.getCopies().length +numberOfCopies ];
		System.arraycopy(book.getCopies(), 0, newArr, 0, book.getCopies().length);
		newArr[book.getCopies().length] = new BookCopy(book, book.getCopies().length +numberOfCopies, true);
	     book.setCopies(newArr);	
	     
	     LibraryFrame.refreshRows();
	     JOptionPane.showMessageDialog(this, "Successfully Checked In the book Isbn: "+book.getIsbn(), "CheckIn",
					JOptionPane.INFORMATION_MESSAGE);
		
		dispose();
	}

	void JButtonCalcel_actionPerformed(java.awt.event.ActionEvent event)
	{
		dispose();
	}

}