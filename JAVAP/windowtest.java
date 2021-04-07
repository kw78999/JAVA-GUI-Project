package JAVAP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;
import java.awt.GridLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;

public class  windowtest {
	private static final LayoutManager FlowLayout = null;

	public static void main(String[] args) {
		JPanel panel = new JPanel();
		JPanel inpanel = new JPanel();
		JPanel panel1 = new JPanel();
		JPanel inpanel1 = new JPanel(); 
		JTabbedPane t = new JTabbedPane();
		JTabbedPane t1 = new JTabbedPane();
		
		JFrame frame = new JFrame("gi");
		JLabel label = new JLabel("회원목록");
		label.setFont(new Font("Times",Font.BOLD,25));
		JLabel label1 = new JLabel("도서목록");
		label1.setFont(new Font("Times",Font.BOLD,25));
		JPanel p = new JPanel();
		JPanel p1 = new JPanel();
		TextField tf = new TextField(10);
		JTextField tf8 = new JTextField(12);
		JTextField tf9 = new JTextField(12);
		JTextField tf10 = new JTextField(12);
		JTextField tf11 = new JTextField(50);
		JTextField tf12 = new JTextField(12);
		JTextField tf13 = new JTextField(12);
		JTextField tf14 = new JTextField(12);
		String col[] = {"순번","회원번호","회원명","회원상태","회원등급","전화번호"};
		String row[][] = {{"1","101","홍길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"}};
		String col1[] = {"순번","도서상태","등록번호","서명","저자","대출일"};
		String row1[][] = {{"1","101","홍길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"},
				{"2","102","고길동","일반","일반","0"}};
		frame.getContentPane().setLayout(new BorderLayout());
		inpanel1.setLayout(new BorderLayout());
		p1.setLayout(new BorderLayout());
		p.setLayout(new BorderLayout());
		panel.setLayout(new BorderLayout());
		panel1.setLayout(new BorderLayout());
		JPanel panel13 = new JPanel();
		JPanel panel14 = new JPanel();
		JPanel panel15 = new JPanel();
		panel14.setLayout(new FlowLayout());
		JPanel panel12 = new JPanel();
		panel12.setLayout(new BorderLayout());
		frame.getContentPane().add(inpanel,BorderLayout.NORTH);
		
		
		
		t.add("대출 / 반납",t1);
		t.add("도서관리",new JTextArea());
		t.add("회원관리",new JTextArea());
		t.add("이용통계",new JTextArea());
		t.setFont( new Font( "Times", Font.BOLD, 23 ) );
		t.setBackground(new  Color(170,220,255));
		t1.add("대여",panel);
		t1.add("반납",new JTextArea());
		t1.add("이용 현황",new JTextArea());
		t1.setFont( new Font( "Times", Font.BOLD, 18 ) );
		panel1.add(t);
		JLabel lab8= new JLabel("등록번호");
		JLabel lab9= new JLabel("대출일");
		JLabel lab10= new JLabel("반납예정일");
		JLabel lab11= new JLabel("서명");
		JLabel lab12= new JLabel("저자");
		JLabel lab13= new JLabel("출판사");
		JLabel lab14= new JLabel("도서분류");
		
		
		
		JTable table = new JTable(row,col);
		table.setPreferredScrollableViewportSize(new Dimension(500,300));
		table.setFillsViewportHeight(true);
		p.add(label,BorderLayout.NORTH);
	p.add(new JScrollPane(table),BorderLayout.CENTER);
		
	JTable table1 = new JTable(row1,col1);
	table1.setPreferredScrollableViewportSize(new Dimension(500,300));
	table1.setFillsViewportHeight(true);
	p1.add(label1,BorderLayout.NORTH);
    p1.add(new JScrollPane(table1),BorderLayout.CENTER);
	
    p.setBackground(new  Color(170,220,255));
    p1.setBackground(new  Color(170,220,255));
    inpanel1.add(p,BorderLayout.NORTH);
    inpanel1.add(p1,BorderLayout.CENTER);
    panel.add(inpanel1,BorderLayout.WEST);
    
    TitledBorder jtx = 
new TitledBorder(new LineBorder(Color.white),"회원정보");
    TitledBorder jtx1= 
    		new TitledBorder(new LineBorder(Color.white),"대출자료정보");
    panel13.setBorder(new EmptyBorder(30, 30, 5, 5));
    JLabel lab2= new JLabel("전화번호");
    JLabel lab6= new JLabel("주소              ");
    JTextField tf6 = new JTextField(13);
    
    JLabel label_27 = new JLabel("");
    
    JLabel label_5 = new JLabel("");
    
    JLabel label_1 = new JLabel("");
    
    JLabel label_32 = new JLabel("");
    
    JLabel label_12 = new JLabel("");
    
    JLabel label_9 = new JLabel("");
    JTextField tf4 = new JTextField(12);
    
    JLabel label_14 = new JLabel("");
    
    JLabel label_2 = new JLabel("");
    
    JLabel label_33 = new JLabel("");
    JLabel lab3= new JLabel("대출/가능권수");
    
    JLabel label_23 = new JLabel("");
    JLabel lab5= new JLabel("회원상태");
    
    JLabel label_10 = new JLabel("");
    JLabel lab7= new JLabel("메모");
    JLabel lab1= new JLabel("회원명");
    
    JLabel label_22 = new JLabel("");
    
    JLabel label_19 = new JLabel("");
    JTextField tf3 = new JTextField(12);
    
    JLabel label_38 = new JLabel("");
    
    JLabel label_28 = new JLabel("");
    JLabel lab = new JLabel("회원정보");
    
    JLabel label_35 = new JLabel("");
    
    JLabel label_17 = new JLabel("");
    
    JLabel label_25 = new JLabel("");
    JTextField tf7 = new JTextField(50);
    
    JLabel label_11 = new JLabel("");
    
    JLabel label_15 = new JLabel("");
    
    JLabel label_21 = new JLabel("");
    
    JLabel label_37 = new JLabel("");
    JTextField tf5 = new JTextField(13);
    
    JLabel label_8 = new JLabel("");
    
    JLabel label_24 = new JLabel("");
    
    JLabel label_3 = new JLabel("");
    
    JLabel label_20 = new JLabel("");
    JTextField tf2 = new JTextField(12);
    
    JLabel label_36 = new JLabel("");
    
    JLabel label_34 = new JLabel("");
    
    JLabel label_7 = new JLabel("");
    
    JLabel label_26 = new JLabel("");
    JButton btn1 = new JButton("회원검색");
    JTextArea ta1 = new JTextArea(6,30);
    
    JLabel label_30 = new JLabel("");
    
    JLabel label_29 = new JLabel("");
    
    JLabel label_13 = new JLabel("");
    JLabel lab4= new JLabel("회원등급");
    JTextField tf1 = new JTextField(12);
    
    JLabel label_16 = new JLabel("");
    
    JLabel label_4 = new JLabel("");
    
    JLabel label_31 = new JLabel("");
    
    JLabel label_18 = new JLabel("");
    
    JLabel label_6 = new JLabel("");
  panel14.setBorder(jtx1);
  panel14.add(lab8);
  panel14.add(tf8);
  panel14.add(lab9);
  panel14.add(tf9);
  panel14.add(lab10);
  panel14.add(tf10);
  panel14.add(lab11);
  panel14.add(tf11);
  panel14.add(lab12);
  panel14.add(tf12);
  panel14.add(lab13);
  panel14.add(tf13);
  panel14.add(lab14);
  panel14.add(tf14);
  panel15.setLayout(new GridLayout(0, 1, 0, 0));
  panel15.add(panel13);
  panel15.add(panel14);
  
  
    jtx.setTitleFont(new Font( "Times", Font.BOLD, 18 ) );
    panel13.setBackground(new  Color(170,220,255));
    FlowLayout fl_panel13 = new FlowLayout();
    panel13.setLayout(fl_panel13);
    panel13.add(lab2);
    panel13.add(lab6);
    panel13.add(tf6);
    panel13.add(label_27);
    panel13.add(label_5);
    panel13.add(label_1);
    panel13.add(label_32);
    panel13.add(label_12);
    panel13.add(label_9);
    panel13.add(tf4);
    panel13.add(label_14);
    panel13.add(label_2);
    panel13.add(label_33);
    panel13.add(lab3);
    panel13.add(label_23);
    panel13.add(lab5);
    panel13.add(label_10);
    panel13.add(lab7);
    panel13.add(lab1);
    panel13.add(label_22);
    panel13.add(label_19);
    panel13.add(tf3);
    panel13.add(label_38);
    panel13.add(label_28);
    panel13.add(lab);
    panel13.add(label_35);
    panel13.add(label_17);
    panel13.add(label_25);
    panel13.add(tf7);
    panel13.add(label_11);
    panel13.add(label_15);
    panel13.add(label_21);
    panel13.add(label_37);
    panel13.add(tf5);
    panel13.add(label_8);
    panel13.add(label_24);
    panel13.add(label_3);
    panel13.add(label_20);
    panel13.add(tf2);
    panel13.add(label_36);
    panel13.add(label_34);
    panel13.add(label_7);
    panel13.add(label_26);
    panel13.add(btn1);
    panel13.add(ta1);
    panel13.add(label_30);
    panel13.add(label_29);
    panel13.add(label_13);
    panel13.add(lab4);
    panel13.add(tf1);
    panel13.add(label_16);
    panel13.add(label_4);
    panel13.add(label_31);
    panel13.add(label_18);
    panel13.add(label_6);
    panel14.setBackground(new  Color(170,220,255));
    panel.add(panel15,BorderLayout.CENTER);

    
    
	
	frame.getContentPane().add(panel1,BorderLayout.NORTH);
	frame.setBackground(new  Color(170,220,255));
		 frame.setVisible(true);
		 frame.setSize(1200,845);
		 frame.setLocationRelativeTo(null);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}