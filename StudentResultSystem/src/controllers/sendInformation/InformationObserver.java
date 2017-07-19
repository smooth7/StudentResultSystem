package controllers.sendInformation;

import model.SendInformationDAO;

public class InformationObserver implements Observer {

	SendInformationDAO sendNotificationsDAO = new SendInformationDAO();
	
	Subject notificationSubject;
	String userId;
	String userType;
	
	public InformationObserver(Subject notificationSubject, String userId, String userType){
		this.notificationSubject = notificationSubject;
		this.userId = userId;
		this.userType = userType;
		
		notificationSubject.addObserver(this);
		
	}
	
	@Override
	public void updateNotice(String message) {
		
		sendNotificationsDAO.updateAnnouncement(message, this.userType, this.userId, "Admin");
		
	}
	

}
