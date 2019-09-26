package ja.javafx.canvasResize;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ResizeMain extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		MyResizeController bok = new MyResizeController();
		bok.hello();

		final FXMLLoader loader = new FXMLLoader(getClass().getResource("myResize.fxml"));
		bok.hello();
		final AnchorPane root = loader.load();
		final Scene scene = new Scene(root); // new Scene(root, 250, 150);
		//mainDialog.initModality(Modality.WINDOW_MODAL);
		// stage.initModality(Modality.APPLICATION_MODAL);
		// stage.initStyle(StageStyle.UNDECORATED);
		// stage.initOwner(emailField.getScene().getWindow());
		primaryStage.setScene(scene);
		//primaryStage.setResizable(false);
		primaryStage.show();


		MyResizeController controller = loader.getController();
		controller.setScene(scene);

		root.prefWidthProperty().bind(scene.widthProperty());
		root.prefHeightProperty().bind(scene.heightProperty());

		//		primaryStage.maximizedProperty().addListener((observable, oldValue, newValue) ->
		//		{	controller.setScene(scene);
		//		if (oldValue != newValue) controller.drawAbout();
		//		System.out.println("maximized:" + newValue.booleanValue());
		//		});
		//		primaryStage.widthProperty().addListener((observable, oldValue, newValue) ->
		//		{	if (oldValue != newValue) controller.drawAbout();
		//		});
		//		primaryStage.heightProperty().addListener((observable, oldValue, newValue) ->
		//		{	if (oldValue != newValue) controller.drawAbout();
		//		});

	}
}
