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
	    String gravidaNameString = "²¡Àú"+randomNum;
	    int medicalNo = randomNum;
	    String doctorNameString = "Áõ´ó·ò"+randomNum;
	    CasesHelper chCasesHelper = new CasesHelper();
	    chCasesHelper.addCase(age, gravidaNameString, medicalNo, doctorNameString);
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
		CasesHelper ch = new CasesHelper();
		List list = ch.getLatestCases(2);
		assertEquals(list.size(), 2);
		assertEquals(((Cases)list.get(0)).getCreateDate(), "2012-10-14 16:05:04");
	}
}