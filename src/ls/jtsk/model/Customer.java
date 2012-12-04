package ls.jtsk.model;
import java.io.Serializable;
/**
 *  * @hibernate.class table = "Customer"
 * @author liushuai
 *
 */

public class Customer implements Serializable{
	// Sql: CREATE TABLE doctor (id INTEGER PRIMARY KEY , name varchar(60));
	
    /**
	 * @uml.property  name="id"
	 */
    private long id = 1;
	/**
	 * @uml.property  name="name"
	 */
	private String name = null;
	private String email = null;
	private String phone = null;
	private String hospitalAndDepString = null;
	private String departmentString = null;
	private int isActivated = 0;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @return
	 * @uml.property  name="id"
	 * @hibernate.id generator-class = "native" column = "id"
	 */
	public long getId() {
		return id;
	}
	/** 
	 * @return
	 * @uml.property  name="name"
	 * @hibernate.property column = "name"
	 */
	public String getName() {
		// TODO 如果重名，如何处理，如何让人分辨？所以doctor需要科室，或者需要工号。
		return name;
	}
	/**
	 * @hibernate.property column = "phone"
	 * @return
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @hibernate.property column = "email"
	 * @return
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * @hibernate.property column = "hospital" not-null = "true"
	 * @return
	 */
	public String getHospitalAndDepString() {
		return hospitalAndDepString;
	}
	
	/**
	 * @hibernate.property column = "department"
	 * @return
	 */
	public String getDepartmentString() {
		return departmentString;
	}
	/**
	 * @hibernate.property column = "isActivated"
	 * @return
	 */
	public int getIsActivated() {
		return isActivated;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setHospitalAndDepString(String hospitalAndDepString) {
		this.hospitalAndDepString = hospitalAndDepString;
	}
	public void setDepartmentString(String departmentString) {
		this.departmentString = departmentString;
	}
	/**
	 * @param id
	 * @uml.property  name="id"
	 */
	public void setId(long id) {
		this.id = id;
	}
	/** 
	 * @param nameString
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}
	public void setIsActivated(int isActivated) {
		this.isActivated = isActivated;
	}
}
