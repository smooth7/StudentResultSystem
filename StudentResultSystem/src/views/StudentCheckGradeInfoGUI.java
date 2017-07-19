package views;
import javax.swing.*;

import controllers.studentcheckGradeInfo.CheckGradeListener;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

public class StudentCheckGradeInfoGUI extends JFrame {

	JButton buttonSubmit;
	JLabel labelModuleInfo;
	JComboBox<String> comboModuleInfo;
	
	public StudentCheckGradeInfoGUI(ArrayList<String> studentScoreList){
		createGUI(studentScoreList);
	}
	
	public void createGUI(ArrayList<String> studentScoreList){
		
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
		
		String[] listOfModules = studentScoreList.toArray(new String[studentScoreList.size()] );
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
		
		this.add(jPanelObject);
		this.setVisible(true);
		
	}
	
	public JComboBox<String> getChangeModuleCombo(){
		return comboModuleInfo;
		
	}
	
	public void displayResult(String result){
		JOptionPane.showMessageDialog(StudentCheckGradeInfoGUI.this, result, "Result Information", JOptionPane.INFORMATION_MESSAGE);
		
	}
	
}
