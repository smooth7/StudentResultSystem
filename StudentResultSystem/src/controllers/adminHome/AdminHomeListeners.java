package controllers.adminHome;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import controllers.lecturerDetailsEntry.SubmitLecturerListener;
import controllers.moduleDetailsEntry.SubmitModuleListener;
import controllers.sendInformation.SendInformationListener;
import controllers.studentDetailsEntry.SubmitStudentListener;

public class AdminHomeListeners {
	
	//Listeners for the buttons in the AdminHome page
	
	public class SendNotificationsListener implements ActionListener{
		
		public void actionPerformed(ActionEvent e){
			
			SendInformationListener.createGUI();
			
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

}
