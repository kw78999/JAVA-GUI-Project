package libSearchProgram;


public class ResetThread implements Runnable {
	static int timer = 10;  //�⺻ Ÿ�̸� 
	 
	
	@Override
	public void run() {
		
		
		//1�ʿ� 1�� ���̳ʽ��ϰ� 10�ʵ�  Ÿ�̸Ӱ� 0���� ������ ���ΰ�ħ 
		//���� �׼Ǹ����ʸ� Ŭ���ϸ� timer�� 10���� �ʱ�ȭ��
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
