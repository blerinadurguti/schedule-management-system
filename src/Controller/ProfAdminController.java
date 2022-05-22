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
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.StafiAkademik;
import processor.GjuhaProcessor;
import processor.Validations;
import repository.StafiAkademikRepository;

public class ProfAdminController implements Initializable{

	private Stage stage;
	private Scene scene;
	
	private StafiAkademikRepository stafiAkademikRepository = new StafiAkademikRepository();
	private Validations v = new Validations();
	private ObservableList<StafiAkademik> oblist = FXCollections.observableArrayList();
	private Alert a = new Alert(AlertType.NONE);
	
	@FXML
    private ChoiceBox<String> chbRole;
	
    @FXML
    private TextField txtEmri;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtMbiemri;
	
	
	
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
		
	    	try {
				this.chbRole.getItems().addAll(stafiAkademikRepository.findAllPozitat());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
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
    void Oraret(ActionEvent event) throws IOException, SQLException {
		GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/DashboardAdmin.fxml"),bundle);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

	 @FXML
	    void Profesoret(ActionEvent event) throws IOException, SQLException {
		 GjuhaProcessor g = new GjuhaProcessor();
			Locale locale = new Locale(g.setGjuha());
			ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
			Parent root = FXMLLoader.load(getClass().getResource("/views/ProfAdmin.fxml"),bundle);
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
    void Studentet(ActionEvent event) throws IOException, SQLException {
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/StudentetAdmin.fxml"),bundle);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }


    @FXML
    void add(ActionEvent event) throws SQLException, IOException {
    	String emri = this.txtEmri.getText();
    	String mbiemri = this.txtMbiemri.getText();
    	String role = this.chbRole.getValue();
    	
    	if(v.NullTextFields(txtEmri) || v.NullTextFields(txtMbiemri)|| v.NullChoiceBox(chbRole)) {
    		this.a.setAlertType(AlertType.CONFIRMATION);
			this.a.setContentText("All fields must be filled!");
			this.a.show();
    	}else {
    		stafiAkademikRepository.addProfesori(emri, mbiemri, role);
    		 GjuhaProcessor g = new GjuhaProcessor();
 			Locale locale = new Locale(g.setGjuha());
 			ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
 			Parent root = FXMLLoader.load(getClass().getResource("/views/ProfAdmin.fxml"),bundle);
 			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
 			scene = new Scene(root);
 			stage.setScene(scene);
 			stage.show();
    	}
    	
    }

    @FXML
    void update(ActionEvent event) throws IOException, SQLException {
    	String id = this.txtId.getText();
    	String emri = this.txtEmri.getText();
    	String mbiemri = this.txtMbiemri.getText();
    	String role = this.chbRole.getValue();
    	
    	if(v.NullTextFields(txtEmri)||v.NullTextFields(txtMbiemri)||v.NullTextFields(txtId)||v.NullChoiceBox(chbRole)) {
    		this.a.setAlertType(AlertType.CONFIRMATION);
			this.a.setContentText("All fields must be filled!");
			this.a.show();
    	}else {
    		stafiAkademikRepository.updateProfesori(id, emri, mbiemri, role);
   		 GjuhaProcessor g = new GjuhaProcessor();
			Locale locale = new Locale(g.setGjuha());
			ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
			Parent root = FXMLLoader.load(getClass().getResource("/views/ProfAdmin.fxml"),bundle);
			stage = (Stage)((Node)event.getSource()).getScene().getWindow();
			scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
    	}
    	
    }
    
}
