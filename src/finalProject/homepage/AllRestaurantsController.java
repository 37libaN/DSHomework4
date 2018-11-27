package finalProject.homepage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

public class AllRestaurantsController implements Initializable{
	@FXML
	VBox contain;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		LLStackReview allRestaurants = RestaurantAdvisor.getInstance().getAllRestaurants();
	}
	
}
