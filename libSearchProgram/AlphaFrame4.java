package libSearchProgram;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class AlphaFrame4 extends JFrame implements Runnable{
	private static int count = 0;
	private AlphaComposite alphaComposite;
	public Image image;
	
	public AlphaFrame4()  {
		/*image = Toolkit.getDefaultToolkit().getImage("C:\\Image\\vlikeA.png"); //원하는 이미지
		
		setSize(300, 300);
		setUndecorated(true);
		setBackground(new Color(0,0,0,0));
		setTitle("제발");
		setLocationRelativeTo(null);
		setVisible(true);
		 dispose();*/
	}
	
	public void paint(Graphics g){
		
		
			alphaComposite = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1-((float)0.95)); //alpha값 0.1~1
		    Graphics2D g2 = (Graphics2D)g;
		    g2.setComposite(alphaComposite);
		    g2.drawImage(image, 0, 0, this);
		    
	//Timer timer = new Timer();
	//TimerTask task = new TimerTask() {
		
		/*@Override
		public void run() {
			     count++;
			     if (count == 3) {
			         timer.cancel();
			         dispose();
			         return;
			     }
			}*/
	//};
	//timer.schedule(task, 1500);
	}
	
	
	public static void main(String[] args) {
		new AlphaFrame4();
	}

	@Override
	public void run() {
		image = Toolkit.getDefaultToolkit().getImage("C:\\Image\\vlikeA.png"); //원하는 이미지
		
		setSize(300, 300);
		setUndecorated(true);
		setBackground(new  Color(0,0,0,0));
		setTitle("제발");
		setLocationRelativeTo(null);
		setVisible(true);
		for (int i = 0; i < 100; i++) {
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		 dispose();
	}
}
