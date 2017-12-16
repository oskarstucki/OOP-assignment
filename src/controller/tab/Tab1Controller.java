package controller.tab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import controller.MainController;
import javafx.scene.web.WebView;
import map.DataBuilder;
import map.SmartPost;
import stuff.DefaultItems;

import java.util.ArrayList;

public class Tab1Controller {
	
	private MainController main;

    private ObservableList <SmartPost> posts;
    private ObservableList <String> delivery_classes;
    private ObservableList<String> items;
    private DataBuilder db = new DataBuilder();

    @FXML
    private Button sendPacket;
    @FXML
    private WebView mapView;
    @FXML
    private ComboBox<SmartPost> smartPostLocations;
    @FXML
    private Button addSmartPost;
    @FXML
    private ChoiceBox<String> ListOfPacketClasses;
    @FXML
    private ChoiceBox<String> listOfItems;

    /**
     * Initializes the controller class.
     */

    @FXML
    private void sendPacket(ActionEvent event) {



    }

    public void setListOfCities(ArrayList<SmartPost> list){
        posts = FXCollections.observableArrayList(list);
    }

    /**
     * Method for filling choise box ListOfPacketClasses.
     */
    private void setDeliveryClasses(){
        delivery_classes = FXCollections.observableArrayList(
                "1. Luokka", "2. Luokka", "3. Luokka");
        ListOfPacketClasses.setItems(delivery_classes);
    }

    /**
     * Method for filling the choise box with default items.
     */
    private void fillDefaultItems(){
        DefaultItems di = new DefaultItems();
        items = FXCollections.observableArrayList(di.getNames());
        listOfItems.setItems(items);
    }


    @FXML public void initialize() {
        mapView.getEngine().load(getClass().getResource("index.html").toExternalForm());

        ArrayList<SmartPost> cities = db.returnCities();
        setListOfCities(cities);
        smartPostLocations.setItems(this.posts);
        setDeliveryClasses();
        fillDefaultItems();



    }

    @FXML private void addOnMap(ActionEvent event){
        //SmartPost found = db.searchCity(smartPostLocations.getValue());
        //mapView.getEngine().executeScript("document.goToLocation('"+found.getAddress()+", "+ Integer.toString(found.getPostCode())+" "+ found.getCity()+"', '"+found.getAvailable()+"', 'blue')");
        //System.out.println("document.goToLocation('"+found.getAddress()+", "+ Integer.toString(found.getPostCode())+" "+ found.getCity()+"', '"+found.getAvailable()+"', 'blue')");

    }


	public void init(MainController mainController) {
		main = mainController;
	}
}
