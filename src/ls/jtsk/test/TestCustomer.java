package ls.jtsk.test;

import static org.junit.Assert.*;
import ls.jtsk.helper.CustomerHelper;
import ls.jtsk.model.Customer;

import org.junit.Test;

public class TestCustomer {
    
	@Test
	public void testCreateHospitalCustomer() { 
		CustomerHelper.addNewCustomer("宣武医院妇产科", "使用者姓名", null, null, null);
		Customer customer = CustomerHelper.getFirstCustomer();
		assertEquals(customer.getHospitalAndDepString(), "宣武医院妇产科");
	}
	
	
	@Test
	public void testUpdateCustomerActivateStatus() {
		CustomerHelper.updateCustomerWithActivated(1);
		assertEquals(CustomerHelper.getFirstCustomer().getIsActivated(), 1);
	}
}
