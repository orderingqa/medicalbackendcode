package ls.jtsk.model;

import java.io.Serializable;

/**
 * 
 * @author liushuai
 * @hibernate.class
 * table = "Apgar"
 */

public class Apgar  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @uml.property  name="id"
	 */
	private long id;

	/**
	 * @uml.property  name="apgarInterval"
	 */
	private int apgarInterval;

	/**
	 * @uml.property  name="pulse"
	 */
	private int pulse; //心率

	/**
	 * @uml.property  name="grimace"
	 */
	private int grimace; //对刺激反应、怪象

	/**
	 * @uml.property  name="activity"
	 */
	private int activity; // 肌张力

	/**
	 * @uml.property  name="respiration"
	 */
	private int respiration; // 呼吸

	/**
	 * @uml.property  name="appearance"
	 */
	private int appearance; // 肤色
	/**
	 * Getter of the property <tt>id</tt>
	 * @return  Returns the id.
	 * @uml.property  name="id"
	 * @hibernate.id  generator-class="native" column="id"
	 */
	public long getId() {
		return id;
	}

	/**
	 * Getter of the property <tt>apgarInterval</tt>
	 * @return  Returns the apgarInterval.
	 * @uml.property  name="apgarInterval"
	 * @hibernate.property column="apgarInterval" type="int"
	 */
	public int getApgarInterval() {
		return apgarInterval;
	}

	// TODO need add a method for checking 1min and 5min larger than 7.
	/** 
	 * Getter of the property <tt>Appearance</tt>
	 * @return  Returns the appearance.
	 * @uml.property  name="appearance"
	 * @hibernate.property
	 * @hibernate.column
	 * name="Appearance"
	 */
	public int getAppearance() {
		return appearance;
	}

	/**
	 * Getter of the property <tt>pulse</tt>
	 * @return  Returns the pulse.
	 * @uml.property  name="pulse"
	 * @hibernate.property
	 * @hibernate.column
	 *   name = "Pulse"
	 */
	public int getPulse() {
		return pulse;
	}

	/**
	 * Getter of the property <tt>grimace</tt>
	 * @return  Returns the grimace.
	 * @uml.property  name="grimace"
	 * @hibernate.property
	 * column = "Grimace"
	 */
	public int getGrimace() {
		return grimace;
	}

	/**
	 * Getter of the property <tt>activity</tt>
	 * @return  Returns the activity.
	 * @uml.property  name="activity"
	 * @hibernate.property
	 * column = "Activity"
	 */
	public int getActivity() {
		return activity;
	}

	/**
	 * Getter of the property <tt>respiration</tt>
	 * @return  Returns the respiration.
	 * @uml.property  name="respiration"
	 * @hibernate.property
	 * column = "Respiration"
	 */
	public int getRespiration() {
		return respiration;
	}

	/**
		 */
		public int getSum(){
			return getActivity()+getPulse()+getAppearance()+getGrimace()+getRespiration();
		}

		/**
		 * Setter of the property <tt>id</tt>
		 * @param id  The id to set.
		 * @uml.property  name="id"
		 */
		public void setId(long id) {
			this.id = id;
		}


		/**
		 * Setter of the property <tt>respiration</tt>
		 * @param respiration  The respiration to set.
		 * @uml.property  name="respiration"
		 */
		public void setRespiration(int respiration) {
			this.respiration = respiration;
		}

		/** 
		 * Setter of the property <tt>Appearance</tt>
		 * @param Appearance  The appearance to set.
		 * @uml.property  name="appearance"
		 */
		public void setAppearance(int appearance) {
			this.appearance = appearance;
		}

		/**
		 * Setter of the property <tt>pulse</tt>
		 * @param pulse  The pulse to set.
		 * @uml.property  name="pulse"
		 */
		public void setPulse(int pulse) {
			this.pulse = pulse;
		}

		/**
		 * Setter of the property <tt>grimace</tt>
		 * @param grimace  The grimace to set.
		 * @uml.property  name="grimace"
		 */
		public void setGrimace(int grimace) {
			this.grimace = grimace;
		}

		/**
		 * Setter of the property <tt>activity</tt>
		 * @param activity  The activity to set.
		 * @uml.property  name="activity"
		 */
		public void setActivity(int activity) {
			this.activity = activity;
		}

		/**
		 * Setter of the property <tt>apgarInterval</tt>
		 * @param apgarInterval  The apgarInterval to set.
		 * @uml.property  name="apgarInterval"
		 */
		public void setApgarInterval(int apgarInterval) {
			this.apgarInterval = apgarInterval;
		}
}
