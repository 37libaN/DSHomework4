package finalProject.homepage;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application {
	public static Login instance;
	
	public Login() {
		instance = this;
	}
	
	@Override
	public void start(Stage primaryStage) {
		try {
			// Read file fxml and draw interface.
			Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
			primaryStage.setTitle("Login");
			primaryStage.setScene(new Scene(root));
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
	public static Login getInstance() {
		return instance;
	}
	public void loginUser(String username, String password) throws FileNotFoundException {
		System.out.println("hi");
		BinSearchTreeLogin<LoginInfo> loginDatabase = new BinSearchTreeLogin<LoginInfo>();
		File loginFile = new File(
				"C:/Users/liban/Desktop/Nabil/Comp Sci/EclipseWorkspace/DSHomework4/src/FinalProject/homepage/loginData.txt");
		Scanner inputFile = new Scanner(loginFile);
		while (inputFile.hasNextLine()) {
			LoginInfo currLogin = new LoginInfo();
			currLogin.setUsername(inputFile.nextLine());
			currLogin.setPassword(inputFile.nextLine());
			loginDatabase.add(currLogin);
		}
		LoginInfo toCheck = new LoginInfo(username, password);
		if (loginDatabase.contains(toCheck)) {
			replaceSceneContent("Home.fxml");
		}
	}

	private void replaceSceneContent(String string) {
		// TODO Auto-generated method stub

	}
}
