package JAVAP;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class ChartPanel03 extends JPanel {
	
	Color beige = new Color(255, 229, 178);//#ffe5b2
	Color skyBlue = new Color(89, 158, 255);//#599eff
	Color ashe = new Color(212, 212, 212);//#d4d4d4
	Color asheAlpha = new Color(212, 212, 212, 55);//#d4d4d4 ���İ�55
	Color magenta = new Color(255, 0, 255);//ff00ff
	
	Color darkYellow = new Color(230, 212, 18);//#e6d412
	Color mint = new Color(93, 201, 188);//5dc9bc
	Color darkMint = new Color(38, 148, 137);//ff00ff
	Color wine = new Color(198, 58, 57);//c63a39
	Color orange = new Color(246, 112, 74);//ff00ff
	
	public ChartPanel03() {
		TitledBorder tB3 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true),"���� ���");
		tB3.setTitleFont(new Font("��Ǯ���¿��� Medium", Font.BOLD, 15));
		TitledBorder tB4 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		Draw3 drawP3 = new Draw3();//�׸��� �г� (���г�)
		JPanel info2 = new JPanel();//drawP3 �ȿ� �� �����г� (����)
		JPanel info1 = new JPanel();//drawP3 �ȿ� �� �����г� (����)
		Font lbFont = new Font("��Ǯ���¿��� Medium", Font.PLAIN, 12);//��Ʈ ����
		
		drawP3.setBorder(tB3);
		drawP3.setLayout(null);
		drawP3.setBounds(10, 10, 570, 310);
		drawP3.setBackground(Color.WHITE);
		//�ϴ� ���� 4�� ���� �г� (���� ���� ������, �̸�, �ۼ�������)/////////////////////////////////////////////////////
		info1.setBounds(10, 240, 290, 60);
		info1.setLayout(null);
		info1.setBackground(Color.WHITE);
		ImageIcon iconColor[] = {
				new ImageIcon("C:\\image\\ICON\\darkyellow.png"),
				new ImageIcon("C:\\image\\ICON\\mint.png"),
				new ImageIcon("C:\\image\\ICON\\darkmint.png"),
				new ImageIcon("C:\\image\\ICON\\wine.png")};
		String[] cateTop4 = {"����", "����", "��ȸ��", "ö��"}; //���� ���̿� ���� ��ġ�� �ָ��ؼ� �� ���� ������ �ݺ��� ����
		JLabel[] cateLb = new JLabel[2];
		JLabel[] iconLb = new JLabel[2];
		int[] per = {32,15,12,10};
		for (int i = 0; i < cateLb.length; i++) {
			iconLb[i] = new JLabel(iconColor[i]);
			iconLb[i].setBounds(60+i*90, 10, 12, 20);
			cateLb[i] = new JLabel(cateTop4[i]+"  "+per[i]+"%");
			cateLb[i].setBounds(74+i*90, 10, 100, 20);
			cateLb[i].setFont(lbFont);
			info1.add(iconLb[i]);
			info1.add(cateLb[i]);
		}
		for (int i = 0; i < cateLb.length; i++) {
			iconLb[i] = new JLabel(iconColor[i+2]);//[i+2]�� �� 2ĭ�迭�� �̹���, ���ڿ� 4ĭ�迭�� ���� ����
			iconLb[i].setBounds(60+i*90, 30, 12, 20);
			cateLb[i] = new JLabel(cateTop4[i+2]+"  "+per[i+2]+"%");
			cateLb[i].setBounds(74+i*90, 30, 100, 20);
			cateLb[i].setFont(lbFont);
			info1.add(iconLb[i]);
			info1.add(cateLb[i]);
		}
		////////////////////////////////////////////////////////////////////////////////////////
		//���� ���� 6�� ���� �г� (���� ���� ������, �̸�, �ۼ�������)///////////////////////////////////////////////////// 
		info2.setBounds(300, 20, 90, 140);
		info2.setLayout(null);
//		info2.setBackground(Color.WHITE);
		JLabel[] cateLb2 = new JLabel[6];
		String[] cateOther = {"�ڿ�����", "�������", "����", "���", "����", "�ѷ�"};
		int[] per2 = {9,8,6,4,3,1};
		for (int i = 0; i < cateLb2.length; i++) {
			cateLb2[i] = new JLabel(cateOther[i]+" "+per2[i]+"%");
			cateLb2[i].setBounds(10, 10+i*20, 100, 20);
			cateLb2[i].setFont(lbFont);
			info2.add(cateLb2[i]);
		}
		
		drawP3.add(info1);
		drawP3.add(info2);
		add(drawP3);
		
		setVisible(true);
		setBackground(Color.WHITE);
	}
	class Draw3 extends JPanel{
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			Graphics2D g2=(Graphics2D)g;//XY�� ���β�
			g2.setStroke(new BasicStroke(3,BasicStroke.CAP_SQUARE,0));
			
			int pieX = 50;
			int pieY = 30;
			int pieSize = 200;
			
			//���� 1 (21%) //�� ������ �� �Ҽ��� ����
			//int startAngle = ������ �ޱ�
			//int angle[1 2 3 4] = �׸� ����
			g2.setColor(darkYellow);
			g2.fillArc(pieX, pieY, pieSize, pieSize, 90, 115);
			
			//����2 (12%)
			g2.setColor(mint);
			g2.fillArc(pieX, pieY, pieSize, pieSize, 90+115, 54);
			
			//����3 (11%)
			g2.setColor(darkMint);
			g2.fillArc(pieX, pieY, pieSize, pieSize, 205+54, 43);
			
			//����4 (10%)
			g2.setColor(wine);
			g2.fillArc(pieX, pieY, pieSize, pieSize, 259+43, 36);
			
			//����5 (������) // �׸� ���� ������ �ؼ� ���ֱ�
			g2.setColor(asheAlpha);
			g2.fillArc(pieX, pieY, pieSize, pieSize, 302+36 ,360-115-54-43-36);
			
			//������ ���� ���� �����гΰ� ������ �׸���
			g2.setColor(Color.LIGHT_GRAY);
			g2.drawLine(180, 80, 235, 40);
			g2.drawLine(235+1, 40-1, 285, 40-1);
		}
	}
}
