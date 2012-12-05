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

	// �����ά������Ϊ�������
	// �Զ�ά�����һά����������һ��ExtendedTableModel����
	/**
	 * @uml.property  name="tableData" multiplicity="(0 -1)" dimension="2"
	 */
	Object[][] tableData = {
			new Object[] { "000001", "����", 29, "�����", "2012-05-18", "�鿴", "�޸�",
					"ɾ��", "��ӡ" },
			new Object[] { "000002", "������", 33, "�Ŵ��", "2012-05-31", "�鿴",
					"�޸�", "ɾ��", "apgar" }, };
	// ����һά������Ϊ�б���
	/**
	 * @uml.property  name="columnTitle" multiplicity="(0 -1)" dimension="1"
	 */
	String[] columnTitle = { "סԺ��", "��������", "��������", "����ҽ��", "��������", "����", "����",
			"����", "����" };
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
		JFrame jf = new JFrame("ʹ�õ�Ԫ�������");
		JTable table;

		ExtendedBingLiTableModel model = new ExtendedBingLiTableModel(
				tableTitle, tableContent);
		// ��ExtendedTableModel������JTable
		table = new JTable(model);
		table.setRowSelectionAllowed(false);
		table.setRowHeight(30);
		
		// �������ȫ�������Զ���ı����Ⱦ��
        for (int i=columnTitle.length-4; i<columnTitle.length;i++) {
        	TableColumn lastColumn = table.getColumnModel().getColumn(i);
    		lastColumn.setCellRenderer(new ButtonCellRenderer());
    		lastColumn.setCellEditor(new ButtonCellEditor());
        }
		
		// �Ե����в����Զ���ĵ�Ԫ�������
		// lastColumn.setCellRenderer(new ButtonRenderer());
		// lastColumn.setCellEditor(new ButtonEditor(new JCheckBox()));



		// ��JTable�������JScrollPane�У�������JScrollPane���ڴ�������ʾ����
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

	// �����ṩһ�����������ù�������ʵ��ί�и�DefaultTableModel����
	public ExtendedBingLiTableModel(String[] columnNames, Object[][] cells) {
		super(cells, columnNames);
	}

	// ��дgetColumnClass����������ÿ�еĵ�һ��ֵ����������ʵ����������
	// TODO û�������������������ʲô
	// TODO ����Ҫ����ڲ�ͬ����֮�俽���ı�������
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
// button.setOpaque(true);// ��͸��
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
// //��дpaint������������Ƹõ�Ԫ������
// public void paint(Graphics g)
// {
// //������ֵΪ"��"��"male"�������һ������ͼ��
// if (cellValue.equalsIgnoreCase("view")
// || cellValue.equalsIgnoreCase("male"))
// {
// drawImage(g , new ImageIcon("icon/male.gif").getImage());
// }
// //������ֵΪ"Ů"��"female"�������һ��Ů��ͼ��
// if (cellValue.equalsIgnoreCase("Ů")
// || cellValue.equalsIgnoreCase("female"))
// {
// drawImage(g , new ImageIcon("icon/female.gif").getImage());
// }
// }
// //����ͼ��ķ���
// private void drawImage(Graphics g , Image image)
// {
// g.drawImage(image, (getWidth() - ICON_WIDTH ) / 2
// , (getHeight() - ICON_HEIGHT) / 2 , null);
// }
// }