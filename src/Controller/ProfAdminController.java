package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.StafiAkademik;
import repository.StafiAkademikRepository;

public class ProfAdminController implements Initializable{

	private Stage stage;
	private Scene scene;
	
	private StafiAkademikRepository stafiAkademikRepository = new StafiAkademikRepository();
	
	private ObservableList<StafiAkademik> oblist = FXCollections.observableArrayList();
	
	 @FXML
	    private TableView<StafiAkademik> ProfesoretTV;

	    @FXML
	    private TableColumn<StafiAkademik, String> col_emri;

	    @FXML
	    private TableColumn<StafiAkademik, String> col_id;

	    @FXML
	    private TableColumn<StafiAkademik, String> col_mbiemri;

	    @FXML
	    private TableColumn<StafiAkademik, String> col_pozita;
	
	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
		
	    	col_id.setCellValueFactory(new PropertyValueFactory<>("Id"));
	    	col_emri.setCellValueFactory(new PropertyValueFactory<>("Emri"));
	    	col_mbiemri.setCellValueFactory(new PropertyValueFactory<>("Mbiemri"));
	    	col_pozita.setCellValueFactory(new PropertyValueFactory<>("Pozita"));
	    	
	    	try {
				oblist = stafiAkademikRepository.getData();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			};
	    	
			ProfesoretTV.setItems(oblist);
	    }

	    
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
