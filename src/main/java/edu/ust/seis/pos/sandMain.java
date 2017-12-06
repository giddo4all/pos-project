package edu.ust.seis.pos;

//import static edu.ust.seis.pos.Commons.DATA_STORE_BOOK;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class sandMain {

//	private static HSSFWorkbook wt;
//	private File workBookFile;
//	private static FileOutputStream workBookFileOutputStream;
//	private final String workBookName = DATA_STORE_BOOK;
	
	
	public static void main(String[] args) throws IOException, URISyntaxException {
		// TODO Auto-generated method stub
		
//		File f = new File("dbSpreadSheet.xls");
//		System.out.println(f.getCanonicalPath());
//		FileOutputStream  fo = new FileOutputStream(f);
//		fo.write(0);
//		System.out.println(f.getClass().getCanonicalName());
//		File.createTempFile("test1", "test2");
//		DataStore ds = new DataStore();
//		ds.createTRLDataFile();
//		System.out.println(ds.test());
//		System.out.println(Commons.getProperty("inventorySheetName"));
////		System.out.println(Commons.getFile(sandMain.class, "app.properties").getPath());
//		
//		wt = new HSSFWorkbook();
//		workBookFileOutputStream = new FileOutputStream("mee.xls");
//		wt.write(workBookFileOutputStream);
//		
//		HSSFSheet sheet1 = wt.createSheet("stName");
//		HSSFRow header = sheet1.createRow(0);
//
//		
//
//			header.createCell(0).setCellValue("tk");
//			sheet1.autoSizeColumn(0);

		new BookCopyData().collectBookCopyData();
		

	}

}
