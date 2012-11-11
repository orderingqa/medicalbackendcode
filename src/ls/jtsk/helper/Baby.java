package ls.jtsk.helper;

import java.io.Serializable;
import java.sql.Time;

/**
 * 
 * @author liushuai
 * @hibernate.class table = "Baby"
 */

public class Baby  implements Serializable{
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
	private Time birthTime = null;

	/**
	 * @uml.property name="gender"
	 */
	private int gender;
//
//	/**
//	 * @uml.property name="momId"
//	 * @hibernate.many-to-one column = "momId" class = "ls.jtsk.model.Gravida"
//	 *                        not-null = "true" foreign-key = ""
//	 * @return
//	 */
//
//	public long getMomId() {
//		return momId;
//	}

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
	 * @uml.property name="birthTime"
	 * @hibernate.property column = "birthTime" type = "time"
	 */
	public Time getBirthTime() {
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
	public void setBirthTime(Time birthTime) {
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
	 * Setter of the property <tt>gender</tt>
	 * 
	 * @param gender
	 *            The gender to set.
	 * @uml.property name="gender"
	 */
	public void setGender(int gender) {
		this.gender = gender;
	}

//	/**
//	 * @uml.property name="momId"
//	 * @param momId
//	 */
//	public void setMomId(long momId) {
//		this.momId = momId;
//	}
}
