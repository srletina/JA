package ja.java8;

import java.util.function.Function;

public class FunctionsTest {
	public static void main(String[] args) {
		Function<String, Integer> toInteger = Integer::valueOf;
		
		Function<String, String> backToString = toInteger.andThen(String::valueOf);

		Function<String, String> reverser = backToString.andThen(StringReverser::reverse);
		
		System.out.println(reverser.apply("123"));
	}
}
