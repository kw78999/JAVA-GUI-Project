package JAVAP;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.net.ssl.SSLContext;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

public class Testicon {  
	

	ImageIcon book = new ImageIcon("C:\\Users\\admin\\Desktop\\수업 자료\\gitTest\\gitTest1\\gitTest1\\image\\book1.jpg");
Image book1 = book.getImage();    //icon 이미지 img에 넣기
Image book2 = book1.getScaledInstance(45, 30, Image.SCALE_SMOOTH); //img이미지 크기조절
ImageIcon book3 = new ImageIcon(book2);//img 이미지 다시 imageicon에 넣기

   ImageIcon wbook = new ImageIcon("C:\\Users\\admin\\Desktop\\수업 자료\\gitTest\\gitTest1\\gitTest1\\image\\wbook1.jpg");
	Image wbook1 = wbook.getImage();    //icon 이미지 img에 넣기
	Image wbook2 = wbook1.getScaledInstance(45, 30, Image.SCALE_SMOOTH); //img이미지 크기조절
	ImageIcon wbook3 = new ImageIcon(wbook2);//img 이미지 다시 imageicon에 넣기

ImageIcon mem = new ImageIcon("C:\\Users\\admin\\Desktop\\수업 자료\\gitTest\\gitTest1\\gitTest1\\image\\mem.jpg");
Image mem1 = mem.getImage();    //icon 이미지 img에 넣기
Image mem2 = mem1.getScaledInstance(45, 30, Image.SCALE_SMOOTH); //img이미지 크기조절
ImageIcon mem3 = new ImageIcon(mem2);//img 이미지 다시 imageicon에 넣기

ImageIcon wmem = new ImageIcon("C:\\Users\\admin\\Desktop\\수업 자료\\gitTest\\gitTest1\\gitTest1\\image\\wmem.jpg");
Image wmem1 = wmem.getImage();    //icon 이미지 img에 넣기
Image wmem2 = wmem1.getScaledInstance(45, 30, Image.SCALE_SMOOTH); //img이미지 크기조절
ImageIcon wmem3 = new ImageIcon(wmem2);//img 이미지 다시 imageicon에 넣기

ImageIcon sta = new ImageIcon("C:\\Users\\admin\\Desktop\\수업 자료\\gitTest\\gitTest1\\gitTest1\\image\\\\sta.jpg");
Image sta1 = sta.getImage();    //icon 이미지 img에 넣기
Image sta2 = sta1.getScaledInstance(45, 30, Image.SCALE_SMOOTH); //img이미지 크기조절
ImageIcon sta3 = new ImageIcon(sta2);//img 이미지 다시 imageicon에 넣기

ImageIcon wsta = new ImageIcon("C:\\Users\\admin\\Desktop\\수업 자료\\gitTest\\gitTest1\\gitTest1\\image\\\\wsta.jpg");
Image wsta1 = wsta.getImage();    //icon 이미지 img에 넣기
Image wsta2 = wsta1.getScaledInstance(45,30, Image.SCALE_SMOOTH); //img이미지 크기조절
ImageIcon wsta3 = new ImageIcon(wsta2);//img 이미지 다시 imageicon에 넣기

ImageIcon home = new ImageIcon("C:\\Users\\admin\\Desktop\\수업 자료\\gitTest\\gitTest1\\gitTest1\\image\\home.jpg");
Image home1 = home.getImage();    //icon 이미지 img에 넣기
Image home2 = home1.getScaledInstance(45, 30, Image.SCALE_SMOOTH); //img이미지 크기조절
ImageIcon home3 = new ImageIcon(home2);//img 이미지 다시 imageicon에 넣기

ImageIcon whome = new ImageIcon("C:\\Users\\admin\\Desktop\\수업 자료\\gitTest\\gitTest1\\gitTest1\\image\\whome.jpg");
Image whome1 = whome.getImage();    //icon 이미지 img에 넣기
Image whome2 = whome1.getScaledInstance(45, 30, Image.SCALE_SMOOTH); //img이미지 크기조절
ImageIcon whome3 = new ImageIcon(whome2);//img 이미지 다시 imageicon에 넣기
}