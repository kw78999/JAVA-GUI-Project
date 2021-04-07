package JAVAP;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class ChatClient {
	
	static JTextField ctf = new JTextField("",50);
	static JTextArea cta = new JTextArea();
	static Color cor= Color.white;
	static String id;
	static JScrollPane chatScroll ;
	static Socket socket;
	static JPanel mpanel = new JPanel();
	static Color red = new Color(255,207,253);
	static Color bg = new Color(186,218,255);
	//static Color bg = new Color(186,218,255);
	//new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 20) );
	static TitledBorder jtx2;
	static LineBorder lb = new LineBorder(cor,5);
	
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
	  
	  
	public ChatClient() {
		  
		  
		  
		cbtn = new JButton(changeicon);
		 cbtn.setBorderPainted(false);
			cbtn.setFocusPainted(false);
			cbtn.setContentAreaFilled(false);
		 
		 jtx2=                       
		    		new TitledBorder(lb,"회원과의 채팅");
		  jtx2.setTitleFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 18) );
		
		  mpanel.setLayout(null);
		  mpanel. setBackground(bg);
		  mpanel. setBorder(jtx2);
		  chatScroll = new JScrollPane(cta);
		  //ChatAction ca = new ChatAction();
		  
				
		  //cta.setEnabled(false);
		  cta.setForeground(Color.black);
		  
		  //cbtn.addActionListener(ca.acc);
			cbtn.setBackground(bg);   //떄문에 글자가 파란색인가?
		 // ctf.addActionListener(ca.acc);
		  cbtn.setBounds(455, 220, 80,30);
		  ctf.setBounds(20, 220, 435, 30);
		  chatScroll.setBounds(20,30	, 515, 190);
		  cbtn.addMouseListener(send);
		  mpanel.add(cbtn);
		  mpanel. add(ctf);
		  mpanel. add(chatScroll);
		  mpanel. validate();//갱신
		 // ca.connect();  //생성과 동시에 서버와 커넥트 
		//  ca.out.println("관리자");
		  }

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
}
	

	
	
	
	
	
	

