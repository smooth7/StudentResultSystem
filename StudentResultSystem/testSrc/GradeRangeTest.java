import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import controllers.studentcheckGradeInfo.CheckGradeListener;
import model.MarksDAO;
import views.LoginGUI;
import views.StudentCheckGradeInfoGUI;

public class GradeRangeTest {
	
	
	@Before
	public void setUp() throws Exception {}
	
	//Test to ensure the right output is returned for score
	@Test
	public void testScoreValueRange() {
		
		
		int inputLowValue = -2;
		int inputHighValue = 101;
		int inputUnmarkedValue = -1;
		
		String expectedUnMarkedResult = "Sorry, the result for this module is not yet out";
		String expectedOutOfRangeResult = "Invalid entry";
		
		assertEquals(expectedUnMarkedResult, CheckGradeListener.getGrade(inputUnmarkedValue));
		assertEquals(expectedOutOfRangeResult, CheckGradeListener.getGrade(inputHighValue));
		assertEquals(expectedOutOfRangeResult, CheckGradeListener.getGrade(inputLowValue));
		
	}

}
