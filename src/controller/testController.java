package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.web.WebView;
import map.DataBuilder;
import map.SmartPost;
import parcel_system.*;
import stuff.DefaultItems;
import stuff.Item;

import java.util.ArrayList;
import java.util.Optional;

public class testController {
    private ObservableList<SmartPost> posts;
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
    private Button addItem;
    @FXML
    private ComboBox<String> ListOfPacketClasses;
    @FXML
    private ComboBox<String> listOfItems;
    @FXML
    private ComboBox<SmartPost> senderPost;
    @FXML
    private ComboBox<SmartPost> receiverPost;
    @FXML
    private TextField newThingName;
    @FXML
    private TextField newThingWeight;
    @FXML
    private TextField newThingLength;
    @FXML
    private TextField newThingHeight;
    @FXML
    private TextField newThingWidth;
    @FXML
    private Button emptyMapButton;

    @FXML
    private CheckBox fragile;



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

                SmartPost source;
                SmartPost destination;
                source = db.searchCity(senderPost.getValue().getAddress(),
                        senderPost.getValue().getPostCode());
                destination = db.searchCity(receiverPost.getValue().getAddress(),
                        receiverPost.getValue().getPostCode());

                boolean value;
                Item item = itemsArray.get(itemIndex);
                DeliveryClassSelector selector = new DeliveryClassSelector();
                if (deliveryClassIndex == 0) {
                    FirstClass d1 = new FirstClass(item.getHeight(), item.getLength(),
                            item.getDepth(), item.getWeight(), item.isFragile(), item.getContent());
                    value = selector.testDeliveryClass(item,d1);
                    if (value == true) {
                        d1.setDestination(destination);
                        d1.setSource(source);
                        warehouse.AddPackage(d1);
                    }
                } else if (deliveryClassIndex == 1) {
                    SecondClass d2 = new SecondClass(item.getHeight(), item.getLength(),
                            item.getDepth(), item.getWeight(), item.isFragile(), item.getContent());
                    value = selector.testDeliveryClass(item,d2);
                    if (value == true){
                        d2.setDestination(destination);
                        d2.setSource(source);
                        warehouse.AddPackage(d2);
                    }
                }else if (deliveryClassIndex == 2) {
                    ThirdClass d3 = new ThirdClass(item.getHeight(), item.getLength(),
                            item.getDepth(), item.getWeight(), item.isFragile(), item.getContent());
                    value = selector.testDeliveryClass(item,d3);
                    if (value == true){
                        d3.setDestination(destination);
                        d3.setSource(source);
                        warehouse.AddPackage(d3);
                    }
                }

                System.out.println("Warehouse contains:");
                warehouse.printPackages();
            }
        });
    }





    private void setListOfCities(ArrayList<SmartPost> list){
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
        setListOfCities(cities);
        smartPostLocations.setItems(this.posts);
        senderPost.setItems(this.posts);
        receiverPost.setItems(this.posts);

        setDeliveryClasses();
        fillDefaultItems();
        initSendButton();

        loadPreviousData();

    }

    @FXML private void addOnMap(ActionEvent event){
        SmartPost found = db.searchCity(smartPostLocations.getValue().getAddress(), smartPostLocations.getValue().getPostCode());
        mapView.getEngine().executeScript("document.goToLocation('"+found.getAddress()+", "+ Integer.toString(found.getPostCode())+" "+ found.getCity()+"', '"+found.getAvailable()+"', 'blue')");
        System.out.println("document.goToLocation('"+found.getAddress()+", "+ Integer.toString(found.getPostCode())+" "+ found.getCity()+"', '"+found.getAvailable()+"', 'blue')");

    }

    @FXML private void emptyMap(ActionEvent event){
        mapView.getEngine().executeScript("document.deletePaths()");

    }


    @FXML public void AddNewItem(ActionEvent event ){
        if(!isDouble(newThingHeight.getText())){
            alert("Korkeuden tulee olla numero");
        }
        else if(!isDouble(newThingLength.getText())){
            alert("Pituuden tulee olla numero");
        }
        else if(!isDouble(newThingWidth.getText())){
            alert("Leveyden tulee olla numero");
        }
        else if(!isDouble(newThingWeight.getText())){
            alert("Painon tulee olla numero");
        }else{
            di.AddnewItem(Double.parseDouble(newThingHeight.getText()),
                    Double.parseDouble(newThingLength.getText()),
                    Double.parseDouble(newThingWidth.getText()),
                    Double.parseDouble(newThingWeight.getText()),
                    newThingName.getText()
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
        Item i = new Item(Double.parseDouble(newThingHeight.getText()),
                Double.parseDouble(newThingLength.getText()),
                Double.parseDouble(newThingWidth.getText()),
                Double.parseDouble(newThingWeight.getText()), fragile.isSelected() ? 1:0,
                newThingName.getText());
        itemsArray.add(i);
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

    @FXML public void handleSourceAction(ActionEvent event){
        SmartPost found = db.searchCity(senderPost.getValue().getAddress(), senderPost.getValue().getPostCode());
        mapView.getEngine().executeScript("document.goToLocation('"+found.getAddress()+", "+ Integer.toString(found.getPostCode())+" "+ found.getCity()+"', '"+found.getAvailable()+"', 'orange')");
    }


    @FXML public void handleDestinationAction(ActionEvent event) {
        SmartPost sender = db.searchCity(senderPost.getValue().getAddress(), senderPost.getValue().getPostCode());
        SmartPost receiver = db.searchCity(receiverPost.getValue().getAddress(), receiverPost.getValue().getPostCode());
        mapView.getEngine().executeScript("document.goToLocation('" + receiver.getAddress() + ", " + Integer.toString(receiver.getPostCode()) + " " + receiver.getCity() + "', '" + receiver.getAvailable() + "', 'orange')");
        double senderLat = sender.getLatitude();
        double senderLng = sender.getLongitude();
        double receiverLat = receiver.getLatitude();
        double receiverLng = receiver.getLongitude();

        ArrayList<String> coordinates = new ArrayList<>();
        coordinates.add(String.valueOf(senderLat));
        coordinates.add(String.valueOf(senderLng));
        coordinates.add(String.valueOf(receiverLat));
        coordinates.add(String.valueOf(receiverLng));
        mapView.getEngine().executeScript("document.createPath("
                + coordinates + ",'blue',"
                + ListOfPacketClasses.getSelectionModel().selectedIndexProperty().getValue() + ")");

    }
}
