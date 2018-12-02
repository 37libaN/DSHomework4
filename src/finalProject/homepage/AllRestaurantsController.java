package finalProject.homepage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class AllRestaurantsController implements Initializable {
	@FXML
	VBox contain;
	@FXML
	private Button logout;
	@FXML
	private Button cart;
	private LLQueue<String> firstNames;
	private LLQueue<String> secondNames;
	@FXML
	private Button button1;
	@FXML
	private Button button2;
	@FXML
	private Button button3;
	@FXML
	private Button button4;
	@FXML
	private Button button5;
	@FXML
	private Button button6;
	@FXML
	private Button button7;
	@FXML
	private Button button8;
	@FXML
	private Button button9;
	@FXML
	private Button button10;
	// @FXML
	// private Button[] buttons;
	private final int VBOXOBJECTS = 5;
	private SortedLinkedList<RestaurantInfo> allRestaurants;

	public void initialize(URL location, ResourceBundle resources) {
		try {
			allRestaurants = RestaurantAdvisor.getInstance().getAllRestaurants();
			allRestaurants.reset();
			firstNames = new LLQueue<String>();
			secondNames = new LLQueue<String>();
			int count = 0;
			for (count = count; count < allRestaurants.size() && count < VBOXOBJECTS; count++) {
				firstNames.enqueue(allRestaurants.getNode().getInfo().getName());
				allRestaurants.step();
			}
			for (count = count; count < allRestaurants.size() && count < (VBOXOBJECTS * 2); count++) {
				secondNames.enqueue(allRestaurants.getNode().getInfo().getName());
				allRestaurants.step();
			}
			if(!firstNames.isEmpty())
				button1.setText(firstNames.dequeue());
			if(!firstNames.isEmpty())
				button2.setText(firstNames.dequeue());
			if(!firstNames.isEmpty())
				button3.setText(firstNames.dequeue());
			if(!firstNames.isEmpty())
				button4.setText(firstNames.dequeue());
			if(!firstNames.isEmpty())
				button5.setText(firstNames.dequeue());
			if(!secondNames.isEmpty())
				button6.setText(secondNames.dequeue());
			if(!secondNames.isEmpty())
				button7.setText(secondNames.dequeue());
			if(!secondNames.isEmpty())
				button8.setText(secondNames.dequeue());
			if(!secondNames.isEmpty())
				button9.setText(secondNames.dequeue());
			if(!secondNames.isEmpty())
				button10.setText(secondNames.dequeue());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	public void toRestOne(ActionEvent event) throws Exception {
		toRestaurants(button1.getText());
	}
	public void toRestTwo(ActionEvent event) throws Exception {
		toRestaurants(button2.getText());
	}
	public void toRestThree(ActionEvent event) throws Exception {
		toRestaurants(button3.getText());
	}
	public void toRestFour(ActionEvent event) throws Exception {
		toRestaurants(button4.getText());
	}
	public void toRestFive(ActionEvent event) throws Exception {
		toRestaurants(button5.getText());
	}
	public void toRestSix(ActionEvent event) throws Exception {
		toRestaurants(button6.getText());
	}
	public void toRestSeven(ActionEvent event) throws Exception {
		toRestaurants(button7.getText());
	}
	public void toRestEight(ActionEvent event) throws Exception {
		toRestaurants(button8.getText());
	}
	public void toRestNine(ActionEvent event) throws Exception {
		toRestaurants(button9.getText());
	}
	public void toRestTen(ActionEvent event) throws Exception {
		toRestaurants(button10.getText());
	}
	public void toRestaurants(String name) throws Exception {
		if(allRestaurants.findRestaurant(name)) {
			Writer.writeRestaurant(allRestaurants.getFoundNode().getInfo());
			RestaurantAdvisor.getInstance().toRestaurant();
		}
	}
	public void logout(ActionEvent event) throws Exception {//go to login page
		RestaurantAdvisor.getInstance().toLogin();
	}
	public void cart(ActionEvent event) throws Exception {//go to cart page
		RestaurantAdvisor.getInstance().toHome();
	}
}
