package ja.oop.abstraction;

public class Rectangle extends GeometricalFigure {

	private double a, b;

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public Rectangle(String color, double a, double b) {
		super(color);
		this.a = a;
		this.b = b;
	}

	//@Override
	public double area() {
		return a * b;
	}

	//@Override
	public double perimeter() {
		return 2 * (a + b);
	}
}
