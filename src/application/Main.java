package application;
	
import controller.tab.Tab1Controller;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import map.DataBuilder;

import java.util.ArrayList;


public class Main extends Application {


	@Override
	public void start(Stage primaryStage) {
		try {

			Parent root = FXMLLoader.load(getClass().getResource("/view/Main.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DataBuilder postPoints = new DataBuilder();
		Tab1Controller tab1 = new Tab1Controller();
		tab1.setListOfCities(postPoints.returnCities());
		launch(args);

	}
}
