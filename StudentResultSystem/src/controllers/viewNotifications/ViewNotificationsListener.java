package controllers.viewNotifications;

import java.util.ArrayList;

import model.ViewNoticeDAO;
import views.LoginGUI;
import views.ViewCommunicationGUI;

public class ViewNotificationsListener {
	
	static ViewCommunicationGUI viewCommunication;
	static ViewNoticeDAO notificationDAO = new ViewNoticeDAO();
	
	static String loginId = LoginGUI.getLoginId().getText();
	static String loginUser[] = LoginGUI.getUserType().split(" login");
	
	public static void createGUI(){

		//get list of all notifications for a particular user
		ArrayList<String> messageList = notificationDAO.getNewsList(loginId, loginUser[0]);
		
		viewCommunication = new ViewCommunicationGUI();
		
		ViewCommunicationGUI.insertMessageList(messageList);
	}

}
