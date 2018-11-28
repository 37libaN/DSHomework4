package finalProject.homepage;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class RestaurantController implements Initializable {
	private RestaurantInfo restaurantInfo;
	@FXML
	private Text name;
	@FXML
	private Text address;
	@FXML
	private Text phoneNo;
	@FXML
	private Text email;
	@FXML
	private Text monday;
	@FXML
	private Text tuesday;
	@FXML
	private Text wednesday;
	@FXML
	private Text thursday;
	@FXML
	private Text friday;
	@FXML
	private Text saturday;
	@FXML
	private Text sunday;
	@FXML
	private Text cuisine;
	@FXML
	private Text diningType;
	@FXML
	private Text priceRange;
	@FXML
	private Text rating;
	@FXML
	private Button logout;
	@FXML
	private Button cart;
	@FXML
	private Button viewMenu;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			restaurantInfo = RestaurantAdvisor.getRestaurantInfo();//get selected restaurant
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//set all text fields to the restaurant's info
		name.setText(restaurantInfo.getName());
		address.setText(restaurantInfo.getAddress());
		phoneNo.setText(restaurantInfo.getPhoneNo());
		email.setText(restaurantInfo.getEmail());
		String[] hours = restaurantInfo.getHours();
		monday.setText(hours[0]);
		tuesday.setText(hours[1]);
		wednesday.setText(hours[2]);
		thursday.setText(hours[3]);
		friday.setText(hours[4]);
		saturday.setText(hours[5]);
		sunday.setText(hours[6]);
		cuisine.setText(restaurantInfo.getCuisine());
		diningType.setText(restaurantInfo.getDineType());
		priceRange.setText(restaurantInfo.getPriceRange());
		rating.setText(restaurantInfo.getAvgRating());
		//System.out.print(restaurantInfo.toString());
	}
	public void logout(ActionEvent event) throws Exception {//go to login page
		RestaurantAdvisor.getInstance().toLogin();
	}
	public void cart(ActionEvent event) throws Exception {//go to cart page
		RestaurantAdvisor.getInstance().toCart();
	}
	public void menu(ActionEvent event) throws Exception {//go to menu page
		RestaurantAdvisor.getInstance().toMenu();
	}
}
