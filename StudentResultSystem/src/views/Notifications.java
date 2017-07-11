package views;
import javax.swing.*;

import java.awt.Font;
import java.awt.GridLayout;

public class Notifications extends JFrame {

	JLabel labelInformation, labelNotificationsList;
	DefaultListModel<String> notificationsDefaultList = new DefaultListModel<String>();
	JList<String> notificationsJList;
	JScrollPane scroller;
	JTextArea notificationMessage;
	
	public Notifications(){
			
		// Define the size of the frame
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("View your notifications");
				
		JPanel jPanelObject = new JPanel();
		jPanelObject.setLayout(new GridLayout(0,1,2,4));
		Font font = new Font("Helvetica", Font.PLAIN, 22);
		
		JPanel infoPanel = new JPanel();
		labelInformation = new JLabel("Your notifications are listed below");
		labelInformation.setFont(font);
		infoPanel.add(labelInformation);
		jPanelObject.add(infoPanel);
		
		JPanel notificationsPanel = new JPanel();
		labelNotificationsList = new JLabel("Select a notification to view");
		labelNotificationsList.setFont(font);
		notificationsPanel.add(labelNotificationsList);
		
		String[] listOfNotifications = {""};
		
		for(String notificationInfo: listOfNotifications){
			notificationsDefaultList.addElement(notificationInfo);
		}
		
		notificationsJList = new JList<String>(notificationsDefaultList);
		notificationsJList.setFont(font);
		
		scroller = new JScrollPane(notificationsJList, 
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, 
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		notificationsJList.setFixedCellHeight(150);
		notificationsJList.setFixedCellWidth(250);
		notificationsPanel.add(notificationsJList);
		notificationsPanel.add(scroller);
		jPanelObject.add(notificationsPanel);
		
		JPanel messagePanel = new JPanel();
		notificationMessage = new JTextArea(6, 40);
		notificationMessage.setLineWrap(true);
		notificationMessage.setWrapStyleWord(true);
		scroller = new JScrollPane(notificationMessage, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		notificationMessage.setEditable(false);
		messagePanel.add(notificationMessage);
		messagePanel.add(scroller);
		jPanelObject.add(messagePanel);
		
		this.add(jPanelObject);
		this.setVisible(true);
		
	}
	
}
