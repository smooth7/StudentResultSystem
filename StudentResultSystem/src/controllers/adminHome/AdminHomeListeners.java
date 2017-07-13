package controllers.adminHome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.ConfirmRemark;
import controllers.lecturerDetailsEntry.SubmitLecturerListener;
import controllers.moduleDetailsEntry.SubmitModuleListener;
import controllers.sendNotifications.SendNotificationListener;
import controllers.studentDetailsEntry.SubmitStudentListener;
import views.ViewNotifications;
import views.RemarkRequest;
import views.SendNotificationsGUI;

public class AdminHomeListeners {
	
	public class ConfirmRequestListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			new ConfirmRemark();
			
		}


	}
	
	public class SendNotificationsListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			SendNotificationListener.createGUI();
			
		}


	}
	
	public class ViewNotificationsListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			new ViewNotifications();
			
		}


	}
	
	public class RegLecturerListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			SubmitLecturerListener.createGUI();
			
		}


	}
	
	public class RegModulesListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			SubmitModuleListener.createGUI();
			
		}


	}

	public class RegStudentListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			SubmitStudentListener.createGUI();
			
		}


	}

	public class RequestRemarkListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			new RemarkRequest();
			
		}


	}


}
