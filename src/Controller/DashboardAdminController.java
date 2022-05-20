package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Oraret;
import model.Studenti;
import processor.GjuhaProcessor;
import repository.CarryRepository;
import repository.OraretRepository;

public class DashboardAdminController implements Initializable{

	private ObservableList<Oraret> oblist = FXCollections.observableArrayList();
	private OraretRepository oraretRepository = new OraretRepository();
	private CarryRepository carryRepository = new CarryRepository();
	
	private Stage stage;
	private Scene scene;

	   @FXML
	    private Label lblEmri;
	   	
	  
	    @FXML
	    private TableView<Oraret> OrariTV;

	    @FXML
	    private TableColumn<Oraret, String> col_dita;

	    @FXML
	    private TableColumn<Oraret, String> col_kohaFillimit;

	    @FXML
	    private TableColumn<Oraret, String> col_lenda;

	    @FXML
	    private TableColumn<Oraret, String> col_profesori;

	    @FXML
	    private TableColumn<Oraret, String> col_salla;
	    
	    @FXML
	    private TableColumn<Oraret, String> col_grupi;
	    
	    @FXML
	    private TableColumn<Oraret, String> col_u_l;
	    
	    @FXML
	    private TableColumn<Oraret, String> col_drejtimi;
	    
	    @FXML
	    private TableColumn<Oraret, String> col_viti;
	    
		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			// TODO Auto-generated method stub
			
			try {
				  this.col_dita.setCellValueFactory(new PropertyValueFactory<>("dita"));
				  this.col_kohaFillimit.setCellValueFactory(new PropertyValueFactory<>("kohaFillimit"));
				  this.col_lenda.setCellValueFactory(new PropertyValueFactory<>("lenda"));
				  this.col_salla.setCellValueFactory(new PropertyValueFactory<>("salla"));
				  this.col_profesori.setCellValueFactory(new PropertyValueFactory<>("profesori"));
				  this.col_grupi.setCellValueFactory(new PropertyValueFactory<>("grupi"));
				  this.col_u_l.setCellValueFactory(new PropertyValueFactory<>("l_u"));
				  this.col_drejtimi.setCellValueFactory(new PropertyValueFactory<>("drejtimi"));		  
				  this.col_viti.setCellValueFactory(new PropertyValueFactory<>("viti"));		  
				  
				  
				  oblist = oraretRepository.getData();
				  
				  OrariTV.setItems(oblist);
				  
				  FilteredList<Oraret> filteredData = new FilteredList<>(oblist, b -> true);
				  
				  this.txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
					  filteredData.setPredicate(Oraret -> {
						  
						  if(newValue.isEmpty() || newValue.isBlank() || newValue == null) {
								return true;
							}
						  
						  String search = newValue.toLowerCase();
						  
						  if(Oraret.getL_u().toLowerCase().indexOf(search) > -1) {
							  return true;
						  }else if(Oraret.getDrejtimi().toLowerCase().indexOf(search) > -1) {
							  return true;
						  }else if(Oraret.getLenda().toLowerCase().indexOf(search) > -1) {
							  return true;
						  }else if(Oraret.getProfesori().toLowerCase().indexOf(search) > -1) {
							  return true;
						  }else if(Oraret.getViti().toLowerCase().indexOf(search) > -1) {
							  return true;
						  }else if(Oraret.getGrupi().toLowerCase().indexOf(search) > -1) {
							  return true;
						  }else if(Oraret.getSalla().toLowerCase().indexOf(search) > -1) {
							  return true;
						  }else if(Oraret.getDita().toLowerCase().indexOf(search) > -1) {
							  return true;
						  }else if(Oraret.getKohaFillimit().toLowerCase().indexOf(search) > -1) {
							  return true;
						  }
						  else
						  {
							  return false;
							  }
					  });
				  });
				  
				  SortedList<Oraret> sorted = new SortedList<>(filteredData);
				  
				  sorted.comparatorProperty().bind(this.OrariTV.comparatorProperty());
					this.OrariTV.setItems(sorted);
				  
			  }catch(SQLException e) {
				  e.printStackTrace();
			  }
			  
			
			
		}

    @FXML
    private TextField txtSearch;

    @FXML
    void Oraret(ActionEvent event) throws IOException, SQLException {
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/DashboardAdmin.fxml"),bundle);stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }


    @FXML
    void Profesoret(ActionEvent event) throws IOException, SQLException {
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/ProfAdmin.fxml"),bundle);stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void Gjuha(ActionEvent event) throws SQLException, IOException {
    	carryRepository.setIdGjuha();
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/DashboardAdmin.fxml"),bundle);stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void Shkyqu(ActionEvent event) throws IOException, SQLException {
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/log_in.fxml"),bundle);stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
    }

    @FXML
    void Studentet(ActionEvent event) throws IOException, SQLException {
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/StudentetAdmin.fxml"),bundle);stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

}