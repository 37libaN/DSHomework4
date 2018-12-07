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
	private Button logout;
	@FXML
	private Button cart;
	@FXML
	private Button viewMenu;
	@FXML
	private Button addReview;
	@FXML
	private Button nextReview;
	@FXML
	private Text review;
	@FXML
	private Text rating;
	@FXML
	private Text avgRating;
	private LLStackReview<Reviews> reviews;
	private LLStackReview<Reviews> reviews1;

	@Override
	public void initialize(URL location, ResourceBundle resources) {//set info and reviews at start
		try {
			restaurantInfo = RestaurantAdvisor.getInstance().getRestaurantInfo();// get selected restaurant
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// set all text fields to the restaurant's info
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
		reviews1 = new LLStackReview<Reviews>();
		int averageRating = 0;
		int totalElements = 0;
		try {
			getReviews1();
			totalElements = reviews1.getSize();
			while(!reviews1.isEmpty()) {
				averageRating+=reviews1.Top().getRating();
				reviews1.Pop();
			}
			if(totalElements!=0)
				averageRating = averageRating/totalElements;
			avgRating.setText(Integer.toString(averageRating));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		reviews = new LLStackReview<Reviews>();
		try {
			getReviews();
			if(!reviews.isEmpty()) {
				review.setText(reviews.Top().getReview());
				rating.setText(Integer.toString(reviews.Top().getRating()));
				reviews.Pop();
			}
				
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// System.out.print(restaurantInfo.toString());
	}

	public void logout(ActionEvent event) throws Exception {// go to login page
		RestaurantAdvisor.getInstance().toLogin();
	}

	public void cart(ActionEvent event) throws Exception {// go to cart page
		RestaurantAdvisor.getInstance().toshowAllRest();
	}

	public void menu(ActionEvent event) throws Exception {// go to menu page
		RestaurantAdvisor.getInstance().toMenu();
	}

	public void addReview(ActionEvent event) throws Exception {// go to add review page
		RestaurantAdvisor.getInstance().toAddReview();
	}

	public void getReviews() throws FileNotFoundException {//put reviews in stack
		SortedLinkedList<RestaurantReviews> allReviews = RestaurantAdvisor.getInstance().getAllReviews();
		if (allReviews.findReview(restaurantInfo.getName())) {
			reviews = allReviews.getFoundNode().getInfo().getReviews();
		}
	}
	
	public void getReviews1() throws FileNotFoundException {//put reviews in stack
		SortedLinkedList<RestaurantReviews> allReviews = RestaurantAdvisor.getInstance().getAllReviews();
		if (allReviews.findReview(restaurantInfo.getName())) {
			reviews1 = allReviews.getFoundNode().getInfo().getReviews();
		}
	}

	public void nextReview(ActionEvent event) throws Exception {//show the next review
		if(reviews.isEmpty())
			getReviews();
		if(!reviews.isEmpty()) {
			review.setText(reviews.Top().getReview());
			rating.setText(Integer.toString(reviews.Top().getRating()));
			reviews.Pop();
		}
	}
}
