package ja.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsTest {

	public static void main(String[] args) {
		double sum = 0;
			int predznak = 1;
			for(int n=0;;n++) {
			 sum += predznak * 4 / (2*n+1);
					 System.out.println(sum);
					 predznak*=-1;
			}
	
	}		
}
	/*
	{	
		
		List<String> list = Arrays.asList("Pero", "Lujo", "Maso", "Skrbo", "Pegla");

		list.stream()
		.sorted()
		.filter(s -> s.startsWith("P"))
		.map(StringReverser::reverse)
		.forEach(System.out::println);
		System.out.println();

		boolean b = Stream.of("Pero", "Lujo", "Maso", "Skrbo", "Pegla")
				//.anyMatch(s->s.startsWith("P"));
				//.allMatch(String::isEmpty);
				.noneMatch(s->s.length()>0);
		System.out.println(b);
		System.out.println();
		System.out.println();

		long count = IntStream.range(1, 100)
				.filter(i->i%2==0)
				.count();
		System.out.println("parnih do 100: " + count);
		System.out.println();

		IntStream.range(1, 10).reduce((x, y) -> x+y).ifPresent(System.out::print);
	}
}
*/