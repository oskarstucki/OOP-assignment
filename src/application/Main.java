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

			Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void stop() throws Exception {
		Storage STORAGE = getStorage();
		STORAGE.saveStorageState(1);
		STORAGE.saveStorageState(2);
		STORAGE.saveStorageState(3);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
