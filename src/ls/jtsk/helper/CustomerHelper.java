package ls.jtsk.helper;

import java.util.List;

import org.hibernate.SQLQuery;

import ls.jtsk.model.Cases;
import ls.jtsk.model.Customer;
import ls.jtsk.model.Gravida;
import ls.jtsk.util.HibernateTestUtil;

public class CustomerHelper {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	public static Customer getFirstCustomer() {
		HibernateTestUtil.getSession();
		// ��offset���ֺ���ļ�¼�����㣬ȡ�ڼ�������, order by����������
		SQLQuery sqlQuery = HibernateTestUtil.session.createSQLQuery(
				"select {c.*} from Customer c order by id desc limit 1");
		sqlQuery.addEntity("c", Customer.class);
		Customer customer = null;
		List list = sqlQuery.list();
		if (list.size() > 0) customer = (Customer) list.get(0);
		HibernateTestUtil.destroySession();
//      ����Ҳ�����detroySession���ҿ��Է��ظ�client�˿��Խ��м�����ѯ��list���������������⡣���磺
//		�����destroySession��һ���������ڣ��Ҵ�ʱ����һ��case����ʱ������ύʱ������database is locked�Ĵ���
//		����������Ϊд��¼��ʱ�������ݿ��Ѿ����������ˡ����Խ�������
        // TODO ��Ҫһ����¡�����ܹ���һϵ�ж��󶼷��أ�����ֱ�ӷ���json��ǰ̨������		
		return customer;
	}
	
	public static Customer getCustomerById(long id) {
//		TODO ѧ����ô���ӳ���֧�ֵ��쳣
//		throws UnsupportedOperationException;
		HibernateTestUtil.getSession();
		Customer customer = (Customer) HibernateTestUtil.session.load(Customer.class, id);
    	HibernateTestUtil.destroySession();
		return customer;
	}
	
//	TODO ��ô���ô����ɹ��󷵻�ID�����ǵ���ȫ�ԣ����ǲ�Ҫid
	public static void addNewCustomer(	
	    String hospitalAndDepString,
        String name,
        String email,
	    String phone,
	    String departmentString) {
//		TODO ����handle�������ݿ����Ӳ�����ô�죬����������ô�죬����ԭ��ʧ���ˣ���ô�죿log�أ�
        if (hospitalAndDepString != null && hospitalAndDepString.trim().length() > 0) {
        	HibernateTestUtil.getSession();
        	Customer customer = new Customer();
//        	TODO ������set���������������ʮ���޴�
        	customer.setHospitalAndDepString(hospitalAndDepString);
        	customer.setName(name);
        	customer.setEmail(email);
        	customer.setPhone(phone);
        	customer.setDepartmentString(departmentString);
        	HibernateTestUtil.session.save(customer);
        	HibernateTestUtil.destroySession();
        }		
	}
	

	
	/**
	 * 
	 * @param activated
	 */
	public static void updateCustomerWithActivated(int activated) {
		Customer c = CustomerHelper.getFirstCustomer();
		c.setIsActivated(activated);
		HibernateTestUtil.getSession();
		HibernateTestUtil.session.update(c);
		HibernateTestUtil.destroySession();
	}
}
