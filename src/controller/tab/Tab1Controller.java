package controller.tab;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import controller.MainController;
import javafx.scene.web.WebView;
import map.DataBuilder;
import map.SmartPost;

import javax.swing.*;
import java.util.ArrayList;

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
        ArrayList<String> listOfCities = new ArrayList<String>();
        listOfCities = DataBuilder.returnCities();
        JComboBox<SmartPost> posts = new JComboBox<SmartPost>();

    }

    @FXML private void addOnMap(ActionEvent event){


    }


	public void init(MainController mainController) {
		main = mainController;
	}
}
