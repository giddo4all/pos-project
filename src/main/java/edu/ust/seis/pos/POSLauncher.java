package edu.ust.seis.pos;

import static edu.ust.seis.pos.Commons.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class POSLauncher extends Application implements EventHandler<ActionEvent> {

	private Label lbUsername, lbPasword, lbUPC, lbQuantity, lbPrice, lbTotal, lbTax, lbTranscationID, lbItemToRemove,
			lbItemName;

	private TextField textFieldUsername, textFieldPasword, textFieldUPC, textFieldQuantity, textFieldTranscationID,
			textFieldItemToRemove, textFieldItemName;

	Label textFieldTax;

	Label textFieldPrice;

	Label textFieldTotal;

	private Button btnLogin, btnRegister, btnReset1, btnSaleItem, btnRetrnItem, btnUpdateInventory, btnGenerateReport,
			btnRemove, btnAdd, btnCancel, btnCheckOut, btnSearch, btnItemRemove, btnReset, btnInventoryReport,
			btnCashierReport, btnRegisterReport;
	private Scene sceneLogin, sceneAllAction, sceneSell, sceneReturn, scene5, scene6, scene5A, scene5B, scene5C;
	private TableView table, tableSale, table2, table3, table4;
	private ArrayList<String> tableDataList;

	private Label[] lblArray = { lbUsername, lbPasword };
	private TextField[] textArray = { textFieldUsername, textFieldPasword };
	private Button[] btnArray = { btnLogin, btnRegister, btnReset };
	private Scene scene;
	private Stage primaryStage;

	private Pane layoutLogin;

	public POSLauncher() {

		// this.layout = new Pane();
		// this.scene = new Scene(layout, 700, 700);
	}

	public static void main(String[] args) {
		launch(args);

	}

	public void start(Stage primaryStage) throws Exception {

		// Controller controller = new Controller();
		// Scene scene = new Scene(
		// controller.getContent(), 700, 700, Color.AQUA);

		this.layoutLogin = new Pane();
		this.primaryStage = primaryStage;

		sceneLogin = new Scene(layoutLogin, 700, 700);

		try {

			primaryStage.setTitle("Login");
			textFieldUsername = new TextField();
			textFieldUsername.setPrefSize(220, 40);
			textFieldUsername.setLayoutX(270);
			textFieldUsername.setLayoutY(80);
			textFieldUsername.setId("User Name");
			layoutLogin.getChildren().add(textFieldUsername);

			lbUsername = new Label("User Name");
			lbUsername.setFont(new Font("Times New Roman", 25));
			lbUsername.setPrefSize(121, 24);
			lbUsername.setLayoutX(120);
			lbUsername.setLayoutY(80);
			layoutLogin.getChildren().add(lbUsername);

			textFieldPasword = new PasswordField();
			textFieldPasword.setPrefSize(220, 40);
			textFieldPasword.setLayoutX(270);
			textFieldPasword.setLayoutY(140);
			textFieldPasword.setId("Password");
			layoutLogin.getChildren().add(textFieldPasword);

			lbPasword = new Label("Password");
			lbPasword.setFont(new Font("Times New Roman", 25));
			lbPasword.setPrefSize(121, 24);
			lbPasword.setLayoutX(120);
			lbPasword.setLayoutY(140);
			layoutLogin.getChildren().add(lbPasword);

			btnLogin = new Button("Login");
			btnLogin.setPrefSize(100, 30);
			btnLogin.setLayoutX(270);
			btnLogin.setLayoutY(220);
			btnLogin.setOnMouseClicked(e -> login());
			btnLogin.setId("Login");
			btnLogin.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
			layoutLogin.getChildren().add(btnLogin);

			btnRegister = new Button("Register");
			btnRegister.setPrefSize(100, 30);
			btnRegister.setLayoutX(420);
			btnRegister.setLayoutY(220);
			btnRegister.setId("Register");
			btnRegister.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
			layoutLogin.getChildren().add(btnRegister);

			btnReset = new Button("Reset");
			btnReset.setPrefSize(100, 30);
			btnReset.setLayoutX(120);
			btnReset.setLayoutY(220);
			btnReset.setId("Reset");
			btnReset.setOnMouseClicked(e -> Commons.resetTextField(textArray));
			btnReset.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
			layoutLogin.getChildren().add(btnReset);

			// this.scene = new Scene(layout, 700, 700, Color.BLUE);
			//
			// setArray();
			// setPrimaryStage(scene);

			// ------------Scene 2(Task)---------------------
			Pane layoutAllAction = new Pane();
			sceneAllAction = new Scene(layoutAllAction, 700, 700);

			btnSaleItem = new Button("Sell Item");
			btnSaleItem.setPrefSize(300, 100);
			btnSaleItem.setLayoutX(200);
			btnSaleItem.setLayoutY(40);
			btnSaleItem.setOnAction(e -> primaryStage.setScene(sceneSell));
			btnSaleItem.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
			btnSaleItem.setId("Sell Item");
			layoutAllAction.getChildren().add(btnSaleItem);

			btnRetrnItem = new Button("Return Item");
			btnRetrnItem.setPrefSize(300, 100);
			btnRetrnItem.setLayoutX(200);
			btnRetrnItem.setLayoutY(160);
			btnRetrnItem.setOnAction(e -> primaryStage.setScene(sceneReturn));
			btnRetrnItem.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
			btnRetrnItem.setId("Return Item");
			layoutAllAction.getChildren().add(btnRetrnItem);

			btnUpdateInventory = new Button("Update Inventory");
			btnUpdateInventory.setPrefSize(300, 100);
			btnUpdateInventory.setLayoutX(200);
			btnUpdateInventory.setLayoutY(280);
			btnUpdateInventory.setOnAction(e -> primaryStage.setScene(scene6));
			btnUpdateInventory.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
			btnUpdateInventory.setId("Update Inventory");
			layoutAllAction.getChildren().add(btnUpdateInventory);

			btnGenerateReport = new Button("Generate Report");
			btnGenerateReport.setPrefSize(300, 100);
			btnGenerateReport.setLayoutX(200);
			btnGenerateReport.setLayoutY(400);
			btnGenerateReport.setOnAction(e -> primaryStage.setScene(scene5));
			btnGenerateReport.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
			btnGenerateReport.setId("Generate Report");
			layoutAllAction.getChildren().add(btnGenerateReport);

			// ------------Scene 3(Sell Item)---------------------

			Pane layoutSell = new Pane();
			layoutSell.autosize();
			sceneSell = new Scene(layoutSell, 700, 700);

			textFieldUPC = new TextField();
			textFieldUPC.setPrefSize(145, 20);
			textFieldUPC.setLayoutX(250);
			textFieldUPC.setLayoutY(40);
			textFieldUPC.setId("UPC");
			layoutSell.getChildren().add(textFieldUPC);

			lbUPC = new Label("UPC");
			lbUPC.setFont(new Font("Times New Roman", 15));
			lbUPC.setPrefSize(121, 24);
			lbUPC.setLayoutX(120);
			lbUPC.setLayoutY(40);
			layoutSell.getChildren().add(lbUPC);

			textFieldQuantity = new TextField();
			textFieldQuantity.setPrefSize(145, 20);
			textFieldQuantity.setLayoutX(250);
			textFieldQuantity.setLayoutY(60);
			textFieldQuantity.setId("Quantity");
			layoutSell.getChildren().add(textFieldQuantity);

			lbQuantity = new Label("Quantity");
			lbQuantity.setFont(new Font("Times New Roman", 15));
			lbQuantity.setPrefSize(121, 24);
			lbQuantity.setLayoutX(120);
			lbQuantity.setLayoutY(60);
			layoutSell.getChildren().add(lbQuantity);

			btnItemRemove = new Button("Remove");
			btnItemRemove.setPrefSize(145, 20);
			btnItemRemove.setLayoutX(200);
			btnItemRemove.setLayoutY(100);
			btnItemRemove.setId("Remove");
//			btnItemRemove.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
			layoutSell.getChildren().add(btnItemRemove);

			btnAdd = new Button("Add");
			btnAdd.setPrefSize(145, 20);
			btnAdd.setLayoutX(200);
			btnAdd.setLayoutY(100);
			btnAdd.setOnMouseClicked(event -> addDataToGrid(textFieldUPC.getText(), textFieldQuantity.getText(),
					tableSale));
			btnAdd.setId("Add");
//			btnAdd.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
			// btnAdd.setOnMouseClicked(e -> login());
			layoutSell.getChildren().add(btnAdd);

			textFieldPrice = new Label();
			textFieldPrice.setPrefSize(145, 20);
			textFieldPrice.setLayoutX(250);
			textFieldPrice.setLayoutY(160);
			textFieldPrice.setId("Price");
			layoutSell.getChildren().add(textFieldPrice);

			lbPrice = new Label("Price($)");
			lbPrice.setFont(new Font("Times New Roman", 15));
			lbPrice.setPrefSize(145, 20);
			lbPrice.setLayoutX(120);
			lbPrice.setLayoutY(160);
			layoutSell.getChildren().add(lbPrice);

			textFieldTotal = new Label();
			textFieldTotal.setPrefSize(145, 20);
			textFieldTotal.setLayoutX(250);
			textFieldTotal.setLayoutY(200);
			textFieldTotal.setId("Total");
			layoutSell.getChildren().add(textFieldTotal);

			lbTotal = new Label("Total ($)");
			lbTotal.setFont(new Font("Times New Roman", 15));
			lbTotal.setPrefSize(145, 20);
			lbTotal.setLayoutX(120);
			lbTotal.setLayoutY(200);
			layoutSell.getChildren().add(lbTotal);

			textFieldTax = new Label(Commons.taxRate);
			textFieldTax.setFont(new Font("Times New Roman", 15));
			textFieldTax.setPrefSize(145, 20);
			textFieldTax.setLayoutX(250);
			textFieldTax.setLayoutY(240);
			textFieldTotal.setId("Tax");
			layoutSell.getChildren().add(textFieldTax);

			lbTax = new Label("Tax (%)");
			lbTax.setFont(new Font("Times New Roman", 15));
			lbTax.setPrefSize(145, 20);
			lbTax.setLayoutX(120);
			lbTax.setLayoutY(240);
			layoutSell.getChildren().add(lbTax);

			btnCancel = new Button("Cancel");
			btnCancel.setPrefSize(145, 20);
			btnCancel.setLayoutX(200);
			btnCancel.setLayoutY(300);
			btnCancel.setId("Cancel");
//			btnCancel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
			layoutSell.getChildren().add(btnCancel);

			btnCheckOut = new Button("CheckOut");
			btnCheckOut.setPrefSize(145, 20);
			btnCheckOut.setLayoutX(340);
			btnCheckOut.setLayoutY(300);
			btnCheckOut.setId("CheckOut");
//			btnCheckOut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
			layoutSell.getChildren().add(btnCheckOut);

			tableSale = new TableView<>();
			tableSale.setEditable(true);
			tableSale.autosize();
			// table.setBorder(new Border());
			// table.setColumnResizePolicy((param) -> true );
			TableColumn<TableParam, String> UPC = new TableColumn<>("UPC");
			UPC.setResizable(true);
//			UPC.setMinWidth(150);

			TableColumn<TableParam, String> item = new TableColumn<>("Item");
			UPC.setResizable(true);
//			UPC.setMinWidth(150);

			TableColumn<TableParam, String> unitPrice = new TableColumn<>("Unit Price");
			UPC.setResizable(true);
//			UPC.setMinWidth(150);

			TableColumn<TableParam, String> Quantity = new TableColumn<>("Quantity");
			Quantity.setResizable(true);
//			Quantity.setMinWidth(150);

			TableColumn<TableParam, String> total = new TableColumn<>("Total Amount");
			Quantity.setResizable(true);
//			Quantity.setMinWidth(150);

			// table.setItems(getGridData());
			// String displayDataSell = {INV_UPC, INV_ITEM, INV_UNIT_PRICE, INV_QUANT, INV_

			tableSale.getColumns().addAll(UPC, item, unitPrice, Quantity, total);
			tableSale.autosize();
			tableSale.setLayoutX(180);
			tableSale.setLayoutY(320);
			layoutSell.getChildren().add(tableSale);

			// ------------Scene 4(Return Item)---------------------

			Pane layoutReturn = new Pane();
			sceneReturn = new Scene(layoutReturn, 1000, 1000);

			textFieldTranscationID = new TextField();
			textFieldTranscationID.setPrefSize(250, 40);
			textFieldTranscationID.setLayoutX(400);
			textFieldTranscationID.setLayoutY(40);
			textFieldTranscationID.setId("TranscationID");
			layoutReturn.getChildren().add(textFieldTranscationID);

			lbTranscationID = new Label("Transcation ID");
			lbTranscationID.setFont(new Font("Times New Roman", 25));
			lbTranscationID.setPrefSize(160, 35);
			lbTranscationID.setLayoutX(200);
			lbTranscationID.setLayoutY(40);
			layoutReturn.getChildren().add(lbTranscationID);

			btnSearch = new Button("Search");
			btnSearch.setPrefSize(100, 30);
			btnSearch.setLayoutX(350);
			btnSearch.setLayoutY(140);
			btnSearch.setId("Search");
			btnSearch.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
			layoutReturn.getChildren().add(btnSearch);

			table = new TableView<String>();
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
			table.getColumns().addAll(UPC, ItemName, Quantity, Cost);
			table.setLayoutX(180);
			table.setLayoutY(300);
			layoutReturn.getChildren().add(table);

			lbItemToRemove = new Label("Enter Item To Remove");
			lbItemToRemove.setFont(new Font("Times New Roman", 25));
			lbItemToRemove.setPrefSize(250, 35);
			lbItemToRemove.setLayoutX(350);
			lbItemToRemove.setLayoutY(750);
			layoutReturn.getChildren().add(lbItemToRemove);

			textFieldItemToRemove = new TextField();
			textFieldItemToRemove.setPrefSize(450, 40);
			textFieldItemToRemove.setLayoutX(300);
			textFieldItemToRemove.setLayoutY(800);
			textFieldItemToRemove.setId("ItemToRemove");
			layoutReturn.getChildren().add(textFieldItemToRemove);

			btnRemove = new Button("Remove");
			btnRemove.setPrefSize(100, 30);
			btnRemove.setLayoutX(330);
			btnRemove.setLayoutY(880);
			btnRemove.setId("Remove");
			btnRemove.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
			layoutReturn.getChildren().add(btnRemove);

			btnReset = new Button("Reset");
			btnReset.setPrefSize(100, 30);
			btnReset.setLayoutX(460);
			btnReset.setLayoutY(880);
			btnReset.setId("Reset");
			btnReset.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
			layoutReturn.getChildren().add(btnReset);

			// ------------Scene 5(Generate report)---------------------

			Pane layout5 = new Pane();
			scene5 = new Scene(layout5, 700, 700);

			btnInventoryReport = new Button("Inventory Report");
			btnInventoryReport.setPrefSize(300, 100);
			btnInventoryReport.setLayoutX(200);
			btnInventoryReport.setLayoutY(40);
			btnInventoryReport.setOnAction(e -> primaryStage.setScene(scene5A));
			btnInventoryReport.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
			btnInventoryReport.setId("Inventory Report");
			layout5.getChildren().add(btnInventoryReport);

			btnCashierReport = new Button("Cashier Report");
			btnCashierReport.setPrefSize(300, 100);
			btnCashierReport.setLayoutX(200);
			btnCashierReport.setLayoutY(160);
			btnCashierReport.setOnAction(e -> primaryStage.setScene(scene5B));
			btnCashierReport.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
			btnCashierReport.setId("Cashier Report");
			layout5.getChildren().add(btnCashierReport);

			btnRegisterReport = new Button("Register Report");
			btnRegisterReport.setPrefSize(300, 100);
			btnRegisterReport.setLayoutX(200);
			btnRegisterReport.setLayoutY(280);
			btnRegisterReport.setOnAction(e -> primaryStage.setScene(scene5C));
			btnRegisterReport.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
			btnRegisterReport.setId("Register report");
			layout5.getChildren().add(btnRegisterReport);

			// ------------Scene 6(Update Inventory)---------------------

			Pane layout6 = new Pane();
			scene6 = new Scene(layout6, 700, 700);

			textFieldUPC = new TextField();
			textFieldUPC.setPrefSize(220, 40);
			textFieldUPC.setLayoutX(250);
			textFieldUPC.setLayoutY(40);
			textFieldUPC.setId("UPC");
			layout6.getChildren().add(textFieldUPC);

			lbUPC = new Label("UPC");
			lbUPC.setFont(new Font("Times New Roman", 25));
			lbUPC.setPrefSize(121, 24);
			lbUPC.setLayoutX(120);
			lbUPC.setLayoutY(40);
			layout6.getChildren().add(lbUPC);

			textFieldQuantity = new TextField();
			textFieldQuantity.setPrefSize(220, 40);
			textFieldQuantity.setLayoutX(250);
			textFieldQuantity.setLayoutY(100);
			textFieldQuantity.setId("Quantity");
			layout6.getChildren().add(textFieldQuantity);

			lbQuantity = new Label("Quantity");
			lbQuantity.setFont(new Font("Times New Roman", 25));
			lbQuantity.setPrefSize(121, 24);
			lbQuantity.setLayoutX(120);
			lbQuantity.setLayoutY(100);
			layout6.getChildren().add(lbQuantity);

			textFieldItemName = new TextField();
			textFieldItemName.setPrefSize(220, 40);
			textFieldItemName.setLayoutX(250);
			textFieldItemName.setLayoutY(160);
			textFieldItemName.setId("Item Name");
			layout6.getChildren().add(textFieldItemName);

			lbItemName = new Label("Item Name");
			lbItemName.setFont(new Font("Times New Roman", 25));
			lbItemName.setPrefSize(121, 24);
			lbItemName.setLayoutX(120);
			lbItemName.setLayoutY(160);
			layout6.getChildren().add(lbItemName);

			// ------------Scene 5A(Update Inventory)---------------------

			Pane layout5A = new Pane();
			scene5A = new Scene(layout5A, 1000, 700);

			table2 = new TableView<>();
			table2.setEditable(true);
			// table.setBorder(new Border());
			// table.setColumnResizePolicy((param) -> true );
			TableColumn UPC2 = new TableColumn("UPC");
			UPC2.setResizable(true);
			UPC2.setMinWidth(150);

			TableColumn Brand = new TableColumn("Brand");
			Brand.setResizable(true);
			Brand.setMinWidth(150);

			TableColumn ItemNo = new TableColumn("Item No");
			ItemNo.setMinWidth(150);

			TableColumn UnitType = new TableColumn("Unit Type");
			UnitType.setResizable(true);
			UnitType.setMinWidth(150);

			TableColumn UnitPrice = new TableColumn("Unit Price");
			UnitPrice.setResizable(true);
			UnitPrice.setMinWidth(150);

			TableColumn StockLevel = new TableColumn("Stock Level");
			StockLevel.setResizable(true);
			StockLevel.setMinWidth(150);

			// table.setItems(getGridData());
			table2.getColumns().addAll(UPC, Brand, ItemNo, UnitType, UnitPrice, StockLevel);
			table2.setLayoutX(50);
			table2.setLayoutY(100);
			layout5A.getChildren().add(table2);

			// ------------Scene 5B(Update Inventory)---------------------
			Pane layout5B = new Pane();
			scene5B = new Scene(layout5B, 1300, 700);

			table3 = new TableView<>();
			table3.setEditable(true);
			// table.setBorder(new Border());
			// table.setColumnResizePolicy((param) -> true );
			TableColumn Name = new TableColumn("Name");
			Name.setResizable(true);
			Name.setMinWidth(150);

			TableColumn ID = new TableColumn("ID");
			ID.setResizable(true);
			ID.setMinWidth(150);

			TableColumn VPC = new TableColumn("VPC");
			VPC.setMinWidth(150);

			TableColumn Item_Name = new TableColumn("Item Name");
			Item_Name.setResizable(true);
			Item_Name.setMinWidth(150);

			TableColumn Unit_Type = new TableColumn("Unit Type");
			Unit_Type.setResizable(true);
			Unit_Type.setMinWidth(150);

			TableColumn Price = new TableColumn("Price");
			Price.setResizable(true);
			Price.setMinWidth(150);

			TableColumn authBy = new TableColumn("AuthBy");
			authBy.setResizable(true);
			authBy.setMinWidth(150);

			TableColumn isReturn = new TableColumn("isReturn");
			isReturn.setResizable(true);
			isReturn.setMinWidth(150);
			// table.setItems(getGridData());
			// String[] displayCol = {Name, ID, VPC, ItemName, UnitType, Price, authBy, isReturn};
			table3.getColumns().addAll(Name, ID, VPC, ItemName, UnitType, Price, authBy, isReturn);
			table3.setLayoutX(50);
			table3.setLayoutY(100);
			layout5B.getChildren().add(table3);

			// ------------Scene 5C(Update Inventory)---------------------

			Pane layout5C = new Pane();
			scene5C = new Scene(layout5C, 1000, 700);

			table4 = new TableView<>();
			table4.setEditable(true);
			// table.setBorder(new Border());
			// table.setColumnResizePolicy((param) -> true );
			TableColumn RegisterType = new TableColumn("RegisterType");
			RegisterType.setResizable(true);
			RegisterType.setMinWidth(150);

			TableColumn I_D = new TableColumn("ID");
			I_D.setResizable(true);
			I_D.setMinWidth(150);

			TableColumn TotalAmount = new TableColumn("Total Amount");
			TotalAmount.setMinWidth(150);

			TableColumn auth_By = new TableColumn("AuthBy");
			authBy.setResizable(true);
			authBy.setMinWidth(150);

			TableColumn PaymentType = new TableColumn("Payment type");
			PaymentType.setResizable(true);
			PaymentType.setMinWidth(150);

			TableColumn is_Return = new TableColumn("isReturn");
			isReturn.setResizable(true);
			isReturn.setMinWidth(150);
			// table.setItems(getGridData());
			table4.getColumns().addAll(RegisterType, ID, TotalAmount, authBy, PaymentType, isReturn);
			table4.setLayoutX(50);
			table4.setLayoutY(100);
			layout5C.getChildren().add(table4);

			setArray();
			setPrimaryStage(sceneLogin);

			// primaryStage.setScene(sceneLogin);
			// primaryStage.show();

		} catch (Exception e) {

			new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
		}

	}

	private Stage getPrimaryStage() {
		return primaryStage;
	}

	public void setPrimaryStage(Scene scene) {
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public void setPrimaryStageTitle() {

	}

	private void setArray() {
		this.lblArray = new Label[] { lbUsername, lbPasword };
		this.textArray = new TextField[] { textFieldUsername, textFieldPasword };
		this.btnArray = new Button[] { btnLogin, btnRegister, btnReset };
	}

	private void login() {
		try {
			SecuritySubsystem sbs = new SecuritySubsystem();
			boolean isGood = sbs.login(textFieldUsername.getText(), textFieldPasword.getText());
			if (isGood) {
				setPrimaryStage(sceneAllAction);
				// primaryStage.setScene(sceneAllAction);
				getPrimaryStage().setTitle(sbs.getUserName() + " " + sbs.getUserID());

			}
		} catch (Exception e) {

			new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
		}
	}

	public ObservableList<TableParam> getGridData() throws IOException, URISyntaxException {

		ObservableList<TableParam> tableData = FXCollections.observableArrayList();
		tableData.add(new TableParam(tableDataList.get(0), tableDataList.get(1), tableDataList.get(2), tableDataList
				.get(3), tableDataList.get(4)));

		return tableData;

	}

	public void addDataToGrid(String upc, String quant, TableView tbv) {
		try {

			tableDataList = new SalesSubsystem().scanItem(upc, quant);
			TableParam lp = new TableParam(tableDataList.get(0), tableDataList.get(1), tableDataList.get(2),
					tableDataList.get(3), tableDataList.get(5));
			tbv.getItems().add(lp);

		} catch (Exception e) {
			new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
		}
	}

	public void createTableView(List<String> tableData) {

		TableView<TableParam> table = new TableView<>();
		for (int i = 0; i < tableData.size(); i++) {
			// table.getItems().add(new TableParam(tableData.get(i)));
		}
	}

	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}

	// @Override
	// public Parent getContent() {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
