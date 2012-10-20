package ls.jtsk.util;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class HibernateTestUtil {
	public static Session session = null;
	static Transaction tx = null;
	
	public static void getSession() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	public static void destroySession() {
		tx.commit();
		session.close();
		HibernateUtil.shutdown();
	}
}