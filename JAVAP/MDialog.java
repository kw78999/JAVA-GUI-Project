package JAVAP;

import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

class MDialog extends Dialog implements ActionListener{          //���̾�α� ����Ŭ����
	
	JButton b;
	JLabel lab1;
	public MDialog(Frame f,String title,boolean modal,String str) {  //modal�� awt������ �����̴� 
		super (f,title,modal);
		setLayout(null);
		 b= new JButton ("Ȯ��");
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
	dispose();  //��ư ������ ���̾�αװ� �������.
	}
}
