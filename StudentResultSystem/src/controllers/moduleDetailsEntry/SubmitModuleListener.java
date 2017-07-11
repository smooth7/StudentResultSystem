package controllers.moduleDetailsEntry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import model.ModuleDetailsDAO;
import views.ModuleDetailsEntry;

public class SubmitModuleListener implements ActionListener{
	
	static ModuleDetailsEntry moduleDetailsEntry;
	static ModuleDetailsDAO moduleDetailsDAO = new ModuleDetailsDAO();
	
	String moduleDepartment = "";
	String moduleLecturerInfo = "";
	String moduleYear = "";
	String moduleName = "";
	ArrayList<String> moduleStudentList = new ArrayList<String>();
	
	public void actionPerformed(ActionEvent e){
		
		moduleDepartment = moduleDetailsEntry.getModuleDepartment().getText();
		moduleLecturerInfo = moduleDetailsEntry.getModuleLecturer().getSelectedItem().toString();
		moduleYear = moduleDetailsEntry.getModuleYear().getSelectedItem().toString();
		moduleName = moduleDetailsEntry.getModuleName().getText();
		moduleStudentList = moduleDetailsEntry.getStudentList();
		
		if (validateDetails() == true){
		
		String[] moduleLecturerInfoParts = moduleLecturerInfo.split("; Id: ");
		String moduleLecturerId = moduleLecturerInfoParts[1];
		
		ArrayList<String> moduleStudentIdList  = new ArrayList<String>();
		for (String studentInfo : moduleStudentList) {
			String[] moduleStudentInfoParts = studentInfo.split("; Id: ");
			String moduleStudentId = moduleStudentInfoParts[1];
			moduleStudentIdList.add(moduleStudentId);
		}
		
		if (moduleDetailsDAO.insertModuleDetails(moduleName, moduleDepartment, moduleLecturerId, moduleYear) == true){
			
			String moduleId = moduleDetailsDAO.getCurrentModuleId();
			
			if(moduleDetailsDAO.insertModuleStudents(moduleId, moduleLecturerId, moduleYear, moduleStudentIdList) == true){
				moduleDetailsEntry.showInsertSuccess();
			}
			
		}
		
	}
	}
	
	
	private boolean validateDetails() {
		
		if(moduleName.equals("")){
			moduleDetailsEntry.showValidationError("Please enter the module name");
			return false;
		}
		
		if(moduleDepartment.equals("")){
			moduleDetailsEntry.showValidationError("Please enter the module department");
			return false;
		}
		
		if(moduleStudentList.size() == 0){
			moduleDetailsEntry.showValidationError("Please select the student(s) that are offering this module");
			return false;
		}
		
		return true;
		
	}

	public static void createGUI(){

		ArrayList<String> lecturerInfoList = moduleDetailsDAO.getLecturerDetails();
		ArrayList<String> studentInfoList = moduleDetailsDAO.getStudentDetails();
		
		moduleDetailsEntry = new ModuleDetailsEntry(lecturerInfoList, studentInfoList);
	}
	}
