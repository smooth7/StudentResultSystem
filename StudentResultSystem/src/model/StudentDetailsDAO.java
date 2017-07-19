package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import connector.MySqlConnection;
import modelInterfaces.IStudentDetailsInput;

public class StudentDetailsDAO implements IStudentDetailsInput {
	
	public boolean insertStudentDetails(String studentName, String studentDepartment){
		
		MySqlConnection mySqlConnection = new MySqlConnection();;
		Connection connectionInstance = null;
		
		connectionInstance = mySqlConnection.getConnection();
		
		try{
		
		String insertStudentQuery = "insert into student_details "
				+ " (student_name, student_department, student_password)"
				+ " values (?, ?, ?)";
		
		PreparedStatement preparedInsertStudent = connectionInstance.prepareStatement(insertStudentQuery);
		preparedInsertStudent.setString(1, studentName);
		preparedInsertStudent.setString(2, studentDepartment);
		preparedInsertStudent.setString(3, "student");
	      
		int numbeOfRows = preparedInsertStudent.executeUpdate();
		
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
