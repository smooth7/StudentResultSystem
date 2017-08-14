package controllers.marks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JComboBox;

import model.MarksDAO;
import model.SendCommunicationDAO;
import views.LoginGUI;
import views.ScoresEntryGUI;
import views.ModuleDetailsGUI;

public class SubmitMarkListener implements ActionListener{
	
	static MarksDAO marksDAO = new MarksDAO();
	static ScoresEntryGUI marks;
	SendCommunicationDAO sendNotificationsDAO = new SendCommunicationDAO();
	static String lecturerId = LoginGUI.getLoginId().getText();
	String moduleId = "";
	String moduleYear = "";
	
	int score= 0;
	String studentId = "";
	
	public void actionPerformed(ActionEvent e){
		
		lecturerId = LoginGUI.getLoginId().getText();
		
		//if source is submit button
		if (e.getSource() == marks.getSubmitButton()){
			
			//if student_id is selected
			if(!(marks.getStudentId().getSelectedItem() == null)){
				studentId = marks.getStudentId().getSelectedItem().toString();
				
				moduleId = getModuleId();
				moduleYear = getModuleYear();
			
				if(validateDetails() == true){
					
					//update student score
					if(marksDAO.updateStudentScore(score, studentId, moduleId, moduleYear, lecturerId) == true){
						
						String message = "The score for module-id " + moduleId + "(" + moduleYear + ") has been updated";
						
						sendNotificationsDAO.updateAnnouncement(message, "student", studentId, "System");
						
						marks.showUpdateSuccess();
					}
					
				}
		}
			
		//if source is retrieve student_id button
		}else if (e.getSource() == marks.getRetrieveButton()){
			
			moduleId = getModuleId();
			moduleYear = getModuleYear();
			
			//Get IDs of students offering module
			ArrayList<String> unmarkedStudentList = marksDAO.retrieveUnmarkedStudentsRecord(moduleId, moduleYear, lecturerId);
			
			marks.insertunmarkedStudents(unmarkedStudentList);
			unmarkedStudentList.removeAll(unmarkedStudentList);
		}
		
	}
	
	public String getModuleId(){
		String moduleInfo = marks.getChangeModuleCombo().getSelectedItem().toString();
		String[] moduleInfoPartsOne = moduleInfo.split("[)]; Id: ");
		moduleId = moduleInfoPartsOne[1];
		return moduleId;
	}
	
	public String getModuleYear(){
		String moduleInfo = marks.getChangeModuleCombo().getSelectedItem().toString();
		String[] moduleInfoPartsOne = moduleInfo.split("[)]; Id: ");
		String[] moduleInfoPartsTwo = moduleInfoPartsOne[0].split(" [(]");
		moduleYear = moduleInfoPartsTwo[1];
		return moduleYear;
	}
	
	
	private boolean validateDetails() {
		
		if(studentId == ""){
			marks.showValidationError("Marks list is empty");
			return false;
		}
		
		try {
		     score = Integer.parseInt(marks.getStudentScore().getText());

		     if(score < 1 || score > 100){
		    	 marks.showValidationError("Score should be integer value ranging from 1 to 100");
		    	 return false;
		     }
		}
		catch (NumberFormatException e) {
			marks.showValidationError("Score should be integer value ranging from 1 to 100");
			return false;
		}
		
		return true;
		
	}


	public static void createGUI(){

		lecturerId = LoginGUI.getLoginId().getText();
		
		ArrayList<String> moduleInfoList = marksDAO.getModuleDetails(lecturerId);
		
		marks = new ScoresEntryGUI(moduleInfoList);
		
	}
	
}
