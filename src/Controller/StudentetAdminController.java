package Controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class StudentetAdminController {

	private Stage stage;
	private Scene scene;
	

		@FXML
	    void Oraret(ActionEvent event) throws IOException {
	    	Parent root = FXMLLoader.load(getClass().getResource("/views/DashboardAdmin.fxml"));
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
	    }

		  @FXML
		    void Profesoret(ActionEvent event) throws IOException {
		    	Parent root = FXMLLoader.load(getClass().getResource("/views/ProfAdmin.fxml"));
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

		  @FXML
		    void Studentet(ActionEvent event) throws IOException {
		    	Parent root = FXMLLoader.load(getClass().getResource("/views/StudentetAdmin.fxml"));
				stage = (Stage)((Node)event.getSource()).getScene().getWindow();
				scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
		    }

}
