package ja.javafx.prvaforma;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class PrvaForma extends Application {

	@Override
	public void start(Stage primaryStage) {
		//primaryStage.setMinWidth(800);
		//primaryStage.setMinHeight(600);
		//primaryStage.setFullScreen(true);

		try {
			//final FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("views/prvaForma.fxml"));
			final FXMLLoader loader = new FXMLLoader(getClass().getResource("prvaForma.fxml"));
			//final FXMLLoader loader = new FXMLLoader(getClass().getResource("test.fxml"));
			final Parent root = loader.load();
			final Scene scene = new Scene(root); // new Scene(root, 250, 150);
			//mainDialog.initModality(Modality.WINDOW_MODAL);
			// stage.initModality(Modality.APPLICATION_MODAL);
			// stage.initStyle(StageStyle.UNDECORATED);
			// stage.initOwner(emailField.getScene().getWindow());
			primaryStage.setScene(scene);
			//primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root, 400, 400);
			scene.getStylesheets().add(getClass().getResource("prvaforma.css").toExternalForm());
			//primaryStage.initModality(Modality.NONE);
			//primaryStage.setScene(scene);
			//primaryStage.show();
			Stage modalDialog = new Stage();
			modalDialog.initModality(Modality.WINDOW_MODAL);
			modalDialog.initOwner(primaryStage);
			modalDialog.setScene(scene);
			modalDialog.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
