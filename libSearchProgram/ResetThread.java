package libSearchProgram;


public class ResetThread implements Runnable {
	static int timer = 10;  //기본 타이머 
	 
	
	@Override
	public void run() {
		
		
		//1초에 1씩 마이너스하고 10초뒤  타이머가 0보다 작으면 새로고침 
		//각각 액션리스너를 클릭하면 timer가 10으로 초기화됨
		while(true) {
		try {
			
			Thread.sleep(1000);
			timer--;
			Thread.sleep(1000);
			timer--;
			Thread.sleep(1000);
			timer--;
			Thread.sleep(1000);
			timer--;
			Thread.sleep(1000);
			timer--;
			Thread.sleep(1000);
			timer--;
			Thread.sleep(1000);
			timer--;
			Thread.sleep(1000);
			timer--;
			Thread.sleep(1000);
			timer--;
			
			if(timer<0) {
			SFrame.viewlist();
			SFrame.textField.setText("");
			
		}} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	
	}
	
	
	}
}
