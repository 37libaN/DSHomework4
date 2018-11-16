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
	   public void login(ActionEvent event, Stage primaryStage) throws IOException {
		   BinSearchTreeLogin<LoginInfo> loginDatabase = new BinSearchTreeLogin<LoginInfo>();
		   File loginFile = new File("C:/Users/liban/Desktop/Nabil/Comp Sci/EclipseWorkspace/DSHomework4/src/FinalProject/homepage/loginData.txt");
		   Scanner inputFile = new Scanner(loginFile);
		   while(inputFile.hasNextLine()) {
			   LoginInfo currLogin = new LoginInfo();
			   currLogin.setUsername(inputFile.nextLine());
			   currLogin.setPassword(inputFile.nextLine());
			   loginDatabase.add(currLogin);
		   }
		   LoginInfo toCheck = new LoginInfo(username.toString(), password.toString());
		   if(loginDatabase.contains(toCheck)) {
			   Parent root = FXMLLoader.load(getClass().getResource("Home.fxml"));
	           primaryStage.setTitle("Login");
	           primaryStage.setScene(new Scene(root));
	           primaryStage.show();
		   }
	   }
}
