package ja.books.persistence;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import ja.books.managers.HibernateManager;
import ja.books.model.Book;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class HibernateRepository implements IRepository {
	@SuppressWarnings("unchecked")
	@Override
	public ObservableList<Book> getBooks() {
		List<Book> list = new ArrayList<>();
		try (Session session = HibernateManager.getSession()){
			Criteria criteria = session.createCriteria(Book.class);
			list = criteria.list();
			//HibernateManager.cleanup();
		} catch (HibernateException e) {
			e.printStackTrace();
		}
		return FXCollections.observableArrayList(list);
	}

	@Override
	public void setBooks(ObservableList<Book> books) {
		// TODO Auto-generated method stub
		
	}
}
