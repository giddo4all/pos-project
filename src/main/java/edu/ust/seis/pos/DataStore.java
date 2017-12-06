package edu.ust.seis.pos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;

import static edu.ust.seis.pos.Commons.*;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;

public class DataStore {

	private static HSSFWorkbook wrkbk;

	private File excelFile;
	private FileOutputStream excelFileOut;
	private String referencePath;
	String bookCopyDataHeader[] = { "Copy ID", "Book Name", "ISBN" };

	public DataStore() throws URISyntaxException, IOException {

		referencePath = DATA_STORE_BOOK;
		excelFile = new File(referencePath);
		
			if (!excelFile.exists()) {
				try {
				wrkbk = new HSSFWorkbook();
				excelFileOut = new FileOutputStream(excelFile);
				wrkbk.write(excelFileOut);
				System.out.println("Data File created successfully");
				} finally {
					excelFileOut.close();
			}
		
			
		}

	}

	public File getDataStoreFile() {
		return excelFile;

	}

	public HSSFWorkbook getDataStoreWorkBook() throws IOException {
		File trlDataFile = null;
		InputStream in = null;
		
		try {
			trlDataFile = getDataStoreFile();
			in = new FileInputStream(trlDataFile);
		}finally{
//			in.close();
		}
		return new HSSFWorkbook(in);

	}



	public HSSFSheet getDataStoreSheet(String sheetName, String headerName[])
			throws IOException {
		return sheetCreator(sheetName, headerName);
	}

	public HSSFSheet getDataStoreSheet(String sheetName) throws IOException {
		File trlDataFile = getDataStoreFile();
		InputStream in = null;
		HSSFSheet sheet;
		try {
			in = new FileInputStream(trlDataFile);
			sheet = new HSSFWorkbook(in).getSheet(sheetName);
		} finally {
			in.close();
		}
		
		return sheet;
	}

	private HSSFSheet sheetCreator(String sheetName, String headerName[])
			throws IOException {
		HSSFSheet dataStoreSheet = null;
		InputStream in = null;
		// Create a blank sheet
		try{
		File trlDataFile = getDataStoreFile();
		 in = new FileInputStream(trlDataFile);
		HSSFWorkbook wk = new HSSFWorkbook(in);
		HSSFSheet testSheet = wk.getSheet(sheetName);

		if (testSheet == null) {

			dataStoreSheet = wk.createSheet(sheetName);
			HSSFRow header = dataStoreSheet.createRow(0);
			for (int i = 0; i < headerName.length; i++) {
				header.createCell(i).setCellValue(headerName[i]);
				dataStoreSheet.autoSizeColumn(i);
			}
		} else {

			dataStoreSheet = wk.getSheet(sheetName);
		}

		excelFileOut = new FileOutputStream(excelFile);
		wk.write(excelFileOut);
		
		} finally {
			in.close();
			excelFileOut.close();
		}
		return dataStoreSheet;
	}

	private void DBWrite(ArrayList<String> bookData) throws IOException,
			URISyntaxException {

		// FileInputStream in = new FileInputStream(file);
		// try {
		// java.nio.channels.FileLock lock = in.getChannel().lock();
		// try {
		// Reader reader = new InputStreamReader(in, charset);
		// ...
		// } finally {
		// lock.release();
		// }
		// } finally {
		// in.close();
		// }

		// File trlDataFile = new Database().createDBSpreadSheet();
		// InputStream in = new FileInputStream(trlDataFile);
		HSSFWorkbook workbook = new HSSFWorkbook();// (new
													// DataStore().createDBSpreadSheet());

		HSSFSheet bookDataSheet = workbook.getSheet("Book Data");

		int lastRowNumber = bookDataSheet.getLastRowNum();
		HSSFRow row = bookDataSheet.createRow(++lastRowNumber);

		for (int i = 0; i < bookData.size(); i++) {

			row.createCell(i).setCellValue(bookData.get(i));
			bookDataSheet.autoSizeColumn(i);
		}

		// FileOutputStream out = new FileOutputStream();
		// workbook.write(trlDataFile);
		System.out.println("Book Data updated successfully");

		// out.close();

	}

}
