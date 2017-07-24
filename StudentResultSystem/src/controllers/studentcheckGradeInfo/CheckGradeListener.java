package controllers.studentcheckGradeInfo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.MarksDAO;
import views.LoginGUI;
import views.StudentCheckGradeInfoGUI;

public class CheckGradeListener implements ActionListener, ICheckGradeListener{
	
	
	int score = 0;
	static String scoreMessage = "";

	static MarksDAO marksDAO = new MarksDAO();
	static StudentCheckGradeInfoGUI studentCheckGrade;
	
	public void actionPerformed(ActionEvent e){
		
		String studentId = LoginGUI.getLoginId().getText();
		
		studentId = LoginGUI.getLoginId().getText();
		
		String moduleInfo = studentCheckGrade.getChangeModuleCombo().getSelectedItem().toString();
		
		String[] moduleInfoPartsOne = moduleInfo.split("[)]; Id: ");
		String moduleId = moduleInfoPartsOne[1];
		
		String[] moduleInfoPartsTwo = moduleInfoPartsOne[0].split(" [(]");
		String moduleYear = moduleInfoPartsTwo[1];
		
		score = marksDAO.getStudentScore(studentId, moduleId, moduleYear);
		
		studentCheckGrade.displayResult(getGrade(score));
		
		
	}

	//returns student grade
	public static String getGrade(int score) {

		if(score < -1){
			scoreMessage = "Invalid entry";
		}else if(score == -1){//default data when result is not yet out
			scoreMessage = "Sorry, the result for this module is not yet out";
		}else if(score < 30){
			scoreMessage = "Your grade is F, you have to repeat";
		}else if(score < 35){
			scoreMessage = "Your grade is D2";
		}else if(score < 40){
			scoreMessage = "Your grade is D1";
		}else if(score < 45){
			scoreMessage = "Your grade is C3";
		}else if(score < 50){
			scoreMessage = "Your grade is C2";
		}else if(score < 55){
			scoreMessage = "Your grade is C1";
		}else if(score < 60){
			scoreMessage = "Your grade is B3";
		}else if(score < 65){
			scoreMessage = "Your grade is B2";
		}else if(score < 72){
			scoreMessage = "Your grade is B1";
		}else if(score < 80){
			scoreMessage = "Your grade is A2";
		}else if(score <= 100){
			scoreMessage = "Your grade is A1";
		}else{
			scoreMessage = "Invalid entry";
		}
		
		return scoreMessage;
		
	}

	public static void createGUI(){

		String studentId = LoginGUI.getLoginId().getText();
		MarksDAO marksDAO = new MarksDAO();
		
		studentId = LoginGUI.getLoginId().getText();
		
		ArrayList<String> studentScoreList = marksDAO.getStudentModuleList(studentId);
		
		studentCheckGrade = new StudentCheckGradeInfoGUI(studentScoreList);
		
	}

}
