package modelInterfaces;

import java.util.ArrayList;

public interface IModuleDetailsDAO {
	ArrayList<String> getLecturerDetails();
	ArrayList<String> getStudentDetails();
	String getCurrentModuleId();
}
