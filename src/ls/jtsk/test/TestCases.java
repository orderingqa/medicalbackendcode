/**
 * 
 */
package ls.jtsk.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import ls.jtsk.helper.CasesHelper;
import ls.jtsk.model.Cases;
import ls.jtsk.model.Doctor;
import ls.jtsk.model.Gravida;
import ls.jtsk.util.*;

import org.junit.Test;

import java.util.List;

/**
 * @author liushuai
 *
 */
public class TestCases {
	
	@Test
	public void testAddCase() {
		int randomNum = TestUtility.randomNumber();
	    int age = 22;
	    String gravidaNameString = "病历test"+randomNum;
	    int medicalNo = randomNum;
	    String doctorNameString = "刘大夫test"+randomNum;
	    long caseId = CasesHelper.addCase(medicalNo, doctorNameString, gravidaNameString, age);
	}
		
	@Test
	public void testGetCasesSortByField() {
		CasesHelper ch = new CasesHelper();
		List list = ch.getCasesSortByField(2, 1, "age DESC");
		assertEquals(list.size(), 2);
		assertEquals(((Cases)list.get(0)).getCreateDate(), "2012-10-14 16:05:04");
	}
	
	@Test
	public void testGetLatestCases() {
		testAddCase();
		CasesHelper ch = new CasesHelper();
		List list = ch.getLatestCases(5);
		assertEquals(list.size(), 5);
		Cases topCase = (Cases)list.get(0);
		assertEquals(topCase.getCreateDate().indexOf(new SimpleDateFormat("yyyy-MM-dd").format(new Date())), 0);
		assertEquals(topCase.getGravida().getName().indexOf("病历test"), 0);
		assertEquals(topCase.getDoctor().getDoctorName().indexOf("刘大夫test"), 0);
	}
}