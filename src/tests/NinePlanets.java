package tests;

enum Day {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY};
enum Month {January, February, March, April, May, June, July, August, September, October, November, December};

public enum NinePlanets {
	MERCURY (3.303e+23, 2.4397e6),
	VENUS   (4.869e+24, 6.0518e6),
	EARTH   (5.976e+24, 6.37814e6),
	MARS    (6.421e+23, 3.3972e6),
	JUPITER (1.9e+27,   7.1492e7),
	SATURN  (5.688e+26, 6.0268e7),
	URANUS  (8.686e+25, 2.5559e7),
	NEPTUNE (1.024e+26, 2.4746e7),
	PLUTON  (1.303e+22, 1.187e6);

	private final double mass;   // in kilograms
	private final double radius; // in meters

	// enum constructor
	NinePlanets(double mass, double radius) {
		this.mass = mass;
		this.radius = radius;
	}

	public double mass() {return this.mass;}
	public double radius() {return this.radius;}
}
