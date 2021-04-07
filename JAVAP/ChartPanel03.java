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
	Color asheAlpha = new Color(212, 212, 212, 55);//#d4d4d4 알파값55
	Color magenta = new Color(255, 0, 255);//ff00ff
	
	Color darkYellow = new Color(230, 212, 18);//#e6d412
	Color mint = new Color(93, 201, 188);//5dc9bc
	Color darkMint = new Color(38, 148, 137);//ff00ff
	Color wine = new Color(198, 58, 57);//c63a39
	Color orange = new Color(246, 112, 74);//ff00ff
	
	public ChartPanel03() {
		TitledBorder tB3 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true),"도서 통계");
		tB3.setTitleFont(new Font("잘풀리는오늘 Medium", Font.BOLD, 15));
		TitledBorder tB4 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		Draw3 drawP3 = new Draw3();//그리기 패널 (통패널)
		JPanel info2 = new JPanel();//drawP3 안에 들어갈 정보패널 (우측)
		JPanel info1 = new JPanel();//drawP3 안에 들어갈 정보패널 (우측)
		Font lbFont = new Font("잘풀리는오늘 Medium", Font.PLAIN, 12);//폰트 정의
		
		drawP3.setBorder(tB3);
		drawP3.setLayout(null);
		drawP3.setBounds(10, 10, 570, 310);
		drawP3.setBackground(Color.WHITE);
		//하단 상위 4개 정보 패널 (파이 색깔 아이콘, 이름, 퍼센테이지)/////////////////////////////////////////////////////
		info1.setBounds(10, 240, 290, 60);
		info1.setLayout(null);
		info1.setBackground(Color.WHITE);
		ImageIcon iconColor[] = {
				new ImageIcon("C:\\image\\ICON\\darkyellow.png"),
				new ImageIcon("C:\\image\\ICON\\mint.png"),
				new ImageIcon("C:\\image\\ICON\\darkmint.png"),
				new ImageIcon("C:\\image\\ICON\\wine.png")};
		String[] cateTop4 = {"문학", "역사", "사회학", "철학"}; //글자 길이에 따라 위치가 애매해서 두 개로 나눠서 반복문 돌림
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
			iconLb[i] = new JLabel(iconColor[i+2]);//[i+2]로 라벨 2칸배열과 이미지, 문자열 4칸배열의 합을 맞춤
			iconLb[i].setBounds(60+i*90, 30, 12, 20);
			cateLb[i] = new JLabel(cateTop4[i+2]+"  "+per[i+2]+"%");
			cateLb[i].setBounds(74+i*90, 30, 100, 20);
			cateLb[i].setFont(lbFont);
			info1.add(iconLb[i]);
			info1.add(cateLb[i]);
		}
		////////////////////////////////////////////////////////////////////////////////////////
		//우측 하위 6개 정보 패널 (파이 색깔 아이콘, 이름, 퍼센테이지)///////////////////////////////////////////////////// 
		info2.setBounds(300, 20, 90, 140);
		info2.setLayout(null);
//		info2.setBackground(Color.WHITE);
		JLabel[] cateLb2 = new JLabel[6];
		String[] cateOther = {"자연과학", "기술과학", "예술", "언어", "종교", "총류"};
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
			
			Graphics2D g2=(Graphics2D)g;//XY축 선두께
			g2.setStroke(new BasicStroke(3,BasicStroke.CAP_SQUARE,0));
			
			int pieX = 50;
			int pieY = 30;
			int pieSize = 200;
			
			//파이 1 (21%) //값 가져올 때 소수점 절삭
			//int startAngle = 시작할 앵글
			//int angle[1 2 3 4] = 그릴 각도
			g2.setColor(darkYellow);
			g2.fillArc(pieX, pieY, pieSize, pieSize, 90, 115);
			
			//파이2 (12%)
			g2.setColor(mint);
			g2.fillArc(pieX, pieY, pieSize, pieSize, 90+115, 54);
			
			//파이3 (11%)
			g2.setColor(darkMint);
			g2.fillArc(pieX, pieY, pieSize, pieSize, 205+54, 43);
			
			//파이4 (10%)
			g2.setColor(wine);
			g2.fillArc(pieX, pieY, pieSize, pieSize, 259+43, 36);
			
			//파이5 (나머지) // 그릴 각도 변수로 해서 빼주기
			g2.setColor(asheAlpha);
			g2.fillArc(pieX, pieY, pieSize, pieSize, 302+36 ,360-115-54-43-36);
			
			//나머지 파이 우측 정보패널과 이음선 그리기
			g2.setColor(Color.LIGHT_GRAY);
			g2.drawLine(180, 80, 235, 40);
			g2.drawLine(235+1, 40-1, 285, 40-1);
		}
	}
}
