package views;
import javax.swing.*;

import controllers.remarkRequest.RemarkRequestListener;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;

public class RemarkRequest extends JFrame {

	JButton buttonSubmit;
	JLabel labelModuleInfo;
	JComboBox<String> comboModuleInfo;
	
	public RemarkRequest(){
			
		// Define the size of the frame
		this.setSize(800, 400);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setTitle("Place a remark request");
				
		JPanel jPanelObject = new JPanel();
		jPanelObject.setLayout(new GridLayout(0,1,2,4));
		Font font = new Font("Helvetica", Font.PLAIN, 22);
		
		JPanel moduleInfoPanel = new JPanel();
		labelModuleInfo = new JLabel("Select Module");
		labelModuleInfo.setFont(font);
		moduleInfoPanel.add(labelModuleInfo);
		
		String[] listOfModules = {""};
		comboModuleInfo = new JComboBox<String>(listOfModules);
		comboModuleInfo.setFont(font);
		moduleInfoPanel.add(comboModuleInfo);
		jPanelObject.add(moduleInfoPanel);
		
		JPanel submitPanel = new JPanel();
		buttonSubmit = new JButton("Request Remark");
		buttonSubmit.setFont(font);
		RemarkRequestListener remarkRequest = new RemarkRequestListener();
		buttonSubmit.addActionListener(remarkRequest);
		submitPanel.add(buttonSubmit);
		jPanelObject.add(submitPanel);
		
		this.add(jPanelObject);
		this.setVisible(true);
		
	}
	
}
