package edu.ust.seis.pos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

import static edu.ust.seis.pos.Commons.DATA_STORE_BOOK;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Row;

public class DataStore {

	private static HSSFWorkbook wrkbk;

	private File excelFile;
	private FileOutputStream excelFileOut;
//	private String referencePath;
	String bookCopyDataHeader[] = { "Copy ID", "Book Name", "ISBN" };

	public DataStore() throws URISyntaxException, IOException {

//		referencePath = DATA_STORE_BOOK;
		excelFile = new File(Commons.getResourcesFile(DATA_STORE_BOOK));
//		excelFile = new File(DATA_STORE_BOOK); // working but file in top level dir
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
		InputStream in = null;
		try {
			in = new FileInputStream(getDataStoreFile());
		} finally {
			// in.close();
		}
		return new HSSFWorkbook(in);

	}

	// public HSSFSheet getDataStoreSheet(String sheetName, String headerName[])
	// throws IOException {
	// return sheetCreator(sheetName, headerName);
	// }

	// public HSSFSheet getDataStoreSheet(String sheetName) throws IOException {
	// File trlDataFile = getDataStoreFile();
	// InputStream in = null;
	// HSSFSheet sheet;
	// try {
	// in = new FileInputStream(trlDataFile);
	// sheet = new HSSFWorkbook(in).getSheet(sheetName);
	// } finally {
	// in.close();
	// }
	//
	// return sheet;
	// }
	
	public HSSFSheet createSheet(String sheetName) throws IOException{
		
		String[] headerName = Commons.sheetNameToHeaderMap().get(sheetName);
		return createSheet(sheetName, headerName);
		
	}

	public HSSFSheet createSheet(String sheetName, String[] headerName) throws IOException {
		HSSFSheet dataStoreSheet = null;
		InputStream in = null;
//		String[] headerName = Commons.sheetNameToHeaderMap().get(sheetName);
		// Create a blank sheet

		File trlDataFile = getDataStoreFile();
		in = new FileInputStream(trlDataFile);
		HSSFWorkbook wk = new HSSFWorkbook(in);
		HSSFSheet testSheet = wk.getSheet(sheetName);

		try {
			if (testSheet == null) {
				try {

					dataStoreSheet = wk.createSheet(sheetName);
					HSSFRow header = dataStoreSheet.createRow(0);
					for (int i = 0; i < headerName.length; i++) {
						header.createCell(i).setCellValue(headerName[i]);
						dataStoreSheet.autoSizeColumn(i);
					}

					excelFileOut = new FileOutputStream(excelFile);
					wk.write(excelFileOut);

				} finally {

					excelFileOut.close();
				}
			} else {

				in = new FileInputStream(trlDataFile);
				dataStoreSheet = new HSSFWorkbook(in).getSheet(sheetName);

			}

		} finally {
			in.close();
		}
		return dataStoreSheet;
	}

	// TODO: Outdated, for Test only
	public void dataStoreWrite(ArrayList<String> data, String sheetName)
			throws IOException, URISyntaxException {

		// DataStore dataStoreObject = new DataStore();
		// getDataStoreSheet("Book Copy Data", bookCopyDataHeader);
		HSSFWorkbook workbook = getDataStoreWorkBook();
		HSSFSheet bookDataSheet = workbook.getSheet("Book Copy Data");
		int lastRowNumber = bookDataSheet.getLastRowNum();
		HSSFRow row = bookDataSheet.createRow(++lastRowNumber);
		for (int i = 0; i < data.size(); i++) {
			row.createCell(i).setCellValue(data.get(i));
			bookDataSheet.autoSizeColumn(i);
		}

		FileOutputStream out = new FileOutputStream(getDataStoreFile());
		workbook.write(out);
		out.close();

	}

