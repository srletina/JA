package ja.oop.inheritance;

import java.util.ArrayList;
import java.util.List;

public class CarUser {

	public static void main(String[] args) {

		Car car = new Car(123, "Mercedes", "Blue");
		printDetails(car);
		car.drive();
		car.stop();
		System.out.println();

		SportsCar sportsCar = new SportsCar(321, "Ferrari", "red", true);
		printDetails(sportsCar);
		sportsCar.drive();
		sportsCar.drift();
		sportsCar.stop();
		System.out.println();

		Car car2 = sportsCar;
		car2.drive();
		car2.stop();
		if (car2 instanceof SportsCar) {
			((SportsCar) car2).drift();
		}
		System.out.println();

		List<Car> list = new ArrayList<>();
		list.add(car);
		list.add(sportsCar);
		list.add(car2);
		list.add(getCar());
		list.add(getSportsCar());
		list.add(getFactoryCar("za curice"));
		list.add(getFactoryCar("sports"));
		list.add(getFactoryCar("truck"));
		for (Car c : list) {
			printDetails(c);
		}
	}

	private static void printDetails(Car car) {
		System.out.println(car);
	}

	private static Car getCar() {
		return new SportsCar(112, "Diana", "yellow", true);
	}

	private static SportsCar getSportsCar() {
		//return new Car(112, "Diana", "yellow"); no can do!
		return new SportsCar(112, "Diana", "yellow", true);
	}

	private static Car getFactoryCar(String type) {
		switch (type) {
		case "sports":
			return new SportsCar(112, "Diana", "yellow", true);
		case "truck":
			return new Truck(122, "FAP", "SIVI");
		}
		return new SportsCar(112, "Diana", "pink", true);
	}
}
