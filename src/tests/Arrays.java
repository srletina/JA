package tests;


public class Arrays {

	static int testStatic[];
	//@formatter:off
	String[][] names = {
			{"Mr. ", "Mrs. ", "Ms. "},
			{"Smith", "Jones"}
	};
	//@formatter:on

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int[] test = new int[10];
		testStatic = new int[10];

		int[][][][][] test3 = new int[2][3][4][5][6];
		Integer[][] test4 = new Integer[3][1];
		Integer[][][] test5 = { { { new Integer(1), new Integer(2) }, { new Integer(1), new Integer(2) } },
				{ { new Integer(1), new Integer(2) }, { new Integer(1), new Integer(2) } } };
		int test6[][][] = { { { 1, 2 }, { 3, 4 } }, { { 5, 6 }, { 7, 8 } } };

		for (int i : test) {
			System.out.println(i);
		}
		for (int i : testStatic) {
			System.out.println(i);
		}

		int[] a = new int[5];
		for (int i = 0; i < a.length; i = i + 1) {
			a[i] = 10 + i;
		}
		for (int i = 0; i < a.length; i = i + 1) {
			System.out.println(a[i]);
		}
		String[] s = { "Frank", "Bob", "Jim" };
		for (int i = 0; i < s.length; i = i + 1) {
			System.out.println(s[i]);
		}
		s[2] = "Mike";
		System.out.println(s[2]);
	}
}
