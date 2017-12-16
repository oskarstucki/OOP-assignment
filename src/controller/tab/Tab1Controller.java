package controller.tab;

import application.Main;
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
    private ArrayList<String> listOfCities;

    private JComboBox<String> posts = new JComboBox<String>();
    public void setListOfCities(ArrayList<String> list){
        this.posts = list.toArray();
    }
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



    }

    @FXML private void addOnMap(ActionEvent event){


    }


	public void init(MainController mainController) {
		main = mainController;
	}
}
