package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connector.MySqlConnection;
import modelInterfaces.IMarksDAO;
import modelInterfaces.IMarksUpdate;

public class MarksDAO implements IMarksUpdate, IMarksDAO {

	//Get all the module details a lecturer is handling
	public ArrayList<String> getModuleDetails(String lecturerId){
		
		MySqlConnection mySqlConnection = new MySqlConnection();
		Connection connectionInstance = null;
		
		connectionInstance = mySqlConnection.getConnection();
		ArrayList<String> moduleInfoList = new ArrayList<String>();
		
		try{
			
		Statement queryStatement = connectionInstance.createStatement();
		ResultSet moduleInfoResultSet = queryStatement.executeQuery("select * from module_details");
		
		while(moduleInfoResultSet.next()){
			moduleInfoList.add(moduleInfoResultSet.getString("module_name") + " (" + moduleInfoResultSet.getString("module_year") + "); Id: " + moduleInfoResultSet.getString("module_Id"));
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
		return moduleInfoList;
	}
	
	public ArrayList<String> retrieveUnmarkedStudentsRecord(String moduleId, String moduleYear, String lecturerId){
		
		MySqlConnection mySqlConnection = new MySqlConnection();
		Connection connectionInstance = null;
		
		connectionInstance = mySqlConnection.getConnection();
		ArrayList<String> unmarkedStudentList = new ArrayList<String>();
		
		try{
			
		String selectStatement = "SELECT student_id FROM result WHERE module_id = ? and module_year = ? and lecturer_id = ? and score = ?";
		PreparedStatement preparedStatement = connectionInstance.prepareStatement(selectStatement);
		
		preparedStatement.setString(1, moduleId);
		preparedStatement.setString(2, moduleYear);
		preparedStatement.setString(3, lecturerId);
		preparedStatement.setInt(4, -1);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			unmarkedStudentList.add(resultSet.getString("student_id"));
			
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
		return unmarkedStudentList;
	}
	
	//get module list which a student is offering
	public ArrayList<String> getStudentModuleList(String studentId){
		
		MySqlConnection mySqlConnection = new MySqlConnection();
		Connection connectionInstance = null;
		
		connectionInstance = mySqlConnection.getConnection();
		ArrayList<String> studentScoreList = new ArrayList<String>();
		
		try{
			
		String selectStatement = "SELECT * FROM result WHERE student_id = ?";
		PreparedStatement preparedStatement = connectionInstance.prepareStatement(selectStatement);
		
		preparedStatement.setString(1, studentId);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			studentScoreList.add(resultSet.getString("module_name") + " (" + resultSet.getString("module_year") + "); Id: " + resultSet.getString("module_Id"));
			
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
		return studentScoreList;
	}
	
	//Get score for a student
	public int getStudentScore(String studentId, String moduleId, String moduleYear){
		
		MySqlConnection mySqlConnection = new MySqlConnection();
		Connection connectionInstance = null;
		
		connectionInstance = mySqlConnection.getConnection();
		int studentScore = 0;
		
		try{
			
		String selectStatement = "SELECT score FROM result WHERE student_id = ? and module_id = ? and module_year = ?";
		PreparedStatement preparedStatement = connectionInstance.prepareStatement(selectStatement);
		
		preparedStatement.setString(1, studentId);
		preparedStatement.setString(2, moduleId);
		preparedStatement.setString(3, moduleYear);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while (resultSet.next()) {
			studentScore = resultSet.getInt("score");
			
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
		return studentScore;
	}

	//lecturer update student score
	public boolean updateStudentScore(int score, String studentId, String moduleId, String moduleYear, String lecturerId){
		
		MySqlConnection mySqlConnection = new MySqlConnection();
		Connection connectionInstance = null;
		
		try{
			connectionInstance = mySqlConnection.getConnection();
			
			String updateScoreQuery = "update result set score = ? where student_id =? and module_id = ? and module_year = ? and lecturer_id = ?";
				
		PreparedStatement preparedUpdateScore = connectionInstance.prepareStatement(updateScoreQuery);
		preparedUpdateScore.setInt(1, score);
		preparedUpdateScore.setString(2, studentId);
		preparedUpdateScore.setString(3, moduleId);
		preparedUpdateScore.setString(4, moduleYear);
		preparedUpdateScore.setString(5, lecturerId);
	      
		int numbeOfRows = preparedUpdateScore.executeUpdate();
		
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
