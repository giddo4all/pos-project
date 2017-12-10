package edu.ust.seis.pos;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class GUISales {
	
	
	private static String saleFXMLFileName = "sales.fxml";
	ConSales salesController;

	public void display() {
		try {
			Stage stageAllTask = new Stage();

			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getClassLoader().getResource(saleFXMLFileName));

			Parent root = fxmlLoader.load();
			saleFXMLFileName = fxmlLoader.getController();

			Scene scene = new Scene(root);
			stageAllTask.setScene(scene);
			stageAllTask.setTitle(SecuritySubsystem.getTitleString());
			stageAllTask.show();

		} catch (Exception e) {
			e.printStackTrace();
			new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
		}

	}

}
