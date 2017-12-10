package edu.ust.seis.pos;

import javafx.event.ActionEvent;
import javafx.scene.input.MouseEvent;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ConWelcome {

	@FXML
	private MenuItem menuPrint;

	@FXML
	private MenuItem menuLogOut;

	@FXML
	private MenuItem menuQuit;

	@FXML
	private MenuItem menuClear;

	@FXML
	private MenuItem menuAbout;

	@FXML
	private MenuItem menuHelp;

	@FXML
	private AnchorPane anchorPaneTask;

	@FXML
	private Font x1;

	@FXML
	private Color x2;

	@FXML
	private Button btnSaleTask;

	@FXML
	private Button btnReturnTask;

	@FXML
	private Button btnInventoryTask;

	@FXML
	private Button btnReportsTask;

	@FXML
	private Font x3;

	@FXML
	private Color x4;

	@FXML
	void Mouse(ActionEvent event) {

	}

	@FXML
	void eventInventoryClick(MouseEvent event) {

	}

	@FXML
	void eventReportClick(MouseEvent event) {

	}

	@FXML
	void eventReturnsClick(MouseEvent event) {

	}

	@FXML
	void eventSellItemClick(MouseEvent event) {

		GUISales gs = new GUISales();
		gs.display();
	}

	@FXML
	void menuAboutClick(ActionEvent event) {

	}

	@FXML
	void menuHelpClick(ActionEvent event) {

	}

	@FXML
	void menuLogOutClick(ActionEvent event) {

	}

	@FXML
	void menuPrintClick(ActionEvent event) {

	}

	@FXML
	void menuQuitClick(ActionEvent event) {

	}

}
