package ja.java8;

import java.util.Optional;

public class OptionalTest {

	public static void main(String[] args) {
		//Optional<Integer> opt = getInteger("123");
		Optional<Integer> opt = getInteger("milica");
		System.out.println(opt);
		
		if (opt.isPresent()) {
			System.out.println(opt.get());
		}
		
		opt.ifPresent(System.out::println);
		
		int num = opt.orElse(-1);
		System.out.println(num);
	}

	
	private static Optional<Integer> getInteger(String s) {
		Converter<Integer, String> c = Integer::valueOf;
		
		try {
			//return Integer.valueOf(s);
			return Optional.of(c.convert(s));
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return Optional.empty();
	}
}
