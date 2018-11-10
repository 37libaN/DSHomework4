package finalProject;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
 
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
public class HelloWorldController implements Initializable{
	 @FXML
	   private Button myButton;
    
       public void printHW(ActionEvent event) {
    	  
    	             System.out.println("Hello World!");
    	       
       }
	  
	   @FXML
	   private TextField myTextField;
	  
	   @Override
	   public void initialize(URL location, ResourceBundle resources) {
	 
	       // TODO (don't really need to do anything here).
	      
	   }
}
