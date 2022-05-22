package Controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Locale;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import processor.GjuhaProcessor;

public class smoAboutController {

    private Stage stage;
    private Scene scene;

    @FXML
    private Pane pane;

    @FXML
    void back(ActionEvent event) throws IOException, SQLException {
        GjuhaProcessor g = new GjuhaProcessor();
        Locale locale = new Locale(g.setGjuha());
        ResourceBundle bundle = ResourceBundle.getBundle("resources.gjuha",locale);
        Parent root = FXMLLoader.load(getClass().getResource("/views/DashboardStudenti.fxml"),bundle);
            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
    }

}
