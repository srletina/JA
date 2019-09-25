package ja.javafx;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ButtonJavaFX8Lambda extends Application {

	Button btn = new Button();
	Button btn2 = new Button();
	Button btn3 = new Button();
	static TextField txt = new TextField();
	static Text txt2 = new Text();

	public void test(ActionEvent e) {
		System.out.println("Hello World method references!");
		txt.setText("Hello World method references!");
	}

	public static void testStatic(ActionEvent e) {
		System.out.println("Hello World static method references!");
		txt.setText("Hello World static method references!");
	}

	@Override
	public void start(Stage primaryStage) {

		btn.setText("Say 'Hello World Lambda!'");
		btn2.setText("Say 'Hello World method references!'");
		btn3.setText("Say 'Hello World static method references!'");

		// Java 8 Lambda
		// btn.setOnAction(e -> System.out.println("Hello World Lambda"));
		btn.setOnAction((e) -> {
			System.out.println("Hello World Lambda!");
			txt.setText("Hello World Lambda!");
			txt2.setText("Hello World Lambda!");
		});
		// Java 8 method references
		btn2.setOnAction(this::test);
		// Java 8 static method references
		btn3.setOnAction(ButtonJavaFX8Lambda::testStatic);

		VBox root = new VBox();
		root.setSpacing(10);
		root.setPadding(new Insets(50, 30, 50, 30));
		root.getChildren().add(btn);
		root.getChildren().add(btn2);
		root.getChildren().add(btn3);
		root.getChildren().add(txt);
		root.getChildren().add(txt2);
		

		Scene scene = new Scene(root, 400, 250);

		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}