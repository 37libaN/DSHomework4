package finalProject.homepage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Screen;
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
			Rectangle2D primScreenBounds = Screen.getPrimary().getVisualBounds();
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
		// C:/Users/liban/Desktop/loginData.txt
		// User: 123hibob password: jshihi
		File loginFile = new File("C:/Users/vishn/Desktop/loginData.txt");
		Scanner inputFile = new Scanner(loginFile);
		while (inputFile.hasNextLine()) {
			LoginInfo currLogin = new LoginInfo();
			currLogin.setUsername(inputFile.nextLine());
			currLogin.setPassword(inputFile.nextLine());
			loginDatabase.add(currLogin);
		}
		inputFile.close();
		//System.out.println(getRestaurantInfo().toString());
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
	
	public void toMenu() throws Exception {
		replaceSceneContent("TasteofIndiaMenu.fxml");
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
			// primaryStage.sizeToScene();
			primaryStage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static RestaurantInfo getRestaurantInfo() throws FileNotFoundException {
		// C:/Users/vishn/Desktop/restaurantData.txt
		File loginFile = new File("C:/Users/vishn/Desktop/restaurantData.txt");
		Scanner inputFile = new Scanner(loginFile);
		String name = inputFile.nextLine();
		String address = inputFile.nextLine();
		String phoneNo = inputFile.nextLine();
		String email = inputFile.nextLine();
		String[] hours = new String[7];
		for (int i = 0; i < hours.length; i++) {
			hours[i] = inputFile.nextLine();
		}
		String cuisine = inputFile.nextLine();
		String diningType = inputFile.nextLine();
		String priceRange = inputFile.nextLine();
		String avgRating = inputFile.nextLine();
		inputFile.close();
		return new RestaurantInfo(name, address, phoneNo, email, cuisine, diningType, priceRange, null, hours,
				avgRating, null);
		
	}
}
