package ls.jtsk.model;
import java.io.Serializable;
/**
 *  * @hibernate.class table = "Doctor"
 * @author liushuai
 *
 */

public class Doctor implements Serializable{
	// Sql: CREATE TABLE doctor (doctorId INTEGER PRIMARY KEY , doctorName varchar(60));
	
    /**
		 * @uml.property  name="doctorId"
		 */
	   private long id = 1;
	/**
	 * @uml.property  name="doctorName"
	 */
	private String doctorName = null;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * @return
	 * @uml.property  name="doctorId"
	 * @hibernate.id generator-class = "native" column = "id"
	 */
	public long getId() {
		return id;
	}
	/** 
	 * @return
	 * @uml.property  name="doctorName"
	 * @hibernate.property column = "doctorName"
	 */
	public String getDoctorName() {
		// TODO 如果重名，如何处理，如何让人分辨？所以doctor需要科室，或者需要工号。
		return doctorName;
	}
	/**
	 * @param doctorId
	 * @uml.property  name="doctorId"
	 */
	public void setId(long doctorId) {
		this.id = doctorId;
	}
	/** 
	 * @param nameString
	 * @uml.property  name="doctorName"
	 */
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
}
