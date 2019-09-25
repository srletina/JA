package tests;

import java.util.List;


public final class GenericTest {

	// public static T max(T x, T y) {
	public static <T> T max(T x, T y) {
		// return x > y ? x : y;
		return x;

	}

	public static void print(List<? extends Number> list) {
		for (Number n : list)
			System.out.print(n + " ");
		System.out.println();
	}
}
