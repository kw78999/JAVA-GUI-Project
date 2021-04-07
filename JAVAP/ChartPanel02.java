package JAVAP;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class ChartPanel02 extends JPanel {
	Color beige = new Color(255, 229, 178);//#ffe5b2
	Color skyBlue = new Color(89, 158, 255);//#599eff
	Color ashe = new Color(212, 212, 212);//#d4d4d4
	Color magenta = new Color(255, 0, 255);//ff00ff
	Draw2 drawP2;
	
	public ChartPanel02() {}
	
	public ChartPanel02(String month,String year) {
		
		
		paint(month,year);
	}
	
	
	
	void paint(String month,String year) {
	
		drawP2 = new Draw2(month,year);	//�Ʒ��� Ŭ������ ����� �� �׷��� �г�
		drawP2.removeAll();
		drawP2.revalidate();
		drawP2.repaint();
		JLabel lb3;  									//�׷��� Y�� ����ǥ��
		TitledBorder tB2 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true),"������");//�г� �ܰ��� �ٹ̱� ����
		tB2.setTitleFont(new Font("��Ǯ���¿��� Medium", Font.BOLD, 15));
		Font lbFont = new Font("Times", Font.ITALIC, 12);// Y�� ���� ��Ʈ ����
		Font infoFont = new Font("��Ǯ���¿��� Medium", Font.PLAIN, 12);
		//�׷��� �г� �����ʿ� ���� �����г�(������� ������, �̸�)////////////////////////////////
		JPanel info = new JPanel();
		info = new JPanel();
		info.setLayout(null);
		info.setBounds(380, 20, 180, 280);
		info.setBackground(Color.WHITE);
		//////////////////////////////////////////////////////////////////
//		ImageIcon iconColor[] = {
//				new ImageIcon("graphEx3/copy/magenta.png"),
//				new ImageIcon("graphEx3/copy/skyblue.png"),
//				new ImageIcon("graphEx3/copy/beige.png"),
//				new ImageIcon("graphEx3/copy/ashe.png")};
		ImageIcon iconColor1 = new ImageIcon("graphEx3/copy/magenta.png");
		ImageIcon iconColor2 = new ImageIcon("graphEx3/copy/skyblue.png");
		ImageIcon iconColor3 = new ImageIcon("graphEx3/copy/beige.png");
		ImageIcon iconColor4 = new ImageIcon("graphEx3/copy/ashe.png");
		
		
		LibStatMgr mgr = new LibStatMgr();
		LibStatBean bean = mgr.getMonthStat1();
		String name1 = bean.getFst();
		String name2 = bean.getSnd();
		String name3 = bean.getThd();
		JLabel lbName1 = new JLabel(name1);
		JLabel lbName2 = new JLabel(name2);
		JLabel lbName3 = new JLabel(name3);
		JLabel lbName4 = new JLabel("ȸ�����");
		JLabel lbIcon1 = new JLabel(iconColor1);
		JLabel lbIcon2 = new JLabel(iconColor2);
		JLabel lbIcon3 = new JLabel(iconColor3);
		JLabel lbIcon4 = new JLabel(iconColor4);
		System.out.println(name1+name2+name3);
		lbIcon1.setBounds(63, 20+20*0, 12, 12);
		info.add(lbIcon1);
		lbIcon1.setBounds(63, 20+20*1, 12, 12);
		info.add(lbIcon2);
		lbIcon1.setBounds(63, 20+20*2, 12, 12);
		info.add(lbIcon3);
		lbIcon1.setBounds(63, 20+20*3, 12, 12);
		info.add(lbIcon4);
		
		lbName1.setBounds(80, 20+20*0, 100, 12);
		lbName1.setFont(infoFont);
		info.add(lbName1);
		lbName2.setBounds(80, 20+20*1, 100, 12);
		lbName2.setFont(infoFont);
		info.add(lbName2);
		lbName3.setBounds(80, 20+20*2, 100, 12);
		lbName3.setFont(infoFont);
		info.add(lbName3);
		lbName4.setBounds(80, 20+20*3, 100, 12);
		lbName4.setFont(infoFont);
		info.add(lbName4);
		
		
