package edu.ust.seis.pos;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
public class Launcher extends Application implements EventHandler<ActionEvent> {
	
	private Label lbUsername,lbPasword,lbUFC,lbQuantity, lbPrice,lbTotal,lbTax, lbTranscationID,lbItemToRemove,lbItemName;
    
	private TextField textFieldUsername,textFieldPasword,textFieldUFC, textFieldQuantity,textFieldPrice,textFieldTotal, textFieldTax,textFieldTranscationID, textFieldItemToRemove, textFieldItemName;
	
	private Button btnLogin,  btnSaleItem, btnRetrnItem,btnUpdateInventory,btnGenerateReport,btnRemove,btnAdd,btnCancel,btnCheckOut,btnSearch,btnItemRemove,btnReset,btnInventoryReport,btnCashierReport,btnRegisterReport;
	private     Scene scene1,scene2,scene3,scene4,scene5,scene6;
	private TableView table;
	
	public static void main(String []args){
		launch(args);
		
	}
	public void start(Stage primaryStage) throws Exception{
		
		  primaryStage.setTitle("Login");
          Pane layout = new Pane();
          scene1 = new Scene(layout, 400, 300);

         //Login
          textFieldUsername = new TextField();
  
          textFieldUsername.setPrefSize(144, 20);
          textFieldUsername.setLayoutX(181);
          textFieldUsername.setLayoutY(40);
          textFieldUsername.setId("User Name");
          layout.getChildren().add(textFieldUsername);

          lbUsername = new Label("User Name");
          lbUsername.setFont(new Font("Times New Roman", 15));
          lbUsername.setPrefSize(121, 24);
          lbUsername.setLayoutX(10);
          lbUsername.setLayoutY(40);
          layout.getChildren().add(lbUsername);
          
          
          textFieldPasword = new TextField();
          textFieldPasword.setPrefSize(144, 20);
          textFieldPasword.setLayoutX(181);
          textFieldPasword.setLayoutY(90);
          textFieldPasword.setId("Password");
          layout.getChildren().add( textFieldPasword);

          lbPasword = new Label("Password");
          lbPasword.setFont(new Font("Times New Roman", 15));
          lbPasword.setPrefSize(121, 24);
          lbPasword.setLayoutX(10);
          lbPasword.setLayoutY(90);
          layout.getChildren().add(lbPasword);
          
          btnLogin= new Button("Login");
          btnLogin.setPrefSize(80, 20);
          btnLogin.setLayoutX(181);
          btnLogin.setLayoutY(150);
          btnLogin.setOnAction(e-> primaryStage.setScene(scene2)); //new Task().scene
          btnLogin.setId("Login");
          layout.getChildren().add( btnLogin);
          
          //------------Scene 2(Task)---------------------  
          Pane layout2 = new Pane();
          scene2 = new Scene(layout2, 700, 700);

          
          btnSaleItem= new Button("Sell Item");
          btnSaleItem.setPrefSize(300, 100);
          btnSaleItem.setLayoutX(200);
          btnSaleItem.setLayoutY(40);
          btnSaleItem.setOnAction(e-> primaryStage.setScene(scene3));
          btnSaleItem.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
          btnSaleItem.setId("Sell Item");
          layout2.getChildren().add(btnSaleItem);
          
          btnRetrnItem= new Button("Return Item");
          btnRetrnItem.setPrefSize(300, 100);
          btnRetrnItem.setLayoutX(200);
          btnRetrnItem.setLayoutY(160);
          btnRetrnItem.setOnAction(e-> primaryStage.setScene(scene4));
          btnRetrnItem.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
          btnRetrnItem.setId("Return Item");
          layout2.getChildren().add(btnRetrnItem);
          
          btnUpdateInventory= new Button("Update Inventory");
          btnUpdateInventory.setPrefSize(300, 100);
          btnUpdateInventory.setLayoutX(200);
          btnUpdateInventory.setLayoutY(280);
          btnUpdateInventory.setOnAction(e-> primaryStage.setScene(scene6));
          btnUpdateInventory.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
          btnUpdateInventory.setId("Update Inventory");
          layout2.getChildren().add(btnUpdateInventory);
          
          btnGenerateReport= new Button("Generate Report");
          btnGenerateReport.setPrefSize(300, 100);
          btnGenerateReport.setLayoutX(200);
          btnGenerateReport.setLayoutY(400);
          btnGenerateReport.setOnAction(e-> primaryStage.setScene(scene5));
          btnGenerateReport.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
          btnGenerateReport.setId("Generate Report");
          layout2.getChildren().add(btnGenerateReport);
          
        //------------Scene 3(Sell  Item)---------------------  
          
      Pane layout3 = new Pane();
           scene3 = new Scene(layout3, 700, 700);

         
          textFieldUFC = new TextField();
          textFieldUFC.setPrefSize(220, 40);
          textFieldUFC.setLayoutX(250);
          textFieldUFC.setLayoutY(40);
          textFieldUFC.setId("UFC");
          layout3.getChildren().add(textFieldUFC);

          lbUFC = new Label("UFC");
          lbUFC.setFont(new Font("Times New Roman", 25));
          lbUFC.setPrefSize(121, 24);
          lbUFC.setLayoutX(120);
          lbUFC.setLayoutY(40);
          layout3.getChildren().add(lbUFC);
          
          
          textFieldQuantity = new TextField();
          textFieldQuantity.setPrefSize(220, 40);
          textFieldQuantity.setLayoutX(250);
          textFieldQuantity.setLayoutY(100);
          textFieldQuantity.setId("Quantity");
          layout3.getChildren().add( textFieldQuantity);

          lbQuantity = new Label("Quantity");
          lbQuantity.setFont(new Font("Times New Roman", 25));
          lbQuantity.setPrefSize(121, 24);
          lbQuantity.setLayoutX(120);
          lbQuantity.setLayoutY(100);
          layout3.getChildren().add(lbQuantity);
          
          btnItemRemove= new Button("Remove");
          btnItemRemove.setPrefSize(100, 30);
          btnItemRemove.setLayoutX(200);
          btnItemRemove.setLayoutY(180);
          btnItemRemove.setId("Remove");
          btnItemRemove.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
          layout3.getChildren().add( btnItemRemove);
          
          btnAdd= new Button("Add");
          btnAdd.setPrefSize(100, 30);
          btnAdd.setLayoutX(340);
          btnAdd.setLayoutY(180);
          btnAdd.setId("Add");
          btnAdd.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
          layout3.getChildren().add(btnAdd);
          
          
          textFieldPrice = new TextField();
          textFieldPrice.setPrefSize(220, 40);
          textFieldPrice.setLayoutX(250);
          textFieldPrice.setLayoutY(280);
          textFieldPrice.setId("Price");
          layout3.getChildren().add( textFieldPrice);

          lbPrice = new Label("Price");
          lbPrice.setFont(new Font("Times New Roman", 25));
          lbPrice.setPrefSize(121, 24);
          lbPrice.setLayoutX(120);
          lbPrice.setLayoutY(280);
          layout3.getChildren().add(lbPrice);
          
          textFieldTotal = new TextField();
          textFieldTotal.setPrefSize(220, 40);
          textFieldTotal.setLayoutX(250);
          textFieldTotal.setLayoutY(340);
          textFieldTotal.setId("Total");
          layout3.getChildren().add(   textFieldTotal);

          lbTotal = new Label("Total");
          lbTotal.setFont(new Font("Times New Roman", 25));
          lbTotal.setPrefSize(121, 24);
          lbTotal.setLayoutX(120);
          lbTotal.setLayoutY(340);
          layout3.getChildren().add(lbTotal);
          
          
          textFieldTax = new TextField();
          textFieldTax.setPrefSize(220, 40);
          textFieldTax.setLayoutX(250);
          textFieldTax.setLayoutY(400);
          textFieldTotal.setId("Tax");
          layout3.getChildren().add(textFieldTax);

          lbTax = new Label("Tax");
          lbTax.setFont(new Font("Times New Roman", 25));
          lbTax.setPrefSize(121, 24);
          lbTax.setLayoutX(120);
          lbTax.setLayoutY(400);
          layout3.getChildren().add(lbTax);
          
          btnCancel= new Button("Cancel");
          btnCancel.setPrefSize(100, 30);
          btnCancel.setLayoutX(200);
          btnCancel.setLayoutY(480);
          btnCancel.setId("Cancel");
          btnCancel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
          layout3.getChildren().add(btnCancel);
          
          btnCheckOut= new Button("CheckOut");
          btnCheckOut.setPrefSize(100, 30);
          btnCheckOut.setLayoutX(340);
          btnCheckOut.setLayoutY(480);
          btnCheckOut.setId("CheckOut");
          btnCheckOut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
          layout3.getChildren().add(btnCheckOut);
          
          //------------Scene 4(Return Item)---------------------  
          
          
          Pane layout4 = new Pane();
         scene4 = new Scene(layout4, 1000, 1000);

          
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
          
          btnSearch= new Button("Search");
          btnSearch.setPrefSize(100, 30);
          btnSearch.setLayoutX(350);
          btnSearch.setLayoutY(140);
          btnSearch.setId("Search");
          btnSearch.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
          layout4.getChildren().add(btnSearch);
          
          
          table = new TableView<>();
          table.setEditable(true);
          // table.setBorder(new Border());
          // table.setColumnResizePolicy((param) -> true );
          TableColumn UFC = new TableColumn("UFC");
          UFC.setResizable(true);
          UFC.setMinWidth(150);
          TableColumn ItemName = new TableColumn("ItemName");
          ItemName.setResizable(true);
          ItemName.setMinWidth(150);
          TableColumn Quantity = new TableColumn("Quantity");
          Quantity.setMinWidth(150);
          TableColumn Cost = new TableColumn("Cost");
          Cost.setResizable(true);
          Cost.setMinWidth(150);    
          // table.setItems(getGridData());
          table.getColumns().addAll(UFC, ItemName, Quantity, Cost);
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
          
          btnRemove= new Button("Remove");
          btnRemove.setPrefSize(100, 30);
          btnRemove.setLayoutX(330);
          btnRemove.setLayoutY(880);
          btnRemove.setId("Remove");
          btnRemove.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
          layout4.getChildren().add(btnRemove);
          
          btnReset= new Button("Reset");
          btnReset.setPrefSize(100, 30);
          btnReset.setLayoutX(460);
          btnReset.setLayoutY(880);
          btnReset.setId("Reset");
          btnReset.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
          layout4.getChildren().add(btnReset);
          
          
        //------------Scene 5(Generate report)---------------------
          
          Pane layout5 = new Pane();
           scene5 = new Scene(layout5, 700, 700);

          
          btnInventoryReport= new Button("Inventory Report");
          btnInventoryReport.setPrefSize(300, 100);
          btnInventoryReport.setLayoutX(200);
          btnInventoryReport.setLayoutY(40);
          btnInventoryReport.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
          btnInventoryReport.setId("Inventory Report");
          layout5.getChildren().add(btnInventoryReport);
          
          btnCashierReport= new Button("Cashier Report");
          btnCashierReport.setPrefSize(300, 100);
          btnCashierReport.setLayoutX(200);
          btnCashierReport.setLayoutY(160);
          btnCashierReport.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
          btnCashierReport.setId("Cashier Report");
          layout5.getChildren().add(btnCashierReport);
          
          btnRegisterReport= new Button("Register Report");
          btnRegisterReport.setPrefSize(300, 100);
          btnRegisterReport.setLayoutX(200);
          btnRegisterReport.setLayoutY(280);
          btnRegisterReport.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
          btnRegisterReport.setId("Register report");
          layout5.getChildren().add(btnRegisterReport);
          
          
          //------------Scene 6(Update Inventory)---------------------
          
          
          Pane layout6 = new Pane();
          scene6 = new Scene(layout6, 700, 700);

         
          textFieldUFC = new TextField();
          textFieldUFC.setPrefSize(220, 40);
          textFieldUFC.setLayoutX(250);
          textFieldUFC.setLayoutY(40);
          textFieldUFC.setId("UFC");
          layout6.getChildren().add(textFieldUFC);

          lbUFC = new Label("UFC");
          lbUFC.setFont(new Font("Times New Roman", 25));
          lbUFC.setPrefSize(121, 24);
          lbUFC.setLayoutX(120);
          lbUFC.setLayoutY(40);
          layout6.getChildren().add( lbUFC);
          
          
          textFieldQuantity = new TextField();
          textFieldQuantity.setPrefSize(220, 40);
          textFieldQuantity.setLayoutX(250);
          textFieldQuantity.setLayoutY(100);
          textFieldQuantity.setId("Quantity");
          layout6.getChildren().add( textFieldQuantity);

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
          
          primaryStage.setScene(scene1);
          primaryStage.show();
		
		

		
	}
	@Override
	public void handle(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}

