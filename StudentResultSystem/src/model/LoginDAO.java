package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import connector.MySqlConnection;
import modelInterfaces.ILoginDAO;

public class LoginDAO implements ILoginDAO {

	MySqlConnection mySqlConnection = new MySqlConnection();
	Connection connectionInstance = null;
	
	public boolean checkStudentInfo(String studentId, String studentPassword){
		
		connectionInstance = mySqlConnection.getConnection();
		
		try{
			
		String selectQuery = "select COUNT(*) from student_details where student_id = ? and student_password = ?";
		
		PreparedStatement preparedSelectQuery = connectionInstance.prepareStatement(selectQuery);
		preparedSelectQuery.setString(1, studentId);
		preparedSelectQuery.setString(2, studentPassword);
		
		ResultSet resultSet = preparedSelectQuery.executeQuery();
		int numbeOfRows = 0;
		
		while(resultSet.next()){
			numbeOfRows = resultSet.getInt(1);
		}
		
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
	
	public boolean checkLecturerInfo(String lecturerId, String lecturerPassword){
			
			connectionInstance = mySqlConnection.getConnection();
			
			try{
				
			String selectQuery = "select COUNT(*) from lecturer_details where lecturer_id = ? and lecturer_password = ?";
			
			PreparedStatement preparedSelectQuery = connectionInstance.prepareStatement(selectQuery);
			preparedSelectQuery.setString(1, lecturerId);
			preparedSelectQuery.setString(2, lecturerPassword);
			
			ResultSet resultSet = preparedSelectQuery.executeQuery();
			int numbeOfRows = 0;
			
			while(resultSet.next()){
				numbeOfRows = resultSet.getInt(1);
			}
			
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
	
	public boolean checkAdminInfo(String adminId, String adminPassword){
		
		connectionInstance = mySqlConnection.getConnection();
		
		try{
			
		String selectQuery = "select COUNT(*) from admin_details where admin_id = ? and admin_password = ?";
		
		PreparedStatement preparedSelectQuery = connectionInstance.prepareStatement(selectQuery);
		preparedSelectQuery.setString(1, adminId);
		preparedSelectQuery.setString(2, adminPassword);
		
		ResultSet resultSet = preparedSelectQuery.executeQuery();
		int numbeOfRows = 0;
		
		while(resultSet.next()){
			numbeOfRows = resultSet.getInt(1);
		}
		
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
