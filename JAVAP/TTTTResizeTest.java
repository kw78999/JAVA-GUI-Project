package JAVAP;

import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class TTTTResizeTest {

	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	       Image img = icon.getImage();  
	       Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	       return new ImageIcon(resizedImage);
	}//1. �޼ҵ� �߰�
	
	public TTTTResizeTest() {
		JFrame frame2 = new JFrame("Tauler Joc");
		JPanel panell = new JPanel();
		ImageIcon icon = new ImageIcon("libFrame/printericon.png");
		JButton jb= new JButton();
		panell.setLayout(null);

		jb.setBounds(200,200,150,150);//2. ��ư ������ ����
		panell.add(jb);

		//3. ��ư����� �̹��� ����ֱ�
		int offset = jb.getInsets().left;
		jb.setIcon(resizeIcon(icon, jb.getWidth() - offset, jb.getHeight() - offset));

		
		frame2.setSize(1200, 700);
		frame2.add(panell);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
		frame2.setVisible(true);
	}
	
	
	
	public static void main(String[] args) {
		new TTTTResizeTest();
	}

}
