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
import model.SqlViewStudentet;
import processor.GjuhaProcessor;
import processor.Validations;
import repository.DrejtimiRepository;
import repository.GrupiRepository;
import repository.SqlViewStudentetRepository;
import repository.StudentRepository;
import repository.VitiAkademikRepository;

public class StudentetAdminController implements Initializable{

	private SqlViewStudentetRepository sqlViewStudentetRepository = new SqlViewStudentetRepository();
	
	private ObservableList<SqlViewStudentet> oblist = FXCollections.observableArrayList();
	
	private Stage stage;
	private Scene scene;
	private StudentRepository studentRepository = new StudentRepository();
	private DrejtimiRepository drejtimetRepository = new DrejtimiRepository();
	private GrupiRepository grupiRepository = new GrupiRepository();
	private VitiAkademikRepository vitiAkademik = new VitiAkademikRepository();
	private Validations v = new Validations();
	private Alert a = new Alert(AlertType.NONE);
	
	  @FXML
	    private ChoiceBox<String> chbDrejtimi;

	    @FXML
	    private ChoiceBox<String> chbGrupi;
	    
	    @FXML
	    private ChoiceBox<String> chbviti;
	
	    @FXML
	    private TextField txtStudentId;
	
	
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
			
	    	try {    		
				this.chbDrejtimi.getItems().addAll(drejtimetRepository.getDrejtimet());
				this.chbGrupi.getItems().addAll(grupiRepository.getGrupi());
				this.chbviti.getItems().addAll(vitiAkademik.getVitet());
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	    	
	    	
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
		    void remove(ActionEvent event) throws SQLException, IOException {
			   String id = this.txtStudentId.getText();
			   studentRepository.RemoveBySId(id);

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
		    void update(ActionEvent event) throws SQLException, IOException {

		    	String StudentId = this.txtStudentId.getText();
		    	String drejtimi = this.chbDrejtimi.getValue();
		    	String grupi = this.chbGrupi.getValue();
		    	String viti = this.chbviti.getValue();
		    	
		    	if(v.NullChoiceBox(chbDrejtimi) || v.NullChoiceBox(chbGrupi) || v.NullChoiceBox(chbviti) || v.NullTextFields(txtStudentId)) {
		    		this.a.setAlertType(AlertType.CONFIRMATION);
	    			this.a.setContentText("All fields must be filled!");
	    			this.a.show();
		    	}else {
		    		studentRepository.UpdateBySId(StudentId, drejtimi, grupi, viti);
		    		GjuhaProcessor g = new GjuhaProcessor();
					Locale locale = new Locale(g.setGjuha());
					ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
					Parent root = FXMLLoader.load(getClass().getResource("/views/StudentetAdmin.fxml"),bundle);
					stage = (Stage)((Node)event.getSource()).getScene().getWindow();
					scene = new Scene(root);
					stage.setScene(scene);
					stage.show();
		    	}
		    	
		    }
}
