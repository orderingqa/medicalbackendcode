package ls.jtsk.otherhelp;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.CellEditorListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

public class BingLi {

	// 定义二维数组作为表格数据
	// 以二维数组和一维数组来创建一个ExtendedTableModel对象
	/**
	 * @uml.property  name="tableData" multiplicity="(0 -1)" dimension="2"
	 */
	Object[][] tableData = {
			new Object[] { "000001", "王菲", 29, "王大夫", "2012-05-18", "查看", "修改",
					"删除", "打印" },
			new Object[] { "000002", "章子怡", 33, "张大夫", "2012-05-31", "查看",
					"修改", "删除", "apgar" }, };
	// 定义一维数据作为列标题
	/**
	 * @uml.property  name="columnTitle" multiplicity="(0 -1)" dimension="1"
	 */
	String[] columnTitle = { "住院号", "产妇姓名", "产妇年龄", "主治医生", "建档日期", "操作", "操作",
			"操作", "操作" };
	static {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		BingLi bingLi = new BingLi();
		JFrame jf = bingLi.buildBingLiTable(bingLi.columnTitle, bingLi.tableData);
		jf.setVisible(true);
	}
	
	
	private JFrame buildBingLiTable (String[] tableTitle, Object[][] tableContent) {
		JFrame jf = new JFrame("使用单元格绘制器");
		JTable table;

		ExtendedBingLiTableModel model = new ExtendedBingLiTableModel(
				tableTitle, tableContent);
		// 以ExtendedTableModel来创建JTable
		table = new JTable(model);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(30);
		
		// 最后四列全部采用自定义的表格渲染器
        for (int i=columnTitle.length-4; i<columnTitle.length;i++) {
        	TableColumn lastColumn = table.getColumnModel().getColumn(i);
    		lastColumn.setCellRenderer(new ButtonCellRenderer());
    		lastColumn.setCellEditor(new ButtonCellEditor());
        }
		
		// 对第四列采用自定义的单元格绘制器
		// lastColumn.setCellRenderer(new ButtonRenderer());
		// lastColumn.setCellEditor(new ButtonEditor(new JCheckBox()));



		// 将JTable对象放在JScrollPane中，并将该JScrollPane放在窗口中显示出来
		jf.add(new JScrollPane(table));
		jf.setSize(800, 500);
//		jf.pack();
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		return jf;
	}
}

class ExtendedBingLiTableModel extends DefaultTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 重新提供一个构造器，该构造器的实现委托给DefaultTableModel父类
	public ExtendedBingLiTableModel(String[] columnNames, Object[][] cells) {
		super(cells, columnNames);
	}

	// 重写getColumnClass方法，根据每列的第一个值来返回其真实的数据类型
	// TODO 没看出来这个到底用来做什么
	// TODO 必须要解决在不同机器之间拷贝的编码问题
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}

class ButtonCellRenderer extends JButton implements TableCellRenderer {
	/**
	 * @uml.property  name="button"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JButton button;

	ButtonCellRenderer() {
		button = new JButton();
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			button.setText(value.toString());
		return button;

	}

}

class ButtonCellEditor extends AbstractCellEditor implements TableCellEditor,
		ActionListener {
	/**
	 * @uml.property  name="button"
	 * @uml.associationEnd  multiplicity="(1 1)"
	 */
	JButton button;
	/**
	 * @uml.property  name="row"
	 */
	int row;
	ButtonCellEditor() {
		button = new JButton();
		button.addActionListener(this);
	}

	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
			button.setText(value.toString());
		this.row = row;
		return button;
	}

	public Object getCellEditorValue() {
		return button.getText();
	}

	public void actionPerformed(ActionEvent e) {
		System.out.print("you press " + row + " row\n");
	}

}

// class ButtonRenderer extends JButton implements TableCellRenderer {
//
// public ButtonRenderer() {
// setOpaque(true);
// }
//
// public Component getTableCellRendererComponent(JTable table, Object value,
// boolean isSelected, boolean hasFocus, int row, int column) {
// if (isSelected) {
// setForeground(table.getSelectionForeground());
// setBackground(table.getSelectionBackground());
// } else{
// setForeground(table.getForeground());
// setBackground(UIManager.getColor("Button.background"));
// }
// setText( (value ==null) ? "" : value.toString() );
// return this;
// }
// }
//
//
// class ButtonEditor extends DefaultCellEditor {
// protected JButton button;
// private String label;
// private boolean isPushed;
//
// public ButtonEditor(JCheckBox checkBox) {
// super(checkBox);
// button = new JButton();
// button.setOpaque(true);// 不透明
// button.addActionListener(new ActionListener() {
// public void actionPerformed(ActionEvent e) {
// fireEditingStopped();
// }
// });
// }
//
// public Component getTableCellEditorComponent(JTable table, Object value,
// boolean isSelected, int row, int column) {
// if (isSelected) {
// button.setForeground(table.getSelectionForeground());
// button.setBackground(table.getSelectionBackground());
// } else{
// button.setForeground(table.getForeground());
// button.setBackground(table.getBackground());
// }
// label = (value ==null) ? "" : value.toString();
// button.setText( label );
// isPushed = true;
// return button;
// }
//
// public Object getCellEditorValue() {
// if (isPushed) {
// //
// //
// JOptionPane.showMessageDialog(button ,label + ": Ouch!");
// // System.out.println(label + ": Ouch!");
// }
// isPushed = false;
// return new String( label ) ;
// }
//
// public boolean stopCellEditing() {
// isPushed = false;
// return super.stopCellEditing();
// }
//
// protected void fireEditingStopped() {
// super.fireEditingStopped();
// }
// }

// class GenderBingLiTableCellRenderer extends JPanel implements
// TableCellRenderer
// {
// /**
// *
// */
// private static final long serialVersionUID = 1L;
// private String cellValue;
// public Component getTableCellRendererComponent(JTable table, Object value,
// boolean isSelected, boolean hasFocus, int row, int column)
// {
// cellValue = (String)value;
// JButton cellButton = new JButton(cellValue);
//
// if (isSelected) {
// cellButton.setForeground(table.getSelectionForeground());
// cellButton.setBackground(table.getSelectionBackground());
// } else{
// cellButton.setForeground(table.getForeground());
// cellButton.setBackground(table.getBackground());
// }
//
// return cellButton;
// }
// //重写paint方法，负责绘制该单元格内容
// public void paint(Graphics g)
// {
// //如果表格值为"男"或"male"，则绘制一个男性图标
// if (cellValue.equalsIgnoreCase("view")
// || cellValue.equalsIgnoreCase("male"))
// {
// drawImage(g , new ImageIcon("icon/male.gif").getImage());
// }
// //如果表格值为"女"或"female"，则绘制一个女性图标
// if (cellValue.equalsIgnoreCase("女")
// || cellValue.equalsIgnoreCase("female"))
// {
// drawImage(g , new ImageIcon("icon/female.gif").getImage());
// }
// }
// //绘制图标的方法
// private void drawImage(Graphics g , Image image)
// {
// g.drawImage(image, (getWidth() - ICON_WIDTH ) / 2
// , (getHeight() - ICON_HEIGHT) / 2 , null);
// }
// }