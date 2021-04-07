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
	}// �̹����� �޾Ƽ� ��ư ����� �°� �������ִ� �޼ҵ�. �Ʒ� int offset�� ���� ���

	ImageIcon iconLike = new ImageIcon("C:\\IMAGE\\like.png");
	String[] col = { "������", "����", "���ǻ�", "���ƿ�","i"};
	JTextField searchT;// ���콺�����ʶ����� Ŭ������ �ʵ�� ����
						// �����ڿ� �����ϸ�??? ����ƽ��???
	
	BVOTEMgr mgr = new BVOTEMgr();
	BVOTEBean bean = new BVOTEBean();
	Vector<BVOTEBean> vlist3 = new Vector<BVOTEBean>();
	
	JButton searchBtn, likeBtn;
	String[] s = {"���� �˻�","��û ����"};
	DefaultTableModel model;
	JTable table;
	JTable table2;
	JScrollPane scroll;
	JTextField tf1, tf2, tf3;
	JPanel p1, p3;
	JPanel p2 = new JPanel();
	Font lbfont = new Font("��Ǯ���¿��� Medium", Font.PLAIN, 14);
	
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
		table.setShowVerticalLines(false);// ���� �� ����
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// ������ ����
		table.setDefaultEditor(Object.class, null);// ���̺� ���� �Ұ��� (null)//JTable �� �÷� ���� ����
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
		
		TitledBorder tB1 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2, true), "�̺��� ���� �˻�");
		tB1.setTitleFont(new Font("��Ǯ���¿��� Medium", Font.PLAIN, 12));

		TitledBorder tB2 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2, true), "�˻� ���");
		tB2.setTitleFont(new Font("��Ǯ���¿��� Medium", Font.PLAIN, 18));

		TitledBorder tB3 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 2, true), "���� ��û");
		tB3.setTitleFont(new Font("��Ǯ���¿��� Medium", Font.PLAIN, 18));

		
		Font lbfont2 = new Font("��Ǯ���¿��� Medium", Font.PLAIN, 16);
		Font comboFont = new Font("��Ǯ���¿��� Medium", Font.PLAIN, 12 );
		
		comboBox = new JComboBox<>(s);
		comboBox.setBounds(400, 30, 100, 25);
		comboBox.setFont(comboFont);
		comboBox.setBackground(Color.white);
		comboBox.addActionListener(com);
		setTitle("���� ��û");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(800, 560);
		setResizable(false);
		setLayout(null);
		setLocationRelativeTo(null);

		////////////////////////////////////////////////
		// �˻����̺��г�
		ImageIcon iconSearch = new ImageIcon("C:\\IMAGE\\searchIcon.png");

		p1 = new JPanel();
		// p1.setBorder(tB1);
		p1.setLayout(null);
		p1.setBounds(0, 0, 780, 80);
		p1.setBackground(Color.WHITE);
		SearchPanel05 p5 = new SearchPanel05();

		String s = p5.name;
		String s1 = p5.testInputName;
		JTextArea ta = new JTextArea(s + "�� �ݰ����ϴ�.\n" + "ã���ô� �������� �˻��ؼ� ��ǥ���ּ���.");
		ta.setEditable(false);
		ta.setBounds(130, 20, 250, 32);
		ta.setFont(lbfont);

		searchT = new JTextField("�������� �Է��ϼ���.");
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
		// ������̺��г�
		
		p2.setBorder(tB2);
		p2.setLayout(null);
		p2.setBounds(0, 80, 780, 280);
		p2.setBackground(Color.WHITE);
		
		String[] col = { "������", "����", "���ǻ�", "���ƿ�","i"};
		/*
		 * Object[][] data = { {"�˿� �� (��)", "�����俹����Ű", "������", "97ǥ"}, {"������", "Į�� �����",
		 * "å�� ����", "67ǥ"}, {"���� �Ͼ�� ���� �ܸ��Ѵ�", "õ���", "���", "17ǥ"} };
		 */
		Object[][] row[][] = {};
		model = new DefaultTableModel(row, col);

		table = new JTable(model);
		table.setFillsViewportHeight(true);
		table.setShowVerticalLines(false);// ���� �� ����
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// ������ ����
		table.setDefaultEditor(Object.class, null);// ���̺� ���� �Ұ��� (null)//JTable �� �÷� ���� ����
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
		// ��ǥ�г�
		p3 = new JPanel();
		p3.setBorder(tB3);
		p3.setLayout(null);
		p3.setBounds(0, 360, 780, 160);
		p3.setBackground(Color.WHITE);

		int lbX = 50;

		JLabel lb1, lb2, lb3;
		lb1 = new JLabel("������");
		lb1.setBounds(lbX, 40, 100, 24);
		lb1.setFont(lbfont2);
		tf1 = new JTextField();
		tf1.setBounds(lbX + 50, 40, 300, 24);
		tf1.setBackground(new Color(235, 235, 235));
		tf1.setFont(lbfont2);

		lb2 = new JLabel("����");
		lb2.setBounds(lbX, 70, 100, 24);
		lb2.setFont(lbfont2);
		tf2 = new JTextField();
		tf2.setBounds(lbX + 50, 70, 300, 24);
		tf2.setBackground(new Color(235, 235, 235));
		tf2.setFont(lbfont2);

		lb3 = new JLabel("���ǻ�");
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
		ta2 = new JTextArea("      ã���ô� ������ �´ٸ�?\n\n���ϴ� ������ ��µ��� �ʴ� ���\n�Ʒ� ����Ʈ �������� ����\n����� ������ּ���.");
		ta2.setBounds(100, 30, 200, 110);
		ta2.setFont(lbfont);
		ta2.setEditable(false);

		likeBtn = new JButton(iconLike);
		likeBtn.setBounds(280, 10, 52, 46);
		likeBtn.setContentAreaFilled(false);
		likeBtn.setBorderPainted(false);
		likeBtn.setFocusPainted(false);
		likeBtn.addMouseListener(this);

		int offset = likeBtn.getInsets().left; // ��ư ũ�� ���
		likeBtn.setIcon(resizeIcon(iconLike, likeBtn.getWidth() - offset, likeBtn.getHeight() - offset)); // ��ư ũ�⿡ ���� �̹��� ����

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
		if (obj.equals(table)&&table.getRowCount()!=0) {//���̺� Ŭ���ߴµ� ���̺��� �� ������ 0�� �ƴ� ��(���� �ϳ� �̻� ����)
			int row = table.getSelectedRow();
			int col = table.getSelectedColumn();
			
			for (int i = 0; i < table.getColumnCount(); i++) {
				String s1 = (String) table.getValueAt(row, 0);
				String s2 = (String) table.getValueAt(row, 1);
				String s3 = (String) table.getValueAt(row, 2);
				tf1.setText(s1);
				tf2.setText(s2);
				tf3.setText(s3);
				tf1.select(0, 0);   //�ؽ�Ʈ ���ʺ��� �������� (����)
				tf2.select(0, 0);
				tf3.select(0, 0);
			} // --for �г�2 ���� �ٲٴ� �ݺ���
			
			
		}else if (obj == likeBtn) {
			if(tf1.getText().equals("")) {
				JDialog jd = new JDialog();
				JLabel lb = new JLabel("���ð��� �����ϴ�");
				//JLabel lb2 = new JLabel("<html>�����˻� ����� ���ٸ�<br>�缭���� �������ּ���.</html>");
				JLabel lb3 = new JLabel(new ImageIcon("C:\\IMage\\mask.png"));
				lb.setFont(lbfont);
				//lb2.setFont(lbfont);
				lb.setBounds(40, 20, 260, 20);
			//	lb2.setBounds(40, 120, 260, 20);
				jd.setLayout(new FlowLayout(FlowLayout.CENTER));
				//jd.setTitle(tf1.getText().substring(0,15) + "... ��(��) ���������Դϴ�.");
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
			int offset = likeBtn.getInsets().left; // ��ư ũ�� ���
			likeBtn.setIcon(resizeIcon(iconLike, likeBtn.getWidth() - offset, likeBtn.getHeight() - offset));
			System.out.println("���ƿ� ��ư ��� ���弼��");
			
			String isbn = (String)table.getValueAt(table.getSelectedRow(), 4);
			String title= (String)table.getValueAt(table.getSelectedRow(), 0);
			 if(mgr2.getisbn(isbn)) {
				 
				
				JDialog jd = new JDialog();
				JLabel lb;
				if(str1.length()>10) {
				 lb = new JLabel(tf1.getText().substring(0,10) + "... ��(��) ���������Դϴ�.");
				jd.setTitle(tf1.getText().substring(0,10) + "... ��(��) ���������Դϴ�.");
				}else {
					lb = new JLabel(tf1.getText() + " ��(��) ���������Դϴ�.");
					jd.setTitle(tf1.getText() + " ��(��) ���������Դϴ�.");
				}
				JLabel lb2 = new JLabel("<html>�����˻� ����� ���ٸ�<br>�缭���� �������ּ���.</html>");
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
			 * 1. �̹��� ȣ�� �����
			 * 2. DB �������� Like �� Ȯ��
			 * 3. DB ������Ʈ Like �� +1
			 */
			
			String bTitle = searchT.getText();
			//���������� ������ ��������.
			System.out.println(title);
			bean = mgr.getBookLike8(title);
			
			System.out.println(bean.getVTITLE()+bean.getVAUTHOR()+bean.getVPUBLISHER()+bean.getVLIKE()+bean.getVISBN());
			System.out.println("���ǿ� �� ���ƿ� : "+bean.getVLIKE());//0�� �� = �μ�Ʈ, �� �� ������Ʈ
			
			/*
			 * �� ���� ��찡 �߻��Ѵ�
			 * 1. ���ƿ� ���̺� �����Ͱ� �ִ� ��� 
			 * 2. ���ƿ� ���̺� �����Ͱ� ���� ���
			 * if ���࿡ bean.size
			 */
			
			
			if(bean.getVTITLE()==null) {//���ƿ䰡 0�̶�� (���ƿ� ���̺� ������ X)
				
				JDialog jd = new JDialog();
				JLabel lb;
				if(str1.length()>10) {
				 lb = new JLabel(tf1.getText().substring(0,10) + "... ��(��) ��û ��Ͽ� �߰� �Ǿ����ϴ�.");
				jd.setTitle(tf1.getText().substring(0,10) + "...��(��) �߰��Ǿ����ϴ�.");
				}else {
					lb = new JLabel(tf1.getText() + " ��(��) ���������Դϴ�.");
					jd.setTitle(tf1.getText() + " ��(��) ��û���� ��Ͽ� �߰� �Ǿ����ϴ�.");
				}
				JLabel lb2 = new JLabel("<html>��û ���� ��Ͽ��� <br>Ȯ�� ���ּ���.</html>");
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
				
				if(mgr.insertBVOTE(bean)) {  //���θ����
				
				Vector<BVOTEBean> vlist2 = new Vector<BVOTEBean>();
				vlist2 = mgr.getLikeBook2(bTitle);
				System.out.println(vlist2.size());
				String[] col = { "������", "����", "���ǻ�", "���ƿ�" ,"i"};
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
				
				
				
			}else if(bean.getVLIKE()>0) {//���ƿ䰡 1 �̻��̶�� (���ƿ� ���̺� ������ ����)
				Runnable tt = new AlphaFrame4();
				Thread t1 = new Thread(tt);
				t1.start();
				
				
				String s = bean.getVTITLE();
				int i = bean.getVLIKE();
				System.out.println("������ ��: "+i);
				i++;
				System.out.println("�ڹٿ��� ������ ��: "+i);
				//���� ���ƿ� ���� +1 ������ ������Ʈ�� ���� �� ��´�.
				bean.setVTITLE(s);
				bean.setVLIKE(i);
				System.out.println("�Ѱ��� ��� ��� ��"+i);
				mgr.updateBVOTE(bean);
				
				p2.removeAll();
				viewBV();
				for (int j = 0; j < table.getRowCount(); j++) {
					if(s.equals(table.getValueAt(j, 0))) {
						table.changeSelection(j,	0, false, false);
					}
				}
				/*bean = mgr.getBookLike(bTitle);
				System.out.println("DB ������Ʈ�� ���ƿ� ��: "+bean.getVLIKE());
				
				
				
				Vector<BVOTEBean> vlist2 = new Vector<BVOTEBean>();
				vlist2 = mgr.getLikeBook2(bTitle);
				System.out.println(vlist2.size());
				String[] col = { "������", "����", "���ǻ�", "���ƿ�" };
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
			int offset = likeBtn.getInsets().left; // ��ư ũ�� ���
			likeBtn.setIcon(resizeIcon(iconLike, likeBtn.getWidth() - offset, likeBtn.getHeight() - offset));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Object obj = e.getSource();
		if (obj == likeBtn) {
			likeBtn.setBounds(280-2, 10-2, 56, 50);
			int offset = likeBtn.getInsets().left; // ��ư ũ�� ���
			likeBtn.setIcon(resizeIcon(iconLike, likeBtn.getWidth() - offset, likeBtn.getHeight() - offset));
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		String dft = searchT.getText();
		if (obj == searchT && dft.equals("�������� �Է��ϼ���.")) {
			searchT.setText("");
		} else if (obj == likeBtn) {
			likeBtn.setBounds(280-2, 10-2, 56, 50);
			int offset = likeBtn.getInsets().left; // ��ư ũ�� ���
			likeBtn.setIcon(resizeIcon(iconLike, likeBtn.getWidth() - offset, likeBtn.getHeight() - offset));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		if (obj == likeBtn) {
			likeBtn.setBounds(280, 10, 52, 46);
			int offset = likeBtn.getInsets().left; // ��ư ũ�� ���
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
			 * ����� �� 3���� 1. DB [ �������̺� ] �� �����Ͱ� �ִ� = ���������Դϴ�. �˾�â 2. DB [ �̺����������̺� ]�� �����Ͱ�
			 * �ִ� = ����� ���� 3. DB�� �˻������ ���ٸ� �Ľ��� �Ѵ�.
			 */

			
		

			/*String keyWord = searchT.getText();// tf�� �Էµ� Ű���带 item�� ��´�.
			// 1. �������̺���� �Ⱦ��.
			BooksMgr mgr1 = new BooksMgr();
			Vector<BooksBean> vlist1 = mgr1.getBookTitleAccord(keyWord);// ��ġ�ؾ���
			if (vlist1.size() >= 1) {// ������ �����Ͱ� 1�� �̻��̶��(�������̺� �ִ� �����������)
				System.out.println("���������� ������ ����: " + vlist1.size());
				JDialog jd = new JDialog();
				JLabel lb = new JLabel(keyWord + "��(��) ���������Դϴ�.");
				JLabel lb2 = new JLabel("<html>�����˻� ����� ���ٸ�<br>�缭���� �������ּ���.</html>");
				JLabel lb3 = new JLabel(new ImageIcon("C:\\IMG\\mask.png"));
				lb.setFont(lbfont);
				lb2.setFont(lbfont);
//				lb.setBounds(40, 20, 260, 20);
//				lb2.setBounds(40, 120, 260, 20);
				jd.setLayout(new FlowLayout(FlowLayout.CENTER));
				jd.setTitle(keyWord + "��(��) ���������Դϴ�.");
				jd.add(lb);
				jd.add(lb3);
				jd.add(lb2);
				jd.setLocationRelativeTo(searchT);
				jd.setSize(300, 180);
				jd.setVisible(true);*/
//					 JScrollPane scroll;
//						String[] col = {"������", "����", "���ǻ�", "���ƿ�"};
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
//						table.setShowVerticalLines(false);//���� �� ����
//						table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//������ ����
//						table.setDefaultEditor(Object.class, null);//���̺� ���� �Ұ��� (null)//JTable �� �÷� ���� ����
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
			}//-----���� 1 ��
			// 2. �̺��� ���̺� �Ⱦ��
		
			/*else if (vlist1.size() == 0) {// ���������� ���ٸ�
				BVOTEMgr mgr = new BVOTEMgr();// �̺�������(��ǥ���̺�)�� ���캸�ڴ�.
				Vector<BVOTEBean> vlist2 = mgr.getListVote(keyWord);
				// ���� ���� ����(�������̺���ȸ �� �̺����������̺� ��ȸ)
				if (vlist2.size() != 0) { // vlist2�� �����Ͱ� ��� �ִٸ�(�̺����������̺� �����Ͱ� �ִٸ�)
					System.out.println("���������� ������ ����: " + vlist1.size());
					System.out.println("�̺��������� ������ ����: " + vlist2.size());
					JScrollPane scroll;
					String[] col = { "������", "����", "���ǻ�", "���ƿ�","i" };
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
//					table.setShowVerticalLines(false);// ���� �� ����
//					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// ������ ����
//					table.setDefaultEditor(Object.class, null);// ���̺� ���� �Ұ��� (null)//JTable �� �÷� ���� ����
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
//								System.out.println("2�� ��Ȳ���� ���̺� Ŭ���߽��ϴ�.");
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
					
				//3. �Ľ��� �Ѵ�
				//} else if (vlist2.size() == 0) {// ����T�� �̺���T�� ���ٸ� �Ľ��� �ϰڴ�.
					//System.out.println("���������� ������ ����: " + vlist1.size());
					//System.out.println("�̺��������� ������ ����: " + vlist2.size());
					//System.out.println("�Ľ��� �����մϴ�.");
		
			if(comboBox.getSelectedIndex()==0) {
					model.setNumRows(0);// �� �ʱ�ȭ �޼ҵ�
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
				table.setShowVerticalLines(false);// ���� �� ����
				table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);// ������ ����
				table.setDefaultEditor(Object.class, null);// ���̺� ���� �Ұ��� (null)//JTable �� �÷� ���� ����
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
