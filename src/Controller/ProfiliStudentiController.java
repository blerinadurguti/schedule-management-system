package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import processor.CarryProcessor;

public class ProfiliStudentiController implements Initializable{

	private CarryProcessor c;
	
	private Stage stage;
	private Scene scene;
	
	@FXML
	private Label lblMainEmri;

    @FXML
    private Label lblEmri;

    @FXML
    private Label lblMbiemri;

    @FXML
    private Label lblStudentId;

    @FXML
    private Label lblViti;

    @FXML
    private Label lbldrejtimi;

    @FXML
    private Label lblgrupi;

    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		try {
			c = new CarryProcessor();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			c.SetProfiliStudent(lblMainEmri, lblEmri, lblMbiemri, lblStudentId, lbldrejtimi, lblViti, lblgrupi);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    
    @FXML
    void Ballina(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/views/DashboardStudenti.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void NdryshoFjalkalimin(ActionEvent event) throws IOException {
    	Parent root = FXMLLoader.load(getClass().getResource("/views/NdryshoFjalkaliminStudenti.fxml"));
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