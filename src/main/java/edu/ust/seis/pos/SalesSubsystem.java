package edu.ust.seis.pos;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static edu.ust.seis.pos.Commons.*;

//import static
public class SalesSubsystem {

	private String userID;
	private String userName;
	private String transactID;
	private String transactIDPlus;
	private ArrayList<String> checkOutList = new ArrayList<String>();
	private ArrayList<String> scanList = new ArrayList<String>();

	// public SalesSubsystem(){
	// // DataStore ds = new DataStore().dataStoreWrite(data, sheetName);
	// // transID = setTransactionID();
	// this.userID = SecuritySubsystem.getUserID();
	// this.userName = SecuritySubsystem.getUserName();
	// }

	public SalesSubsystem(){
		
	}
	
	
	public SalesSubsystem(String userID, String userName) {
		// DataStore ds = new DataStore().dataStoreWrite(data, sheetName);
		// transID = setTransactionID();
		this.userID = userID;
		this.userName = userName;
	}

	public ArrayList<String> scanItem(String UPC, String requestedQuantity)
			throws URISyntaxException, IOException {
		// String id = SecuritySubsystem.getUserID();
		DataStore ds = new DataStore();
		ds.createSheet(userID, Commons.CH_HEADER);

		String[] rowsRead = { INV_UPC, INV_ITEM, INV_UNIT_TYPE, INV_UNIT_PRICE };
		ArrayList<String> invArray = new ArrayList<String>();
		invArray = ds.dataStoreRead(INV_SHEETNAME, INV_UPC, rowsRead, UPC);
		String epochDate = String.valueOf(Commons.epochTimesStamp());
		String tranID = getTransactionID();

		String totalPrice = String.valueOf(Integer.valueOf(requestedQuantity)
				* Double.valueOf(invArray.get(3)));

		Map<String, String> mp = new HashMap<String, String>();
		mp.put(CH_DATE, epochDate);
		mp.put(CH_TRAN_ID, tranID);
		mp.put(CH_UPC, invArray.get(0));
		scanList.add(invArray.get(0));
		mp.put(CH_ITEM, invArray.get(1));
		scanList.add(invArray.get(1));
		mp.put(CH_UNIT_TYPE, invArray.get(2));
		scanList.add(invArray.get(2));
		mp.put(CH_UNIT_SOLD, requestedQuantity);
		scanList.add(requestedQuantity);
		mp.put(CH_PRICE, totalPrice);
		scanList.add(totalPrice);
		mp.put(CH_AUTH, userID);
		mp.put(CH_RETURN, "false");

		ds.dataStoreWrite(mp, CH_SHEETNAME);
		return scanList;

	}

	/**
	 * 
	 * @param allUPC
	 *            : an array containing UPC
	 * @throws Exception
	 */

	public void checkOut(List<String> allUPC) throws Exception {
		DataStore ds = new DataStore();
		InventorySubsystem is = new InventorySubsystem();
		ArrayList<String> checkOutArray = new ArrayList<String>();
		String[] columnsNamesToRead = { CH_UPC, CH_UNIT_SOLD, CH_PRICE };
		String transIDPlus = generateTransactionIDPlus(allUPC.size());
		for (String uc : allUPC) {
			checkOutArray = ds.dataStoreRead(CH_SHEETNAME, CAT_UPC,
					columnsNamesToRead, uc);
			ds.dataStoreUpdate(CH_TRAN_ID, transIDPlus, CH_SHEETNAME, CH_TRAN_ID, uc);
			is.inventoryCheckout(uc, checkOutArray.get(1));
		}
	}

	// private void setUPCList(String){
	//
	//
	// }
	public String generateTransactionIDPlus(int itemCount) {
		transactIDPlus = "TIDP" + Commons.epochTimesStamp() + "#"
				+ itemCount;
		return transactIDPlus;
	}

	public void setTransactionID() {

		transactID = "CHID" + Commons.epochTimesStamp();
	}

	public String getTransactionID() {
		return transactID;
	}

	public String getTransactionIDPlus() {
		return transactIDPlus;
	}
}
