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
	private int pulse; //����

	/**
	 * @uml.property  name="respiration"
	 */
	private int respiration; // ����
	
	/**
	 * @uml.property  name="activity"
	 */
	private int activity; // ������

	/**
	 * @uml.property  name="grimace"
	 */
	private int grimace; //�Դ̼���Ӧ������
	
	/**
	 * @uml.property  name="appearance"
	 */
	private int appearance; // ��ɫ
	
	public Apgar() {
		// ��ֵΪ-1��Ϊ�������Ƿ���
		this.pulse = -1;
		this.respiration = -1;
		this.activity = -1;
		this.grimace = -1;
		this.appearance = -1;
	}
	
	// TODO ��Ҫ����-1�������ƶ���ʾЧ����
	public String toPrintableString() {
		return (this.getApgarInterval() == -1 ? "δ���" : this.getApgarInterval()) + "          " + 
	           (this.getPulse() == -1 ? "δ���" : this.getPulse()) + "          " + 
	           (this.getRespiration() == -1 ? "δ���" : this.getRespiration())+"          " + 
	           (this.getActivity() == -1 ? "δ���" : this.getActivity()) +"          " + 
			   (this.getGrimace() == -1 ? "δ���" :  + this.getGrimace()) + "          " + 
	           (this.getAppearance() == -1 ? "δ���" :  + this.getAppearance());
	}
	
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
	     * TODO �����Ʋ�̫�ã�Ϊ�������Ƿ����֣����ò��ѳ�ʼ�ķ�����Ϊ-1�������мӷ�ʱȴ���������⡣
		 */
		public int getSum() {
			int sumScore = 
			       (getActivity() == -1 ? 0 : getActivity()) +
				   (getPulse() == -1 ? 0 : getPulse())+
				   (getAppearance() == -1 ? 0 : getAppearance())+
				   (getGrimace() == -1 ? 0 : getGrimace())+
				   (getRespiration() == -1 ? 0 : getRespiration());
			return sumScore;
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
