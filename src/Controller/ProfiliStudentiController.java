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
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import processor.CarryProcessor;
import processor.GjuhaProcessor;
import repository.CarryRepository;

public class ProfiliStudentiController implements Initializable{

	private CarryProcessor c;
	private CarryRepository carryRepository = new CarryRepository();
	
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
    
    @FXML
    private PieChart piechart;

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
		
		ObservableList<PieChart.Data> pieData;
		try {
			pieData = FXCollections.observableArrayList(
					new PieChart.Data("E hënë", carryRepository.getNrLigj("E hëne")),
					new PieChart.Data("E martë", carryRepository.getNrLigj("E marte")),
					new PieChart.Data("E mërkurë", carryRepository.getNrLigj("E mërkure")),
					new PieChart.Data("E enjtë", carryRepository.getNrLigj("E enjëte")),
					new PieChart.Data("E premtë", carryRepository.getNrLigj("E premte")),
					new PieChart.Data("E shtunë", carryRepository.getNrLigj("E shtune"))
					);
		
			piechart.setData(pieData);
			piechart.setTitle("Ligjerata/Dite");
			
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
		Parent root = FXMLLoader.load(getClass().getResource("/views/DashboardStudenti.fxml"),bundle);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void NdryshoFjalkalimin(ActionEvent event) throws IOException, SQLException {
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/NdryshoFjalkaliminStudenti.fxml"),bundle);stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }

    @FXML
    void Orari(ActionEvent event) throws IOException, SQLException {
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/OrariStudenti.fxml"),bundle);stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
    }


    @FXML
    void Profili(ActionEvent event) throws IOException, SQLException {
    	GjuhaProcessor g = new GjuhaProcessor();
		Locale locale = new Locale(g.setGjuha());
		ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
		Parent root = FXMLLoader.load(getClass().getResource("/views/ProfiliStudenti.fxml"),bundle);stage = (Stage)((Node)event.getSource()).getScene().getWindow();
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


}
