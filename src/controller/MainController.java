package controller;

import javafx.fxml.FXML;
import controller.tab.Tab1Controller;
import controller.tab.Tab2Controller;
import controller.tab.Tab3Controller;

import java.util.ArrayList;

public class MainController {
	@FXML Tab1Controller tab1Controller;
	@FXML Tab2Controller tab2Controller;
	@FXML Tab3Controller tab3Controller;
	
	@FXML public void initialize() {
		System.out.println("Application started");
		tab1Controller.init(this);
		tab2Controller.init(this);
		tab3Controller.init(this);

	}


	public void sendNewItem(ArrayList<String> information) {
		tab1Controller.AddNewItem(information);
	}


}
