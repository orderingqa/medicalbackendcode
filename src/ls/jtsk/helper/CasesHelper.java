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
	 * 10-17 �����ͨ���и�����������и�����������medicalNo��������
	 * select {c.*} from Cases c, Gravida d where c.id=d.id order by age/medicalNo /DESC"
	 */
	public static List getCasesSortByField(int numberOfOnePage, int pageIndex, String sortByField) {
		int offset = (pageIndex-1) * numberOfOnePage;
		HibernateTestUtil.getSession();;
		// ��offset���ֺ���ļ�¼�����㣬ȡ�ڼ�������, order by����������
		SQLQuery sqlQuery = HibernateTestUtil.session.createSQLQuery(
				"select {c.*} from Cases c, Gravida d where c.id=d.id order by "+ sortByField + " limit " + numberOfOnePage +  " offset " + offset );
		sqlQuery.addEntity("c", Cases.class);
		List list = sqlQuery.list();
		HibernateTestUtil.destroySession();
		return list;
	}
	
	
	/**
	 * UI should pass one parameter as numberOfOnePage
	 * @param numberOfOnePage
	 * @return
	 */
	public static List getLatestCases(int numberOfOnePage) {
		return getCasesSortByField(numberOfOnePage, 1, "createDate");
	}
	
	public void addCase(int age, String gravidaName, int medicalNo, String doctorName) {
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
	    HibernateTestUtil.session.save(doctor); // ���Ǳ�����save doctor��Ȼ��Cases�������Ż������á�
	    HibernateTestUtil.session.save(newCase); // Case��Gravida�Ķ�Ӧ��ϵ���ϸ�һ��һ�ģ���������һ���ġ�
	    HibernateTestUtil.destroySession();
	}
}