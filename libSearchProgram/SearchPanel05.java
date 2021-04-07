package libSearchProgram;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SearchPanel05 extends JPanel
implements ActionListener{
	
		JButton btn1;
		int mID;
		static String name;
		
		String testInputName;
		
		BMEMBERSMgr mgr;
		JTextField tf, tf1;
		BMEMBERSBean bean;
		
		
		Font lbfont = new Font("잘풀리는오늘 Medium", Font.PLAIN, 12);
		Font lbfont2 = new Font("잘풀리는오늘 Medium", Font.PLAIN, 14);
		
		
		JDialog dialog;

	public SearchPanel05() {
		TitledBorder tB2 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3, true),"도서 요청");
		tB2.setTitleFont(new Font("잘풀리는오늘 Medium", Font.BOLD, 18));
		
	
		JTextArea ta1;
		tf = new JTextField();
		tf.addActionListener(this);
		
		setLayout(null);

		JLabel lb1 = new JLabel("읽고 싶은 도서에 투표해보세요.");
		lb1.setBounds(20, 30, 200, 14);
		lb1.setFont(lbfont);
		
		ta1 = new JTextArea("도서를 기증하신 분들에게는\n"
				+ "작은 카페에서 사용할 수 있는 아메리카노(s) 쿠폰을 드립니다.");
		ta1.setEditable(false);
		ta1.setBounds(20, 60, 400, 32);
		ta1.setFont(lbfont2);

		JLabel lb2 = new JLabel("회원번호");
		lb2.setBounds(20, 140, 52, 14);
		lb2.setFont(lbfont2);
		
		JLabel lb3 = new JLabel("회원명");
		lb3.setBounds(20, 110, 52, 14);
		lb3.setFont(lbfont2);
		
		tf.setBounds(75, 136, 140, 24);
		
		tf1 = new JTextField();
		tf1.addActionListener(this);
		tf1.setBounds(75, 110, 140, 24);
		add(tf1);
		
		
		btn1 = new JButton("투표");
		btn1.setBounds(215, 136, 80, 23);
		btn1.setFocusPainted(false);
		btn1.setContentAreaFilled(false);
		btn1.addActionListener(this);
		
		add(lb3);
		add(lb1);
		add(lb2);
		add(ta1);
		add(tf);
		add(btn1);
		
		setBorder(tB2);
	}
	
	public void IDdialog() {
		dialog = new JDialog();
		dialog.setLayout(null);
		dialog.setTitle("회원을 찾을 수 없습니다");
		JLabel lb = new JLabel("회원명과 회원번호를 확인하세요.");
		lb.setBounds(50, 20, 300, 20);
		lb.setFont(lbfont2);
		dialog.add(lb);
		dialog.setSize(300, 180);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		JButton btn3 = new JButton("확인");
		btn3.setBounds(100, 80, 80, 40);
		btn3.addActionListener(popClose);
		dialog.add(btn3);
	}

	ActionListener popClose = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			dialog.dispose();
			ResetThread.timer = 10;
		}
	};
	
	@Override
	public void actionPerformed(ActionEvent e) {
		ResetThread.timer = 10;
		bean = new BMEMBERSBean();
		//추가할 사항************************************
		//빈즈에서 가져온 ID의 크기보다 높은 값을 입력받으면
		//-1로 바꿔주는 것으로 아이디 확인팝업 활용하기
		String s = tf.getText();//입력된 문자(회원번호)를 s에 담고
		int inputID;					//회원번호를 숫자로 바꿔 담을 변수 inputID
		if(s.equals("")) { 			//이푸 만약에 회원번호를 입력하지 않았다면(tf에 입력한 값이 없다면)
			s = "-1";					//s에 "-1"을 담고 (DB.회원번호에 -1은 없는 값)
			inputID = Integer.parseInt(s);//s를 숫자로 바꿔 inputID에 담는다
			}else {inputID = Integer.parseInt(s);}//아니라면(입력값존재) s를 inputID에 담는다
	
		mgr = new BMEMBERSMgr();
		
		bean = mgr.idCheck(inputID);//인트(회원번호)를 매개변수로 받는 MID와 MNAME 조회하는 메소드
		//빈공간 빈은 =  mgr 메소드 id 체크를 매개변수 3을넣은 반환값홍길동 빈을 넣는다 ****** 별 다섯개
		
		System.out.println("mgr실행후"+bean.getMID()+bean.getMNAME());
		
		
		mID = bean.getMID();//빈에 담겨있는 MID (조회하기 위한)
		name = bean.getMNAME();//빈에 담겨있는 MNAME (다음 창에 반영될 값)
		
		String inputName = tf1.getText();//회원이름 입력한 값
		testInputName = tf1.getText();//회원이름 입력한 값
		Object obj = e.getSource();//버튼 일치여부 확인용 오브젝트
		
		if(obj.equals(btn1)&&inputID==mID&&inputName.equals(name)) {
			System.out.println(name+"버튼, 아이디, 회원명 일치 = 투표프레임 실행");
			new VFrame();
		}else if(obj.equals(btn1)&&(inputID==-1||inputName!=name)){//스트링타입인데 != 연산자가 맞는지 확인하기. 실행은 잘 됨.
			System.out.println("이름과 회원번호를 확인하세요.");
			this.IDdialog();//아이디를 확인하세요 팝업. 이걸 액션리스너로 감싸니까 this가 오류가 뜨는데 왤까
		}
//		else if(obj.equals(btn1)){
//			System.out.println("가져온mID: "+mID+"\n가져온name: "+name+"\n입력된inputID: "+s+"\n변환된값:"+inputID);
//		}
	}

}
