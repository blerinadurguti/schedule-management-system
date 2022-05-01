package java_06;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class LoginViewController {

	@FXML
	private TextField txtEmri;
	@FXML
	private TextField txtMbiemri;
	@FXML
	private void confirmEventHandler(ActionEvent e) {
		System.out.print(this.txtEmri.getText()+ " ");
		System.out.println(this.txtMbiemri.getText());
	}
	@FXML
	private void ClearEventHandler(ActionEvent e) {
	System.out.println("Clear");	
	}
}
