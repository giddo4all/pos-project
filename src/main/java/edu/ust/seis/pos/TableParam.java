package edu.ust.seis.pos;

import static edu.ust.seis.pos.Commons.INV_SHEETNAME;
import static edu.ust.seis.pos.Commons.INV_UPC;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class TableParam {

	String upc;
	String item;
	String uPrice;
	String quant;
	String amount;

	 public TableParam() {
	
	 // this.allData = new ArrayList<String>();
	
	 }

	public TableParam(String upc, String item, String uPrice, String quant, String amount) throws IOException,
			URISyntaxException {
		this.upc =upc;
		this.item = item;
		this.uPrice = uPrice;
		this.quant = quant;
		this.amount = amount;

	}

	public String getUPC() {
		return upc;
	}

	public String getItem() {
		return item;
	}
	
	public String getUprice() {
		return uPrice;
	}
	
	public String getQuant() {
		return quant;
	}
	
	public String getAmount() {
		return amount;
	}
	// public void setPrincipal(List<String> data) {
	// this.allData = data;
	// }

}
