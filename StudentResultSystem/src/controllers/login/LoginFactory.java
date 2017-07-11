package controllers.login;

public class LoginFactory {
	
	public ILogin getUserTypeInstance(String userType){
		
		if (userType.equals("Student login")){
			return new StudentLogin();
		}else if (userType.equals("Lecturer login")){
			return new LecturerLogin();
		}else if (userType.equals("Admin login")){
			return new AdminLogin();
		}else{
			return null;
		}
		
	}

}
