package JAVAP;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

//이용현황
public class SwingProject_state {
	ImageIcon normalIcon = new ImageIcon("C:\\\\\\\\image\\\\send.jpg"); 
	ImageIcon normalIcon3 = new ImageIcon("C:\\\\\\\\image\\\\sned3.jpg"); 
	 static  JButton cbtn ;
	 Image btnimg = normalIcon.getImage(); 
	 Image btnimg3 = normalIcon3.getImage(); 
	 //버튼에 이미지 추가
	  Image change = btnimg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	  ImageIcon changeicon = new ImageIcon(change);
	  
	  Image change1 = btnimg.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
	  ImageIcon changeicon1= new ImageIcon(change1);
	  
	  Image change3 = btnimg3.getScaledInstance(40, 40, Image.SCALE_SMOOTH);
	  ImageIcon changeicon3= new ImageIcon(change3);
		//sbtn.setBorderPainted(false);			
		//sbtn.setFocusPainted(false);
		//sbtn.setContentAreaFilled(false);
	  /////////////////////////////////////////////////////////////////////////
	  ImageIcon normalIcon7 = new ImageIcon("C:\\\\\\\\image\\\\search.jpg"); 
		ImageIcon normalIcon8 = new ImageIcon("C:\\\\\\\\image\\\\search2.jpg"); 
		 static  JButton sbtn ;
		 Image btnimg7 = normalIcon7.getImage(); 
		 Image btnimg8 = normalIcon8.getImage(); 
		 //버튼에 이미지 추가
		  Image change7 = btnimg7.getScaledInstance(80, 40, Image.SCALE_SMOOTH);
		  ImageIcon changeicon7 = new ImageIcon(change7);
		  
		  Image change8 = btnimg7.getScaledInstance(90, 45, Image.SCALE_SMOOTH);
		  ImageIcon changeicon8= new ImageIcon(change8);
		  
		  Image change9 = btnimg8.getScaledInstance(80, 40, Image.SCALE_SMOOTH);
		  ImageIcon changeicon9= new ImageIcon(change9);
	//////////////////////////////////////////////////////////////////////////////	
		  ImageIcon normalIcon11 = new ImageIcon("C:\\\\\\\\image\\\\end.jpg"); 
			ImageIcon normalIcon12 = new ImageIcon("C:\\\\\\\\image\\\\end2.jpg"); 
			 static  JButton ebtn ;
			 Image btnimg11 = normalIcon11.getImage(); 
			 Image btnimg12 = normalIcon12.getImage(); 
			 //버튼에 이미지 추가
			  Image change11 = btnimg11.getScaledInstance(80, 40, Image.SCALE_SMOOTH);
			  ImageIcon changeicon11 = new ImageIcon(change11);
			  
			  Image change12 = btnimg11.getScaledInstance(90, 45, Image.SCALE_SMOOTH);
			  ImageIcon changeicon12= new ImageIcon(change12);
			  
			  Image change13 = btnimg12.getScaledInstance(80, 40, Image.SCALE_SMOOTH);
			  ImageIcon changeicon13= new ImageIcon(change13);
			  ////////////////////////////////////////////////////////////////////////////////////
			  ImageIcon normalIcon55 = new ImageIcon("C:\\\\\\\\image\\\\reset.jpg"); 
				ImageIcon normalIcon66 = new ImageIcon("C:\\\\\\\\image\\\\reset2.jpg"); 
				 static  JButton rbtn ;
				 Image btnimg55 = normalIcon55.getImage(); 
				 Image btnimg66 = normalIcon66.getImage(); 
				 //버튼에 이미지 추가
				  Image change55 = btnimg55.getScaledInstance(80, 40, Image.SCALE_SMOOTH);
				  ImageIcon changeicon55 = new ImageIcon(change55);
				  
				  Image change66 = btnimg55.getScaledInstance(90, 45, Image.SCALE_SMOOTH);
				  ImageIcon changeicon66= new ImageIcon(change66);
				  
