package ja.books.persistence;

import ja.books.model.Book;
import javafx.collections.ObservableList;

public interface IRepository {
	// sa promjenama baze/liste radi se automatski update
	ObservableList<Book> getBooks();
	void setBooks(ObservableList<Book> books);
}
