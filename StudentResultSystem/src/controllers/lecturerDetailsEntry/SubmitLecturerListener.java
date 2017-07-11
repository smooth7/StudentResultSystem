package controllers.lecturerDetailsEntry;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.LecturerDetailsDAO;
import views.LecturerDetailsEntry;

public class SubmitLecturerListener implements ActionListener{
	
	static LecturerDetailsEntry lecturerDetailsEntry;
	LecturerDetailsDAO lecturerDetailsDAO = new LecturerDetailsDAO();
	
	String lecturerName = "";
	String lecturerDepartment = "";
	
	public void actionPerformed(ActionEvent e){
		
		lecturerName = lecturerDetailsEntry.getLecturerName().getText();
		lecturerDepartment = lecturerDetailsEntry.getLecturerDepartment().getText();
		
		if(validateDetails() == true){
			if (lecturerDetailsDAO.insertLecturerDetails(lecturerName, lecturerDepartment) == true){
				lecturerDetailsEntry.showInsertSuccess();
			}
		}
		
	}
	
	private boolean validateDetails() {
		
		if(lecturerName.equals("")){
			lecturerDetailsEntry.showValidationError("Please enter the lecturer name");
			return false;
		}
		
		if(lecturerDepartment.equals("")){
			lecturerDetailsEntry.showValidationError("Please enter the lecturer department");
			return false;
		}
		
		return true;
		
	}
	
	public static void createGUI(){
		lecturerDetailsEntry = new LecturerDetailsEntry();
	}
	
}
