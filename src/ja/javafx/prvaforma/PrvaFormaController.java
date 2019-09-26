package ja.javafx.prvaforma;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.TextField;

public class PrvaFormaController {
	
	@FXML
	Canvas canvas;
	@FXML
	TextField synopsis;
	
	@FXML
	public void fuckOff(ActionEvent event) {
		synopsis.setText("Fuck Off?");
	}
	
	@FXML
	public void fuckOn(ActionEvent event) {
		synopsis.setText("Fuck On!");
	}
	
}
