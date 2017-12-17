package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import parcel_system.Storage;

import static parcel_system.Storage.getStorage;


public class Main extends Application {


	@Override
	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/view/ComplexApplication_css.fxml"));
			Scene scene = new Scene(root);

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() throws Exception {
		Storage STORAGE = getStorage();
		STORAGE.saveStorageState(STORAGE.getPriority());
		STORAGE.saveStorageState(STORAGE.getStandard());
		STORAGE.saveStorageState(STORAGE.getEconomy());
	}

	public static void main(String[] args) {
		launch(args);
	}
}
