package finalProject.homepage;

import java.io.FileNotFoundException;
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
		try {
			LLStackReview allRestaurants = RestaurantAdvisor.getInstance().getAllRestaurants();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
