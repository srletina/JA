package ja.java8;

public class StringReverser {
	public static String reverse(String s) {
		return new StringBuilder(s).reverse().toString();
	}

}
