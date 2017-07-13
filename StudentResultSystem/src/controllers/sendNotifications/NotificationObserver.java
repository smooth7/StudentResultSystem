package controllers.sendNotifications;

import model.SendNotificationsDAO;

public class NotificationObserver implements Observer {

	SendNotificationsDAO sendNotificationsDAO = new SendNotificationsDAO();
	
	Subject notificationSubject;
	String userId;
	String userType;
	
	public NotificationObserver(Subject notificationSubject, String userId, String userType){
		this.notificationSubject = notificationSubject;
		this.userId = userId;
		this.userType = userType;
		
		notificationSubject.addObserver(this);
		
	}
	
	@Override
	public void update(String message) {

		sendNotificationsDAO.updateNotification(message, this.userType, this.userId);
		
	}
	

}
