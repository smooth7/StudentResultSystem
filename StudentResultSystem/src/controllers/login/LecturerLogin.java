package controllers.login;

import model.LoginDAO;
import views.LecturerHomeGUI;

public class LecturerLogin implements ILogin {

	//Checks lecturer login details
	@Override
	public boolean checkLoginInfo(String lecturerId, String lecturerPassword) {
		
		LoginDAO LoginDAO = new LoginDAO();
		if(LoginDAO.checkLecturerInfo(lecturerId, lecturerPassword) == true){
			new LecturerHomeGUI();
			return true;
		}else{
			return false;
		}
	}

}
