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


public class ChartPanel01 extends JPanel {
    
	int pY;
	
	Color beige = new Color(255, 229, 178);
	Color skyBlue = new Color(89, 158, 255);
	Color pastelPink = new Color(255, 122, 202);//#ff7aca
	Color pastelGreen = new Color(122, 255, 174);//#7affae
	Vector<LibStatBean> vlist;
    
	public ChartPanel01() {
		JLabel lb1;								//그래프 Y축 표기 단위
		Draw drawP = new Draw();	//그래프를 그릴 페인트컴포넌트 클래스
		JPanel info1;							//그래프 아래에 들어가는 범례패널
		TitledBorder tB1 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true),"이용자 추이");//패널 외곽선 꾸미는 보더
		tB1.setTitleFont(new Font("잘풀리는오늘 Medium", Font.BOLD, 15));
		Font lbFont = new Font("Times", Font.ITALIC, 12);//폰트 정의
		Font monFont = new Font("잘풀리는오늘 Medium", Font.PLAIN|Font.ITALIC, 14);
		
		setLayout(null);
		setBackground(Color.WHITE);
		
		lb1 = new JLabel("(단위: 명)");
		lb1.setFont(lbFont);
		lb1.setBounds(10, 35, 105, 18);
		
		drawP.setBorder(tB1);
		drawP.setLayout(null);
		drawP.setBounds(10, 10, 570, 310);
		drawP.setBackground(Color.WHITE);
		
		info1 = new JPanel();		//그래프 아래 월과 범례 표기하는 정보패널
		info1.setLayout(null);
		info1.setBounds(60, 215, 440, 90);//가려놓은 Y축 위를 덮고 있는 좌표임 Y축 보이게 할거면 좌표 수정
		info1.setBackground(Color.WHITE);
		
		//X축 구분값(월) DB에서 가져와서 붙이기
		LibStatMgr mgr = new LibStatMgr();
		Vector<LibStatBean> vlist = mgr.getListStat();
		JLabel[] mLb = new JLabel[4];
		String[][] months = new String[vlist.size()][4];
		for (int i = 0; i < 4; i++) {
			LibStatBean bean = vlist.elementAt(i);
			months[i][0] = bean.getMon();
			String s = months[i][0];
			mLb[i] = new JLabel(s);
			mLb[i].setBounds(10+80*(i+1), 1, 44, 22);
			mLb[i].setFont(lbFont);
			info1.add(mLb[i]);
		}
		//Y축 기준값 DB에서 가져와서 붙이기
		LibStatBean bean = mgr.getAxisY1();
		pY = bean.getMaxCount();
		System.out.println(pY+"PY");
		String si = Integer.toString(pY);
		JLabel pYLb = new JLabel(si);
		
		pYLb.setBounds(50, 55, 105, 18);
		pYLb.setFont(lbFont);
		drawP.add(pYLb);
		
		JLabel[] headLb = new JLabel[5];
		for (int i = 1; i < 5; i++) {
			int j = pY-200*i;//Y축 기준값에서 -100씩 라벨 붙이기
			String s = Integer.toString(j);
			headLb[i] = new JLabel(s);
			headLb[i].setFont(lbFont);
			headLb[i].setBounds(50, 55+30*i, 105, 18);
			drawP.add(headLb[i]);
		}
