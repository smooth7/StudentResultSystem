package modelInterfaces;

public interface ILoginDAO {
	boolean checkStudentInfo(String studentId, String studentPassword);
	boolean checkLecturerInfo(String lecturerId, String lecturerPassword);
	boolean checkAdminInfo(String adminId, String adminPassword);
}