	public void dataStoreWrite(Map<String, String> dataMap, String sheetName)
			throws IOException, URISyntaxException {

		String[] sheetHeader = Commons.sheetNameToHeaderMap().get(sheetName);
		createSheet(sheetName);
		HSSFWorkbook workbook = getDataStoreWorkBook();
		HSSFSheet bookDataSheet = workbook.getSheet(sheetName);
		int lastRowNumber = bookDataSheet.getLastRowNum();
		HSSFRow headerRow = bookDataSheet.getRow(0);
		HSSFRow row = bookDataSheet.createRow(++lastRowNumber);

		for (String key : dataMap.keySet()) {

			for (Iterator<Cell> cl = headerRow.cellIterator(); cl.hasNext();) {
				Cell nextCell = cl.next();
				if (nextCell.getStringCellValue().equals(key)) {
					int cellNo = nextCell.getColumnIndex();
					row.createCell(cellNo).setCellValue(dataMap.get(key));
					bookDataSheet.autoSizeColumn(cellNo);
				}
			}
		}

		FileOutputStream out = new FileOutputStream(getDataStoreFile());
		workbook.write(out);
//		System.out.println("Datastore write successfully");
		out.close();
	}

	public void dataStoreUpdate(String targetHeaderColumn, String newValue,
			String sheetName, String primaryKeyColumn, String primaryKeyValue)
			throws Exception {

		// String[] sheetHeader = Commons.sheetNameToHeaderMap().get(sheetName);
		boolean isFound = false;
		createSheet(sheetName);
		HSSFWorkbook workbook = getDataStoreWorkBook();
		HSSFSheet dataSheet = workbook.getSheet(sheetName);
		// int lastRow = dataSheet.getLastRowNum();
		Row heading = dataSheet.getRow(0);
		int targetColumnIndex = -1;
		for (Cell c : heading) {
			if (c.getStringCellValue().equals(targetHeaderColumn)) {
				targetColumnIndex = c.getColumnIndex();
				break;
			}

		}

		for (Cell c : heading) {
			if (c.getStringCellValue().equals(primaryKeyColumn)) {
				int primaryColumnIndex = c.getColumnIndex();

				for (Iterator<Row> rw = dataSheet.rowIterator(); rw.hasNext();) {

					Row nextRow = rw.next();
					Cell cl = nextRow.getCell(primaryColumnIndex);
					String cellVal = cl.getStringCellValue();

					if (cellVal.equals(primaryKeyValue)) {
						isFound = true;
						nextRow.getCell(targetColumnIndex).setCellValue(
								newValue);
						dataSheet.autoSizeColumn(primaryColumnIndex);
						break;
					}

				}
				break;

			}
		}

		if (!isFound) {

			throw new RecordNotFoundException(
					"The provided Primary key was not found in the transversed record. Please provide a valid primary key");
		}

		FileOutputStream out = new FileOutputStream(getDataStoreFile());
		workbook.write(out);
		out.close();

	}

	public ArrayList<String> dataStoreRead(String sheetName,
			String primaryKeyColumnName, String[] columnsNamesToRead,
			String primaryKeyValue) throws IOException {

		boolean isFound = false;
		ArrayList<String> readValues = new ArrayList<String>();
		String[] sheetHeader = Commons.sheetNameToHeaderMap().get(sheetName);
		createSheet(sheetName);
		HSSFWorkbook workbook = getDataStoreWorkBook();
		HSSFSheet dataSheet = workbook.getSheet(sheetName);
		Row heading = dataSheet.getRow(0);
		ArrayList<Integer> colndex = new ArrayList<Integer>();
		for (Iterator<Cell> cell = heading.cellIterator(); cell.hasNext();) {
			Cell nextCell = cell.next();
			for (String cr : columnsNamesToRead) {
				if (nextCell.getStringCellValue().equals(cr)) {
					colndex.add(nextCell.getColumnIndex());
				}
			}

		}

		if (colndex != null) {
			for (Cell c : heading) {
				if (c.getStringCellValue().equals(primaryKeyColumnName)) {
					int primaryColumnIndex = c.getColumnIndex();

					for (Iterator<Row> rw = dataSheet.rowIterator(); rw
							.hasNext();) {

						Row nextRow = rw.next();
						Cell cl = nextRow.getCell(primaryColumnIndex);

						// try{
						// String cellVal = cl.getStringCellValue();

						try {
							if (cl.getStringCellValue().equals(primaryKeyValue)) {
								isFound = true;
								for (Iterator<Cell> cell = nextRow
										.cellIterator(); cell.hasNext();) {

									Cell nextCell = cell.next();
									for (int cr : colndex) {
										if (nextCell.getColumnIndex() == cr) {
											readValues.add(nextCell
													.getStringCellValue());
										}
									}

								}
							}
						} catch (NullPointerException e) {

						}

					}
				}

			}
		}


		return readValues;

	}

