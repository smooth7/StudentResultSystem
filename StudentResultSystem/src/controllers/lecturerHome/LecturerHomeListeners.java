package controllers.lecturerHome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllers.marks.SubmitMarkListener;

public class LecturerHomeListeners {

	public class EnterScoresListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			SubmitMarkListener.createGUI();
			
		}


	}

	public class NotificationsListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			
			
		}


	}

	
}
