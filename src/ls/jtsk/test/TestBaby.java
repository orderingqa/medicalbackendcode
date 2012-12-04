package ls.jtsk.test;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import ls.jtsk.helper.BabyHelper;
import ls.jtsk.helper.CasesHelper;
import ls.jtsk.model.Gender;

import org.junit.Test;

public class TestBaby {
	
	@Test
	public void testAddBabyAfterAddedCase() {
		int randomNum = TestUtility.randomNumber();
	    int age = 22;
	    String gravidaNameString = "²¡Àú"+randomNum;
	    int medicalNo = randomNum;
	    String doctorNameString = "Áõ´ó·ò"+randomNum;
	    long caseId = CasesHelper.addCase(medicalNo, doctorNameString, gravidaNameString, age,null);
	    long babyId = BabyHelper.addBaby(caseId, Gender.BOY, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	}

}
