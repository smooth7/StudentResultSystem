package views;

import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import controllers.sendInformation.SendInformationListener;

public class SendMessageGUI extends JFrame {

	JTextArea textNotificationMessage;
	JLabel labelRecipients;
	JCheckBox allStudentsList, allLecturersList;
	JScrollPane scroller;
	JButton buttonSubmit;
	
	public SendMessageGUI(){
		createGUI();
	}
	
	public void createGUI(){

		this.setSize(900, 600);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Send notifications");
		
		JPanel jPanelObject = new JPanel();
		jPanelObject.setLayout(new GridLayout(0,1,2,4));
		Font font = new Font("Helvetica", Font.PLAIN, 22);
		
		JPanel recipientsLabelPanel = new JPanel();
		labelRecipients = new JLabel("Select notification recipients:");
		labelRecipients.setFont(font);
		recipientsLabelPanel.add(labelRecipients);
		jPanelObject.add(recipientsLabelPanel);
		
		JPanel recipientsCheckPanel = new JPanel();
		allStudentsList = new JCheckBox("All Students"); 
		allLecturersList = new JCheckBox("All Lecturers");
		allStudentsList.setFont(font);
		allLecturersList.setFont(font);
		recipientsCheckPanel.add(allStudentsList);
		recipientsCheckPanel.add(allLecturersList);
		jPanelObject.add(recipientsCheckPanel);
		
		JPanel messagePanel = new JPanel();
		textNotificationMessage = new JTextArea(12, 40);
		textNotificationMessage.setFont(font);
		textNotificationMessage.setLineWrap(true);
		textNotificationMessage.setWrapStyleWord(true);
		scroller = new JScrollPane(textNotificationMessage, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		messagePanel.add(textNotificationMessage);
		messagePanel.add(scroller);
		jPanelObject.add(messagePanel);
		
		JPanel submitPanel = new JPanel();
		buttonSubmit = new JButton("Send Notification");
		buttonSubmit.setFont(font);
		SendInformationListener sendNotificationListener = new SendInformationListener();
		buttonSubmit.addActionListener(sendNotificationListener);
		submitPanel.add(buttonSubmit);
		jPanelObject.add(submitPanel);
		
		this.add(jPanelObject);
		this.setVisible(true);
		
	}
	
	//determines whether or not notification should be sent to students
	public boolean getStudentsSelection(){
		
		if(allStudentsList.isSelected()){
			return true;
		}else{
			return false;
		}
		
	}
	
	//determines whether or not notification should be sent to lecturers
	public boolean getLecturersSelection(){
		
		if(allLecturersList.isSelected()){
			return true;
		}else{
			return false;
		}
		
	}
	
	public JTextArea getMessage() {
		return textNotificationMessage;
	}
	
	public void showValidationError(String errorMessage){
		
		JOptionPane.showMessageDialog(SendMessageGUI.this, errorMessage, "Correct input error", JOptionPane.ERROR_MESSAGE);
		
	}
	
	public void showUpdateSuccess(){
		JOptionPane.showMessageDialog(SendMessageGUI.this, "Notifications have been sent to all those concerned", "Information", JOptionPane.INFORMATION_MESSAGE);
	}
	
}
