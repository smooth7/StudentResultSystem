package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connector.MySqlConnection;

public class ModuleDetailsDAO {

	
	public boolean insertModuleDetails(String moduleName, String moduleDepartment, String moduleLecturerId, String moduleYear){
		
		MySqlConnection mySqlConnection = new MySqlConnection();
		Connection connectionInstance = null;
		
		try{
			connectionInstance = mySqlConnection.getConnection();
			
			String insertModuleQuery = "insert into module_details "
				+ " (module_name, module_department, module_year, lecturer_id)"
				+ " values (?, ?, ?, ?)";
		
		PreparedStatement preparedInsertModule = connectionInstance.prepareStatement(insertModuleQuery);
		preparedInsertModule.setString(1, moduleName);
		preparedInsertModule.setString(2, moduleDepartment);
		preparedInsertModule.setString(3, moduleYear);
		preparedInsertModule.setString(4, moduleLecturerId);
	      
		int numbeOfRows = preparedInsertModule.executeUpdate();
		
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
	
	public boolean insertModuleStudents(String moduleId, String moduleLecturerId, String moduleYear, ArrayList<String>moduleStudentIdList){
		
		MySqlConnection mySqlConnection = new MySqlConnection();
		Connection connectionInstance = null;
		
		int numbeOfRows = 0;
		
		for (String studentId : moduleStudentIdList) {
			
		connectionInstance = mySqlConnection.getConnection();
		try{
		
			String insertModuleQuery = "insert into result "
				+ " (module_id, student_id, module_year, lecturer_id)"
				+ " values (?, ?, ?, ?)";
		
		PreparedStatement preparedInsertModule = connectionInstance.prepareStatement(insertModuleQuery);
		preparedInsertModule.setString(1, moduleId);
		preparedInsertModule.setString(2, studentId);
		preparedInsertModule.setString(3, moduleYear);
		preparedInsertModule.setString(4, moduleLecturerId);
	      
		numbeOfRows = preparedInsertModule.executeUpdate();
		
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
		if(numbeOfRows>0){
			return true;
		}
		
		return false;
	}
	
	
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
			lecturerInfoList.add(lecturerDetailsSet.getString("lecturer_name") + "; Id: " + lecturerDetailsSet.getString("lecturer_id"));
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
			studentInfoList.add(studentDetailsSet.getString("student_name") + "; Id: " + studentDetailsSet.getString("student_id"));
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
	
	public String getCurrentModuleId(){
		
		MySqlConnection mySqlConnection = new MySqlConnection();
		Connection connectionInstance = null;
		
		String moduleId = "";
		
		connectionInstance = mySqlConnection.getConnection();
		try{
			
		Statement queryStatement = connectionInstance.createStatement();
		ResultSet moduleIdSet = queryStatement.executeQuery("Select module_Id from module_details order by module_Id desc limit 1");
		
		//process the result set
		while(moduleIdSet.next()){
			moduleId = moduleIdSet.getString("module_Id");
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
		return moduleId;
	}
}

