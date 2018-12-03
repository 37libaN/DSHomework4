package finalProject.homepage;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CreateAccountController {
	@FXML
	private Button back;
	@FXML
	private Button create;
	@FXML
	private TextField username;
	@FXML
	private TextField password;
	@FXML
	private Button logout;
	
	public void create(ActionEvent event) throws Exception {//add account and go to home page
		Writer.addAccount(username.getText(), password.getText());
		RestaurantAdvisor.getInstance().toHome();
	}
	public void back(ActionEvent event) throws Exception {//go to login page
		RestaurantAdvisor.getInstance().toLogin();
	}
	
}
