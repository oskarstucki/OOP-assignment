package controller.tab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import controller.MainController;
import javafx.scene.web.WebView;

public class Tab1Controller {
	
	private MainController main;

    @FXML
    private Button sendPacket;
    @FXML
    private WebView mapView;
    @FXML
    private ChoiceBox<?> smartPostLocations;
    @FXML
    private Button addSmartPost;
    @FXML
    private ChoiceBox<?> ListOfPacketClasses;
    @FXML
    private ChoiceBox<?> listOfItems;

    /**
     * Initializes the controller class.
     */

    @FXML
    private void sendPacket(ActionEvent event) {



    }

    @FXML public void initialize() {
        mapView.getEngine().load(getClass().getResource("index.html").toExternalForm());
    }


	public void init(MainController mainController) {
		main = mainController;
	}
}
