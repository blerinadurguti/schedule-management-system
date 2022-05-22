package Controller;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import processor.CarryProcessor;
import processor.GjuhaProcessor;
import processor.Validations;
import repository.CarryRepository;
import repository.DitetRepository;
import repository.DrejtimiRepository;
import repository.GrupiRepository;
import repository.KohetRepository;
import repository.LendetRepository;
import repository.OraretRepository;
import repository.SallaRepository;
import repository.VitiAkademikRepository;

public class shtoLigjeratenController implements Initializable{

	private Validations v = new Validations();
	
	private Alert a = new Alert(AlertType.NONE);
	
	private CarryProcessor c;
	private DrejtimiRepository drejtimetRepository = new DrejtimiRepository();
	private VitiAkademikRepository vitiAkademik = new VitiAkademikRepository();
	private GrupiRepository grupiRepository = new GrupiRepository();
	private LendetRepository lendetRepository = new LendetRepository();
	private SallaRepository sallaRepository = new SallaRepository();
	private DitetRepository ditetRepository = new DitetRepository();
	private KohetRepository kohetRepository = new KohetRepository();
	private OraretRepository oraretRepository = new OraretRepository();
	
	private Stage stage;
	private Scene scene;
	
	private CarryRepository carryRepository = new CarryRepository();

    @FXML
    private Label lblEmri;
	
    

    @FXML
    private ChoiceBox<String> chbDita;

    @FXML
    private ChoiceBox<String> chbFillimi;    
    
    @FXML
    private ChoiceBox<String> chbGrupi;

    @FXML
    private ChoiceBox<String> chbL_U;
    private String[] LU = new String[] {"Ligjeratë" , "Ushtrime"};
    
    @FXML
    private ChoiceBox<String> chbLenda;

    @FXML
    private ChoiceBox<String> chbSalla;

    @FXML
    private ChoiceBox<String> chbdrejtimi;
    
    @FXML
    private ChoiceBox<String> chbViti;
    
    @Override
	public void initialize(URL arg0, ResourceBundle arg1) {
    	try {
			c = new CarryProcessor();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    	c.SetShtoLigjeraten(lblEmri);
    	
    	
    	try {
			this.chbdrejtimi.getItems().addAll(drejtimetRepository.getDrejtimet());
			this.chbViti.getItems().addAll(vitiAkademik.getVitet());
			this.chbGrupi.getItems().addAll(grupiRepository.getGrupi());
			this.chbLenda.getItems().addAll(lendetRepository.getLendet());
			this.chbL_U.getItems().addAll(this.LU);
			this.chbSalla.getItems().addAll(sallaRepository.getSallat());
			this.chbDita.getItems().addAll(ditetRepository.getDitet());
			this.chbFillimi.getItems().addAll(kohetRepository.getKohet());			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
	}
    
    @FXML
    void Ballina(ActionEvent event) throws IOException, SQLException {
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/Dashboard.fxml"),bundle);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void Orari(ActionEvent event) throws IOException, SQLException {
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/Orari.fxml"),bundle);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void Profili(ActionEvent event) throws IOException, SQLException {
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/Profili.fxml"),bundle);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void Shkyqu(ActionEvent event) throws IOException, SQLException {
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/log_in.fxml"),bundle);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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
	void ShtoLigjeraten(ActionEvent event) throws IOException, SQLException {
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/shtoLigjeraten.fxml"),bundle);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

    
    @FXML
    void shtoLigjeratenbtn(ActionEvent event) throws SQLException {

    	if(checknull()) {
    		
    		if(oraretRepository.checkOrariTaken(chbdrejtimi, chbViti, chbGrupi, chbSalla, chbDita, chbFillimi)) {
    			
    			oraretRepository.insertOrari(chbdrejtimi, chbViti, chbGrupi, chbLenda, chbL_U, chbSalla, chbDita, chbFillimi);
    			
    			this.a.setAlertType(AlertType.CONFIRMATION);
    			this.a.setContentText("Ligjerata u shtua!");
    			this.a.show();
    		}else {
    			this.a.setAlertType(AlertType.CONFIRMATION);
    			this.a.setContentText("Orar i zene!");
    			this.a.show();
    		}
    		
    	}else{
    		this.a.setAlertType(AlertType.CONFIRMATION);
			this.a.setContentText("All choice boxes not selected!");
			this.a.show();
    	}
    	
    }
    
    
    
    private boolean checknull() {
    	boolean a = this.v.NullChoiceBox(this.chbDita);
    	boolean b = this.v.NullChoiceBox(this.chbdrejtimi);
    	boolean c = this.v.NullChoiceBox(this.chbFillimi);
    	boolean d = this.v.NullChoiceBox(this.chbGrupi);
    	boolean e = this.v.NullChoiceBox(this.chbL_U);
    	boolean f = this.v.NullChoiceBox(this.chbLenda);
    	boolean g = this.v.NullChoiceBox(this.chbSalla);
    	boolean h = this.v.NullChoiceBox(this.chbViti);
    	
    	if(a || b || c || d || e || f || g || h) {
    		return false;
    	}else {
    		return true;
    	}
    }
    
}
