package modelInterfaces;

import java.util.ArrayList;

public interface IMarksDAO {
	ArrayList<String> getModuleDetails(String lecturerId);
	ArrayList<String> retrieveUnmarkedStudentsRecord(String moduleId, String moduleYear, String lecturerId);
	ArrayList<String> getStudentModuleList(String studentId);
	int getStudentScore(String studentId, String moduleId, String moduleYear);
	
}
