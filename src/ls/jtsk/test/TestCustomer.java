package ls.jtsk.test;

import static org.junit.Assert.*;
import ls.jtsk.helper.CustomerHelper;
import ls.jtsk.model.Customer;

import org.junit.Test;

public class TestCustomer {
    
	@Test
	public void testCreateHospitalCustomer() { 
		CustomerHelper.addNewCustomer("����ҽԺ������", "ʹ��������", null, null, null);
		Customer customer = CustomerHelper.getFirstCustomer();
		assertEquals(customer.getHospitalAndDepString(), "����ҽԺ������");
	}
	
	
	@Test
	public void testUpdateCustomerActivateStatus() {
		CustomerHelper.updateCustomerWithActivated(1);
		assertEquals(CustomerHelper.getFirstCustomer().getIsActivated(), 1);
	}
}
