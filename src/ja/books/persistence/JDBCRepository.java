package ja.books.persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import ja.books.managers.JDBCManager;
import ja.books.model.Book;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class JDBCRepository implements IRepository {

	private static final String SELECT_STMT = "select IDBook, Isbn, Title, Author from BOOK";

	//@Override
	public ObservableList<Book> getBooks() {
		List<Book> list = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			con = JDBCManager.getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(SELECT_STMT);
			while(rs.next()) {
				list.add(new Book(
						rs.getInt("IDBook"),
						rs.getString("Isbn"),
						rs.getString("Title"),
						rs.getString("Author")
						)
				);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				JDBCManager.clean(con, stmt, rs);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return FXCollections.observableArrayList(list);
	}

	@Override
	public void setBooks(ObservableList<Book> books) {
		// TODO Auto-generated method stub
		
	}
}
