package ls.jtsk.helper;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import ls.jtsk.model.Cases;
import ls.jtsk.model.Doctor;
import ls.jtsk.model.Gravida;
import ls.jtsk.util.HibernateTestUtil;

import org.hibernate.SQLQuery;

public class CasesHelper {
	/**
	 * 
	 * @param numberOfOnePage
	 * @param pageIndex
	 * @param sortByField TODO should be a enum, createDate or "createDate DESC" or doctorId or "doctorId DESC"
	 * @return
	 * 10-17 解决了通过孕妇的年龄或者孕妇的姓名或者medicalNo进行排序：
	 * select {c.*} from Cases c, Gravida d where c.id=d.id order by age/medicalNo /DESC"
	 * 怎么根据医生进行排序？
	 */
	public static List getCasesSortByField(int numberOfOnePage, int pageIndex, String sortByField) {
		int offset = (pageIndex-1) * numberOfOnePage;
		HibernateTestUtil.getSession();
		// 从offset数字后面的记录往后算，取第几条数据, order by是排序依据
		SQLQuery sqlQuery = HibernateTestUtil.session.createSQLQuery(
				"select {c.*} from Cases c, Gravida d, Doctor e where c.id=d.id and c.doctorId = e.id order by "+ sortByField + " limit " + numberOfOnePage +  " offset " + offset );
		sqlQuery.addEntity("c", Cases.class);
		List list = sqlQuery.list();
		
		// TODO [待总结] 这个是为了让hibernate来将doctor数据加载，这样后台就可以使用。
		for (int i=0; i<list.size(); i++) {
			((Cases) list.get(i)).getDoctor().getDoctorName();
		}
		HibernateTestUtil.destroySession();
//      如果我不进行detroySession，我可以返回给client端可以进行级联查询的list。但这样存在问题。比如：
//		如果不destroySession的一个问题在于，我此时创建一个case，这时候进行提交时会遇到database is locked的错误。
//		看起来是因为写记录的时候发现数据库已经被读出来了。所以建立了锁
        // TODO 需要一个克隆函数能够将一系列对象都返回，或者直接返回json供前台解析。		
		return list;
	}
		
	/**
	 * UI should pass one parameter as numberOfOnePage
	 * @param numberOfOnePage
	 * @return
	 */
	public static List getLatestCases(int numberOfOnePage) {
		return getCasesSortByField(numberOfOnePage, 1, "createDate DESC");
	}
	
	public static long addCase(int medicalNo, String doctorName, String gravidaName, int age) {
	    Gravida gravida = new Gravida();
	    gravida.setAge(age);
	    gravida.setName(gravidaName);
	    gravida.setMedicNo(medicalNo);
	    Doctor doctor = new Doctor();
	    doctor.setDoctorName(doctorName);
	    Cases newCase = new Cases();
	    newCase.setCreateDate(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
	    newCase.setDoctor(doctor);
	    newCase.setGravida(gravida);
	    HibernateTestUtil.getSession();
	    HibernateTestUtil.session.save(doctor); // 我们必须先save doctor，然后Cases表的外键才会起作用。
	    HibernateTestUtil.session.save(newCase); // Case和Gravida的对应关系是严格一对一的，主键都是一样的。
	    HibernateTestUtil.destroySession();
	    return newCase.getId();
	}
	
	public static Cases getCasesById(long caseGravidaId) {
		HibernateTestUtil.getSession();
		Cases casesFromId = (Cases) HibernateTestUtil.session.load(Cases.class, caseGravidaId);
		HibernateTestUtil.destroySession();
		return casesFromId;
	}
	
	public static Gravida getGravidaById(long caseGravidaId) {
		HibernateTestUtil.getSession();
		Gravida gravidaFromId = (Gravida) HibernateTestUtil.session.load(Gravida.class, caseGravidaId);
//      TODO 理想情况是直接返回gravidaFromId。但直接返回gravidaFromId，就不能destroy session，否则会报session失效的错误。
//      所以这个时候，我clone了另外一个gravida对象。
//		Gravida clonedGravida = cloneObj(gravidaFromId);
		HibernateTestUtil.destroySession();
//		return clonedGravida;
        return gravidaFromId;
	}

	private static Gravida cloneObj(Gravida gravidaFromId) {
		// TODO 这个暂时不实现也无所谓，期望自己实现或者寻找一个能够克隆简单对象的函数。
		return null;
	}
}