/**
 * 
 */
package ls.jtsk.helper;

import ls.jtsk.model.Baby;
import ls.jtsk.model.Gravida;
import ls.jtsk.util.HibernateTestUtil;

/**
 * @author liushuai
 * 2012-11-4
 *
 */
public class BabyHelper {

//	/**
//	 * @param args
//	 */
//	
//	public static Baby getBabyById(long babyId) {
//		HibernateTestUtil.getSession();
//		Baby babyFromId = (Baby) HibernateTestUtil.session.load(Baby.class, babyId);
//		HibernateTestUtil.destroySession();
//		return babyFromId;
//	}
	
	
	// TODO HibernateTestUtil.getSession();和HibernateTestUtil.destroySession(); 要通过spring aop干掉
	public static long addBaby(long momId, int babyGender, String babyBirthTime) {
		HibernateTestUtil.getSession();
		Gravida gravida = (Gravida) HibernateTestUtil.session.load(
				Gravida.class, momId);
		Baby b = new Baby();
		b.setGender(babyGender);
		b.setBirthTime(babyBirthTime);
		gravida.getBabys().add(b);
		HibernateTestUtil.session.update(gravida);
		HibernateTestUtil.destroySession();
		return b.getId();
	}
}
