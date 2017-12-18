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


    /**
    *Gui is started here and the FXML file is loaded
    */
	@Override
	public void start(Stage primaryStage) {
		try {

		    setPrimaryStage(primaryStage);
			Parent root = FXMLLoader.load(getClass().getResource("/view/InterfaceFXML.fxml"));
			Scene scene = new Scene(root);

			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}


	/**When the program is stoped storage data is saved
	 *
	 * @throws Exception
	 * if data cannot be saved
	 */


	 @Override
	public void stop() throws Exception {
		Storage STORAGE = getStorage();
		System.out.println("Saving data...");
		STORAGE.saveStorageState(1);
		STORAGE.saveStorageState(2);
		STORAGE.saveStorageState(3);
	}

	/**main class where the program is launched
	 *
	 */
	public static void main(String[] args) {
		launch(args);
	}


	/**primaryStage is set
	 *
	 */
	private void setPrimaryStage(Stage pStage){
	    Main.pStage = pStage;
    }


    public static Stage getPrimaryStage(){
	    return pStage;
    }

}
