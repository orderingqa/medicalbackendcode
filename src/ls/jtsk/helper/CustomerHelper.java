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
		// 从offset数字后面的记录往后算，取第几条数据, order by是排序依据
		SQLQuery sqlQuery = HibernateTestUtil.session.createSQLQuery(
				"select {c.*} from Customer c order by id desc limit 1");
		sqlQuery.addEntity("c", Customer.class);
		Customer customer = null;
		List list = sqlQuery.list();
		if (list.size() > 0) customer = (Customer) list.get(0);
		HibernateTestUtil.destroySession();
//      如果我不进行detroySession，我可以返回给client端可以进行级联查询的list。但这样存在问题。比如：
//		如果不destroySession的一个问题在于，我此时创建一个case，这时候进行提交时会遇到database is locked的错误。
//		看起来是因为写记录的时候发现数据库已经被读出来了。所以建立了锁
        // TODO 需要一个克隆函数能够将一系列对象都返回，或者直接返回json供前台解析。		
		return customer;
	}
	
	public static Customer getCustomerById(long id) {
//		TODO 学会怎么样扔出不支持的异常
//		throws UnsupportedOperationException;
		HibernateTestUtil.getSession();
		Customer customer = (Customer) HibernateTestUtil.session.load(Customer.class, id);
    	HibernateTestUtil.destroySession();
		return customer;
	}
	
//	TODO 怎么样让创建成功后返回ID？考虑到安全性，还是不要id
	public static void addNewCustomer(	
	    String hospitalAndDepString,
        String name,
        String email,
	    String phone,
	    String departmentString) {
//		TODO 必须handle错误，数据库连接不上怎么办，磁盘慢了怎么办，各种原因失败了，怎么办？log呢？
        if (hospitalAndDepString != null && hospitalAndDepString.trim().length() > 0) {
        	HibernateTestUtil.getSession();
        	Customer customer = new Customer();
//        	TODO 连续的set属性域操作看起来十分愚蠢
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
