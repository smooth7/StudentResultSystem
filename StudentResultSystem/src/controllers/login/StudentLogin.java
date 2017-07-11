package controllers.login;

import model.LoginDAO;
import views.Login;
import views.StudentHome;

public class StudentLogin implements ILogin {

	@Override
	public boolean checkLoginInfo(String studentId, String studentPassword) {

		LoginDAO LoginDAO = new LoginDAO();
		if(LoginDAO.checkStudentInfo(studentId, studentPassword) == true){
			new StudentHome();
			return true;
		}else{
			return false;
		}

	}

}
