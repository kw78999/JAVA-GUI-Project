package libSearchProgram;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import JAVAP.BookThread;
import libSearchProgram.ParseEx3;

public class VFrame extends JFrame implements MouseListener, ActionListener {

	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
		Image img = icon.getImage();
		Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight, java.awt.Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}// 이미지를 받아서 버튼 사이즈에 맞게 조절해주는 메소드. 아래 int offset과 같이 사용

	ImageIcon iconLike = new ImageIcon("C:\\IMAGE\\like.png");
	String[] col = { "도서명", "저자", "출판사", "좋아요","i"};
	JTextField searchT;// 마우스리스너때문에 클래스의 필드로 선언
						// 생성자에 선언하면??? 스태틱은???
	
	BVOTEMgr mgr = new BVOTEMgr();
	BVOTEBean bean = new BVOTEBean();
	Vector<BVOTEBean> vlist3 = new Vector<BVOTEBean>();
	
	JButton searchBtn, likeBtn;
	String[] s = {"도서 검색","요청 도서"};
	DefaultTableModel model;
	JTable table;
	JTable table2;
	JScrollPane scroll;
	JTextField tf1, tf2, tf3;
	JPanel p1, p3;
	JPanel p2 = new JPanel();
	Font lbfont = new Font("잘풀리는오늘 Medium", Font.PLAIN, 14);
	
	JComboBox<String> comboBox;
	
	void viewBV(){
		vlist3 = mgr.getListVote();
	
		String row[][] = new String[vlist3.size()][5];
		for (int j = 0; j < row.length; j++) {
			bean = vlist3.elementAt(j);
			row[j][0] = bean.getVTITLE();
			row[j][1] = bean.getVAUTHOR();
			row[j][2] = bean.getVPUBLISHER();
			row[j][3] = bean.getVLIKE()+"";
			row[j][4] = bean.getVISBN();
		}
		model = new DefaultTableModel(row, col);

		table = new JTable(model);
		table.setFillsViewportHeight(true);
		table.setShowVerticalLines(false);// 가로 선 제거
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 단일행 선택
		table.setDefaultEditor(Object.class, null);// 테이블 수정 불가능 (null)//JTable 의 컬럼 길이 조절
		table.getColumnModel().getColumn(0).setPreferredWidth(400);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(1);
		table.setRowHeight(25);
		table.addMouseListener(this);
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer); // table.set
		scroll = new JScrollPane(table);
		scroll.setBounds(10, 30, 740, 240);
		p2.removeAll();
		p2.add(scroll);
		
		
	}
	
	
	public VFrame() {
		
		TitledBorder tB1 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2, true), "미보유 도서 검색");
		tB1.setTitleFont(new Font("잘풀리는오늘 Medium", Font.PLAIN, 12));

		TitledBorder tB2 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2, true), "검색 결과");
		tB2.setTitleFont(new Font("잘풀리는오늘 Medium", Font.PLAIN, 18));

		TitledBorder tB3 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2, true), "도서 신청");
		tB3.setTitleFont(new Font("잘풀리는오늘 Medium", Font.PLAIN, 18));

		
		Font lbfont2 = new Font("잘풀리는오늘 Medium", Font.PLAIN, 16);
		Font comboFont = new Font("잘풀리는오늘 Medium", Font.PLAIN, 12 );
		
		comboBox = new JComboBox<>(s);
		comboBox.setBounds(400, 30, 100, 25);
		comboBox.setFont(comboFont);
		comboBox.setBackground(Color.white);
		comboBox.addActionListener(com);
		setTitle("도서 요청");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 560);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);

		////////////////////////////////////////////////
		// 검색테이블패널
		ImageIcon iconSearch = new ImageIcon("C:\\IMAGE\\searchIcon.png");

		p1 = new JPanel();
		// p1.setBorder(tB1);
		p1.setLayout(null);
		p1.setBounds(0, 0, 780, 80);
		p1.setBackground(Color.WHITE);
		SearchPanel05 p5 = new SearchPanel05();

		String s = p5.name;
		String s1 = p5.testInputName;
		JTextArea ta = new JTextArea(s + "님 반갑습니다.\n" + "찾으시는 도서명을 검색해서 투표해주세요.");
		ta.setEditable(false);
		ta.setBounds(130, 20, 250, 32);
		ta.setFont(lbfont);

		searchT = new JTextField("도서명을 입력하세요.");
		searchT.setBounds(500, 30, 150, 26);
		searchT.addMouseListener(this);

		searchBtn = new JButton(iconSearch);
		searchBtn.setBounds(650, 30, 27, 25);
		searchBtn.setContentAreaFilled(false);
		searchBtn.addActionListener(this);
		p1.add(searchBtn);
		p1.add(ta);
		p1.add(searchT);
		p1.add(comboBox);
		////////////////////////////////////////////////
		// 목록테이블패널
		
		p2.setBorder(tB2);
		p2.setLayout(null);
		p2.setBounds(0, 80, 780, 280);
		p2.setBackground(Color.WHITE);
		
		String[] col = { "도서명", "저자", "출판사", "좋아요","i"};
		/*
		 * Object[][] data = { {"죄와 벌 (하)", "도스토예프스키", "민음사", "97표"}, {"예언자", "칼릴 지브란",
		 * "책과 세상", "67표"}, {"일찍 일어나는 새는 단명한다", "천행운", "행운", "17표"} };
		 */
		Object[][] row[][] = {};
		model = new DefaultTableModel(row, col);

		table = new JTable(model);
		table.setFillsViewportHeight(true);
		table.setShowVerticalLines(false);// 가로 선 제거
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 단일행 선택
		table.setDefaultEditor(Object.class, null);// 테이블 수정 불가능 (null)//JTable 의 컬럼 길이 조절
		table.getColumnModel().getColumn(0).setPreferredWidth(400);
		table.getColumnModel().getColumn(1).setPreferredWidth(250);
		table.getColumnModel().getColumn(2).setPreferredWidth(150);
		table.getColumnModel().getColumn(3).setPreferredWidth(100);
		table.getColumnModel().getColumn(4).setPreferredWidth(1);
		table.setRowHeight(25);
		table.addMouseListener(this);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		table.setDefaultRenderer(Object.class, centerRenderer); // table.set
		scroll = new JScrollPane(table);
		scroll.setBounds(10, 30, 740, 240);
		p2.add(scroll);
		////////////////////////////////////////////////
		// 투표패널
		p3 = new JPanel();
		p3.setBorder(tB3);
		p3.setLayout(null);
		p3.setBounds(0, 360, 780, 160);
		p3.setBackground(Color.WHITE);

		int lbX = 50;

		JLabel lb1, lb2, lb3;
		lb1 = new JLabel("도서명");
		lb1.setBounds(lbX, 40, 100, 24);
		lb1.setFont(lbfont2);
		tf1 = new JTextField();
		tf1.setBounds(lbX + 50, 40, 300, 24);
		tf1.setBackground(new Color(235, 235, 235));
		tf1.setFont(lbfont2);

		lb2 = new JLabel("저자");
		lb2.setBounds(lbX, 70, 100, 24);
		lb2.setFont(lbfont2);
		tf2 = new JTextField();
		tf2.setBounds(lbX + 50, 70, 300, 24);
		tf2.setBackground(new Color(235, 235, 235));
		tf2.setFont(lbfont2);

		lb3 = new JLabel("출판사");
		lb3.setBounds(lbX, 100, 100, 24);
		lb3.setFont(lbfont2);
		tf3 = new JTextField();
		tf3.setBounds(lbX + 50, 100, 250, 24);
		tf3.setBackground(new Color(235, 235, 235));
		tf3.setFont(lbfont2);

		JPanel p4 = new JPanel();
		p4.setLayout(null);
		p4.setBounds(400, 16, 370, 135);
		p4.setBackground(null);
		JTextArea ta2;
		ta2 = new JTextArea("      찾으시는 도서가 맞다면?\n\n원하는 도서가 출력되지 않는 경우\n아래 프린트 아이콘을 눌러\n양식을 출력해주세요.");
		ta2.setBounds(100, 30, 200, 110);
		ta2.setFont(lbfont);
		ta2.setEditable(false);

		likeBtn = new JButton(iconLike);
		likeBtn.setBounds(280, 10, 52, 46);
		likeBtn.setContentAreaFilled(false);
		likeBtn.setBorderPainted(false);
		likeBtn.setFocusPainted(false);
		likeBtn.addMouseListener(this);

		int offset = likeBtn.getInsets().left; // 버튼 크기 재기
		likeBtn.setIcon(resizeIcon(iconLike, likeBtn.getWidth() - offset, likeBtn.getHeight() - offset)); // 버튼 크기에 맞춰 이미지 삽입

		p4.add(likeBtn);

		p4.add(ta2);
		p3.add(p4);
		p3.add(lb1);
		p3.add(lb2);
		p3.add(lb3);
		p3.add(tf1);
		p3.add(tf2);
		p3.add(tf3);
		add(p1);
		add(p2);
		add(p3);

		setVisible(true);
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		ResetThread.timer =10 ;
		
		
		BooksMgr  mgr2 = new BooksMgr();
		BooksBean bean2 = new BooksBean();
		
		Object obj = e.getSource();
		if (obj.equals(table)&&table.getRowCount()!=0) {//테이블 클릭했는데 테이블의 행 개수가 0이 아닐 때(행이 하나 이상 존재)
			int row = table.getSelectedRow();
			int col = table.getSelectedColumn();
			
			for (int i = 0; i < table.getColumnCount(); i++) {
				String s1 = (String) table.getValueAt(row, 0);
				String s2 = (String) table.getValueAt(row, 1);
				String s3 = (String) table.getValueAt(row, 2);
				tf1.setText(s1);
				tf2.setText(s2);
				tf3.setText(s3);
				tf1.select(0, 0);   //텍스트 왼쪽부터 보여지기 (정렬)
				tf2.select(0, 0);
				tf3.select(0, 0);
			} // --for 패널2 문자 바꾸는 반복문
			
			
		}else if (obj == likeBtn) {
			if(tf1.getText().equals("")) {
				JDialog jd = new JDialog();
				JLabel lb = new JLabel("선택값이 없습니다");
				//JLabel lb2 = new JLabel("<html>도서검색 결과가 없다면<br>사서에게 문의해주세요.</html>");
				JLabel lb3 = new JLabel(new ImageIcon("C:\\IMage\\mask.png"));
				lb.setFont(lbfont);
				//lb2.setFont(lbfont);
				lb.setBounds(40, 20, 260, 20);
			//	lb2.setBounds(40, 120, 260, 20);
				jd.setLayout(new FlowLayout(FlowLayout.CENTER));
				//jd.setTitle(tf1.getText().substring(0,15) + "... 은(는) 보유도서입니다.");
				jd.add(lb);
				jd.add(lb3);
				//jd.add(lb2);
				//jd.setLocationRelativeTo(searchT);
				//jd.setSize(300, 190);
				jd.setBounds(800, 400, 300, 190);
				jd.setVisible(true);
			}else {
				String str1 = tf1.getText();
			
			//AlphaFrame4 alpha = new AlphaFrame4();
			//model.setNumRows(0);
			
			
			
			
			likeBtn.setBounds(280-2, 10-2, 56, 50);
			int offset = likeBtn.getInsets().left; // 버튼 크기 재기
			likeBtn.setIcon(resizeIcon(iconLike, likeBtn.getWidth() - offset, likeBtn.getHeight() - offset));
			System.out.println("좋아요 버튼 기능 만드세요");
			
			String isbn = (String)table.getValueAt(table.getSelectedRow(), 4);
			String title= (String)table.getValueAt(table.getSelectedRow(), 0);
			 if(mgr2.getisbn(isbn)) {
				 
				
				JDialog jd = new JDialog();
				JLabel lb;
				if(str1.length()>10) {
				 lb = new JLabel(tf1.getText().substring(0,10) + "... 은(는) 보유도서입니다.");
				jd.setTitle(tf1.getText().substring(0,10) + "... 은(는) 보유도서입니다.");
				}else {
					lb = new JLabel(tf1.getText() + " 은(는) 보유도서입니다.");
					jd.setTitle(tf1.getText() + " 은(는) 보유도서입니다.");
				}
				JLabel lb2 = new JLabel("<html>도서검색 결과가 없다면<br>사서에게 문의해주세요.</html>");
				JLabel lb3 = new JLabel(new ImageIcon("C:\\IMage\\mask.png"));
				lb.setFont(lbfont);
				lb2.setFont(lbfont);
				lb.setBounds(40, 20, 260, 20);
				lb2.setBounds(40, 120, 260, 20);
				jd.setLayout(new FlowLayout(FlowLayout.CENTER));
				
				jd.add(lb);
				jd.add(lb3);
				jd.add(lb2);
				jd.setLocationRelativeTo(searchT);
				jd.setSize(300, 190);
				jd.setVisible(true);
				
			}else {
			/*
			 * 1. 이미지 호출 만들기
			 * 2. DB 가져오기 Like 값 확인
			 * 3. DB 업데이트 Like 값 +1
			 */
			
			String bTitle = searchT.getText();
			//도서명으로 정보들 가져오기.
			System.out.println(title);
			bean = mgr.getBookLike8(title);
			
			System.out.println(bean.getVTITLE()+bean.getVAUTHOR()+bean.getVPUBLISHER()+bean.getVLIKE()+bean.getVISBN());
			System.out.println("조건에 들어갈 좋아요 : "+bean.getVLIKE());//0일 때 = 인서트, 그 외 업데이트
			
			/*
			 * 두 가지 경우가 발생한다
			 * 1. 좋아요 테이블에 데이터가 있는 경우 
			 * 2. 좋아요 테이블에 데이터가 없는 경우
			 * if 만약에 bean.size
			 */
			
			
			if(bean.getVTITLE()==null) {//좋아요가 0이라면 (좋아요 테이블에 데이터 X)
				
				JDialog jd = new JDialog();
				JLabel lb;
				if(str1.length()>10) {
				 lb = new JLabel(tf1.getText().substring(0,10) + "... 이(가) 요청 목록에 추가 되었습니다.");
				jd.setTitle(tf1.getText().substring(0,10) + "...이(가) 추가되었습니다.");
				}else {
					lb = new JLabel(tf1.getText() + " 은(는) 보유도서입니다.");
					jd.setTitle(tf1.getText() + " 이(가) 요청도서 목록에 추가 되었습니다.");
				}
				JLabel lb2 = new JLabel("<html>요청 도서 목록에서 <br>확인 해주세요.</html>");
				JLabel lb3 = new JLabel(new ImageIcon("C:\\IMage\\mask.png"));
				lb.setFont(lbfont);
				lb2.setFont(lbfont);
				lb.setBounds(40, 20, 260, 20);
				lb2.setBounds(40, 120, 260, 20);
				jd.setLayout(new FlowLayout(FlowLayout.CENTER));
				jd.add(lb);
				jd.add(lb3);
				jd.add(lb2);
				jd.setLocationRelativeTo(searchT);
				jd.setSize(370, 190);
				jd.setVisible(true);
				
				bean.setVLIKE(1);
				bean.setVTITLE(tf1.getText());
				bean.setVAUTHOR(tf2.getText());
				bean.setVPUBLISHER(tf3.getText());
				bean.setVISBN(isbn);
				
				if(mgr.insertBVOTE(bean)) {  //새로만들기
				
				Vector<BVOTEBean> vlist2 = new Vector<BVOTEBean>();
				vlist2 = mgr.getLikeBook2(bTitle);
				System.out.println(vlist2.size());
				String[] col = { "도서명", "저자", "출판사", "좋아요" ,"i"};
				Object row[][] = new Object[vlist2.size()][5];
				for (int j = 0; j < row.length; j++) {
					bean = vlist2.elementAt(j);
					row[j][0] = bean.getVTITLE();
					row[j][1] = bean.getVAUTHOR();
					row[j][2] = bean.getVPUBLISHER();
					row[j][3] = bean.getVLIKE();
					row[j][4] = bean.getVISBN();
					System.out.println("");
					}
				}
			//	model = new DefaultTableModel(row, col);
//				DefaultTableModel m = (DefaultTableModel)table.getModel();
//				m.fireTableDataChanged();
				
				
				
			}else if(bean.getVLIKE()>0) {//좋아요가 1 이상이라면 (좋아요 테이블에 데이터 존재)
				Runnable tt = new AlphaFrame4();
				Thread t1 = new Thread(tt);
				t1.start();
				
				
				String s = bean.getVTITLE();
				int i = bean.getVLIKE();
				System.out.println("가져온 값: "+i);
				i++;
				System.out.println("자바에서 증가된 값: "+i);
				//이제 좋아요 수를 +1 했으니 업데이트를 위해 빈에 담는다.
				bean.setVTITLE(s);
				bean.setVLIKE(i);
				System.out.println("넘겨줄 빈즈에 담긴 값"+i);
				mgr.updateBVOTE(bean);
				
				p2.removeAll();
				viewBV();
				for (int j = 0; j < table.getRowCount(); j++) {
					if(s.equals(table.getValueAt(j, 0))) {
						table.changeSelection(j,	0, false, false);
					}
				}
				/*bean = mgr.getBookLike(bTitle);
				System.out.println("DB 업데이트된 좋아요 수: "+bean.getVLIKE());
				
				
				
				Vector<BVOTEBean> vlist2 = new Vector<BVOTEBean>();
				vlist2 = mgr.getLikeBook2(bTitle);
				System.out.println(vlist2.size());
				String[] col = { "도서명", "저자", "출판사", "좋아요" };
				Object row[][] = new Object[vlist2.size()][5];
				for (int j = 0; j < row.length; j++) {
					bean = vlist2.elementAt(j);
					row[j][0] = bean.getVTITLE();
					row[j][1] = bean.getVAUTHOR();
					row[j][2] = bean.getVPUBLISHER();
					row[j][3] = bean.getVLIKE();
					
					System.out.println("");
				}*/
			//	model = new DefaultTableModel(row, col);
//				DefaultTableModel m = (DefaultTableModel)table.getModel();
//				m.fireTableDataChanged();
				
			///	for (int i1 = 0; i1 < row.length; i1++) {
				//	model.insertRow(i1, row[i1]);
			//	}
				
				
				//revalidate();
				
			}
			
			
		}}}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		ResetThread.timer =10 ;
		Object obj = e.getSource();
		if (obj == likeBtn) {
			likeBtn.setBounds(280, 10, 52, 46);
			int offset = likeBtn.getInsets().left; // 버튼 크기 재기
			likeBtn.setIcon(resizeIcon(iconLike, likeBtn.getWidth() - offset, likeBtn.getHeight() - offset));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Object obj = e.getSource();
		if (obj == likeBtn) {
			likeBtn.setBounds(280-2, 10-2, 56, 50);
			int offset = likeBtn.getInsets().left; // 버튼 크기 재기
			likeBtn.setIcon(resizeIcon(iconLike, likeBtn.getWidth() - offset, likeBtn.getHeight() - offset));
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		String dft = searchT.getText();
		if (obj == searchT && dft.equals("도서명을 입력하세요.")) {
			searchT.setText("");
		} else if (obj == likeBtn) {
			likeBtn.setBounds(280-2, 10-2, 56, 50);
			int offset = likeBtn.getInsets().left; // 버튼 크기 재기
			likeBtn.setIcon(resizeIcon(iconLike, likeBtn.getWidth() - offset, likeBtn.getHeight() - offset));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		if (obj == likeBtn) {
			likeBtn.setBounds(280, 10, 52, 46);
			int offset = likeBtn.getInsets().left; // 버튼 크기 재기
			likeBtn.setIcon(resizeIcon(iconLike, likeBtn.getWidth() - offset, likeBtn.getHeight() - offset));
		}
	}

	public static void main(String[] args) {
		new VFrame();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ResetThread.timer =10 ;
		Object obj = e.getSource();
		if (obj.equals(searchBtn)) {

			/*
			 * 경우의 수 3가지 1. DB [ 도서테이블 ] 에 데이터가 있다 = 보유도서입니다. 팝업창 2. DB [ 미보유도서테이블 ]에 데이터가
			 * 있다 = 결과값 리턴 3. DB에 검색결과가 없다면 파싱을 한다.
			 */

			
		

			/*String keyWord = searchT.getText();// tf에 입력된 키워드를 item에 담는다.
			// 1. 도서테이블부터 훑어본다.
			BooksMgr mgr1 = new BooksMgr();
			Vector<BooksBean> vlist1 = mgr1.getBookTitleAccord(keyWord);// 일치해야함
			if (vlist1.size() >= 1) {// 가져온 데이터가 1개 이상이라면(도서테이블에 있는 보유도서라면)
				System.out.println("보유도서의 데이터 개수: " + vlist1.size());
				JDialog jd = new JDialog();
				JLabel lb = new JLabel(keyWord + "은(는) 보유도서입니다.");
				JLabel lb2 = new JLabel("<html>도서검색 결과가 없다면<br>사서에게 문의해주세요.</html>");
				JLabel lb3 = new JLabel(new ImageIcon("C:\\IMG\\mask.png"));
				lb.setFont(lbfont);
				lb2.setFont(lbfont);
//				lb.setBounds(40, 20, 260, 20);
//				lb2.setBounds(40, 120, 260, 20);
				jd.setLayout(new FlowLayout(FlowLayout.CENTER));
				jd.setTitle(keyWord + "은(는) 보유도서입니다.");
				jd.add(lb);
				jd.add(lb3);
				jd.add(lb2);
				jd.setLocationRelativeTo(searchT);
				jd.setSize(300, 180);
				jd.setVisible(true);*/
//					 JScrollPane scroll;
//						String[] col = {"도서명", "저자", "출판사", "좋아요"};
//						Object row[][] = new Object[vlist1.size()][3];
//						for (int i = 0; i < row.length; i++) {
//							BooksBean bean = vlist1.elementAt(i);
//							row[i][0] = bean.getTITLE();
//							row[i][1] = bean.getAUTHOR();
//							row[i][2] = bean.getPUBLISHER();
//						}
//						model = new DefaultTableModel(row, col);
//						
//						table = new JTable(model);
//						table.setFillsViewportHeight(true);
//						table.setShowVerticalLines(false);//가로 선 제거
//						table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//단일행 선택
//						table.setDefaultEditor(Object.class, null);//테이블 수정 불가능 (null)//JTable 의 컬럼 길이 조절
//						table.getColumnModel().getColumn(0).setPreferredWidth(400);
//						table.getColumnModel().getColumn(1).setPreferredWidth(250);
//						table.getColumnModel().getColumn(2).setPreferredWidth(150);
//						table.getColumnModel().getColumn(3).setPreferredWidth(100);
//						table.setRowHeight(25);
//						table.addMouseListener(this);
//						
//						DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//						centerRenderer.setHorizontalAlignment( JLabel.CENTER );
//						table.setDefaultRenderer(Object.class, centerRenderer); 		//table.set
//						scroll = new JScrollPane(table);
//						scroll.setBounds(10, 30, 740, 240);
//						p2.add(scroll);
			}//-----조건 1 끝
			// 2. 미보유 테이블 훑어본다
		
			/*else if (vlist1.size() == 0) {// 보유도서가 없다면
				BVOTEMgr mgr = new BVOTEMgr();// 미보유도서(투표테이블)을 살펴보겠다.
				Vector<BVOTEBean> vlist2 = mgr.getListVote(keyWord);
				// 이프 안의 이프(도서테이블조회 후 미보유도서테이블 조회)
				if (vlist2.size() != 0) { // vlist2에 데이터가 들어 있다면(미보유도서테이블에 데이터가 있다면)
					System.out.println("보유도서의 데이터 개수: " + vlist1.size());
					System.out.println("미보유도서의 데이터 개수: " + vlist2.size());
					JScrollPane scroll;
					String[] col = { "도서명", "저자", "출판사", "좋아요","i" };
					Object row[][] = new Object[vlist2.size()][4];
					for (int i = 0; i < row.length; i++) {
						BVOTEBean bean = vlist2.elementAt(i);
						row[i][0] = bean.getVTITLE();
						row[i][1] = bean.getVAUTHOR();
						row[i][2] = bean.getVPUBLISHER();
						row[i][3] = bean.getVLIKE();
					}
				//	model = new DefaultTableModel(row, col);
					DefaultTableModel m = (DefaultTableModel)table.getModel();
					m.fireTableDataChanged();
					revalidate();
					
					for (int i = 0; i < row.length; i++) {
						m.insertRow(i, row[i]);
					}*/
					
					
					
					
//					m.insertRow(1, new Object[]{"d1","d2","d3","d4"});
//	
//					table = new JTable(model);
//					table.setFillsViewportHeight(true);
//					table.setShowVerticalLines(false);// 가로 선 제거
//					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 단일행 선택
//					table.setDefaultEditor(Object.class, null);// 테이블 수정 불가능 (null)//JTable 의 컬럼 길이 조절
//					table.getColumnModel().getColumn(0).setPreferredWidth(400);
//					table.getColumnModel().getColumn(1).setPreferredWidth(250);
//					table.getColumnModel().getColumn(2).setPreferredWidth(150);
//					table.getColumnModel().getColumn(3).setPreferredWidth(100);
//					table.setRowHeight(25);
//					table.addMouseListener(new MouseListener() {
//						@Override
//						public void mouseReleased(MouseEvent e) {}
//						@Override
//						public void mousePressed(MouseEvent e) {}
//						@Override
//						public void mouseExited(MouseEvent e) {}
//						@Override
//						public void mouseEntered(MouseEvent e) {}
//						@Override
//						public void mouseClicked(MouseEvent e) {
//							Object obj = e.getSource();
//							if (obj.equals(table)) {
//								System.out.println("2번 상황에서 테이블 클릭했습니다.");
//								int row = table.getSelectedRow();
//								int col = table.getSelectedColumn();
//								for (int i = 0; i < table.getColumnCount(); i++) {
//									String s1 = (String) table.getValueAt(row, 0);
//									String s2 = (String) table.getValueAt(row, 1);
//									String s3 = (String) table.getValueAt(row, 2);
//									tf1.setText(s1);
//									tf2.setText(s2);
//									tf3.setText(s3);
//								}
//							} 
//						}
//					});
//
//					DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
//					centerRenderer.setHorizontalAlignment(JLabel.CENTER);
//					table.setDefaultRenderer(Object.class, centerRenderer); // table.set
//					scroll = new JScrollPane(table);
//					scroll.setBounds(10, 30, 740, 240);
//					p2.add(scroll);
					
				//3. 파싱을 한다
				//} else if (vlist2.size() == 0) {// 도서T도 미보유T도 없다면 파싱을 하겠다.
					//System.out.println("보유도서의 데이터 개수: " + vlist1.size());
					//System.out.println("미보유도서의 데이터 개수: " + vlist2.size());
					//System.out.println("파싱을 수행합니다.");
		
			if(comboBox.getSelectedIndex()==0) {
					model.setNumRows(0);// 행 초기화 메소드
					ParseEx3 ex3 = new ParseEx3(searchT.getText());
					for (int i = 0; i < ex3.title1.size(); i++) {
						model.insertRow(i, 
								new Object[] { 
										ex3.title1.get(i), 
										ex3.author1.get(i), 
										ex3.pub1.get(i),"",
										ex3.isbn1.get(i)
										});
						// table.updateUI();
					}
			}else if(comboBox.getSelectedIndex()==1) {
				p2.removeAll();
				
				vlist3 = mgr.getLikeBook2(searchT.getText());
				
				
				String row[][] = new String[vlist3.size()][5];
				for (int j = 0; j < row.length; j++) {
					bean = vlist3.elementAt(j);
					row[j][0] = bean.getVTITLE();
					row[j][1] = bean.getVAUTHOR();
					row[j][2] = bean.getVPUBLISHER();
					row[j][3] = bean.getVLIKE()+"";
					row[j][4] = bean.getVISBN();
				}
				model = new DefaultTableModel(row, col);

				table = new JTable(model);
				table.setFillsViewportHeight(true);
				table.setShowVerticalLines(false);// 가로 선 제거
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// 단일행 선택
				table.setDefaultEditor(Object.class, null);// 테이블 수정 불가능 (null)//JTable 의 컬럼 길이 조절
				table.getColumnModel().getColumn(0).setPreferredWidth(400);
				table.getColumnModel().getColumn(1).setPreferredWidth(250);
				table.getColumnModel().getColumn(2).setPreferredWidth(150);
				table.getColumnModel().getColumn(3).setPreferredWidth(100);
				table.getColumnModel().getColumn(4).setPreferredWidth(1);
				table.setRowHeight(25);
				table.addMouseListener(this);
				DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
				centerRenderer.setHorizontalAlignment(JLabel.CENTER);
				table.setDefaultRenderer(Object.class, centerRenderer); // table.set
				scroll = new JScrollPane(table);
				scroll.setBounds(10, 30, 740, 240);
			//	p2.removeAll();
				p2.add(scroll);
			}
			

		

	}
	ActionListener com = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(comboBox.getSelectedIndex()==0) {
				searchT.setText("");
				model.setNumRows(0);
			}else if(comboBox.getSelectedIndex()==1) {
				searchT.setText("");
				//p2.removeAll();
				viewBV();
			}
		}
	};

}
