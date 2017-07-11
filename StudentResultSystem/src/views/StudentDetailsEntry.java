package views;
import javax.swing.*;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controllers.studentDetailsEntry.SubmitStudentListener;

import java.text.NumberFormat;
import javax.swing.border.*;

public class StudentDetailsEntry extends JFrame {

	JButton buttonSubmit;
	JTextField textStudentName, textStudentDepartment;
	JLabel labelStudentName, labelStudentDepartment;
	
	public StudentDetailsEntry(){
			
		// Define the size of the frame
		this.setSize(700, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Enter new student details");
		
		Font font = new Font("Helvetica", Font.PLAIN, 22);
		
		JPanel jPanelObject = new JPanel();
		jPanelObject.setLayout(new GridLayout(0,1,2,3));
		
		JPanel studentNamePanel = new JPanel();
		
		labelStudentName = new JLabel("Student Name: ");
		labelStudentName.setFont(font);
		studentNamePanel.add(labelStudentName);
		
		textStudentName = new JTextField("", 15);
		textStudentName.setFont(font);
		studentNamePanel.add(textStudentName);
		
		jPanelObject.add(studentNamePanel);
		
		JPanel studentDepartmentPanel = new JPanel();
		
		labelStudentDepartment = new JLabel("Student Department:");
		labelStudentDepartment.setFont(font);
		studentDepartmentPanel.add(labelStudentDepartment);
		
		textStudentDepartment = new JTextField("", 15);
		textStudentDepartment.setFont(font);
		studentDepartmentPanel.add(textStudentDepartment);
		
		jPanelObject.add(studentDepartmentPanel);
		
		JPanel buttonPanel = new JPanel();
		buttonSubmit = new JButton("Submit");
		buttonSubmit.setFont(font);
		SubmitStudentListener submitListener = new SubmitStudentListener();
		buttonSubmit.addActionListener(submitListener);
		buttonPanel.add(buttonSubmit);
		jPanelObject.add(buttonPanel);
		
		this.add(jPanelObject);
		this.setVisible(true);
		
	}
	
	public JTextField getStudentName() {
		return textStudentName;
	}

	public JTextField getStudentDepartment() {
		return textStudentDepartment;
	}
	
	public void showInsertSuccess(){
		JOptionPane.showMessageDialog(StudentDetailsEntry.this, "You have successfully inserted student details", "Information", JOptionPane.INFORMATION_MESSAGE);
		textStudentName.setText("");
		textStudentDepartment.setText("");
	}

	public void showValidationError(String errorMessage){
		
		JOptionPane.showMessageDialog(StudentDetailsEntry.this, errorMessage, "Correct input error", JOptionPane.ERROR_MESSAGE);
		
	}
	
}
