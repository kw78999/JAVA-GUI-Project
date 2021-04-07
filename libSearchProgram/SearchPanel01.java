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
	String[] col = {"������", "����", "���ǻ�", "������ġ", "���⿩��", "���"};
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
		
	/*System.out.println("�ο� ī��Ʈ : "+model.getRowCount());
		DefaultTableModel m = (DefaultTableModel)table.getModel();
		m.fireTableDataChanged(); //model(���̺�) �� �ʱ�ȭ
		m.fireTableRowsDeleted(0, m.getRowCount());
		System.out.println("�ο� ī��Ʈ : "+model.getRowCount());
		//removeAll();
		model.setNumRows(0);
		System.out.println("�ο� ī��Ʈ : "+model.getRowCount());
		table.removeAll();
		table.updateUI();
		table.repaint();
		scroll.removeAll();
		scroll.updateUI();
		removeAll();
		revalidate();
		vlist.removeAllElements();*/
		String bTitle = SearchPanel02.keyWord;
		System.out.println("������˻��޼ҵ�ȣ�� �ڵ���ġ: ��ġ�г�01\n�˻���: "+bTitle);
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
			System.out.println("���� ��"+(i+1)+": "+row[i][0]+row[i][1]+row[i][2]+row[i][3]+row[i][4]+row[i][5]);
		}
		
		model = new DefaultTableModel(row, col);
	
		table = new JTable(model);
	table.setFillsViewportHeight(true);
		table.setShowVerticalLines(false);//���� �� ����
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//������ ����
		table.setDefaultEditor(Object.class, null);//���̺� ���� �Ұ��� (null)
		table.getColumnModel().getColumn(0).setPreferredWidth(200);//JTable �� �÷� ���� ����
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
			
			TitledBorder tB3 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3, true),"���� ���");
			tB3.setTitleFont(new Font("��Ǯ���¿��� Medium", Font.BOLD, 18) );
			panel.setBorder(tB3);
			panel.setLayout(null);
			model = new DefaultTableModel(/*data*/row, col);
			
			table = new JTable(model);
			table.setFillsViewportHeight(true);
			table.setShowVerticalLines(false);//���� �� ����
			table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//������ ����
			table.setDefaultEditor(Object.class, null);//���̺� ���� �Ұ��� (null)
			table.getColumnModel().getColumn(0).setPreferredWidth(200);//JTable �� �÷� ���� ����
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
	
	
	
	 
	public void setbookimg(String imastr) {         //�̹����� �����ϴ� �޼ҵ�
		//å �̹��� ����
		//	SearchPanel02 eventInfo = new SearchPanel02();
		    icon = new ImageIcon("C:\\img\\"+imastr);
			bimg = icon.getImage();    //icon �̹��� img�� �ֱ�
			Image change = bimg.getScaledInstance(90, 120, Image.SCALE_SMOOTH); //img�̹��� ũ������
			ImageIcon changeicon = new ImageIcon(change);//img �̹��� �ٽ� imageicon�� �ֱ�
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
			eventInfo.infoTitle.setText("������: "+s1);
			eventInfo.infoAuthor.setText("����: "+s2);
			eventInfo.infoLocate.setText("��ġ: "+s3);
		}//--for �г�2 ���� �ٲٴ� �ݺ���
		
		
		
		System.out.println("���õ� ��: "+table.getValueAt(row, 5));
		String s = (String) table.getValueAt(row, 5);//�̹������ ��
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
		}//--for �г�3 ���� �ٲٴ� �ݺ���
		
			
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
