package ls.jtsk.test;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import ls.jtsk.model.Apgar;
import ls.jtsk.model.Apgarinterval;
import ls.jtsk.model.Baby;
import ls.jtsk.model.Gender;
import ls.jtsk.model.Gravida;
import ls.jtsk.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

public class TestSaveGravida{
	
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
	
	@SuppressWarnings("unchecked")
	@Test
	public void testSaveGravidaAndBaby() {
		Gravida gravida = new Gravida();
		gravida.setAge(30);
		gravida.setMedicNo(9000);
		gravida.setName("Íõ·Æ1");
		Baby b = new Baby();
		b.setBirthTime(new Timestamp(System.currentTimeMillis()).toString());
		b.setGender(Gender.GIRL);
		gravida.getBabys().add(b);
		getSession();
		session.save(gravida);
		destroySession();
	}
	
			
	@SuppressWarnings("unchecked")
	@Test
	public void testUpdateGravidaWithNewBaby() {
		getSession();
		Gravida oneGravida = (Gravida) session.load(Gravida.class, 2L);
		Baby b = new Baby();
		b.setBirthTime(new Timestamp(System.currentTimeMillis()).toString());
		b.setGender(Gender.GIRL);
		oneGravida.getBabys().add(b);
		session.update(oneGravida);
		destroySession();
	}
	
	@Test
	public void testSaveGravidaAndBabyAndApgar() {
		Gravida gravida = new Gravida();
		gravida.setAge(30);
		gravida.setMedicNo(9000);
		gravida.setName("ÁõÏþÇì2");
		Baby b = new Baby();
		b.setBirthTime(new Timestamp(System.currentTimeMillis()).toString());
		b.setGender(Gender.GIRL);
		gravida.getBabys().add(b);
		Apgar a = new Apgar();
		a.setApgarInterval(Apgarinterval.ONEMINTUE);
		a.setActivity(1);
		a.setAppearance(1);
		a.setGrimace(2);
		a.setPulse(0);
		a.setRespiration(2);
		b.getApgars().add(a);
		getSession();
		session.save(gravida);
		destroySession();
	}
	
	@Test
	public void testFindBabyAndApgars() {
		getSession();
		Gravida oneGravida = (Gravida) session.load(Gravida.class, 1L);
		Set babySet = oneGravida.getBabys();
		org.junit.Assert.assertEquals(11, babySet.size());
		destroySession();
	}
}
