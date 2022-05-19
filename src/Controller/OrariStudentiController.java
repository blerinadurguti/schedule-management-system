package Controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class OrariStudentiController {

	private Stage stage;
	private Scene scene;
	
	 @FXML
	    void Ballina(ActionEvent event) throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("/views/DashboardStudenti.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	    }

	  @FXML
	    void Orari(ActionEvent event) throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("/views/OrariStudenti.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	    }

	  @FXML
	    void Profili(ActionEvent event) throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("/views/ProfiliStudenti.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	    }

	  @FXML
	    void Shkyqu(ActionEvent event) throws IOException {
	    	  Parent root = FXMLLoader.load(getClass().getResource("/views/log_in.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
	    }

}
