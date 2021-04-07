package JAVAP;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import javax.swing.table.TableCellRenderer;

import JAVAP.BMEMBERSBean;


public class SwingProject_MemberScanner{ 
	String col[] = {"ȸ����ȣ","ȸ�� �̸�","ȸ�� ���","��ȭ��ȣ","�뿩�Ⱓ","�뿩Ƚ��","���Ⱑ�� �Ǽ�"};
	
	BMEMBERSMgr mgr;
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
	Vector<BMEMBERSBean> vlist;
	static Color red = new Color(255,207,253);
	static Color bg = new Color(186,218,255);
	//new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 20) );
	
	
	void viewmem() {
		mgr = new BMEMBERSMgr();
		
	    vlist = mgr.getListMember();
		String row[][] = new String[vlist.size()][10];
		for (int i = 0; i < row.length; i++) {
			BMEMBERSBean bean = vlist.elementAt(i);
			row[i][0] = bean.getMID()+"";
			row[i][1] = bean.getMNAME();
			row[i][2] = bean.getMGRADE();
			row[i][3] = bean.getMPHONE();
			row[i][4] = bean.getMAXRENTAL()+"";
			row[i][5] = bean.getECOUNT()+"";
			row[i][6] = bean.getELIMIT()+"";
		}
		DefaultTableModel model2 = new DefaultTableModel(row, col) {

	        private static final long serialVersionUID = 1L;

	        @Override
	        public Class getColumnClass(int column) {
	            return getValueAt(0, column).getClass();
	        }
	    };
	    table = new JTable(model2) {
	            private static final long serialVersionUID = 1L;
	            @Override
	            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
	                Component c = super.prepareRenderer(renderer, row, column);

	                if (!isRowSelected(row)) {
	                    if (table.getColumnCount() >= 0) {
	                        String type = (String)getModel().getValueAt(row,6);
	                        if (!type.equals("0")) {
	                            c.setBackground(Color.white);
	                        }
	                        if (type.equals("0")) {
	                            c.setBackground(red);
	                        }
	                    }
	                }
	                return c;
	            }
	        };
	        table.setPreferredScrollableViewportSize(new Dimension(597,100));
	        JScrollPane scr = new JScrollPane(table);
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	        table.getColumnModel().getColumn(0).setPreferredWidth(70);  //JTable �� �÷� ���� ����
	        table.getColumnModel().getColumn(1).setPreferredWidth(90);
	        table.getColumnModel().getColumn(2).setPreferredWidth(80);
	        table.getColumnModel().getColumn(3).setPreferredWidth(200);
	        table.getColumnModel().getColumn(4).setPreferredWidth(80);
	        table.getColumnModel().getColumn(5).setPreferredWidth(70);
	        table.getColumnModel().getColumn(6).setPreferredWidth(100);
	        table.setFont(new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 20) );
		    table.setRowHeight(25);
		    table.setSelectionBackground(new Color(7,142,255));
		    table.setSelectionForeground(Color.white);
		    scr.setBounds(0, 0, 670, 380);
	    tpanel.add(scr);
	}
	public SwingProject_MemberScanner() {
		viewmem();
		
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
		
		cho.add("ȸ����ȣ");
		cho.add("ȸ���̸�");
		cho.setBounds(110	, 50, 150, 50);
		tf.setBounds(320, 50,150 , 27);
		btn.setBounds(470, 50, 100, 27);
		panel.add(cho);
		panel.add(tf);
		panel.add(btn);
		btn.addActionListener(sc);
		TitledBorder jtx= 
	    		new TitledBorder(new LineBorder(Color.white),"ȸ�� �˻�");
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
	ActionListener ac = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(table.getSelectedRow()==-1) {
			MDialog md = new MDialog(memberf, "����", true, "ȸ���� ������ �ּ���.");
				md.setVisible(true);
			}else {
				String item = (String)table.getValueAt(table.getSelectedRow(), 0);
				for (int i = 0; i < SwingProject.table.getRowCount(); i++) {
					if(SwingProject.table.getValueAt(i, 0).equals(item)) {
						SwingProject.table.changeSelection(i,0, false, false);       //�ش缿 �����ϰ� ȭ�鵵 �̵����� 
						
			String str0 = (String) table.getValueAt(table.getSelectedRow(),0);            //Object Ÿ���� ��� ���������� ��ȯ
			String str1 = (String) table.getValueAt(table.getSelectedRow(),1);            //Object Ÿ���� ��� ���������� ��ȯ
			String str2 = (String) table.getValueAt(table.getSelectedRow(),2);
			String str3 = (String) table.getValueAt(table.getSelectedRow(),3);
			String str4 = (String) table.getValueAt(table.getSelectedRow(),4);
			String str6 = (String) table.getValueAt(table.getSelectedRow(),6);
			SwingProject.tf1.setText(str0);
			SwingProject.tf2.setText(str1);
			SwingProject.tf3.setText(str3);
			SwingProject.tf4.setText(str4);
			SwingProject.tf5.setText(str2);
			SwingProject.tf6.setText(str6);
			
			if(str6.equals("0")) {
				SwingProject.tf6.setBackground(red);
				SwingProject.lentalbtn.setBackground(red);
				Runnable tt = new MemThread();
				Thread t1 = new Thread(tt);
				t1.start();
			}else if (!str6.equals("0")) {
				SwingProject.tf6.setBackground(Color.white);
				SwingProject.lentalbtn.setBackground(new Color(116,173,255));
			}
			SimpleDateFormat sysdate = new SimpleDateFormat();
			Calendar date = Calendar.getInstance();
			String date2 = sysdate.format(date.getTime()); //���ڿ��� ���ó�¥ ���� 
			SwingProject.tf15.setText(date2.substring(0,10));  //�뿩��¥ĭ�� ���ó�¥ �Է�
			
			int to = Integer.parseInt(SwingProject.tf4.getText().substring(0, 1));   //���ڿ��� ������ ��ȯ 
			date.add(Calendar.DATE,to);   
			String date3 = sysdate.format(date.getTime()); //���ѳ�¥ ���ڿ� �ֱ�
            SwingProject.tf16.setText(date3.substring(0,10));  //�ú��� �ڸ��� �ֱ� 
			memberf.dispose();
					}}}
			
		}
	};
	ActionListener sc = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if(cho.getSelectedIndex()==0) {
				int to = Integer.parseInt(tf.getText());
				String row[][] = new String[1][7];
				for (int i = 0; i < row.length; i++) {
					BMEMBERSBean bean = mgr.getett(to);
					row[i][0] = bean.getMID()+"";
					row[i][1] = bean.getMNAME();
					row[i][2] = bean.getMGRADE();
					row[i][3] = bean.getMPHONE();
					row[i][4] = bean.getMAXRENTAL()+"";
					row[i][5] = bean.getECOUNT()+"";
					row[i][6] = bean.getELIMIT()+"";
			}
				DefaultTableModel model2 = new DefaultTableModel(row, col) {

			        private static final long serialVersionUID = 1L;

			        @Override
			        public Class getColumnClass(int column) {
			            return getValueAt(0, column).getClass();
			        }
			    };
				table = new JTable(model2) {
		            private static final long serialVersionUID = 1L;
		            @Override
		            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		                Component c = super.prepareRenderer(renderer, row, column);

		                if (!isRowSelected(row)) {
		                    if (table.getColumnCount() >= 0) {
		                        String type = (String)getModel().getValueAt(row,6);
		                        if (!type.equals("0")) {
		                            c.setBackground(Color.white);
		                        }
		                        if (type.equals("0")) {
		                            c.setBackground(red);
		                        }
		                    }
		                }
		                return c;
		            }
		        };
		        table.setPreferredScrollableViewportSize(new Dimension(597,100));
		        JScrollPane scr = new JScrollPane(table);
		        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		        table.getColumnModel().getColumn(0).setPreferredWidth(70);  //JTable �� �÷� ���� ����
		        table.getColumnModel().getColumn(1).setPreferredWidth(90);
		        table.getColumnModel().getColumn(2).setPreferredWidth(80);
		        table.getColumnModel().getColumn(3).setPreferredWidth(200);
		        table.getColumnModel().getColumn(4).setPreferredWidth(80);
		        table.getColumnModel().getColumn(5).setPreferredWidth(70);
		        table.getColumnModel().getColumn(6).setPreferredWidth(100);
		        table.setFont(new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 20) );
			    table.setRowHeight(25);
			    table.setSelectionBackground(new Color(7,142,255));
			    table.setSelectionForeground(Color.white);
			    scr.setBounds(0, 0, 670, 380);
			    tpanel.removeAll();
				tpanel.revalidate();
			    vlist.removeAllElements();
		    tpanel.add(scr);
		
		    
			
			
			
			if(table.getValueAt(0, 0).equals("0")) {         //�˻���� ������ ���̾�α�
				MDialog md2 = new MDialog(memberf, "����", true, "�˻������ �����ϴ�");
				md2.setVisible(true);
			 }
			}else if(cho.getSelectedIndex()==1) {
				vlist = mgr.search(tf.getText());
				String row[][] = new String[vlist.size()][7];
				for (int i = 0; i < row.length; i++) {
					BMEMBERSBean bean = vlist.elementAt(i);
					row[i][0] = bean.getMID()+"";
					row[i][1] = bean.getMNAME();
					row[i][2] = bean.getMGRADE();
					row[i][3] = bean.getMPHONE();
					row[i][4] = bean.getMAXRENTAL()+"";
					row[i][5] = bean.getECOUNT()+"";
					row[i][6] = bean.getELIMIT()+"";
			}
				DefaultTableModel model2 = new DefaultTableModel(row, col) {

			        private static final long serialVersionUID = 1L;

			        @Override
			        public Class getColumnClass(int column) {
			            return getValueAt(0, column).getClass();
			        }
			    };
				table = new JTable(model2) {
		            private static final long serialVersionUID = 1L;
		            @Override
		            public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
		                Component c = super.prepareRenderer(renderer, row, column);

		                if (!isRowSelected(row)) {
		                    if (table.getColumnCount() >= 0) {
		                        String type = (String)getModel().getValueAt(row,6);
		                        if (!type.equals("0")) {
		                            c.setBackground(Color.white);
		                        }
		                        if (type.equals("0")) {
		                            c.setBackground(red);
		                        }
		                    }
		                }
		                return c;
		            }
		        };
		        table.setPreferredScrollableViewportSize(new Dimension(597,100));
		        JScrollPane scr = new JScrollPane(table);
		        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		        table.getColumnModel().getColumn(0).setPreferredWidth(70);  //JTable �� �÷� ���� ����
		        table.getColumnModel().getColumn(1).setPreferredWidth(90);
		        table.getColumnModel().getColumn(2).setPreferredWidth(80);
		        table.getColumnModel().getColumn(3).setPreferredWidth(200);
		        table.getColumnModel().getColumn(4).setPreferredWidth(80);
		        table.getColumnModel().getColumn(5).setPreferredWidth(70);
		        table.getColumnModel().getColumn(6).setPreferredWidth(100);
		        table.setFont(new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 20) );
			    table.setRowHeight(25);
			    table.setSelectionBackground(new Color(7,142,255));
			    table.setSelectionForeground(Color.white);
			    scr.setBounds(0, 0, 670, 380);
			    tpanel.removeAll();
				tpanel.revalidate();
			    vlist.removeAllElements();
		    tpanel.add(scr);
		
			if(table.getRowCount()==0) {
				MDialog md2 = new MDialog(memberf, "����", true, "�˻������ �����ϴ�");
				md2.setVisible(true);
			}
			}
			
			
		}
	};
	
	
	
	
	
}
