package controller.tab;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import controller.MainController;
import javafx.scene.web.WebView;
import map.DataBuilder;
import map.SmartPost;
import javax.swing.*;
import java.util.ArrayList;

public class Tab1Controller {
	
	private MainController main;
    private ArrayList<String> listOfCities;

    private ObservableList <String> posts;

    public void setListOfCities(ArrayList<String> list){
        this.posts = FXCollections.observableArrayList(list);
    }
    @FXML
    private Button sendPacket;
    @FXML
    private WebView mapView;
    @FXML
    private ComboBox<String> smartPostLocations;
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

        smartPostLocations.setItems(this.posts);



    }

    @FXML private void addOnMap(ActionEvent event){


    }


	public void init(MainController mainController) {
		main = mainController;
	}
}
