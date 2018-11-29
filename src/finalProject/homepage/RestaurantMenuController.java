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

public class RestaurantMenuController implements Initializable{
	private ArrayList<String> menu;
	@FXML
	private Button logout;
	@FXML
	private TextArea menuText;
	private String menuStr;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			menu = RestaurantAdvisor.getInstance().getRestaurantInfo().getMenu();
			for(int i = 0; i < menu.size(); i++) {
				menuStr = menuStr+menu.get(i);
				menuText.setText(menuStr);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public void logout(ActionEvent event) throws Exception {//go to login page
		RestaurantAdvisor.getInstance().toLogin();
	}
	
}
