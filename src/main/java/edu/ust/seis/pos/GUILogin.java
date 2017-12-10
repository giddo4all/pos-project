package edu.ust.seis.pos;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class GUILogin extends Application {

	// init xy offsets
//	private double xOffset = 0;
//	private double yOffset = 0;
	Stage window;
	Scene sceneAllTask;
	ConLogin loginFXMLController; //= new FXMLLoginController();
	String loginSceneFXML = "login.fxml";


	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			window = primaryStage;
			FXMLLoader fxmlLoader = new FXMLLoader();
//			FileInputStream fi = Commons.getFileInputStream(getClass(), loginSceneFXML);
			fxmlLoader.setLocation(getClass().getClassLoader().getResource(loginSceneFXML));
//			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(loginSceneFXML));

			VBox root = (VBox) fxmlLoader.load();
			loginFXMLController = fxmlLoader.getController();
			
			window.initStyle(StageStyle.UNDECORATED);
			Scene scene = new Scene(root);
			window.setScene(scene);
			window.show();

		} catch (Exception e) {
			e.printStackTrace();
			new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
		}
	}
	
	

	public Stage getMainWindow() {
		return window;
	}

	public void setMainWindow(Scene sc, String title) {
		window.setScene(sc);
		window.setTitle(title);
		window.show();
	}

	private Scene createScene(String fxmlFileName) throws IOException, URISyntaxException, RecordNotFoundException,
			DuplicatePrimaryKeyException {
		Parent sc = FXMLLoader.load(getClass().getClassLoader().getResource(fxmlFileName));
		Scene scene = new Scene(sc);
		SecuritySubsystem sbs = new SecuritySubsystem();
		setMainWindow(scene, sbs.getUserName() + " " + sbs.getUserID());

		return scene;

	}

	Scene getAllTaskScene() throws IOException, URISyntaxException, RecordNotFoundException,
			DuplicatePrimaryKeyException {

		return createScene("Main.fxml");
	}

	public void setAllTaskScenePrimary() throws IOException, URISyntaxException, RecordNotFoundException,
			DuplicatePrimaryKeyException {

		getAllTaskScene();

	}
	
//	public void allTaskSceneTrigger(){
//
//		try {
//			
//		if(loginFXMLController.login()){
//			
//				createScene("Main.fxml");
//		}
//			} catch (Exception e) {
//				new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
//			}
//		
//	}
}
