package views;
import javax.swing.*;

import controllers.studentsHome.StudentHomeListeners;

import java.awt.Font;
import java.awt.GridLayout;

public class StudentHomeGUI extends JFrame {

	JButton buttonCheckGrades, buttonViewNotifications;
	
	StudentHomeListeners studentHomeListeners = new StudentHomeListeners();
	
	public StudentHomeGUI(){
		createGUI();
	}
	
	public void createGUI(){
		
		this.setTitle("Student Home Page");
		this.setResizable(false);
		this.setSize(700, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		Font font = new Font("Helvetica", Font.PLAIN, 22);
				
		JPanel jPanelObject = new JPanel();
		
		jPanelObject.setLayout(new GridLayout(0,1,2,2));
		
		JPanel buttonGradesPanel = new JPanel();
		buttonCheckGrades = new JButton("Check your grades");
		buttonCheckGrades.setFont(font);
		StudentHomeListeners.CheckGradesListener checkGradesListener = studentHomeListeners.new CheckGradesListener();
		buttonCheckGrades.addActionListener(checkGradesListener);
		buttonGradesPanel.add(buttonCheckGrades);
		jPanelObject.add(buttonGradesPanel);
		
		JPanel buttonNotificationPanel = new JPanel();
		buttonViewNotifications = new JButton("View Notifications");
		buttonViewNotifications.setFont(font);
		StudentHomeListeners.NotificationsListener notificationsListener = studentHomeListeners.new NotificationsListener();
		buttonViewNotifications.addActionListener(notificationsListener);
		buttonNotificationPanel.add(buttonViewNotifications);
		jPanelObject.add(buttonNotificationPanel);
		
		this.add(jPanelObject);
		this.setVisible(true);
		
	}
}
