package controllers.login;

import model.LoginDAO;
import views.AdminHomeGUI;

public class AdminLogin implements ILogin {

	//Checks admin login details
	
	@Override
	public boolean checkLoginInfo(String adminId, String adminPassword) {
		
		LoginDAO LoginDAO = new LoginDAO();
		if(LoginDAO.checkAdminInfo(adminId, adminPassword) == true){
			new AdminHomeGUI();
			return true;
		}else{
			return false;
		}
	
	}

}
