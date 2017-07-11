package views;
import javax.swing.*;

import controllers.adminHome.AdminHomeListeners;

import java.awt.Font;
import java.awt.GridLayout;

public class AdminHome extends JFrame {

	JButton buttonRegStudents, buttonRegLecturers, buttonRegModules, buttonViewNotifications, buttonConfirmRequest, buttonRequestRemark;
	JLabel labelSpace;
	
	AdminHomeListeners adminHomeListeners = new AdminHomeListeners();
	
	public AdminHome(){
			
		this.setTitle("Admin Home Page");
		this.setResizable(false);
		this.setSize(700, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		Font font = new Font("Helvetica", Font.PLAIN, 22);
				
		JPanel jPanelObject = new JPanel();
		
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
		
		JPanel buttonNotificationPanel = new JPanel();
		buttonViewNotifications = new JButton("View Notifications");
		buttonViewNotifications.setFont(font);
		AdminHomeListeners.NotificationsListener notificationsListener = adminHomeListeners.new NotificationsListener();
		buttonViewNotifications.addActionListener(notificationsListener);
		buttonNotificationPanel.add(buttonViewNotifications);
		jPanelObject.add(buttonNotificationPanel);
		
		JPanel buttonConfirmRequestPanel = new JPanel();
		buttonConfirmRequest = new JButton("Confirm student remark request");
		buttonConfirmRequest.setFont(font);
		AdminHomeListeners.ConfirmRequestListener confirmRequestListener = adminHomeListeners.new ConfirmRequestListener();
		buttonConfirmRequest.addActionListener(confirmRequestListener);
		buttonConfirmRequestPanel.add(buttonConfirmRequest);
		jPanelObject.add(buttonConfirmRequestPanel);
		
		JPanel buttonRequestRemarkPanel = new JPanel();
		buttonRequestRemark = new JButton("Request for Module remark");
		buttonRequestRemark.setFont(font);
		AdminHomeListeners.RequestRemarkListener requestRemarkListener = adminHomeListeners.new RequestRemarkListener();
		buttonRequestRemark.addActionListener(requestRemarkListener);
		buttonRequestRemarkPanel.add(buttonRequestRemark);
		jPanelObject.add(buttonRequestRemarkPanel);
		
		this.add(jPanelObject);
		this.setVisible(true);
		
	}
	
}
