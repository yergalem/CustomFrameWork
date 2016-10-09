package di.bank.form;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;


import di.frwk.FormValidator2;
import di.lib.DBHelper;

public class UserRegistration extends FormValidator2  {


    	List<String> lableTxtList = new ArrayList<>();
        List<JTextField> txtFieldList = new ArrayList<>();
        JFrame userFrame = new JFrame("CREDIT UNION USER REGISTRATION FORM");
        JLabel title, firstnameLabel, lastnameLabel, genderLabel, usernameLabel, passwordLabel,ageLabel;
        JTextField firstnameField, lastnameField, genderField, usernameField, passwordField,ageField;
        JButton registerButton, exitButton, updateButton, deleteButton, resetButton,  refresh;
         
        JRadioButton male, female;
        ButtonGroup bg;

        JPanel panel;
        JTable table;
        DefaultTableModel model;
        JScrollPane scrollpane;

        public UserRegistration() {
            // TODO Auto-generated constructor stub
        	
        	
        	userFrame.setTitle("User Registration -- Bank");
        	userFrame.setSize(470, 420);
        	userFrame.setLayout(null);

            title = new JLabel("Registration Form");

            refreshTxtFieldList(new ArrayList<>());
            
            title.setBounds(60, 7, 200, 30);
            firstnameLabel = new JLabel("FirstName");
            firstnameLabel.setBounds(30, 50, 60, 30);
            lastnameLabel = new JLabel("LastName");
            lastnameLabel.setBounds(30, 85, 60, 30);
            genderLabel = new JLabel("Gender");
            genderLabel.setBounds(30, 120, 60, 30);

            ageLabel = new JLabel("Age");
            ageLabel.setBounds(30, 155, 60, 30);

            usernameLabel = new JLabel("Username");
            usernameLabel.setBounds(30, 190, 60, 30);
            passwordLabel = new JLabel("Password");
            passwordLabel.setBounds(30, 225, 60, 30);

            firstnameField = new JTextField();

            firstnameField.setBounds(95, 50, 130, 30);
            firstnameField.setName("firstname");
            regiterTextField(firstnameField);
            lastnameField = new JTextField();
            lastnameField.setBounds(95, 85, 130, 30);
            lastnameField.setName("lastname");
            regiterTextField(lastnameField);
            // Defining Gender Buttons
            male = new JRadioButton("Male");
            male.setBounds(95, 120, 60, 30);
            male.setSelected(true);
            female = new JRadioButton("Female");
            female.setBounds(155, 120, 70, 30);
            bg = new ButtonGroup();

            bg.add(male);
            bg.add(female);

            ageField = new JTextField();
            ageField.setBounds(95, 155, 130, 30);
            regiterTextField(ageField);
            ageField.setName("age");

            usernameField = new JTextField();
            usernameField.setBounds(95, 190, 130, 30);
            regiterTextField(usernameField);
            usernameField.setName("username");

            passwordField = new JPasswordField();
            passwordField.setBounds(95, 225, 130, 30);
            regiterTextField(passwordField);
            passwordField.setName("password");    
            userFrame.add(title);
            userFrame.add(firstnameLabel);
            userFrame.add(lastnameLabel);
            userFrame.add(genderLabel);
            userFrame.add(ageLabel);
            userFrame.add(usernameLabel);
            userFrame.add(passwordLabel);
            userFrame.add(firstnameField);
            userFrame.add(lastnameField);
            userFrame.add(male);
            userFrame.add(female);
            userFrame.add(usernameField);
            userFrame.add(passwordField);
            userFrame.add(ageField);
            exitButton = new JButton("Exit");

            exitButton.setBounds(25, 250, 80, 25);
            // Defining Register Button
            registerButton = new JButton("Register");
            registerButton.setBounds(110, 270, 100, 25);
            // Defining Update Button
            updateButton = new JButton("Update");
            updateButton.setBounds(110, 285, 100, 25);
            updateButton.setEnabled(false);
            // Defining Delete Button
            deleteButton = new JButton("Delete");
            deleteButton.setBounds(25, 285, 80, 25);
            deleteButton.setEnabled(false);
            // Defining Reset Button
            resetButton = new JButton("Reset");
            resetButton.setBounds(60, 320, 100, 25);
            resetButton.setEnabled(false);

            // fixing all Buttons
//            add(exitButton);
            userFrame.add(registerButton);
//            add(updateButton);
//            add(deleteButton);
//            add(resetButton);

            // Defining Panel
            panel = new JPanel();
            panel.setLayout(new GridLayout());
            panel.setBounds(250, 40, 480, 100);
           // panel.setBorder(BorderFactory.createDashedBorder(Color.blue));
            userFrame.add(panel);
            
            
            panel.add(validationResultLbl);

            //Displaying Frame in Center of the Screen
            Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();

            userFrame.setLocation(dim.width / 2 - userFrame.getSize().width / 2,
                    dim.height / 2 - userFrame.getSize().height / 2);

            userFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            userFrame.setResizable(false);
            userFrame.setVisible(true);
            
            registerButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    process(new BankStaff());
                    
                    if(validationResultLbl.getText().equals("<html></html>")){
                     
                    String fname =firstnameField.getText();
            		String lname = lastnameField.getText();
            		String gender = male.isSelected() ? "Male" : "Female";
            		int age =Integer.parseInt( ageField.getText());	
            		String username = usernameField.getText();
            		String password = passwordField.getText();
            		
            		BankStaff bs=new BankStaff();
            		bs.setFname(fname);
            		bs.setLname(lname);
            		bs.setGender(gender);
            		bs.setAge(age);
            		bs.setUsername(username);
            		bs.setPassword(password);
            		
            		DBHelper.addBankStaff(bs);
            	
            		userFrame.dispose();
            		
            		new UserLoginForm();
                  }	
                }
            });

        }
    
       
}
