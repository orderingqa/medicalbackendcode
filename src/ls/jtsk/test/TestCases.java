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
	    String gravidaNameString = "病历test"+randomNum+"920";
	    int medicalNo = randomNum;
	    String doctorNameString = "刘大夫test"+randomNum+"920";
	    String jieshengrenNameString = "接生大夫"+randomNum+"920";
	    long caseId = CasesHelper.addCase(medicalNo, doctorNameString, jieshengrenNameString, gravidaNameString, age, "请填写类似孕高症等其他备注");
//	    CasesHelper.addCase(medicalNo, doctorNameString, gravidaNameString, age, "孕高症");
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
	
	// TODO 程序员的工作就是automate everything，比如能不能一键执行所有的automation case？
	
	@Test
	public void testModifyCase() {
		testAddCase(); // 添加一个病历
		List list = CasesHelper.getLatestCases(1); // 检索出来一个列表
		Cases topCase = (Cases) list.get(0); // 取出第一个病历
	    String oldGrividaName = topCase.getGravida().getName();
	    int oldGravidaAge = topCase.getGravida().getAge();
		int oldMedicalNo = topCase.getGravida().getMedicNo();
	    String oldDoctorName = topCase.getDoctor().getDoctorName();
	    CasesHelper.modifyCase(topCase.getId(), oldGrividaName, oldGravidaAge+1, oldMedicalNo, oldDoctorName, "新的comment");
		list = CasesHelper.getLatestCases(1); // 检索出来一个列表
		topCase = (Cases) list.get(0); // 取出第一个病历
		assertEquals(topCase.getGravida().getAge(), 23);
	}
	
	@Test
	public void testDeleteCase() {
		testAddCase();
		List list = CasesHelper.getLatestCases(1); // 检索出来一个列表
		Cases topCase = (Cases) list.get(0); // 取出第一个病历
	    CasesHelper.deleteCase(topCase.getId());
	}
	
}