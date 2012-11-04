package ls.jtsk.test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;

import org.junit.Test;
import ls.jtsk.helper.*;
import ls.jtsk.model.Apgar;
import ls.jtsk.model.Gender;


public class TestApgar {

//	@Test
//	public void testSaveApgar() {
//		
//        Apgar tstApgar = new Apgar();
//        tstApgar.setApgarInterval(6);
//        tstApgar.setActivity(6);
//        tstApgar.setAppearance(6);
//        tstApgar.setGrimace(6);
//        tstApgar.setPulse(6);
//        tstApgar.setRespiration(6);
//        Collection collection = new ArrayList<Apgar>();
//        collection.add(tstApgar);
//		
//        ApgarHelper.saveApgar(collection);
//	}
	
	@Test
	public void testAddApgarAfterBabyAndCase() {
		int randomNum = TestUtility.randomNumber();
	    int age = 22;
	    String gravidaNameString = "²¡Àú"+randomNum;
	    int medicalNo = randomNum;
	    String doctorNameString = "Áõ´ó·ò"+randomNum;
	    long caseId = CasesHelper.addCase(medicalNo, doctorNameString, gravidaNameString, age);
	    long babyId = BabyHelper.addBaby(caseId, Gender.BOY, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	    
        Apgar tstApgar = new Apgar();
        tstApgar.setApgarInterval(6);
        tstApgar.setActivity(6);
        tstApgar.setAppearance(6);
        tstApgar.setGrimace(6);
        tstApgar.setPulse(6);
        tstApgar.setRespiration(6);
        Collection collection = new ArrayList<Apgar>();
        collection.add(tstApgar);

        ApgarHelper.addApgar(caseId, babyId, collection);
	}
}
