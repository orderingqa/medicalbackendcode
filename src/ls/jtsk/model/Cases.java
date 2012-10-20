package ls.jtsk.model;

import java.io.Serializable;
import java.sql.Date;

/**
 * 
 * @hibernate.class table = "Cases"
 * @author liushuai
 * case 和 gravida的对应是一一的严格对应，故他们可以采用同样的主键。也即产生一个case时，必然唯一的产生一个gravida
 * case 和 doctor的对应不像gravida。
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
	 * TODO 这样不行，这样创建出来的Case表中都没有doctor的id
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
