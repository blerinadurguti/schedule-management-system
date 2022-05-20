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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Oraret;
import processor.CarryProcessor;
import repository.OraretRepository;

public class DashboardStudentiController implements Initializable{
	private ObservableList<Oraret> oblist = FXCollections.observableArrayList();
	private OraretRepository oraretRepository = new OraretRepository();
	private CarryProcessor c;
	private Stage stage;
	private Scene scene;
	
    @FXML
    private Label lblStudenti;
	
	 @FXML
	    private ChoiceBox<String> ChBoxLang;
	    private String[] Gjuha = {"Shqip","Anglisht"};

	    @FXML
	    private TableView<Oraret> OrariTV;

	    @FXML
	    private TableColumn<Oraret, String> col_dita;

	    @FXML
	    private TableColumn<Oraret, String> col_kohaFillimit;

	    @FXML
	    private TableColumn<Oraret, String> col_kohaMbarimit;

	    @FXML
	    private TableColumn<Oraret, String> col_lenda;

	    @FXML
	    private TableColumn<Oraret, String> col_profesori;

	    @FXML
	    private TableColumn<Oraret, String> col_salla;
	    
	    @FXML
	    private TableColumn<Oraret, String> col_grupi;
	    
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			this.ChBoxLang.setValue("Shqip");
			ChBoxLang.getItems().addAll(this.Gjuha);
			
			this.col_dita.setCellValueFactory(new PropertyValueFactory<>("dita"));
			  this.col_kohaFillimit.setCellValueFactory(new PropertyValueFactory<>("kohaFillimit"));
			  this.col_kohaMbarimit.setCellValueFactory(new PropertyValueFactory<>("kohaMbarimit"));
			  this.col_lenda.setCellValueFactory(new PropertyValueFactory<>("lenda"));
			  this.col_salla.setCellValueFactory(new PropertyValueFactory<>("salla"));
			  this.col_grupi.setCellValueFactory(new PropertyValueFactory<>("grupi"));
			  this.col_profesori.setCellValueFactory(new PropertyValueFactory<>("profesori"));
			
			  try {
				  oblist = oraretRepository.getData();
			  }catch(SQLException e) {
				  e.printStackTrace();
			  }
			  
			  OrariTV.setItems(oblist);
			  
			try {
				c = new CarryProcessor();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
				c.SetDashboardStudenti(lblStudenti);
		}

    @FXML
    private TextField txtSearch;

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
    void Search(ActionEvent event) {

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