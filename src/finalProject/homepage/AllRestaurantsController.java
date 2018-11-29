package finalProject.homepage;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class AllRestaurantsController implements Initializable{
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
	//@FXML 
	//private Button[] buttons; 
	private final int VBOXOBJECTS = 5; 
 
	public void initialize(URL location, ResourceBundle resources) {
		try {
			SortedLinkedList<RestaurantInfo> allRestaurants = RestaurantAdvisor.getInstance().getAllRestaurants(); 
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
	
}
