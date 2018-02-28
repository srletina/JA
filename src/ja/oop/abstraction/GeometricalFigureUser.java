package ja.oop.abstraction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;


public class GeometricalFigureUser {

	public static void main(String[] args) {
		List<GeometricalFigure> list = Arrays.asList(new Circle("red", 2.4), new Rectangle("blue", 2.7, 3.6), new Square("green", 2.2));
		System.out.println(list);
		System.out.println();

		System.out.println("normal:");
		for (GeometricalFigure gf : list) {
			System.out.println(gf.getClass());
			System.out.println(gf.area());
			System.out.println(gf);
		}
		System.out.println();

		System.out.println("List.forEach() with java.util.function.Consumer:");
		list.forEach(new Consumer<GeometricalFigure>() {
			@Override
			public void accept(GeometricalFigure gf) {
				System.out.println(gf.getClass());
				System.out.println(gf.area());
				System.out.println(gf.perimeter());
			}
		});
		System.out.println();

		System.out.println("List.forEach() with lambda:");
		list.forEach((gf)-> {
			System.out.println(gf.getClass());
			System.out.println(gf.area());
			System.out.println(gf.perimeter());
		});
	}
}
