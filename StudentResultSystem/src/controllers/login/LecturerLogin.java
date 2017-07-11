package controllers.login;

import model.LoginDAO;
import views.LecturerHome;

public class LecturerLogin implements ILogin {

	@Override
	public boolean checkLoginInfo(String lecturerId, String lecturerPassword) {
		
		LoginDAO LoginDAO = new LoginDAO();
		if(LoginDAO.checkLecturerInfo(lecturerId, lecturerPassword) == true){
			new LecturerHome();
			return true;
		}else{
			return false;
		}
	}

}
