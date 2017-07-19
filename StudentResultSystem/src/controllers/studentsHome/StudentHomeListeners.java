package controllers.studentsHome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllers.studentcheckGradeInfo.CheckGradeListener;
import controllers.viewNotifications.ViewNotificationsListener;
import views.StudentCheckGradeInfoGUI;

//Listeners for the buttons in the AdminHome page

public class StudentHomeListeners {

	public class CheckGradesListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			CheckGradeListener.createGUI();
			
		}


	}

	public class NotificationsListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			ViewNotificationsListener.createGUI();
			
		}


	}

}
