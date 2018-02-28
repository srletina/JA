package ja.java8;

@FunctionalInterface
public interface IMathOperation {
	double operation(double a, double  b);
	
	static void printMessage(String message) {
		System.out.print(message);
	}
	
//	default void print() {
//	}

//	@Override
//	default String toString();
}
