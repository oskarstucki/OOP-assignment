package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.web.WebView;
import map.DataBuilder;
import map.SmartPost;
import parcel_system.*;
import stuff.DefaultItems;
import stuff.Item;

import java.util.ArrayList;

public class testController {
    private ObservableList<SmartPost> posts;
    private ObservableList <String> delivery_classes;
    private ObservableList<String> items;
    private DataBuilder db = new DataBuilder();
    private DefaultItems di = new DefaultItems();

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
    @FXML
    private Button emptyMapButton;



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
        initSendButton();



    }

    @FXML private void addOnMap(ActionEvent event){
        SmartPost found = db.searchCity(smartPostLocations.getValue().getAddress(), smartPostLocations.getValue().getPostCode());
        mapView.getEngine().executeScript("document.goToLocation('"+found.getAddress()+", "+ Integer.toString(found.getPostCode())+" "+ found.getCity()+"', '"+found.getAvailable()+"', 'blue')");
        System.out.println("document.goToLocation('"+found.getAddress()+", "+ Integer.toString(found.getPostCode())+" "+ found.getCity()+"', '"+found.getAvailable()+"', 'blue')");

    }

    @FXML private void emptyMap(ActionEvent event){
        mapView.getEngine().executeScript("document.deletePaths()");

    }


    public void AddNewItem(ArrayList<String> information ){
        if(!isDouble(information.get(1))){
            alert("Korkeuden tulee olla numero");
        }
        else if(!isDouble(information.get(2))){
            alert("Pituuden tulee olla numero");
        }
        else if(!isDouble(information.get(3))){
            alert("Leveyden tulee olla numero");
        }
        else if(!isDouble(information.get(4))){
            alert("Painon tulee olla numero");
        }else{
            di.AddnewItem(Double.parseDouble(information.get(1)),
                    Double.parseDouble(information.get(2)),
                    Double.parseDouble(information.get(3)),
                    Double.parseDouble(information.get(4)),
                    information.get(0)
            );
            fillDefaultItems();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Tuote lisätty");
            alert.setHeaderText(null);
            alert.setContentText("Uusi tuote lisätty onnistuneesti!");
            alert.showAndWait();

        }


    }

    public boolean isDouble( String str ){
        try{
            Double.parseDouble( str );
            return true;
        }
        catch( Exception e ){
            return false;
        }
    }

    public void alert(String allerter){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Varoitus");
        alert.setHeaderText(null);
        alert.setContentText(allerter);
        alert.showAndWait();
    }

}
