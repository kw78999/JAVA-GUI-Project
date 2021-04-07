package JAVAP;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class ChartFrame extends JPanel{

	String year[] = {"20년", "19년"};
	String month[] = {"10월","09월","08월","07월","06월","05월","04월","03월","02월","01월"};
	JComboBox<String> cbYear = new JComboBox<String>(year);
	JComboBox<String> cbMonth = new JComboBox<String>(month);
	
	Color beige = new Color(255, 229, 178);//#ffe5b2
	Color skyBlue = new Color(89, 158, 255);//#599eff
	Color ashe = new Color(212, 212, 212);//#d4d4d4
	Color magenta = new Color(255, 0, 255);//ff00ff
	
	JPanel southPanel = new JPanel();
	JPanel northPanel = new JPanel();
	ChartPanel01 p1 = new ChartPanel01();
	ChartPanel02 p2 ;
	ChartPanel03 p3 = new ChartPanel03();
	static JPanel p4 = new JPanel();
	static JTextField ctf = new JTextField("",50);
	static JTextArea cta = new JTextArea();
	static JButton cbtn = new JButton("보내기");
	static JScrollPane chatScroll ;
//	Container c;
	
	static Color bg = new Color(186,218,255);
	//new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 20) );
	public ChartFrame(){
		northPanel.setBounds(0,0,1200, 50);
		northPanel.setLayout(null);
		northPanel.setBackground(bg);
		JButton btn1 = new JButton("도표");
		btn1.setBounds(800, 20, 80, 20);
		northPanel.add(btn1);
		btn1.addActionListener(CallXl);
		
		cbYear.setBounds(15, 15, 100, 20);
		cbMonth.setBounds(125, 15, 100, 20);
		northPanel.add(cbMonth);
		northPanel.add(cbYear);
		cbMonth.addActionListener(repaintChart);
		
		southPanel.setBounds(0,50,1200, 700);
		southPanel.setLayout(null);
		southPanel.setBackground(bg);
		//setTitle("Grid");
	//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1200, 700);
	//	setLocationRelativeTo(null);
	//	GridLayout grid = new GridLayout(2, 2);
	//	Container c = getContentPane();
      setLayout(null);
		TitledBorder tB1 = new TitledBorder(new LineBorder(Color.white, 3, true),"독서왕");
		tB1.setTitleFont(new Font("잘풀리는오늘 Medium", Font.PLAIN, 15));
		p1 = new ChartPanel01();
		p1.setLayout(null);
		
		String s1 = (String) cbMonth.getSelectedItem();
		String s2 = (String) cbYear.getSelectedItem();
		p2 = new ChartPanel02(s1, s2);
		p2.setLayout(null);
		
		p3 = new ChartPanel03();
		p3.setLayout(null);
		
		p4 = new JPanel();
		p4.setLayout(null);
		p4.setBackground(bg);
		TitledBorder jtx1=          //검색창 보더
 	    		new TitledBorder(new LineBorder(Color.white,5),"회원과의 채팅");
 		 jtx1.setTitleFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 18) );
 		 p4.setBorder(jtx1);
 		chatScroll = new JScrollPane(cta);
 		
 		
		ChatAction ca = new ChatAction();
		cta.setEnabled(false);
		  cbtn.addActionListener(ca.acc);
		  ctf.addActionListener(ca.acc);
		  cbtn.setBounds(470, 220, 80,30);
		  ctf.setBounds(20, 220, 450, 30);
		  chatScroll.setBounds(20,30	, 530, 190);
		  chatScroll.setBackground(bg);
		  p4.add(cbtn);
		  p4.add(ctf);
		  p4.add(chatScroll);
		 p1.setBackground(bg);
	     p2.setBackground(bg);
         p3.setBackground(bg);
	   	p4.setBackground(bg);
		setBackground(bg);
		southPanel.add(p1);
		p1.setBounds(0, 0, 600, 350);
		p2.setBounds(600, 0, 600, 350);
		p3.setBounds(0, 350, 600, 350);
		southPanel.add(p2);
		southPanel.add(p3);
		southPanel.add(p4);
		p4.setBounds(602, 420, 570, 260);
		add(northPanel);
		add(southPanel);
		
		setVisible(true);
	}
	
ActionListener CallXl = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			new ExcelFrame();
		}
	};
	
	ActionListener repaintChart = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("차트 123 리페인트 메소드 호출하기");
			p2.removeAll();
			p2.revalidate();
			String s1 = (String) cbMonth.getSelectedItem();
			String s2 = (String) cbYear.getSelectedItem();
		    p2 = new ChartPanel02(s1, s2);
		    System.out.println(s1+s2);
		//	p2.removeAll();
		}
		
	};
	
	
	
//	
//	public static void main(String[] args) {
//		new ChartFrame();
//	}
}
