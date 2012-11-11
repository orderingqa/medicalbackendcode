package ls.jtsk;
import com.jgoodies.forms.layout.FormLayout;
import info.clearthought.layout.TableLayout;
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import javax.swing.WindowConstants;
import javax.swing.SwingUtilities;


/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
public class ViewCaseHistory extends javax.swing.JFrame {
	/**
	 * @uml.property  name="womanYearLabel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel WomanYearLabel;
	/**
	 * @uml.property  name="womanYear"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField WomanYear;
	/**
	 * @uml.property  name="womanName"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField WomanName;
	/**
	 * @uml.property  name="jTextField1"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField jTextField1;
	/**
	 * @uml.property  name="doctorName"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel DoctorName;
	/**
	 * @uml.property  name="hospitalNo"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JTextField HospitalNo;
	/**
	 * @uml.property  name="cancel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton Cancel;
	/**
	 * @uml.property  name="saveAndApgar"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton SaveAndApgar;
	/**
	 * @uml.property  name="save"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JButton Save;
	/**
	 * @uml.property  name="womanNameLabel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel WomanNameLabel;
	/**
	 * @uml.property  name="hospitalNoLabel"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	private JLabel HospitalNoLabel;

	/**
	* Auto-generated main method to display this JFrame
	*/
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				ViewCaseHistory inst = new ViewCaseHistory();
				inst.setLocationRelativeTo(null);
				inst.setVisible(true);
			}
		});
	}
	
	public ViewCaseHistory() {
		super();
		initGUI();
	}
	
	private void initGUI() {
		try {
			GridBagLayout thisLayout = new GridBagLayout();
			thisLayout.rowWeights = new double[] {0.1, 0.1, 0.1, 0.1, 0.1};
			thisLayout.rowHeights = new int[] {7, 7, 7, 7, 7};
			thisLayout.columnWeights = new double[] {0.0, 0.0, 0.0, 0.1};
			thisLayout.columnWidths = new int[] {102, 108, 96, 7};
			getContentPane().setLayout(thisLayout);
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			{
				HospitalNoLabel = new JLabel();
				getContentPane().add(HospitalNoLabel, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				HospitalNoLabel.setText("\u8bf7\u8f93\u5165\u4f4f\u9662\u53f7");
			}
			{
				WomanNameLabel = new JLabel();
				getContentPane().add(WomanNameLabel, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				WomanNameLabel.setText("\u8bf7\u8f93\u5165\u4ea7\u5987\u59d3\u540d");
			}
			{
				WomanYearLabel = new JLabel();
				getContentPane().add(WomanYearLabel, new GridBagConstraints(2, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				WomanYearLabel.setText("\u8bf7\u8f93\u5165\u4ea7\u5987\u5e74\u9f84");
			}
			{
				WomanYear = new JTextField();
				getContentPane().add(WomanYear, new GridBagConstraints(3, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				WomanYear.setMinimumSize(new java.awt.Dimension(100, 24));
			}
			{
				Save = new JButton();
				getContentPane().add(Save, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				Save.setText("\u4fdd\u5b58");
			}
			{
				SaveAndApgar = new JButton();
				getContentPane().add(SaveAndApgar, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				SaveAndApgar.setText("\u4fdd\u5b58\u5e76APGAR");
			}
			{
				Cancel = new JButton();
				getContentPane().add(Cancel, new GridBagConstraints(3, 3, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				Cancel.setText("\u53d6\u6d88");
				Cancel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent evt) {
						System.out.println("Cancel.actionPerformed, event="+evt);
						System.exit(0);
						//TODO add your code for Cancel.actionPerformed
					}
				});
			}
			{
				HospitalNo = new JTextField();
				getContentPane().add(HospitalNo, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				HospitalNo.setMinimumSize(new java.awt.Dimension(100, 24));
			}
			{
				DoctorName = new JLabel();
				getContentPane().add(DoctorName, new GridBagConstraints(2, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				DoctorName.setText("\u8bf7\u8f93\u5165\u533b\u751f\u59d3\u540d");
			}
			{
				jTextField1 = new JTextField();
				getContentPane().add(jTextField1, new GridBagConstraints(3, 1, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				jTextField1.setMinimumSize(new java.awt.Dimension(100, 24));
				jTextField1.setColumns(20);
			}
			{
				WomanName = new JTextField();
				getContentPane().add(WomanName, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
				WomanName.setColumns(20);
				WomanName.setMinimumSize(new java.awt.Dimension(100, 24));
			}
			pack();
			this.setSize(426, 304);
		} catch (Exception e) {
		    //add your error handling code here
			e.printStackTrace();
		}
	}

}
