package ja.books.model;

public class Book {
	private int idBook;
	private String isbn;
	private String title;
	private String author;

	// hibernate zahtijeva defaultni konstruktor i sve gettere i settere
	public Book() {}

	public Book(int idBook, String isbn, String title, String author) {
		//super();
		this.idBook = idBook;
		this.isbn = isbn;
		this.title = title;
		this.author = author;
	}

	// getteri i setteri automatski generirani
	//
	public int getIdBook() { return idBook; }

	public void setIdBook(int idBook) {
		this.idBook = idBook;
	}

	public String getIsbn() { return isbn; }

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getTitle() { return title; }

	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() { return author; }

	public void setAuthor(String author) {
		this.author = author;
	}
}
