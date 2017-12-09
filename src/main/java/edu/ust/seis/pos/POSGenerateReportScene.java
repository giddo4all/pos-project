package edu.ust.seis.pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class POSGenerateReportScene {

	private Label lbUsername, lbPasword, lbUPC, lbQuantity, lbPrice, lbTotal, lbTax, lbTranscationID, lbItemToRemove,
			lbItemName;

	private TextField textFieldUsername, textFieldPasword, textFieldUPC, textFieldQuantity, textFieldPrice,
			textFieldTotal, textFieldTax, textFieldTranscationID, textFieldItemToRemove, textFieldItemName;

	private Button btnLogin, btnRegister, btnReset1, btnSaleItem, btnRetrnItem, btnUpdateInventory, btnGenerateReport,
			btnRemove, btnAdd, btnCancel, btnCheckOut, btnSearch, btnItemRemove, btnReset, btnInventoryReport,
			btnCashierReport, btnRegisterReport;

	private Scene scene5;

	public POSGenerateReportScene() {
		Pane layout5 = new Pane();
		this.scene5 = new Scene(layout5, 700, 700);

		btnInventoryReport = new Button("Inventory Report");
		btnInventoryReport.setPrefSize(300, 100);
		btnInventoryReport.setLayoutX(200);
		btnInventoryReport.setLayoutY(40);
		// btnInventoryReport.setOnAction(e -> primaryStage.setScene(scene5A));
		btnInventoryReport.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
		btnInventoryReport.setId("Inventory Report");
		layout5.getChildren().add(btnInventoryReport);

		btnCashierReport = new Button("Cashier Report");
		btnCashierReport.setPrefSize(300, 100);
		btnCashierReport.setLayoutX(200);
		btnCashierReport.setLayoutY(160);
		// btnCashierReport.setOnAction(e -> primaryStage.setScene(scene5B));
		btnCashierReport.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
		btnCashierReport.setId("Cashier Report");
		layout5.getChildren().add(btnCashierReport);

		btnRegisterReport = new Button("Register Report");
		btnRegisterReport.setPrefSize(300, 100);
		btnRegisterReport.setLayoutX(200);
		btnRegisterReport.setLayoutY(280);
		// btnRegisterReport.setOnAction(e -> primaryStage.setScene(scene5C));
		btnRegisterReport.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
		btnRegisterReport.setId("Register report");
		layout5.getChildren().add(btnRegisterReport);

	}

	public Scene getScene() {
		return scene5;
	}

}
