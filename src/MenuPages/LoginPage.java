package MenuPages;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import staff.User;
import utilities.DataSingleton;


public class LoginPage implements ActionListener{
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JButton kzButton = new JButton("KZ");
	JButton engButton = new JButton("ENG");
	JButton ruButton = new JButton("RU");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel userIDLabel = new JLabel("Email");
	JLabel userPasswordLabel = new JLabel("Password");
	JLabel messageLabel = new JLabel();
	
	public LoginPage() {
		userIDLabel.setBounds(650, 400, 75, 25);
		userPasswordLabel.setBounds(650,450,75,25);
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);

		messageLabel.setBounds(600,550,1000,150);
		messageLabel.setFont(new Font(null,Font.ITALIC,25));
		frame.add(messageLabel);
		
		userIDField.setBounds(720,400,200,25);
		userPasswordField.setBounds(720,450,200,25);
		frame.add(userIDField);
		frame.add(userPasswordField);

		loginButton.setBounds(690,500,100,25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		
		resetButton.setBounds(790,500,100,25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		kzButton.setBounds(1390,10,100,25);
		kzButton.setFocusable(false);
		kzButton.addActionListener(this);
		ruButton.setBounds(1490,10,100,25);
		ruButton.setFocusable(false);
		ruButton.addActionListener(this);
		engButton.setBounds(1590,10,100,25);
		engButton.setFocusable(false);
		engButton.addActionListener(this);

		frame.add(loginButton);
		frame.add(resetButton);
		frame.add(kzButton);
		frame.add(ruButton);
		frame.add(engButton);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1700, 1000);
		frame.setLayout(null);
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == kzButton) {
			loginButton.setText("Кіру");
			resetButton.setText("Қайта жазу");
			userIDLabel.setText("Логин");
			userPasswordLabel.setText("Құпиясөз");
		}
		if(e.getSource() == ruButton) {
			loginButton.setText("Войти");
			resetButton.setText("Ввести заново");
			userIDLabel.setText("Логин");
			userPasswordLabel.setText("Пароль");
		}
		if(e.getSource() == engButton) {
			loginButton.setText("Login");
			resetButton.setText("Reset");
			userIDLabel.setText("Email");
			userPasswordLabel.setText("Password");
		}
		if(e.getSource() == resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		if(e.getSource() == loginButton) {
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(DataSingleton.INSTANCE.getLoginInfo().containsKey(userID)) {
				if(DataSingleton.INSTANCE.getLoginInfo().get(userID).equals(password)) {
					try {
						for(User u : DataSingleton.INSTANCE.getUsers()) {
							if(u.getCorparateEmail().equals(userID) && u.getPassword().equals(password)) {
								messageLabel.setForeground(Color.green);
								
								messageLabel.setText("Login successful, welcome " + u.getName() + " " + u.getSurname());
								// if (type check) -> menu
								// today i will finish the teacher's menu and show u how to do, but it is easy
								
							}
						}
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
					
				}
			}
			
			
		}
		
	}
	
	
}
