package views;

import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.List;

import controllers.moduleDetailsEntry.SubmitModuleListener;
import java.util.ArrayList;

public class ModuleDetailsEntry extends JFrame {

	JButton buttonSubmit;
	JTextField textModuleName, textModuleDepartment;
	JLabel labelModuleName, labelModuleDepartment, labelModuleYear, labelModuleLecturers, labelModuleStudents;
	JComboBox<String> comboModuleYear, comboModuleLecturer;
	DefaultListModel<String> studentInfoDefaultList = new DefaultListModel<String>();
	JList<String> studentInfoJList;
	JScrollPane scroller;
	
	public ModuleDetailsEntry(ArrayList<String> lecturerInfoList, ArrayList<String> studentInfoList){
			
		// Define the size of the frame
		this.setSize(900, 1000);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Enter new module details");
				
		JPanel jPanelObject = new JPanel();
		jPanelObject.setLayout(new GridLayout(0,1,2,4));
		Font font = new Font("Helvetica", Font.PLAIN, 22);
		
		JPanel moduleNamePanel = new JPanel();
		labelModuleName = new JLabel("Module Name");
		labelModuleName.setFont(font);
		moduleNamePanel.add(labelModuleName);
		
		textModuleName = new JTextField("", 10);
		textModuleName.setFont(font);
		moduleNamePanel.add(textModuleName);
		jPanelObject.add(moduleNamePanel);
		
		JPanel moduleDepartmentPanel = new JPanel();
		labelModuleDepartment = new JLabel("Module Department");
		labelModuleDepartment.setFont(font);
		moduleDepartmentPanel.add(labelModuleDepartment);
		
		textModuleDepartment = new JTextField("", 10);
		textModuleDepartment.setFont(font);
		moduleDepartmentPanel.add(textModuleDepartment);
		jPanelObject.add(moduleDepartmentPanel);
		
		JPanel moduleYearPanel = new JPanel();
		labelModuleYear = new JLabel("Module Academic Year");
		labelModuleYear.setFont(font);
		moduleYearPanel.add(labelModuleYear);
		
		String[] listOfYears = {"2016", "2017", "2018"};
		comboModuleYear = new JComboBox<String>(listOfYears);
		comboModuleYear.setFont(font);
		moduleYearPanel.add(comboModuleYear);
		jPanelObject.add(moduleYearPanel);
		
		JPanel moduleLecturerPanel = new JPanel();
		labelModuleLecturers = new JLabel("Select module lecturers");
		labelModuleLecturers.setFont(font);
		moduleLecturerPanel.add(labelModuleLecturers);
		
		String[] arrayLecturerList = lecturerInfoList.toArray(new String[lecturerInfoList.size()] );
		comboModuleLecturer = new JComboBox<String>(arrayLecturerList);
		comboModuleLecturer.setFont(font);
		moduleLecturerPanel.add(comboModuleLecturer);
		jPanelObject.add(moduleLecturerPanel);
		
		JPanel moduleStudentsPanel = new JPanel();
		labelModuleStudents = new JLabel("Select all students taking module");
		labelModuleStudents.setFont(font);
		moduleStudentsPanel.add(labelModuleStudents);
		
		String[] arrayStudentList = studentInfoList.toArray(new String[studentInfoList.size()] );
		
		for(String studentInfo: arrayStudentList){
			studentInfoDefaultList.addElement(studentInfo);
		}
		
		studentInfoJList = new JList<String>(studentInfoDefaultList);
		studentInfoJList.setFont(font);
		
		scroller = new JScrollPane(studentInfoJList, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		studentInfoJList.setFixedCellHeight(30);
		studentInfoJList.setFixedCellWidth(350);
		moduleStudentsPanel.add(scroller);
		jPanelObject.add(moduleStudentsPanel);
		
		JPanel submitPanel = new JPanel();
		buttonSubmit = new JButton("Submit");
		buttonSubmit.setFont(font);
		SubmitModuleListener submitListener = new SubmitModuleListener();
		buttonSubmit.addActionListener(submitListener);
		submitPanel.add(buttonSubmit);
		jPanelObject.add(submitPanel);
		
		this.add(jPanelObject);
		this.setVisible(true);
		
	}
	
	public JTextField getModuleName() {
		return textModuleName;
	}

	public JTextField getModuleDepartment() {
		return textModuleDepartment;
	}
	
	public JComboBox<String> getModuleYear() {
		return comboModuleYear;
	}
	
	public JComboBox<String> getModuleLecturer() {
		return comboModuleLecturer;
	}
	
	public ArrayList<String> getStudentList() {

		ArrayList<String> studentsList = new ArrayList<>();
		java.util.List<String> list = studentInfoJList.getSelectedValuesList();
		for(int i = 0; i<list.size(); i++) {
			studentsList.add(list.get(i).toString());
		}
		return studentsList;
	}
	
	public void showInsertSuccess(){
		JOptionPane.showMessageDialog(ModuleDetailsEntry.this, "You have successfully inserted module details", "Information", JOptionPane.INFORMATION_MESSAGE);
		textModuleName.setText("");
		textModuleDepartment.setText("");
	}
	
	public void showValidationError(String errorMessage){
			
		JOptionPane.showMessageDialog(ModuleDetailsEntry.this, errorMessage, "Correct input error", JOptionPane.ERROR_MESSAGE);
		
	}
	
}
