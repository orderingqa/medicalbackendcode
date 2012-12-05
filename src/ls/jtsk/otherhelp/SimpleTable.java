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
	JFrame jf = new JFrame("简单表格");
	/**
	 * @uml.property  name="table"
	 * @uml.associationEnd  
	 */
	JTable table;
	//定义二维数组作为表格数据
	/**
	 * @uml.property  name="tableData" multiplicity="(0 -1)" dimension="2"
	 */
	Object[][] tableData = 
	{
		new Object[]{"李清照" , 29 , "女"},
		new Object[]{"苏格拉底", 56 , "男"},
		new Object[]{"李白", 35 , "男"},
		new Object[]{"弄玉", 18 , "女"},
		new Object[]{"虎头" , 2 , "男"}
	};
	//定义一维数据作为列标题
	/**
	 * @uml.property  name="columnTitle" multiplicity="(0 -1)" dimension="1"
	 */
	Object[] columnTitle = {"姓名" , "年龄" , "性别"};
	public void init()
	{
		//以二维数组和一维数组来创建一个JTable对象
		table = new JTable(tableData , columnTitle);
		//将JTable对象放在JScrollPane中，并将该JScrollPane放在窗口中显示出来
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

