package ls.jtsk.otherhelp;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class SimpleTable
{
	/**
	 * @uml.property  name="jf"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JFrame jf = new JFrame("�򵥱��");
	/**
	 * @uml.property  name="table"
	 * @uml.associationEnd  
	 */
	JTable table;
	//�����ά������Ϊ�������
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
		//��JTable�������JScrollPane�У�������JScrollPane���ڴ�������ʾ����
		jf.add(new JScrollPane(table));
		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
    public static void main(String[] args) 
    {
		new SimpleTable().init();
    }
}

