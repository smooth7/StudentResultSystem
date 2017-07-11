package controllers.login;

import model.LoginDAO;
import views.AdminHome;

public class AdminLogin implements ILogin {

	@Override
	public boolean checkLoginInfo(String adminId, String adminPassword) {
		
		LoginDAO LoginDAO = new LoginDAO();
		if(LoginDAO.checkAdminInfo(adminId, adminPassword) == true){
			new AdminHome();
			return true;
		}else{
			return false;
		}
	
	}

}
