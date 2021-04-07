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

		
		sendMessage(userId+"���� ���� �Ͽ����ϴ�") ;
	}
	
	void sendMessage(String line){
		
		//���޹��� �޼����� �����Ͽ� �Ѹ� 
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
		//����  ServerSocket -> accept -> socket
		
		BufferedReader br = null;
		ServerSocket serverSocket = null; 
		try {
			serverSocket = new ServerSocket(8880);
			System.out.println("Ŭ���̾�Ʈ ���� �����....");
			while(true) {
				Socket socket = serverSocket.accept();
				System.out.println("Ŭ���̾�Ʈ ���� ��");
				//Ŭ���̾�Ʈ �޼��� �ޱ�
				br = new BufferedReader(
						new InputStreamReader(socket.getInputStream()));
				String userId = br.readLine();
				//System.out.println(userId+"���� ���ӵ�.");
				PrintWriter pw = new PrintWriter(
						new BufferedOutputStream(socket.getOutputStream()));
				
				
				map.put(userId,pw);
				
				//��ε� ĳ��Ʈ �غ� 
				S server = new S(userId,br);
				server.start();
			}
		} catch (IOException e) {
			System.out.println("Ŭ���̾�Ʈ�� ������ ������");
		}
		
		
	}

}
