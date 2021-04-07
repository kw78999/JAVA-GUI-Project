package libSearchProgram;

import java.awt.Color;
import java.awt.Container;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import JAVAP.BookThread;

public class SFrame extends JFrame{
	ResetThread rt = new ResetThread();
	 ImageIcon normalIcon7 = new ImageIcon("C:\\\\\\\\image\\\\resetbtn.png"); 
		 Image btnimg7 = normalIcon7.getImage(); 
		  Image change7 = btnimg7.getScaledInstance(27, 25, Image.SCALE_SMOOTH);
		  ImageIcon changeicon7 = new ImageIcon(change7);
		  
	//SearchPanel01 p1 = new SearchPanel01();	//���̺�
//	SearchPanel02 p2 = new SearchPanel02();	//�˻� �� Ŭ���� �� ���
	SearchPanel03 p3 = new SearchPanel03();	//ä��
	SearchPanel04 p4 = new SearchPanel04();	//���� ����
	SearchPanel05 p5 = new SearchPanel05();	//���� ����
	
	static JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	
	static String[] col = {"������", "����", "���ǻ�", "������ġ", "���⿩��", "���"};
	static Vector<BooksBean> vlist;
	SearchPanel02 eventInfo;
	SearchPanel04 eventMap;
	static JTable table;
	static DefaultTableModel model;
	static JScrollPane scroll;
	static ImageIcon none = new ImageIcon("C:\\IMAGE\\non.jpg");
	static ImageIcon icon;
	static Image bimg;
	static BooksMgr mgr = new BooksMgr();
	
	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	       Image img = icon.getImage();  
	       Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	       return new ImageIcon(resizedImage);
	}//�̹����� �޾Ƽ� ��ư ����� �°� �������ִ� �޼ҵ�. �Ʒ� int offset�� ���� ���
	
	static JLabel infoImg = new JLabel();
	static  JLabel infoTitle = new JLabel();
	static  JLabel infoAuthor = new JLabel();
	static  JLabel infoLocate = new JLabel();
	static String keyWord;
	
	ImageIcon print = new ImageIcon("C:\\IMage\\printericon.png");
	static JTextField textField;

	
	JButton btn1, btn2,btn3;
	JComboBox<String> comboBox;
	
	
	
	public SFrame() {
		
		viewlist();
		
		TitledBorder tB1 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3, true),"���� �˻�");
		tB1.setTitleFont(new Font("��Ǯ���¿��� Medium", Font.BOLD, 18));
		
		TitledBorder tB1_1 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		JPanel p1_1 = new JPanel();
		JPanel p1_2 = new JPanel();
		ImageIcon iconSearch = new ImageIcon("C:\\IMAGE\\searchIcon.png");
		String[] s = {"������", "����"};
		Font comboFont = new Font("��Ǯ���¿��� Medium", Font.PLAIN, 12 );
		
		
		
		
		Font infoFont = new Font("��Ǯ���¿��� Medium", Font.PLAIN, 15 );

		p2.setBorder(tB1);
		p2.setLayout(null);
		p2.	setBounds(690, 0, 450, 230);//p1 ����450 ���� 200
		btn1 = new JButton(iconSearch);//�˻���ư
		btn1.setBounds(380, 25, 27, 25);
		btn1.setContentAreaFilled(false);//��ư �����ֱ�
		btn1.addActionListener(se2);
		
		btn2 = new JButton(print);
		btn2.setBounds(390,160,46,46);//����Ʈ��ư
		btn2.setContentAreaFilled(false);//��ư �����ֱ�
		btn2.setBorderPainted(false);//��ư �׵θ� ���ֱ�
		btn2.setFocusPainted(false);
		btn2.addMouseListener(se);//���콺������
		btn2.addActionListener(se2);//�׼Ǹ�����
		
		btn3= new JButton(changeicon7);
		btn3.setBounds(410, 25, 27, 25);
		btn3.addActionListener(reset);
		
		int offset = btn2.getInsets().left; //��ư ũ�� ���
		btn2.setIcon(resizeIcon(print, btn2.getWidth() - offset, btn2.getHeight() - offset)); //��ư ũ�⿡ ���� �̹��� ����
		
		textField = new JTextField();
		textField.setBounds(145, 25, 240, 26);
		comboBox = new JComboBox<>(s);
		comboBox.setBounds(20, 25, 125, 25);
		comboBox.setFont(comboFont);
	//	comboBox.setOpaque(false);
		p2.add(btn1);
		p2.	add(btn2);
		p2.	add(btn3);
		p2.add(textField);
		p2.add(comboBox);
		
		p1_1 = new JPanel();
		p1_1.setBorder(tB1_1);
		p1_1.setBounds(10, 60, 430, 155);
		p1_1.setBackground(Color.WHITE);
		p1_1.setLayout(null);
		
		p1_2 = new JPanel();
		p1_2.setLayout(null);
		p1_2.setBounds(10, 10, 410, 135);
		p1_2.setBackground(Color.WHITE);
		
		infoImg = new JLabel();
		infoImg.setLayout(null);
		infoImg.setBounds(20, 10, 90, 120);
		
		infoTitle = new JLabel("");//�˻���� �� ������ DB���� �� ��������
		infoTitle.setBounds(130, 30, 240, 20);
		infoTitle.setFont(infoFont);
		
		infoAuthor = new JLabel("");
		infoAuthor.setBounds(130, 60, 240, 20);
		infoAuthor.setFont(infoFont);
		
		infoLocate = new JLabel("");
		infoLocate.setBounds(130, 90, 240, 20);
		infoLocate.setFont(infoFont);
		
		
		p1_2.add(infoTitle);
		p1_2.add(infoAuthor);
		p1_2.add(infoLocate);
		p1_2.add(infoImg);
		
		p1_1.add(p1_2);
		p2.add(p1_1);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1155, 700);
		setResizable(false);
		setLayout(null);
		setTitle("ȸ���� �����˻� ���α׷�");
		setLocationRelativeTo(null);
		Container c = getContentPane();
		p1.setBounds(0, 0, 690, 450);
		p1.setBackground(Color.WHITE);
		p2.setBounds(690, 0, 450, 230);
		p2.setBackground(Color.WHITE);
		p3.setBounds(0, 450, 690, 210);
		p3.setBackground(Color.WHITE);
		p4.setBounds(690, 230, 450, 220);
		p4.setBackground(Color.WHITE);
		p5.setBounds(690, 450, 450, 210);
		p5.setBackground(Color.WHITE);
		c.add(p1);
		c.add(p2);
		c.add(p3);
		c.add(p4);
		c.add(p5);
		
		setVisible(true);
		validate();
	}
	
	
	public static void setbookimg(String imastr) {         //�̹����� �����ϴ� �޼ҵ�
		//å �̹��� ����
		//	SearchPanel02 eventInfo = new SearchPanel02();
		    icon = new ImageIcon("C:\\image\\"+imastr);
			bimg = icon.getImage();    //icon �̹��� img�� �ֱ�
			Image change = bimg.getScaledInstance(90, 120, Image.SCALE_SMOOTH); //img�̹��� ũ������
			ImageIcon changeicon = new ImageIcon(change);//img �̹��� �ٽ� imageicon�� �ֱ�
			infoImg.removeAll();
			infoImg.setIcon(changeicon);
			}
	
	public static void viewlist() {
		
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
		p1.setBorder(tB3);
		p1.setLayout(null);
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
		table.addMouseListener(tablemouse);
		scroll = new JScrollPane(table);
		scroll.setBounds(20, 24, 650, 400);
		
		
		p1.removeAll();
		p1.	revalidate();
		vlist.removeAllElements();
		p1.add(scroll);
		
		
		p1.setVisible(true);
 }
	public static void main(String[] args) {
		new SFrame();
		Runnable tt = new ResetThread();
		Thread t1 = new Thread(tt);
		t1.start();
	}

	
	
	static  MouseListener tablemouse = new MouseListener() {
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {
			ResetThread.timer = 5;
		}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseClicked(MouseEvent e) {
			int row = table.getSelectedRow();
			int col = table.getSelectedColumn();
			for (int i = 0; i < table.getColumnCount(); i++) {
				String s1 = (String) table.getValueAt(row, 0);
				String s2 = (String) table.getValueAt(row, 1);
				String s3 = (String) table.getValueAt(row, 3);
				infoTitle.setText("������: "+s1);
				infoAuthor.setText("����: "+s2);
				infoLocate.setText("��ġ: "+s3);
			}//--for �г�2 ���� �ٲٴ� �ݺ���
			
			
			String s = (String) table.getValueAt(row, 5);//�̹������ ��
			if(s=="") {
				infoImg.setIcon(none);
			}else {
				setbookimg(s);
			}
//			int offset = eventInfo.getInsets().left;
//					 if(s.equals("aaaa.png")) {
//				eventInfo.infoImg.setIcon(bookZ);
//			}else if(s.equals("bbbb.png")) {
//				eventInfo.infoImg.setIcon(bookJ);
//			}else if(s.equals("cccc.png")) {
//				eventInfo.infoImg.setIcon(bookH);
//			}else if(s.equals("dddd.png")) {
//				eventInfo.infoImg.setIcon(bookL);
//			}
			
			
			String[] subStr = new String[4];
			for (int i = 0; i < subStr.length; i++) {
				String str = (String) table.getValueAt(row, 3);
				subStr[i] = str.substring(0, 1);
				
				
				if(subStr[i].equals("A")||subStr[i].equals("a")) {
					SearchPanel04.map.setIcon(SearchPanel04.MAPA);
				}else if(subStr[i].equals("B")||subStr[i].equals("b")) {
					SearchPanel04.map.setIcon(SearchPanel04.MAPB);
				}else if(subStr[i].equals("C")||subStr[i].equals("c")) {
					SearchPanel04.map.setIcon(SearchPanel04.MAPC);
				}else if(subStr[i].equals("D")||subStr[i].equals("d")) {
					SearchPanel04.map.setIcon(SearchPanel04.MAPD);
				}
			}//--for �г�3 ���� �ٲٴ� �ݺ���
			
		}
	};
	
	MouseListener se = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			Object obj = e.getSource();
			if(obj==btn2) {
				btn2.setBounds(390-2,160-2,50,50);
				int offset = btn2.getInsets().left;
				btn2.setIcon(resizeIcon(print, btn2.getWidth() - offset, btn2.getHeight() - offset));
			}
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			Object obj = e.getSource();
			if(obj==btn2) {
			btn2.setBounds(390,160,46,46);
			int offset = btn2.getInsets().left; //��ư ũ�� ���
			btn2.setIcon(resizeIcon(print, btn2.getWidth() - offset, btn2.getHeight() - offset));
			}
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			Object obj = e.getSource();
			if(obj==btn2) {
				btn2.setBounds(390,160,46,46);
				int offset = btn2.getInsets().left; //��ư ũ�� ���
				btn2.setIcon(resizeIcon(print, btn2.getWidth() - offset, btn2.getHeight() - offset));
			}
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			Object obj = e.getSource();
			if(obj==btn2) {
				btn2.setBounds(390-2,160-2,50,50);
				int offset = btn2.getInsets().left; //��ư ũ�� ���
				btn2.setIcon(resizeIcon(print, btn2.getWidth() - offset, btn2.getHeight() - offset));
			}
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			Object obj = e.getSource();
			if(obj==btn2) {
			new PrinterMethod();//�ܺ�Ŭ���� ����Ʈ ȣ��
			
			PrintDialogExample s = new PrintDialogExample();
			ResetThread.timer = 10;
			
			}
		}
	};
	
	ActionListener se2 = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			Object item = comboBox.getSelectedItem();
			if(obj.equals(btn1)&&item=="������") {//���������� �˻����� ��
				
				keyWord = textField.getText();//tf�� �Էµ� �˻��� Search01���� ó��
				
				 vlist = mgr.getBookTitle(keyWord);
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
					table.addMouseListener(tablemouse);
					scroll = new JScrollPane(table);
					scroll.setBounds(20, 24, 650, 400);
					
					p1.removeAll();
					p1.	revalidate();
					vlist.removeAllElements();
					p1.	add(scroll);
					
					p1.setVisible(true);
					ResetThread.timer = 10;
			}else if(obj.equals(btn1)&&item=="����") {
				keyWord = textField.getText();//tf�� �Էµ� �˻��� Search01���� ó��
				
				 vlist = mgr.getBookAuthor(keyWord);
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
					table.addMouseListener(tablemouse);
					scroll = new JScrollPane(table);
					scroll.setBounds(20, 24, 650, 400);
					
					p1.removeAll();
					p1.	revalidate();
					vlist.removeAllElements();
					p1.	add(scroll);
					
					p1.setVisible(true);
					ResetThread.timer = 10;
			}else if(obj.equals(btn1)&&textField.equals("")){//if �ٿ��� ���� �ߤ��ϱ�
				ResetThread.timer = 10;
			}
			
		}
	};
	
	ActionListener reset = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			viewlist();
			ResetThread.timer = 10;
		}
	};
	
	
	
	
	
}
