package ls.jtsk.model;

import java.io.Serializable;
import java.util.Set;

/**
 * @hibernate.class table = "Gravida"
 * @author liushuai
 *
 */

public class Gravida  implements Serializable{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Gravida() {
	}

	/**
	 * @uml.property  name="id"
	 * 
	 */
	private long id;

	/**
	 * @uml.property  name="name"
	 */
	private String name = null;

	/**
	 * @uml.property  name="age"
	 */
	private int age = 0;

	/**
	 * @uml.property  name="medicNo"
	 */
	private int medicNo = 0;

	/**
	 * @uml.property  name="babys"
	 */
	private Set babys = new java.util.HashSet();

	/**
	 * Getter of the property <tt>id</tt>
	 * @return  Returns the id.
	 * @uml.property  name="id"
	 * @hibernate.id generator-class = "native" column="id"
	 */
	public long getId() {
		return id;
	}

	/**
	 * @return
	 * @uml.property  name="age"
	 * @hibernate.property column = "age" type = "int"
	 */
	public int getAge() {
		return age;
	}

	/** 
	 * @return
	 * @uml.property  name="medicNo"
	 * @hibernate.property column = "medicalNo" type = "int"
	 */
	public int getMedicNo() {
		return medicNo;
	}

	/**
	 * @uml.property  name="babys"
	 * @hibernate.collection-one-to-many class = "ls.jtsk.model.Baby"
	 * @hibernate.collection-key column = "momId"
	 * @hibernate.set cascade="all" table = "Baby"
	 * @return
	 */
	public Set getBabys() { // TODO change uml from getBabyNumber to this
		return babys;
	}

	/**
	 * @return
	 * @uml.property  name="name"
	 * @hibernate.property column = "name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param age
	 * @uml.property  name="age"
	 */
	public void setAge(int age) {
		this.age = age;
	}

	/**
	 * @param name
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @param babys
	 * @uml.property  name="babys"
	 */
	public void setBabys(Set babys) {
		this.babys = babys;
	}

	/** 
	 * @param medicNoString
	 * @uml.property  name="medicNo"
	 */
	public void setMedicNo(int medicNo) {
		// TODO 此处需要有逻辑，medicNo在添加时，需要检查是否已经存在
		this.medicNo = medicNo;
	}

	/**
	 * Setter of the property <tt>id</tt>
	 * @param id  The id to set.
	 * @uml.property  name="id"
	 */
	public void setId(long id) {
		this.id = id;
	}
}
