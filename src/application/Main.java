package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import parcel_system.Storage;

import static parcel_system.Storage.getStorage;


public class Main extends Application {

    private static Stage pStage;


	@Override
	public void start(Stage primaryStage) {
		try {

		    setPrimaryStage(primaryStage);
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
		System.out.println("Saving data...");
		STORAGE.saveStorageState(1);
		STORAGE.saveStorageState(2);
		STORAGE.saveStorageState(3);
	}

	public static void main(String[] args) {
		launch(args);
	}

	private void setPrimaryStage(Stage pStage){
	    Main.pStage = pStage;
    }

    public static Stage getPrimaryStage(){
	    return pStage;
    }

}
