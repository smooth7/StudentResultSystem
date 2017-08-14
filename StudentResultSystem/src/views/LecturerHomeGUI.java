package views;
import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;

import controllers.lecturerHome.LecturerHomeListeners;

public class LecturerHomeGUI extends JFrame {

	LecturerHomeListeners lecturerHomeListeners = new LecturerHomeListeners();
	
	JButton buttonEnterScores, buttonViewNotifications;
	JLabel labelSpace;
	
	public LecturerHomeGUI(){
		createGUI();
	}
	
	public void createGUI(){
		
		this.setTitle("Lecturer Home Page");
		this.setResizable(false);
		this.setSize(700, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		
		Font font = new Font("Helvetica", Font.PLAIN, 22);
				
		JPanel jPanelObject = new JPanel();
		
		jPanelObject.setLayout(new GridLayout(0,1,2,2));
		
		JPanel buttonScoresPanel = new JPanel();
		buttonEnterScores = new JButton("Enter students' scores");
		buttonEnterScores.setFont(font);
		LecturerHomeListeners.EnterScoresListener enterScoresListener = lecturerHomeListeners.new EnterScoresListener();
		buttonEnterScores.addActionListener(enterScoresListener);
		buttonScoresPanel.add(buttonEnterScores);
		jPanelObject.add(buttonScoresPanel);
		
		JPanel buttonNotificationPanel = new JPanel();
		buttonViewNotifications = new JButton("View Notifications");
		buttonViewNotifications.setFont(font);
		LecturerHomeListeners.AnnouncementListener notificationsListener = lecturerHomeListeners.new AnnouncementListener();
		buttonViewNotifications.addActionListener(notificationsListener);
		buttonNotificationPanel.add(buttonViewNotifications);
		jPanelObject.add(buttonNotificationPanel);
		
		this.add(jPanelObject);
		this.setVisible(true);
		
	}
	
}
