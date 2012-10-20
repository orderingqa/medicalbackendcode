package ls.jtsk.test;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ls.jtsk.model.Apgar;
import ls.jtsk.model.Apgarinterval;
import ls.jtsk.model.Baby;
import ls.jtsk.model.Cases;
import ls.jtsk.model.Doctor;
import ls.jtsk.model.Gender;
import ls.jtsk.model.Gravida;
import ls.jtsk.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class TestGravida{
	
	Session session = null;
	Transaction tx = null;
	
	private void getSession() {
		session = HibernateUtil.getSessionFactory().openSession();
		tx = session.beginTransaction();
	}
	
	private void destroySession() {
		tx.commit();
		session.close();
		HibernateUtil.shutdown();
	}
	
//  该function不能单独执行了，因为创建gravida需要从创建病历开始	
//	@SuppressWarnings("unchecked")
//	@Test
//	public void testSaveGravidaAndBaby() {
//		Gravida gravida = new Gravida();
//		gravida.setAge(30);
//		gravida.setMedicNo(9000);
//		gravida.setName("王菲1");
//		Baby b = new Baby();
//		b.setBirthTime(new Timestamp(System.currentTimeMillis()).toString());
//		b.setGender(Gender.BOY);
//		gravida.getBabys().add(b);
//		getSession();
//		session.save(gravida);
//		destroySession();
//	}
	
			
	@SuppressWarnings("unchecked")
	@Test
	public void testUpdateGravidaWithNewBaby() {
		getSession();
		Gravida oneGravida = (Gravida) session.load(Gravida.class, 1L);
		Baby b = new Baby();
		b.setBirthTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		b.setGender(Gender.GIRL);
		oneGravida.getBabys().add(b);
		session.update(oneGravida);
		destroySession();
	}

	@SuppressWarnings("unchecked")
	@Test
	public void testUpdateGravidaInformation() {
		getSession();
		Gravida oneGravida = (Gravida) session.load(Gravida.class, 1L);
		oneGravida.setAge(50);
		session.update(oneGravida);
		destroySession();
	}

	@Test
	public void testSaveGravidaAndBabyAndApgar() {
	    getSession();
		Gravida gravida = (Gravida) session.load(Gravida.class, 2L);
		Baby b = new Baby();
		b.setBirthTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		b.setGender(Gender.GIRL);
		gravida.getBabys().add(b);
		Apgar a = new Apgar();
		a.setApgarInterval(Apgarinterval.FIVEMINTUE);
		a.setActivity(1);
		a.setAppearance(1);
		a.setGrimace(2);
		a.setPulse(0);
		a.setRespiration(2);
		b.getApgars().add(a);
		session.save(gravida);
		destroySession();
	}
	

	
	@Test
	public void testFindBabyAndApgars() {
		getSession();
		Gravida oneGravida = (Gravida) session.load(Gravida.class, 1L);
		Set babySet = oneGravida.getBabys();
		org.junit.Assert.assertEquals(2, babySet.size());
		destroySession();
	}
}
