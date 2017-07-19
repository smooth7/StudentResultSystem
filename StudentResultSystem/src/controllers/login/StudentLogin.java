package controllers.login;

import model.LoginDAO;
import views.LoginGUI;
import views.StudentHomeGUI;

public class StudentLogin implements ILogin {

	//Checks student login details
	@Override
	public boolean checkLoginInfo(String studentId, String studentPassword) {

		LoginDAO LoginDAO = new LoginDAO();
		if(LoginDAO.checkStudentInfo(studentId, studentPassword) == true){
			new StudentHomeGUI();
			return true;
		}else{
			return false;
		}

	}

}
