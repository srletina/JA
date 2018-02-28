package ja.oop.interfaces;

public class SwitchableWorkerTest {

	public static void main(String[] args) {
		
		SwitchableWorker sw = new SwitchableWorker(new Spouse()); // Spouse implements ISwitchable
		sw.turnOn();
		sw.turnMiddle();
		sw.turnOff();
		System.out.println();
		
		sw.setiSwitchable(new Oven());
		sw.turnOn();
		sw.turnMiddle();
		sw.turnOff();
		System.out.println();
		
		sw.setiSwitchable(new ISwitchable() {
			@Override
			public void turnOn() {
				System.out.println("anonimous turns on");
			}
		});
		sw.turnOn();
		sw.turnMiddle();
		sw.turnOff();
		System.out.println();
		
		sw.setiSwitchable(()-> {
			System.out.println("lambda turns on");
		});
		sw.turnOn();
		sw.turnMiddle();
		sw.turnOff();
	}
}
