package ja.java8;

public class ConverterTest {

	public static void main(String[] args) {
		Converter<Integer,String> c = from -> Integer.valueOf(from);
		
		c = Integer::valueOf;
		System.out.println(c.convert("123"));
		
		
		Converter<String, String> ss_c = from -> StringReverser.reverse(from);
		
		ss_c = StringReverser::reverse;
		System.out.println(ss_c.convert("milica"));
	}
}
