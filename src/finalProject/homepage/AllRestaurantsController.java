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
	private LLQueue<String> thirdNames;
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
			thirdNames = new LLQueue<String>();
			int count = 0;
			for (count = count; count < allRestaurants.size() && count < VBOXOBJECTS; count++) {
				firstNames.enqueue(allRestaurants.getNode().getInfo().getName());
				allRestaurants.step();
			}
			for (count = count; count < allRestaurants.size() && count < (VBOXOBJECTS * 2); count++) {
				secondNames.enqueue(allRestaurants.getNode().getInfo().getName());
				allRestaurants.step();
			}
			for (count = count; count < allRestaurants.size() && count < (VBOXOBJECTS * 3); count++) {
				thirdNames.enqueue(allRestaurants.getNode().getInfo().getName());
				allRestaurants.step();
			}
			contain = new VBox();
			button1.setText(firstNames.dequeue());
			button2.setText(firstNames.dequeue());
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
	public void toRestaurants(String name) throws Exception {
		if(allRestaurants.find(name)) {
			Writer.writeRestaurant(allRestaurants.getFoundNode().getInfo());
			RestaurantAdvisor.getInstance().toRestaurant();
		}
	}
}
