package JAVAP;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Vector;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import JAVAP.LibStatBean;
import JAVAP.LibStatMgr;

public class ExcelWrite {
	
	LibStatMgr mgr = new LibStatMgr();
	Vector<LibStatBean> vlist = mgr.getListStat(); 
	String[][] data = new String[vlist.size()][5];
	
	public ExcelWrite() throws Exception{
		
		FileOutputStream fos = new FileOutputStream(new File(".\\test.xls"));	
		HSSFWorkbook wb = new HSSFWorkbook();// ����(workbook)�� ����ϴ�.
		HSSFSheet sheet = wb.createSheet("Books");// "Books" Sheet�� ����ϴ�.
		HSSFRow row = null;// ������ ����� row�� cell�̿���.
		HSSFCell cell = null;
		
		for (int i = 0; i < data.length; i++) {
			LibStatBean bean = vlist.elementAt(i);
			data[i][0] = bean.getYear();
			data[i][1] = bean.getCnt();
			data[i][2] = bean.getMon();
			data[i][3] = bean.getFst();
			data[i][4] = bean.getPopCate();
		}
		for(int i=0; i<data.length; i++) {// ����� �����͸� ������ ���鼭 ����մϴ�.
			row = sheet.createRow(i);// row�� ������
			// �� cell�� �����͸� �Է��Ͽ��ݴϴ�.
			
			//		0	1	2	3	4
			//		1
			//		2
			//		3
			//		4
			
			cell = row.createCell(0);
			cell.setCellValue(data[i][0]);
			cell = row.createCell(1);
			cell.setCellValue(data[i][1]);
			cell = row.createCell(2);
			cell.setCellValue(data[i][2]);
			cell = row.createCell(3);
			cell.setCellValue(data[i][3]);
//			cell = row.createCell(4);
//			cell.setCellValue(dataArray[i][4]);
//			cell = row.createCell(5);
//			cell.setCellValue(dataArray[i][5]);
//			cell = row.createCell(6);
//			cell.setCellValue(dataArray[i][6]);
//			cell = row.createCell(7);
//			cell.setCellValue(dataArray[i][7]);
//			cell = row.createCell(8);
//			cell.setCellValue(dataArray[i][8]);
		}//---for
	
		wb.write(fos);
	
		if(fos != null) {
			fos.close();// close�� �޸� ������ �����ϱ� ���Ͽ� �ʼ�
	
		}
	}
//
//	public static void main(String[] args) {
//		try {
//			new ExcelWrite();
//			System.out.println("�μ⼺��");
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("�μ����");
//		}
//	}
	}	
