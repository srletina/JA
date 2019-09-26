package ja.javafx.canvasResize;

import java.io.IOException;

import ja.javafx.canvasResize.CanvasResizeable;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ResizeMain2 extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {
		CanvasResizeable canvasResizeable= new CanvasResizeable();

		final AnchorPane root = new AnchorPane();
		root.getChildren().add(canvasResizeable);

		canvasResizeable.widthProperty().bind(root.widthProperty());
		canvasResizeable.heightProperty().bind(root.heightProperty());

		primaryStage.setScene(new Scene(root));
		primaryStage.show();

		/*
		final FXMLLoader loader = new FXMLLoader(getClass().getResource("myResize.fxml"));
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
		 */
	}
}
