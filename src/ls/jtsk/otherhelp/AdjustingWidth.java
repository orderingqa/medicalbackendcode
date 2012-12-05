package ls.jtsk.otherhelp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.TableColumn;

public class AdjustingWidth
{
	/**
	 * @uml.property  name="jf"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JFrame jf = new JFrame("���������п�");
	/**
	 * @uml.property  name="menuBar"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JMenuBar menuBar = new JMenuBar();
	/**
	 * @uml.property  name="adjustModeMenu"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JMenu adjustModeMenu = new JMenu("������ʽ");
	/**
	 * @uml.property  name="selectUnitMenu"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JMenu selectUnitMenu = new JMenu("ѡ��Ԫ");
	/**
	 * @uml.property  name="selectModeMenu"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JMenu selectModeMenu = new JMenu("ѡ��ʽ");

	//����5����ѡ��ť�����Կ��Ʊ���Ŀ��ȵ�����ʽ
	/**
	 * @uml.property  name="adjustModesItem"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	JRadioButtonMenuItem[] adjustModesItem = new JRadioButtonMenuItem[5];
	//����3����ѡ��ť�����Կ��Ʊ����ѡ��ʽ
	/**
	 * @uml.property  name="selectModesItem"
	 * @uml.associationEnd  multiplicity="(0 -1)"
	 */
	JRadioButtonMenuItem[] selectModesItem = new JRadioButtonMenuItem[3];

    /**
	 * @uml.property  name="rowsItem"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    JCheckBoxMenuItem rowsItem = new JCheckBoxMenuItem("ѡ����");
    /**
	 * @uml.property  name="columnsItem"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    JCheckBoxMenuItem columnsItem = new JCheckBoxMenuItem("ѡ����");
    /**
	 * @uml.property  name="cellsItem"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
    JCheckBoxMenuItem cellsItem = new JCheckBoxMenuItem("ѡ��Ԫ��");
	/**
	 * @uml.property  name="adjustBg"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	ButtonGroup adjustBg = new ButtonGroup();
	/**
	 * @uml.property  name="selectBg"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	ButtonGroup selectBg = new ButtonGroup();
	//����һ��int���͵����飬���ڱ���������еĿ��ȵ�����ʽ
	/**
	 * @uml.property  name="adjustModes" multiplicity="(0 -1)" dimension="1"
	 */
	int[] adjustModes = new int[]{
		JTable.AUTO_RESIZE_OFF,
		JTable.AUTO_RESIZE_NEXT_COLUMN,
		JTable.AUTO_RESIZE_SUBSEQUENT_COLUMNS,
		JTable.AUTO_RESIZE_LAST_COLUMN,
		JTable.AUTO_RESIZE_ALL_COLUMNS 
	};
	/**
	 * @uml.property  name="selectModes" multiplicity="(0 -1)" dimension="1"
	 */
	int[] selectModes = new int[]{
		ListSelectionModel.MULTIPLE_INTERVAL_SELECTION ,
		ListSelectionModel.SINGLE_INTERVAL_SELECTION ,
		ListSelectionModel.SINGLE_SELECTION
	};
	/**
	 * @uml.property  name="table"
	 * @uml.associationEnd  
	 */
	JTable table;
	//�����ά������Ϊ��������
	/**
	 * @uml.property  name="tableData" multiplicity="(0 -1)" dimension="2"
	 */
	Object[][] tableData = 
	{
		new Object[]{"������" , 29 , "Ů"},
		new Object[]{"�ո�����", 56 , "��"},
		new Object[]{"���", 35 , "��"},
		new Object[]{"Ū��", 18 , "Ů"},
		new Object[]{"��ͷ" , 2 , "��"}
	};
	//����һά������Ϊ�б���
	/**
	 * @uml.property  name="columnTitle" multiplicity="(0 -1)" dimension="1"
	 */
	Object[] columnTitle = {"����" , "����" , "�Ա�"};

