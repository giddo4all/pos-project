package edu.ust.seis.pos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Random;

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
			INV_UNIT_TYPE, INV_UNIT_PRICE, INV_QUANT };
	public static Map<String, String> INV_MAP;

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
	public static Map<String, String> CAT_MAP;

	// Cashier DataStore
	public static final String CH_SHEETNAME = Commons
			.getProperty("cashierSheetName");
	public static final String CH_DATE = Commons.getProperty("cashierCol0");
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
	public static final String[] CH_HEADER = { CH_DATE, CH_TRAN_ID, CH_UPC,
			CH_ITEM, CH_UNIT_TYPE, CH_UNIT_SOLD, CH_PRICE, CH_AUTH, CH_RETURN };
	public static Map<String, String> CH_MAP;

	// Register DataStore
	public static final String REG_SHEETNAME = Commons
			.getProperty("registerSheetName");
	public static final String REG_DATE = Commons.getProperty("registerCol0");
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
	public static Map<String, String> REG_MAP;

	// Auth
	public static final String AUTH_SHEETNAME = Commons
			.getProperty("authSheetName");
	public static final String AUTH_USERNAME = Commons.getProperty("authCol1");
	public static final String AUTH_PASSWORD = Commons.getProperty("authCol2");
	public static final String AUTH_ROLE = Commons.getProperty("authCol3");
	public static final String AUTH_ID_NUMBER = Commons.getProperty("authCol0");
	public static final String[] AUTH_HEADER = { AUTH_ID_NUMBER, AUTH_USERNAME,
			AUTH_PASSWORD, AUTH_ROLE };
	// public static String AUTH_ID_NUMBER_VALUE= "DGS"+ epochTimesStamp();

	public static Map<String, String> AUTH_MAP;
	// Admin
	public static final String ADMIN_USERNAME_VALUE = Commons
			.getProperty("adminUser");
	public static final String ADMIN_PASSWORD_VALUE = Commons
			.getProperty("adminPassword");
	public static final String ADMIN_USER_ID_VALUE = Commons
			.getProperty("adminUserID");

	// Temp store
	public static final String TEMP_SHEET = Commons.getProperty("adminUser");
	public static final String TEMP_UPC = "upc";
	public static final String TEMP_QUANT = "quantity";
	public static final String TEMP_AMOUNT = "amount";
	public static final String[] TEMP_HEADER = { TEMP_UPC, TEMP_QUANT,
			TEMP_AMOUNT };

	private static final SimpleDateFormat sdf = new SimpleDateFormat(
			"yyyy.MM.dd.HH.mm.ss");

	// TODO: Test param
	public static final String[] bookHeader = { "copyID", "bookName", "isbn",
			"copyCount" };
	public static final String bookSheet = "testSheet";

	// ***************************************************

	public enum BookHead {
		copyID, bookName, isbn, copyCount;

	}

	// TODO:
	public enum AuthHeader {
		IDNumber, username, password, role;
	}



	// public enum AuthRoles{
	// superAdmin,
	// Admin,
	// Manager,
	// Cashier;
	// }

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

	public static Map<String, String> createPlaceHolderMapFromHeader(
			String sheetName) {
		String[] headerArray = Commons.sheetNameToHeaderMap().get(sheetName);
		Map<String, String> mp = new HashMap<String, String>();
		for (String hd : headerArray) {
			mp.put(hd, "-");
		}
		return mp;
	}

	public static Map<String, String[]> sheetNameToHeaderMap() {
		Map<String, String[]> mp = new HashMap<String, String[]>();
		mp.put(AUTH_SHEETNAME, AUTH_HEADER);
		mp.put(CAT_SHEETNAME, CAT_HEADER);
		mp.put(CH_SHEETNAME, CH_HEADER);
		mp.put(INV_SHEETNAME, INV_HEADER);
		mp.put(REG_SHEETNAME, REG_HEADER);

		// TODO: Test
		mp.put(bookSheet, bookHeader);

		return mp;
	}

	public static int randomInt() {

		Random rand = new Random();
		int min = 1;
		int max = 999;
		// return (int) ((Math.ceil(Math.random() + 1 ))*1000);

		return (rand.nextInt((max - min) + 1) + min);
	}

	public static String timesStamp() {

		return new Timestamp(System.currentTimeMillis()).toString();
	}

	public static long epochTimesStamp() {

		return Instant.now().toEpochMilli();
		// return new
		// Timestamp(System.currentTimeMillis()).toInstant().toString();
	}

	// public static void DataStoreWrite(ArrayList<String> bookCopyData)
	// throws IOException, URISyntaxException {
	//
	// DataStore dataStoreObject = new DataStore();
	// dataStoreObject.getDataStoreSheet("Book Copy Data", bookCopyDataHeader);
	// HSSFWorkbook workbook = dataStoreObject.getDataStoreWorkBook();
	// HSSFSheet bookDataSheet = workbook.getSheet("Book Copy Data");
	// int lastRowNumber = bookDataSheet.getLastRowNum();
	// HSSFRow row = bookDataSheet.createRow(++lastRowNumber);
	// for (int i = 0; i < bookCopyData.size(); i++) {
	// row.createCell(i).setCellValue(bookCopyData.get(i));
	// bookDataSheet.autoSizeColumn(i);
	// }
	//
	// FileOutputStream out = new FileOutputStream(
	// dataStoreObject.getDataStoreFile());
	// workbook.write(out);
	// System.out.println("Book Data updated successfully");
	//
	// out.close();
	//
	// }
}
