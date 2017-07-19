package views;
import javax.swing.*;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controllers.marks.SubmitMarkListener;

import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.border.*;

public class MarksGUI extends JFrame {

	JButton buttonSubmit, buttonRetrieveStudents;
	JComboBox<String> comboStudentInfo, comboModuleInfo;
	JTextField textStudentScore;
	JLabel labelStudentInfo, labelScore, labelModuleInfo;
	
	Font font = new Font("Helvetica", Font.PLAIN, 22);
	
	public MarksGUI(ArrayList<String> moduleInfoList){
		createGUI(moduleInfoList);
	}
	
	public void createGUI(ArrayList<String> moduleInfoList){
		
		// Define the size of the frame
		this.setResizable(false);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Enter student marks");
		
		JPanel jPanelObject = new JPanel();
		
		jPanelObject.setLayout(new GridLayout(0,1,2,2));
		
		JPanel userModuleInfoPanel = new JPanel();
		
		labelModuleInfo = new JLabel("    Module Information");
		labelModuleInfo.setFont(font);
		userModuleInfoPanel.add(labelModuleInfo);
		
		String[] listOfModuleInfo = moduleInfoList.toArray(new String[moduleInfoList.size()] );
		comboModuleInfo = new JComboBox<String>(listOfModuleInfo);
		comboModuleInfo.setFont(font);
		userModuleInfoPanel.add(comboModuleInfo);
		
		jPanelObject.add(userModuleInfoPanel);
		
		JPanel retrieveStudentsPanel = new JPanel();
		buttonRetrieveStudents = new JButton("Retrieve Students");
		buttonRetrieveStudents.setFont(font);
		SubmitMarkListener retrieveListener = new SubmitMarkListener();
		buttonRetrieveStudents.addActionListener(retrieveListener);
		retrieveStudentsPanel.add(buttonRetrieveStudents);
		jPanelObject.add(retrieveStudentsPanel);
		
		JPanel studentInfoPanel = new JPanel();
		
		labelStudentInfo = new JLabel("    Student Id");
		labelStudentInfo.setFont(font);
		studentInfoPanel.add(labelStudentInfo);
		
		String[] listOfStudentInfo = {""};
		comboStudentInfo = new JComboBox<String>(listOfStudentInfo);
		comboStudentInfo.setFont(font);
		studentInfoPanel.add(comboStudentInfo);
		
		jPanelObject.add(studentInfoPanel);
		
		JPanel studentScorePanel = new JPanel();
		
		labelScore = new JLabel("    Student Score");
		labelScore.setFont(font);
		studentScorePanel.add(labelScore);
		
		textStudentScore = new JTextField("", 3);
		textStudentScore.setFont(font);
		studentScorePanel.add(textStudentScore);
		
		jPanelObject.add(studentScorePanel);
		
		JPanel submitPanel = new JPanel();
		buttonSubmit = new JButton("Submit");
		buttonSubmit.setFont(font);
		SubmitMarkListener submitMarkListener = new SubmitMarkListener();
		buttonSubmit.addActionListener(submitMarkListener);
		submitPanel.add(buttonSubmit);
		jPanelObject.add(submitPanel);
		
		this.add(jPanelObject);
		this.setVisible(true);
		
	}
	
	public JButton getSubmitButton(){
		return buttonSubmit;
		
	}
	
	//to insert unmarked students for selected module into comboStudentInfo
	public void insertunmarkedStudents(ArrayList<String> unmarkedStudentList){
		
		if(unmarkedStudentList.isEmpty()){
			comboStudentInfo.removeAllItems();
			showValidationError("There are no unmarked students for selected module.");
		}else{
			
			String[] listUnmarkedStudent = unmarkedStudentList.toArray(new String[unmarkedStudentList.size()] );
			
			comboStudentInfo.removeAllItems();
			
			for (String unmarkedStudent : listUnmarkedStudent) {
				comboStudentInfo.addItem(unmarkedStudent);
			}
			
			comboStudentInfo.setSelectedIndex(0);
			
		}
		
	}
	
	public JComboBox<String> getStudentId(){
		return comboStudentInfo;
		
	}
	
	public JTextField getStudentScore(){
		return textStudentScore;
		
	}
	
	//returns object of buttonRetrieveStudents variable
	public JButton getRetrieveButton(){
		return buttonRetrieveStudents;
		
	}
	
	//returns object of comboModuleInfo variable
	public JComboBox<String> getChangeModuleCombo(){
		return comboModuleInfo;
		
	}
	
	public void showInsertSuccess(){
		JOptionPane.showMessageDialog(MarksGUI.this, "You have successfully inserted the student score", "Information", JOptionPane.INFORMATION_MESSAGE);
		
		textStudentScore.setText("");
		comboStudentInfo.removeItemAt(comboStudentInfo.getSelectedIndex());
		
	}
	
	public void showValidationError(String errorMessage){
		
		JOptionPane.showMessageDialog(MarksGUI.this, errorMessage, "Correct input error", JOptionPane.ERROR_MESSAGE);
		
	}
}