//X축 구분값/////////////////////////////////////////////////////////////////////
//		String[] getM = {"3월","4월","5월","6월"}; //DB에서 가져올 값. 직전 월을 0번 방에 넣고 한 달 단위로 문자로 표기. 
//		JLabel[] months = new JLabel[4];			//DATE의 월을 가져와서 문자로??
//		for (int i = 0; i < months.length; i++) {
//			months[i] = new JLabel(getM[i]);
//			months[i].setFont(monFont);
//			months[i].setForeground(Color.BLACK);
//			months[i].setBounds(10+80*(i+1), 1, 44, 22);
//			info1.add(months[i]);
//		}/////////////////////////////////////////////////////////////////////////////
//Y축 구분값//////////////////////////////////////////////////////////////////////
//		String[] head = {"600","500","400","300","200"};  //DB에서 가져온 값 중 가장 높은 값을
//		JLabel[] headLb = new JLabel[5];								// 100 단위로 잘라서 0번방에 넣고 이후 100단위로 5개
//		for (int i = 0; i < headLb.length; i++) {
//			headLb[i] = new JLabel(head[i]);
//			headLb[i].setFont(lbFont);
//			headLb[i].setBounds(50, 55+30*i, 105, 18);
//			drawP.add(headLb[i]);
/////////////////////////////////////////////////////////////////////////////
		// 범례 아이콘과 이름/////////////////////////////////////////////////////////////////
		JLabel[] iconLb = new JLabel[2];
		JLabel[] yearLb = new JLabel[2];
		String[] s = {"당해", "지난해"};
		ImageIcon iconColor[] = {
				new ImageIcon("graphEx3/copy/pastelpinkbar.png"),
				new ImageIcon("graphEx3/copy/pastelgreenbar.png")};
		for (int i = 0; i < iconColor.length; i++) {
			iconLb[i] = new JLabel(iconColor[i]);
			iconLb[i].setBounds(130*(i+1), 30, 48, 16);
			yearLb[i] = new JLabel(s[i]);
			yearLb[i].setFont(lbFont);
			yearLb[i].setBounds(180+i*130, 30, 48, 16);
			info1.add(iconLb[i]);
			info1.add(yearLb[i]);
		}
		//////////////////////////////////////////////////////////////////////////////
		drawP.add(lb1);
		drawP.add(info1);
		
		add(drawP);
		
		setVisible(true);
	}
	//1. 꺾은선 그래프(이용객 추이)
		class Draw extends JPanel{
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				
			//	int sX = 80; //시작하는 X좌표 점 
			//	int lineX = 80;
				
				Graphics2D g2=(Graphics2D)g;//두께설정을 위해 붓을 업그레이드
				//XY축 선 긋기
		//		g2.setStroke(new BasicStroke(3,BasicStroke.CAP_SQUARE,0));//두께 정의
		//		g2.setColor(new Color(237,237,237));
		//		g2.drawLine(sX,40,sX,230);//Y축. 
		//		g2.drawLine(sX,230,480,230);//X축. 가로축400 세로축190
				//그래프 내부 구분선///////////////////////////////////////////////////////////////////
				g2.setStroke(new BasicStroke(2, BasicStroke.CAP_SQUARE,0));
				g2.setColor(new Color(228, 235, 247));
				for (int i = 0; i < 5; i++) {
					g2.drawLine(70, 190-30*i, 490, 190-30*i);
				}/*처음에는 아래와 같이 만든 다음 규칙을 찾아서 위와 같이 반복문으로 수정했습니다.		
				g2.drawLine(80,200,480,200);//X축 1  30 픽셀마다 한 줄씩 얇은 줄 생성
				g2.drawLine(80,170,480,170);//X축 2
				g2.drawLine(80,140,480,140);//X축 3
				g2.drawLine(80,110,480,110);//X축 4
				g2.drawLine(80,80,480,80);//X축 5			*/
				//그래프 1////////////////////////////////////////////////////////////////////////
		//		int visitors[] = {3, 4, 3, 5, 6, 5};
			
				g2.setStroke(new BasicStroke(3,BasicStroke.CAP_SQUARE,0));
				g2.setColor(pastelPink);
				LibStatMgr mgr = new LibStatMgr();
				Vector<LibStatBean> vlist3 = mgr.getChart1Data();
				String[] visitors = new String[7];
				for (int i = 0; i < 6; i++) {
					LibStatBean bean = vlist3.elementAt(i);
				//	System.out.println("vlistsize:"+vlist3.size());
					int j[] = new int[7];
					visitors[i] = bean.getCnt();
					j[i] = Integer.parseInt(visitors[i]);
					//System.out.println(j[i+1]);
					g2.drawLine(80+80*i+1, 
							28+28*(i+1), 
							80+80*(i+1), 
							28+28*(i+1));
					g2.fillOval(80+80*(i+1)-5, 
							28+28*(i+1)-5, 
							10, 
							10);//-30에서 -는 위에서부터 그리게. 30은 보정해주는 값.
				}
		//		g2.setStroke(new BasicStroke(3,BasicStroke.CAP_SQUARE,0));
		//		g2.setColor(pastelPink);
		//		for (int i = 0; i < visitors.length-1; i++) {//렝스에 -1인 이유 = 실행문에 배열[i+1]이 들어가서 배열범위 벗어난 오류
//					g2.drawLine(80+80*i, 250-30*visitors[i], 80+80*(i+1), 250-30*visitors[i+1]);//[i+1]를 하지 않으면 선 연결이 안됨.
//					g2.fillOval(    80+80*i-5, 250-30*visitors[i]-5, 10, 10);//-30에서 -는 위에서부터 그리게. 30은 보정해주는 값.
		//		}//////////////////////////////////////////////////////////////////////////////
				////그래프 2////////////////////////////////////////////////////////////////////////
				int visitors2[] = {2, 4, 3, 6, 5, 5};
				g2.setColor(pastelGreen);
				for (int i = 0; i < visitors2.length-1; i++) {
					g2.drawLine(80+80*i, 
							250-30*visitors2[i], 
							80+80*(i+1), 
							250-30*visitors2[i+1]);
					g2.fillOval(    80+80*i-5, 
							250-30*visitors2[i]-5, 
							10, 
							10);
				}
			}//--paintComponent
		}//--Draw
}
