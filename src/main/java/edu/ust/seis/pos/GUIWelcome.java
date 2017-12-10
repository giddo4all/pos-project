package edu.ust.seis.pos;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class GUIWelcome {
	
	
	private static String welcomeFXMLFileName = "welcome.fxml";
	ConWelcome allTaskController;
	
	public void display(String windowTitle) throws Exception {
		try {
			Stage stageAllTask = new Stage();
//			stageAllTask.initModality();;
//			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource(allTaskFXMLFileName));
//			new FileInputStream(new File(URLDecoder.decode(cl.getResource(fileName).getPath(), "UTF-8")));
			FXMLLoader fxmlLoader = new FXMLLoader();
			fxmlLoader.setLocation(getClass().getClassLoader().getResource(welcomeFXMLFileName));
//			FileInputStream fs = Commons.getFileInputStream(getClass(), allTaskFXMLFileName);
			
			Parent root = fxmlLoader.load();
			allTaskController = fxmlLoader.getController();

			Scene scene = new Scene(root);
			stageAllTask.setScene(scene);
//			SecuritySubsystem sbs = new SecuritySubsystem();
			stageAllTask.setTitle(SecuritySubsystem.getTitleString());
			stageAllTask.show();

		} catch (Exception e) {
			e.printStackTrace();
			new Alert(Alert.AlertType.ERROR, e.getMessage()).showAndWait();
		}
	}

}
