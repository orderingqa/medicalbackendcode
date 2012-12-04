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

public class TestEncryptModule {

	@Test
	public void testGenerateMacAddress() {
		assertEquals(NetID.getMacAddressFromSystemCall(), "50-E5-49-D9-60-8D");
	}
	
	@Test
	public void testTransferFromMacAddressToNumber() {
		String macAddress = "50-E5-49-D9-60-8D";
		assertEquals(NetID.generateSnFromMacAddressToNumber(macAddress), 501549096080L);
        macAddress = null;
        assertEquals(NetID.generateSnFromMacAddressToNumber(macAddress), 10016957L);
        macAddress = "00-00-00-00-00-00";
        assertEquals(NetID.generateSnFromMacAddressToNumber(macAddress), 10016957L);
	}
	
	@Test
	public void testFinalOutsideInterface() {
		assertEquals(NetID.generateApplyNumber(), 501549096080L);
        assertEquals(NetID.isValidActivateNumber(501549096080L), true);
	}
	
    @Test
    public void testGenerateActivateNumber() {
    	long sn = 0L;
    	assertEquals(NetID.finalActivateNumberGenerate(sn), new Long(10016959*17).toString().subSequence(0, 9));
    	sn = NetID.generateSnFromMacAddressToNumber("50-E5-49-D9-60-8D");
    	assertEquals(NetID.finalActivateNumberGenerate(sn), "852650492");
    }
	
}
