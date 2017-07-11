package views;
import javax.swing.*;

import controllers.studentsHome.StudentHomeListeners;

import java.awt.Font;
import java.awt.GridLayout;

public class StudentHome extends JFrame {

	JButton buttonCheckGrades, buttonRequestRemark, buttonViewNotifications;
	JLabel labelSpace;
	
	StudentHomeListeners studentHomeListeners = new StudentHomeListeners();
	
	public StudentHome(){
			
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
		
		JPanel buttonRequestRemarkPanel = new JPanel();
		buttonRequestRemark = new JButton("Request for Module remark");
		buttonRequestRemark.setFont(font);
		StudentHomeListeners.RequestRemarkListener requestRemarkListener = studentHomeListeners.new RequestRemarkListener();
		buttonRequestRemark.addActionListener(requestRemarkListener);
		buttonRequestRemarkPanel.add(buttonRequestRemark);
		jPanelObject.add(buttonRequestRemarkPanel);
		
		this.add(jPanelObject);
		this.setVisible(true);
		
	}
	
}
