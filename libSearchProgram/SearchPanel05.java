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
		
		
		Font lbfont = new Font("��Ǯ���¿��� Medium", Font.PLAIN, 12);
		Font lbfont2 = new Font("��Ǯ���¿��� Medium", Font.PLAIN, 14);
		
		
		JDialog dialog;

	public SearchPanel05() {
		TitledBorder tB2 = new TitledBorder(new LineBorder(Color.LIGHT_GRAY, 3, true),"���� ��û");
		tB2.setTitleFont(new Font("��Ǯ���¿��� Medium", Font.BOLD, 18));
		
	
		JTextArea ta1;
		tf = new JTextField();
		tf.addActionListener(this);
		
		setLayout(null);

		JLabel lb1 = new JLabel("�а� ���� ������ ��ǥ�غ�����.");
		lb1.setBounds(20, 30, 200, 14);
		lb1.setFont(lbfont);
		
		ta1 = new JTextArea("������ �����Ͻ� �е鿡�Դ�\n"
				+ "���� ī�信�� ����� �� �ִ� �Ƹ޸�ī��(s) ������ �帳�ϴ�.");
		ta1.setEditable(false);
		ta1.setBounds(20, 60, 400, 32);
		ta1.setFont(lbfont2);

		JLabel lb2 = new JLabel("ȸ����ȣ");
		lb2.setBounds(20, 140, 52, 14);
		lb2.setFont(lbfont2);
		
		JLabel lb3 = new JLabel("ȸ����");
		lb3.setBounds(20, 110, 52, 14);
		lb3.setFont(lbfont2);
		
		tf.setBounds(75, 136, 140, 24);
		
		tf1 = new JTextField();
		tf1.addActionListener(this);
		tf1.setBounds(75, 110, 140, 24);
		add(tf1);
		
		
		btn1 = new JButton("��ǥ");
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
		dialog.setTitle("ȸ���� ã�� �� �����ϴ�");
		JLabel lb = new JLabel("ȸ����� ȸ����ȣ�� Ȯ���ϼ���.");
		lb.setBounds(50, 20, 300, 20);
		lb.setFont(lbfont2);
		dialog.add(lb);
		dialog.setSize(300, 180);
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		JButton btn3 = new JButton("Ȯ��");
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
		//�߰��� ����************************************
		//����� ������ ID�� ũ�⺸�� ���� ���� �Է¹�����
		//-1�� �ٲ��ִ� ������ ���̵� Ȯ���˾� Ȱ���ϱ�
		String s = tf.getText();//�Էµ� ����(ȸ����ȣ)�� s�� ���
		int inputID;					//ȸ����ȣ�� ���ڷ� �ٲ� ���� ���� inputID
		if(s.equals("")) { 			//��Ǫ ���࿡ ȸ����ȣ�� �Է����� �ʾҴٸ�(tf�� �Է��� ���� ���ٸ�)
			s = "-1";					//s�� "-1"�� ��� (DB.ȸ����ȣ�� -1�� ���� ��)
			inputID = Integer.parseInt(s);//s�� ���ڷ� �ٲ� inputID�� ��´�
			}else {inputID = Integer.parseInt(s);}//�ƴ϶��(�Է°�����) s�� inputID�� ��´�
	
		mgr = new BMEMBERSMgr();
		
		bean = mgr.idCheck(inputID);//��Ʈ(ȸ����ȣ)�� �Ű������� �޴� MID�� MNAME ��ȸ�ϴ� �޼ҵ�
		//����� ���� =  mgr �޼ҵ� id üũ�� �Ű����� 3������ ��ȯ��ȫ�浿 ���� �ִ´� ****** �� �ټ���
		
		System.out.println("mgr������"+bean.getMID()+bean.getMNAME());
		
		
		mID = bean.getMID();//�� ����ִ� MID (��ȸ�ϱ� ����)
		name = bean.getMNAME();//�� ����ִ� MNAME (���� â�� �ݿ��� ��)
		
		String inputName = tf1.getText();//ȸ���̸� �Է��� ��
		testInputName = tf1.getText();//ȸ���̸� �Է��� ��
		Object obj = e.getSource();//��ư ��ġ���� Ȯ�ο� ������Ʈ
		
		if(obj.equals(btn1)&&inputID==mID&&inputName.equals(name)) {
			System.out.println(name+"��ư, ���̵�, ȸ���� ��ġ = ��ǥ������ ����");
			new VFrame();
		}else if(obj.equals(btn1)&&(inputID==-1||inputName!=name)){//��Ʈ��Ÿ���ε� != �����ڰ� �´��� Ȯ���ϱ�. ������ �� ��.
			System.out.println("�̸��� ȸ����ȣ�� Ȯ���ϼ���.");
			this.IDdialog();//���̵� Ȯ���ϼ��� �˾�. �̰� �׼Ǹ����ʷ� ���δϱ� this�� ������ �ߴµ� �ͱ�
		}
//		else if(obj.equals(btn1)){
//			System.out.println("������mID: "+mID+"\n������name: "+name+"\n�Էµ�inputID: "+s+"\n��ȯ�Ȱ�:"+inputID);
//		}
	}

}
