package tests;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class Primarno {

	public static void main(String[] args)
	{	// da vidim koliko se brzo generiraju prim brojevi
		// glede https://www.eff.org/awards/coop

		// $100,000 to the first individual or group who discovers a prime number with at least 10,000,000 decimal digits (awarded Oct. 22, 2009)
		// $150,000 to the first individual or group who discovers a prime number with at least 100,000,000 decimal digits
		// $250,000 to the first individual or group who discovers a prime number with at least 1,000,000,000 decimal digits
		
		// ispada da je brute force smješan algoritam prema ovome što se koristi za odrediti primarni broj....

		final int target = 100000;
		int i, candidate, primarnih, enough;

		System.out.println(String.format("Primarni brojevi.\nMetode: Memorija, eksplicitni algoritam, optimizirano, jako optimizirano"));

		startTimer();
		int primarni[] = new int[target];
		primarni[0] = 2;
		candidate = 3;
		primarnih = 1;
		//int delta;
		//int maxDelta = 0;
		//long deltaAvg = 0;
		while (primarnih < target)
		{	// kandidat za provjeru je kandidat
			enough = (int) Math.sqrt(candidate);
			i = 0;
			while (i < primarnih) {
				if (candidate % primarni[i] == 0) {
					// not a primary number
					// double-check
					//if (isPrimeFaster(kandidat) == false) {
					//  System.out.println("A u kurac!!!");
					//}
					break;
				}
				if (primarni[i] >= enough) {
					primarni[primarnih] = candidate;
					//delta = kandidat - primarni[primarnih - 1];
					//deltaAvg += delta;
					//if (maxDelta < delta) {
					//	maxDelta = delta;
					//}
					primarnih++;
					//System.out.println(String.format("%d: %d, delta=%d", primarnih, kandidat, delta));
					// double-check
					//if (isPrimeFaster(kandidat) == false) {
					//  System.out.println("A u kurac!!!");
					//}
					break;
				}
				i++;
			}
			candidate++;
		}
		stopTimer();
		//System.out.println(String.format("%d primarnih brojeva, zadnji je %d=%d, maxDelta=%d, deltaAvg=%d", target, candidate - 1, primarni[primarnih - 1], maxDelta, deltaAvg/target));
		System.out.println(String.format("%d primarnih brojeva, zadnji je %d", primarnih, candidate - 1));
		System.out.println("Time: " + duration);

		
		startTimer();
		candidate = 0;
		primarnih = 0;
		for(;;) { // fastest loop 
			if (isPrime(candidate++)) {
				primarnih++;
				if (primarnih >= target) {
					break;
				}
			}
		}
		stopTimer();
		System.out.println(String.format("%d primarnih brojeva, zadnji je %d", primarnih, candidate - 1));
		System.out.println("Time: " + duration);


		startTimer();
		candidate = 0;
		primarnih = 0;
		for(;;) { // fastest loop 
			if (isPrimeFast(candidate++)) {
				primarnih++;
				if (primarnih >= target) {
					break;
				}
			}
		}
		stopTimer();
		System.out.println(String.format("%d primarnih brojeva, zadnji je %d", primarnih, candidate - 1));
		System.out.println("Time: " + duration);


		ThreadMXBean bean = ManagementFactory.getThreadMXBean( );
		LocalTime start, end;
		long start2, start3;
		long end2, end3;
		long fastest = -1;
		long fastest2 = -1;
		long fastest3 = -1;
		long avg = 0;
		long avg2 = 0;
		long avg3 = 0;
		for (int measure = 1; measure<11; measure++) {
			start = LocalTime.now();
			start2 = bean.getCurrentThreadCpuTime();
			start3 = bean.getCurrentThreadUserTime();
			candidate = 0;
			primarnih = 0;
			for(;;) {
				if (isPrimeFaster(candidate++)) {
					primarnih++;
					if (primarnih >= target) {
							break;
					}
				}
			}
			end = LocalTime.now();
			end2 = bean.getCurrentThreadCpuTime();
			end3 = bean.getCurrentThreadUserTime();
			long diff = start.until(end, ChronoUnit.MILLIS);
			long diff2 = (end2-start2)/1000000;
			long diff3 = (end3-start3)/1000000;
			avg += diff;
			avg2 += diff2;
			avg3 += diff3;
			if (fastest == -1 || diff < fastest) {
				fastest = diff;
			}
			if (fastest2 == -1 || diff2 < fastest2) {
				fastest2 = diff2;
			}
			if (fastest3 == -1 || diff3 < fastest3) {
				fastest3 = diff3;
			}
			System.out.print(diff + "<->" + diff2 + "<->" + diff3 + "..");
		}
		System.out.println();
		System.out.println("Fastest/Average time: " + fastest + "/" + avg/10);
		System.out.println("Fastest/Average time2: " + fastest2 + "/" + avg2/10);
		System.out.println("Fastest/Average time3: " + fastest3 + "/" + avg3/10);
	}


	public static boolean isPrime(int candidate) {
		// negative numbers are not allowed, and 0 & 1 are not primes
		if (candidate < 2) {
			return false;
		}
		int enough = (int) Math.sqrt(candidate);
		for (int i = 2; i <= enough; i++) {
			if (candidate % i == 0) {
				return false;
			}
		}
		return true;
	}


	public static boolean isPrimeFast(int candidate) {
		// negative numbers are not allowed, and 0 & 1 are not primes, 2 is prime
		if (candidate < 3) {
			if (candidate == 2)
				return true;
			else
				return false;
		}
		// even numbers aren't prime numbers (except 2)
		if ((candidate & 1) == 0) {
			return false;
		}
		// check odd ones from 3 to SQR(candidate)
		int enough = (int) Math.sqrt(candidate);
		for (int i = 3; i <= enough; i+=2) {
			if (candidate % i == 0) {
				return false;
			}
		}
		return true;
	}


	public static boolean isPrimeFaster(int candidate) {
		// values for 0 - 10
		final boolean[] first10 = {false, false, true, true, false, true, false, true, false, false, false};
		// negative numbers are not allowed, and 0 & 1 are not primes
		if (candidate < 2) {
			return false;
		}
		// from 2 - 10
		if (candidate < 11) {
			return first10[candidate];
		}
		// even numbers aren't prime numbers, wont be checking them later
		// faster than if ((candidate % 2) == 0) {
		if ((candidate & 1) == 0) {
			return false;
		}
		// ending with 5 aren't primes, wont be checking them later
		if ((candidate % 5) == 0) {
			return false;
		}
		// check the rest to SQR(candidate)
		int enough = (int) Math.sqrt(candidate);
		int i = 3;
		while (true) {
			// number ends with 3
			if (candidate % i == 0) {
				return false;
			}
			i += 4;
			if (i > enough) {
				return true;
			}
			// number ends with 7
			if (candidate % i == 0) {
				return false;
			}
			i += 2;
			if (i > enough) {
				return true;
			}
			// number ends with 9
			if (candidate % i == 0) {
				return false;
			}
			i += 2;
			if (i > enough) {
				return true;
			}
			// number ends with 1
			if (candidate % i == 0) {
				return false;
			}
			i += 2;
			if (i > enough) {
				return true;
			}
		}
	}


	static LocalTime startLT;
	static long duration;
	
	private static void startTimer() {
		startLT = LocalTime.now();
	}
	
	private static void stopTimer() {
		duration = startLT.until(LocalTime.now(), ChronoUnit.MILLIS);
	}
}