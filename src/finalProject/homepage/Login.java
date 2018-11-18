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

public class Login extends Application {
	public static Login instance;
	private Stage stage;
	
	public Login() {
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

	private void toLogin() throws Exception {
            replaceSceneContent("Login.fxml");
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

	private void toHome() throws Exception {
		replaceSceneContent("Home.fxml");
	}

	private void replaceSceneContent(String fxmlFile) throws Exception {
		Parent page = FXMLLoader.load(getClass().getResource(fxmlFile));
        stage.setScene(new Scene(page));
    }
}