//�׷��� ���� ���� (�г� ���� �������гο� �� �����ܰ� �̸�)/////////////////////////////
//		String name[] = {"õ���", "�ֹμ�", "�̰���", "ȸ�� ���"};
//		JLabel lbName[] = new JLabel[4];
//		JLabel lbIcon[] = new JLabel[4];
//		for (int i = 0; i < iconColor.length; i++) {//�����гο� ���� ��������ܰ� �̸��� ���� �ݺ���
//			lbIcon[i] = new JLabel(iconColor[i]);			//������
//			lbIcon[i].setBounds(63, 20+20*i, 12, 12);
//			info.add(lbIcon[i]);
//			lbName[i] = new JLabel(name[i]);				//�̸�
//			lbName[i].setBounds(80, 20+20*i, 100, 12);
//			lbName[i].setFont(infoFont);
//			info.add(lbName[i]);
//		}////////////////////////////////////////////////////////////////
//		//Y�࿡ �� ����/////////////////////////////////////////////////////
//		String point[] = {"  3","  6","  9","12","15"};
//		JLabel lbPoint[] = new JLabel[5];
//		for (int i = 0; i < lbPoint.length; i++) {
//			lbPoint[i] = new JLabel(point[i]);
//			lbPoint[i].setBounds(60, 220-30*i, 20, 10);
//			drawP2.add(lbPoint[i]);
//		}////////////////////////////////////////////////////////////////
		//�׷��� �׸��� �г�/////////////////////////////////////////////////////
		drawP2.setBorder(tB2);
		drawP2.setLayout(null);
		drawP2.setBounds(10, 10, 570, 310);
		drawP2.setBackground(Color.WHITE);
		/////////////////////////////////////////////////////////////////
		lb3 = new JLabel("(����: ��)");
		lb3.setFont(lbFont);
		lb3.setBounds(20, 80, 100, 18);
		
		drawP2.add(lb3);
		drawP2.add(info);
		add(drawP2);
		
		setVisible(true);
		setBackground(Color.WHITE);
		drawP2.repaint();
	}
	








	class Draw2 extends JPanel{
		String month;
		String year;
		public Draw2() {
		}
		
		public Draw2(String month,String year) {
			this.month = month;
			this.year = year;
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int readGold = 15; //����1 �� DB���� ���� �� ������ �Ǽ� ��������
			int readSilver = 14;//2
			int readBronze = 13;//3
			int readAVG = 8;//���
			
			LibStatMgr mgr = new LibStatMgr();
			LibStatBean bean = mgr.getMonthStat(month,year);
			int gold = bean.getFstCnt();
			int silver = bean.getSndCnt();
			int bronze = bean.getThdCnt();
			int avg = bean.getAvgCnt();
			System.out.println("ȣ���"+avg+"avg"+gold+silver+bronze);
			
			
			Graphics2D g2=(Graphics2D)g;//XY�� ���β�
			g2.setStroke(new BasicStroke(3,BasicStroke.CAP_SQUARE,0));
			g2.setColor(Color.LIGHT_GRAY);
			g2.drawLine(70,250+1,370,250+1);//X��. �׷����� Y��ǥ�� ������ ���� �Ʒ��� X���� �������� ������ X���� Y��ǥ�� +1 ���ش�.
			//�׷��� ���� ���м�///////////////////////////////////////////////////////////
			g2.setStroke(new BasicStroke(2, BasicStroke.CAP_SQUARE,0));
			g2.setColor(new Color(228, 235, 247));
			for (int i = 0; i < 5; i++) {
				g2.drawLine(80, 220-30*i, 360, 220-30*i);
			}//////////////////////////////////////////////////////////////////////
			//������ (��üȸ�� ��� ������)////////////////////////////////////////////////////
			g2.setColor(ashe);
			g2.fillRect(80+60, 250-avg*10, 20, avg*10); //�������� ���̿� ������ ���� �ؾ���
			g2.fillRect(80+140, 250-avg*10, 20, avg*10); //��Ģ������ �þ
			g2.fillRect(80+220, 250-avg*10, 20, avg*10);//Y �������� ���� ���̿��� ���� ������ �Ʒ��� �׸��� ����
			
			//���� 1
			g2.setColor(magenta);
			g2.fillRect(80+40, 250-gold*10, 20, gold*10); //*10�� �ؼ� 1���� 1px�� �ƴ� 10px��ŭ �������� �������ִ� ����
			
			//���� 2
			g2.setColor(skyBlue);
			g2.fillRect(80+120, 250-silver*10, 20, silver*10);
			
			//���� 3
			g2.setColor(beige);
			g2.fillRect(80+200, 250-bronze*10, 20, bronze*10);
		
		}
	}
}
