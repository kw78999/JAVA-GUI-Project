package JAVAP;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import ch20.ChatServer1;


public class ChatAction extends Thread implements Runnable {
	static Socket socket;
	static BufferedReader in;
	static 	PrintWriter out;
	
	
	
	 ActionListener acc = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			Object obj = e.getSource();
			 if(obj==ChatClient.ctf||obj==ChatClient.cbtn||obj==SwingProject_state.cbtn||obj==SwingProject_state.ctf||
					obj==SwingProject_1.sbtn||obj==SwingProject_1.ctf||obj==SwingProject_2.sbtn||obj==SwingProject_2.ctf
					) {
				
				if(!ChatClient.ctf.getText().equals("")) {   //입푸 ctf가 ""가 아닐시에 
					out.println(ChatClient.ctf.getText());    //현재 텍스트가 있는 tf만 서버로 전송하기 
					ChatClient.ctf.setText("");
					
				}else if(!SwingProject_state.ctf.getText().equals("")){
					out.println(SwingProject_state.ctf.getText());
					SwingProject_state.ctf.setText("");
				}else if(!SwingProject_1.ctf.getText().equals("")) {
					out.println(SwingProject_1.ctf.getText());
					SwingProject_1.ctf.setText("");
				}else if(!SwingProject_2.ctf.getText().equals("")) {
					out.println(SwingProject_2.ctf.getText());
					SwingProject_2.ctf.setText("");
				//}else if(!ChartFrame.ctf.getText().equals("")) {
					//out.println(ChartFrame.ctf.getText());
					//ChartFrame.ctf.setText("");
				//}
				int pos = ChatClient.cta.getText().length(); //스크롤 자동으로 내리기 
			//	System.out.println(pos);
				ChatClient.cta.setCaretPosition(pos);
				SwingProject_1.cta.setCaretPosition(pos-15);
				SwingProject_2.cta.setCaretPosition(pos-15);
				SwingProject_state.cta.setCaretPosition(pos-15);
				//ChartFrame.cta.setCaretPosition(pos-15);
		}
	}
	};

	@Override
	public void run() {
		try {
			while(true) {
				String str = in.readLine()+"\n";    //들어온 문자 스트링에담아서 하나씩 보내주기 
				ChatClient.cta.append(str);
				SwingProject_state.cta.append(str);
				SwingProject_1.cta.append(str);
				SwingProject_2.cta.append(str);
				//ChartFrame.cta.append(str);
				ChatClient.ctf.requestFocus();
				if(str.substring(0,4).equals("[회원]")) {
				Runnable tt = new ColorThread();
				Thread t1 = new Thread(tt);
				t1.start();
				}
				
			}
			
		} catch (Exception e) {
			System.out.println("Error");
			e.printStackTrace();
			System.exit(1);
		}
	}

	public void connect() {
		try {
		 socket = new Socket("127.0.0.1",8001);
			in = new BufferedReader(
					new InputStreamReader(
							socket.getInputStream()));
			out = new PrintWriter(
					socket.getOutputStream(),true);
			out.println("관리자");
		} catch (Exception e) {
			e.printStackTrace();
		}
		new Thread(this).start();
	}
	
	
};}