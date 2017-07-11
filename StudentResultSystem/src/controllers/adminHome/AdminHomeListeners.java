package controllers.adminHome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import views.ConfirmRemark;
import controllers.lecturerDetailsEntry.SubmitLecturerListener;
import controllers.moduleDetailsEntry.SubmitModuleListener;
import controllers.studentDetailsEntry.SubmitStudentListener;
import views.Notifications;
import views.RemarkRequest;

public class AdminHomeListeners {
	
	public class ConfirmRequestListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			new ConfirmRemark();
			
		}


	}
	
	public class NotificationsListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			new Notifications();
			
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
