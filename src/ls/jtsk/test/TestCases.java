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
	    String gravidaNameString = "����test"+randomNum+"920";
	    int medicalNo = randomNum;
	    String doctorNameString = "�����test"+randomNum+"920";
	    String jieshengrenNameString = "�������"+randomNum+"920";
	    long caseId = CasesHelper.addCase(medicalNo, doctorNameString, jieshengrenNameString, gravidaNameString, age, "����д�����и�֢��������ע");
//	    CasesHelper.addCase(medicalNo, doctorNameString, gravidaNameString, age, "�и�֢");
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
		assertEquals(topCase.getGravida().getName().indexOf("����test"), 0);
		assertEquals(topCase.getDoctor().getDoctorName().indexOf("�����test"), 0);
	}
	
	// TODO ����Ա�Ĺ�������automate everything�������ܲ���һ��ִ�����е�automation case��
	
	@Test
	public void testModifyCase() {
		testAddCase(); // ���һ������
		List list = CasesHelper.getLatestCases(1); // ��������һ���б�
		Cases topCase = (Cases) list.get(0); // ȡ����һ������
	    String oldGrividaName = topCase.getGravida().getName();
	    int oldGravidaAge = topCase.getGravida().getAge();
		int oldMedicalNo = topCase.getGravida().getMedicNo();
	    String oldDoctorName = topCase.getDoctor().getDoctorName();
	    CasesHelper.modifyCase(topCase.getId(), oldGrividaName, oldGravidaAge+1, oldMedicalNo, oldDoctorName, "�µ�comment");
		list = CasesHelper.getLatestCases(1); // ��������һ���б�
		topCase = (Cases) list.get(0); // ȡ����һ������
		assertEquals(topCase.getGravida().getAge(), 23);
	}
	
	@Test
	public void testDeleteCase() {
		testAddCase();
		List list = CasesHelper.getLatestCases(1); // ��������һ���б�
		Cases topCase = (Cases) list.get(0); // ȡ����һ������
	    CasesHelper.deleteCase(topCase.getId());
	}
	
}