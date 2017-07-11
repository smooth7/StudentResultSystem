package views;
import javax.swing.*;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controllers.confirmRemark.ConfirmRemarkListener;

import java.text.NumberFormat;
import javax.swing.border.*;

public class ConfirmRemark extends JFrame {

	JButton buttonSubmit;
	JLabel labelStudentInfo, labelModuleInfo, labelRemarkConfirm;
	JComboBox<String> comboStudents, comboModuleInfo, comboRemarkConfirm;
	
	public ConfirmRemark(){
			
		// Define the size of the frame
		this.setSize(900, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Confirm a remark request");
				
		JPanel jPanelObject = new JPanel();
		jPanelObject.setLayout(new GridLayout(0,1,2,4));
		Font font = new Font("Helvetica", Font.PLAIN, 22);
		
		
		JPanel studentInfoPanel = new JPanel();
		labelStudentInfo = new JLabel("Select student");
		labelStudentInfo.setFont(font);
		studentInfoPanel.add(labelStudentInfo);
		
		String[] listOfStudents = {""};
		comboStudents = new JComboBox<String>(listOfStudents);
		comboStudents.setFont(font);
		studentInfoPanel.add(comboStudents);
		jPanelObject.add(studentInfoPanel);
		
		JPanel moduleInfoPanel = new JPanel();
		labelModuleInfo = new JLabel("Select Module");
		labelModuleInfo.setFont(font);
		moduleInfoPanel.add(labelModuleInfo);
		
		String[] listOfModules = {""};
		comboModuleInfo = new JComboBox<String>(listOfModules);
		comboModuleInfo.setFont(font);
		moduleInfoPanel.add(comboModuleInfo);
		jPanelObject.add(moduleInfoPanel);
		
		JPanel remarkConfirmPanel = new JPanel();
		labelRemarkConfirm = new JLabel("Confirm remark");
		labelRemarkConfirm.setFont(font);
		remarkConfirmPanel.add(labelRemarkConfirm);
		
		String[] confirmOptions = {"Accept Remark", "Reject Remark"};
		comboRemarkConfirm = new JComboBox<String>(confirmOptions);
		comboRemarkConfirm.setFont(font);
		remarkConfirmPanel.add(comboRemarkConfirm);
		jPanelObject.add(remarkConfirmPanel);
		
		JPanel submitPanel = new JPanel();
		buttonSubmit = new JButton("Submit");
		buttonSubmit.setFont(font);
		ConfirmRemarkListener confirmRemarkListener = new ConfirmRemarkListener();
		buttonSubmit.addActionListener(confirmRemarkListener);
		submitPanel.add(buttonSubmit);
		jPanelObject.add(submitPanel);
		
		this.add(jPanelObject);
		this.setVisible(true);
		
	}
	
}
