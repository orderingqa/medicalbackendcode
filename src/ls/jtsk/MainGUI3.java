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
//	String [] productTableTitleName = {"1分钟打分", "5分钟打分", "10分钟打分"};
    /**
	 * @uml.property  name="emptyBorder"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    private Border emptyBorder = BorderFactory.createEmptyBorder(0, 0, 0, 0);
	
	public void componentsInit() {
		this.setLayout(new FlowLayout());
		int SPACE = 30;

		
		
		
		
		Box informationLineBox = new Box(BoxLayout.LINE_AXIS); // 一行两列
		
		Box informationPageBox = new Box(BoxLayout.PAGE_AXIS);
//		Box informationBox = new Box(BoxLayout.PAGE_AXIS);
		informationPageBox.add(new JLabel("新生儿姓名：XXXXXX"));
//		informationLineBox.add(Box.createHorizontalStrut(SPACE));
		informationPageBox.add(new JLabel("新生儿出生年月：XXXXXX"));
//		informationLineBox.add(Box.createHorizontalStrut(SPACE));
		
		Box startBox = new Box(BoxLayout.PAGE_AXIS);
		startBox.add(new JButton("开始Apgar（阿氏）打分"));
		
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
		Box lineBox = new Box(BoxLayout.LINE_AXIS); // 一行四列
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
		
//		oneMinBox.setBorder(BorderFactory.createTitledBorder("1分钟"));
//		fiveMinBox.setBorder(BorderFactory.createTitledBorder("5分钟"));
//		tenMinBox.setBorder(BorderFactory.createTitledBorder("10分钟"));
		
		oneMinBox.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
		fiveMinBox.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
//		tenMinBox.setBorder(BorderFactory.createMatteBorder(0, 0, 0, 2, Color.BLACK));
		
	}

	private void addToTenMinBox(Box tenMinBox) {
		JButton tenMinButton = new JButton("10分钟", new ImageIcon(MainGUI3.class.getResource("green.png")));
		tenMinButton.setHorizontalTextPosition(SwingConstants.CENTER);
		tenMinButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		tenMinButton.setContentAreaFilled(false);
		tenMinButton.setBorder(emptyBorder);
		tenMinButton.setFocusPainted(false);
		tenMinButton.setEnabled(false);

		JPanel tenMinXinLvPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder tenMinXinLvTB = new TitledBorder("心率(次/分)");
		JRadioButton tenMinXinLvZeroScoreButton = new JRadioButton("无 (0分)");
		JRadioButton tenMinXinLvOneScoreButton = new JRadioButton("小于100 (1分)");
		JRadioButton tenMinXinLvTwoScoreButton = new JRadioButton("大于等于100 (2分)");
		ButtonGroup tenMinXinLvGroup = new ButtonGroup();
		tenMinXinLvGroup.add(tenMinXinLvZeroScoreButton);
		tenMinXinLvGroup.add(tenMinXinLvOneScoreButton);
		tenMinXinLvGroup.add(tenMinXinLvTwoScoreButton);
        tenMinXinLvPanel.setBorder(tenMinXinLvTB);
        tenMinXinLvPanel.add(tenMinXinLvZeroScoreButton);
        tenMinXinLvPanel.add(tenMinXinLvOneScoreButton);
        tenMinXinLvPanel.add(tenMinXinLvTwoScoreButton);
        
        
		JPanel tenMinHuXiPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder tenMinHuXiTB = new TitledBorder("呼吸");
		JRadioButton tenMinHuXiZeroScoreButton = new JRadioButton("无 (0分)");
		JRadioButton tenMinHuXiOneScoreButton = new JRadioButton("慢、不规则 (1分)");
		JRadioButton tenMinHuXiTwoScoreButton = new JRadioButton("规则、哭声洪亮 (2分)");
		ButtonGroup tenMinHuXiGroup = new ButtonGroup();
		tenMinHuXiGroup.add(tenMinHuXiZeroScoreButton);
		tenMinHuXiGroup.add(tenMinHuXiOneScoreButton);
		tenMinHuXiGroup.add(tenMinHuXiTwoScoreButton);
        tenMinHuXiPanel.setBorder(tenMinHuXiTB);
        tenMinHuXiPanel.add(tenMinHuXiZeroScoreButton);
        tenMinHuXiPanel.add(tenMinHuXiOneScoreButton);
        tenMinHuXiPanel.add(tenMinHuXiTwoScoreButton);
        
		JPanel tenMinJiZhangLiPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder tenMinJiZhangLiTB = new TitledBorder("肌张力");
		JRadioButton tenMinJiZhangLiZeroScoreButton = new JRadioButton("松弛 (0分)");
		JRadioButton tenMinJiZhangLiOneScoreButton = new JRadioButton("四肢屈曲 (1分)");
		JRadioButton tenMinJiZhangLiTwoScoreButton = new JRadioButton("四肢活动好 (2分)");
		ButtonGroup tenMinJiZhangLiGroup = new ButtonGroup();
		tenMinJiZhangLiGroup.add(tenMinJiZhangLiZeroScoreButton);
		tenMinJiZhangLiGroup.add(tenMinJiZhangLiOneScoreButton);
		tenMinJiZhangLiGroup.add(tenMinJiZhangLiTwoScoreButton);
        tenMinJiZhangLiPanel.setBorder(tenMinJiZhangLiTB);
        tenMinJiZhangLiPanel.add(tenMinJiZhangLiZeroScoreButton);
        tenMinJiZhangLiPanel.add(tenMinJiZhangLiOneScoreButton);
        tenMinJiZhangLiPanel.add(tenMinJiZhangLiTwoScoreButton);
        
		JPanel tenMinCiJiFanYingPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder tenMinCiJiFanYingTB = new TitledBorder("对刺激反应、怪象");
		JRadioButton tenMinCiJiFanYingZeroScoreButton = new JRadioButton("无反应 (0分)");
		JRadioButton tenMinCiJiFanYingOneScoreButton = new JRadioButton("略有反应(怪脸、弱反应) (1分)");
		JRadioButton tenMinCiJiFanYingTwoScoreButton = new JRadioButton("喷嚏、哭 (2分)");
		ButtonGroup tenMinCiJiFanYingGroup = new ButtonGroup();
		tenMinCiJiFanYingGroup.add(tenMinCiJiFanYingZeroScoreButton);
		tenMinCiJiFanYingGroup.add(tenMinCiJiFanYingOneScoreButton);
		tenMinCiJiFanYingGroup.add(tenMinCiJiFanYingTwoScoreButton);
        tenMinCiJiFanYingPanel.setBorder(tenMinCiJiFanYingTB);
        tenMinCiJiFanYingPanel.add(tenMinCiJiFanYingZeroScoreButton);
        tenMinCiJiFanYingPanel.add(tenMinCiJiFanYingOneScoreButton);
        tenMinCiJiFanYingPanel.add(tenMinCiJiFanYingTwoScoreButton);
        
		JPanel tenMinFuSePanel = new JPanel(new GridLayout(0, 1));
		TitledBorder tenMinFuSeTB = new TitledBorder("皮肤颜色");
		JRadioButton tenMinFuSeZeroScoreButton = new JRadioButton("全身青紫或苍白 (0分)");
		JRadioButton tenMinFuSeOneScoreButton = new JRadioButton("躯干红、四肢紫(灰) (1分)");
		JRadioButton tenMinFuSeTwoScoreButton = new JRadioButton("粉红色 (2分)");
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
		confirmPanel.add(new JLabel("总分：3分"));
		confirmPanel.add(new JButton("确认"));
		tenMinBox.add(confirmPanel);
		
//		tenMinBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	}

	private void addToFiveMinBox(Box fiveMinBox) {
		JButton fiveMinButton = new JButton("5分钟", new ImageIcon(MainGUI3.class.getResource("red.png")));
		fiveMinButton.setHorizontalTextPosition(SwingConstants.CENTER);
		fiveMinButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		fiveMinButton.setContentAreaFilled(false);
		fiveMinButton.setBorder(emptyBorder);
		fiveMinButton.setFocusPainted(false);
//		fiveMinButton.setEnabled(false);
		
		JPanel fiveMinXinLvPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder fiveMinXinLvTB = new TitledBorder("心率(次/分)");
		JRadioButton fiveMinXinLvZeroScoreButton = new JRadioButton("无 (0分)");
		JRadioButton fiveMinXinLvOneScoreButton = new JRadioButton("小于100 (1分)");
		JRadioButton fiveMinXinLvTwoScoreButton = new JRadioButton("大于等于100 (2分)");
		ButtonGroup fiveMinXinLvGroup = new ButtonGroup();
		fiveMinXinLvGroup.add(fiveMinXinLvZeroScoreButton);
		fiveMinXinLvGroup.add(fiveMinXinLvOneScoreButton);
		fiveMinXinLvGroup.add(fiveMinXinLvTwoScoreButton);
        fiveMinXinLvPanel.setBorder(fiveMinXinLvTB);
        fiveMinXinLvPanel.add(fiveMinXinLvZeroScoreButton);
        fiveMinXinLvPanel.add(fiveMinXinLvOneScoreButton);
        fiveMinXinLvPanel.add(fiveMinXinLvTwoScoreButton);
        
        
        
		JPanel fiveMinHuXiPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder fiveMinHuXiTB = new TitledBorder("呼吸");
		JRadioButton fiveMinHuXiZeroScoreButton = new JRadioButton("无 (0分)");
		JRadioButton fiveMinHuXiOneScoreButton = new JRadioButton("慢、不规则 (1分)");
		JRadioButton fiveMinHuXiTwoScoreButton = new JRadioButton("规则、哭声洪亮 (2分)");
		ButtonGroup fiveMinHuXiGroup = new ButtonGroup();
		fiveMinHuXiGroup.add(fiveMinHuXiZeroScoreButton);
		fiveMinHuXiGroup.add(fiveMinHuXiOneScoreButton);
		fiveMinHuXiGroup.add(fiveMinHuXiTwoScoreButton);
        fiveMinHuXiPanel.setBorder(fiveMinHuXiTB);
        fiveMinHuXiPanel.add(fiveMinHuXiZeroScoreButton);
        fiveMinHuXiPanel.add(fiveMinHuXiOneScoreButton);
        fiveMinHuXiPanel.add(fiveMinHuXiTwoScoreButton);
        
		JPanel fiveMinJiZhangLiPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder fiveMinJiZhangLiTB = new TitledBorder("肌张力");
		JRadioButton fiveMinJiZhangLiZeroScoreButton = new JRadioButton("松弛 (0分)");
		JRadioButton fiveMinJiZhangLiOneScoreButton = new JRadioButton("四肢屈曲 (1分)");
		JRadioButton fiveMinJiZhangLiTwoScoreButton = new JRadioButton("四肢活动好 (2分)");
		ButtonGroup fiveMinJiZhangLiGroup = new ButtonGroup();
		fiveMinJiZhangLiGroup.add(fiveMinJiZhangLiZeroScoreButton);
		fiveMinJiZhangLiGroup.add(fiveMinJiZhangLiOneScoreButton);
		fiveMinJiZhangLiGroup.add(fiveMinJiZhangLiTwoScoreButton);
        fiveMinJiZhangLiPanel.setBorder(fiveMinJiZhangLiTB);
        fiveMinJiZhangLiPanel.add(fiveMinJiZhangLiZeroScoreButton);
        fiveMinJiZhangLiPanel.add(fiveMinJiZhangLiOneScoreButton);
        fiveMinJiZhangLiPanel.add(fiveMinJiZhangLiTwoScoreButton);
        
		JPanel fiveMinCiJiFanYingPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder fiveMinCiJiFanYingTB = new TitledBorder("对刺激反应、怪象");
		JRadioButton fiveMinCiJiFanYingZeroScoreButton = new JRadioButton("无反应 (0分)");
		JRadioButton fiveMinCiJiFanYingOneScoreButton = new JRadioButton("略有反应(怪脸、弱反应) (1分)");
		JRadioButton fiveMinCiJiFanYingTwoScoreButton = new JRadioButton("喷嚏、哭 (2分)");
		ButtonGroup fiveMinCiJiFanYingGroup = new ButtonGroup();
		fiveMinCiJiFanYingGroup.add(fiveMinCiJiFanYingZeroScoreButton);
		fiveMinCiJiFanYingGroup.add(fiveMinCiJiFanYingOneScoreButton);
		fiveMinCiJiFanYingGroup.add(fiveMinCiJiFanYingTwoScoreButton);
        fiveMinCiJiFanYingPanel.setBorder(fiveMinCiJiFanYingTB);
        fiveMinCiJiFanYingPanel.add(fiveMinCiJiFanYingZeroScoreButton);
        fiveMinCiJiFanYingPanel.add(fiveMinCiJiFanYingOneScoreButton);
        fiveMinCiJiFanYingPanel.add(fiveMinCiJiFanYingTwoScoreButton);
        
		JPanel fiveMinFuSePanel = new JPanel(new GridLayout(0, 1));
		TitledBorder fiveMinFuSeTB = new TitledBorder("皮肤颜色");
		JRadioButton fiveMinFuSeZeroScoreButton = new JRadioButton("全身青紫或苍白 (0分)");
		JRadioButton fiveMinFuSeOneScoreButton = new JRadioButton("躯干红、四肢紫(灰) (1分)");
		JRadioButton fiveMinFuSeTwoScoreButton = new JRadioButton("粉红色 (2分)");
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
		confirmPanel.add(new JLabel("总分：3分"));
		confirmPanel.add(new JButton("确认"));
		fiveMinBox.add(confirmPanel);
//		fiveMinBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	}

	private void addToOneMinBox(Box oneMinBox) {
		JButton oneMinButton = new JButton("1分钟", new ImageIcon(MainGUI3.class.getResource("green.png")));
		oneMinButton.setHorizontalTextPosition(SwingConstants.CENTER);
		oneMinButton.setVerticalTextPosition(SwingConstants.BOTTOM);
		oneMinButton.setContentAreaFilled(false);
		oneMinButton.setBorder(emptyBorder);
		oneMinButton.setFocusPainted(false); // 如果swing下的界面编程也能用css控制多好
//		oneMinButton.setEnabled(false);
		
		JPanel oneMinXinLvPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder oneMinXinLvTB = new TitledBorder("心率(次/分)");
		JRadioButton oneMinXinLvZeroScoreButton = new JRadioButton("无 (0分)");
		JRadioButton oneMinXinLvOneScoreButton = new JRadioButton("小于100 (1分)");
		JRadioButton oneMinXinLvTwoScoreButton = new JRadioButton("大于等于100 (2分)");
		ButtonGroup oneMinXinLvGroup = new ButtonGroup();
		oneMinXinLvGroup.add(oneMinXinLvZeroScoreButton);
		oneMinXinLvGroup.add(oneMinXinLvOneScoreButton);
		oneMinXinLvGroup.add(oneMinXinLvTwoScoreButton);
        oneMinXinLvPanel.setBorder(oneMinXinLvTB);
        oneMinXinLvPanel.add(oneMinXinLvZeroScoreButton);
        oneMinXinLvPanel.add(oneMinXinLvOneScoreButton);
        oneMinXinLvPanel.add(oneMinXinLvTwoScoreButton);
        
		// TODO 所有的汉字都应该放在文件里，并以properties的方式引入
		
		JPanel oneMinHuXiPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder oneMinHuXiTB = new TitledBorder("呼吸");
		JRadioButton oneMinHuXiZeroScoreButton = new JRadioButton("无 (0分)");
		JRadioButton oneMinHuXiOneScoreButton = new JRadioButton("慢、不规则 (1分)");
		JRadioButton oneMinHuXiTwoScoreButton = new JRadioButton("规则、哭声洪亮 (2分)");
		ButtonGroup oneMinHuXiGroup = new ButtonGroup();
		oneMinHuXiGroup.add(oneMinHuXiZeroScoreButton);
		oneMinHuXiGroup.add(oneMinHuXiOneScoreButton);
		oneMinHuXiGroup.add(oneMinHuXiTwoScoreButton);
        oneMinHuXiPanel.setBorder(oneMinHuXiTB);
        oneMinHuXiPanel.add(oneMinHuXiZeroScoreButton);
        oneMinHuXiPanel.add(oneMinHuXiOneScoreButton);
        oneMinHuXiPanel.add(oneMinHuXiTwoScoreButton);
        
		JPanel oneMinJiZhangLiPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder oneMinJiZhangLiTB = new TitledBorder("肌张力");
		JRadioButton oneMinJiZhangLiZeroScoreButton = new JRadioButton("松弛 (0分)");
		JRadioButton oneMinJiZhangLiOneScoreButton = new JRadioButton("四肢屈曲 (1分)");
		JRadioButton oneMinJiZhangLiTwoScoreButton = new JRadioButton("四肢活动好 (2分)");
		ButtonGroup oneMinJiZhangLiGroup = new ButtonGroup();
		oneMinJiZhangLiGroup.add(oneMinJiZhangLiZeroScoreButton);
		oneMinJiZhangLiGroup.add(oneMinJiZhangLiOneScoreButton);
		oneMinJiZhangLiGroup.add(oneMinJiZhangLiTwoScoreButton);
        oneMinJiZhangLiPanel.setBorder(oneMinJiZhangLiTB);
        oneMinJiZhangLiPanel.add(oneMinJiZhangLiZeroScoreButton);
        oneMinJiZhangLiPanel.add(oneMinJiZhangLiOneScoreButton);
        oneMinJiZhangLiPanel.add(oneMinJiZhangLiTwoScoreButton);
        
		JPanel oneMinCiJiFanYingPanel = new JPanel(new GridLayout(0, 1));
		TitledBorder oneMinCiJiFanYingTB = new TitledBorder("对刺激反应、怪象");
		JRadioButton oneMinCiJiFanYingZeroScoreButton = new JRadioButton("无反应 (0分)");
		JRadioButton oneMinCiJiFanYingOneScoreButton = new JRadioButton("略有反应(怪脸、弱反应) (1分)");
		JRadioButton oneMinCiJiFanYingTwoScoreButton = new JRadioButton("喷嚏、哭 (2分)");
		ButtonGroup oneMinCiJiFanYingGroup = new ButtonGroup();
		oneMinCiJiFanYingGroup.add(oneMinCiJiFanYingZeroScoreButton);
		oneMinCiJiFanYingGroup.add(oneMinCiJiFanYingOneScoreButton);
		oneMinCiJiFanYingGroup.add(oneMinCiJiFanYingTwoScoreButton);
        oneMinCiJiFanYingPanel.setBorder(oneMinCiJiFanYingTB);
        oneMinCiJiFanYingPanel.add(oneMinCiJiFanYingZeroScoreButton);
        oneMinCiJiFanYingPanel.add(oneMinCiJiFanYingOneScoreButton);
        oneMinCiJiFanYingPanel.add(oneMinCiJiFanYingTwoScoreButton);
        
		JPanel oneMinFuSePanel = new JPanel(new GridLayout(0, 1));
		TitledBorder oneMinFuSeTB = new TitledBorder("皮肤颜色");
		JRadioButton oneMinFuSeZeroScoreButton = new JRadioButton("全身青紫或苍白 (0分)");
		JRadioButton oneMinFuSeOneScoreButton = new JRadioButton("躯干红、四肢紫(灰) (1分)");
		JRadioButton oneMinFuSeTwoScoreButton = new JRadioButton("粉红色 (2分)");
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
		confirmPanel.add(new JLabel("总分：3分"));
		confirmPanel.add(new JButton("确认"));
		oneMinBox.add(confirmPanel);
//		oneMinBox.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	}

	public MainGUI3() {
		componentsInit();
		this.setTitle("Apgar（阿氏）评分法自动评分仪PC版Demo");
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