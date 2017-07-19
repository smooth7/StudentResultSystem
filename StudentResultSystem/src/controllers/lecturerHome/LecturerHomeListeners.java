package controllers.lecturerHome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllers.marks.SubmitMarkListener;
import controllers.viewNotifications.ViewNotificationsListener;


//Listeners for the buttons in the LecturerHome page

public class LecturerHomeListeners {

	public class EnterScoresListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			SubmitMarkListener.createGUI();
			
		}


	}

	public class NotificationsListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			ViewNotificationsListener.createGUI();
			
		}


	}

	
}
