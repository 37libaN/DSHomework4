package finalProject.homepage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

public class ReviewsController implements Initializable{
	@FXML
	private Button logout;
	@FXML
	private Button back;
	@FXML
	private Button cart;
	@FXML
	private Button addReview;
	@FXML
	private TextArea review;
	@FXML
	private TextField rating;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	public void logout(ActionEvent event) throws Exception {//go to login page
		RestaurantAdvisor.getInstance().toLogin();
	}
	public void addReview(ActionEvent event) throws Exception {
		Writer.writeReview(review.getText(), rating.getText());
		RestaurantAdvisor.getInstance().toRestaurant();
	}
	public void back(ActionEvent event) throws Exception {//go to login page
		RestaurantAdvisor.getInstance().toRestaurant();
	}

}
