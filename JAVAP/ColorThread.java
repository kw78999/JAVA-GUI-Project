package JAVAP;

import java.awt.Color;
import java.awt.Font;

import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

class ColorThread implements Runnable{
	static Color red = new Color(255,184,249);
	static Color cor= Color.white;
	
	static LineBorder lb = new LineBorder(red,5);
	static LineBorder bb = new LineBorder(cor,5);
	TitledBorder jtx2=new TitledBorder(lb,"회원과의 채팅");
	TitledBorder jtx3=new TitledBorder(bb,"회원과의 채팅");
    

	public void run() {
		
		jtx2.setTitleFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 18) );
		jtx3.setTitleFont(new Font(  "잘풀리는오늘 Medium", Font.PLAIN, 18) );
		try {
			ChatClient.mpanel.setBorder(jtx2);
			SwingProject_1.cpanel.setBorder(jtx2);
			SwingProject_2.cpanel.setBorder(jtx2);
			SwingProject_state.cpanel.setBorder(jtx2);
			ChartFrame.p4.setBorder(jtx2);
			Thread.sleep(1000);
			ChatClient.mpanel.setBorder(jtx3);
			SwingProject_1.cpanel.setBorder(jtx3);
			SwingProject_2.cpanel.setBorder(jtx3);
			SwingProject_state.cpanel.setBorder(jtx3);
			ChartFrame.p4.setBorder(jtx3);
			Thread.sleep(1000);
			ChatClient.mpanel.setBorder(jtx2);
			SwingProject_1.cpanel.setBorder(jtx2);
			SwingProject_2.cpanel.setBorder(jtx2);
			SwingProject_state.cpanel.setBorder(jtx2);
			ChartFrame.p4.setBorder(jtx2);
			Thread.sleep(1000);
			ChatClient.mpanel.setBorder(jtx3);
			SwingProject_1.cpanel.setBorder(jtx3);
			SwingProject_2.cpanel.setBorder(jtx3);
			SwingProject_state.cpanel.setBorder(jtx3);
			ChartFrame.p4.setBorder(jtx3);
			Thread.sleep(1000);
			}catch(Exception e){
				
			}}
}
	