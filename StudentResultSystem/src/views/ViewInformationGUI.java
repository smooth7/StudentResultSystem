package views;
import javax.swing.*;

import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

public class ViewInformationGUI extends JFrame {

	DefaultListModel<String> notificationsDefaultList = new DefaultListModel<String>();
	JList<String> notificationsJList;
	JScrollPane scroller;
	static JTextArea notificationMessage;
	
	static Font font = new Font("Helvetica", Font.PLAIN, 22);
	
	public ViewInformationGUI(){
		createGUI();
	}
	
	public void createGUI(){
		
		// Define the size of the frame
		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Your notifications are in the text panel");
				
		JPanel jPanelObject = new JPanel();
		jPanelObject.setLayout(new GridLayout(0,1,2,4));
		
		JPanel messagePanel = new JPanel();
		notificationMessage = new JTextArea(12, 40);
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
	
	//gets all messages and inserts it to notificationMessage variable
	public static void insertMessageList(ArrayList<String> messageList){
		
		for (String message : messageList) {
			notificationMessage.append(message + "\n");
		}
		notificationMessage.setFont(font);
		
	}
	
}
