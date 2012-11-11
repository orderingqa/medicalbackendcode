package ls.jtsk.helper;

import java.sql.Time;

import ls.jtsk.model.Apgar;
import ls.jtsk.model.Apgarinterval;

/**
 * 
 * @author liushuai
 * @hibernate.class table = "Baby"
 */

public class Baby1 {
	// /**
	// * @uml.property name="apgarScoreHash"
	// */
	// private HashMap<Apgarinterval, Apgar> apgarScoreHash;
	//
	// /**
	// * Getter of the property <tt>apgarScoreHash</tt>
	// * @return Returns the apgarScoreHash.
	// * @uml.property name="apgarScoreHash"
	// */
	// public HashMap<Apgarinterval, Apgar> getApgarScoreHash() {
	// return apgarScoreHash;
	// }
	//
	// /**
	// * Setter of the property <tt>apgarScoreHash</tt>
	// * @param apgarScoreHash The apgarScoreHash to set.
	// * @uml.property name="apgarScoreHash"
	// */
	// public void setApgarScoreHash(HashMap<Apgarinterval, Apgar>
	// apgarScoreHash) {
	// this.apgarScoreHash = apgarScoreHash;
	// }

	// /**
	// * TODO 小孩有很多的APGAR分数，数据库怎么存储？先解决产妇和小孩的一对多关系
	// */
	// public Apgar getApgarScoreByInterval(Apgarinterval apgarInterval){
	// return apgarScoreHash.get(apgarInterval);
	// }

	/**
	 * @uml.property name="id"
	 */
	private long id;

	/**
	 * 该字段的存储比较讲究，如果我们存字符串，那么从DB取出日期时间后将不好进行排序，如果我们存成date类型，那么ui展示时需要处理。
	 * 
	 * @uml.property name="birthTime"
	 */
	private Time birthTime = null;

	
	/**
	 * @uml.property name="momId"
	 */
	private long momId;

	/**
	 * @uml.property name="momId"
	 * @hibernate.many-to-one column = "momId" class = "ls.jtsk.model.Gravida" not-null = "true"
	 * @return
	 */
	
	public long getMomId() {
		return momId;
	}

	

//	/**
//	 * @uml.property name="mom"
//	 */
//	 private Gravida mom;
//	
//	 /**
//	 * Getter of the property <tt>mom</tt>
//	 * @return Returns the mom.
//	 * @uml.property name="mom"
//	 * TODO 如何映射小孩和母亲关系，这里应该是存储母亲的id
//	 * @hibernate.property column="momid" type="int"
//	 */
//	 public Gravida getMom() {
//	 return mom;
//	 }
//	
//	 /**
//	 * Setter of the property <tt>mom</tt>
//	 * @param mom The mom to set.
//	 * @uml.property name="mom"
//	 */
//	 public void setMom(Gravida mom) {
//	 this.mom = mom;
//	 }

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
	 * @param id The id to set.
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

	/**
	 * @uml.property name="momId"
	 * @param momId
	 */
	public void setMomId(long momId) {
		this.momId = momId;
	}

	/**
		 */
	public String addApgarScore(Apgarinterval interval, Apgar score) {
		return null;
		// TODO if both one/five minutes score larger than 7
	}

	// /**
	// * @uml.property name="apgarScoreHash"
	// */
	// private HashMap<Apgarinterval, Apgar> apgarScoreHash;
	//
	// /**
	// * Getter of the property <tt>apgarScoreHash</tt>
	// * @return Returns the apgarScoreHash.
	// * @uml.property name="apgarScoreHash"
	// */
	// public HashMap<Apgarinterval, Apgar> getApgarScoreHash() {
	// return apgarScoreHash;
	// }
	//
	// /**
	// * Setter of the property <tt>apgarScoreHash</tt>
	// * @param apgarScoreHash The apgarScoreHash to set.
	// * @uml.property name="apgarScoreHash"
	// */
	// public void setApgarScoreHash(HashMap<Apgarinterval, Apgar>
	// apgarScoreHash) {
	// this.apgarScoreHash = apgarScoreHash;
	// }

	// /**
	// * TODO 小孩有很多的APGAR分数，数据库怎么存储？
	// */
	// public Apgar getApgarScoreByInterval(Apgarinterval apgarInterval){
	// return apgarScoreHash.get(apgarInterval);
	// }

}
