package finalProject.homepage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable {
	@FXML
	private Button login;
	@FXML
	private TextField username;
	@FXML
	private PasswordField password;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	public void login(ActionEvent event) throws IOException {// send main app login info to try to go to homepage
		RestaurantAdvisor.getInstance().loginUser(username.getText(), password.getText());
	}
}
