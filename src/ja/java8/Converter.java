package ja.java8;

@FunctionalInterface
public interface Converter<T, F> {
	T convert (F from);

}
