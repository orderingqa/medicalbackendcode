package ls.jtsk.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * 
 * @hibernate.class table = "Cases"
 * @author liushuai
 * case �� gravida�Ķ�Ӧ��һһ���ϸ��Ӧ�������ǿ��Բ���ͬ����������Ҳ������һ��caseʱ����ȻΨһ�Ĳ���һ��gravida
 * case �� doctor�Ķ�Ӧ����gravida��
 *
 */
public class Cases implements Serializable{
	
	/**
	 * @uml.property  name="id"
	 */
	private long id;
	
	/**
	 * @uml.property  name="gravida"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Gravida gravida = null;
	/**
	 * @uml.property  name="doctor"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private Doctor doctor = null;
	/**
	 * @uml.property  name="createDate"
	 */
	private String createDate = null;

	/**
	 * @uml.property  name="id"
	 * @hibernate.id  generator-class="foreign"
	 * @hibernate.generator-param name="property" value="gravida"
	 * @return
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return
	 * @uml.property  name="gravida"
	 * @hibernate.one-to-one cascade = "all" class="ls.jtsk.model.Gravida"
	 */
    public Gravida getGravida() {
		return gravida;
	}

	/**
	 * @return
	 * @uml.property  name="doctor"
	 * @hibernate.many-to-one column = "doctorId"
	 * TODO �������У���������������Case���ж�û��doctor��id
	 */
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * @return
	 * @uml.property  name="createDate"
	 * @hibernate.property column = "createDate"
	 */
	public String getCreateDate() {
		return createDate;
	}

	/**
	 * @uml.property  name="id"
	 * @param id
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @param gravida
	 * @uml.property  name="gravida"
	 */
	public void setGravida(Gravida gravida) {
		this.gravida = gravida;
	}

	/**
	 * @param doctor
	 * @uml.property  name="doctor"
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 * @param createDate
	 * @uml.property  name="createDate"
	 */
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}


}
