package modelInterfaces;

import java.util.ArrayList;

public interface IModuleDetailsInput {
	
	boolean insertModuleDetails(String moduleName, String moduleDepartment, String moduleLecturerId, String moduleYear);
	boolean insertModuleStudents(String moduleId, String moduleName, String moduleLecturerId, String moduleYear, ArrayList<String>moduleStudentIdList);
	
}
