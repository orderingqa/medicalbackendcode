/**
 * 
 */
package ls.jtsk;


import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class MainGUI3 extends JFrame implements ActionListener {
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
//	public static void updateTable() {
//		productTable.validate();
//		productTable.repaint();
//	}
	private static final long serialVersionUID = 1L;
//	JButton jAddASINButton = new JButton("Add");
//	JButton jControlButton = new JButton("Start");
//	JButton jClearButton = new JButton("Clear");
//	JTextField jtfASIN = new JTextField(10);
//	JTextField jtfPrice = new JTextField(6);
//	Thread secKillAppThread = null;
//	static JTable productTable = null;
//	String[][] productDataModel = new String[5][3];
//	String [] productTableTitleName = {"1���Ӵ��", "5���Ӵ��", "10���Ӵ��"};
    /**
	 * @uml.property  name="emptyBorder"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
	
	public void componentsInit() {
		this.setLayout(new FlowLayout());
		int SPACE = 30;

		
		
		
		
		Box informationLineBox = new Box(BoxLayout.LINE_AXIS); // һ������
		
		Box informationPageBox = new Box(BoxLayout.PAGE_AXIS);
//		Box informationBox = new Box(BoxLayout.PAGE_AXIS);
		informationPageBox.add(new JLabel("������������XXXXXX"));
//		informationLineBox.add(Box.createHorizontalStrut(SPACE));
		informationPageBox.add(new JLabel("�������������£�XXXXXX"));
//		informationLineBox.add(Box.createHorizontalStrut(SPACE));
		
		Box startBox = new Box(BoxLayout.PAGE_AXIS);
		startBox.add(new JButton("��ʼApgar�����ϣ����"));
		
		informationLineBox.add(informationPageBox);
		informationLineBox.add(Box.createHorizontalStrut(30));
		informationLineBox.add(startBox);
		informationLineBox.add(Box.createHorizontalStrut(340));
		
//		informationLineBox.add(informationBox);
//		informationLineBox.add(Box.createHorizontalStrut(SPACE));
//		informationLineBox.add(new Box(BoxLayout.PAGE_AXIS));
//		informationLineBox.add(Box.createHorizontalStrut(SPACE));
//		informationLineBox.add(new Box(BoxLayout.PAGE_AXIS));

		
//		JPanel scorePanel = new JPanel();
//		scorePanel.setSize(800, 800);
		Box lineBox = new Box(BoxLayout.LINE_AXIS); // һ������
//		Box labelSummaryBox = new Box(BoxLayout.PAGE_AXIS);
		Box oneMinBox = new Box(BoxLayout.PAGE_AXIS);
		Box fiveMinBox = new Box(BoxLayout.PAGE_AXIS);
		Box tenMinBox = new Box(BoxLayout.PAGE_AXIS);
//		lineBox.add(labelSummaryBox);
		lineBox.add(oneMinBox);
		lineBox.add(Box.createHorizontalStrut(SPACE));
		lineBox.add(fiveMinBox);
		lineBox.add(Box.createHorizontalStrut(SPACE));
		lineBox.add(tenMinBox);
//		labelSummaryBox.add(Box.createVerticalStrut(40));
		
		addToOneMinBox(oneMinBox);
		addToFiveMinBox(fiveMinBox);
		addToTenMinBox(tenMinBox);
//		scorePanel.add(lineBox);
		
		this.add(informationLineBox);
		this.add(Box.createVerticalStrut(SPACE*2));
		this.add(lineBox);
		
//		oneMinBox.setBorder(BorderFactory.createTitledBorder("1����"));
//		fiveMinBox.setBorder(BorderFactory.createTitledBorder("5����"));
//		tenMinBox.setBorder(BorderFactory.createTitledBorder("10����"));
		
		oneMinBox.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
		fiveMinBox.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
//		tenMinBox.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
		
	}

	private void addToTenMinBox(Box tenMinBox) {
		JButton tenMinButton = new JButton("10����", new ImageIcon(MainGUI3.class.getResource("green.png")));
		tenMinButton.setHorizontalTextPosition(SwingConstants.CENTER);
		tenMinButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		tenMinButton.setContentAreaFilled(false);
		tenMinButton.setBorder(emptyBorder);
		tenMinButton.setFocusPainted(false);
		tenMinButton.setEnabled(false);

		JPanel tenMinXinLvPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder tenMinXinLvTB = new TitledBorder("����(��/��)");
		JRadioButton tenMinXinLvZeroScoreButton = new JRadioButton("�� (0��)");
		JRadioButton tenMinXinLvOneScoreButton = new JRadioButton("С��100 (1��)");
		JRadioButton tenMinXinLvTwoScoreButton = new JRadioButton("���ڵ���100 (2��)");
		ButtonGroup tenMinXinLvGroup = new ButtonGroup();
		tenMinXinLvGroup.add(tenMinXinLvZeroScoreButton);
		tenMinXinLvGroup.add(tenMinXinLvOneScoreButton);
		tenMinXinLvGroup.add(tenMinXinLvTwoScoreButton);
        tenMinXinLvPanel.setBorder(tenMinXinLvTB);
        tenMinXinLvPanel.add(tenMinXinLvZeroScoreButton);
        tenMinXinLvPanel.add(tenMinXinLvOneScoreButton);
        tenMinXinLvPanel.add(tenMinXinLvTwoScoreButton);
        
        
		JPanel tenMinHuXiPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder tenMinHuXiTB = new TitledBorder("����");
		JRadioButton tenMinHuXiZeroScoreButton = new JRadioButton("�� (0��)");
		JRadioButton tenMinHuXiOneScoreButton = new JRadioButton("���������� (1��)");
		JRadioButton tenMinHuXiTwoScoreButton = new JRadioButton("���򡢿������� (2��)");
		ButtonGroup tenMinHuXiGroup = new ButtonGroup();
		tenMinHuXiGroup.add(tenMinHuXiZeroScoreButton);
		tenMinHuXiGroup.add(tenMinHuXiOneScoreButton);
		tenMinHuXiGroup.add(tenMinHuXiTwoScoreButton);
        tenMinHuXiPanel.setBorder(tenMinHuXiTB);
        tenMinHuXiPanel.add(tenMinHuXiZeroScoreButton);
        tenMinHuXiPanel.add(tenMinHuXiOneScoreButton);
        tenMinHuXiPanel.add(tenMinHuXiTwoScoreButton);
        
		JPanel tenMinJiZhangLiPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder tenMinJiZhangLiTB = new TitledBorder("������");
		JRadioButton tenMinJiZhangLiZeroScoreButton = new JRadioButton("�ɳ� (0��)");
		JRadioButton tenMinJiZhangLiOneScoreButton = new JRadioButton("��֫���� (1��)");
		JRadioButton tenMinJiZhangLiTwoScoreButton = new JRadioButton("��֫��� (2��)");
		ButtonGroup tenMinJiZhangLiGroup = new ButtonGroup();
		tenMinJiZhangLiGroup.add(tenMinJiZhangLiZeroScoreButton);
		tenMinJiZhangLiGroup.add(tenMinJiZhangLiOneScoreButton);
		tenMinJiZhangLiGroup.add(tenMinJiZhangLiTwoScoreButton);
        tenMinJiZhangLiPanel.setBorder(tenMinJiZhangLiTB);
        tenMinJiZhangLiPanel.add(tenMinJiZhangLiZeroScoreButton);
        tenMinJiZhangLiPanel.add(tenMinJiZhangLiOneScoreButton);
        tenMinJiZhangLiPanel.add(tenMinJiZhangLiTwoScoreButton);
        
		JPanel tenMinCiJiFanYingPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder tenMinCiJiFanYingTB = new TitledBorder("�Դ̼���Ӧ������");
		JRadioButton tenMinCiJiFanYingZeroScoreButton = new JRadioButton("�޷�Ӧ (0��)");
		JRadioButton tenMinCiJiFanYingOneScoreButton = new JRadioButton("���з�Ӧ(����������Ӧ) (1��)");
		JRadioButton tenMinCiJiFanYingTwoScoreButton = new JRadioButton("���硢�� (2��)");
		ButtonGroup tenMinCiJiFanYingGroup = new ButtonGroup();
		tenMinCiJiFanYingGroup.add(tenMinCiJiFanYingZeroScoreButton);
		tenMinCiJiFanYingGroup.add(tenMinCiJiFanYingOneScoreButton);
		tenMinCiJiFanYingGroup.add(tenMinCiJiFanYingTwoScoreButton);
        tenMinCiJiFanYingPanel.setBorder(tenMinCiJiFanYingTB);
        tenMinCiJiFanYingPanel.add(tenMinCiJiFanYingZeroScoreButton);
        tenMinCiJiFanYingPanel.add(tenMinCiJiFanYingOneScoreButton);
        tenMinCiJiFanYingPanel.add(tenMinCiJiFanYingTwoScoreButton);
        
		JPanel tenMinFuSePanel = new JPanel(new GridLayout(0, 1));
		TitledBorder tenMinFuSeTB = new TitledBorder("Ƥ����ɫ");
		JRadioButton tenMinFuSeZeroScoreButton = new JRadioButton("ȫ�����ϻ�԰� (0��)");
		JRadioButton tenMinFuSeOneScoreButton = new JRadioButton("���ɺ졢��֫��(��) (1��)");
		JRadioButton tenMinFuSeTwoScoreButton = new JRadioButton("�ۺ�ɫ (2��)");
		ButtonGroup tenMinFuSeGroup = new ButtonGroup();
		tenMinFuSeGroup.add(tenMinFuSeZeroScoreButton);
		tenMinFuSeGroup.add(tenMinFuSeOneScoreButton);
		tenMinFuSeGroup.add(tenMinFuSeTwoScoreButton);
        tenMinFuSePanel.setBorder(tenMinFuSeTB);
        tenMinFuSePanel.add(tenMinFuSeZeroScoreButton);
        tenMinFuSePanel.add(tenMinFuSeOneScoreButton);
        tenMinFuSePanel.add(tenMinFuSeTwoScoreButton);
		tenMinBox.add(tenMinButton);
		tenMinBox.add(tenMinXinLvPanel);
		tenMinBox.add(tenMinHuXiPanel);
		tenMinBox.add(tenMinJiZhangLiPanel);
		tenMinBox.add(tenMinCiJiFanYingPanel);
		tenMinBox.add(tenMinFuSePanel);
		JPanel confirmPanel = new JPanel();
		confirmPanel.add(new JLabel("�ܷ֣�3��"));
		confirmPanel.add(new JButton("ȷ��"));
		tenMinBox.add(confirmPanel);
		
//		tenMinBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	}

	private void addToFiveMinBox(Box fiveMinBox) {
		JButton fiveMinButton = new JButton("5����", new ImageIcon(MainGUI3.class.getResource("red.png")));
		fiveMinButton.setHorizontalTextPosition(SwingConstants.CENTER);
		fiveMinButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		fiveMinButton.setContentAreaFilled(false);
		fiveMinButton.setBorder(emptyBorder);
		fiveMinButton.setFocusPainted(false);
//		fiveMinButton.setEnabled(false);
		
		JPanel fiveMinXinLvPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder fiveMinXinLvTB = new TitledBorder("����(��/��)");
		JRadioButton fiveMinXinLvZeroScoreButton = new JRadioButton("�� (0��)");
		JRadioButton fiveMinXinLvOneScoreButton = new JRadioButton("С��100 (1��)");
		JRadioButton fiveMinXinLvTwoScoreButton = new JRadioButton("���ڵ���100 (2��)");
		ButtonGroup fiveMinXinLvGroup = new ButtonGroup();
		fiveMinXinLvGroup.add(fiveMinXinLvZeroScoreButton);
		fiveMinXinLvGroup.add(fiveMinXinLvOneScoreButton);
		fiveMinXinLvGroup.add(fiveMinXinLvTwoScoreButton);
        fiveMinXinLvPanel.setBorder(fiveMinXinLvTB);
        fiveMinXinLvPanel.add(fiveMinXinLvZeroScoreButton);
        fiveMinXinLvPanel.add(fiveMinXinLvOneScoreButton);
        fiveMinXinLvPanel.add(fiveMinXinLvTwoScoreButton);
        
        
        
		JPanel fiveMinHuXiPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder fiveMinHuXiTB = new TitledBorder("����");
		JRadioButton fiveMinHuXiZeroScoreButton = new JRadioButton("�� (0��)");
		JRadioButton fiveMinHuXiOneScoreButton = new JRadioButton("���������� (1��)");
		JRadioButton fiveMinHuXiTwoScoreButton = new JRadioButton("���򡢿������� (2��)");
		ButtonGroup fiveMinHuXiGroup = new ButtonGroup();
		fiveMinHuXiGroup.add(fiveMinHuXiZeroScoreButton);
		fiveMinHuXiGroup.add(fiveMinHuXiOneScoreButton);
		fiveMinHuXiGroup.add(fiveMinHuXiTwoScoreButton);
        fiveMinHuXiPanel.setBorder(fiveMinHuXiTB);
        fiveMinHuXiPanel.add(fiveMinHuXiZeroScoreButton);
        fiveMinHuXiPanel.add(fiveMinHuXiOneScoreButton);
        fiveMinHuXiPanel.add(fiveMinHuXiTwoScoreButton);
        
		JPanel fiveMinJiZhangLiPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder fiveMinJiZhangLiTB = new TitledBorder("������");
		JRadioButton fiveMinJiZhangLiZeroScoreButton = new JRadioButton("�ɳ� (0��)");
		JRadioButton fiveMinJiZhangLiOneScoreButton = new JRadioButton("��֫���� (1��)");
		JRadioButton fiveMinJiZhangLiTwoScoreButton = new JRadioButton("��֫��� (2��)");
		ButtonGroup fiveMinJiZhangLiGroup = new ButtonGroup();
		fiveMinJiZhangLiGroup.add(fiveMinJiZhangLiZeroScoreButton);
		fiveMinJiZhangLiGroup.add(fiveMinJiZhangLiOneScoreButton);
		fiveMinJiZhangLiGroup.add(fiveMinJiZhangLiTwoScoreButton);
        fiveMinJiZhangLiPanel.setBorder(fiveMinJiZhangLiTB);
        fiveMinJiZhangLiPanel.add(fiveMinJiZhangLiZeroScoreButton);
        fiveMinJiZhangLiPanel.add(fiveMinJiZhangLiOneScoreButton);
        fiveMinJiZhangLiPanel.add(fiveMinJiZhangLiTwoScoreButton);
        
		JPanel fiveMinCiJiFanYingPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder fiveMinCiJiFanYingTB = new TitledBorder("�Դ̼���Ӧ������");
		JRadioButton fiveMinCiJiFanYingZeroScoreButton = new JRadioButton("�޷�Ӧ (0��)");
		JRadioButton fiveMinCiJiFanYingOneScoreButton = new JRadioButton("���з�Ӧ(����������Ӧ) (1��)");
		JRadioButton fiveMinCiJiFanYingTwoScoreButton = new JRadioButton("���硢�� (2��)");
		ButtonGroup fiveMinCiJiFanYingGroup = new ButtonGroup();
		fiveMinCiJiFanYingGroup.add(fiveMinCiJiFanYingZeroScoreButton);
		fiveMinCiJiFanYingGroup.add(fiveMinCiJiFanYingOneScoreButton);
		fiveMinCiJiFanYingGroup.add(fiveMinCiJiFanYingTwoScoreButton);
        fiveMinCiJiFanYingPanel.setBorder(fiveMinCiJiFanYingTB);
        fiveMinCiJiFanYingPanel.add(fiveMinCiJiFanYingZeroScoreButton);
        fiveMinCiJiFanYingPanel.add(fiveMinCiJiFanYingOneScoreButton);
        fiveMinCiJiFanYingPanel.add(fiveMinCiJiFanYingTwoScoreButton);
        
		JPanel fiveMinFuSePanel = new JPanel(new GridLayout(0, 1));
		TitledBorder fiveMinFuSeTB = new TitledBorder("Ƥ����ɫ");
		JRadioButton fiveMinFuSeZeroScoreButton = new JRadioButton("ȫ�����ϻ�԰� (0��)");
		JRadioButton fiveMinFuSeOneScoreButton = new JRadioButton("���ɺ졢��֫��(��) (1��)");
		JRadioButton fiveMinFuSeTwoScoreButton = new JRadioButton("�ۺ�ɫ (2��)");
		ButtonGroup fiveMinFuSeGroup = new ButtonGroup();
		fiveMinFuSeGroup.add(fiveMinFuSeZeroScoreButton);
		fiveMinFuSeGroup.add(fiveMinFuSeOneScoreButton);
		fiveMinFuSeGroup.add(fiveMinFuSeTwoScoreButton);
        fiveMinFuSePanel.setBorder(fiveMinFuSeTB);
        fiveMinFuSePanel.add(fiveMinFuSeZeroScoreButton);
        fiveMinFuSePanel.add(fiveMinFuSeOneScoreButton);
        fiveMinFuSePanel.add(fiveMinFuSeTwoScoreButton);
		fiveMinBox.add(fiveMinButton);
		fiveMinBox.add(fiveMinXinLvPanel);
		fiveMinBox.add(fiveMinHuXiPanel);
		fiveMinBox.add(fiveMinJiZhangLiPanel);
		fiveMinBox.add(fiveMinCiJiFanYingPanel);
		fiveMinBox.add(fiveMinFuSePanel);
		JPanel confirmPanel = new JPanel();
		confirmPanel.add(new JLabel("�ܷ֣�3��"));
		confirmPanel.add(new JButton("ȷ��"));
		fiveMinBox.add(confirmPanel);
//		fiveMinBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	}

	private void addToOneMinBox(Box oneMinBox) {
		JButton oneMinButton = new JButton("1����", new ImageIcon(MainGUI3.class.getResource("green.png")));
		oneMinButton.setHorizontalTextPosition(SwingConstants.CENTER);
		oneMinButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		oneMinButton.setContentAreaFilled(false);
		oneMinButton.setBorder(emptyBorder);
		oneMinButton.setFocusPainted(false); // ���swing�µĽ�����Ҳ����css���ƶ��
//		oneMinButton.setEnabled(false);
		
		JPanel oneMinXinLvPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder oneMinXinLvTB = new TitledBorder("����(��/��)");
		JRadioButton oneMinXinLvZeroScoreButton = new JRadioButton("�� (0��)");
		JRadioButton oneMinXinLvOneScoreButton = new JRadioButton("С��100 (1��)");
		JRadioButton oneMinXinLvTwoScoreButton = new JRadioButton("���ڵ���100 (2��)");
		ButtonGroup oneMinXinLvGroup = new ButtonGroup();
		oneMinXinLvGroup.add(oneMinXinLvZeroScoreButton);
		oneMinXinLvGroup.add(oneMinXinLvOneScoreButton);
		oneMinXinLvGroup.add(oneMinXinLvTwoScoreButton);
        oneMinXinLvPanel.setBorder(oneMinXinLvTB);
        oneMinXinLvPanel.add(oneMinXinLvZeroScoreButton);
        oneMinXinLvPanel.add(oneMinXinLvOneScoreButton);
        oneMinXinLvPanel.add(oneMinXinLvTwoScoreButton);
        
		// TODO ���еĺ��ֶ�Ӧ�÷����ļ������properties�ķ�ʽ����
		
		JPanel oneMinHuXiPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder oneMinHuXiTB = new TitledBorder("����");
		JRadioButton oneMinHuXiZeroScoreButton = new JRadioButton("�� (0��)");
		JRadioButton oneMinHuXiOneScoreButton = new JRadioButton("���������� (1��)");
		JRadioButton oneMinHuXiTwoScoreButton = new JRadioButton("���򡢿������� (2��)");
		ButtonGroup oneMinHuXiGroup = new ButtonGroup();
		oneMinHuXiGroup.add(oneMinHuXiZeroScoreButton);
		oneMinHuXiGroup.add(oneMinHuXiOneScoreButton);
		oneMinHuXiGroup.add(oneMinHuXiTwoScoreButton);
        oneMinHuXiPanel.setBorder(oneMinHuXiTB);
        oneMinHuXiPanel.add(oneMinHuXiZeroScoreButton);
        oneMinHuXiPanel.add(oneMinHuXiOneScoreButton);
        oneMinHuXiPanel.add(oneMinHuXiTwoScoreButton);
        
		JPanel oneMinJiZhangLiPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder oneMinJiZhangLiTB = new TitledBorder("������");
		JRadioButton oneMinJiZhangLiZeroScoreButton = new JRadioButton("�ɳ� (0��)");
		JRadioButton oneMinJiZhangLiOneScoreButton = new JRadioButton("��֫���� (1��)");
		JRadioButton oneMinJiZhangLiTwoScoreButton = new JRadioButton("��֫��� (2��)");
		ButtonGroup oneMinJiZhangLiGroup = new ButtonGroup();
		oneMinJiZhangLiGroup.add(oneMinJiZhangLiZeroScoreButton);
		oneMinJiZhangLiGroup.add(oneMinJiZhangLiOneScoreButton);
		oneMinJiZhangLiGroup.add(oneMinJiZhangLiTwoScoreButton);
        oneMinJiZhangLiPanel.setBorder(oneMinJiZhangLiTB);
        oneMinJiZhangLiPanel.add(oneMinJiZhangLiZeroScoreButton);
        oneMinJiZhangLiPanel.add(oneMinJiZhangLiOneScoreButton);
        oneMinJiZhangLiPanel.add(oneMinJiZhangLiTwoScoreButton);
        
		JPanel oneMinCiJiFanYingPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder oneMinCiJiFanYingTB = new TitledBorder("�Դ̼���Ӧ������");
		JRadioButton oneMinCiJiFanYingZeroScoreButton = new JRadioButton("�޷�Ӧ (0��)");
		JRadioButton oneMinCiJiFanYingOneScoreButton = new JRadioButton("���з�Ӧ(����������Ӧ) (1��)");
		JRadioButton oneMinCiJiFanYingTwoScoreButton = new JRadioButton("���硢�� (2��)");
		ButtonGroup oneMinCiJiFanYingGroup = new ButtonGroup();
		oneMinCiJiFanYingGroup.add(oneMinCiJiFanYingZeroScoreButton);
		oneMinCiJiFanYingGroup.add(oneMinCiJiFanYingOneScoreButton);
		oneMinCiJiFanYingGroup.add(oneMinCiJiFanYingTwoScoreButton);
        oneMinCiJiFanYingPanel.setBorder(oneMinCiJiFanYingTB);
        oneMinCiJiFanYingPanel.add(oneMinCiJiFanYingZeroScoreButton);
        oneMinCiJiFanYingPanel.add(oneMinCiJiFanYingOneScoreButton);
        oneMinCiJiFanYingPanel.add(oneMinCiJiFanYingTwoScoreButton);
        
		JPanel oneMinFuSePanel = new JPanel(new GridLayout(0, 1));
		TitledBorder oneMinFuSeTB = new TitledBorder("Ƥ����ɫ");
		JRadioButton oneMinFuSeZeroScoreButton = new JRadioButton("ȫ�����ϻ�԰� (0��)");
		JRadioButton oneMinFuSeOneScoreButton = new JRadioButton("���ɺ졢��֫��(��) (1��)");
		JRadioButton oneMinFuSeTwoScoreButton = new JRadioButton("�ۺ�ɫ (2��)");
		ButtonGroup oneMinFuSeGroup = new ButtonGroup();
		oneMinFuSeGroup.add(oneMinFuSeZeroScoreButton);
		oneMinFuSeGroup.add(oneMinFuSeOneScoreButton);
		oneMinFuSeGroup.add(oneMinFuSeTwoScoreButton);
        oneMinFuSePanel.setBorder(oneMinFuSeTB);
        oneMinFuSePanel.add(oneMinFuSeZeroScoreButton);
        oneMinFuSePanel.add(oneMinFuSeOneScoreButton);
        oneMinFuSePanel.add(oneMinFuSeTwoScoreButton);
		
		
		oneMinBox.add(oneMinButton);
		oneMinBox.add(oneMinXinLvPanel);
		oneMinBox.add(oneMinHuXiPanel);
		oneMinBox.add(oneMinJiZhangLiPanel);
		oneMinBox.add(oneMinCiJiFanYingPanel);
		oneMinBox.add(oneMinFuSePanel);
		JPanel confirmPanel = new JPanel();
		confirmPanel.add(new JLabel("�ܷ֣�3��"));
		confirmPanel.add(new JButton("ȷ��"));
		oneMinBox.add(confirmPanel);
//		oneMinBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	}

	public MainGUI3() {
		componentsInit();
		this.setTitle("Apgar�����ϣ����ַ��Զ�������PC��Demo");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800, 800);
		this.setResizable(true);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		new MainGUI3();
	}

	public void actionPerformed(ActionEvent e){
		
	}
}