	public void init()
	{
		//�Զ�ά�����һά����������һ��JTable����
		table = new JTable(tableData , columnTitle);

		//-----------Ϊ���ڰ�װ���ñ��������ʽ�Ĳ˵�-----------
		adjustModesItem[0] = new JRadioButtonMenuItem("ֻ��������");
		adjustModesItem[1] = new JRadioButtonMenuItem("ֻ������һ��");
		adjustModesItem[2] = new JRadioButtonMenuItem("ƽ������������");
		adjustModesItem[3] = new JRadioButtonMenuItem("ֻ�������һ��");
		adjustModesItem[4] = new JRadioButtonMenuItem("ƽ������������");
		menuBar.add(adjustModeMenu);
		for (int i = 0; i < adjustModesItem.length ; i++)
		{
			//Ĭ��ѡ�е������˵������Ӧ����Ĭ�ϵĿ��ȵ�����ʽ
			if (i == 2)
			{
				adjustModesItem[i].setSelected(true);
			}
			adjustBg.add(adjustModesItem[i]);
			adjustModeMenu.add(adjustModesItem[i]);
			final int index = i;
			//Ϊ���õ�����ʽ�Ĳ˵������Ӽ�����
			adjustModesItem[i].addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					//�����ǰ�˵����ѡ��״̬������ʹ�ö�Ӧ�ĵ�����ʽ
					if (adjustModesItem[index].isSelected())
					{
						table.setAutoResizeMode(adjustModes[index]);
					}
				}
			});
		}
		//-----------Ϊ���ڰ�װ���ñ���ѡ��ʽ�Ĳ˵�-----------
		selectModesItem[0] = new JRadioButtonMenuItem("������");
		selectModesItem[1] = new JRadioButtonMenuItem("������������");
		selectModesItem[2] = new JRadioButtonMenuItem("��ѡ");
		menuBar.add(selectModeMenu);
		for (int i = 0; i < selectModesItem.length ; i++)
		{
			//Ĭ��ѡ�е�һ���˵������Ӧ����Ĭ�ϵ�ѡ��ʽ
			if (i == 0)
			{
				selectModesItem[i].setSelected(true);
			}
			selectBg.add(selectModesItem[i]);
			selectModeMenu.add(selectModesItem[i]);
			final int index = i;
			//Ϊ����ѡ��ʽ�Ĳ˵������Ӽ�����
			selectModesItem[i].addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent evt)
				{
					//�����ǰ�˵����ѡ��״̬������ʹ�ö�Ӧ��ѡ��ʽ
					if (selectModesItem[index].isSelected())
					{
						table.getSelectionModel().setSelectionMode(selectModes[index]);
					}
				}
			});
		}
		menuBar.add(selectUnitMenu);
		//-----------Ϊ���ڰ�װ���ñ���ѡ��Ԫ�Ĳ˵�-----------
		rowsItem.setSelected(table.getRowSelectionAllowed());
		columnsItem.setSelected(table.getColumnSelectionAllowed());
		cellsItem.setSelected(table.getCellSelectionEnabled());

		rowsItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				table.clearSelection();
				//����ò˵����ѡ��״̬�����ñ����ѡ��Ԫ����
				table.setRowSelectionAllowed(rowsItem.isSelected());
				//���ѡ���С�ѡ����ͬʱ��ѡ�У���ʵ����ѡ��Ԫ��
				cellsItem.setSelected(table.getCellSelectionEnabled());
			}
		});
		selectUnitMenu.add(rowsItem);
		columnsItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				table.clearSelection();
				//����ò˵����ѡ��״̬�����ñ����ѡ��Ԫ����
				table.setColumnSelectionAllowed(columnsItem.isSelected());
				//���ѡ���С�ѡ����ͬʱ��ѡ�У���ʵ����ѡ��Ԫ��
				cellsItem.setSelected(table.getCellSelectionEnabled());
			}
		});
		selectUnitMenu.add(columnsItem);
		cellsItem.addActionListener(new	ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				table.clearSelection();
				//����ò˵����ѡ��״̬�����ñ����ѡ��Ԫ�ǵ�Ԫ��
				table.setCellSelectionEnabled(cellsItem.isSelected());
				//��ѡ��ĸı��ͬʱӰ��ѡ���С�ѡ���������˵�
				rowsItem.setSelected(table.getRowSelectionAllowed());
				columnsItem.setSelected(table.getColumnSelectionAllowed());
			}
		});
		selectUnitMenu.add(cellsItem);

		jf.setJMenuBar(menuBar);
		//�ֱ��ȡ��������������У����������е���С���ȣ���ѿ��Ⱥ�������
		TableColumn nameColumn = table.getColumn(columnTitle[0]);
		nameColumn.setMinWidth(40);
		TableColumn ageColumn = table.getColumn(columnTitle[1]);
		ageColumn.setPreferredWidth(50);
		TableColumn genderColumn = table.getColumn(columnTitle[2]);
		genderColumn.setMaxWidth(50);


		//��JTable�������JScrollPane�У�������JScrollPane���ڴ�������ʾ����
		jf.add(new JScrollPane(table));
		System.out.println(table.getModel());
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}

    public static void main(String[] args) 
    {
		new AdjustingWidth().init();
    }
}