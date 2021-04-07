package JAVAP;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Hashtable;
import java.util.Scanner;

public class Client extends Thread{
	static Scanner scan = new Scanner(System.in);
	BufferedReader br;
	
	public Client(BufferedReader br) {
		this.br = br;
	}
	@Override
	public void run() {
		while(true){
		if(br!=null) {
			String line;
			try {
				line = br.readLine();
				System.out.println(line);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}}
		
	}
	
	
	public static void main(String[] args) {
		BufferedReader br = null;
		
		try {
			Socket socket = new Socket("127.0.0.1", 9990);
		System.out.println("채팅 서버에 연결 되었습니다");
		PrintWriter pw = new PrintWriter(
				new BufferedOutputStream(socket.getOutputStream()));
		pw.println(args[0]);	
		pw.flush();
		br = new BufferedReader(
				new InputStreamReader(socket.getInputStream()));
		String inMessage = br.readLine();
		System.out.println(inMessage);
		
		//메세지 수신대기 
		Client client = new Client(br);
		client.start();
		while(true) {
			String line = scan.nextLine();
			pw.println(line);	
			pw.flush();
		}
		
		}catch (IOException e) {
			e.printStackTrace();
		}
	}

}
