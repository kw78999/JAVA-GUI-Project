package JAVAP;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class MemThread implements Runnable{

	
	static Color red = new Color(255,184,249);
	static Color cor= Color.white;
	
	static LineBorder lb = new LineBorder(red,5);
	static LineBorder bb = new LineBorder(cor,5);
	TitledBorder jtx2=new TitledBorder(lb,"ȸ������        ");
	TitledBorder jtx3=new TitledBorder(bb,"ȸ������        ");
	
	
	
	@Override
	public void run() {
		
	jtx2.setTitleFont(new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 18) );
	jtx3.setTitleFont(new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 18) );
	try {
		//SwingProject.panel13.setBorder(jtx2);
		//Thread.sleep(1000);
		//SwingProject.panel13.setBorder(jtx3);
		int l = 249 ;
		int j = 184;
		
		for (int i = 255; j<255; j++) {
			Color red = new Color(i,j,l);
			LineBorder test = new LineBorder(red,5);
			TitledBorder jtx8 =new TitledBorder(test,"ȸ������        ");
			jtx8.setTitleFont(new Font(  "��Ǯ���¿��� Medium", Font.PLAIN, 18) );
			SwingProject.panel13.setBorder(jtx8);
			Thread.sleep(20);
			if(l<255)
				l++;
		}
		
		}catch(Exception e){
			
		}

}}
