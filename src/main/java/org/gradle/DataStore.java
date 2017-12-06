package org.gradle;

import static edu.ust.seis.pos.Commons.DATA_STORE_BOOK;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class DataStore {

	private static HSSFWorkbook workBookObject;
	private File workBookFile;
	private FileOutputStream workBookFileOutputStream;
	private final String workBookName = DATA_STORE_BOOK;

	public DataStore() throws URISyntaxException, IOException {

		// String referencePath =
		// "C:/Users/Gideon/git/TRLBuild/src/main/resources/TRLData.xls";
		// referencePath = new SetProperty().setReferencePath()
		// +"/classes/TRLData.xls";

		// referencePath = "/resources/dbSpreadSheet.xls"; //new
		// SetProperty().setReferencePath() +"/resources/TRLData.xls";
		workBookFile = new File(DATA_STORE_BOOK);
//		workBookFile = Commons.createFile(DataStore.class, workBookName);
		if (!workBookFile.exists()) {
			// Blank workbook
			workBookObject = new HSSFWorkbook();
			workBookFileOutputStream = new FileOutputStream(workBookFile);
			workBookObject.write(workBookFileOutputStream);
			

		}
		

	}
	
	

	public InputStream createDBSpreadSheet() throws IOException,
			URISyntaxException {

		if (!workBookFile.exists()) {
			// Blank workbook
			workBookObject = new HSSFWorkbook();
			workBookFileOutputStream = new FileOutputStream(workBookFile);
			workBookObject.write(workBookFileOutputStream);
			System.out.println("Data File created successfully");

		}

		InputStream in = new FileInputStream(workBookFile);

		String inventoryDataHeader[] = { "UPC", "Item Name", "Unit",
				"Quantity in Stock", "Auto Restock Level" };

		sheetCreator("Inventory", inventoryDataHeader);
		System.out.println("Inventory");

		String bookDataHeader[] = { "ISBN", "Book Name", "Author", "Edition",
				"Number of Copies" };
		sheetCreator("Book Data", bookDataHeader);

		String bookCopyDataHeader[] = { "Copy ID", "Book Name", "ISBN" };
		sheetCreator("Book Copy Data", bookCopyDataHeader);

		// int numberOfSheets = workBookObject.getNumberOfSheets();
		// System.out.println("\t" + "Number of sheets are: " + numberOfSheets);
		//
		// for (int i = 0; i < numberOfSheets; i++) {
		//
		// System.out.println("\t" + workBookObject.getSheetName(i)
		// + " Sheet was created\n");
		// }

		return in;

	}

	
	public String test(){
		
		return workBookObject.getSheetName(0).toString();
		
	}
	
	
	private void sheetCreator(String sheetName, String headerName[]) {

		if (workBookObject.getSheet(sheetName).equals(null)) {
			// Create a blank sheet object
			HSSFSheet sheet1 = workBookObject.createSheet(sheetName);
			HSSFRow header = sheet1.createRow(0);

			for (int i = 0; i < headerName.length; i++) {

				header.createCell(i).setCellValue(headerName[i]);
				sheet1.autoSizeColumn(i);

			}

		}
	}

	File createTRLDataFile() throws IOException, URISyntaxException {

		if (!workBookFile.exists()) {

			String studentDataHeader[] = { "Student ID", "First Name",
					"Last Name", "Major" };
			sheetCreator("Student Data", studentDataHeader);
			System.out.println("student");
			String bookDataHeader[] = { "ISBN", "Book Name", "Author",
					"Edition", "Number of Copies" };
			sheetCreator("Book Data", bookDataHeader);
			String bookCopyDataHeader[] = { "Copy ID", "Book Name", "ISBN" };
			sheetCreator("Book Copy Data", bookCopyDataHeader);
			
			// Blank workbook
			workBookObject = new HSSFWorkbook();
			workBookFileOutputStream = new FileOutputStream(workBookFile);
			workBookObject.write(workBookFileOutputStream);
//			System.out.println("Data File created successfully");

//			int numberOfSheets = workBookObject.getNumberOfSheets();
//			System.out.println("\t" + "Number of sheets are: " + numberOfSheets);
//			for (int i = 0; i < numberOfSheets; i++) {
//
//				System.out.println("\t" + workBookObject.getSheetName(i)
//						+ " Sheet was created\n");
//			}

			workBookFileOutputStream.close();

		}

		else {

			// System.out.println("\nData file exist for this system\n");
		}

		return workBookFile;

	}

}
