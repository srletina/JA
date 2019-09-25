package tests;

import tests.NinePlanets;

enum Days {SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY};


public class Enums {

	enum Months {January, February, March, April, May, June, July, August, September, October, November, December};

	public static void main(String[] args) {
		Day day = Day.MONDAY;
		System.out.println("Every day is like " + day);
		System.out.println("Day with index 3 is " + Day.values()[3]);
		// from test.NinePlanets
		Days born = Days.FRIDAY;
		System.out.println("I was born on " + born);
		System.out.println();
		
		Month month = Month.January;
		switch(month) {
		case February:
			System.out.println("Shortest month is " + month);
			break;
		default:
			System.out.println("It's " + month + "!!!");
			break;
		}
		System.out.println();

	    for (NinePlanets p : NinePlanets.values())
	    	System.out.println(p);

	    System.out.println("\nPlanet " + NinePlanets.EARTH + " has radius of " + (int)(NinePlanets.EARTH.radius()/1000) + " km.\n" );

	    NinePlanets planet = NinePlanets.PLUTON;
	    System.out.println();
		System.out.println(planet);
		System.out.println(planet.toString());
		System.out.println(planet.name());
		System.out.println(planet.hashCode());
		System.out.println(planet.ordinal());
		System.out.println(NinePlanets.values()[NinePlanets.VENUS.ordinal()]);
		System.out.println(planet.compareTo(NinePlanets.VENUS));
		System.out.println(planet.mass());
		System.out.println(planet.radius());
	}
}