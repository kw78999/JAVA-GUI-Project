package libSearchProgram;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

public class SearchPanel03 extends JPanel implements ActionListener,Runnable{
	BufferedReader in;
	PrintWriter out;
	String id;
	JTextArea chatArea;
	JTextArea noticeArea = new JTextArea();
	JTextField chatField = new JTextField();
	JButton btn3 = new JButton();
	JScrollPane chatScroll = new JScrollPane(); 
	//public static Socket socket;
	
	public SearchPanel03() {
	TitledBorder tB4 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3, true),"�缭�� ��ȭ");
	tB4.setTitleFont(new Font("��Ǯ���¿��� Medium", Font.BOLD, 18));
	
	
	
	Font comboFont = new Font("��Ǯ���¿��� Medium", Font.PLAIN, 12 );

	
	
	Border border = BorderFactory.createLineBorder(Color.BLACK,1);
	
	setBorder(tB4);
	setLayout(null);
	setBounds(0, 450, 690, 210);
	
	chatArea = new JTextArea();
	chatScroll = new JScrollPane(chatArea);
	chatScroll.setBounds(220,30,450,130);
	chatScroll.setBorder(border);
	//chatArea.applyComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
	chatArea.setBackground(new Color(240, 246, 255));
	chatArea.setEditable(false);
	
	String notice = "\n���� �������� ���� ���� ȯ���մϴ�!\n\n�ٸ��� ��� ���� ����սô�.\n�����˻��� ������ �ʿ��� ��쿡��\nȣ�����ּ���.\n�����մϴ�.";
	noticeArea = new JTextArea(notice);
	noticeArea.setBounds(20, 30, 200, 158);
	noticeArea.setEditable(false);
	noticeArea.setFont(comboFont);
	
	chatField = new JTextField();
	chatField.setBounds(220,165,370,28);
	btn3 = new JButton("������");
	btn3.setBounds(590, 165, 80, 28);
	btn3.addActionListener(this);
	chatField.addActionListener(this);
	btn3.setContentAreaFilled(false);
	btn3.setFocusPainted(false);
	
	add(noticeArea);
	add(chatScroll);
	add(chatField);
	add(btn3);
	////////////////////////////////////////////
	setVisible(true);
	validate();
	connect();
	}

	@Override
	public void run() {
		try {
			while(true) {
				chatArea.append(in.readLine()+"\n");
				chatField.requestFocus();
			}
			
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
			System.exit(1);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==btn3||obj==chatField) {
			out.println(chatField.getText());
			ResetThread.timer = 10;
			chatField.setText("");
			chatField.requestFocus();
			int pos = chatArea.getText().length();
			chatArea.setCaretPosition(pos);
			
		}
		
	}
	
	public void connect() {
		try {
			 Socket socket = new Socket("127.0.0.2",8001);
			in = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));
			out = new PrintWriter(
					socket.getOutputStream(),true);
			out.println("ȸ��");
		} catch (Exception e) {
			e.printStackTrace();
		}
		new Thread(this).start();
	}
	
}
