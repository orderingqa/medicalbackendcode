/**
 * 
 */
package ls.jtsk.otherhelp;


import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;

public class MainGUI extends JFrame implements ActionListener {
	static {
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			}
			catch (Exception e){
			    e.printStackTrace();
			}
	}
	/**
	 * 
	 */
	public static void updateTable() {
		productTable.validate();
		productTable.repaint();
	}
	private static final long serialVersionUID = 1L;
	/**
	 * @uml.property  name="jAddASINButton"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JButton jAddASINButton = new JButton("Add");
	/**
	 * @uml.property  name="jControlButton"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JButton jControlButton = new JButton("Start");
	/**
	 * @uml.property  name="jClearButton"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JButton jClearButton = new JButton("Clear");
	/**
	 * @uml.property  name="jtfASIN"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JTextField jtfASIN = new JTextField(10);
	/**
	 * @uml.property  name="jtfPrice"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JTextField jtfPrice = new JTextField(6);
	/**
	 * @uml.property  name="secKillAppThread"
	 */
	Thread secKillAppThread = null;
	static JTable productTable = null;
	/**
	 * @uml.property  name="productDataModel" multiplicity="(0 -1)" dimension="2"
	 */
	String[][] productDataModel = new String[5][3];
	/**
	 * @uml.property  name="productTableTitleName" multiplicity="(0 -1)" dimension="1"
	 */
	String [] productTableTitleName = {"1分钟打分", "5分钟打分", "10分钟打分"};
    /**
	 * @uml.property  name="emptyBorder"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
	
	public void componentsInit() {
		this.setLayout(new BorderLayout());
		
		JPanel jpAlarmPanel = new JPanel();
		
		Box horizenBox = new Box(BoxLayout.LINE_AXIS);
		JButton oneMinButton = new JButton("1分钟", new ImageIcon(MainGUI.class.getResource("red.png")));
		oneMinButton.setHorizontalTextPosition(SwingConstants.CENTER);
		oneMinButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		oneMinButton.setContentAreaFilled(false);
		oneMinButton.setBorder(emptyBorder);
		oneMinButton.setFocusPainted(false); // 如果swing下的界面编程也能用css控制多好
		
		JButton fiveMinButton = new JButton("5分钟", new ImageIcon(MainGUI.class.getResource("red.png")));
		fiveMinButton.setHorizontalTextPosition(SwingConstants.CENTER);
		fiveMinButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		fiveMinButton.setContentAreaFilled(false);
		fiveMinButton.setBorder(emptyBorder);
		fiveMinButton.setFocusPainted(false);
//		fiveMinButton.setEnabled(false);
		
		JButton tenMinButton = new JButton("10分钟", new ImageIcon(MainGUI.class.getResource("red.png")));
		tenMinButton.setHorizontalTextPosition(SwingConstants.CENTER);
		tenMinButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		tenMinButton.setContentAreaFilled(false);
		tenMinButton.setBorder(emptyBorder);
		tenMinButton.setFocusPainted(false);
		
		horizenBox.add(Box.createHorizontalStrut(40));
		horizenBox.add(oneMinButton);
		horizenBox.add(Box.createHorizontalStrut(40));
		horizenBox.add(fiveMinButton);
		horizenBox.add(Box.createHorizontalStrut(40));
		horizenBox.add(tenMinButton);
		jpAlarmPanel.add(horizenBox);
		this.add(jpAlarmPanel,BorderLayout.NORTH);
		
		JPanel jpLabelPanel = new JPanel();
		JLabel xinLvLabel = new JLabel("心率");
		JLabel huXiLabel = new JLabel("呼吸");
		JLabel jiZhangLiLabel = new JLabel("肌张力");
		JLabel ciJiFanYingLabel = new JLabel("对刺激反应");
		JLabel fuSeLabel = new JLabel("肤色");
		Box verticalBox = new Box(BoxLayout.PAGE_AXIS);
		verticalBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		verticalBox.add(Box.createVerticalStrut(40));
		verticalBox.add(xinLvLabel);
		verticalBox.add(Box.createVerticalStrut(40));
		verticalBox.add(huXiLabel);
		verticalBox.add(Box.createVerticalStrut(40));
		verticalBox.add(jiZhangLiLabel);
		verticalBox.add(Box.createVerticalStrut(40));
		verticalBox.add(ciJiFanYingLabel);
		verticalBox.add(Box.createVerticalStrut(40));
		verticalBox.add(fuSeLabel);
		jpLabelPanel.add(verticalBox);
		this.add(jpLabelPanel, BorderLayout.WEST);
		productTable = new JTable (productDataModel, productTableTitleName);
		productTable.setEnabled(true);
		productTable.setRowHeight(50); //设置行高
		productTable.getColumnModel().getColumn(0).setPreferredWidth(40);//设置第一列列宽
		productTable.getColumnModel().getColumn(1).setPreferredWidth(40);//设置第二列列宽
		productTable.getColumnModel().getColumn(2).setPreferredWidth(40);//设置第三列列宽
		productTable.getTableHeader().setResizingAllowed(false); 
		productTable.getTableHeader().setReorderingAllowed(false);
		JScrollPane productScrollpane = new JScrollPane(productTable);
		this.add(productScrollpane, BorderLayout.CENTER);
	}

	public MainGUI() {
		componentsInit();
		this.setTitle("Apgar（阿氏）评分法自动评分仪PC版Demo");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480, 500);
		this.setResizable(true);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MainGUI();
	}

	public void actionPerformed(ActionEvent e){
        if (e.getSource() == jAddASINButton) {
        	if (jtfASIN.getText() != null && jtfASIN.getText().length() > 0 && jtfPrice.getText() != null && jtfPrice.getText().length() > 0) {
        		int insertLocation = checkInsertLocation(jtfASIN.getText());
        		if (insertLocation != -1) {
        			//pdm.addProductData(jtfASIN.getText(), null, null, "￥ " + jtfPrice.getText(), false);
            		productDataModel[insertLocation] = new String[] {jtfASIN.getText(), null, null,"￥ " +jtfPrice.getText(), null};
            		updateTable();
            		jtfASIN.setText("");
            		jtfPrice.setText("");
            		jControlButton.setEnabled(true);
            		jClearButton.setEnabled(true);
        		}
        	}
        } else if(e.getSource() == jControlButton) {
        	if (productDataModel[0][0] == null) {
        		jControlButton.setText("Start");
        		jClearButton.setEnabled(false);
        	}
        	else if (jControlButton.getText().equals("Start")) {
        		jControlButton.setText("Stop");
	            jAddASINButton.setEnabled(false);
	            jClearButton.setEnabled(false);
            }
        	else if (jControlButton.getText().equals("Stop")) {
        		// TODO Thread stop has problem
        		jAddASINButton.setEnabled(true);
        		jControlButton.setText("Start");
        		jClearButton.setEnabled(true);
        	}
       } else if (e.getSource() == jClearButton) {
        		// TODO Thread stop has problem
        		if (jControlButton.getText().equals("Start") &&  productDataModel[0][0] != null) {
        			for (int i=0; i<10; i++){
            			productDataModel[i] = new String[5];        				
        			}
                    updateTable();
                    jControlButton.setEnabled(false);
        		}
        	}
        }
	
	/**
	 * Return the null duplicate location
	 * 0-9 means can be added places
	 * -1 means cannot be added
	 * @param ASIN
	 * @return
	 */
	private int checkInsertLocation(String ASIN){
		for (int i=0; i<10; i++) {
			if ((productDataModel[i][0] != null && productDataModel[i][0].equals(ASIN)) || (productDataModel[i][0] == null)) {
				return i;
			}	
		}
		return -1;
	}

}