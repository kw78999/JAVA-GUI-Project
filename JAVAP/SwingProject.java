package JAVAP;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Vector;

import javax.swing.ImageIcon;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;


public class  SwingProject implements ActionListener{
	static ImageIcon normalIcon7 = new ImageIcon("C:\\\\\\\\image\\\\rent2.jpg"); 
	static ImageIcon normalIcon8 = new ImageIcon("C:\\\\\\\\image\\\\rent3.jpg"); 
	static Image btnimg7 = normalIcon7.getImage(); 
	  static Image change7 = btnimg7.getScaledInstance(130, 50, Image.SCALE_SMOOTH);
	  
		static Image btnimg6 = normalIcon7.getImage(); 
		  static Image change6 = btnimg6.getScaledInstance(140, 55, Image.SCALE_SMOOTH);
		  
		  static Image btnimg8 = normalIcon8.getImage(); 
		  static Image change8 = btnimg8.getScaledInstance(130, 50, Image.SCALE_SMOOTH);
		  
	  static ImageIcon changeicon7 = new ImageIcon(change7);
	  static ImageIcon changeicon6 = new ImageIcon(change6);
	  static ImageIcon changeicon8 = new ImageIcon(change8);
	  static  JButton rentalbtn ;
	  
	ImageIcon normalIcon = new ImageIcon("C:\\\\image\\\\test2.jpg");
	ImageIcon la;
	ImageIcon la3;
	ImageIcon la5;
	ImageIcon la6;
	static JTextField tf8 = new JTextField(12);
	JTextField tf11 = new JTextField (20);
	static String col1[] = {"������ȣ","����","����","���ǻ�","��������","������ġ"};
	
	static String col[] = {"ȸ����ȣ","ȸ�� �̸�","ȸ�� ���","��ȭ��ȣ","�뿩�Ⱓ","�뿩Ƚ��","���Ⱑ�� �Ǽ�"};

	static JTextField tf10 = new JTextField(50);
	static JTextField tf12 = new JTextField(50);
	static JTextField tf13 = new JTextField(50);

