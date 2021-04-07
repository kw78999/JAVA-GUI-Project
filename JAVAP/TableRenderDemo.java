package JAVAP;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

public class TableRenderDemo extends JPanel {

       public TableRenderDemo() {
           super(new GridLayout(1, 0));

           final JTable table = new JTable(new MyTableModel());
           table.setPreferredScrollableViewportSize(new Dimension(600, 200));
           table.setFillsViewportHeight(true);
           table.setDefaultRenderer(Object.class, new MyRenderer());

           JScrollPane scrollPane = new JScrollPane(table);
           add(scrollPane);
       }

       public Color getTableCellBackground(JTable table, int row, int col) {
           TableCellRenderer renderer = table.getCellRenderer(row, col);
           Component component = table.prepareRenderer(renderer, row, col);    
           return component.getBackground();
       }

       class MyRenderer implements TableCellRenderer {

           public Component getTableCellRendererComponent(
        		   JTable table, Object value, boolean isSelected,
                   boolean hasFocus, int row, int column) {
               JTextField editor = new JTextField();
               if (value != null) {
                   editor.setText(value.toString());
               }
               editor.setBackground((row % 2 == 0) ? Color.white : Color.BLUE);
               return editor;
           }
       }

       class MyTableModel extends AbstractTableModel {

           private String[] columnNames = {"First Name",
               "Last Name",
               "Sport",
               "# of Years",
               "Vegetarian"};
           private Object[][] data = {
               {"Kathy", "Smith",
                   "Snowboarding", new Integer(5), new Boolean(false)},
               {"John", "Doe",
                   "Rowing", new Integer(3), new Boolean(true)},
               {"Sue", "Black",
                   "Knitting", new Integer(2), new Boolean(false)},
               {"Jane", "White",
                   "Speed reading", new Integer(20), new Boolean(true)},
               {"Joe", "Brown",
                   "Pool", new Integer(10), new Boolean(false)}
           };
           public final Object[] longValues = {"Jane", "Kathy",
               "None of the above",
               new Integer(20), Boolean.TRUE};

           public int getColumnCount() {
               return columnNames.length;
           }

           public int getRowCount() {
               return data.length;
           }

           public String getColumnName(int col) {
               return columnNames[col];
           }

           public Object getValueAt(int row, int col) {
               return data[row][col];
           }
       }

       private static void createAndShowGUI() {
           JFrame frame = new JFrame("TableRenderDemo");
           frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

           TableRenderDemo newContentPane = new TableRenderDemo();
           newContentPane.setOpaque(true); //content panes must be opaque
           frame.setContentPane(newContentPane);

           frame.pack();
           frame.setVisible(true);
       }

       public static void main(String[] args) {
           javax.swing.SwingUtilities.invokeLater(new Runnable() {

               public void run() {
                   createAndShowGUI();
               }
           });
       }
}