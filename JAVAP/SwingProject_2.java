package JAVAP;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import JAVAP.BMEMBERSBean;
import JAVAP.BMEMBERSMgr;

public class SwingProject_2 implements ActionListener,ItemListener{
	ImageIcon normalIcon5 = new ImageIcon("C:\\\\\\\\image\\\\send.jpg"); 
	ImageIcon normalIcon6 = new ImageIcon("C:\\\\\\\\image\\\\sned3.jpg"); 
	 static  JButton sbtn ;
	 Image btnimg5 = normalIcon5.getImage(); 
	 Image btnimg6= normalIcon6.getImage(); 
	 //버튼에 이미지 추가
	  Image change5 = btnimg5.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	  ImageIcon changeicon5 = new ImageIcon(change5);
	  
	  Image change6 = btnimg5.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	  ImageIcon changeicon6= new ImageIcon(change6);
	  
	  Image change7 = btnimg6.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	  ImageIcon changeicon7= new ImageIcon(change7);
	  
	JTabbedPane t_2 = new JTabbedPane();
	JPanel mpanel = new JPanel();
	static JPanel lpanel = new JPanel();
	static JPanel lpanel8 = new JPanel();
	JPanel lmpanel = new JPanel();
	JPanel lpanel2 = new JPanel();
//	JPanel rpanel = new JPanel();
	static BMEMBERSMgr mgr;
	static ImageIcon icon;
	static JTextField ctf = new JTextField("",50);
	static JTextArea cta = new JTextArea();
	static int cnt;
	static JScrollPane chatScroll ;
	static JPanel cpanel = new JPanel();
	JButton btn1 = new JButton("회원생성");
	JButton btn2 = new JButton("수정");
	JButton btn3 = new JButton("삭제");
	
	JLabel lab0 = new JLabel("회원번호");
	JLabel lab1 = new JLabel("대여기간");
	JLabel lab2 = new JLabel("회원이름");
	JLabel lab3 = new JLabel("회원등급");
	JLabel lab4 = new JLabel("전화번호");
	
	
	JLabel lab5 = new JLabel("대여횟수");
	JLabel lab6 = new JLabel("대출가능 권수");
	
	static ImageIcon normalIcon2 = new ImageIcon("C:\\image\\test2.jpg");
	static  Image btnimg = normalIcon2.getImage();        //버튼에 이미지 부착
	  static  Image change1 = btnimg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
	   static  ImageIcon changeicon1 = new ImageIcon(change1);
	
	static JTextField mID = new JTextField(10);
	static JTextField mMax = new JTextField(10);
	static JTextField mName = new JTextField(10);
	static JTextField mPhone = new JTextField(20);
	static JButton btns = new JButton(changeicon1);
	static JTextField mCount = new JTextField();
	static JTextField mLimit = new JTextField();
	
	static Choice cho = new Choice();
	static String cho1 ;
	DefaultTableModel m2;
	static Vector<BMEMBERSBean> vlist;
    static JTable table7;
	static DefaultTableModel model3;
	static JScrollPane scr;
	static String col[] = {"회원번호","이름","회원등급","전화번호","대여기간","대여횟수","대출가능 권수"};
	//String row[][] ;
	
