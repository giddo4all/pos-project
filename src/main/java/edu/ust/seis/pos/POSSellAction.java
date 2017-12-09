package edu.ust.seis.pos;

import java.io.IOException;
import java.net.URISyntaxException;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import static edu.ust.seis.pos.Commons.*;

public class POSSellAction {

	private Label lbUPC, lbQuantity, lbPrice, lbTotal, lbTax;

	private TextField textFieldUPC, textFieldQuantity, textFieldPrice, textFieldTotal, textFieldTax;

	private Button btnAdd, btnCancel, btnCheckOut, btnItemRemove;
	private Scene scene;

	private void setScene() {
		Pane layout3 = new Pane();
		this.scene = new Scene(layout3, 700, 1000);

		textFieldUPC = new TextField();
		textFieldUPC.setPrefSize(220, 40);
		textFieldUPC.setLayoutX(250);
		textFieldUPC.setLayoutY(40);
		textFieldUPC.setId("UPC");
		layout3.getChildren().add(textFieldUPC);

		lbUPC = new Label("UPC");
		lbUPC.setFont(new Font("Times New Roman", 25));
		lbUPC.setPrefSize(121, 24);
		lbUPC.setLayoutX(120);
		lbUPC.setLayoutY(40);
		layout3.getChildren().add(lbUPC);

		textFieldQuantity = new TextField();
		textFieldQuantity.setPrefSize(220, 40);
		textFieldQuantity.setLayoutX(250);
		textFieldQuantity.setLayoutY(100);
		textFieldQuantity.setId("Quantity");
		layout3.getChildren().add(textFieldQuantity);

		lbQuantity = new Label("Quantity");
		lbQuantity.setFont(new Font("Times New Roman", 25));
		lbQuantity.setPrefSize(121, 24);
		lbQuantity.setLayoutX(120);
		lbQuantity.setLayoutY(100);
		layout3.getChildren().add(lbQuantity);

		btnItemRemove = new Button("Remove");
		btnItemRemove.setPrefSize(100, 30);
		btnItemRemove.setLayoutX(200);
		btnItemRemove.setLayoutY(180);
		btnItemRemove.setId("Remove");
		btnItemRemove.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
		layout3.getChildren().add(btnItemRemove);

		btnAdd = new Button("Add");
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
		layout3.getChildren().add(textFieldPrice);

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
		layout3.getChildren().add(textFieldTotal);

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

		btnCancel = new Button("Cancel");
		btnCancel.setPrefSize(100, 30);
		btnCancel.setLayoutX(200);
		btnCancel.setLayoutY(480);
		btnCancel.setId("Cancel");
		btnCancel.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
		layout3.getChildren().add(btnCancel);

		btnCheckOut = new Button("CheckOut");
		btnCheckOut.setPrefSize(100, 30);
		btnCheckOut.setLayoutX(340);
		btnCheckOut.setLayoutY(480);
		btnCheckOut.setId("CheckOut");
		btnCheckOut.setFont(Font.font("Tahoma", FontWeight.NORMAL, 16));
		layout3.getChildren().add(btnCheckOut);

		TableView<String> table1 = new TableView<>();
		table1.setEditable(true);
		// table.setBorder(new Border());
		// table.setColumnResizePolicy((param) -> true );
		TableColumn UPC = new TableColumn("UPC");
		UPC.setResizable(true);
		UPC.setMinWidth(150);

		TableColumn Quantity = new TableColumn("Quantity");
		Quantity.setResizable(true);
		Quantity.setMinWidth(150);

		// table.setItems(getGridData());
		table1.getColumns().addAll(UPC, Quantity);
		table1.setLayoutX(180);
		table1.setLayoutY(560);
		layout3.getChildren().add(table1);

	}

	public Scene getScene() {
		setScene();
		return scene;
	}
	
	public POSSellAction(String[] param, String upc) throws IOException, URISyntaxException{
		
		DataStore ds = new DataStore();
		ds.dataStoreRead(INV_SHEETNAME, INV_UPC, param, upc);
		
	}
}
