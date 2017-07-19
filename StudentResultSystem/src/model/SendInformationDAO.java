package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connector.MySqlConnection;
import modelInterfaces.ISendInformationDAO;
import modelInterfaces.ISendInformationInput;

public class SendInformationDAO implements ISendInformationInput, ISendInformationDAO {

	public ArrayList<String> getLecturerDetails(){
		
		MySqlConnection mySqlConnection = new MySqlConnection();
		Connection connectionInstance = null;
		
		connectionInstance = mySqlConnection.getConnection();
		ArrayList<String> lecturerInfoList = new ArrayList<String>();
		
		try{
		Statement queryStatement = connectionInstance.createStatement();
		ResultSet lecturerDetailsSet = queryStatement.executeQuery("select * from lecturer_details");
		
		//process the result set
		while(lecturerDetailsSet.next()){
			lecturerInfoList.add(lecturerDetailsSet.getString("lecturer_id") + ";lecturer");
		}
		
		}
		catch(SQLException sqlException){
			sqlException.printStackTrace();
	   }catch(Exception exception){
		   exception.printStackTrace();
	   }finally{
		      try{
		          if(connectionInstance!=null)
		         	 connectionInstance.close();
		       }catch(SQLException sqlException){
		     	  sqlException.printStackTrace();
		       }
		    }
		return lecturerInfoList;
	}
	
	public ArrayList<String> getStudentDetails(){
		
		MySqlConnection mySqlConnection = new MySqlConnection();
		Connection connectionInstance = null;
		
		connectionInstance = mySqlConnection.getConnection();
		ArrayList<String> studentInfoList = new ArrayList<String>();
		
		try{
			
		Statement queryStatement = connectionInstance.createStatement();
		ResultSet studentDetailsSet = queryStatement.executeQuery("select * from student_details");
		
		//process the result set
		while(studentDetailsSet.next()){
			studentInfoList.add(studentDetailsSet.getString("student_id") + ";student");
		}
		
		}
		catch(SQLException sqlException){
			sqlException.printStackTrace();
	   }catch(Exception exception){
		   exception.printStackTrace();
	   }finally{
		      try{
		          if(connectionInstance!=null)
		         	 connectionInstance.close();
		       }catch(SQLException sqlException){
		     	  sqlException.printStackTrace();
		       }
		    }
		return studentInfoList;
	}
	
	public void updateAnnouncement(String message, String userType, String userId, String sender){
			
			MySqlConnection mySqlConnection = new MySqlConnection();
			Connection connectionInstance = null;
			
			try{
				connectionInstance = mySqlConnection.getConnection();
				
				String insertNotificationQuery = "insert into notification "
					+ " (receiver_type, receiver_id, sender, message)"
					+ " values (?, ?, ?, ?)";
			
			PreparedStatement preparedInsertNotification = connectionInstance.prepareStatement(insertNotificationQuery);
			preparedInsertNotification.setString(1, userType);
			preparedInsertNotification.setString(2, userId);
			preparedInsertNotification.setString(3, sender);
			preparedInsertNotification.setString(4, message);
		      
			preparedInsertNotification.executeUpdate();
			
		}
		
		catch(SQLException sqlException){
			sqlException.printStackTrace();
	   }catch(Exception exception){
		   exception.printStackTrace();
	   }finally{
		      try{
		          if(connectionInstance!=null)
		         	 connectionInstance.close();
		       }catch(SQLException sqlException){
		     	  sqlException.printStackTrace();
		       }
		    }
			
		}
	
	
}
