package controller.tab;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import controller.MainController;
import javafx.scene.effect.DropShadow;
import javafx.scene.web.WebView;
import map.DataBuilder;
import parcel_system.*;
import stuff.DefaultItems;
import stuff.Item;

import java.util.ArrayList;

public class Tab1Controller {
	
	private MainController main;

    private ObservableList <String> posts;
    private ObservableList <String> delivery_classes;
    private ObservableList<String> items;

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
    private ChoiceBox<String> listOfItems;

    /**
     * Initializes the controller class.
     */

    @FXML
    private void sendPacket(ActionEvent event) {

    }

    private void initSendButton(){
        sendPacket.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Send button pressed.");
                String itemName = listOfItems.getValue();
                int itemIndex = listOfItems.getSelectionModel().selectedIndexProperty().getValue();
                String deliveryClassName = ListOfPacketClasses.getValue();
                int deliveryClassIndex = ListOfPacketClasses.getSelectionModel().selectedIndexProperty().getValue();
                System.out.println(itemName + " sent in class " + deliveryClassName);

                DefaultItems di = new DefaultItems();
                ArrayList<Item> diArray = di.getDefaultItems();
                Item item = diArray.get(itemIndex);
                DeliveryClass delivery;
                if (deliveryClassIndex == 1) {
                    FirstClass d1 = new FirstClass(item.getHeight(), item.getLength(),
                            item.getDepth(), item.getWeight(), item.isFragile(), item.getContent());
                    delivery = d1;
                } else if (deliveryClassIndex == 2) {
                    SecondClass d2 = new SecondClass(item.getHeight(), item.getLength(),
                            item.getDepth(), item.getWeight(), item.isFragile(), item.getContent());
                    delivery = d2;
                }else {
                    ThirdClass d3 = new ThirdClass(item.getHeight(), item.getLength(),
                        item.getDepth(), item.getWeight(), item.isFragile(), item.getContent());
                    delivery = d3;
                }
                DeliveryClassSelector selector = new DeliveryClassSelector();
                boolean value = selector.testDeliveryClass(item,delivery);

                }




            }
        );
    }




    public void setListOfCities(ArrayList<String> list){
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
        DataBuilder db = new DataBuilder();
        ArrayList<String> cities = db.returnCities();
        setListOfCities(cities);
        smartPostLocations.setItems(this.posts);

        setDeliveryClasses();
        fillDefaultItems();
        initSendButton();



    }

    @FXML private void addOnMap(ActionEvent event){


    }


	public void init(MainController mainController) {
		main = mainController;
	}
}
