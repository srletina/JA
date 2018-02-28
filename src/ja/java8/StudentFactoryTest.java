package ja.java8;

public class StudentFactoryTest {

	public static void main(String[] args) {
		StudentFactory<Student> factory = Student::new;
		
		Student s = factory.create("milica", "krmpotic");
		System.out.println(s);
	}
}
