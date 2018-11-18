package finalProject.homepage;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

public class TasteofIndiaController implements Initializable {
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
			restaurantInfo = RestaurantAdvisor.getRestaurantInfo();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		name.setText(restaurantInfo.getName());
		address.setText(restaurantInfo.getName());
		phoneNo.setText(restaurantInfo.getName());
		email.setText(restaurantInfo.getName());
		monday.setText(restaurantInfo.getName());
		tuesday.setText(restaurantInfo.getName());
		wednesday.setText(restaurantInfo.getName());
		thursday.setText(restaurantInfo.getName());
		friday.setText(restaurantInfo.getName());
		saturday.setText(restaurantInfo.getName());
		sunday.setText(restaurantInfo.getName());
		cuisine.setText(restaurantInfo.getName());
		diningType.setText(restaurantInfo.getName());
		priceRange.setText(restaurantInfo.getName());
		rating.setText(restaurantInfo.getName());
	}
	
}
