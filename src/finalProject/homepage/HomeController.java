package finalProject.homepage;


import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class HomeController implements Initializable{
	@FXML
	private Button logout;
	@FXML
	private Button cart;
	@FXML
	private Button vrTOI;
	@FXML
	private Button vrMias;
	@FXML
	private Button vrPanda;
	@FXML
	private Button showAllRest;

	public void logout(ActionEvent event) throws Exception {//go to login page
		RestaurantAdvisor.getInstance().toLogin();
	}
	public void cart(ActionEvent event) throws Exception {//go to cart page
		RestaurantAdvisor.getInstance().toCart();
	}
	public void toRestaurant(ActionEvent event) throws Exception {
		RestaurantAdvisor.getInstance().toRestaurant();
	}
	
	public void showAllRest(ActionEvent event) throws Exception {
		RestaurantAdvisor.getInstance().toshowAllRest();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {}
}
