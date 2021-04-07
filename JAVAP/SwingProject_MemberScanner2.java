package JAVAP;

import java.awt.Choice;
import java.awt.Color;
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

public class SwingProject_MemberScanner2 {
	String col[] = {"회원번호","회원 이름","회원 등급","전화번호","대여기간","대여횟수","대출가능 권수"};
	
	BMEMBERSMgr mgr;
	JPanel panel = new JPanel();
	JPanel mpanel = new JPanel();
	JPanel tpanel = new JPanel();
	JTable table;
	DefaultTableModel model;
	JScrollPane scr;
	Choice cho = new Choice();
	JTextField tf = new JTextField(10);
	JButton btn = new JButton("검색");
	JButton btn1 = new JButton("선택하기");
	static JFrame memberf;
	Vector<BMEMBERSBean> vlist;
	
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
		model = new DefaultTableModel(row,col);
		table = new JTable(model);
		 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		scr = new JScrollPane(table);
		table.setFont(new Font( "잘풀리는오늘 Medium", Font.PLAIN, 20) );
		 table.setRowHeight(25);
		 
		  table.getColumnModel().getColumn(0).setPreferredWidth(70);  //JTable 의 컬럼 길이 조절
		    table.getColumnModel().getColumn(1).setPreferredWidth(90);
		    table.getColumnModel().getColumn(2).setPreferredWidth(80);
		    table.getColumnModel().getColumn(3).setPreferredWidth(190);
		    table.getColumnModel().getColumn(4).setPreferredWidth(80);
		    table.getColumnModel().getColumn(5).setPreferredWidth(80);
		    table.getColumnModel().getColumn(6).setPreferredWidth(130);
		    scr.setBounds(0, 0, 670, 380);
	tpanel.add(scr);
		
		
	}
	public SwingProject_MemberScanner2() {
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
		
		cho.add("회원번호");
		cho.add("회원이름");
		cho.setBounds(110	, 50, 150, 50);
		tf.setBounds(320, 50,150 , 27);
		btn.setBounds(470, 50, 100, 27);
		panel.add(cho);
		panel.add(tf);
		panel.add(btn);
		btn.addActionListener(sc);
		TitledBorder jtx= 
	    		new TitledBorder(new LineBorder(Color.white),"회원 검색");
		 jtx.setTitleFont(new Font( "잘풀리는오늘 Medium", Font.PLAIN, 18 ) );
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
			MDialog md = new MDialog(memberf, "오류", true, "회원을 선택해 주세요.");
				md.setVisible(true);
			}else {
				String item = (String)table.getValueAt(table.getSelectedRow(), 0);
				for (int i = 0; i < SwingProject.table.getRowCount(); i++) {
					if(SwingProject_2.table7.getValueAt(i, 0).equals(item)) {
						SwingProject_2.table7.changeSelection(i,0, false, false);       //해당셀 선택하고 화면도 이동해줌 
						
			String str0 = (String) table.getValueAt(table.getSelectedRow(),0);            //Object 타입을 모두 정수형으로 변환
			String str1 = (String) table.getValueAt(table.getSelectedRow(),1);            //Object 타입을 모두 정수형으로 변환
			String str2 = (String) table.getValueAt(table.getSelectedRow(),2);
			String str3 = (String) table.getValueAt(table.getSelectedRow(),3);
			String str4 = (String) table.getValueAt(table.getSelectedRow(),4);
			String str5 = (String) table.getValueAt(table.getSelectedRow(),5);
			String str6 = (String) table.getValueAt(table.getSelectedRow(),6);
			SwingProject_2.mID.setText(str0);
			SwingProject_2.mName.setText(str1);
			SwingProject_2.cho.select(str2);
			SwingProject_2.mPhone.setText(str3);
			SwingProject_2.mMax.setText(str4);
			SwingProject_2.mCount.setText(str5);
			SwingProject_2.mLimit.setText(str6);
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
				model = new DefaultTableModel(row,col);
				table = new JTable(model);
				 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				scr = new JScrollPane(table);
				table.setFont(new Font( "잘풀리는오늘 Medium", Font.PLAIN, 20) );
				 table.setRowHeight(25);
				 
				  table.getColumnModel().getColumn(0).setPreferredWidth(70);  //JTable 의 컬럼 길이 조절
				    table.getColumnModel().getColumn(1).setPreferredWidth(90);
				    table.getColumnModel().getColumn(2).setPreferredWidth(80);
				    table.getColumnModel().getColumn(3).setPreferredWidth(190);
				    table.getColumnModel().getColumn(4).setPreferredWidth(80);
				    table.getColumnModel().getColumn(5).setPreferredWidth(80);
				    table.getColumnModel().getColumn(6).setPreferredWidth(130);
				    scr.setBounds(0, 0, 670, 380);
				    
			
			
			tpanel.removeAll();
			tpanel.revalidate();
		    vlist.removeAllElements();
		    tpanel.add(scr);
		    
			
			
			
			if(table.getValueAt(0, 0).equals("0")) {         //검색결과 없으면 다이얼로그
				MDialog md2 = new MDialog(memberf, "오류", true, "검색결과가 없습니다");
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
				model = new DefaultTableModel(row,col);
				table = new JTable(model);
				 table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				scr = new JScrollPane(table);
				table.setFont(new Font( "잘풀리는오늘 Medium", Font.PLAIN, 20) );
				 table.setRowHeight(25);
				 
				  table.getColumnModel().getColumn(0).setPreferredWidth(70);  //JTable 의 컬럼 길이 조절
				    table.getColumnModel().getColumn(1).setPreferredWidth(90);
				    table.getColumnModel().getColumn(2).setPreferredWidth(80);
				    table.getColumnModel().getColumn(3).setPreferredWidth(190);
				    table.getColumnModel().getColumn(4).setPreferredWidth(80);
				    table.getColumnModel().getColumn(5).setPreferredWidth(80);
				    table.getColumnModel().getColumn(6).setPreferredWidth(130);
				    scr.setBounds(0, 0, 670, 380);
				    tpanel.removeAll();
					tpanel.revalidate();
				    vlist.removeAllElements();
				    tpanel.add(scr);
			
			
			
			
			if(table.getRowCount()==0) {
				MDialog md2 = new MDialog(memberf, "오류", true, "검색결과가 없습니다");
				md2.setVisible(true);
			}
			}
			
			
		}
	};
	
	
	
	
	
}