package JAVAP;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Enumeration;
import java.util.Hashtable;

public class S extends Thread{
	static Hashtable<String, PrintWriter> map = new Hashtable<String,PrintWriter>();
	BufferedReader br;
	String userId;
	
	
	public S(String userId,BufferedReader br) {
		this.userId = userId;
		this.br = br;

		
		sendMessage(userId+"님이 입장 하였습니당") ;
	}
	
	void sendMessage(String line){
		
		//전달받은 메세지를 모든소켓에 뿌림 
		Enumeration<String> keys = map.keys();
		while(keys.hasMoreElements()) {
			String idkey = keys.nextElement();
			PrintWriter pw = map.get(idkey);
			pw.println(line);
			pw.flush();
	 }
	}
	@Override
	public void run() {
		while(true) {
			try {
				String line = br.readLine();
				sendMessage(line);
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		//서버  ServerSocket -> accept -> socket
		
		BufferedReader br = null;
		ServerSocket serverSocket = null; 
		try {
			serverSocket = new ServerSocket(8880);
			System.out.println("클라이언트 연결 대기중....");
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println("클라이언트 연결 됨");
				//클라이언트 메세지 받기
				br = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				String userId = br.readLine();
				//System.out.println(userId+"님이 접속됨.");
				PrintWriter pw = new PrintWriter(
						new BufferedOutputStream(socket.getOutputStream()));
				
				
				map.put(userId,pw);
				
				//브로드 캐스트 준비 
				S server = new S(userId,br);
				server.start();
			}
		} catch (IOException e) {
			System.out.println("클라이언트와 연결이 끊어짐");
		}
		
		
	}

}
