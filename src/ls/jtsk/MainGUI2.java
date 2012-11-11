/**
 * 
 */
package ls.jtsk;


import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;


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

import org.omg.CORBA.PRIVATE_MEMBER;

public class MainGUI2 extends JFrame implements ActionListener {
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
	String [] productTableTitleName = {"1���Ӵ��", "5���Ӵ��", "10���Ӵ��"};
    /**
	 * @uml.property  name="emptyBorder"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
	
	public void componentsInit() {
		this.setLayout(new FlowLayout());
		
		Box lineBox = new Box(BoxLayout.LINE_AXIS); // һ������
		
		Box labelSummaryBox = new Box(BoxLayout.PAGE_AXIS);
		Box oneMinBox = new Box(BoxLayout.PAGE_AXIS);
		Box fiveMinBox = new Box(BoxLayout.PAGE_AXIS);
		Box tenMinBox = new Box(BoxLayout.PAGE_AXIS);
		lineBox.add(labelSummaryBox);
		lineBox.add(oneMinBox);
		lineBox.add(fiveMinBox);
		lineBox.add(tenMinBox);
		
		
		JLabel xinLvLabel = new JLabel("���ʣ���/�֣�");
		JLabel huXiLabel = new JLabel("����");
		JLabel jiZhangLiLabel = new JLabel("������");
		JLabel ciJiFanYingLabel = new JLabel("�Դ̼���Ӧ������");
		JLabel fuSeLabel = new JLabel("Ƥ����ɫ");
		labelSummaryBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		int SPACE = 17;
		labelSummaryBox.add(Box.createVerticalStrut(40));
		labelSummaryBox.add(xinLvLabel);
		labelSummaryBox.add(Box.createVerticalStrut(SPACE));
		labelSummaryBox.add(huXiLabel);
		labelSummaryBox.add(Box.createVerticalStrut(SPACE));
		labelSummaryBox.add(jiZhangLiLabel);
		labelSummaryBox.add(Box.createVerticalStrut(SPACE));
		labelSummaryBox.add(ciJiFanYingLabel);
		labelSummaryBox.add(Box.createVerticalStrut(SPACE));
		labelSummaryBox.add(fuSeLabel);
		
		
		JButton oneMinButton = new JButton("1����", new ImageIcon(MainGUI2.class.getResource("red.png")));
		oneMinButton.setHorizontalTextPosition(SwingConstants.CENTER);
		oneMinButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		oneMinButton.setContentAreaFilled(false);
		oneMinButton.setBorder(emptyBorder);
		oneMinButton.setFocusPainted(false); // ���swing�µĽ�����Ҳ����css���ƶ��
		
		JPanel oneMinXinlvPanel = new JPanel();
		oneMinXinlvPanel.add(new JTextField(10));
		JPanel oneMinHuXiPanel = new JPanel();
		oneMinHuXiPanel.add(new JTextField(10));
		JPanel oneMinJiZhangliPanel = new JPanel();
		oneMinJiZhangliPanel.add(new JTextField(10));
		JPanel oneMinCiJiFanYingPanel = new JPanel();
		oneMinCiJiFanYingPanel.add(new JTextField(10));
		JPanel oneMinFuSePanel = new JPanel();
		oneMinFuSePanel.add(new JTextField(10));
		oneMinBox.add(oneMinButton);
		oneMinBox.add(oneMinXinlvPanel);
		oneMinBox.add(oneMinHuXiPanel);
		oneMinBox.add(oneMinJiZhangliPanel);
		oneMinBox.add(oneMinCiJiFanYingPanel);
		oneMinBox.add(oneMinFuSePanel);
		oneMinBox.add(new JButton("ȷ��"));
//		oneMinBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		
		JButton fiveMinButton = new JButton("5����", new ImageIcon(MainGUI2.class.getResource("red.png")));
		fiveMinButton.setHorizontalTextPosition(SwingConstants.CENTER);
		fiveMinButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		fiveMinButton.setContentAreaFilled(false);
		fiveMinButton.setBorder(emptyBorder);
		fiveMinButton.setFocusPainted(false);
//		fiveMinButton.setEnabled(false);
		
		JPanel fiveMinXinlvPanel = new JPanel();
		fiveMinXinlvPanel.add(new JTextField(10));
		JPanel fiveMinHuXiPanel = new JPanel();
		fiveMinHuXiPanel.add(new JTextField(10));
		JPanel fiveMinJiZhangliPanel = new JPanel();
		fiveMinJiZhangliPanel.add(new JTextField(10));
		JPanel fiveMinCiJiFanYingPanel = new JPanel();
		fiveMinCiJiFanYingPanel.add(new JTextField(10));
		JPanel fiveMinFuSePanel = new JPanel();
		fiveMinFuSePanel.add(new JTextField(10));
		fiveMinBox.add(fiveMinButton);
		fiveMinBox.add(fiveMinXinlvPanel);
		fiveMinBox.add(fiveMinHuXiPanel);
		fiveMinBox.add(fiveMinJiZhangliPanel);
		fiveMinBox.add(fiveMinCiJiFanYingPanel);
		fiveMinBox.add(fiveMinFuSePanel);
		fiveMinBox.add(new JButton("ȷ��"));
//		fiveMinBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		JButton tenMinButton = new JButton("10����", new ImageIcon(MainGUI2.class.getResource("red.png")));
		tenMinButton.setHorizontalTextPosition(SwingConstants.CENTER);
		tenMinButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		tenMinButton.setContentAreaFilled(false);
		tenMinButton.setBorder(emptyBorder);
		tenMinButton.setFocusPainted(false);

		JPanel tenMinXinlvPanel = new JPanel();
		tenMinXinlvPanel.add(new JTextField(10));
		JPanel tenMinHuXiPanel = new JPanel();
		tenMinHuXiPanel.add(new JTextField(10));
		JPanel tenMinJiZhangliPanel = new JPanel();
		tenMinJiZhangliPanel.add(new JTextField(10));
		JPanel tenMinCiJiFanYingPanel = new JPanel();
		tenMinCiJiFanYingPanel.add(new JTextField(10));
		JPanel tenMinFuSePanel = new JPanel();
		tenMinFuSePanel.add(new JTextField(10));
		tenMinBox.add(tenMinButton);
		tenMinBox.add(tenMinXinlvPanel);
		tenMinBox.add(tenMinHuXiPanel);
		tenMinBox.add(tenMinJiZhangliPanel);
		tenMinBox.add(tenMinCiJiFanYingPanel);
		tenMinBox.add(tenMinFuSePanel);
		tenMinBox.add(new JButton("ȷ��"));
//		tenMinBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		this.add(lineBox);
	}

	public MainGUI2() {
		componentsInit();
		this.setTitle("Apgar�����ϣ����ַ��Զ�������PC��Demo");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(480, 500);
		this.setResizable(true);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		new MainGUI2();
	}

	public void actionPerformed(ActionEvent e){
		
	}
}