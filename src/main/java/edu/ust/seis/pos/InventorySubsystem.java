package edu.ust.seis.pos;

import static edu.ust.seis.pos.Commons.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.ParseConversionEvent;

public class InventorySubsystem extends ReportSubsystem {

	public List<String> inventoryRead(String UPC) throws IOException,
			URISyntaxException, RecordNotFoundException {

		DataStore ds = new DataStore();
		String[] columnsNamesToRead = { INV_UPC, INV_BRAND, INV_ITEM,
				INV_UNIT_TYPE, INV_UNIT_PRICE, INV_QUANT };
		ArrayList<String> al = new ArrayList<String>();
		try {
			al = ds.dataStoreRead(INV_SHEETNAME, INV_UPC, columnsNamesToRead,
					UPC);

		} catch (Exception e) {

		}

		if (al == null) {
			throw new RecordNotFoundException("The item with UPC Code " + UPC
					+ " is not in inventory");
		}
		return al;

	}

	public String inventoryRead(String UPC, String colToRead)
			throws IOException, URISyntaxException, RecordNotFoundException {

		DataStore ds = new DataStore();
		String[] columnsNamesToRead = { colToRead };
		ArrayList<String> al = new ArrayList<String>();
		try {
			al = ds.dataStoreRead(INV_SHEETNAME, INV_UPC, columnsNamesToRead,
					UPC);

		} catch (Exception e) {

		}

		if (al == null) {
			throw new RecordNotFoundException("The item with UPC Code " + UPC
					+ " is not in inventory");
		}
		return al.get(0);

	}

	public void inventoryUpdate(String UPC, Map<String, String> mp)
			throws Exception {
		DataStore ds = new DataStore();
		for (String st : mp.keySet()) {

			ds.dataStoreUpdate(st, mp.get(st), INV_SHEETNAME, INV_UPC, UPC);
		}

	}

	public void inventoryUpdate(String UPC, String colNameToUpdate,
			String newCellValue) throws Exception {
		DataStore ds = new DataStore();
		ds.dataStoreUpdate(colNameToUpdate, newCellValue, INV_SHEETNAME,
				INV_UPC, UPC);
	}

	private void inventoryUpdateStock(String UPC, String updateQuantity,
			boolean isCheckOut) throws Exception {

		String qty = inventoryRead(UPC, INV_QUANT);
		int invQuant = Integer.valueOf(qty);
		int upQuant = Integer.valueOf(updateQuantity);
		DataStore ds = new DataStore();

		if (isCheckOut) {
			if (invQuant >= upQuant) {
				ds.dataStoreUpdate(INV_QUANT,
						String.valueOf((invQuant - upQuant)), INV_SHEETNAME,
						INV_UPC, UPC);
			} else {
				throw new Exception(
						"Requested checkout quantity is larger that what is in stock");
			}

		}

		if (!isCheckOut) {
			ds.dataStoreUpdate(INV_QUANT, String.valueOf((invQuant + upQuant)),
					INV_SHEETNAME, INV_UPC, UPC);
		}
	}

	public void inventoryCheckout(String UPC, String checkOutQuantity) throws Exception {

		inventoryUpdateStock(UPC, checkOutQuantity, true);
	}

	public void inventoryRestock(String UPC, String restockQuantity) throws Exception {

		inventoryUpdateStock(UPC, restockQuantity, false);
	}

	@Override
	public List<List<String>> generateReport() {
		return null;
		// TODO Auto-generated method stub

	}
}
