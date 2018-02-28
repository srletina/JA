package ja.java8;

import java.util.Objects;
import java.util.function.Predicate;

public class PredicateTest {
	public static void main(String[] args) {
		Predicate<String> stringNotEmpty = s -> s.trim().length() > 0;
		System.out.println(stringNotEmpty.test("Milica"));

		Predicate<String> stringIsEmpty = String::isEmpty;

		//System.out.println("");
		System.out.println(stringIsEmpty.test(""));
		
		stringNotEmpty = stringIsEmpty.negate();
		System.out.println(stringNotEmpty.test("Milica"));
		
		Predicate<String> objNotNull = Objects::nonNull;
		
		String s = null;
		System.out.println(objNotNull.test(s));

		Predicate<String> objIsNull = Objects::isNull;

		s = "Mirko";
		System.out.println(objIsNull.test(s));
	}
}