				  Image change77 = btnimg66.getScaledInstance(80, 40, Image.SCALE_SMOOTH);
				  ImageIcon changeicon77= new ImageIcon(change77);
				  ///////////////////////////////////////////////////////////////////////////////
	static String col[] = {"대출번호","회원번호","회원 이름","도서 번호","도서 이름","대출 날짜","반납 날짜"};
	static String row1 [][];
	JPanel npanel = new JPanel();
	static JPanel mpanel = new JPanel();
	static JPanel tpanel = new JPanel();
	
	static JPanel cpanel=new JPanel();
	static JTextField ctf = new JTextField("",50);
	static JTextArea cta = new JTextArea();
	static JScrollPane chatScroll ;
	
	static JTable table;                             //테이블에 필요한 클래스
	static DefaultTableModel model;
	static JScrollPane scr;
	static DefaultTableModel m;
	
	Choice cho = new Choice();
	JTextField tf = new JTextField(10);
	 
	
	static BMEMBERSMgr bmgr = new BMEMBERSMgr();
	static  BrentalMgr  mgr= new BrentalMgr();
	 static    Vector <BrentalBean>  vlist ;
	BooksMgr mgr1 = new BooksMgr();
	BooksMgr mgr12 = new BooksMgr();
	
	static Color red = new Color(255,207,253);
	static Color bg = new Color(186,218,255);
	//new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 20) );
	
	JLabel time = new JLabel();
	
	static SimpleDateFormat sysdate = new SimpleDateFormat();
	static Calendar date = Calendar.getInstance();
	static String date2 = sysdate.format(date.getTime()); //문자열에 오늘날짜 대입 
	
	
	
	
	
