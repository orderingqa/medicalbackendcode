package ls.jtsk.test;

import junit.framework.TestCase;
import ls.jtsk.model.*;
import ls.jtsk.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;


public class TestDoctor extends TestCase{

	public void testSave(){
		Doctor doctor = new Doctor();
		doctor.setDoctorName("¡ı¥Û∑Ú10");
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = session.beginTransaction();
		session.save(doctor);
		tx.commit();
		session.close();
		HibernateUtil.shutdown();
	}
}