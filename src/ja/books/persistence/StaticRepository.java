package ja.books.persistence;

import ja.books.model.Book;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class StaticRepository implements IRepository {

	// klikneš ime konstruktora iz interfacea i on izgenerira prototipe moetoda

	@Override
	public ObservableList<Book> getBooks() {

		return FXCollections.observableArrayList(
				new Book(1, "ISBN-123", "Ponedjeljak", "Daniel Bele"),
				new Book(1, "ISBN-312", "Prazina", "Daniel Bele"),
				new Book(1, "ISBN-734", "Fijasko", "Imre Kertesz"));
	}

	@Override
	public void setBooks(ObservableList<Book> books) {
		// TODO Auto-generated method stub
		
	}
}
