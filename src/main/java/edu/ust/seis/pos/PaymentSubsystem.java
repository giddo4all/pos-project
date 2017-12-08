package edu.ust.seis.pos;
import static edu.ust.seis.pos.Commons.*;

import java.io.IOException;
import java.net.URISyntaxException;

public class PaymentSubsystem {

	
	public enum PaymentType {
		CASH, CREDITCARD, CHECK, EBT, DEBITCARD;
	}
	
	public PaymentSubsystem() throws URISyntaxException, IOException {
		DataStore ds = new DataStore();
		ds.createSheet(REG_SHEETNAME);
	}
	
	
//	REG_SHEETNAME 	
//	REG_DATE 		
//	REG_TRAN_ID 	
//	REG_TOTAL_AMOUNT
//	REG_AUTH 		
//	REG_PAY_TYPE 	
//	REG_PAY_ID 		
//	REG_VOID 		
//	REG_HEADER 		

	
	public void makePayment(PaymentType payType, String payID){
		

}

}