package ja.javafx.canvasResize;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;

public class MyResizeController implements Initializable {

	Scene scene;
	GraphicsContext gc;
	double width, height;

	@FXML AnchorPane myCanvasAP;
	@FXML Canvas myCanvas;

	public void drawAbout() {
		gc.clearRect(0, 0, myCanvas.getWidth(), myCanvas.getHeight());

		gc.setStroke(Color.RED);
		gc.strokeLine(0, 0, myCanvas.getWidth(), myCanvas.getHeight());
		gc.strokeLine(0, myCanvas.getHeight(), myCanvas.getWidth(), 0);

		System.out.println("Draw About finished! " + myCanvas.getWidth() + " x " + myCanvas.getHeight());
	}

	public void hello() {
		System.out.println("Hello!");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		gc = myCanvas.getGraphicsContext2D();

		myCanvasAP.prefWidthProperty().addListener((ov, oldValue, newValue) -> {
			myCanvas.setWidth(newValue.doubleValue());
			drawAbout();
		});

		myCanvasAP.prefHeightProperty().addListener((ov, oldValue, newValue) -> {
			myCanvas.setHeight(newValue.doubleValue());
			drawAbout();
		});
	}

	public void setScene(Scene scene) {
		this.scene = scene;
	}
}
