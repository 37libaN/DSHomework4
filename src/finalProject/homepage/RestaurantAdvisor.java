package finalProject.homepage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
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
	public void start(Stage primaryStage) {//set up for login page
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

	public void toLogin() throws Exception {//go to login page
		replaceSceneContent("Login.fxml");
	}

	public static void main(String[] args) {
		launch(args);
	}

	public static RestaurantAdvisor getInstance() {//return this object for controllers' use
		return instance;
	}

	public void loginUser(String username, String password) throws FileNotFoundException {//used by login controller to test login data
		BinSearchTreeLogin<LoginInfo> loginDatabase = new BinSearchTreeLogin<LoginInfo>();
		// C:/Users/liban/Desktop/loginData.txt
		// User: 123hibob password: jshihi
		File loginFile = new File("C:/Users/liban/Desktop/loginData.txt");
		Scanner inputFile = new Scanner(loginFile);
		while (inputFile.hasNextLine()) {
			LoginInfo currLogin = new LoginInfo();
			currLogin.setUsername(inputFile.nextLine());
			currLogin.setPassword(inputFile.nextLine());
			loginDatabase.add(currLogin);
		}
		inputFile.close();
		// System.out.println(getRestaurantInfo().toString());
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

	public void toHome() throws Exception {//go to home page
		replaceSceneContent("Home.fxml");
	}

	public void toCart() throws Exception {//go to cart page
		replaceSceneContent("Cart.fxml");
	}

	public void toMenu() throws Exception {//go to menu page for a restaurant
		replaceSceneContent("TasteofIndiaMenu.fxml");
	}

	public void toRestaurant() throws Exception {//go to restaurant page
		replaceSceneContent("TasteofIndia.fxml");
	}

	public void toshowAllRest() throws Exception {//go to allRestaurants page
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
		File loginFile = new File("C:/Users/liban/Desktop/singleRestaurantData.txt");
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
		ArrayList<String> restMenu = new ArrayList<String>();
		inputFile.nextLine();
		String nextString = inputFile.nextLine();
		while (!nextString.equals("-")) {
			restMenu.add(nextString);
			nextString = inputFile.nextLine();
		}
		inputFile.close();
		return new RestaurantInfo(name, address, phoneNo, email, cuisine, diningType, priceRange, null, hours,
				avgRating, restMenu);
	}
	
	public SortedLinkedList<RestaurantInfo> getAllRestaurants() throws FileNotFoundException {//returns all restaurants
		SortedLinkedList<RestaurantInfo> allRestaurants = new SortedLinkedList<RestaurantInfo>(); 
		File loginFile = new File("C:/Users/liban/Desktop/restaurantData.txt"); 
		Scanner inputFile = new Scanner(loginFile);
		while (inputFile.hasNextLine()) {//go through file for restaurant data
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
			ArrayList<String> restMenu = new ArrayList<String>();
			inputFile.nextLine();
			String nextString = inputFile.nextLine();
			while (!nextString.equals("-")) {
				restMenu.add(nextString);
				nextString = inputFile.nextLine();
			}
			RestaurantInfo restaurant = new RestaurantInfo(name, address, phoneNo, email, cuisine, diningType,
					priceRange, null, hours, avgRating, restMenu);
			allRestaurants.add(restaurant);
			inputFile.nextLine();
		}
		inputFile.close();
		return allRestaurants;
	}
}
