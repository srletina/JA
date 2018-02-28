package ja.java8;

import java.util.function.Consumer;

public class ConsumerTest {
	public static void main(String[] args) {
		Consumer<Student> welcome = s -> System.out.println("Hi " + s);
		StudentFactory<Student> factory = Student::new;
		
		Student s = factory.create("daniel", "bele");
		welcome.accept(s);
		
	}
}
