package ja.oop.interfaces;


//functional interface has exactly one abstract method
@FunctionalInterface
public interface ISwitchable {

	int a = 0;
	Integer b = 0;
	
	abstract void turnOn();

	// Java 8: interface can provide the default implementation of a method
	default void turnOff() {
	}

	// Java 8: interface can provide the default implementation of a method
	default void turnMiddle() {
		System.out.println("Middle implemented in interface");
	}
}
