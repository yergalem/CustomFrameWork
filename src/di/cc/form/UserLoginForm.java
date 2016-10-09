package di.cc.form;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import di.frwk.FormValidator2;

public class UserLoginForm extends FormValidator2 {

	 List<String> reqs, emptyFields;
	 JLabel userLabel;
	 JPasswordField passwordText;
	 JTextField userText;
	 JLabel passwordLabel;

	public UserLoginForm() {

		JFrame frame = new JFrame("Login Form - Credit Union");
		frame.setSize(350, 250);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();

		panel.setLayout(null);

		refreshTxtFieldList(txtFieldList);
		
		userLabel = new JLabel("UserName");
		userLabel.setBounds(30, 60, 80, 25);
		panel.add(userLabel);

		userText = new JTextField(20);
		userText.setBounds(110, 60, 160, 25);
		userText.setName("username");
		regiterTextField(userText);
		panel.add(userText);

		passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(30, 90, 80, 25);
		panel.add(passwordLabel);

		passwordText = new JPasswordField(20);
		passwordText.setBounds(110, 90, 160, 25);
		passwordText.setName("password");
		regiterTextField(passwordText);
		panel.add(passwordText);
        
		
		
		JButton loginButton = new JButton("Login");
		loginButton.setBounds(30, 130, 100, 25);
		panel.add(loginButton);

		JButton registerButton = new JButton("Register");
		registerButton.setBounds(168, 130, 100, 25);
		panel.add(registerButton);


		loginButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				process(new CreditStaff());
				
			}

		});

		registerButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
                frame.dispose();
				new UserRegistration();

			}

		});
		validationResultLbl.setBounds(110, 8, 180, 45);
		
		panel.add(validationResultLbl);
		frame.add(panel);
		frame.setVisible(true);
		
	}

}
