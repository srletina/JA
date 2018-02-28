package ja.books.books;

import ja.books.model.Book;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class BookDetailsController {
	@FXML
	TextField tfIsbn;
	@FXML
	TextField tfTitle;
	@FXML
	TextField tfAuthor;
	private Book book;
	public void initData(Book book) {
		this.book = book;
		tfIsbn.setText(this.book.getIsbn());
		tfTitle.setText(this.book.getTitle());
		tfAuthor.setText(this.book.getAuthor());
	}
}

