package views;
import javax.swing.*;

import java.awt.Font;
import java.awt.GridLayout;

import controllers.lecturerDetailsEntry.SubmitLecturerListener;

public class LecturerInfoDetailEntryGUI extends JFrame {

	JButton buttonSubmit;
	JTextField textLecturerName, textLecturerDepartmentInput;
	JLabel labelLecturerName, labelLecturerDepartment;
	Font font = new Font("Helvetica", Font.PLAIN, 22);
	
	public LecturerInfoDetailEntryGUI(){
		
		createGUI();
	}
	
	public void createGUI(){
		
		this.setSize(700, 400);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Enter Lecturer Details");
				
		JPanel jPanelObject = new JPanel();
		jPanelObject.setLayout(new GridLayout(0,1,2,3));
		
		JPanel lecturerNamePanel = new JPanel();
		
		labelLecturerName = new JLabel("Lecturer Name:  ");
		labelLecturerName.setFont(font);
		lecturerNamePanel.add(labelLecturerName);
		
		textLecturerName = new JTextField("", 15);
		textLecturerName.setFont(font);
		lecturerNamePanel.add(textLecturerName);
		
		jPanelObject.add(lecturerNamePanel);
				
		JPanel lecturerDepartmentPanel = new JPanel();
		
		labelLecturerDepartment = new JLabel("Lecturer Department: ");
		labelLecturerDepartment.setFont(font);
		lecturerDepartmentPanel.add(labelLecturerDepartment);
		
		textLecturerDepartmentInput = new JTextField("", 15);
		textLecturerDepartmentInput.setFont(font);
		lecturerDepartmentPanel.add(textLecturerDepartmentInput);
		
		jPanelObject.add(lecturerDepartmentPanel);
		
		JPanel submitPanel = new JPanel();
		
		buttonSubmit = new JButton("Submit");
		buttonSubmit.setFont(font);
		SubmitLecturerListener submitListener = new SubmitLecturerListener();
		buttonSubmit.addActionListener(submitListener);
		submitPanel.add(buttonSubmit);
		
		jPanelObject.add(submitPanel);
		
		this.add(jPanelObject);
		this.setVisible(true);
		
	}
	
	public JTextField getLecturerName() {
		return textLecturerName;
	}

	public JTextField getLecturerDepartment() {
		return textLecturerDepartmentInput;
	}
	
	public void showInsertSuccess(){
		JOptionPane.showMessageDialog(LecturerInfoDetailEntryGUI.this, "You have successfully inserted lecturer details", "Information", JOptionPane.INFORMATION_MESSAGE);
		textLecturerName.setText("");
		textLecturerDepartmentInput.setText("");
	}
	
	public void showValidationError(String errorMessage){
		
		JOptionPane.showMessageDialog(LecturerInfoDetailEntryGUI.this, errorMessage, "Correct input error", JOptionPane.ERROR_MESSAGE);
		
	}
	
}
