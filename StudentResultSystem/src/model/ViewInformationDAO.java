package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import connector.MySqlConnection;

public class ViewInformationDAO {

public ArrayList<String> getNewsList(String loginId, String loginUserType){
		
		MySqlConnection mySqlConnection = new MySqlConnection();
		Connection connectionInstance = null;
		
		connectionInstance = mySqlConnection.getConnection();
		ArrayList<String> messageList = new ArrayList<String>();
		
		try{
			
		String selectStatement = "SELECT * FROM notification WHERE receiver_id = ? and receiver_type = ?";
		PreparedStatement preparedStatement = connectionInstance.prepareStatement(selectStatement);
		
		preparedStatement.setString(1, loginId);
		preparedStatement.setString(2, loginUserType);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			messageList.add("From: " + resultSet.getString("sender") + ": " + resultSet.getString("message"));
			
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
		return messageList;
	}
}