	JButton btn ;
	JButton btn3 ;
	ImageIcon icon;
	Font fon = new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 16 );
	static JTable table;
	static JTable table1;
	TextField tf = new TextField(10);
	JTabbedPane t1;
	static JTextField tf1 = new JTextField(12);
	static JTextField tf2 = new JTextField(12);
	static JTextField tf3 = new JTextField(12);
	static JTextField tf4 = new JTextField(12);
	static JTextField tf5 = new JTextField(7);
	static JTextField tf6 = new JTextField(13);
	JTextField tf7 = new JTextField(50);
	static JTextField tf9 = new JTextField(12);
	static 	JTextField tf14 = new JTextField(12);
	static JTextField tf15 = new JTextField();
	static JTextField tf16 = new JTextField(12);
	JTextArea ta1 = new JTextArea("ä��â");
	
	static DefaultTableModel model;
	 static DefaultTableModel model1;
	 static JScrollPane scr;
	static JScrollPane scr1;
	
	static JButton lentalbtn = new JButton("�����ϱ�");
	static JFrame frame;
	static Color cor;
	static JTabbedPane t;
	static JPanel  p1 = new JPanel(); ;
	JPanel panel = new JPanel();
	JPanel tabpanel = new JPanel();
	JPanel inpanel1 = new JPanel(); 
	static JPanel panel13 = new JPanel();
	static JPanel panel14 = new JPanel();
	static JLabel label = new JLabel("ȸ�����");
	static JLabel label17 = new JLabel("�������");
	
	static JPanel p = new JPanel();
	JPanel panel15 = new JPanel();
	
	static String row1[][];
	static BrentalMgr mgr2= new BrentalMgr();
	static BooksMgr  mgr1 = new BooksMgr();
	static BMEMBERSMgr mgr = new BMEMBERSMgr();
	static Vector <BooksBean>  vlist1;
	static Vector<BMEMBERSBean> vlist;
	
	
	static Color red = new Color(255,207,253);
	static Color bg = new Color(186,218,255);
	//new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 20) );
	
	
	
	
	public static void viewList() {
		p1.add(label17,BorderLayout.NORTH);
		
		//mgr1 = new BooksMgr();
		vlist1 = mgr1.getListMember();
		
	    row1 = new String[vlist1.size()][12];
		for (int i = 0; i < row1.length; i++) {
			BooksBean bean = vlist1.elementAt(i);
			row1[i][0] = bean.getBID()+"";
			row1[i][1] = bean.getTITLE();
			row1[i][2] = bean.getAUTHOR();
			row1[i][3] = bean.getPUBLISHER();
			row1[i][5] = bean.getLOCATION();
			row1[i][4] = bean.getBOOKSTATE();
		}
		DefaultTableModel model = new DefaultTableModel(row1, col1) {

	           private static final long serialVersionUID = 1L;

	           @Override
	           public Class getColumnClass(int column) {
	               return getValueAt(0, column).getClass();
	           }
	       };
	       table1 = new JTable(model) {

	               private static final long serialVersionUID = 1L;

	               @Override
	               public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
	                   Component c = super.prepareRenderer(renderer, row, column);

	                   if (!isRowSelected(row)) {
	                       if (table1.getColumnCount() >= 0) {
	                           String type = (String)getModel().getValueAt(row,4);
	                           if (type.equals("���Ⱑ��")) {
	                               c.setBackground(Color.white);
	                           }
	                           if (type.equals("���� �Ұ���")) {
	                               c.setBackground(red);
	                           }
	                       }
	                   }
	                   return c;
	               }
	           };
	           table1.setPreferredScrollableViewportSize(new Dimension(597,100));
	       JScrollPane scrollPane = new JScrollPane(table1);
	   	table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	       table1.getColumnModel().getColumn(0).setPreferredWidth(70);  //JTable �� �÷� ���� ����
			table1.getColumnModel().getColumn(1).setPreferredWidth(250);
			table1.getColumnModel().getColumn(2).setPreferredWidth(80);
			table1.getColumnModel().getColumn(3).setPreferredWidth(150);
			table1.getColumnModel().getColumn(4).setPreferredWidth(110);
			table1.getColumnModel().getColumn(5).setPreferredWidth(80);
			JTableHeader header = table1.getTableHeader();            //���̺� ��� ���� 
		    header.setBackground(new  Color(170,220,255));
	       table1.addMouseListener(book);
	       table1.setFont(new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 20) );
		    table1.setRowHeight(25);
		    table1.setSelectionBackground(new Color(7,142,255));
		    table1.setSelectionForeground(Color.white);
	       p1.add(scrollPane);
	}
	
	public static void memlist() {
		p.add(label,BorderLayout.NORTH);
		
	vlist = mgr.getListMember();
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
        JTableHeader header = table.getTableHeader();            //���̺� ��� ���� 
	    header.setBackground(new  Color(170,220,255));
        table.addMouseListener(member);
        table.setFont(new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 20) );
	    table.setRowHeight(25);
	    table.setSelectionBackground(new Color(7,142,255));
	    table.setSelectionForeground(Color.white);
    p.add(scr);
}

	 
	public SwingProject() {
		frame = new JFrame("�������� ���α׷�");
		cor = Color.white;
		p.add(label,BorderLayout.NORTH);
		p1.add(label,BorderLayout.NORTH);
	    t = new JTabbedPane();
		t.setBackground(cor);
		t1 = new JTabbedPane();
		t1.setBackground(cor);
		lentalbtn.setBackground(new Color(116,173,255));
		label.setFont(new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 25) );
		label17.setFont (new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 25) );
		
		
		
		
		
		frame.setLayout(new BorderLayout());
		inpanel1.setLayout(new GridLayout(2,0));
		p1.setLayout(new BorderLayout());
		p.setLayout(new BorderLayout());
		panel.setLayout(new BorderLayout());
		tabpanel.setLayout(new BorderLayout());
		panel13.setLayout(null);
		panel14.setLayout(null);
	
		panel15.setLayout(null);
	
		
		
    panel13.setBackground(bg);
    panel14.setBackground(bg);
    panel.setBackground(bg);
  
    
   
		Testicon ti = new Testicon();
		SwingProject_1 sp_1 = new SwingProject_1();
		SwingProject_2 sp_2 = new SwingProject_2();
		SwingProject_state sp_s = new SwingProject_state();
		//ChartFrame cf = new ChartFrame();
		t.addTab("����/�ݳ�",ti.whome3,t1);
		t.addTab("��������",ti.book3,sp_1.t_1);
		t.addTab("ȸ������",ti.mem3,sp_2.t_2);
		//t.addTab("�̿����",ti.sta3 ,cf);
		
		t.setFont( new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 18) );
		t.setBackground(cor);
		
		
		t1.add("�뿩",panel);
		t1.add("�̿� ��Ȳ / �ݳ�",sp_s.mpanel);
		t1.setFont( new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 18) );
		tabpanel.add(t);
	
		tabpanel.setBackground(bg);
		
		JLabel lab = new JLabel("ȸ�� ��ȣ");
		JLabel lab1= new JLabel("ȸ�� �̸�");
		JLabel lab2= new JLabel("��ȭ ��ȣ");
		JLabel lab3= new JLabel("�뿩 �Ⱓ");
		JLabel lab4= new JLabel("ȸ�� ���");
		JLabel lab5= new JLabel("���Ⱑ�ɱǼ�");
		
		JLabel lab8= new JLabel("���� ��ȣ");
		JLabel lab9= new JLabel("�� ��");
		JLabel lab10= new JLabel("�� ��");
		JLabel lab11= new JLabel("���ǻ�");
		JLabel lab14= new JLabel("ISBN");
		JLabel lab13= new JLabel("���� ��ġ");
		JLabel lab12= new JLabel("���� ����");
		JLabel lab15= new JLabel("������");
		JLabel lab16= new JLabel("�ݳ���");
		
		 btn3 = new JButton();
		JButton btn4 = new JButton("����");
	
		
		
		
	
	
  
	
	
	viewList();// ������� ���̺� ���̰��ϱ�
	memlist();
	
    p.setBackground(bg);
    panel15.setBackground(bg);
    p1.setBackground(bg);
    inpanel1.add(p);
    inpanel1.add(p1);
    panel.add(inpanel1,BorderLayout.WEST);
    
    TitledBorder jtx=                        //Ÿ��Ʋ �������� 
    		new TitledBorder(new LineBorder(cor,5),"ȸ������        ");
    TitledBorder jtx1= 
    		new TitledBorder(new LineBorder(cor,5),"��������       ");

    panel13.setBorder(jtx);
    jtx.setTitleFont(new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 18) );
    jtx1.setTitleFont(new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 18) );
  
    
    lab.setBounds(20, 35, 80, 30);
    lab.setFont(fon);
    panel13.add(lab);
    tf1.setBounds(100, 35, 160, 25);
  panel13.add(tf1);
  lab1.setBounds(290, 35, 80, 30);
  lab1.setFont(fon);
  panel13.add(lab1);
  tf2.setBounds(370, 35, 160, 25);
 panel13.add(tf2);
 
 lab2.setBounds(20, 70, 80, 30);
 lab2.setFont(fon);
 panel13.add(lab2);
 tf3.setBounds(100, 70, 160, 25);
  panel13.add(tf3);
  lab3.setBounds(290, 70, 80, 30);
  lab3.setFont(fon);
  panel13.add(lab3);
  tf4.setBounds(370, 70, 160, 25);
  panel13.add(tf4);
  
  lab4.setBounds(20, 105, 80, 30);
  lab4.setFont(fon);
 panel13.add(lab4);
 tf5.setBounds(100, 105, 160, 25);
  panel13.add(tf5);
  lab5.setBounds(290, 105, 150, 30);
  lab5.setFont(fon);
  panel13.add(lab5);
  tf6.setBounds(400, 105,130, 25);
  panel13.add(tf6);
  

  Image btnimg = normalIcon.getImage();         //��ư�� �̹��� �߰�
  Image change = btnimg.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
  ImageIcon changeicon = new ImageIcon(change);
  JButton btn = new JButton(changeicon);
  
  btn.setBounds(95, 0, 30, 30);
  btn.addActionListener(memberscan);
  panel13.add(btn);
  
  panel14.setBorder(jtx1);
  lab8.setBounds(20, 35, 80, 30);
  lab8.setFont(fon);
  panel14.add(lab8);
  tf8.setBounds(100, 35, 160, 25);
  panel14.add(tf8);
  
  lab9.setBounds(290, 35, 80, 30);
  lab9.setFont(fon);
  panel14.add(lab9);
  tf9.setBounds(370, 35, 160, 25);
  panel14.add(tf9);
  
  lab10.setBounds(20, 70, 80, 30);
  lab10.setFont(fon);
  panel14.add(lab10);
  tf10.setBounds(100, 70, 160, 25);
  panel14.add(tf10);
  
  lab12.setFont(fon);
  lab12.setBounds(290, 70, 80, 30);
  panel14.add(lab12);
  tf12.setBounds(370, 70, 160, 25);
  panel14.add(tf12);
  lab13.setFont(fon);
  
  lab13.setBounds(20, 105, 80, 30);
  panel14.add(lab13);
  tf13.setBounds(100, 105, 160, 25);
  panel14.add(tf13);
  lab11.setBounds(290, 105, 80, 30);
  lab11.setFont(fon);
  panel14.add(lab11);
  panel14.add(lab14);
  tf14.setBounds(370, 105, 160, 25);
  panel14.add(tf14);
  lab14.setBounds(120, 105, 80, 30);
  lab14.setFont(fon);
  panel14.add(lab15);
  lab15.setBounds(20, 140, 80, 30);
  lab15.setFont(fon);
  panel14.add(lab16);
  lab16.setBounds(290, 140, 80, 30);
  lab16.setFont(fon);
  panel14.add(tf15);
  tf15.setBounds(100, 140, 160, 25);
  panel14.add(tf16);
  tf16.setBounds(370, 140, 160, 25);
