package ja.java8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@SuppressWarnings("unused")
public class LambdaTest {

	public static void main(String[] args) {
		List<String> list = Arrays.asList("Pero", "Mirko", "murko", "daniel", "Darko");
		
//		Collections.sort(list, new Comparator<String>() {
//			@Override
//			public int compare(String a, String b) {
//				return a.compareToIgnoreCase(b);
//			}
//		});
		
//		Collections.sort(list, (a, b) -> {
//			return a.compareToIgnoreCase(b);
//		});

		//Collections.sort(list, (a, b) -> a.compareToIgnoreCase(b));

		// default void	sort(Comparator<? super E> c)
		//list.sort((prvi, drugi) -> prvi.compareToIgnoreCase(drugi));
		list.sort((a, b) -> a.compareToIgnoreCase(b));
		//System.out.println();

		// https://docs.oracle.com/javase/8/docs/api/java/lang/Iterable.html#forEach-java.util.function.Consumer-
		// default void forEach(Consumer<? super T> action)
		list.forEach(t -> System.out.println(t));
		//System.out.println();
	}
}
