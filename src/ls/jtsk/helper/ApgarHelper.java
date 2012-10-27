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
	public static void saveApgar(Collection<Apgar> apgars) {
		if (apgars != null && apgars.size() > 0) {
			HibernateTestUtil.getSession();
			Gravida gravida = (Gravida) HibernateTestUtil.session.load(
					Gravida.class, 2L);
			Baby b = new Baby();
			b.setBirthTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
					.format(new Date()));
			b.setGender(Gender.GIRL);
			gravida.getBabys().add(b);
			Iterator it = apgars.iterator();
			while (it.hasNext()) {
				b.getApgars().add((Apgar) it.next());
			}
			HibernateTestUtil.session.save(gravida);
			HibernateTestUtil.destroySession();
		}
	}
}
