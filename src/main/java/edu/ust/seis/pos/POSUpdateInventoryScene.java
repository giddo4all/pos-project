//package edu.ust.seis.pos;
//
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.control.TableColumn;
//import javafx.scene.control.TableView;
//import javafx.scene.control.TextField;
//import javafx.scene.layout.Pane;
//import javafx.scene.text.Font;
//
//public class POSUpdateInventoryScene {
//
//	private Label lbUsername, lbPasword, lbUPC, lbQuantity, lbPrice, lbTotal, lbTax, lbTranscationID, lbItemToRemove,
//			lbItemName;
//
//	private TextField textFieldUsername, textFieldPasword, textFieldUPC, textFieldQuantity, textFieldPrice,
//			textFieldTotal, textFieldTax, textFieldTranscationID, textFieldItemToRemove, textFieldItemName;
//
//	private Button btnLogin, btnRegister, btnReset1, btnSaleItem, btnRetrnItem, btnUpdateInventory, btnGenerateReport,
//			btnRemove, btnAdd, btnCancel, btnCheckOut, btnSearch, btnItemRemove, btnReset, btnInventoryReport,
//			btnCashierReport, btnRegisterReport;
//	private Scene scene;
//
//	public POSUpdateInventoryScene() {
//		Pane layout6 = new Pane();
//		this.scene = new Scene(layout6, 700, 700);
//
//		textFieldUPC = new TextField();
//		textFieldUPC.setPrefSize(220, 40);
//		textFieldUPC.setLayoutX(250);
//		textFieldUPC.setLayoutY(40);
//		textFieldUPC.setId("UPC");
//		layout6.getChildren().add(textFieldUPC);
//
//		lbUPC = new Label("UPC");
//		lbUPC.setFont(new Font("Times New Roman", 25));
//		lbUPC.setPrefSize(121, 24);
//		lbUPC.setLayoutX(120);
//		lbUPC.setLayoutY(40);
//		layout6.getChildren().add(lbUPC);
//
//		textFieldQuantity = new TextField();
//		textFieldQuantity.setPrefSize(220, 40);
//		textFieldQuantity.setLayoutX(250);
//		textFieldQuantity.setLayoutY(100);
//		textFieldQuantity.setId("Quantity");
//		layout6.getChildren().add(textFieldQuantity);
//
//		lbQuantity = new Label("Quantity");
//		lbQuantity.setFont(new Font("Times New Roman", 25));
//		lbQuantity.setPrefSize(121, 24);
//		lbQuantity.setLayoutX(120);
//		lbQuantity.setLayoutY(100);
//		layout6.getChildren().add(lbQuantity);
//
//		textFieldItemName = new TextField();
//		textFieldItemName.setPrefSize(220, 40);
//		textFieldItemName.setLayoutX(250);
//		textFieldItemName.setLayoutY(160);
//		textFieldItemName.setId("Item Name");
//		layout6.getChildren().add(textFieldItemName);
//
//		lbItemName = new Label("Item Name");
//		lbItemName.setFont(new Font("Times New Roman", 25));
//		lbItemName.setPrefSize(121, 24);
//		lbItemName.setLayoutX(120);
//		lbItemName.setLayoutY(160);
//		layout6.getChildren().add(lbItemName);
//
//		// ------------Scene 5A(Update Inventory)---------------------
//
//		TableView table2 = new TableView<>();
//		table2.setEditable(true);
//		// table.setBorder(new Border());
//		// table.setColumnResizePolicy((param) -> true );
//		TableColumn UPC = new TableColumn("UPC");
//		UPC.setResizable(true);
//		UPC.setMinWidth(150);
//
//		TableColumn Brand = new TableColumn("Brand");
//		Brand.setResizable(true);
//		Brand.setMinWidth(150);
//
//		TableColumn ItemNo = new TableColumn("Item No");
//		ItemNo.setMinWidth(150);
//
//		TableColumn UnitType = new TableColumn("Unit Type");
//		UnitType.setResizable(true);
//		UnitType.setMinWidth(150);
//
//		TableColumn UnitPrice = new TableColumn("Unit Price");
//		UnitPrice.setResizable(true);
//		UnitPrice.setMinWidth(150);
//
//		TableColumn StockLevel = new TableColumn("Stock Level");
//		StockLevel.setResizable(true);
//		StockLevel.setMinWidth(150);
//
//		// table.setItems(getGridData());
//		table2.getColumns().addAll(UPC, Brand, ItemNo, UnitType, UnitPrice, StockLevel);
//		table2.setLayoutX(50);
//		table2.setLayoutY(100);
//		layout6.getChildren().add(table2);
//	}
//
//	public Scene getScene() {
//		return scene;
//	}
//
//}
