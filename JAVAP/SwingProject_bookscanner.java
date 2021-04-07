package JAVAP;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

public class SwingProject_bookscanner {
	String col1[] = {"������ȣ","�����̸�","����","���ǻ�","��������","������ġ"};
	
	BooksMgr mgr1;
	JPanel panel = new JPanel();
	JPanel mpanel = new JPanel();
	JPanel tpanel = new JPanel();
	JTable table;
	DefaultTableModel model;
	JScrollPane scr;
	Choice cho = new Choice();
	JTextField tf = new JTextField(10);
	JButton btn = new JButton("�˻�");
	JButton btn1 = new JButton("�����ϱ�");
	static JFrame memberf1;
	Vector <BooksBean>  vlist1;
	static Color red = new Color(255,207,253);
	static Color bg = new Color(186,218,255);
	//new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 20) );
	//�⺻ ��� �����͸� �����ִ� �޼ҵ� 
	void viewlist(){       
		mgr1 = new BooksMgr();
	    vlist1 = mgr1.getListMember();
		
		String row1[][] = new String[vlist1.size()][12];
		for (int i = 0; i < row1.length; i++) {
			BooksBean bean = vlist1.elementAt(i);
			row1[i][0] = bean.getBID()+"";
			row1[i][1] = bean.getTITLE();
			row1[i][2] = bean.getAUTHOR();
			row1[i][3] = bean.getPUBLISHER();
			row1[i][5] = bean.getLOCATION();
			row1[i][4] = bean.getBOOKSTATE();
		}
		DefaultTableModel model = new DefaultTableModel(row1, col1) {

	           private static final long serialVersionUID = 1L;

	           @Override
	           public Class getColumnClass(int column) {
	               return getValueAt(0, column).getClass();
	           }
	       };
	       table = new JTable(model) {

	               private static final long serialVersionUID = 1L;

	               @Override
	               public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
	                   Component c = super.prepareRenderer(renderer, row, column);

	                   if (!isRowSelected(row)) {
	                       if (table.getColumnCount() >= 0) {
	                           String type = (String)getModel().getValueAt(row,4);
	                           if (type.equals("���Ⱑ��")) {
	                               c.setBackground(Color.white);
	                           }
	                           if (type.equals("���� �Ұ���")) {
	                               c.setBackground(red);
	                           }
	                       }
	                   }
	                   
	                   return c;
	               }
	           };

