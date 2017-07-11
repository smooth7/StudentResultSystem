package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import connector.MySqlConnection;

public class MarksDAO {

public ArrayList<String> getModuleDetails(){
		
		MySqlConnection mySqlConnection = new MySqlConnection();
		Connection connectionInstance = null;
		
		connectionInstance = mySqlConnection.getConnection();
		ArrayList<String> moduleInfoList = new ArrayList<String>();
		
		try{
		Statement queryStatement = connectionInstance.createStatement();
		ResultSet moduleDetailsSet = queryStatement.executeQuery("select * from module_details");
		
		//process the result set
		while(moduleDetailsSet.next()){
			moduleInfoList.add(moduleDetailsSet.getString("module_name") + " ( " + moduleDetailsSet.getString("module_year") + "; Id: " + moduleDetailsSet.getString("module_Id"));
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
	
	
}
