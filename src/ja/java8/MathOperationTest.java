package ja.java8;

import java.util.ArrayList;
import java.util.List;

public class MathOperationTest {

	public static void main(String[] args) {
		IMathOperation add = new IMathOperation() {
			
			@Override
			public double operation(double a, double b) {
				IMathOperation.printMessage(a + " + " + b + " = ");
				return a + b;
			}
		};
		
		IMathOperation divide = (a, b) -> {
			if (b == 0) {
				throw new IllegalArgumentException();
			}
				
			IMathOperation.printMessage(a + " / " + b + " = ");
			return a / b;

		};
		
		List<IMathOperation> list = new ArrayList<>();
		list.add(add);
		list.add(divide);
		list.add(new IMathOperation() {
			
			@Override
			public double operation(double a, double b) {
				IMathOperation.printMessage(a + " - " + b + " = ");
				return a - b;
			}
		});
		list.add((a, b) -> {
			IMathOperation.printMessage(a + " * " + b + " = ");
			return a * b;
			
		});
		
		list.forEach(t -> System.out.println(t.operation(1, 2)));
		//System.out.println(divide.operation(1, 0));
	}

}
