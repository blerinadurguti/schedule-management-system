package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Locale;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.filtered;
import processor.CarryProcessor;
import processor.GjuhaProcessor;
import repository.filteredRepository;

public class AdvancedSearchResController implements Initializable{

	private CarryProcessor c;
	private filteredRepository FilteredRepository = new filteredRepository();
	
	private Stage stage;
	private Scene scene;
	
	
    @FXML
    private TableView<filtered> SearchTV;

    @FXML
    private TableColumn<filtered, String> col_dita;

    @FXML
    private TableColumn<filtered, String> col_drejtimi;

    @FXML
    private TableColumn<filtered, String> col_grupi;

    @FXML
    private TableColumn<filtered, String> col_kohaFillimit;

    @FXML
    private TableColumn<filtered, String> col_l_u;

    @FXML
    private TableColumn<filtered, String> col_lenda;

    @FXML
    private TableColumn<filtered, String> col_profesori;

    @FXML
    private TableColumn<filtered, String> col_salla;

    @FXML
    private TableColumn<filtered, String> col_viti;

    @FXML
    private Label lblEmri;

    private ObservableList<filtered> oblist = FXCollections.observableArrayList();
    
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		try {
			c = new CarryProcessor();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		c.SetDashboardStafi(lblEmri);
		
		this.col_l_u.setCellValueFactory(new PropertyValueFactory<>("l_u"));
		this.col_drejtimi.setCellValueFactory(new PropertyValueFactory<>("drejtimi"));
		this.col_viti.setCellValueFactory(new PropertyValueFactory<>("viti"));
		this.col_grupi.setCellValueFactory(new PropertyValueFactory<>("grupi"));
		this.col_salla.setCellValueFactory(new PropertyValueFactory<>("salla"));
		this.col_dita.setCellValueFactory(new PropertyValueFactory<>("dita"));
		this.col_kohaFillimit.setCellValueFactory(new PropertyValueFactory<>("KohaFillimit"));
		this.col_lenda.setCellValueFactory(new PropertyValueFactory<>("lenda"));
		this.col_profesori.setCellValueFactory(new PropertyValueFactory<>("profesori"));
		
		try {
			oblist = FilteredRepository.getData();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		
//if(oraretRepository.getFilteredData(chbdita, chbdrejtimi, chbgrupi, chbkoha, chblenda, chbporfesori, chbsalla, chbviti).size() > -1) {
//	oblist = oraretRepository.getFilteredData(chbdita, chbdrejtimi, chbgrupi, chbkoha, chblenda, chbporfesori, chbsalla, chbviti);    			
//}else {
//	oblist = oraretRepository.getData();
//}
//
this.SearchTV.setItems(oblist);
		
	}
    
    
    @FXML
    void Ballina(ActionEvent event) throws IOException, SQLException {
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/Dashboard.fxml"),bundle);	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
    }

    @FXML
    void Orari(ActionEvent event) throws IOException, SQLException {
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/Orari.fxml"),bundle);	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
    }

    @FXML
    void Profili(ActionEvent event) throws IOException, SQLException {
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/Profili.fxml"),bundle);	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
    }

    @FXML
    void Shkyqu(ActionEvent event) throws SQLException, IOException {
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/log_in.fxml"),bundle);	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
    }

    @FXML
    void ShtoLigjeraten(ActionEvent event) throws SQLException, IOException {
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/shtoLigjeraten.fxml"),bundle);	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
    }

    @FXML
    void search(ActionEvent event) throws SQLException, IOException {
	 GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/AdvancedSearch.fxml"),bundle);	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
    }



}
