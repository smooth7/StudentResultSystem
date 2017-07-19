package controllers.viewNotifications;

import java.util.ArrayList;

import model.ViewInformationDAO;
import views.LoginGUI;
import views.ViewInformationGUI;

public class ViewNotificationsListener {
	
	static ViewInformationGUI viewCommunication;
	static ViewInformationDAO notificationDAO = new ViewInformationDAO();
	
	static String loginId = LoginGUI.getLoginId().getText();
	static String loginUser[] = LoginGUI.getUserType().split(" login");
	
	public static void createGUI(){

		//get list of all notifications for a particular user
		ArrayList<String> messageList = notificationDAO.getNewsList(loginId, loginUser[0]);
		
		viewCommunication = new ViewInformationGUI();
		
		ViewInformationGUI.insertMessageList(messageList);
	}

}
