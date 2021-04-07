package libSearchProgram;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SearchPanel04 extends JPanel{
	
	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	       Image img = icon.getImage();  
	       Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	       return new ImageIcon(resizedImage);
	}//이미지를 받아서 버튼 사이즈에 맞게 조절해주는 메소드. 아래 int offset과 같이 사용
	
	
	
	
	static JLabel map;
	
	static final ImageIcon MAPA = new ImageIcon("C://IMAGE//mapA.png");
	static final ImageIcon MAPB = new ImageIcon("C://IMAGE//mapB.png");
	static final ImageIcon MAPC = new ImageIcon("C://IMAGE//mapC.png");
	static final ImageIcon MAPD = new ImageIcon("C://IMAGE//mapD.png");
	
	
	
	public SearchPanel04() {
		TitledBorder tB2 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3, true),"도서 위치");
		tB2.setTitleFont(new Font("잘풀리는오늘 Medium", Font.BOLD, 18));
	
		
		
		
	//	ImageIcon mapA = new ImageIcon("libFrame/mapA.png");
	//	ImageIcon mapB = new ImageIcon("libFrame/mapB.png");
	//	ImageIcon mapC = new ImageIcon("libFrame/mapC.png");
	//	ImageIcon mapD = new ImageIcon("libFrame/mapD.png");
		setBorder(tB2);
		setLayout(null);
	//	setBounds(690, 230, 450, 430);//이 패널을 불러오는 SFrame에서 지정해주면 됨
		map = new JLabel(MAPA);	//
		map.setBounds(0, 10, 450, 220);
//		
//		map.setBounds(10, 10, 450, 220);
//		int offset = map.getInsets().left; //버튼 크기 재기
//		map.setIcon(resizeIcon(MAPA, map.getWidth() - offset, map.getHeight() - offset));
//		
//		map.setBounds(10, 10, 450, 220);
//		int offset1 = map.getInsets().left; //버튼 크기 재기
//		map.setIcon(resizeIcon(MAPB, map.getWidth() - offset, map.getHeight() - offset));
//		
//		map.setBounds(10, 10, 450, 220);
//		int offset2 = map.getInsets().left; //버튼 크기 재기
//		map.setIcon(resizeIcon(MAPC, map.getWidth() - offset, map.getHeight() - offset));
//		
//		map.setBounds(10, 10, 450, 220);
//		int offset3 = map.getInsets().left; //버튼 크기 재기
//		map.setIcon(resizeIcon(MAPD, map.getWidth() - offset, map.getHeight() - offset));
//		
		add(map);
	}
}
