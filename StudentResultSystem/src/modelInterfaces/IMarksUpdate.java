package modelInterfaces;

public interface IMarksUpdate {
	boolean updateStudentScore(int score, String studentId, String moduleId, String moduleYear, String lecturerId);
}
