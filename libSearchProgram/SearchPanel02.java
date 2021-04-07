package libSearchProgram;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

class PrinterMethod{
	public PrinterMethod() {
		
	}
}


public class SearchPanel02 extends JPanel
implements ActionListener, MouseListener{
	
	  
	
	
	private static Icon resizeIcon(ImageIcon icon, int resizedWidth, int resizedHeight) {
	       Image img = icon.getImage();  
	       Image resizedImage = img.getScaledInstance(resizedWidth, resizedHeight,  java.awt.Image.SCALE_SMOOTH);  
	       return new ImageIcon(resizedImage);
	}//이미지를 받아서 버튼 사이즈에 맞게 조절해주는 메소드. 아래 int offset과 같이 사용
	
	static JLabel infoImg = new JLabel();
	static JLabel infoTitle = new JLabel();
	static JLabel infoAuthor = new JLabel();
	static JLabel infoLocate = new JLabel();
	static String keyWord;
	
	ImageIcon print = new ImageIcon("C:\\IMG\\printericon.png");
	JTextField textField;

	
	JButton btn1, btn2;
	JComboBox<String> comboBox;

	
	public SearchPanel02() {
		
		
		
		
		TitledBorder tB1 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3, true),"도서 검색");
		tB1.setTitleFont(new Font("잘풀리는오늘 Medium", Font.BOLD, 18));
		
		TitledBorder tB1_1 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 1, true));
		JPanel p1_1 = new JPanel();
		JPanel p1_2 = new JPanel();
		ImageIcon iconSearch = new ImageIcon("C:\\IMAGE\\searchIcon.png");
		String[] s = {"도서명", "저자"};
		Font comboFont = new Font("잘풀리는오늘 Medium", Font.PLAIN, 12 );
		
		
		
		
		Font infoFont = new Font("잘풀리는오늘 Medium", Font.PLAIN, 15 );

		setBorder(tB1);
		setLayout(null);
		setBounds(690, 0, 450, 230);//p1 가로450 세로 200
		btn1 = new JButton(iconSearch);//검색버튼
		btn1.setBounds(405, 25, 27, 25);
		btn1.setContentAreaFilled(false);//버튼 배경없애기
		btn1.addActionListener(this);
		
		btn2 = new JButton(print);
		btn2.setBounds(390,160,46,46);//프린트버튼
		btn2.setContentAreaFilled(false);//버튼 배경없애기
		btn2.setBorderPainted(false);//버튼 테두리 없애기
		btn2.setFocusPainted(false);
		btn2.addMouseListener(this);//마우스리스너
		btn2.addActionListener(this);//액션리스너
		
		int offset = btn2.getInsets().left; //버튼 크기 재기
		btn2.setIcon(resizeIcon(print, btn2.getWidth() - offset, btn2.getHeight() - offset)); //버튼 크기에 맞춰 이미지 삽입
		
		textField = new JTextField();
		textField.setBounds(145, 25, 260, 26);
		comboBox = new JComboBox<>(s);
		comboBox.setBounds(20, 25, 125, 25);
		comboBox.setFont(comboFont);
	//	comboBox.setOpaque(false);
		add(btn1);
		add(btn2);
		add(textField);
		add(comboBox);
		
		p1_1 = new JPanel();
		p1_1.setBorder(tB1_1);
		p1_1.setBounds(10, 60, 430, 155);
		p1_1.setBackground(Color.WHITE);
		p1_1.setLayout(null);
		
		p1_2 = new JPanel();
		p1_2.setLayout(null);
		p1_2.setBounds(10, 10, 410, 135);
		p1_2.setBackground(Color.WHITE);
		
		infoImg = new JLabel();
		infoImg.setLayout(null);
		infoImg.setBounds(20, 20, 85, 105);
		
		infoTitle = new JLabel("");//검색결과 행 누르면 DB연동 값 가져오기
		infoTitle.setBounds(130, 30, 240, 20);
		infoTitle.setFont(infoFont);
		
		infoAuthor = new JLabel("");
		infoAuthor.setBounds(130, 60, 240, 20);
		infoAuthor.setFont(infoFont);
		
		infoLocate = new JLabel("");
		infoLocate.setBounds(130, 90, 240, 20);
		infoLocate.setFont(infoFont);
		
		
		
		
		
		
		p1_2.add(infoTitle);
		p1_2.add(infoAuthor);
		p1_2.add(infoLocate);
		p1_2.add(infoImg);
		
		p1_1.add(p1_2);
		add(p1_1);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==btn2) {
		new PrinterMethod();//외부클래스 프린트 호출
		System.out.println("프린트 메소드 호출할 퍼포머");
		
		PrintDialogExample s = new PrintDialogExample();
		
		
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==btn2) {
		btn2.setBounds(390,160,46,46);
		int offset = btn2.getInsets().left; //버튼 크기 재기
		btn2.setIcon(resizeIcon(print, btn2.getWidth() - offset, btn2.getHeight() - offset));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==btn2) {
			btn2.setBounds(390-2,160-2,50,50);
			int offset = btn2.getInsets().left;
			btn2.setIcon(resizeIcon(print, btn2.getWidth() - offset, btn2.getHeight() - offset));
		}
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==btn2) {
			btn2.setBounds(390-2,160-2,50,50);
			int offset = btn2.getInsets().left; //버튼 크기 재기
			btn2.setIcon(resizeIcon(print, btn2.getWidth() - offset, btn2.getHeight() - offset));
		}
	}
	
	@Override
	public void mouseExited(MouseEvent e) {
		Object obj = e.getSource();
		if(obj==btn2) {
			btn2.setBounds(390,160,46,46);
			int offset = btn2.getInsets().left; //버튼 크기 재기
			btn2.setIcon(resizeIcon(print, btn2.getWidth() - offset, btn2.getHeight() - offset));
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		Object item = comboBox.getSelectedItem();
		if(obj.equals(btn1)&&item=="도서명") {//도서명으로 검색했을 때
			System.out.println("서명검색이벤트발생 코드위치:서치패널02");
			keyWord = textField.getText();//tf에 입력된 검색어 Search01에서 처리
			SearchPanel01 panel01 = new SearchPanel01();
			//panel01.removeAll();
			//panel01.revalidate();
			//panel01.vlist.removeAllElements();
//			panel01.table.removeAll();
//			panel01.model.fireTableDataChanged();
			panel01.SearchTitle();
		}else if(obj.equals(btn1)&&item=="저자") {
			System.out.println("저자검색이벤트발생 코드위치: 서치패널02");
		}else if(obj.equals(btn1)&&textField.equals("")){//if 붙여서 조건 추ㅏ하기
			System.out.println("조건 불일치 코드확인");
		}
	}
	
}