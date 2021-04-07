package JAVAP;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

class MDialog extends Dialog implements ActionListener{          //다이얼로그 내부클래스
	
	JButton b;
	JLabel lab1;
	public MDialog(Frame f,String title,boolean modal,String str) {  //modal은 awt끼리의 관계이다 
		super (f,title,modal);
		setLayout(null);
		 b= new JButton ("확인");
		 lab1 = new JLabel(str);
		 b.setBounds(160, 160, 80, 40);
		 lab1.setBounds(70, 50, 400, 50);
		 lab1.setFont(new Font( "Times", Font.BOLD, 21));
		 b.addActionListener(this);
		 setBounds(700,360,400,250);
		 add(lab1);
		 add(b);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	dispose();  //버튼 누르면 다이얼로그가 사라진다.
	}
}
