package finalProject.homepage;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class RestaurantMenuController implements Initializable {
	private ArrayList<String> menu;
	@FXML
	private Button logout;
	@FXML
	private TextArea menuText;
	@FXML
	private TextField name;
	private String menuStr;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			RestaurantInfo restaurant = RestaurantAdvisor.getInstance().getRestaurantInfo();
			name.setText(restaurant.getName());
			menu = restaurant.getMenu();
			menuStr = "";
			for (int i = 0; i < menu.size(); i++) {
				menuStr = menuStr + menu.get(i) + "\n";
			}
			menuText.setText(menuStr);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void logout(ActionEvent event) throws Exception {// go to login page
		RestaurantAdvisor.getInstance().toLogin();
	}

}
