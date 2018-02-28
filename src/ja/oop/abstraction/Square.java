package ja.oop.abstraction;

public class Square extends Rectangle{

	public Square(String color, double a) {
		super(color, a, a);
	}

	@Override
public void setA(double a) {
	super.setA(a);
	setB(a);
}

	@Override
public void setB(double b) {
	super.setB(b);
	setA(b);
}
}
