package libSearchProgram;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import libSearchProgram.BooksBean;




public class SearchPanel01 
implements MouseListener{
	String[] col = {"도서명", "저자", "출판사", "도서위치", "대출여부", "경로"};
	Vector<BooksBean> vlist;
	SearchPanel02 eventInfo;
	SearchPanel04 eventMap;
	JTable table;
	DefaultTableModel model;
//	static DefaultTableModel model2;
	JScrollPane scroll;
	JPanel panel = new JPanel();
//	ImageIcon bookB = new ImageIcon("libSearchProgram/babybook.jpg");
//	ImageIcon bookD = new ImageIcon("libSearchProgram/deepbook.jpg");
//	ImageIcon bookH = new ImageIcon("C://IMG//htmlbook.jpg");
//	ImageIcon bookJ = new ImageIcon("C://IMG//jspbook.jpg");
//	ImageIcon bookL = new ImageIcon("C://IMG//laspbook.jpg");
//	ImageIcon bookLI = new ImageIcon("libSearchProgram/livebook.jpg");
//	ImageIcon bookP = new ImageIcon("libSearchProgram/prophetbook.jpg");
//	ImageIcon bookZ = new ImageIcon("C://IMG//zarbook.jpg");
	
	ImageIcon none = new ImageIcon("C:\\IMAGE\\non.jpg");
	
	ImageIcon icon;
	Image bimg;
//	static ImageIcon icon;
//	static Image bimg;
	
	//SearchPanel02 panel02 = new SearchPanel02();
	
	BooksMgr mgr = new BooksMgr();
	
	
	public void SearchTitle() {
		
	/*System.out.println("로우 카운트 : "+model.getRowCount());
		DefaultTableModel m = (DefaultTableModel)table.getModel();
		m.fireTableDataChanged(); //model(테이블) 행 초기화
		m.fireTableRowsDeleted(0, m.getRowCount());
		System.out.println("로우 카운트 : "+model.getRowCount());
		//removeAll();
		model.setNumRows(0);
		System.out.println("로우 카운트 : "+model.getRowCount());
		table.removeAll();
		table.updateUI();
		table.repaint();
		scroll.removeAll();
		scroll.updateUI();
		removeAll();
		revalidate();
		vlist.removeAllElements();*/
		String bTitle = SearchPanel02.keyWord;
		System.out.println("도서명검색메소드호출 코드위치: 서치패널01\n검색어: "+bTitle);
		 vlist = mgr.getBookTitle(bTitle);
		String row[][] = new String[vlist.size()][6];
		for (int i = 0; i < row.length; i++) {
			BooksBean bean = vlist.elementAt(i);
			row[i][0] = bean.getTITLE();
			row[i][1] = bean.getAUTHOR();
			row[i][2] = bean.getPUBLISHER();
			row[i][3] = bean.getLOCATION();
			row[i][4] = bean.getBOOKSTATE();
			row[i][5] = bean.getBIMAGE();
			System.out.println("빈즈 행"+(i+1)+": "+row[i][0]+row[i][1]+row[i][2]+row[i][3]+row[i][4]+row[i][5]);
		}
		
		model = new DefaultTableModel(row, col);
	
		table = new JTable(model);
	table.setFillsViewportHeight(true);
		table.setShowVerticalLines(false);//가로 선 제거
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//단일행 선택
		table.setDefaultEditor(Object.class, null);//테이블 수정 불가능 (null)
		table.getColumnModel().getColumn(0).setPreferredWidth(200);//JTable 의 컬럼 길이 조절
	table.getColumnModel().getColumn(1).setPreferredWidth(40);
		table.getColumnModel().getColumn(2).setPreferredWidth(20);
		table.getColumnModel().getColumn(3).setPreferredWidth(20);
		table.getColumnModel().getColumn(4).setPreferredWidth(20);
		table.getColumnModel().getColumn(5).setMaxWidth(5);
		table.setRowHeight(25);
		
	
		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();		
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		table.setDefaultRenderer(Object.class, centerRenderer); 
		table.addMouseListener(this);
		scroll = new JScrollPane(table);
		scroll.setBounds(20, 24, 650, 400);
		
		panel.removeAll();
		panel.	revalidate();
		vlist.removeAllElements();
		panel.	add(scroll);
		
		panel.setVisible(true);
		
	}
	public SearchPanel01() {
		

			viewlist();
		
	}
	public void viewlist() {
			vlist = mgr.getListBooks();
			String row[][] = new String[vlist.size()][6];
			for (int i = 0; i < row.length; i++) {
				BooksBean bean = vlist.elementAt(i);
				row[i][0] = bean.getTITLE();
				row[i][1] = bean.getAUTHOR();
				row[i][2] = bean.getPUBLISHER();
				row[i][3] = bean.getLOCATION();
				row[i][4] = bean.getBOOKSTATE();
				row[i][5] = bean.getBIMAGE();
			}
			
			TitledBorder tB3 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3, true),"도서 목록");
			tB3.setTitleFont(new Font("잘풀리는오늘 Medium", Font.BOLD, 18) );
			panel.setBorder(tB3);
			panel.setLayout(null);
			model = new DefaultTableModel(/*data*/row, col);
			
			table = new JTable(model);
			table.setFillsViewportHeight(true);
			table.setShowVerticalLines(false);//가로 선 제거
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//단일행 선택
			table.setDefaultEditor(Object.class, null);//테이블 수정 불가능 (null)
			table.getColumnModel().getColumn(0).setPreferredWidth(200);//JTable 의 컬럼 길이 조절
			table.getColumnModel().getColumn(1).setPreferredWidth(40);
			table.getColumnModel().getColumn(2).setPreferredWidth(20);
			table.getColumnModel().getColumn(3).setPreferredWidth(20);
			table.getColumnModel().getColumn(4).setPreferredWidth(20);
			table.getColumnModel().getColumn(5).setPreferredWidth(5);
			table.setRowHeight(25);
			
			DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
			centerRenderer.setHorizontalAlignment( JLabel.CENTER );
			table.setDefaultRenderer(Object.class, centerRenderer); 		//table.set
			table.addMouseListener(this);
			scroll = new JScrollPane(table);
			scroll.setBounds(20, 24, 650, 400);
			panel.add(scroll);
			
			panel.setVisible(true);
	 }
	
	
	
	 
	public void setbookimg(String imastr) {         //이미지를 변경하는 메소드
		//책 이미지 삽입
		//	SearchPanel02 eventInfo = new SearchPanel02();
		    icon = new ImageIcon("C:\\img\\"+imastr);
			bimg = icon.getImage();    //icon 이미지 img에 넣기
			Image change = bimg.getScaledInstance(90, 120, Image.SCALE_SMOOTH); //img이미지 크기조절
			ImageIcon changeicon = new ImageIcon(change);//img 이미지 다시 imageicon에 넣기
			eventInfo.infoImg.removeAll();
			eventInfo.infoImg.setIcon(changeicon);
			System.out.println("imastr: "+imastr);
			}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		int row = table.getSelectedRow();
		int col = table.getSelectedColumn();
		for (int i = 0; i < table.getColumnCount(); i++) {
			String s1 = (String) table.getValueAt(row, 0);
			String s2 = (String) table.getValueAt(row, 1);
			String s3 = (String) table.getValueAt(row, 3);
			eventInfo.infoTitle.setText("도서명: "+s1);
			eventInfo.infoAuthor.setText("저자: "+s2);
			eventInfo.infoLocate.setText("위치: "+s3);
		}//--for 패널2 문자 바꾸는 반복문
		
		
		
		System.out.println("선택된 값: "+table.getValueAt(row, 5));
		String s = (String) table.getValueAt(row, 5);//이미지경로 셀
		if(s=="") {
			eventInfo.infoImg.setIcon(none);
		}else {
			setbookimg(s);
			System.out.println("setBookimg: "+s);
		}
//		int offset = eventInfo.getInsets().left;
//				 if(s.equals("aaaa.png")) {
//			eventInfo.infoImg.setIcon(bookZ);
//		}else if(s.equals("bbbb.png")) {
//			eventInfo.infoImg.setIcon(bookJ);
//		}else if(s.equals("cccc.png")) {
//			eventInfo.infoImg.setIcon(bookH);
//		}else if(s.equals("dddd.png")) {
//			eventInfo.infoImg.setIcon(bookL);
//		}
		
		
		String[] subStr = new String[4];
		for (int i = 0; i < subStr.length; i++) {
			String str = (String) table.getValueAt(row, 3);
			subStr[i] = str.substring(0, 1);
			
			
			if(subStr[i].equals("A")) {
				eventMap.map.setIcon(eventMap.MAPA);
			}else if(subStr[i].equals("B")) {
				eventMap.map.setIcon(eventMap.MAPB);
			}else if(subStr[i].equals("C")) {
				eventMap.map.setIcon(eventMap.MAPC);
			}else if(subStr[i].equals("D")) {
				eventMap.map.setIcon(eventMap.MAPD);
			}
		}//--for 패널3 지도 바꾸는 반복문
		
			
		  }
	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	
	
}
