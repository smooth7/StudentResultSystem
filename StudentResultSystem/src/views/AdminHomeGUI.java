package views;
import javax.swing.*;

import controllers.adminHome.AdminHomeListeners;

import java.awt.Font;
import java.awt.GridLayout;

public class AdminHomeGUI extends JFrame {

	JButton buttonRegStudents, buttonRegLecturers, buttonRegModules, buttonSendNotifications;
	JLabel labelSpace;
	
	//listener instance for button
	AdminHomeListeners adminHomeListeners = new AdminHomeListeners();
	
	public AdminHomeGUI(){
			
		createGUI();
	}
	
	public void createGUI(){
		
		this.setTitle("Admin Home Page");
		this.setResizable(false);
		this.setSize(700, 700);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Font font = new Font("Helvetica", Font.PLAIN, 22);
				
		JPanel jPanelObject = new JPanel();
		
		//defines layout
		jPanelObject.setLayout(new GridLayout(0,1,2,2));
		
		JPanel buttonRegStudentPanel = new JPanel();
		buttonRegStudents = new JButton("Register Students");
		buttonRegStudents.setFont(font);
		AdminHomeListeners.RegStudentListener regStudentsListener = adminHomeListeners.new RegStudentListener();
		buttonRegStudents.addActionListener(regStudentsListener);
		buttonRegStudentPanel.add(buttonRegStudents);
		jPanelObject.add(buttonRegStudentPanel);
		
		JPanel buttonRegLecturerPanel = new JPanel();
		buttonRegLecturers = new JButton("Register Lecturers");
		buttonRegLecturers.setFont(font);
		AdminHomeListeners.RegLecturerListener regLecturerListener = adminHomeListeners.new RegLecturerListener();
		buttonRegLecturers.addActionListener(regLecturerListener);
		buttonRegLecturerPanel.add(buttonRegLecturers);
		jPanelObject.add(buttonRegLecturerPanel);
		
		JPanel buttonRegModulePanel = new JPanel();
		buttonRegModules = new JButton("Register Modules");
		buttonRegModules.setFont(font);
		AdminHomeListeners.RegModulesListener regModuleListener = adminHomeListeners.new RegModulesListener();
		buttonRegModules.addActionListener(regModuleListener);
		buttonRegModulePanel.add(buttonRegModules);
		jPanelObject.add(buttonRegModulePanel);
		
		JPanel btnSendNotificationPanel = new JPanel();
		buttonSendNotifications = new JButton("Send Notifications");
		buttonSendNotifications.setFont(font);
		AdminHomeListeners.SendNotificationsListener sendNotificationsListener = adminHomeListeners.new SendNotificationsListener();
		buttonSendNotifications.addActionListener(sendNotificationsListener);
		btnSendNotificationPanel.add(buttonSendNotifications);
		jPanelObject.add(btnSendNotificationPanel);
		
		this.add(jPanelObject);
		this.setVisible(true);
		
	}
	
}
