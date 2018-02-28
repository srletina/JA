package ja.oop.inheritance;

public class SportsCar extends Car {
	private boolean roofWindow;

	public SportsCar(int number, String type, String color, boolean roofWindow) {
		super(number, type, color);
		this.roofWindow = roofWindow;
	}

	public boolean isRoofWindow() {
		return roofWindow;
	}

	public void setRoofWindow(boolean roofWindow) {
		this.roofWindow = roofWindow;
	}

	public void drift() {
		System.out.println("Sports car drifts");
	}

	@Override
	public void drive() {
		//super.drive();
		System.out.println("Sports car drives");
	}
	
	@Override
	public void stop() {
		System.out.println("Sports car stops");
	}
	
	@Override
	public String toString() {
		return super.toString() + " Sportscar[roof window:" + roofWindow+"]";
	}
}
