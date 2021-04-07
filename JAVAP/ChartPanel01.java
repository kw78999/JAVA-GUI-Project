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
		JLabel lb1;								//�׷��� Y�� ǥ�� ����
		Draw drawP = new Draw();	//�׷����� �׸� ����Ʈ������Ʈ Ŭ����
		JPanel info1;							//�׷��� �Ʒ��� ���� �����г�
		TitledBorder tB1 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true),"�̿��� ����");//�г� �ܰ��� �ٹ̴� ����
		tB1.setTitleFont(new Font("��Ǯ���¿��� Medium", Font.BOLD, 15));
		Font lbFont = new Font("Times", Font.ITALIC, 12);//��Ʈ ����
		Font monFont = new Font("��Ǯ���¿��� Medium", Font.PLAIN|Font.ITALIC, 14);
		
		setLayout(null);
		setBackground(Color.WHITE);
		
		lb1 = new JLabel("(����: ��)");
		lb1.setFont(lbFont);
		lb1.setBounds(10, 35, 105, 18);
		
		drawP.setBorder(tB1);
		drawP.setLayout(null);
		drawP.setBounds(10, 10, 570, 310);
		drawP.setBackground(Color.WHITE);
		
		info1 = new JPanel();		//�׷��� �Ʒ� ���� ���� ǥ���ϴ� �����г�
		info1.setLayout(null);
		info1.setBounds(60, 215, 440, 90);//�������� Y�� ���� ���� �ִ� ��ǥ�� Y�� ���̰� �ҰŸ� ��ǥ ����
		info1.setBackground(Color.WHITE);
		
		//X�� ���а�(��) DB���� �����ͼ� ���̱�
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
		//Y�� ���ذ� DB���� �����ͼ� ���̱�
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
			int j = pY-200*i;//Y�� ���ذ����� -100�� �� ���̱�
			String s = Integer.toString(j);
			headLb[i] = new JLabel(s);
			headLb[i].setFont(lbFont);
			headLb[i].setBounds(50, 55+30*i, 105, 18);
			drawP.add(headLb[i]);
		}
//X�� ���а�/////////////////////////////////////////////////////////////////////
//		String[] getM = {"3��","4��","5��","6��"}; //DB���� ������ ��. ���� ���� 0�� �濡 �ְ� �� �� ������ ���ڷ� ǥ��. 
//		JLabel[] months = new JLabel[4];			//DATE�� ���� �����ͼ� ���ڷ�??
//		for (int i = 0; i < months.length; i++) {
//			months[i] = new JLabel(getM[i]);
//			months[i].setFont(monFont);
//			months[i].setForeground(Color.BLACK);
//			months[i].setBounds(10+80*(i+1), 1, 44, 22);
//			info1.add(months[i]);
//		}/////////////////////////////////////////////////////////////////////////////
//Y�� ���а�//////////////////////////////////////////////////////////////////////
//		String[] head = {"600","500","400","300","200"};  //DB���� ������ �� �� ���� ���� ����
//		JLabel[] headLb = new JLabel[5];								// 100 ������ �߶� 0���濡 �ְ� ���� 100������ 5��
//		for (int i = 0; i < headLb.length; i++) {
//			headLb[i] = new JLabel(head[i]);
//			headLb[i].setFont(lbFont);
//			headLb[i].setBounds(50, 55+30*i, 105, 18);
//			drawP.add(headLb[i]);
/////////////////////////////////////////////////////////////////////////////
		// ���� �����ܰ� �̸�/////////////////////////////////////////////////////////////////
		JLabel[] iconLb = new JLabel[2];
		JLabel[] yearLb = new JLabel[2];
		String[] s = {"����", "������"};
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
	//1. ������ �׷���(�̿밴 ����)
		class Draw extends JPanel{
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				
			//	int sX = 80; //�����ϴ� X��ǥ �� 
			//	int lineX = 80;
				
				Graphics2D g2=(Graphics2D)g;//�β������� ���� ���� ���׷��̵�
				//XY�� �� �߱�
		//		g2.setStroke(new BasicStroke(3,BasicStroke.CAP_SQUARE,0));//�β� ����
		//		g2.setColor(new Color(237,237,237));
		//		g2.drawLine(sX,40,sX,230);//Y��. 
		//		g2.drawLine(sX,230,480,230);//X��. ������400 ������190
				//�׷��� ���� ���м�///////////////////////////////////////////////////////////////////
				g2.setStroke(new BasicStroke(2, BasicStroke.CAP_SQUARE,0));
				g2.setColor(new Color(228, 235, 247));
				for (int i = 0; i < 5; i++) {
					g2.drawLine(70, 190-30*i, 490, 190-30*i);
				}/*ó������ �Ʒ��� ���� ���� ���� ��Ģ�� ã�Ƽ� ���� ���� �ݺ������� �����߽��ϴ�.		
				g2.drawLine(80,200,480,200);//X�� 1  30 �ȼ����� �� �پ� ���� �� ����
				g2.drawLine(80,170,480,170);//X�� 2
				g2.drawLine(80,140,480,140);//X�� 3
				g2.drawLine(80,110,480,110);//X�� 4
				g2.drawLine(80,80,480,80);//X�� 5			*/
				//�׷��� 1////////////////////////////////////////////////////////////////////////
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
							10);//-30���� -�� ���������� �׸���. 30�� �������ִ� ��.
				}
		//		g2.setStroke(new BasicStroke(3,BasicStroke.CAP_SQUARE,0));
		//		g2.setColor(pastelPink);
		//		for (int i = 0; i < visitors.length-1; i++) {//������ -1�� ���� = ���๮�� �迭[i+1]�� ���� �迭���� ��� ����
//					g2.drawLine(80+80*i, 250-30*visitors[i], 80+80*(i+1), 250-30*visitors[i+1]);//[i+1]�� ���� ������ �� ������ �ȵ�.
//					g2.fillOval(    80+80*i-5, 250-30*visitors[i]-5, 10, 10);//-30���� -�� ���������� �׸���. 30�� �������ִ� ��.
		//		}//////////////////////////////////////////////////////////////////////////////
				////�׷��� 2////////////////////////////////////////////////////////////////////////
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
