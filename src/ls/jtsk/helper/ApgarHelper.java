package ls.jtsk.helper;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import org.hibernate.Session;

import ls.jtsk.model.Apgar;
import ls.jtsk.model.Apgarinterval;
import ls.jtsk.model.Baby;
import ls.jtsk.model.Gender;
import ls.jtsk.model.Gravida;
import ls.jtsk.util.HibernateTestUtil;

public class ApgarHelper {
//	public static void saveApgar(Collection<Apgar> apgars) {
//		if (apgars != null && apgars.size() > 0) {
//			HibernateTestUtil.getSession();
//			Gravida gravida = (Gravida) HibernateTestUtil.session.load(
//					Gravida.class, 2L);
//			int babyNumber = gravida.getBabys().size();
//			if (babyNumber > 0) { // 测试阶段只是针对id为2的的gravida的第一个孩子进行更新。
//				Iterator<Baby> iterator = gravida.getBabys().iterator();
//				Baby b = iterator.next();
//				b.setBirthTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
//						.format(new Date()));
//				b.setGender(Gender.GIRL);
//				Iterator it = apgars.iterator();
//				while (it.hasNext()) {
//					b.getApgars().add((Apgar) it.next());
//				}
//				HibernateTestUtil.session.save(gravida);
//			}
//			HibernateTestUtil.destroySession();
//		}
//	}

	public static void addApgar(long gravidaId, long babyId, Collection<Apgar> apgars) {
		if (apgars != null && apgars.size() > 0) {
			HibernateTestUtil.getSession();
			Gravida gravida = (Gravida) HibernateTestUtil.session.load(
					Gravida.class, gravidaId);
			int babyNumber = gravida.getBabys().size();
			if (babyNumber > 0) {
				Iterator<Baby> iterator = gravida.getBabys().iterator();
				while (iterator.hasNext()) {
					Baby b = iterator.next();
					if (b.getId() == babyId) { // TODO 用臃肿的代码实现集合中一个baby的查找？
						Iterator it = apgars.iterator();
						while (it.hasNext()) {
							b.getApgars().add((Apgar) it.next());
						}
						break;
					}						
					HibernateTestUtil.session.save(gravida);
				}
			}
			HibernateTestUtil.destroySession();
		}
	}

}
