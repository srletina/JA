package ja.books.books;

import java.io.IOException;

import ja.books.model.Book;
import ja.books.persistence.RepoFactory;
import com.sun.javafx.scene.control.skin.TableColumnHeader;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class BooksController {

//	private static final String REPO_NAME = "STATIC";
//	private static final String REPO_NAME = "JDBC";
	private static final String REPO_NAME = "HIBERNATE";
	@FXML
	TableColumn<Book, String> tcIsbn;
	@FXML
	TableColumn<Book, String> tcTitle;
	@FXML
	TableColumn<Book, String> tcAuthor;
	@FXML
	TableView<Book> tblBooks;

	@FXML
	public void showBooks(ActionEvent event) {
		tcIsbn.setCellValueFactory(new PropertyValueFactory<Book, String>("isbn"));
		tcTitle.setCellValueFactory(new PropertyValueFactory<Book, String>("title"));
		tcAuthor.setCellValueFactory(new PropertyValueFactory<Book, String>("author"));
		tblBooks.setItems(new RepoFactory().getRepository(REPO_NAME).getBooks());
	}

	@FXML
	public void showDetails(MouseEvent event) {
		if (event.getTarget() instanceof TableColumnHeader) { return; }
		Book book = tblBooks.getSelectionModel().getSelectedItem();
		FXMLLoader loader = new FXMLLoader(getClass().getResource("BookDetails.fxml"));
		try {
			Parent parent = loader.load();
			BookDetailsController controller = loader.getController();
			controller.initData(book);
			Stage stage = new Stage();
			stage.setTitle("Book details");
			stage.setScene(new Scene(parent));
			stage.show();
		} catch (IOException e) { e.printStackTrace(); }
	}

}
