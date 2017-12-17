package controller.tab;

import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import controller.MainController;
import javafx.scene.effect.DropShadow;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import map.DataBuilder;
import parcel_system.*;
import map.SmartPost;
import stuff.DefaultItems;
import stuff.Item;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tab1Controller {
	
	private MainController main;

    private ObservableList <SmartPost> posts;
    private ObservableList <String> delivery_classes;
    private ObservableList<String> items;
    private DataBuilder db = new DataBuilder();
    private DefaultItems di = new DefaultItems();
    Storage warehouse = Storage.getStorage();
    ArrayList<Item> itemsArray;


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


    private void loadPreviousData(){
        Alert confirmationScreen = new Alert(Alert.AlertType.CONFIRMATION);
        confirmationScreen.setTitle("Confirmation Screen");
        confirmationScreen.setHeaderText("Ladataanko aikaisempi varastotilanne");
        confirmationScreen.setContentText("Voit aloittaa tyhjältä pöydältä tai ladata edellisen varastotilanteen.");

        ButtonType yes = new ButtonType("Kyllä");
        ButtonType no = new ButtonType("Ei");

        confirmationScreen.getButtonTypes().setAll(yes,no);

        Optional<ButtonType> result = confirmationScreen.showAndWait();
        if (result.get() == yes) {
            warehouse.getStoredData(1);
            warehouse.getStoredData(2);
            warehouse.getStoredData(3);
        } else if (result.get() == no) {
            System.out.println("Previous data was not loaded.");
            // do not load previous data
        } else {
            System.out.println("User closed the first dialog, previous data was not loaded.");
            //  user closed the dialog, do not load data
        }
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

                boolean value;
                Item item = itemsArray.get(itemIndex);
                DeliveryClassSelector selector = new DeliveryClassSelector();
                if (deliveryClassIndex == 1) {
                    FirstClass d1 = new FirstClass(item.getHeight(), item.getLength(),
                            item.getDepth(), item.getWeight(), item.isFragile(), item.getContent());
                    value = selector.testDeliveryClass(item,d1);
                    if (value == true) {
                        warehouse.AddPackage(d1);
                    }
                } else if (deliveryClassIndex == 2) {
                    SecondClass d2 = new SecondClass(item.getHeight(), item.getLength(),
                            item.getDepth(), item.getWeight(), item.isFragile(), item.getContent());
                    value = selector.testDeliveryClass(item,d2);
                    if (value == true){
                        warehouse.AddPackage(d2);
                    }
                }else {
                    ThirdClass d3 = new ThirdClass(item.getHeight(), item.getLength(),
                        item.getDepth(), item.getWeight(), item.isFragile(), item.getContent());
                    value = selector.testDeliveryClass(item,d3);
                    if (value == true){
                        warehouse.AddPackage(d3);
                    }
                }

            }
        });
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
        itemsArray= di.getDefaultItems();
    }


    @FXML public void initialize() {
        mapView.getEngine().load(getClass().getResource("index.html").toExternalForm());
        ArrayList<SmartPost> cities = db.returnCities();
        loadPreviousData();
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

        /* Generates new object of class Item. */
        // TODO information box for fragile, this method adds two items to list for some reason
        Item i = new Item(Double.parseDouble(information.get(1)),
                Double.parseDouble(information.get(2)),
                Double.parseDouble(information.get(3)),
                Double.parseDouble(information.get(4)),1,
                information.get(0));
        itemsArray.add(i);
        System.out.println(itemsArray.size());

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



    public void init(MainController mainController) {
		main = mainController;
	}
}
