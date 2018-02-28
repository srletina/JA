package ja.java8;

import java.util.function.Supplier;

public class SuppliersTest {
	public static void main(String[] args) {
		Supplier<Student> supp = Student::new;
		System.out.println(supp.get());
	}
}
