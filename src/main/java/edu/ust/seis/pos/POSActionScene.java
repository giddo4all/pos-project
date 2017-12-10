//package edu.ust.seis.pos;
//
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.layout.Pane;
//import javafx.scene.text.Font;
//import javafx.scene.text.FontWeight;
//import javafx.stage.Stage;
//
//public class POSActionScene {
//
//	private Button btnSaleItem, btnRetrnItem, btnUpdateInventory, btnGenerateReport;
//	private Scene scene;
//	
//	public POSActionScene(){
////		Thread.currentThread().
//		
//	}
//	private void updateScene() throws Exception {
//		 
//		
//		Pane layout2 = new Pane();
//				
//		btnSaleItem = new Button("Sell Item");
//		btnSaleItem.setPrefSize(300, 100);
//		btnSaleItem.setLayoutX(200);
//		btnSaleItem.setLayoutY(40);
////		btnSaleItem.setOnMouseClicked(e -> new POSLauncher().setPrimaryStage(new POSSellAction().getScene()));
//		btnSaleItem.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
//		btnSaleItem.setId("Sell Item");
//		layout2.getChildren().add(btnSaleItem);
//
//		btnRetrnItem = new Button("Return Item");
//		btnRetrnItem.setPrefSize(300, 100);
//		btnRetrnItem.setLayoutX(200);
//		btnRetrnItem.setLayoutY(160);
////		btnRetrnItem.setOnAction(e -> primaryStage.setScene(scene4));
//		btnRetrnItem.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
//		btnRetrnItem.setId("Return Item");
//		layout2.getChildren().add(btnRetrnItem);
//
//		btnUpdateInventory = new Button("Update Inventory");
//		btnUpdateInventory.setPrefSize(300, 100);
//		btnUpdateInventory.setLayoutX(200);
//		btnUpdateInventory.setLayoutY(280);
////		btnUpdateInventory.setOnAction(e -> primaryStage.setScene(scene6));
//		btnUpdateInventory.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
//		btnUpdateInventory.setId("Update Inventory");
//		layout2.getChildren().add(btnUpdateInventory);
//
//		btnGenerateReport = new Button("Generate Report");
//		btnGenerateReport.setPrefSize(300, 100);
//		btnGenerateReport.setLayoutX(200);
//		btnGenerateReport.setLayoutY(400);
////		btnGenerateReport.setOnAction(e -> primaryStage.setScene(scene5));
//		btnGenerateReport.setFont(Font.font("Tahoma", FontWeight.NORMAL, 25));
//		btnGenerateReport.setId("Generate Report");
//		layout2.getChildren().add(btnGenerateReport);
//		
//		this.scene = new Scene(layout2, 700, 700);
//	}
//	
//	public Scene getScene() throws Exception {
//		updateScene();
//		return scene;
//	}
//
//}
