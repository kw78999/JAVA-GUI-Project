package JAVAP;

import java.awt.Color;
import java.awt.Container;
import java.awt.FileDialog;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FilenameFilter;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import JAVAP.ExcelWrite;

public class ExcelFrame extends JFrame{
	
	JPanel panel1, panel2;
	public static String filePath;
	
	public ExcelFrame() {
		setSize(780, 460);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(null);
		
		Font menuFont = new Font("잘풀리는오늘 Medium", Font.PLAIN, 15);
		
		JMenuBar mb = new JMenuBar();
		setJMenuBar(mb);
		mb.setBackground(new Color(212, 255, 223));
		
		JMenu mnFile = new JMenu("파일");
		mnFile.setFont(menuFont);
		mnFile.setHorizontalAlignment(SwingConstants.CENTER);
		mb.add(mnFile);
		
		JMenuItem saveXl = new JMenuItem("엑셀저장");
		saveXl.setFont(menuFont);
		mnFile.add(saveXl);
		
		
		
		saveXl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FileNameExtensionFilter filter = new FileNameExtensionFilter("xls", "xls");
				
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setFileFilter(filter);
				int result=fileChooser.showSaveDialog(null);
				if(result != JFileChooser.APPROVE_OPTION) {
					JOptionPane.showMessageDialog(null, "취소하셨습니다.","경고",JOptionPane.WARNING_MESSAGE);
				}
				filePath = fileChooser.getSelectedFile().getPath();
//				fileName = fileChooser.getSelectedFile().getName();
				try {
					new ExcelWrite();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		
		panel2 = new JPanel();
		panel2.setBounds(0, 0, 780, 460);
		panel2.setBackground(Color.WHITE);
		panel2.setLayout(null);
		
		LibStatMgr mgr;
		String col[] = {"년도","월","대출총합","독서왕","인기카테고리"};
		mgr = new LibStatMgr();
		Vector<LibStatBean> vlist = mgr.getListStat();
		String row[][] = new String[vlist.size()][5];
		for (int i = 0; i < row.length; i++) {
			LibStatBean bean = vlist.elementAt(i);
			row[i][0] = bean.getYear();
			row[i][1] = bean.getMon();
			row[i][2] = bean.getCnt();
			row[i][3] = bean.getFst();
//			row[i][4] = bean.getSnd();
//			row[i][5] = bean.getThd();
			row[i][4] = bean.getPopCate();
//			row[i][7] = bean.getMaxCount()+"";
//			row[i][8] = bean.getAvgCnt()+"";
//			row[i][9] = bean.getFstCnt()+"";
//			row[i][10] = bean.getSndCnt()+"";
//			row[i][11] = bean.getThdCnt()+"";
		}
		DefaultTableModel model = new DefaultTableModel(row,col);
		JTable table = new JTable(model);
		JScrollPane scroll = new JScrollPane(table);
		panel2.add(scroll);
		scroll.setBounds(0, 0, 780, 420);
		add(panel2);
		setVisible(true);
	}
	
	ActionListener saveXl = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			
		}
	};
	
}
