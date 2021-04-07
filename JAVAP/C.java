package JAVAP;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class C extends  JFrame {
	
	JButton btn;
	public C() {
		
		setSize(200,299);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
	
		btn = new JButton(new ImageIcon("C:\\\\\\\\image\\\\send.jpg")); 	
		btn.setBackground(Color.red);
		
		btn.setBorderPainted(false);
		btn.setFocusPainted(false);
		btn.setContentAreaFilled(false);
		btn.addActionListener(ac);
		btn.setSize(new Dimension(100,100));
		add(btn);
		setVisible(true);
		
	
	
	}
	ActionListener ac =new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btn) {
				System.out.println("asd");
			}
		}
	};
	public static void main(String[] args) {
		new C();
	}
	
	
	
	
	
	
	
	
}
	 