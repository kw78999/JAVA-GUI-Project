package JAVAP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.Panel;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TTest {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		Panel p = new Panel();
		Panel p1 = new Panel();
		
		f.setLayout(new BorderLayout());
		JLabel label = new JLabel("11");
		JButton btn = new JButton(new ImageIcon("aaa0.PNG"));
		JButton btn1 = new JButton(" me");
		JButton btn2 = new JButton("asdasd");
		f.add(btn);
		
	 //  f.add(p1);
		
		
		
		
		
		
		f.setResizable(false);
		f.setVisible(true);
		f.setPreferredSize(new Dimension(840,840/12*8));
		f.setSize(840,840/12*8);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
