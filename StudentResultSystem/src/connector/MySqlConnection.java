package connector;
import java.sql.Connection;
import java.sql.DriverManager;

public class MySqlConnection {
	
	//To get JDBC connection to MYSQL database with singleton pattern
	
	private Connection myConnectionInstance = null;
	
		public Connection getConnection(){
			
			if(myConnectionInstance == null){
			
				try{
					
					//Get a connection
					this.myConnectionInstance = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_result_system?autoReconnect=true&useSSL=false", "root", "Iniobong Mbuk 8");
					
					
				}catch(Exception ex){
					ex.printStackTrace();
				}
			
			}

			return myConnectionInstance;
		}
}
