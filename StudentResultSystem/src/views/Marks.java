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

public class Marks extends JFrame {

	JButton buttonSubmit;
	JComboBox<String> comboStudentInfo, comboModuleInfo;
	JTextField textStudentScore;
	JLabel labelStudentInfo, labelScore, labelModuleInfo;
	JRadioButton radioMarkScore, radioRemarkScore;
	
	public Marks(ArrayList<String> moduleInfoList){
			
		// Define the size of the frame
		this.setResizable(false);
		this.setSize(800, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Enter student marks");
				
		Font font = new Font("Helvetica", Font.PLAIN, 22);
		
		JPanel jPanelObject = new JPanel();
		
		jPanelObject.setLayout(new GridLayout(0,1,2,2));
		
		radioMarkScore = new JRadioButton("Enter score for a marked module");
		radioMarkScore.setFont(font);
		radioRemarkScore = new JRadioButton("Enter score for a remarked module");
		radioRemarkScore.setFont(font);
		
		ButtonGroup radioScoreGroup = new ButtonGroup();
		radioScoreGroup.add(radioMarkScore);
		radioScoreGroup.add(radioRemarkScore);
		
		JPanel radioScorePanel = new JPanel();
		radioScorePanel.add(radioMarkScore);
		radioScorePanel.add(radioRemarkScore);
		
		radioMarkScore.setSelected(true);
		jPanelObject.add(radioScorePanel);
		
		JPanel userModuleInfoPanel = new JPanel();
		
		labelModuleInfo = new JLabel("    Module Information");
		labelModuleInfo.setFont(font);
		userModuleInfoPanel.add(labelModuleInfo);
		
		String[] listOfModuleInfo = moduleInfoList.toArray(new String[moduleInfoList.size()] );
		comboModuleInfo = new JComboBox<String>(listOfModuleInfo);
		comboModuleInfo.setFont(font);
		userModuleInfoPanel.add(comboModuleInfo);
		
		jPanelObject.add(userModuleInfoPanel);
		
		JPanel studentInfoPanel = new JPanel();
		
		labelStudentInfo = new JLabel("    Student Information");
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
	
	public String getMarkAction(){
		if(radioMarkScore.isSelected()){
			return "Mark";
		}else if(radioMarkScore.isSelected()){
			return "Remark";
		}else{
			return null;
		}
	}
	
	public JButton getSubmitButton(){
		return buttonSubmit;
		
	}
	
	public JComboBox<String> getChangeModuleCombo(){
		return comboModuleInfo;
		
	}
}
