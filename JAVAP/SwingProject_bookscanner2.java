package JAVAP;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class SwingProject_bookscanner2 {
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
	static JFrame memberf;
	Vector <BooksBean>  vlist1;
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
		tpanel.add(scr);
		
		}
	
	public SwingProject_bookscanner2() {
		viewlist();
		
		memberf = new JFrame();
		memberf.setBackground(new  Color(170,220,255));
		memberf.setVisible(true);
		memberf.setSize(700,600);
		memberf.setLocationRelativeTo(null);
		memberf.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		memberf.add(mpanel);
		
		panel.setBackground(new Color(170,220,255));
		tpanel.setBackground(new Color(170,220,255));
		mpanel.setBackground(new Color(170,220,255));
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
	    		new TitledBorder(new LineBorder(Color.white),"���� �˻�");
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
			int to = Integer.parseInt(tf.getText());
		
			String row1[][] = new String[1][6];           //���ϳ� �ҷ�����
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
			
			if(table.getValueAt(0, 0).equals("0")) {
				MDialog md2 = new MDialog(memberf, "����", true, "�˻������ �����ϴ�");
				md2.setVisible(true);
			}
		}
			else if(cho.getSelectedIndex()==1) {      //�̸����� �˻�
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
				MDialog md2 = new MDialog(memberf, "����", true, "�˻������ �����ϴ�");
				md2.setVisible(true);
			}
				
			}
		}
	};
	ActionListener ac = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(table.getSelectedRow()==-1) {
			MDialog md = new MDialog(memberf, "����", true, "������ ������ �ּ���.");
				md.setVisible(true);
			}else {
			String str0 = (String) table.getValueAt(table.getSelectedRow(),0);            //Object Ÿ���� ��� ���������� ��ȯ
			
			for (int i = 0; i < SwingProject_1.table7.getRowCount(); i++) {
				if(SwingProject_1.table7.getValueAt(i, 0).equals(str0)) {
				//	SwingProject_1.table7.addRowSelectionInterval(i, i);        �ش缿 ���ø�����
					SwingProject_1.table7.changeSelection(i,0, false, false);       //�ش缿 �����ϰ� ȭ�鵵 �̵����� 
					
					String str00 = (String) SwingProject_1.table7.getValueAt(i,0);            //Object Ÿ���� ��� ���������� ��ȯ
					String str1 = (String) SwingProject_1.table7.getValueAt(i,1);            //Object Ÿ���� ��� ���������� ��ȯ
					String str2 = (String) SwingProject_1.table7.getValueAt(i,2);
					String str3 = (String) SwingProject_1.table7.getValueAt(i,3);
					String str4 = (String) SwingProject_1.table7.getValueAt(i,4);
					String str5 = (String) SwingProject_1.table7.getValueAt(i,5);
					String str6 = (String)SwingProject_1.table7.getValueAt(i,6);
					String str8 = (String) SwingProject_1.table7.getValueAt(i,7);
					String str7 = (String) SwingProject_1.table7.getValueAt(i,8);
					String str9 = (String)SwingProject_1.table7.getValueAt(i, 10);
					SwingProject_1.tf1.setText(str00);
					SwingProject_1.tf2.setText(str1);
					SwingProject_1.tf3.setText(str2);
					SwingProject_1.tf4.setText(str3);
					SwingProject_1.tf5.setText(str4);
					SwingProject_1.tf6.setText(str5);
					SwingProject_1.tf8.setText(str8);
					SwingProject_1.tf9.setText(str6);
					SwingProject_1.tf10.setText(str7);
					if(str9==null) {
						SwingProject_1.setbookimg("non.jpg");
					}else
					SwingProject_1.setbookimg(str9);
				}
			}			
			
			memberf.dispose();
			}
			
		}
	};
}