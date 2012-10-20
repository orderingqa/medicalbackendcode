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
	 * 该字段的存储比较讲究，如果我们存字符串，那么从DB取出日期时间后将不好进行排序，如果我们存成date类型，那么ui展示时需要处理。
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
	 * 这里面的type唯一决定了hbm里头的type，创建的数据库表中的type由方言决定。
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
