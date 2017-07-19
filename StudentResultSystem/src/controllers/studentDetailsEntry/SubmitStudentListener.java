package controllers.studentDetailsEntry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.StudentDetailsDAO;
import views.StudentDetailsGUI;

public class SubmitStudentListener implements ActionListener{
	
		static StudentDetailsGUI studentDetailsEntry;
		StudentDetailsDAO studentDetailsDAO = new StudentDetailsDAO();
		
		String studentName = "";
		String studentDepartment = "";
		
		public void actionPerformed(ActionEvent e){
			
			studentName = studentDetailsEntry.getStudentName().getText();
			studentDepartment = studentDetailsEntry.getStudentDepartment().getText();
			
			if(validateDetails() == true){
				//insert student details
				if (studentDetailsDAO.insertStudentDetails(studentName, studentDepartment) == true){
					studentDetailsEntry.showInsertSuccess();
				}
			}
			
		}
		
		private boolean validateDetails() {
			
			if(studentName.equals("")){
				studentDetailsEntry.showValidationError("Please enter the student name");
				return false;
			}
			
			if(studentDepartment.equals("")){
				studentDetailsEntry.showValidationError("Please enter the student department");
				return false;
			}
			
			return true;
			
		}
		
		public static void createGUI(){
			studentDetailsEntry = new StudentDetailsGUI();
		}
	}
