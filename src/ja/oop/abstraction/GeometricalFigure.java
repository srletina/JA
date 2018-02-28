package ja.oop.abstraction;


public abstract class GeometricalFigure{

	private String color;
	
	public GeometricalFigure(String color) {
		super();	// no need, because this is done implicitly
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public abstract double area();

	public abstract double perimeter();
}
