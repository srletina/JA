package ja.oop.inheritance;

public class Car {
	private int number;
	private String type;
	private String color;

	public Car(int number, String type, String color) {
		//super();
		this.number = number;
		this.type = type;
		this.color = color;
	}

	public void drive() {
		System.out.println("drive");
	}

	public void stop() {
		System.out.println("stop");
	}

	@Override
	public String toString() {
		return "Car [number: "+number +", type: "+ type + ", color: "+color+"]";
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
