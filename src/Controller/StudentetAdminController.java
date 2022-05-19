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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.SqlViewStudentet;
import repository.SqlViewStudentetRepository;

public class StudentetAdminController implements Initializable{

	private SqlViewStudentetRepository sqlViewStudentetRepository = new SqlViewStudentetRepository();
	
	private ObservableList<SqlViewStudentet> oblist = FXCollections.observableArrayList();
	
	private Stage stage;
	private Scene scene;
	
	  @FXML
	    private TableView<SqlViewStudentet> StudentetTV;

	    @FXML
	    private TableColumn<SqlViewStudentet, String> col_drejtimi;

	    @FXML
	    private TableColumn<SqlViewStudentet, String> col_emri;

	    @FXML
	    private TableColumn<SqlViewStudentet, String> col_grupi;

	    @FXML
	    private TableColumn<SqlViewStudentet, String> col_mbiemri;

	    @FXML
	    private TableColumn<SqlViewStudentet, String> col_nengrupi;

	    @FXML
	    private TableColumn<SqlViewStudentet, String> col_studentId;

	    @FXML
	    private TableColumn<SqlViewStudentet, String> col_viti;

	    @Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			
	    	col_emri.setCellValueFactory(new PropertyValueFactory<>("Emri"));
	    	col_mbiemri.setCellValueFactory(new PropertyValueFactory<>("Mbiemri"));
	    	col_studentId.setCellValueFactory(new PropertyValueFactory<>("StudentId"));
	    	col_drejtimi.setCellValueFactory(new PropertyValueFactory<>("Drejtimi"));
	    	col_viti.setCellValueFactory(new PropertyValueFactory<>("Viti"));
	    	col_grupi.setCellValueFactory(new PropertyValueFactory<>("Grupi"));
	    	col_nengrupi.setCellValueFactory(new PropertyValueFactory<>("Nengrupi"));
	    	
	    	try {
	    		oblist = sqlViewStudentetRepository.getData();
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	};
	    	
	    	StudentetTV.setItems(oblist);
	    	
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
