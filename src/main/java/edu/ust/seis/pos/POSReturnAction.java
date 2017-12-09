package edu.ust.seis.pos;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class POSReturnAction {
	
	private Label lbUsername, lbPasword, lbUPC, lbQuantity, lbPrice, lbTotal, lbTax, lbTranscationID, lbItemToRemove,
	lbItemName;

private TextField textFieldUsername, textFieldPasword, textFieldUPC, textFieldQuantity, textFieldPrice,
	textFieldTotal, textFieldTax, textFieldTranscationID, textFieldItemToRemove, textFieldItemName;

private Button btnLogin, btnRegister, btnReset1, btnSaleItem, btnRetrnItem, btnUpdateInventory, btnGenerateReport,
	btnRemove, btnAdd, btnCancel, btnCheckOut, btnSearch, btnItemRemove, btnReset, btnInventoryReport,
	btnCashierReport, btnRegisterReport;

	Scene scene4;

	public POSReturnAction() {
		Pane layout4 = new Pane();
		this.scene4 = new Scene(layout4, 1000, 1000);

		textFieldTranscationID = new TextField();
		textFieldTranscationID.setPrefSize(250, 40);
		textFieldTranscationID.setLayoutX(400);
		textFieldTranscationID.setLayoutY(40);
		textFieldTranscationID.setId("TranscationID");
		layout4.getChildren().add(textFieldTranscationID);

		lbTranscationID = new Label("Transcation ID");
		lbTranscationID.setFont(new Font("Times New Roman", 25));
		lbTranscationID.setPrefSize(160, 35);
		lbTranscationID.setLayoutX(200);
		lbTranscationID.setLayoutY(40);
		layout4.getChildren().add(lbTranscationID);

		btnSearch = new Button("Search");
		btnSearch.setPrefSize(100, 30);
		btnSearch.setLayoutX(350);
		btnSearch.setLayoutY(140);
		btnSearch.setId("Search");
		btnSearch.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
		layout4.getChildren().add(btnSearch);

		TableView<String>table = new TableView<>();
		table.setEditable(true);
		// table.setBorder(new Border());
		// table.setColumnResizePolicy((param) -> true );
		TableColumn UPC1 = new TableColumn("UPC");
		UPC1.setResizable(true);
		UPC1.setMinWidth(150);
		TableColumn ItemName = new TableColumn("ItemName");
		ItemName.setResizable(true);
		ItemName.setMinWidth(150);
		TableColumn Quantity1 = new TableColumn("Quantity");
		Quantity1.setMinWidth(150);
		TableColumn Cost = new TableColumn("Cost");
		Cost.setResizable(true);
		Cost.setMinWidth(150);
		// table.setItems(getGridData());
//		table.getColumns().addAll(UPC, ItemName, Quantity, Cost);
		table.setLayoutX(180);
		table.setLayoutY(300);
		layout4.getChildren().add(table);

		lbItemToRemove = new Label("Enter Item To Remove");
		lbItemToRemove.setFont(new Font("Times New Roman", 25));
		lbItemToRemove.setPrefSize(250, 35);
		lbItemToRemove.setLayoutX(350);
		lbItemToRemove.setLayoutY(750);
		layout4.getChildren().add(lbItemToRemove);

		textFieldItemToRemove = new TextField();
		textFieldItemToRemove.setPrefSize(450, 40);
		textFieldItemToRemove.setLayoutX(300);
		textFieldItemToRemove.setLayoutY(800);
		textFieldItemToRemove.setId("ItemToRemove");
		layout4.getChildren().add(textFieldItemToRemove);

		btnRemove = new Button("Remove");
		btnRemove.setPrefSize(100, 30);
		btnRemove.setLayoutX(330);
		btnRemove.setLayoutY(880);
		btnRemove.setId("Remove");
		btnRemove.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
		layout4.getChildren().add(btnRemove);

		btnReset = new Button("Reset");
		btnReset.setPrefSize(100, 30);
		btnReset.setLayoutX(460);
		btnReset.setLayoutY(880);
		btnReset.setId("Reset");
		btnReset.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
		layout4.getChildren().add(btnReset);
	}

	public Scene getScene(){
		return scene4;
	}
}
