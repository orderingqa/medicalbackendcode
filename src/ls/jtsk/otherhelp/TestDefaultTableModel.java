package ls.jtsk.otherhelp;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class TestDefaultTableModel
{
	/**
	 * @uml.property  name="mainWin"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JFrame mainWin = new JFrame("���������С�������");
	/**
	 * @uml.property  name="cOLUMN_COUNT"
	 */
	final int COLUMN_COUNT = 5;
	/**
	 * @uml.property  name="model"
	 * @uml.associationEnd  
	 */
	DefaultTableModel model;
	/**
	 * @uml.property  name="table"
	 * @uml.associationEnd  
	 */
	JTable table;
	//���ڱ��汻�����е�List����
	/**
	 * @uml.property  name="hiddenColumns"
	 */
	ArrayList<TableColumn> hiddenColumns = new ArrayList<TableColumn>();
	public void init()
	{
		model = new DefaultTableModel(COLUMN_COUNT ,COLUMN_COUNT);
		for (int i = 0; i < COLUMN_COUNT ; i++ )
		{
			for (int j = 0; j < COLUMN_COUNT ; j++ )
			{
				model.setValueAt("�ϵ�Ԫ��ֵ " + i + " " + j , i , j);
			}
		}

		table = new JTable(model);

		mainWin.add(new JScrollPane(table), BorderLayout.CENTER);

		//Ϊ���ڰ�װ�˵�
		JMenuBar menuBar = new JMenuBar();
		mainWin.setJMenuBar(menuBar);
		JMenu tableMenu = new JMenu("����");
		menuBar.add(tableMenu);

		JMenuItem hideColumnsItem = new JMenuItem("����ѡ����");
		hideColumnsItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//��ȡ����ѡ���е�����
				int[] selected = table.getSelectedColumns();
				TableColumnModel columnModel = table.getColumnModel();
				//���ΰ�ÿһ��ѡ�е���������������ʹ��List����Щ�б�������
				for (int i = selected.length - 1; i >= 0; i--)
				{
					TableColumn column = columnModel.getColumn(selected[i]);
					table.removeColumn(column);
					//�����ص��б���������ȷ���Ժ������ʾ����
					hiddenColumns.add(column);
				}
			}
		});
		tableMenu.add(hideColumnsItem);

		JMenuItem showColumnsItem = new JMenuItem("��ʾ������");
		showColumnsItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//������������������ʾ����
				for (TableColumn tc : hiddenColumns)
				{
					//���ΰ��������ص�����ʾ����
					table.addColumn(tc);
				}
				//��ձ��������е�List����
				hiddenColumns.clear();            
			}
		});
		tableMenu.add(showColumnsItem);

		JMenuItem addColumnItem = new JMenuItem("����ѡ����");
		addColumnItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//��ȡ����ѡ���е�����
				int[] selected = table.getSelectedColumns();
				TableColumnModel columnModel = table.getColumnModel();
				//���ΰ�ѡ�е�����ӵ�JTable֮��
				for (int i = selected.length - 1; i >= 0; i--)
				{  
					TableColumn column = columnModel.getColumn(selected[i]);
					table.addColumn(column);
				}
			}
		});
		tableMenu.add(addColumnItem);

		JMenuItem addRowItem = new JMenuItem("������");
		addRowItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//����һ��String������Ϊ�����е�����
				String[] newCells = new String[COLUMN_COUNT];
				for (int i = 0; i < newCells.length; i++)
				{
					newCells[i] = "�µ�Ԫ��ֵ " + model.getRowCount() + " " + i;
				}
				//��TableModel������һ�С�
				model.addRow(newCells);
			}
		});
		tableMenu.add(addRowItem);

		JMenuItem removeRowsItem = new  JMenuItem("ɾ��ѡ����");
		removeRowsItem.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				//��ȡ����ѡ����
				int[] selected = table.getSelectedRows();
				//����ɾ������ѡ����
				for (int i = selected.length - 1; i >= 0; i--)
				{
					model.removeRow(selected[i]);
				}
			}
		});
		tableMenu.add(removeRowsItem);

		mainWin.pack();
		mainWin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainWin.setVisible(true);
	}

	public static void main(String[] args) 
	{
		new TestDefaultTableModel().init();
	}
}