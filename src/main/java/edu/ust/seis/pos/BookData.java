package edu.ust.seis.pos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;


public class BookData {
	
	void collectBookData() throws IOException, URISyntaxException {

		ArrayList <String> bookData = new ArrayList <String> ();
		Scanner sc = new Scanner (System.in);

		System.out.println("Enter Book ISBN");
		String isbn = sc.nextLine();
		bookData.add(isbn);
		
		System.out.println("Enter TRL Book ID:");
		String trlBookID = sc.nextLine();
		bookData.add(trlBookID);

		System.out.println("Enter Book Title");
		String bookTitle = sc.nextLine();
		bookData.add(bookTitle);

		System.out.println("Enter Author's Name - separate multiple names with commas");
		String authors = sc.nextLine();
		bookData.add(authors);

		System.out.println("Enter Book's Edition:");
		String edition = sc.nextLine();
		bookData.add(edition);
		
		new  BookData().DBWrite(bookData);
		
	}

	private void DBWrite (ArrayList<String> bookData) throws IOException, URISyntaxException {

//		FileInputStream in = new FileInputStream(file);
//		try {
//		    java.nio.channels.FileLock lock = in.getChannel().lock();
//		    try {
//		        Reader reader = new InputStreamReader(in, charset);
//		        ...
//		    } finally {
//		        lock.release();
//		    }
//		} finally {
//		    in.close();
//		}
		
//		File trlDataFile = new Database().createDBSpreadSheet();
//		InputStream in = new FileInputStream(trlDataFile);
		HSSFWorkbook workbook = new HSSFWorkbook();
		
		HSSFSheet bookDataSheet = workbook.getSheet("Book Data");
		
		int lastRowNumber = bookDataSheet.getLastRowNum();
		HSSFRow row = bookDataSheet.createRow(++lastRowNumber);
		
		for (int i = 0; i < bookData.size(); i++) {
			
			row.createCell(i).setCellValue(bookData.get(i));
			bookDataSheet.autoSizeColumn(i);
		}
		


//		FileOutputStream out = new FileOutputStream();
//		workbook.write(trlDataFile);
		System.out.println("Book Data updated successfully");
		
//		out.close();

	}

}
