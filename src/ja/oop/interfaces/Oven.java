package ja.oop.interfaces;


public class Oven extends Number implements ISwitchable, Runnable, Cloneable  {

	private static final long serialVersionUID = 1L;

	@Override
	public void turnOn() {
		System.out.println("Oven turned on");
	}

	@Override
	public void turnOff() {
		System.out.println("Oven turned off");
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
	}

	@Override
	public int intValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public long longValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float floatValue() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public double doubleValue() {
		// TODO Auto-generated method stub
		return 0;
	}
}
