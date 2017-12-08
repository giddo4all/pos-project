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

public class BookCopyData {
	
	
	void collectBookCopyData() throws IOException, URISyntaxException {

		ArrayList <String> bookData = new ArrayList <String> ();
		Scanner sc = new Scanner (System.in);

		System.out.println("Enter Book ISBN:");
		String copyISBN = sc.nextLine();
		bookData.add(copyISBN);
		
		System.out.println("Enter TRL Book Copy ID");
		String bookCopyID = sc.nextLine();
		bookData.add(bookCopyID);

		System.out.println("Enter Book Name");
		String bookName = sc.nextLine();
		bookData.add(bookName);

		System.out.println("Enter Number of copies to add");
		String lastAddedNumberOfCopies = sc.nextLine();
		bookData.add(lastAddedNumberOfCopies);
		
		new DataStore().dataStoreWrite(bookData, "Book Copy Data");

	}
	
	
	
}

