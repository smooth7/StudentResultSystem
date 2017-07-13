package controllers.sendNotifications;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.SendNotificationsDAO;
import views.SendNotificationsGUI;

public class SendNotificationListener implements ActionListener{
	
	static SendNotificationsGUI sendNotificationsGUI;
	SendNotificationsDAO sendNotificationsDAO = new SendNotificationsDAO();
	
	ArrayList<String> notificationList = new ArrayList<String>();
	
	String notificationMessage = "";
	boolean lecturersSelectionStatus = false;
	boolean studentsSelectionStatus = false;
	
	
	public void actionPerformed(ActionEvent e){
		
		notificationMessage = sendNotificationsGUI.getMessage().getText();
		lecturersSelectionStatus = sendNotificationsGUI.getLecturersSelection();
		studentsSelectionStatus = sendNotificationsGUI.getStudentsSelection();
		
		getObserverList();
		
		NotificationSubject notificationSubject = new NotificationSubject();
		
		//for adding observer
		for (String notificationInfo : notificationList) {
			String[] notificationInfoParts = notificationInfo.split(";");
			String notificationId = notificationInfoParts[0];
			String notificationUserType = notificationInfoParts[1];

			new NotificationObserver(notificationSubject, notificationId, notificationUserType);
			
		}
		
		notificationSubject.setMessage(notificationMessage);
		notificationList.removeAll(notificationList);
		sendNotificationsGUI.showUpdateSuccess();
	}
	
	public ArrayList<String> getObserverList(){

		if (lecturersSelectionStatus == true){
			ArrayList<String> tempLecturerList = new ArrayList<String>();
			tempLecturerList = sendNotificationsDAO.getLecturerDetails();
			
			for (String lecturerInfo : tempLecturerList) {
				notificationList.add(lecturerInfo);
			}
			
		}
		
		if (studentsSelectionStatus == true){
			ArrayList<String> tempStudentList = new ArrayList<String>();
			tempStudentList = sendNotificationsDAO.getStudentDetails();
			
			for (String studentInfo : tempStudentList) {
				notificationList.add(studentInfo);
			}
		}
		
		return notificationList;
		
	}

	public static void createGUI() {

		sendNotificationsGUI = new SendNotificationsGUI();
		
	}

}
