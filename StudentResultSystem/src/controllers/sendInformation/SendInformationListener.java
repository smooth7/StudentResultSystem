package controllers.sendInformation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.SendCommunicationDAO;
import views.SendMessageGUI;

public class SendInformationListener implements ActionListener{
	
	static SendMessageGUI sendNotificationsGUI;
	SendCommunicationDAO sendNotificationsDAO = new SendCommunicationDAO();
	
	ArrayList<String> notificationList = new ArrayList<String>();
	
	String informationMessage = "";
	boolean lecturersSelectionStatus = false;
	boolean studentsSelectionStatus = false;
	
	
	public void actionPerformed(ActionEvent e){
		
		informationMessage = sendNotificationsGUI.getMessage().getText();
		lecturersSelectionStatus = sendNotificationsGUI.getLecturersSelection();
		studentsSelectionStatus = sendNotificationsGUI.getStudentsSelection();
		
		//Get list of those to receive notification
		getObserverList();
		
		InformationSubject notificationSubject = new InformationSubject();
		
		//for adding observer
		for (String notificationInfo : notificationList) {
			String[] notificationInfoParts = notificationInfo.split(";");
			String notificationId = notificationInfoParts[0];
			String notificationUserType = notificationInfoParts[1];

			new NewsObserver(notificationSubject, notificationId, notificationUserType);
			
		}
		
		notificationSubject.setMessage(informationMessage);
		notificationList.removeAll(notificationList);
		sendNotificationsGUI.showUpdateSuccess();
	}
	
	//Get list of those to receive notification
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

		sendNotificationsGUI = new SendMessageGUI();
		
	}

}
