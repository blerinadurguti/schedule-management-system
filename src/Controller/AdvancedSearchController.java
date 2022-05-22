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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Oraret;
import processor.CarryProcessor;
import processor.GjuhaProcessor;
import repository.CarryRepository;
import repository.DitetRepository;
import repository.DrejtimiRepository;
import repository.GrupiRepository;
import repository.KohetRepository;
import repository.LendetRepository;
import repository.OraretRepository;
import repository.SallaRepository;
import repository.StafiAkademikRepository;
import repository.VitiAkademikRepository;

@SuppressWarnings("unused")
public class AdvancedSearchController implements Initializable{

	private Stage stage;
	private Scene scene;
	
	private CarryProcessor c;
	private DrejtimiRepository drejtimetRepository = new DrejtimiRepository();
	private VitiAkademikRepository vitiAkademik = new VitiAkademikRepository();
	private GrupiRepository grupiRepository = new GrupiRepository();
	private LendetRepository lendetRepository = new LendetRepository();
	private SallaRepository sallaRepository = new SallaRepository();
	private DitetRepository ditetRepository = new DitetRepository();
	private KohetRepository kohetRepository = new KohetRepository();
	private OraretRepository oraretRepository = new OraretRepository();
	private StafiAkademikRepository stafiAkademikRepository = new StafiAkademikRepository();
	
	   @FXML
	    private ChoiceBox<String> chbL_u;
	   private String[] LU = new String[] {"LigjeratÃ«" , "Ushtrime"};
	   
	    @FXML
	    private ChoiceBox<String> chbdita;
	    
	    @FXML
	    private ChoiceBox<String> chbdrejtimi;

	    @FXML
	    private ChoiceBox<String> chbgrupi;

	    @FXML
	    private ChoiceBox<String> chbkoha;

	    @FXML
	    private ChoiceBox<String> chblenda;

	    @FXML
	    private ChoiceBox<String> chbporfesori;

	    @FXML
	    private ChoiceBox<String> chbsalla;

	    @FXML
	    private ChoiceBox<String> chbviti;
	
    @FXML
    private Label lblEmri;    
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
	
    	try {
			c = new CarryProcessor();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	c.SetDashboardStafi(lblEmri);
    	
    	try {
    		this.chbL_u.setValue("");
    		this.chbdrejtimi.setValue("");
    		this.chbviti.setValue("");
    		this.chbgrupi.setValue("");
    		this.chbsalla.setValue("");
    		this.chbdita.setValue("");
    		this.chbkoha.setValue("");
    		this.chblenda.setValue("");
    		this.chbporfesori.setValue(""); 	
    		
    		this.chbL_u.getItems().addAll(this.LU);
    		this.chbdrejtimi.getItems().addAll(drejtimetRepository.getDrejtimet());
    		this.chbviti.getItems().addAll(vitiAkademik.getVitet());
    		this.chbgrupi.getItems().addAll(grupiRepository.getGrupi());
    		this.chbsalla.getItems().addAll(sallaRepository.getSallat());
    		this.chbdita.getItems().addAll(ditetRepository.getDitet());
    		this.chbkoha.getItems().addAll(kohetRepository.getKohet());
    		this.chblenda.getItems().addAll(lendetRepository.getAllLendet());
    		this.chbporfesori.getItems().addAll(stafiAkademikRepository.getProfa());   		
    	    		
    	}catch(SQLException e) {
    		e.printStackTrace();
    	}
		    	
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

    @FXML
    void go(ActionEvent event) throws SQLException, IOException {
    		
    	oraretRepository.getFilteredData(chbdita.getValue(), chbdrejtimi.getValue(), chbgrupi.getValue(),
    			chbkoha.getValue(), chblenda.getValue(), chbporfesori.getValue(), chbsalla.getValue(), chbviti.getValue(),chbL_u.getValue());
    	
    	GjuhaProcessor g = new GjuhaProcessor();
    			Locale locale = new Locale(g.setGjuha());
    			ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
    			Parent root = FXMLLoader.load(getClass().getResource("/views/AdvancedSearchRes.fxml"),bundle);	stage = (Stage)((Node)event.getSource()).getScene().getWindow();
    				scene = new Scene(root);
    				stage.setScene(scene);
    				stage.show();
    }
    
}
