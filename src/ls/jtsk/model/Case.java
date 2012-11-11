package ls.jtsk.model;

import java.sql.Date;

public class Case {
    /**
	 * @return
	 * @uml.property  name="gravida"
	 */
    public Gravida getGravida() {
		return gravida;
	}

	/**
	 * @param gravida
	 * @uml.property  name="gravida"
	 */
	public void setGravida(Gravida gravida) {
		this.gravida = gravida;
	}

	/**
	 * @return
	 * @uml.property  name="doctor"
	 */
	public Doctor getDoctor() {
		return doctor;
	}

	/**
	 * @param doctor
	 * @uml.property  name="doctor"
	 */
	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	/**
	 * @return
	 * @uml.property  name="createDate"
	 */
	public Date getCreateDate() {
		return createDate;
	}

	/**
	 * @param createDate
	 * @uml.property  name="createDate"
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

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
    private Date createDate = null;
    
    public Case(Gravida gravida, Doctor doctor, Date createDate) {
    	this.gravida = gravida;
    	this.doctor = doctor;
    	this.createDate = createDate;
    }
}
