package views;
import javax.swing.*;

import controllers.checkGrade.CheckGradeListener;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

public class CheckGrade extends JFrame {

	JButton buttonSubmit;
	JLabel labelModuleInfo, labelGradeInfo;
	JComboBox<String> comboModuleInfo;
	
	public CheckGrade(){
			
		// Define the size of the frame
		this.setSize(800, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("View your grades");
				
		JPanel jPanelObject = new JPanel();
		jPanelObject.setLayout(new GridLayout(0,1,2,4));
		Font font = new Font("Helvetica", Font.PLAIN, 22);
		
		JPanel moduleInfoPanel = new JPanel();
		labelModuleInfo = new JLabel("Select Module");
		labelModuleInfo.setFont(font);
		moduleInfoPanel.add(labelModuleInfo);
		
		String[] listOfModules = {""};
		comboModuleInfo = new JComboBox<String>(listOfModules);
		comboModuleInfo.setFont(font);
		moduleInfoPanel.add(comboModuleInfo);
		jPanelObject.add(moduleInfoPanel);
		
		JPanel submitPanel = new JPanel();
		buttonSubmit = new JButton("Check Grade");
		buttonSubmit.setFont(font);
		CheckGradeListener checkGradeListener = new CheckGradeListener();
		buttonSubmit.addActionListener(checkGradeListener);
		submitPanel.add(buttonSubmit);
		jPanelObject.add(submitPanel);
		
		JPanel gradeInfoPanel = new JPanel();
		labelGradeInfo = new JLabel("");
		labelGradeInfo.setFont(font);
		gradeInfoPanel.add(labelGradeInfo);
		jPanelObject.add(gradeInfoPanel);
		
		this.add(jPanelObject);
		this.setVisible(true);
		
	}
	
}
