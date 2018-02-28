package ja.books.persistence;

public class RepoFactory {
	public IRepository getRepository(String name) {

		switch(name) {
		case "JDBC":
			return new JDBCRepository();
		case "HIBERNATE":
			return new HibernateRepository();
		}
		return new StaticRepository();
	}
}
