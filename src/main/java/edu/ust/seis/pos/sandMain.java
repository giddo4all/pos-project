package edu.ust.seis.pos;

//import static edu.ust.seis.pos.Commons.DATA_STORE_BOOK;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static edu.ust.seis.pos.Commons.*;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class sandMain {

	// private static HSSFWorkbook wt;
	// private File workBookFile;
	// private static FileOutputStream workBookFileOutputStream;
	// private final String workBookName = DATA_STORE_BOOK;
	static ArrayList<String> reportList;
	List<String> reportList2;
	public static void main(String[] args) throws IOException,
			URISyntaxException {
		// TODO Auto-generated method stub

		// File f = new File("dbSpreadSheet.xls");
		// System.out.println(f.getCanonicalPath());
		// FileOutputStream fo = new FileOutputStream(f);
		// fo.write(0);
		// System.out.println(f.getClass().getCanonicalName());
		// File.createTempFile("test1", "test2");
		// DataStore ds = new DataStore();
		// ds.createTRLDataFile();
		// System.out.println(ds.test());
		// System.out.println(Commons.getProperty("inventorySheetName"));
		// // System.out.println(Commons.getFile(sandMain.class,
		// "app.properties").getPath());
		//
		// wt = new HSSFWorkbook();
		// workBookFileOutputStream = new FileOutputStream("mee.xls");
		// wt.write(workBookFileOutputStream);
		//
		// HSSFSheet sheet1 = wt.createSheet("stName");
		// HSSFRow header = sheet1.createRow(0);
		//
		//
		//
		// header.createCell(0).setCellValue("tk");
		// sheet1.autoSizeColumn(0);

		// new BookCopyData().collectBookCopyData();

//		Map<String, String> mp = Commons
//				.createPlaceHolderMapFromHeader(Commons.bookHeader);
//		 mp.put(Commons.BookHead.getString(Commons.BookHead.copyCount),
//		 "500");
//		mp.put(Commons.BookHead.getString(Commons.BookHead.bookName),
//				"2nd Test");
//		 mp.put(Commons.BookHead.getString(Commons.BookHead.copyID),
//		 "TRL0001");
//		 mp.put(Commons.BookHead.getString(Commons.BookHead.isbn),
//		 "97899556322");

//		DataStore ds = new DataStore();
//		// ds.dataStoreWrite(mp, Commons.bookSheet);
////		ds.dataStoreUpdate(Commons.BookHead.bookName.toString(), "2nd Test",
////				Commons.bookSheet, Commons.BookHead.copyID.toString(), "123");
//		String[] cy = { Commons.BookHead.bookName.toString(),Commons.BookHead.copyCount.toString()} ;
//		ArrayList<String> fr = ds.dataStoreRead(Commons.bookSheet, Commons.BookHead.copyID.toString(), cy, "343");
//		
//		for (String dd: fr){
//			System.out.println(dd);
//		}
		
//		reportList = new ArrayList<String>();
//		reportList = fr();
//		reportList.add("7676");
//		reportList.add("766");
//		reportList.add("76ere76");
//		reportList.add("76yyt76");
		fr2();
//		listFile(".");
//		for (String ds : reportList ){
//		System.out.println(ds);
////		System.out.println(Commons.timesStamp());
//		}
	}

	public static void fr2() throws IOException {
//		String filePath = "pos.jpg";
//		System.out.println(Commons.getProp("dataStoreBook"));
//		File file = new File(filePath);
//		File file = new File(URLDecoder.decode(sandMain.class.getResource(filePath).getPath(), "UTF-8"));
//		Commons.getFile(filePath);
//		String absolutePath = file.getAbsolutePath();
//String fg = Commons.getFile(filePath);
//		System.out.println(absolutePath);
//		System.out.println(file.getAbsolutePath());
//		File file = new File("33ed");
//		System.out.println(file.getAbsolutePath());
//		System.out.println(Commons.getResourcesFile(DATA_STORE_BOOK));
//		System.out.println(new File().);//("resources/" + file);
//		System.out.println("java version: "+System.getProperty("java.version")); 
//		System.out.println("javafx.version: " + System.getProperty("javafx.version"));
		System.out.println(System.getProperties());

	}
	public static void fr1() throws URISyntaxException, IOException{
//		System.out.println(sandMain.class.getClassLoader().getResource("login.fxml").getPath());
		System.out.println(Commons.getResourcesFile(DATA_STORE_BOOK));
	}
	
	public static void listFile(String path){
	File folder = new File(path);
	File[] listOfFiles = folder.listFiles();

	    for (int i = 0; i < listOfFiles.length; i++) {
	      if (listOfFiles[i].isFile()) {
	    	  System.out.println("@@@@@@@@@File@@@@@@@@@*");
	        System.out.println("File " + listOfFiles[i].getName());
	        System.out.println("@@@@@@@@@@@@@@@@@@*");
	        System.out.println("*******Directory*********");
	      } else if (listOfFiles[i].isDirectory()) {
	    	  System.out.println("*******Directory*********");
	        System.out.println("Directory " + listOfFiles[i].getName());
	        System.out.println("***************************");
	      }
	    }
}}
