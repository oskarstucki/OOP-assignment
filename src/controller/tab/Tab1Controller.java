package controller.tab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import controller.MainController;
import javafx.scene.web.WebView;
import map.DataBuilder;

import java.util.ArrayList;

public class Tab1Controller {
	
	private MainController main;

    private ObservableList <String> posts;
    private ObservableList <String> delivery_classes;

    @FXML
    private Button sendPacket;
    @FXML
    private WebView mapView;
    @FXML
    private ComboBox<String> smartPostLocations;
    @FXML
    private Button addSmartPost;
    @FXML
    private ChoiceBox<String> ListOfPacketClasses;
    @FXML
    private ChoiceBox<?> listOfItems;

    /**
     * Initializes the controller class.
     */

    @FXML
    private void sendPacket(ActionEvent event) {



    }

    public void setListOfCities(ArrayList<String> list){
        posts = FXCollections.observableArrayList(list);
    }

    private void setDeliveryClasses(){
        delivery_classes = FXCollections.observableArrayList(
                "1. Luokka", "2. Luokka", "3. Luokka");
        ListOfPacketClasses.setItems(delivery_classes);
    }


    @FXML public void initialize() {
        mapView.getEngine().load(getClass().getResource("index.html").toExternalForm());
        DataBuilder db = new DataBuilder();
        ArrayList<String> cities = db.returnCities();
        setListOfCities(cities);
        smartPostLocations.setItems(this.posts);

        setDeliveryClasses();



    }

    @FXML private void addOnMap(ActionEvent event){


    }


	public void init(MainController mainController) {
		main = mainController;
	}
}
