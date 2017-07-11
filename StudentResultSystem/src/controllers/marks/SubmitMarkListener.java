package controllers.marks;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import model.MarksDAO;
import views.Marks;
import views.ModuleDetailsEntry;

public class SubmitMarkListener implements ActionListener{
	
	static MarksDAO marksDAO = new MarksDAO();
	Marks marks;

	public void actionPerformed(ActionEvent e){
		
		if (e.getSource() == marks.getSubmitButton()){
			
		}else if (e.getSource() == marks.getChangeModuleCombo()){
			
			
			
		}
		
	}


	public static void createGUI(){

		ArrayList<String> moduleInfoList = marksDAO.getModuleDetails();
		
		new Marks(moduleInfoList);
	}
	
}
