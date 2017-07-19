package controllers.login;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.LoginGUI;
import views.StudentHomeGUI;

public class LoginListener implements ActionListener{
	
	static LoginGUI userLoginEntry;
	
	String loginId = "";
	String loginPassword = "";
	String loginUserType = "";
	
	public void actionPerformed(ActionEvent e){
		
		loginId = LoginGUI.getLoginId().getText();
		loginPassword = userLoginEntry.getLoginPassword().getText();
		loginUserType = LoginGUI.getUserType();
		
		if(validateDetails() == true){
			
			//checks login details
			
			LoginFactory loginFactoryObj = new LoginFactory();
			ILogin iLoginObj = loginFactoryObj.getUserTypeInstance(loginUserType);
			
			if(iLoginObj.checkLoginInfo(loginId, loginPassword) == false){
				userLoginEntry.showLoginError("The details you provided are incorrect or you selected the wrong user");
			}
			
		}
		
	}

	private boolean validateDetails() {
		
		if(loginId.equals("")){
			userLoginEntry.showValidationError("Please enter the login ID");
			return false;
		}
		
		if(loginPassword.equals("")){
			userLoginEntry.showValidationError("Please enter the password");
			return false;
		}
		
		return true;
		
	}
	
	public static void createGUI() {

		userLoginEntry = new LoginGUI();
		
	}


}
