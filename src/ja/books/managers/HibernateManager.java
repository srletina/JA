package ja.books.managers;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateManager {
	private static Configuration configuration;
	private static SessionFactory sessionFactory;

	private static void init() {
		configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
	}

	public static Session getSession() {
		if (sessionFactory == null) {
			init();
		}
		return sessionFactory.openSession();
	}

	public static void cleanup(){
		if (sessionFactory!=null) {
			try {
				sessionFactory.close();
			} catch (HibernateException e) {
				e.printStackTrace();
			}
		}
	}
}
