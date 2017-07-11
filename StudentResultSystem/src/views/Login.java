package views;
import javax.swing.*;

import controllers.login.LoginListener;

import java.awt.Font;
import java.awt.GridLayout;

public class Login extends JFrame {

	JButton buttonSubmit;
	JTextField textUserId, textPassword;
	JLabel labelPassword, labelUserId;
	JRadioButton radioStudentLogin, radioLecturerLogin, radioAdminLogin;
	ButtonGroup radioLoginGroup = new ButtonGroup();
	
	public Login(){
			
		this.setTitle("Login");
		this.setResizable(false);
		this.setSize(700, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Font font = new Font("Helvetica", Font.PLAIN, 22);
				
		JPanel jPanelObject = new JPanel();
		
		jPanelObject.setLayout(new GridLayout(0,1,2,4));
		
		radioStudentLogin = new JRadioButton("Student login");
		radioStudentLogin.setFont(font);
		radioLecturerLogin = new JRadioButton("Lecturer login");
		radioLecturerLogin.setFont(font);
		radioAdminLogin = new JRadioButton("Admin login");
		radioAdminLogin.setFont(font);
		
		radioLoginGroup.add(radioStudentLogin);
		radioLoginGroup.add(radioLecturerLogin);
		radioLoginGroup.add(radioAdminLogin);
		
		JPanel radioLoginPanel = new JPanel();
		radioLoginPanel.add(radioStudentLogin);
		radioLoginPanel.add(radioLecturerLogin);
		radioLoginPanel.add(radioAdminLogin);
		
		radioStudentLogin.setSelected(true);
		jPanelObject.add(radioLoginPanel);
		
		JPanel userIdPanel = new JPanel();
		
		labelUserId = new JLabel("    Enter User Id:");
		labelUserId.setFont(font);
		userIdPanel.add(labelUserId);
		
		textUserId = new JTextField("", 15);
		textUserId.setFont(font);
		userIdPanel.add(textUserId);
		
		jPanelObject.add(userIdPanel);
		
		JPanel userPassword = new JPanel();
		
		labelPassword = new JLabel("    Enter Password:");
		labelPassword.setFont(font);
		userPassword.add(labelPassword);
		
		textPassword = new JTextField("", 15);
		textPassword.setFont(font);
		userPassword.add(textPassword);
		
		jPanelObject.add(userPassword);
		
		JPanel buttonPanel = new JPanel();
		buttonSubmit = new JButton("Submit");
		buttonSubmit.setFont(font);
		LoginListener submitListener = new LoginListener();
		buttonSubmit.addActionListener(submitListener);
		buttonPanel.add(buttonSubmit);
		jPanelObject.add(buttonPanel);
		
		this.add(jPanelObject);
		this.setVisible(true);
		
	}
	
	public JTextField getLoginId() {
		return textUserId;
	}
	
	public String getUserType(){
		
		if(radioStudentLogin.isSelected()){
			return "Student login";
		}else if(radioLecturerLogin.isSelected()){
			return "Lecturer login";
		}else if(radioAdminLogin.isSelected()){
			return "Admin login";
		}else{
			return null;
		}
		
	}
	
	public JTextField getLoginPassword() {
		return textPassword;
	}
	
	public void showValidationError(String errorMessage){
		
		JOptionPane.showMessageDialog(Login.this, errorMessage, "Correct input error", JOptionPane.ERROR_MESSAGE);
		
	}
	
	public void showLoginError(String errorMessage){
		
		JOptionPane.showMessageDialog(Login.this, errorMessage, "Correct login error", JOptionPane.ERROR_MESSAGE);
		
	}
	
}
