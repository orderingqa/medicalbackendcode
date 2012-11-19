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
	 * ��ô����ҽ����������
	 */
	public static List getCasesSortByField(int numberOfOnePage, int pageIndex, String sortByField) {
		int offset = (pageIndex-1) * numberOfOnePage;
		HibernateTestUtil.getSession();
		// ��offset���ֺ���ļ�¼�����㣬ȡ�ڼ�������, order by����������
		SQLQuery sqlQuery = HibernateTestUtil.session.createSQLQuery(
				"select {c.*} from Cases c, Gravida d, Doctor e where c.id=d.id and c.doctorId = e.id order by "+ sortByField + " limit " + numberOfOnePage +  " offset " + offset );
		sqlQuery.addEntity("c", Cases.class);
		List list = sqlQuery.list();
		
		// TODO [���ܽ�] �����Ϊ����hibernate����doctor���ݼ��أ�������̨�Ϳ���ʹ�á�
		for (int i=0; i<list.size(); i++) {
			((Cases) list.get(i)).getDoctor().getDoctorName();
		}
		HibernateTestUtil.destroySession();
//      ����Ҳ�����detroySession���ҿ��Է��ظ�client�˿��Խ��м�����ѯ��list���������������⡣���磺
//		�����destroySession��һ���������ڣ��Ҵ�ʱ����һ��case����ʱ������ύʱ������database is locked�Ĵ���
//		����������Ϊд��¼��ʱ�������ݿ��Ѿ����������ˡ����Խ�������
        // TODO ��Ҫһ����¡�����ܹ���һϵ�ж��󶼷��أ�����ֱ�ӷ���json��ǰ̨������		
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
	    HibernateTestUtil.session.save(doctor); // ���Ǳ�����save doctor��Ȼ��Cases�������Ż������á�
	    HibernateTestUtil.session.save(newCase); // Case��Gravida�Ķ�Ӧ��ϵ���ϸ�һ��һ�ģ���������һ���ġ�
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
//      TODO ���������ֱ�ӷ���gravidaFromId����ֱ�ӷ���gravidaFromId���Ͳ���destroy session������ᱨsessionʧЧ�Ĵ���
//      �������ʱ����clone������һ��gravida����
//		Gravida clonedGravida = cloneObj(gravidaFromId);
		HibernateTestUtil.destroySession();
//		return clonedGravida;
        return gravidaFromId;
	}

	private static Gravida cloneObj(Gravida gravidaFromId) {
		// TODO �����ʱ��ʵ��Ҳ����ν�������Լ�ʵ�ֻ���Ѱ��һ���ܹ���¡�򵥶���ĺ�����
		return null;
	}
}