	static Color red = new Color(255,119,228);
	static Color bg = new Color(186,218,255);
	//new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 20) );
	
	
	public static void viewmember() {
		mgr = new BMEMBERSMgr();
		vlist = mgr.getListMember();
		String row[][] = new String[vlist.size()][8];
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
		model3 = new DefaultTableModel(row,col);
		table7 = new JTable(model3);
		scr = new JScrollPane(table7);
		table7.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
		//m2 =(DefaultTableModel)table7.getModel();
		table7.getColumnModel().getColumn(0).setPreferredWidth(70);//JTable 의 컬럼 길이 조절
	    table7.getColumnModel().getColumn(1).setPreferredWidth(100);
	    table7.getColumnModel().getColumn(2).setPreferredWidth(100);
	    table7.getColumnModel().getColumn(3).setPreferredWidth(300);
	    table7.getColumnModel().getColumn(4).setPreferredWidth(90);
	    table7.getColumnModel().getColumn(5).setPreferredWidth(90);
	    table7.getColumnModel().getColumn(6).setPreferredWidth(90);
	    table7.setFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 20) );
	    table7.setRowHeight(25);
	    JTableHeader header = table7.getTableHeader();            //테이블 헤더 색상 
	    header.setBackground(new  Color(170,220,255));
	    table7.setSelectionBackground(new Color(7,142,255));
	    table7.setSelectionForeground(Color.white);
	    table7.addMouseListener(selectRow);
	    scr.setBounds(8, 30, 585, 670);
	    lpanel.add(scr);
	    lpanel.add(btns);
		
		
		
	}
	
	
	
	
	
	
	public SwingProject_2() {
		
		sbtn =new JButton(changeicon5);
		
		mpanel.setBackground(bg);
		lpanel.setBackground(bg);
		lmpanel.setBackground(bg);
		lpanel2.setBackground(bg);
		lpanel8.setBackground(bg);
	//	rpanel.setBackground(new  Color(0,162,240));
	  //  icon = new ImageIcon("C:\\Java\\eclipse-workspace\\myJava\\ch18\\test1.jpg");
	    JPanel rpanel = new JPanel();
	    rpanel.setBackground(bg);
		mpanel.setLayout(null);
		lmpanel.setLayout(new BorderLayout());
		lpanel.setLayout(null);
			rpanel.setLayout(null);
		 lpanel.setPreferredSize(new Dimension(600,600));
		 
		
		TitledBorder jtx= 
	    		new TitledBorder(new LineBorder(Color.white,5),"전체 회원       ");
		 jtx.setTitleFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 20) );
		
		
		
		lpanel.setBorder(jtx);
		
		
		viewmember(); //회원테이블 보이게하기 
		
		TitledBorder jtx1= 
	    		new TitledBorder(new LineBorder(Color.white,5),"회원 생성");
		 jtx1.setTitleFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 20) );
		 rpanel.setBorder(jtx1);
		 
		//스티브 천스 기존코드 수정문/////////////////////////////
		//문의 : 최엔지니어, 천마케터
		 
		 lab0.setBounds(30, 60, 100, 30);
		 lab0.setFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 20) );
		 
		 lab2.setBounds(30, 100, 100, 30);
		 lab2.setFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 20) );
		 
		 lab3.setBounds(30, 140, 100, 30);
		 lab3.setFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 20) );
		 
		 lab1.setBounds(30, 180, 120, 30);
		 lab1.setFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 20) );
		 
		 lab4.setBounds(30, 220, 100, 30);
		 lab4.setFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 20) );
		 
		 
		lab5.setBounds(30, 260, 100, 30);
		lab5.setFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 20) );
		
		lab6.setBounds(10, 300, 140, 30);
		lab6.setFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 20) );
		 
		mID.setBounds(150, 60, 180, 30);
		mID.setEditable(false);
		
		
		 mName.setBounds(150,100,180,30);
		 mName.addActionListener(this);
		 cho.add("등급 선택");
		 cho.add("일반");
		 cho.add("고급");
		 cho.add("VIP");
		 
		 cho.setBounds(150, 140, 180, 190);
		 cho.addItemListener(this);
		 
		 mMax.setBounds(150,180,180,30);
		 mMax.setEditable(false);
		 mMax.addActionListener(this);
		 
		 mPhone.setBounds(150,220,180,30);
		 mPhone.addActionListener(this);
		 mCount.setBounds(150,260,180,30);
		 mCount.setEditable(false);
			mLimit.setBounds(150,300,180,30);
			mLimit.setEditable(false);
			
			
		 btn1.setBounds(150, 340, 170, 40);
		 btn1.addActionListener(this);
		 btn1.addMouseListener(button);
		 btn1.setBackground(new  Color(170,220,255));
		 btn1.setForeground(Color.WHITE);
		 btn1.setFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 14) );
		 
		
		
		btn2.setBounds(100, 390, 100, 30);
		btn2.addActionListener(this);
		
		btn3.setBounds(220, 390, 100, 30);
		btn3.addActionListener(this);
		
		
				
		TitledBorder jtx2= 
		 		new TitledBorder(new LineBorder(Color.white,5),"회원과의 채팅");
		jtx2.setTitleFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 18) );
				
		
		
		chatScroll = new JScrollPane(cta);
		cta.setEnabled(false);
		ChatAction ca = new ChatAction();
		sbtn.setBorderPainted(false);			
				sbtn.setFocusPainted(false);
				sbtn.setContentAreaFilled(false);
				sbtn.addMouseListener(send);
		  sbtn.addActionListener(ca.acc);
		  ctf.addActionListener(ca.acc);
		  sbtn.setBounds(470, 220, 80,30);
		  ctf.setBounds(20, 220, 450, 30);
		  chatScroll.setBounds(20,30	, 530, 190);
		  chatScroll.setBackground(Color.black);
		  cpanel.add(sbtn);
		  cpanel.add(ctf);
		  cpanel.add(chatScroll);
		rpanel.add(btn2);
		rpanel.add(btn3);
		cpanel.setLayout(null);
		lpanel8.setLayout(null);
		cpanel.setBackground(bg);//투명
		cpanel.setBorder(jtx2);
		cpanel.setBounds(0,425,565, 260);///////////////////////////////////////////////
		
		rpanel.add(cho);
		 rpanel.add(mMax);
		 rpanel.add(mPhone);
		 rpanel.add(btn1);
		rpanel.add(lab4);
		 rpanel.add(lab1);
		 rpanel.add(mName);
		
		rpanel.add(lab2);
		rpanel.add(lab3);
		rpanel.add(mID);
		rpanel.add(lab0);
		rpanel.add(mCount);
		rpanel.add(mLimit);
		rpanel.add(lab5);
		rpanel.add(lab6);
		rpanel.setBounds(0, 0, 565, 420);
		lpanel8.add(rpanel);
		lpanel8.add(cpanel);
		//rpanel.add(cpanel);///////////////////////////////////
		 btns.setBounds(100, 0, 30, 30);
		 btns.addActionListener(sc);
		/////////////////////////////////////////////
		
		
		
		
		lmpanel.add(lpanel,BorderLayout.CENTER);
		lmpanel.add(lpanel2,BorderLayout.SOUTH);
		lmpanel.setBounds(0, 0, 600, 740);
		lpanel8.setBounds(605, 0, 600, 740);
		mpanel.add(lmpanel);
		mpanel.add(lpanel8);
		
		
		
		t_2.add("회원 정보",mpanel); 
		t_2.setFont( new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 18) );
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		cho1 = cho.getSelectedItem();
		if(cho.getSelectedItem().equals("일반")) {
			mMax.setText("3");
			mCount.setText("0");//대여횟수
			mLimit.setText("1");//대출가능권수
		}else if (cho.getSelectedItem().equals("고급")) {
			mMax.setText("4");
			mCount.setText("0");//대여횟수
			mLimit.setText("2");//대출가능권수
		}else if (cho.getSelectedItem().equals("VIP")) {
			mMax.setText("7");
			mCount.setText("0");//대여횟수
			mLimit.setText("3");//대출가능권수
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		//회원생성버튼
		if( cmd.equals(btn1.getText())) {
			 if(mName.getText().equals("")) {
					MDialog md = new MDialog(SwingProject.frame, "에러", true, "회원 이름을 입력하세요"	);
					md.setVisible(true);
			 }else if(cho.getSelectedItem().equals("등급 선택")) {
				MDialog md2 = new MDialog(SwingProject.frame,"에러", true, "등급을 선택하세요.");
				md2.setVisible(true);
			}else if(mPhone.getText().equals("")) {
				MDialog md1 = new MDialog(SwingProject.frame, "에러", true, "전화번호를 입력하세요.");
				md1.setVisible(true);
			}else {//tf를 다 채워서 생성버튼을 눌렀다면 (정상작동 인서트메소드)
				//코드 변경된 곳(회원 인서트 쿼리 수행)********************************
				int maxrental = Integer.parseInt(mMax.getText());
				int ecount = Integer.parseInt(mCount.getText());
				int mlimit = Integer.parseInt(mLimit.getText());
				mgr = new BMEMBERSMgr();
				BMEMBERSBean bean = new BMEMBERSBean();
				String s = cho.getSelectedItem(); //회원등급은 초이스에서 가져오니 스트링에 담아서
				bean.setMNAME(mName.getText());
				bean.setMPHONE(mPhone.getText());
				bean.setMGRADE(s);
				bean.setMAXRENTAL(maxrental);
				bean.setECOUNT(ecount);
				bean.setELIMIT(mlimit);
			if(	mgr.insertBMEMBERS(bean)) {
				
				lpanel.removeAll();
				lpanel.revalidate();
				vlist.removeAllElements();
				viewmember();
				
				SwingProject.p.removeAll();
				SwingProject.p.revalidate();
				SwingProject.vlist.removeAllElements();
				SwingProject.memlist();
			}
			}//////////////////////////////////////////////////////////////////////
		
		}else if (cmd.equals(btn2.getText())) {//회원수정버튼일 때***
			if(cho.getSelectedItem().equals("등급 선택")){
				MDialog md2 = new MDialog(SwingProject.frame,"에러", true, "등급을 선택하세요.");
				md2.setVisible(true);
			}else {
			mgr = new BMEMBERSMgr();
			BMEMBERSBean bean = new BMEMBERSBean();
			int i = Integer.parseInt(mID.getText());
			int maxrental = Integer.parseInt(mMax.getText());
			int ecount = Integer.parseInt(mCount.getText());
			int mlimit = Integer.parseInt(mLimit.getText());
			String s1 = cho.getSelectedItem();
			//아이디 일치하는데 수정이 안돼요
			//해결함. 업데이트메소드에 7번째 값 getIdx여서 안됐던 것.
			//삭제는 idx 되는데 수정은 왜 MID? 공부
			bean.setMID(i);									//id는 mid의 정수변환값
			bean.setMNAME(mName.getText());	
			bean.setMPHONE(mPhone.getText());
			bean.setMGRADE(s1);							//grade는 cho의 선택된값
			bean.setMAXRENTAL(maxrental);
			bean.setECOUNT(ecount);
			bean.setELIMIT(mlimit);
			if(mgr.updateBMEMBERS(bean)) {;
			
			lpanel.removeAll();
			lpanel.revalidate();   //회원관리탭 새로고침 
			vlist.removeAllElements();
			viewmember();
			
			SwingProject.p.removeAll();    //대여패널 회원창 새로고침 
			SwingProject.p.revalidate();
			SwingProject.vlist.removeAllElements();
			SwingProject.memlist();
			
			MDialog md2 = new MDialog(SwingProject.frame,"수정", true, "수정 되었습니다.");
			md2.setVisible(true);
			}}
		}else if (cmd.equals(btn3.getText())) {//회원삭제버튼일 때***
			mgr = new BMEMBERSMgr();
			BMEMBERSBean bean = new BMEMBERSBean();
			String s = mID.getText();
			int i = Integer.parseInt(s);
			bean.setMID(i);
			mgr.deleteBMEMBERS(i);
			lpanel.removeAll();
			lpanel.revalidate();
			vlist.removeAllElements();
			viewmember();
			MDialog md2 = new MDialog(SwingProject.frame,"삭제", true, "삭제되었습니다.");
			md2.setVisible(true);
			
			SwingProject.p.removeAll();
			SwingProject.p.revalidate();
			SwingProject.vlist.removeAllElements();
			SwingProject.memlist();
		}
		
	}
	
	
	//테이블 전용 리스너*******************************************
	static MouseListener selectRow = new MouseListener() {
		@Override
		public void mouseClicked(MouseEvent arg0) {
			String str0 = (String) table7.getValueAt(table7.getSelectedRow(),0);            
			String str1 = (String) table7.getValueAt(table7.getSelectedRow(),1);            
			String str2 = (String) table7.getValueAt(table7.getSelectedRow(),2);
			String str3 = (String) table7.getValueAt(table7.getSelectedRow(),3);
			String str4 = (String) table7.getValueAt(table7.getSelectedRow(),4);
			String str5 = (String) table7.getValueAt(table7.getSelectedRow(),5);
			String str6 = (String) table7.getValueAt(table7.getSelectedRow(),6);
			
			mID.setText(str0);
			mName.setText(str1);
			cho.select(str2);
			mPhone.setText(str3);
			mMax.setText(str4);
			mCount.setText(str5);
			mLimit.setText(str6);
		}
		@Override
		public void mouseEntered(MouseEvent arg0) {}
		@Override
		public void mouseExited(MouseEvent arg0) {}
		@Override
		public void mousePressed(MouseEvent arg0) {}
		@Override
		public void mouseReleased(MouseEvent arg0) {}
		};
	
	MouseListener button = new MouseListener() {//마우스 색 바꾸기
	@Override             
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if(obj.equals(btn1)) {
			btn1.setBackground(Color.gray);
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		JButton btn1 = (JButton)e.getSource();
		if(obj.equals(btn1))btn1.setBackground(Color.gray);
	}
	 @Override
	    public void mouseExited(MouseEvent e) {
		 	Object obj = e.getSource();
			JButton btn1 = (JButton)e.getSource();
	        if(obj.equals(btn1))btn1.setBackground(new  Color(170,220,255));   
	 }
	
	};

	static ActionListener sc = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			new SwingProject_MemberScanner2();
			
		}
	};
MouseListener send = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			sbtn.setIcon(changeicon6);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			sbtn.setIcon(changeicon7);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			sbtn.setIcon(changeicon5);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			sbtn.setIcon(changeicon6);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
		}
	}; 
}
