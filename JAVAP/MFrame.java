package JAVAP;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import oracle.net.aso.v;

public class MFrame extends Frame {

	public MFrame() {
		this(300,300,new Color(220,220,220));
	}
	public MFrame(int w, int h) {
		this(w,h, new Color(220,220,220));
	}
	public MFrame(Color c) {
		this(300,300, c);
	}
	public MFrame(int w, int h, Color c) {
		setSize(w, h);
		setBackground(c);
		//setLayout(new FlowLayout());
		setVisible(true);
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		validate();//새로고침의 기능을 내포
	}
}//--class








