package ls.jtsk.model;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 * @author liushuai
 * @hibernate.class table = "Baby"
 */

public class Baby  implements Serializable{
	
	/**
	 * @uml.property name="apgars"
	 */
	private Set apgars = new HashSet();
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property name="id"
	 */
	private long id;

	/**
	 * @uml.property name="momId"
	 */
//	private long momId;

	/**
	 * ���ֶεĴ洢�ȽϽ�����������Ǵ��ַ�������ô��DBȡ������ʱ��󽫲��ý�������������Ǵ��date���ͣ���ôuiչʾʱ��Ҫ����
	 * 
	 * @uml.property name="birthTime"
	 */
	private String birthTime = null;

	/**
	 * @uml.property name="gender"
	 */
	private int gender;

	/**
	 * Getter of the property <tt>id</tt>
	 * 
	 * @return Returns the id.
	 * @uml.property name="id"
	 * @hibernate.id generator-class = "native" column="id"
	 */
	public long getId() {
		return id;
	}

	/**
	 * 
	 * @return
	 * @uml.property name="apgars"
	 * @hibernate.collection-one-to-many class = "ls.jtsk.model.Apgar"
	 * @hibernate.collection-key column = "babyId"
	 * @hibernate.set cascade="all" table = "Apgar"
	 */
	public Set getApgars() {
		return apgars;
	}

	/**
	 * @uml.property name="birthTime"
	 * @hibernate.property column = "birthTime" type = "string"
	 * �������typeΨһ������hbm��ͷ��type�����������ݿ���е�type�ɷ��Ծ�����
	 */
	public String getBirthTime() {
		return birthTime;
	}

	/**
	 * Getter of the property <tt>gender</tt>
	 * 
	 * @return Returns the gender.
	 * @uml.property name="gender"
	 * @hibernate.property column="gender" type = "int"
	 */
	public int getGender() {
		return gender;
	}

	/**
	 * @uml.property name="birthTime"
	 */
	public void setBirthTime(String birthTime) {
		this.birthTime = birthTime;
	}

	/**
	 * Setter of the property <tt>id</tt>
	 * 
	 * @param id
	 *            The id to set.
	 * @uml.property name="id"
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * 
	 * @param apgars
	 * @uml.property name="apgars"
	 */
	public void setApgars(Set apgars) {
		this.apgars = apgars;
	}

	/**
	 * Setter of the property <tt>gender</tt>
	 * 
	 * @param gender
	 *            The gender to set.
	 * @uml.property name="gender"
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

}
