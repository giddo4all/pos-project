package edu.ust.seis.pos;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ConLogin {

	@FXML
	private AnchorPane mainScene;

	@FXML
	private TextField userName;

	@FXML
	private PasswordField password;

	@FXML
	public Button btnLogin;

	@FXML
	private Button btnCancel;

	@FXML
	private void initialize(){

	}

	@FXML
	void eventCancelClick(MouseEvent event) {
		System.exit(0);
	}

	@FXML
	void eventLoginClick(MouseEvent event) {
		try {
			login();
		} catch (Exception e) {

		}
	}

	public void login() {
		boolean isGood = false;

		try {
			SecuritySubsystem sbs = new SecuritySubsystem();
			isGood = sbs.login(userName.getText(), password.getText());
			if (isGood) {
				GUIWelcome gat = new GUIWelcome();
				gat.display(sbs.getUserID());
//				Platform.exit();

			}
		} catch (Exception e) {
			// throw new Exception(e.getMessage());
			e.printStackTrace();
			new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
		}
		// return isGood;
	}
}
