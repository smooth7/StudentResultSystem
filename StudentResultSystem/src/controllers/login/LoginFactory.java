package controllers.login;

public class LoginFactory {
	
	public ILogin getUserTypeInstance(String userType){
		
		if (userType.equals("student login")){
			return new StudentLogin();
		}else if (userType.equals("lecturer login")){
			return new LecturerLogin();
		}else if (userType.equals("admin login")){
			return new AdminLogin();
		}else{
			return null;
		}
		
	}

}
