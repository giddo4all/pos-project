package edu.ust.seis.pos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Commons {

	public static final String DATA_STORE_BOOK = Commons
			.getProperty("dataStoreBook");

	// Inventory DataStore
	public static final String INV_SHEETNAME = Commons
			.getProperty("inventorySheetName");
	public static final String INV_UPC = Commons.getProperty("inventoryCol1");
	public static final String INV_ITEM = Commons.getProperty("inventoryCol2");
	public static final String INV_UNIT_TYPE = Commons
			.getProperty("inventoryCol3");
	public static final String INV_QUANT = Commons.getProperty("inventoryCol4");
	public static final String INV_BRAND = Commons.getProperty("inventoryCol5");
	public static final String INV_UNIT_PRICE = Commons
			.getProperty("inventoryCol6");
	public static final String bookCopyDataHeader[] = { "Copy ID", "Book Name",
			"ISBN" };
	public static final String[] INV_HEADER = { INV_UPC, INV_BRAND, INV_ITEM,
			INV_UNIT_TYPE, INV_QUANT, INV_UNIT_PRICE };

	// Product Catalog DataStore
	public static final String CAT_SHEETNAME = Commons
			.getProperty("productCatalogueSheetName");
	public static final String CAT_UPC = Commons
			.getProperty("prodCatalogueCol1");
	public static final String CAT_ITEM = Commons
			.getProperty("prodCatalogueCol2");
	public static final String CAT_UNIT_TYPE = Commons
			.getProperty("prodCatalogueCol4");
	public static final String CAT_BRAND = Commons
			.getProperty("prodCatalogueCol3");
	public static final String CAT_PRICE = Commons
			.getProperty("prodCatalogueCol5");
	public static final String[] CAT_HEADER = { CAT_UPC, CAT_BRAND, CAT_ITEM,
			CAT_UNIT_TYPE, CAT_PRICE };

	// Cashier DataStore
	public static final String CH_SHEETNAME = Commons
			.getProperty("cashierSheetName");
	public static final String CH_TRAN_ID = Commons.getProperty("cashierCol1");
	public static final String CH_UPC = Commons.getProperty("cashierCol2");
	public static final String CH_ITEM = Commons.getProperty("cashierCol3");
	public static final String CH_UNIT_TYPE = Commons
			.getProperty("cashierCol4");
	public static final String CH_UNIT_SOLD = Commons
			.getProperty("cashierCol5");
	public static final String CH_PRICE = Commons.getProperty("cashierCol6");
	public static final String CH_AUTH = Commons.getProperty("cashierCol7");
	public static final String CH_RETURN = Commons.getProperty("cashierCol8");
	public static final String[] CH_HEADER = { CH_TRAN_ID, CH_UPC, CH_ITEM,
			CH_UNIT_TYPE, CH_UNIT_SOLD, CH_PRICE, CH_AUTH, CH_RETURN };

	// Register DataStore
	public static final String REG_SHEETNAME = Commons
			.getProperty("registerSheetName");
	public static final String REG_TRAN_ID = Commons
			.getProperty("registerCol1");
	public static final String REG_TOTAL_AMOUNT = Commons
			.getProperty("registerCol2");
	public static final String REG_AUTH = Commons.getProperty("registerCol3");
	public static final String REG_PAY_TYPE = Commons
			.getProperty("registerCol4");
	public static final String REG_PAY_ID = Commons.getProperty("registerCol5");
	public static final String REG_VOID = Commons.getProperty("registerCol6");
	public static final String[] REG_HEADER = { REG_TRAN_ID, REG_TOTAL_AMOUNT,
			REG_AUTH, REG_PAY_TYPE, REG_PAY_ID, REG_VOID };

	// Auth
	public static final String AUTH_SHEETNAME = Commons
			.getProperty("authSheetName");
	public static final String AUTH_USERNAME = Commons.getProperty("authCol1");
	public static final String AUTH_PASSWORD = Commons.getProperty("authCol2");
	public static final String AUTH_ROLE = Commons.getProperty("authCol3");

	// Admin
	public static final String ADMIN_USER = Commons.getProperty("adminUser");
	public static final String ADMIN_PASSWORD = Commons
			.getProperty("adminPassword");

	public static String getProperty(String key) {
		Properties prop = new Properties();
		try {
			prop.load(Commons.class.getClassLoader().getResourceAsStream(
					"app.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop.getProperty(key);
	}

	public static File getFile(Class cl, String file)
			throws UnsupportedEncodingException {

		String filePath = "resources/" + file;

		return new File(URLDecoder.decode(cl.getResource(filePath).getPath(),
				"UTF-8"));
	}

	public static File createFile(Class cl, String fileName)
			throws UnsupportedEncodingException {

		String filePath = "resources/" + fileName;

		return new File(URLDecoder.decode(cl.getResource(filePath).getPath(),
				"UTF-8"));
	}

	public static void DataStoreWrite(ArrayList<String> bookCopyData)
			throws IOException, URISyntaxException {

		DataStore dataStoreObject = new DataStore();
		dataStoreObject.getDataStoreSheet("Book Copy Data", bookCopyDataHeader);
		HSSFWorkbook workbook = dataStoreObject.getDataStoreWorkBook();
		HSSFSheet bookDataSheet = workbook.getSheet("Book Copy Data");
		int lastRowNumber = bookDataSheet.getLastRowNum();
		HSSFRow row = bookDataSheet.createRow(++lastRowNumber);
		for (int i = 0; i < bookCopyData.size(); i++) {
			row.createCell(i).setCellValue(bookCopyData.get(i));
			bookDataSheet.autoSizeColumn(i);
		}

		FileOutputStream out = new FileOutputStream(
				dataStoreObject.getDataStoreFile());
		workbook.write(out);
		System.out.println("Book Data updated successfully");

		out.close();

	}
}