	//테이블을 보여주는 메소드
	public static void viewstate() {
		
		
		vlist = mgr.getListBRental();
		row1 = new String [vlist.size()][7];
		for (int i = 0; i < row1.length; i++) {
			BrentalBean bean = vlist.elementAt(i);
			row1[i][0] = bean.getRID()+"";
			row1[i][1] = bean.getRMID()+"";
			row1[i][2] = bean.getRNAME();
			row1[i][3] = bean.getBMID()+"";
			row1[i][4] = bean.getBTITLE();
			row1[i][5] = bean.getRENTAL().substring(0, 10);  //날짜 일까지만 보이게하기 
			row1[i][6] = bean.getENDRENTAL().substring(0, 10);
		}
		DefaultTableModel model = new DefaultTableModel(row1, col) {

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
	                    	   //오늘 날짜데이터에서 필요한 년,월,일 만 가져오기 
	                    	   int yy = Integer.parseInt(date2.substring(0,2));   
	                    		int mm = Integer.parseInt(date2.substring(4,6));
	                    		int dd = Integer.parseInt(date2.substring(8,10));
	                    		//현재날짜와 반납날짜를 연산할 객체 생성 
	                    		Calendar date7 = Calendar.getInstance();
	                    		Calendar date8 = Calendar.getInstance();
	                    		//반납테이블의 6번쨰컬럼에있는 모든 행을 스트링 aaa에 담기 
	                    	   String aaa = (String)getModel().getValueAt(row,6) ;
	                    	   //반납테이블의 년월일 정수형으로 추출하기 
	                    	   int yy2 = Integer.parseInt(aaa.substring(0,4));   
	                    		int mm2 = Integer.parseInt(aaa.substring(5,7));
	                    		int dd2= Integer.parseInt(aaa.substring(8,10));
	                    		//객체 초기화
	                    	   	date7.clear();
	                   			date8.clear();
	                   			//연산할 객체에 각각 오늘날짜,반납날짜 담기
	                   			date7.set(2000+yy,mm,dd);
	                   			date8.set(yy2,mm2,dd2);
	                   			//롱 데이터형에 오늘날짜와 반납날짜를 1/1000초로 분해하여 연산
	                   			//하고 다시 20*60*60*1000으로 나누어 몇일차이 인지 계산하기
	                   		long ttt=	(date7.getTimeInMillis()-date8.getTimeInMillis())/(24*60*60*1000);
	                    	   //만약 오늘날짜 - 반납날짜가 0이상이라면 반납일이 지났고
	                   		//만약 오늘날짜 - 반납날짜가 0보다 작다면 반납일이 지나지 않았다.
	                   		//만약 오늘날짜 -반납날짜가 0이라면 오늘이 반납일 이다
	                         if (ttt<=0) {
	                              c.setBackground(Color.white);
	                           }
	                           if (ttt>0) {
	                              c.setBackground(red);
	                         }
	                       }
	                   }
	                   return c;
	               }
	           };
		
		
		
		//model = new DefaultTableModel(row1,col);   //추가 삭제 수정이 간편한 DefaultTableModel 생성
		//table = new JTable(model);         //테이블에 테이블모델 입히기
		scr = new JScrollPane(table); 	//스크롤 생성
		 table.getColumnModel().getColumn(0).setPreferredWidth(90);  //JTable 의 컬럼 길이 조절
		    table.getColumnModel().getColumn(1).setPreferredWidth(90);
		    table.getColumnModel().getColumn(2).setPreferredWidth(110);
		    table.getColumnModel().getColumn(3).setPreferredWidth(90);
		    table.getColumnModel().getColumn(4).setPreferredWidth(400);
		    table.getColumnModel().getColumn(5).setPreferredWidth(200);
		    table.getColumnModel().getColumn(6).setPreferredWidth(200);
		    table.setFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 20) );
		    JTableHeader header = table.getTableHeader();            //테이블 헤더 색상 
		    header.setBackground(new  Color(170,220,255));
		    table.setRowHeight(30);
		    scr.setBounds(0, 0, 1175, 300);
			tpanel.removeAll();
			tpanel.revalidate();
		    tpanel.add(scr);
		
	}
	
         public SwingProject_state() {
        	 viewstate();

     		cbtn = new JButton(changeicon);
     		sbtn = new JButton(changeicon7);
     		ebtn = new JButton(changeicon11);
     		rbtn = new JButton(changeicon55);
     		
        	 mpanel.setBackground(bg);
        	 npanel.setBackground(bg);
        	 tpanel.setBackground(bg);
        	 cpanel.setBackground(bg);
             npanel.setLayout(null);
             mpanel.setLayout(null);
             cpanel.setLayout(null);
             tpanel.setLayout(null);
             time.setText("오늘 날짜  :  "+date2.substring(0,10)); 
             time.setFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 20) );
         	TitledBorder jtx=          //검색창 보더
    	    		new TitledBorder(new LineBorder(Color.white,5),"검색");
    		 jtx.setTitleFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 18) );
    	     
    		 TitledBorder jtx1=                       
 		    		new TitledBorder(new LineBorder(Color.white,5),"회원과의 채팅");
 		       jtx1.setTitleFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 18) );
     		 cpanel.setBorder(jtx1);
     		// cpanel.setBackground(SwingProject.bg);
    		 cho.add("대출 번호");
    		 cho.add("회원 번호");
    		 cho.add("도서 번호");
    		 cho.setBounds(250, 50, 150, 50);
    		 tf.setBounds(430,50 , 150, 27);
    		 rbtn.setBounds(1030, 60, 90, 45);
    		 ebtn.setBounds(900, 60, 90, 45);
    		 time.setBounds(900,20,270,50);
    		 
    		sbtn.setBounds(590, 43, 90,45);
    	     sbtn.addActionListener(ac);
    	     sbtn.addMouseListener(sm);
    	     rbtn.addMouseListener(reset);
    	     ChatAction ca = new ChatAction();
    	     chatScroll = new JScrollPane(cta);
    	 cpanel.setBounds(600, 430, 570,260);
    	 cpanel.add(chatScroll);
    	 cpanel.add(ctf);
    	 cpanel.add(cbtn);
    	 ctf.addActionListener(ca.acc);
    	 cbtn.addActionListener(ca.acc);
    	 chatScroll.setBounds(20, 30, 530, 180);
    	 ctf.setBounds(20, 220, 450, 30);
    	 cbtn.setBounds(470, 220, 80, 30);
    	 
    	 cbtn.addMouseListener(send);
    	 cbtn.setBorderPainted(false);
			cbtn.setFocusPainted(false);
			cbtn.setContentAreaFilled(false);
		
		sbtn.setBorderPainted(false);			
		sbtn.setFocusPainted(false);
		sbtn.setContentAreaFilled(false);
		
		 ebtn.addMouseListener(end);
	     ebtn.setBorderPainted(false);
			ebtn.setFocusPainted(false);
			ebtn.setContentAreaFilled(false);
		rbtn.setBorderPainted(false);
		rbtn.setFocusPainted(false);
		rbtn.setContentAreaFilled(false);
    	 tpanel.setBounds(0, 120, 1175, 300);
    	 cta.setEnabled(false);
    	 npanel.add(tf);
    	 npanel.add(sbtn);
    	 npanel.add(cho);
    	 npanel.add(rbtn);
    	 npanel.add(ebtn);
    	 npanel.add(time);
    	 rbtn.addActionListener(re);
    	 ebtn.addActionListener(de);
    	 npanel.setBounds(0, 0, 1175, 120);
    	 scr.setBounds(0, 0, 1175, 300);
    	 npanel.setBorder(jtx);
    	 mpanel.add(npanel);
    	 mpanel.add(cpanel);
    	 mpanel.add(tpanel);
    	 npanel.setPreferredSize(new Dimension(1200,120));	 
            	 
          }
         
         ActionListener ac = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {      //대출번호로 가져오기 (하나만)
				if(cho.getSelectedIndex()==0) {
					if(tf.getText().equals("")) {
						MDialog md = new MDialog(SwingProject.frame,	"오류", true,"검색어가 없습니다.");
						md.setVisible(true);
					}else {
					int RID = Integer.parseInt(tf.getText());
					
					String row1[][] = new String [1][7];
					for (int i = 0; i < row1.length; i++) {
						BrentalBean bean = mgr.getett(RID);
						row1[i][0] = bean.getRID()+"";
						row1[i][1] = bean.getRMID()+"";
						row1[i][2] = bean.getRNAME();
						row1[i][3] = bean.getBMID()+"";
						row1[i][4] = bean.getBTITLE();
						if(row1[i][0].equals("0")) {  // 검색내용이 없으면 날짜형식 그대로 가져오기 (잘라서 가져오면 오류남)
							row1[i][5] = bean.getRENTAL();
							row1[i][6] = bean.getENDRENTAL();
						}else {
						row1[i][5] = bean.getRENTAL().substring(0,10);  //검색내용 있으면 잘라서 보기편하게 가져오기
						row1[i][6] = bean.getENDRENTAL().substring(0,10);
						}
						DefaultTableModel model = new DefaultTableModel(row1, col) {

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
					                    	   //오늘 날짜데이터에서 필요한 년,월,일 만 가져오기 
					                    	   int yy = Integer.parseInt(date2.substring(0,2));   
					                    		int mm = Integer.parseInt(date2.substring(4,6));
					                    		int dd = Integer.parseInt(date2.substring(8,10));
					                    		//현재날짜와 반납날짜를 연산할 객체 생성 
					                    		Calendar date7 = Calendar.getInstance();
					                    		Calendar date8 = Calendar.getInstance();
					                    		//반납테이블의 6번쨰컬럼에있는 모든 행을 스트링 aaa에 담기 
					                    	   String aaa = (String)getModel().getValueAt(row,6) ;
					                    	   //반납테이블의 년월일 정수형으로 추출하기 
					                    	   int yy2 = Integer.parseInt(aaa.substring(0,4));   
					                    		int mm2 = Integer.parseInt(aaa.substring(5,7));
					                    		int dd2= Integer.parseInt(aaa.substring(8,10));
					                    		//객체 초기화
					                    	   	date7.clear();
					                   			date8.clear();
					                   			//연산할 객체에 각각 오늘날짜,반납날짜 담기
					                   			date7.set(2000+yy,mm,dd);
					                   			date8.set(yy2,mm2,dd2);
					                   			//롱 데이터형에 오늘날짜와 반납날짜를 1/1000초로 분해하여 연산
					                   			//하고 다시 20*60*60*1000으로 나누어 몇일차이 인지 계산하기
					                   		long ttt=	(date7.getTimeInMillis()-date8.getTimeInMillis())/(24*60*60*1000);
					                    	   //만약 오늘날짜 - 반납날짜가 0이상이라면 반납일이 지났고
					                   		//만약 오늘날짜 - 반납날짜가 0보다 작다면 반납일이 지나지 않았다.
					                   		//만약 오늘날짜 -반납날짜가 0이라면 오늘이 반납일 이다
					                         if (ttt<=0) {
					                              c.setBackground(Color.white);
					                           }
					                           if (ttt>0) {
					                              c.setBackground(red);
					                         }
					                       }
					                   }
					                   return c;
					               }
					           };
						
						
						
						//model = new DefaultTableModel(row1,col);   //추가 삭제 수정이 간편한 DefaultTableModel 생성
						//table = new JTable(model);         //테이블에 테이블모델 입히기
						scr = new JScrollPane(table); 	//스크롤 생성
						 table.getColumnModel().getColumn(0).setPreferredWidth(90);  //JTable 의 컬럼 길이 조절
						    table.getColumnModel().getColumn(1).setPreferredWidth(90);
						    table.getColumnModel().getColumn(2).setPreferredWidth(110);
						    table.getColumnModel().getColumn(3).setPreferredWidth(90);
						    table.getColumnModel().getColumn(4).setPreferredWidth(400);
						    table.getColumnModel().getColumn(5).setPreferredWidth(200);
						    table.getColumnModel().getColumn(6).setPreferredWidth(200);
						    table.setFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 20) );
						    
						    JTableHeader header = table.getTableHeader();            //테이블 헤더 색상 
						    header.setBackground(new  Color(170,220,255));
						    table.setRowHeight(30);
						    scr.setBounds(0, 0, 1175, 300);
							tpanel.removeAll();
							tpanel.revalidate();
						    tpanel.add(scr);}
						
					}
					 if(table.getValueAt(0, 0).equals("0")) {
						 MDialog md = new MDialog(SwingProject.frame,	"오류", true,"검색내용이 없습니다.");
					md.setVisible(true);
					 }
				}else if(cho.getSelectedIndex()==1) {  //(회원번호로 가져오기 다수)
					int RMID = Integer.parseInt(tf.getText());
					vlist = mgr.getett2(RMID);
					
					String row1[][] = new String [vlist.size()][7];
					for (int i = 0; i < row1.length; i++) {
						BrentalBean bean = vlist.elementAt(i);
						row1[i][0] = bean.getRID()+"";
						row1[i][1] = bean.getRMID()+"";
						row1[i][2] = bean.getRNAME();
						row1[i][3] = bean.getBMID()+"";
						row1[i][4] = bean.getBTITLE();
						if(row1[i][0].equals("0")) {  // 검색내용이 없으면 날짜형식 그대로 가져오기 (잘라서 가져오면 오류남)
							row1[i][5] = bean.getRENTAL();
							row1[i][6] = bean.getENDRENTAL();
						}else {
						row1[i][5] = bean.getRENTAL().substring(0,10);  //검색내용 있으면 잘라서 보기편하게 가져오기
						row1[i][6] = bean.getENDRENTAL().substring(0,10);
						}
						DefaultTableModel model = new DefaultTableModel(row1, col) {

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
					                    	   //오늘 날짜데이터에서 필요한 년,월,일 만 가져오기 
					                    	   int yy = Integer.parseInt(date2.substring(0,2));   
					                    		int mm = Integer.parseInt(date2.substring(4,6));
					                    		int dd = Integer.parseInt(date2.substring(8,10));
					                    		//현재날짜와 반납날짜를 연산할 객체 생성 
					                    		Calendar date7 = Calendar.getInstance();
					                    		Calendar date8 = Calendar.getInstance();
					                    		//반납테이블의 6번쨰컬럼에있는 모든 행을 스트링 aaa에 담기 
					                    	   String aaa = (String)getModel().getValueAt(row,6) ;
					                    	   //반납테이블의 년월일 정수형으로 추출하기 
					                    	   int yy2 = Integer.parseInt(aaa.substring(0,4));   
					                    		int mm2 = Integer.parseInt(aaa.substring(5,7));
					                    		int dd2= Integer.parseInt(aaa.substring(8,10));
					                    		//객체 초기화
					                    	   	date7.clear();
					                   			date8.clear();
					                   			//연산할 객체에 각각 오늘날짜,반납날짜 담기
					                   			date7.set(2000+yy,mm,dd);
					                   			date8.set(yy2,mm2,dd2);
					                   			//롱 데이터형에 오늘날짜와 반납날짜를 1/1000초로 분해하여 연산
					                   			//하고 다시 20*60*60*1000으로 나누어 몇일차이 인지 계산하기
					                   		long ttt=	(date7.getTimeInMillis()-date8.getTimeInMillis())/(24*60*60*1000);
					                    	   //만약 오늘날짜 - 반납날짜가 0이상이라면 반납일이 지났고
					                   		//만약 오늘날짜 - 반납날짜가 0보다 작다면 반납일이 지나지 않았다.
					                   		//만약 오늘날짜 -반납날짜가 0이라면 오늘이 반납일 이다
					                         if (ttt<=0) {
					                              c.setBackground(Color.white);
					                           }
					                           if (ttt>0) {
					                              c.setBackground(red);
					                         }
					                       }
					                   }
					                   return c;
					               }
					           };
						
						
						
						//model = new DefaultTableModel(row1,col);   //추가 삭제 수정이 간편한 DefaultTableModel 생성
						//table = new JTable(model);         //테이블에 테이블모델 입히기
						scr = new JScrollPane(table); 	//스크롤 생성
						 table.getColumnModel().getColumn(0).setPreferredWidth(90);  //JTable 의 컬럼 길이 조절
						    table.getColumnModel().getColumn(1).setPreferredWidth(90);
						    table.getColumnModel().getColumn(2).setPreferredWidth(110);
						    table.getColumnModel().getColumn(3).setPreferredWidth(90);
						    table.getColumnModel().getColumn(4).setPreferredWidth(400);
						    table.getColumnModel().getColumn(5).setPreferredWidth(200);
						    table.getColumnModel().getColumn(6).setPreferredWidth(200);
						    table.setFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 20) );
						    JTableHeader header = table.getTableHeader();            //테이블 헤더 색상 
						    header.setBackground(new  Color(170,220,255));
						    table.setRowHeight(30);
						    scr.setBounds(0, 0, 1175, 300);
							tpanel.removeAll();
							tpanel.revalidate();
						    tpanel.add(scr);
						
					}
					 
					 
					 
					 if(table.getRowCount()==0) {
						 MDialog md = new MDialog(SwingProject.frame,	"오류", true,"검색내용이 없습니다.");
					md.setVisible(true);
				}
				
				}else if (cho.getSelectedIndex()==2) {
					int BMID = Integer.parseInt(tf.getText()); //검색하기 
					
					String row1[][] = new String [1][7];
					for (int i = 0; i < row1.length; i++) {
						BrentalBean bean = mgr.getett3(BMID);
						row1[i][0] = bean.getRID()+"";
						row1[i][1] = bean.getRMID()+"";
						row1[i][2] = bean.getRNAME();
						row1[i][3] = bean.getBMID()+"";
						row1[i][4] = bean.getBTITLE();
						if(row1[i][0].equals("0")) {  // 검색내용이 없으면 날짜형식 그대로 가져오기 (잘라서 가져오면 오류남)
							row1[i][5] = bean.getRENTAL();
							row1[i][6] = bean.getENDRENTAL();
						}else {
						row1[i][5] = bean.getRENTAL().substring(0,10);  //검색내용 있으면 잘라서 보기편하게 가져오기
						row1[i][6] = bean.getENDRENTAL().substring(0,10);
						}
					
					DefaultTableModel model = new DefaultTableModel(row1, col) {

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
				                    	   //오늘 날짜데이터에서 필요한 년,월,일 만 가져오기 
				                    	   int yy = Integer.parseInt(date2.substring(0,2));   
				                    		int mm = Integer.parseInt(date2.substring(4,6));
				                    		int dd = Integer.parseInt(date2.substring(8,10));
				                    		//현재날짜와 반납날짜를 연산할 객체 생성 
				                    		Calendar date7 = Calendar.getInstance();
				                    		Calendar date8 = Calendar.getInstance();
				                    		//반납테이블의 6번쨰컬럼에있는 모든 행을 스트링 aaa에 담기 
				                    	   String aaa = (String)getModel().getValueAt(row,6) ;
				                    	   //반납테이블의 년월일 정수형으로 추출하기 
				                    	   int yy2 = Integer.parseInt(aaa.substring(0,4));   
				                    		int mm2 = Integer.parseInt(aaa.substring(5,7));
				                    		int dd2= Integer.parseInt(aaa.substring(8,10));
				                    		//객체 초기화
				                    	   	date7.clear();
				                   			date8.clear();
				                   			//연산할 객체에 각각 오늘날짜,반납날짜 담기
				                   			date7.set(2000+yy,mm,dd);
				                   			date8.set(yy2,mm2,dd2);
				                   			//롱 데이터형에 오늘날짜와 반납날짜를 1/1000초로 분해하여 연산
				                   			//하고 다시 20*60*60*1000으로 나누어 몇일차이 인지 계산하기
				                   		long ttt=	(date7.getTimeInMillis()-date8.getTimeInMillis())/(24*60*60*1000);
				                    	   //만약 오늘날짜 - 반납날짜가 0이상이라면 반납일이 지났고
				                   		//만약 오늘날짜 - 반납날짜가 0보다 작다면 반납일이 지나지 않았다.
				                   		//만약 오늘날짜 -반납날짜가 0이라면 오늘이 반납일 이다
				                         if (ttt<=0) {
				                              c.setBackground(Color.white);
				                           }
				                           if (ttt>0) {
				                              c.setBackground(red);
				                         }
				                       }
				                   }
				                   return c;
				               }
				           };
					
					
					
					//model = new DefaultTableModel(row1,col);   //추가 삭제 수정이 간편한 DefaultTableModel 생성
					//table = new JTable(model);         //테이블에 테이블모델 입히기
					scr = new JScrollPane(table); 	//스크롤 생성
					 table.getColumnModel().getColumn(0).setPreferredWidth(90);  //JTable 의 컬럼 길이 조절
					    table.getColumnModel().getColumn(1).setPreferredWidth(90);
					    table.getColumnModel().getColumn(2).setPreferredWidth(110);
					    table.getColumnModel().getColumn(3).setPreferredWidth(90);
					    table.getColumnModel().getColumn(4).setPreferredWidth(400);
					    table.getColumnModel().getColumn(5).setPreferredWidth(200);
					    table.getColumnModel().getColumn(6).setPreferredWidth(200);
					    table.setFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 20) );
					    JTableHeader header = table.getTableHeader();            //테이블 헤더 색상 
					    header.setBackground(new  Color(170,220,255));
					    table.setRowHeight(30);
					    scr.setBounds(0, 0, 1175, 300);
						tpanel.removeAll();
						tpanel.revalidate();
					    tpanel.add(scr);
					
				}
					 
					 
					 
					 if(table.getValueAt(0, 0).equals("0")) {
						 MDialog md = new MDialog(SwingProject.frame,	"오류", true,"검색내용이 없습니다.");
					md.setVisible(true);
					 
				}
				}
			}
		};
         ActionListener re = new ActionListener() {  //새로고침 
			
			@Override
			public void actionPerformed(ActionEvent e) {
				viewstate();
			}
		};
         ActionListener de = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(table.getSelectedRow()==-1) {
					MDialog MD = new MDialog(SwingProject.frame, "오류", true, "반납할 도서를 선택하세요");
					MD.setVisible(true);
					}else {
					int to2 = Integer.parseInt((String)(table.getValueAt(table.getSelectedRow(),3)));
					int to  = Integer.parseInt((String)(table.getValueAt(table.getSelectedRow(), 1)));	
						BrentalBean bean = vlist.get(table.getSelectedRow());
					if(mgr.deleterental(bean.getRID())) {
						viewstate();
			          }
					
					
						BMEMBERSBean mbean = bmgr.getett(to);
						int mcount = mbean.getECOUNT();
						int limit = mbean.getELIMIT();
						BMEMBERSBean mbean2 = new BMEMBERSBean();
						mbean2.setMID(to);
						mbean2.setECOUNT(mcount);
						mbean2.setELIMIT(limit+1);
						if(bmgr.stateupdateBMEMBERS(mbean2)) {
							SwingProject.p.removeAll();
							SwingProject.p.revalidate();
							SwingProject.vlist.removeAllElements();
							SwingProject.memlist();
						 
						}
					
					//삭제하는 대출데이터의 도서번호로 대출횟수 가져오기 
					BooksBean bean3 = mgr1.getett(to2);
					int bcount = bean3.getBCOUNT();
					//삭제하는 도서 상태바꾸기,대출횟수는 그대로
					BooksBean bean2 = new BooksBean();
					bean2.setBOOKSTATE("대출가능");
					bean2.setBCOUNT(bcount);
					bean2.setBID(to2);
					if(mgr1.stateupdateBooks(bean2)) {
						SwingProject.p1.removeAll();
						SwingProject.p1.revalidate();
						SwingProject.vlist1.removeAllElements();
						SwingProject.viewList();
					} 
					
					MDialog md = new MDialog(SwingProject.frame, "대출", true, "반납 되었습니다.");
					md.setVisible(true);
					
					
					
		}
				
	}};

	MouseListener send = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			cbtn.setIcon(changeicon1);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			cbtn.setIcon(changeicon3);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			cbtn.setIcon(changeicon);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			cbtn.setIcon(changeicon1);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
		}
	}; 
	MouseListener sm = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			sbtn.setIcon(changeicon8);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			sbtn.setIcon(changeicon9);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			sbtn.setIcon(changeicon7);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			sbtn.setIcon(changeicon8);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
		}
	}; 
MouseListener end = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			ebtn.setIcon(changeicon12);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			ebtn.setIcon(changeicon13);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			ebtn.setIcon(changeicon11);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			ebtn.setIcon(changeicon12);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
		}
	}; 
MouseListener reset = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			rbtn.setIcon(changeicon66);
		}
		@Override
		public void mousePressed(MouseEvent e) {
			rbtn.setIcon(changeicon77);
		}
		@Override
		public void mouseExited(MouseEvent e) {
			rbtn.setIcon(changeicon55);
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			rbtn.setIcon(changeicon66);
		}
		@Override
		public void mouseClicked(MouseEvent e) {
		}
	}; 
		}
