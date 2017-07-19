package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connector.MySqlConnection;
import modelInterfaces.ILecturerDetailsInput;

public class LecturerDetailsDAO implements ILecturerDetailsInput {
	
	public boolean insertLecturerDetails(String lecturerName, String lecturerDepartment){
		
		MySqlConnection mySqlConnection = new MySqlConnection();;
		Connection connectionInstance = null;
		
		try{
			
		connectionInstance = mySqlConnection.getConnection();
		
		String insertLecturerQuery = "insert into lecturer_details "
				+ " (lecturer_name, lecturer_department, lecturer_password)"
				+ " values (?, ?, ?)";
		
		PreparedStatement preparedInsertLecturer = connectionInstance.prepareStatement(insertLecturerQuery);
		preparedInsertLecturer.setString(1, lecturerName);
		preparedInsertLecturer.setString(2, lecturerDepartment);
		preparedInsertLecturer.setString(3, "lecturer");
	      
		int numbeOfRows = preparedInsertLecturer.executeUpdate();
		
		if(numbeOfRows>0){
			return true;
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
		return false;
}
}
