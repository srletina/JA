package ja.oop.interfaces;


public class Spouse implements ISwitchable {

	@Override
	public void turnOn() {
		System.out.println("Spouse turns on");
	}

	@Override
	public void turnOff() {
		System.out.println("Spouse turns off");
	}
}