	public int getDataStoreRowIndex(String sheetName, String primaryKeyColumnName,
			String primaryKeyValue) throws IOException, RecordNotFoundException {

		int rowIndex = -7;
		HSSFWorkbook workbook = getDataStoreWorkBook();
		HSSFSheet dataSheet = workbook.getSheet(sheetName);
		Row heading = dataSheet.getRow(0);
		int primaryColumnKeyColIndex = -1;
		for (Iterator<Cell> cell = heading.cellIterator(); cell.hasNext();) {
			Cell nextCell = cell.next();
				if (nextCell.getStringCellValue().equals(primaryKeyColumnName)) {
					primaryColumnKeyColIndex = nextCell.getColumnIndex();
				}
			}


		if (primaryColumnKeyColIndex != -1) {
					for (Iterator<Row> rw = dataSheet.rowIterator(); rw
							.hasNext();) {

						Row nextRow = rw.next();
						Cell cl = nextRow.getCell(primaryColumnKeyColIndex);
						
							if (cl.getStringCellValue().equals(primaryKeyValue)) {
								rowIndex = nextRow.getRowNum();
				}

			}
		}

		return rowIndex;

	}
	
	
//	public Row getRecordRow(String sheetName, String primaryKeyColumnName,
//			String primaryKeyValue) throws IOException, RecordNotFoundException {
//
//		Row search
//		HSSFWorkbook workbook = getDataStoreWorkBook();
//		HSSFSheet dataSheet = workbook.getSheet(sheetName);
//		Row heading = dataSheet.getRow(0);
//		int primaryColumnKeyColIndex = -1;
//		for (Iterator<Cell> cell = heading.cellIterator(); cell.hasNext();) {
//			Cell nextCell = cell.next();
//				if (nextCell.getStringCellValue().equals(primaryKeyColumnName)) {
//					primaryColumnKeyColIndex = nextCell.getColumnIndex();
//				}
//			}
//
//
//		if (primaryColumnKeyColIndex != -1) {
//					for (Iterator<Row> rw = dataSheet.rowIterator(); rw
//							.hasNext();) {
//
//						Row nextRow = rw.next();
//						Cell cl = nextRow.getCell(primaryColumnKeyColIndex);
//						
//							if (cl.getStringCellValue().equals(primaryKeyValue)) {
//								
//				}
//
//			}
//		}
//
//		return isFound;
//
//	}

	public void dataStoreRemoveRowEntry(String sheetName, String primaryKeyHeader, String primaryKeyValue) throws IOException, RecordNotFoundException{
		
//		public static void removeRow(HSSFSheet sheet, int rowIndex) {
		HSSFWorkbook workbook = getDataStoreWorkBook();
		HSSFSheet sheet = workbook.getSheet(sheetName);
		
		int rowIndex = getDataStoreRowIndex(sheetName, primaryKeyHeader, primaryKeyValue);
		
		    int lastRowNum=sheet.getLastRowNum();
		    if(rowIndex>=0&&rowIndex<lastRowNum){
		        sheet.shiftRows(rowIndex+1,lastRowNum, -1);
		    }
		    if(rowIndex==lastRowNum){
		        HSSFRow removingRow=sheet.getRow(rowIndex);
		        if(removingRow!=null){
		            sheet.removeRow(removingRow);
		        }
		    }
		}

	

}
