package ja.java8;

public interface StudentFactory<S extends Student> {
	S create(String name, String surname);
}
