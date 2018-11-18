package finalProject.homepage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class RestaurantAdvisor extends Application {
	public static RestaurantAdvisor instance;
	private Stage stage;
	
	public RestaurantAdvisor() {
		instance = this;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			primaryStage.setTitle("Login");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public void toLogin() throws Exception {
            replaceSceneContent("Login.fxml");
	}

	public static void main(String[] args) {
		launch(args);
	}
	public static RestaurantAdvisor getInstance() {
		return instance;
	}
	public void loginUser(String username, String password) throws FileNotFoundException {
		BinSearchTreeLogin<LoginInfo> loginDatabase = new BinSearchTreeLogin<LoginInfo>();
		File loginFile = new File("C:/Users/vishn/Desktop/loginData.txt");
		Scanner inputFile = new Scanner(loginFile);
		while (inputFile.hasNextLine()) {
			LoginInfo currLogin = new LoginInfo();
			currLogin.setUsername(inputFile.nextLine());
			currLogin.setPassword(inputFile.nextLine());
			loginDatabase.add(currLogin);
		}
		LoginInfo toCheck = new LoginInfo(username, password);
		if (loginDatabase.contains(toCheck)) {
			try {
				toHome();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void toHome() throws Exception {
		replaceSceneContent("Home.fxml");
	}
	
	public void toCart() throws Exception {
		replaceSceneContent("Cart.fxml");
	}
	public void tovrTOI() throws Exception {
		replaceSceneContent("TasteofIndia.fxml");
	}
	public void tovrMias() throws Exception {
		replaceSceneContent("TasteofIndia.fxml");
	}
	public void tovrPanda() throws Exception {
		replaceSceneContent("TasteofIndia.fxml");
	}
	public void toshowAllRest() throws Exception {
		replaceSceneContent("AllRestaurants.fxml");
	}

	public void replaceSceneContent(String fxmlFile) throws Exception {
		Stage primaryStage = new Stage();
		try {
			Parent root = FXMLLoader.load(getClass().getResource(fxmlFile));
			primaryStage.setScene(new Scene(root));
			primaryStage.sizeToScene();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
