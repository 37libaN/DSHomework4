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
	//@FXML
	//private TextField rating;
	@FXML
	private Button one;
	@FXML
	private Button two;
	@FXML
	private Button three;
	@FXML
	private Button four;
	@FXML
	private Button five;
	private int rating;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		rating = 0;
	}
	public void logout(ActionEvent event) throws Exception {//go to login page
		RestaurantAdvisor.getInstance().toLogin();
	}
	public void one() {
		rating = 1;
	}
	public void two() {
		rating = 2;
	}
	public void three() {
		rating = 3;
	}
	public void four() {
		rating = 4;
	}
	public void five() {
		rating = 5;
	}
	public void addReview(ActionEvent event) throws Exception {//add a review and go back to allrestaurants
		Writer.writeReview(review.getText(), rating);
		RestaurantAdvisor.getInstance().toRestaurant();
	}
	public void back(ActionEvent event) throws Exception {//go to login page
		RestaurantAdvisor.getInstance().toRestaurant();
	}

}
