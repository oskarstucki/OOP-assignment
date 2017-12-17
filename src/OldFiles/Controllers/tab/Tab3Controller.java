package controller.tab;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import controller.MainController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;




public class Tab3Controller implements Initializable {

    private MainController main;

    @FXML
    private TextField itemName;
    @FXML
    private TextField itemHeight;
    @FXML
    private TextField itemLength;
    @FXML
    private TextField itemWidth;
    @FXML
    private TextField itemWeight;
    @FXML
    private Button addNewItem;

    /**
     * Initializes the controller class.
     */
    @FXML
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addItem(ActionEvent event) {
        ArrayList<String> information = new ArrayList<String>();

        information.add(itemName.getText());
        information.add(itemHeight.getText());
        information.add(itemHeight.getText());
        information.add(itemLength.getText());
        information.add(itemWidth.getText());
        information.add(itemWeight.getText());
        main.sendNewItem(information);
    }

    public void init(MainController mainController) {
        main = mainController;
    }
}

