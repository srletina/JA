package ja.oop.abstraction;

public class Circle extends GeometricalFigure{

	private double r;
	public Circle(String color, double r) {
		super(color);
		this.r = r;
	}

	@Override
	public double area() {
		return Math.pow(r, 2) * Math.PI;
	}

	@Override
	public double perimeter() {
		return 2 * r * Math.PI;
	}
}