//  tf15.setBackground(bg);
  
  
  btn3.setBounds(430, 200, 100, 80);
  
  Image btnimg2 = normalIcon.getImage();         //��ư�� �̹��� �߰�
  Image change2 = btnimg2.getScaledInstance(30, 30, Image.SCALE_SMOOTH);
  ImageIcon changeicon2 = new ImageIcon(change2);
  JButton btn3 = new JButton(changeicon2);
  btn3.setBounds(95, 0, 30, 30);
  btn3.addActionListener(bookscan);
  
  
  
  rentalbtn = new JButton(changeicon7);
  rentalbtn.setBorderPainted(false);
	rentalbtn.setFocusPainted(false);
	rentalbtn.setContentAreaFilled(false);
	rentalbtn.addActionListener(this);
	rentalbtn.addMouseListener(rent);
  //anel cp = new ChatClient();//,ä���г� ��ü�����ϰ� �гο� ��� 
  new ChatClient();
  panel14.add(btn3);
  panel14.add(btn4);
  panel15.add(panel13);
  panel15.add(panel14);
  panel15.add(ChatClient.mpanel);
  panel13.setBounds(0, 20, 560, 150);
  panel14.setBounds(0, 180, 560, 180);
  ChatClient.mpanel.setBounds(0,430,560, 260);
  panel15.add(rentalbtn);
  //panel15.add(lentalbtn);
  rentalbtn.setBounds(370, 360, 170, 60);
  //lentalbtn.setBounds(210, 370, 160, 40);
    jtx.setTitleFont(new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 18) );
    jtx1.setTitleFont(new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 18) );
    panel.add(panel15);
  // cpanel.add(ta1);
    ta1.setBounds(20, 30, 500, 260);

    
    
	
	frame.add(tabpanel,BorderLayout.NORTH);
		 frame.setVisible(true);
		 frame.setSize(1200,825);
		 frame.setLocationRelativeTo(null);
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	 
	ActionListener memberscan = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new SwingProject_MemberScanner();
		}
	};
	ActionListener bookscan = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			new SwingProject_bookscanner();
		}
	};
	
	@Override
	public void actionPerformed(ActionEvent e) {   //�����ư ���� �̺�Ʈ
		String cmd = e.getActionCommand();
		if(cmd.equals(rentalbtn.getText())) {
			if(tf1.getText().equals("")) {
			MDialog md = new MDialog(frame,"����", true,"ȸ�������� �����ϴ�.");
			md.setVisible(true);
			}else if (tf8.getText().equals("")) {
				MDialog md1 = new MDialog(frame,"����", true,"���������� �����ϴ�.");
				md1.setVisible(true);
		}else if(tf1.getText().equals("1")&&tf12.getText().equals("����")) {
			MDialog md2 = new MDialog(frame,"���ȸ�� �Դϴ�", true,"���� �޾ư�����.");
			md2.setVisible(true);
		}else if(tf6.getText().equals("0")) {
		    MDialog md = new MDialog(frame, "����", true, "���Ⱑ�ɱǼ� �ʰ��Դϴ�.");
		    md.setVisible(true);
		
		}else if(tf12.getText().equals("���Ⱑ��")) {  //�������̺�� ���� �Է�
			BrentalBean bean = new BrentalBean();
			int to = Integer.parseInt(tf1.getText());   //���ڿ� ������ ��ȯ 
			int to2 = Integer.parseInt(tf8.getText());   //���ڿ� ������ ��ȯ 
		     bean.setRMID(to);
			bean.setRNAME(tf2.getText());
			bean.setBMID(to2);
			bean.setBTITLE(tf9.getText());
			bean.setRENTAL(tf15.getText());
			bean.setENDRENTAL(tf16.getText());
			if(mgr2.insertBrental(bean)) {
				SwingProject_state.tpanel.removeAll();
				SwingProject_state.tpanel.revalidate();
				SwingProject_state.vlist.removeAllElements();
				SwingProject_state.viewstate();
				
			}
			BMEMBERSBean mbean = new BMEMBERSBean();
			String str3 = (String)(table.getValueAt(table.getSelectedRow(),5));
			int to6 = Integer.parseInt(str3);
			String str4 = (String)(table.getValueAt(table.getSelectedRow(),6));
			int to7 = Integer.parseInt(str4);
			mbean.setMID(to);
			mbean.setECOUNT(to6+1);   //����Ƚ�� +1
			mbean.setELIMIT(to7-1);     // �뿩���� �Ǽ� -1 
			if(mgr.stateupdateBMEMBERS(mbean)) {
				p.removeAll();
				p.revalidate();
				vlist.removeAllElements();
				memlist();
			}
			
			BooksBean bean3 = mgr1.getett(to2);    //������ȣ�� �˻��Ͽ� ���� ����Ƚ�� ��������
			int bcount = bean3.getBCOUNT();
			
			BooksBean bean2 = new BooksBean();  //����� ����Ұ���,����Ƚ��+1 �ϱ�
			bean2.setBOOKSTATE("���� �Ұ���");
			bean2.setBCOUNT(bcount+1); 
			bean2.setBID(to2);                 //�����ϰ�
			if(mgr1.stateupdateBooks(bean2)) { //�����Ѱ����� �����ϱ�
				p1.removeAll();
				p1.revalidate();
				vlist1.removeAllElements();
				viewList();
			} 
			
			//���� �ѵ� ��� �ؽ�Ʈ�ʵ尪 �ʱ�ȭ
			tf1.setText("");
			tf2.setText("");
			tf3.setText("");
			tf4.setText("");
			tf5.setText("");
			tf6.setText("");
			tf8.setText("");
			tf9.setText("");
			tf10.setText("");
			tf12.setText("");
			tf13.setText("");
			tf14.setText("");
			tf15.setText("");
			tf16.setText("");
			
			
			MDialog md2 = new MDialog(frame,"����", true,"���� �Ǿ����ϴ�.");
			md2.setVisible(true);
			
			
			
		}else {
			MDialog md2 = new MDialog(frame,"����", true,"���� �Ұ��� �Դϴ�");
			md2.setVisible(true);
		}
	}
}
	static MouseListener member = new MouseListener() {       //ȸ������� ������  �����ʿ� ������
	@Override
	public void mouseClicked(MouseEvent arg0) {
		String str0 = (String) table.getValueAt(table.getSelectedRow(),0);            //Object Ÿ���� ��� ���������� ��ȯ
		String str1 = (String) table.getValueAt(table.getSelectedRow(),1);            //Object Ÿ���� ��� ���������� ��ȯ
		String str2 = (String) table.getValueAt(table.getSelectedRow(),2);
		String str3 = (String) table.getValueAt(table.getSelectedRow(),3);
		String str4 = (String) table.getValueAt(table.getSelectedRow(),4);
		String str5 = (String) table.getValueAt(table.getSelectedRow(),6);
		
		tf1.setText(str0);
		tf2.setText(str1);
		tf3.setText(str3);
		tf4.setText(str4);
		tf5.setText(str2); 
		tf6.setText(str5);
		if(str5.equals("0")) {
			tf6.setBackground(red);
			Runnable tt = new MemThread();
			Thread t1 = new Thread(tt);
			t1.start();
		}else if(!str5.equals("0")) {
			tf6.setBackground(Color.white);
		}
		
		if(str5.equals("0")||tf12.getText().equals("���� �Ұ���")) {
			lentalbtn.setBackground(red);
		}else {
			lentalbtn.setBackground(new Color(116,173,255));
		}
		SimpleDateFormat sysdate = new SimpleDateFormat();
		Calendar date = Calendar.getInstance();
		
		String date2 = sysdate.format(date.getTime()); //���ڿ��� ���ó�¥ ���� 
		tf15.setText(date2.substring(0,10));  //�뿩��¥ĭ�� ���ó�¥ �Է�
		
		int to = Integer.parseInt(tf4.getText().substring(0, 1));   //���ڿ��� ������ ��ȯ 
		date.add(Calendar.DATE,to);   
		String date3 = sysdate.format(date.getTime()); //���ѳ�¥ ���ڿ� �ֱ�
		
		tf16.setText(date3.substring(0,10));  //�ݳ���¥ �ú��� �ڸ��� �ֱ� 
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
	
static MouseListener book = new MouseListener() {            //��������� ������ �����ʿ� ������
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mousePressed(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseClicked(MouseEvent e) {
			String str00 = (String) table1.getValueAt(table1.getSelectedRow(),0);            //Object Ÿ���� ��� ���������� ��ȯ
			String str11 = (String) table1.getValueAt(table1.getSelectedRow(),1);            //Object Ÿ���� ��� ���������� ��ȯ
			String str22 = (String) table1.getValueAt(table1.getSelectedRow(),2);
			String str33 = (String) table1.getValueAt(table1.getSelectedRow(),3);
			String str44 = (String) table1.getValueAt(table1.getSelectedRow(),4);
			String str55 = (String) table1.getValueAt(table1.getSelectedRow(),5);
			tf8.setText(str00); 
			tf9.setText(str11);
			tf10.setText(str22);
			tf12.setText(str44);
			if(str44.equals("���� �Ұ���")) {
				tf12.setBackground(red);
				Runnable tt = new BookThread();
				Thread t1 = new Thread(tt);
				t1.start();
			}else if(str44.equals("���Ⱑ��")) {
				tf12.setBackground(Color.white);
			}
			if(tf6.getText().equals("0")||tf12.getText().equals("���� �Ұ���")) {
				lentalbtn.setBackground(red);
			}else {
				lentalbtn.setBackground(new Color(116,173,255));
			}
			tf14.setText(str33); 
			tf13.setText(str55);
			tf8.select(0, 0);
			tf9.select(0, 0);   //�ؽ�Ʈ ���ʺ��� �������� 
			tf10.select(0, 0);
			tf12.select(0, 0);
			tf14.select(0, 0);
			tf13.select(0, 0);
			
			//������ ��¥�� ��ȯ�ϴ� �Լ� �����Ͽ� �߰����� Ŭ���� �ڵ����� ���ó�¥ ��ȯ 
			SimpleDateFormat sysdate = new SimpleDateFormat();
			Calendar date = Calendar.getInstance();
			String date2 = sysdate.format(date.getTime()); //���ڿ��� ���ó�¥ ���� 
			tf15.setText(date2.substring(0,10));         //���ó�¥ �ú��� �ڸ��� ����
			
			if(tf4.getText().equals("")) {}   // �뿩�Ⱓ ĭ�� ����ִٸ� ������� 
			else {  //�뿩�Ⱓ ĭ�� ä�����ִٸ� ��¥ �����Ͽ� �ݳ����� ���� 
			int to = Integer.parseInt(tf4.getText().substring(0, 1));   //���ڿ��� ������ ��ȯ 
			date.add(Calendar.DATE,to);        //���� ��¥�� �ϼ� ���ϱ�
			String date3 = sysdate.format(date.getTime()); //���ѳ�¥ ���ڿ� �ֱ�
			tf16.setText(date3.substring(0,10));  //�ú��� �ڸ��� �ֱ� 
			}
			
		}	
};
MouseListener rent = new MouseListener() {
	
	@Override
	public void mouseReleased(MouseEvent e) {
		rentalbtn.setIcon(changeicon6);
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		rentalbtn.setIcon(changeicon8);
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		rentalbtn.setIcon(changeicon7);
	
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		rentalbtn.setIcon(changeicon6);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
	}
};
	public static void main(String[] args) {
		new SwingProject();
	}
	

}
