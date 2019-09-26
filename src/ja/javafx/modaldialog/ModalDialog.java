package ja.javafx.modaldialog;

import javafx.application.Application;
import javafx.beans.value.*;
import javafx.concurrent.Worker;
import javafx.event.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.*;

// otvori web stranicu u dijalogu i za svaki pomak na drugu stranicu napravi modalni dijalog

public class ModalDialog extends Application {

	@SuppressWarnings("deprecation")
	@Override
	public void start(Stage primaryStage) {

		// initialize the stage
		primaryStage.setTitle("Modal Confirm Example");
		final WebView webView = new WebView();
		webView.getEngine().load("http://docs.oracle.com/javafx/");
		primaryStage.setScene(new Scene(webView));
		primaryStage.show();

		// initialize the confirmation dialog
		final Stage dialog = new Stage(StageStyle.TRANSPARENT);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setScene(new Scene(HBoxBuilder.create().styleClass("modal-dialog").children(
				LabelBuilder.create().text("Will you like this page?").build(),
				ButtonBuilder.create().text("Yes").defaultButton(true).onAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						// take action and close the dialog.
						System.out.println("Liked: " + webView.getEngine().getTitle());
						primaryStage.getScene().getRoot().setEffect(null);
						dialog.close();
					}
				}).build(),
				ButtonBuilder.create().text("No").cancelButton(true).onAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent actionEvent) {
						// abort action and close the dialog.
						System.out.println("Disliked: " + webView.getEngine().getTitle());
						primaryStage.getScene().getRoot().setEffect(null);
						dialog.close();
					}
				}).build()).build(), Color.TRANSPARENT));
		dialog.getScene().getStylesheets().add(getClass().getResource("modal-dialog.css").toExternalForm());

		// allow the dialog to be dragged around.
		final Node root = dialog.getScene().getRoot();
		final Delta dragDelta = new Delta();
		root.setOnMousePressed(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				// record a delta distance for the drag and drop operation.
				dragDelta.x = dialog.getX() - mouseEvent.getScreenX();
				dragDelta.y = dialog.getY() - mouseEvent.getScreenY();
			}
		});
		root.setOnMouseDragged(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				dialog.setX(mouseEvent.getScreenX() + dragDelta.x);
				dialog.setY(mouseEvent.getScreenY() + dragDelta.y);
			}
		});

		// show the confirmation dialog each time a new page is loaded.
		webView.getEngine().getLoadWorker().stateProperty().addListener(new ChangeListener<Worker.State>() {
			@Override
			public void changed(ObservableValue<? extends Worker.State> observableValue, Worker.State state,
					Worker.State newState) {
				if (newState.equals(Worker.State.SUCCEEDED)) {
					primaryStage.getScene().getRoot().setEffect(new BoxBlur());
					dialog.show();
				}
			}
		});
	}

	// records relative x and y co-ordinates.
	class Delta {
		double x, y;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
