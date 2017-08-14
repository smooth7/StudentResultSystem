package controllers.sendInformation;

import model.SendCommunicationDAO;

public class NewsObserver implements ObserverInterface {

	SendCommunicationDAO sendInformationDAO = new SendCommunicationDAO();
	
	SubjectInterface notificationSubject;
	String userId;
	String userType;
	
	public NewsObserver(SubjectInterface notificationSubject, String userId, String userType){
		this.notificationSubject = notificationSubject;
		this.userId = userId;
		this.userType = userType;
		
		notificationSubject.addObserver(this);
		
	}
	
	@Override
	public void updateNotice(String message) {
		
		sendInformationDAO.updateAnnouncement(message, this.userType, this.userId, "Admin");
		
	}
	

}