	       table.setPreferredScrollableViewportSize(table.getPreferredSize());
	       JScrollPane scrollPane = new JScrollPane(table);
	   	table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	       table.getColumnModel().getColumn(0).setPreferredWidth(70);  //JTable �� �÷� ���� ����
			table.getColumnModel().getColumn(1).setPreferredWidth(250);
			table.getColumnModel().getColumn(2).setPreferredWidth(80);
			table.getColumnModel().getColumn(3).setPreferredWidth(150);
			table.getColumnModel().getColumn(4).setPreferredWidth(110);
			table.getColumnModel().getColumn(5).setPreferredWidth(80);
	       table.setFont(new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 20) );
		    table.setRowHeight(25);
		    scrollPane.setBounds(0, 0, 670, 380);
		    table.setSelectionBackground(new Color(7,142,255));
		    table.setSelectionForeground(Color.white);
	       tpanel.add(scrollPane);
	}
	
	//������
	public SwingProject_bookscanner() {
		viewlist();     //��� ������ ��� 
		
		memberf1 = new JFrame();
		memberf1.setBackground(bg);
		memberf1.setVisible(true);
		memberf1.setSize(700,600);
		memberf1.setLocationRelativeTo(null);
		memberf1.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		memberf1.add(mpanel);
		
		panel.setBackground(bg);
		tpanel.setBackground(bg);
		mpanel.setBackground(bg);
		mpanel.setLayout(null);
		tpanel.setLayout(null);
		panel.setLayout(null);
	
		
		cho.add("������ȣ");
		cho.add("�����̸�");
		cho.setBounds(110	, 50, 150, 50);
		tf.setBounds(320, 50,150 , 27);
		btn.setBounds(470, 50, 100, 27);
		btn.addActionListener(ac2);
		panel.add(cho);
		panel.add(tf);
		panel.add(btn);
		TitledBorder jtx= 
	    		new TitledBorder(new LineBorder(Color.white,3),"���� �˻�");
		 jtx.setTitleFont(new Font( "��Ǯ���¿��� Medium", Font.PLAIN, 18 ) );
		 panel.setBorder(jtx);
		 panel.setBounds(0, 0, 700, 100);
		 tpanel.setBounds(0, 100, 700, 380);
		 mpanel.add(panel);
		 
			
		btn1.setBounds(550, 500, 100, 40);
		btn1.addActionListener(ac);
		mpanel.add(btn1);
		
		mpanel.add(tpanel);
		
	}
	
	ActionListener ac2 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(cho.getSelectedIndex()==0) {                 //������ȣ �˻�
			int to = Integer.parseInt(tf.getText());     //�ؽ�Ʈ ��Ʈ������ ��ȯ 
		
			String row1[][] = new String[1][12];           //���ϳ� �ҷ�����
			for (int i = 0; i < row1.length; i++) {
				BooksBean bean = mgr1.getett(to);
				row1[i][0] = bean.getBID()+"";
				row1[i][1] = bean.getTITLE();
				row1[i][2] = bean.getAUTHOR();
				row1[i][3] = bean.getPUBLISHER();
				row1[i][5] = bean.getLOCATION();
				row1[i][4] = bean.getBOOKSTATE();
			} 
				model = new DefaultTableModel(row1,col1);               //table �ٽø���� ������ �ϳ��� �� �ֱ�
				table = new JTable(model);
				 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				scr = new JScrollPane(table);
				table.setFont(new Font( "��Ǯ���¿��� Medium", Font.PLAIN, 20) );
				 table.setRowHeight(25);
				  table.getColumnModel().getColumn(0).setPreferredWidth(60);  //JTable �� �÷� ���� ����
				    table.getColumnModel().getColumn(1).setPreferredWidth(300);
				    table.getColumnModel().getColumn(2).setPreferredWidth(200);
				    table.getColumnModel().getColumn(3).setPreferredWidth(100);
				    table.getColumnModel().getColumn(4).setPreferredWidth(90);
				    table.getColumnModel().getColumn(5).setPreferredWidth(80);
				    scr.setBounds(0, 0, 670, 380);
			
			tpanel.removeAll();        //�гδٽø����  
			tpanel.revalidate();        //�г� �ٽø����
			vlist1.removeAllElements();  //vlist1 �� �ִ� �Ӽ��� �ٻ���
			tpanel.add(scr);                       //�гο� �ٽ� ���̺� �ֱ� 
			
			if(table.getValueAt(0, 0).equals("0")) {         //�˻���� ������ ���̾�α�
				MDialog md2 = new MDialog(memberf1, "����", true, "�˻������ �����ϴ�");
				md2.setVisible(true);
			}
			
		}else if(cho.getSelectedIndex()==1) {      //�̸����� �˻�
				vlist1 = mgr1.getsearch(tf.getText());
			String row1[][] = new String[vlist1.size()][12];
			for (int i = 0; i < row1.length; i++) {
				BooksBean bean = vlist1.elementAt(i);
				row1[i][0] = bean.getBID()+"";
				row1[i][1] = bean.getTITLE();
				row1[i][2] = bean.getAUTHOR();
				row1[i][3] = bean.getPUBLISHER();
				row1[i][5] = bean.getLOCATION();
				row1[i][4] = bean.getBOOKSTATE();
			}
				model = new DefaultTableModel(row1,col1);
				table = new JTable(model);
				 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				scr = new JScrollPane(table);
				table.setFont(new Font( "��Ǯ���¿��� Medium", Font.PLAIN, 20) );
				 table.setRowHeight(25);
				  table.getColumnModel().getColumn(0).setPreferredWidth(60);  //JTable �� �÷� ���� ����
				    table.getColumnModel().getColumn(1).setPreferredWidth(300);
				    table.getColumnModel().getColumn(2).setPreferredWidth(200);
				    table.getColumnModel().getColumn(3).setPreferredWidth(100);
				    table.getColumnModel().getColumn(4).setPreferredWidth(90);
				    table.getColumnModel().getColumn(5).setPreferredWidth(80);
				    scr.setBounds(0, 0, 670, 380);
			
			tpanel.removeAll();
			tpanel.revalidate();
			vlist1.removeAllElements();
			tpanel.add(scr);
			if(table.getRowCount()==0) {
				MDialog md2 = new MDialog(memberf1, "����", true, "�˻������ �����ϴ�");
				md2.setVisible(true);
			}
			
			}
		}
	};
	ActionListener ac = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(table.getSelectedRow()==-1) {
			MDialog md = new MDialog(memberf1, "����", true, "������ ������ �ּ���.");
				md.setVisible(true);
			}else {
				String item = (String)table.getValueAt(table.getSelectedRow(), 0);
				for (int i = 0; i < SwingProject.table1.getRowCount(); i++) {
					if(SwingProject.table1.getValueAt(i, 0).equals(item)) {
						SwingProject.table1.changeSelection(i,0, false, false);       //�ش缿 �����ϰ� ȭ�鵵 �̵����� 
						
			String str0 = (String) table.getValueAt(table.getSelectedRow(),0);            //Object Ÿ���� ��� ���������� ��ȯ
			String str1 = (String) table.getValueAt(table.getSelectedRow(),1);            //Object Ÿ���� ��� ���������� ��ȯ
			String str2 = (String) table.getValueAt(table.getSelectedRow(),2);
			String str3 = (String) table.getValueAt(table.getSelectedRow(),3);
			String str4 = (String) table.getValueAt(table.getSelectedRow(),4);
			String str5 = (String) table.getValueAt(table.getSelectedRow(),5);
			SwingProject.tf8.setText(str0);
			SwingProject.tf9.setText(str1);
			SwingProject.tf10.setText(str2);
			SwingProject.tf12.setText(str4);
			SwingProject.tf13.setText(str5);
			SwingProject.tf14.setText(str3);
			if(SwingProject.tf12.getText().equals("���� �Ұ���")) {
				SwingProject.tf12.setBackground(red);
				SwingProject.lentalbtn.setBackground(red);
				Runnable tt = new BookThread();
				Thread t1 = new Thread(tt);
				t1.start();
			}else if(SwingProject.tf12.getText().equals("���Ⱑ��")) {
				SwingProject.tf12.setBackground(Color.white);
				SwingProject.lentalbtn.setBackground(Color.white);
			}
			
			SimpleDateFormat sysdate = new SimpleDateFormat();
			Calendar date = Calendar.getInstance();
			String date2 = sysdate.format(date.getTime()); //���ڿ��� ���ó�¥ ���� 
			SwingProject.tf15.setText(date2.substring(0,10));         //���ó�¥ �ú��� �ڸ��� ����
			memberf1.dispose();
			if(SwingProject.tf4.getText().equals("")) {}   // �뿩�Ⱓ ĭ�� ����ִٸ� ������� 
			else {  //�뿩�Ⱓ ĭ�� ä�����ִٸ� ��¥ �����Ͽ� �ݳ����� ���� 
			int to = Integer.parseInt(SwingProject.tf4.getText().substring(0, 1));   //���ڿ��� ������ ��ȯ 
			date.add(Calendar.DATE,to);        //���� ��¥�� �ϼ� ���ϱ�
			String date3 = sysdate.format(date.getTime()); //���ѳ�¥ ���ڿ� �ֱ�
			SwingProject.tf16.setText(date3.substring(0,10));  //�ú��� �ڸ��� �ֱ� 
			
			
		
			}}}}
			
		}
	};
}