package ja.oop.principles;

public class StringTest {

	public static void main(String[] args) {

		// gdje su objekti u memoriji i kako se pridružuju jedan drugome....
		// String.intern() - povezuje varijablu sa stringom u poolu stringova, ako postoji koristi postojeæi objekt

		String pero = "Pero";
		String pero2 = new String("Pero");
		String pero3 = new String("Pero");
		
		System.out.println("pero.string == pero2.string: " + pero.equals(pero2));
		System.out.println("pero.object == pero2.object: " + (pero==pero2));
		System.out.println("pero.object == pero3.object: " + (pero==pero3));

		System.out.println("Calling pero2 = pero2.intern();");
		pero2 = pero2.intern();
		System.out.println("pero.string == pero2.string: " + pero.equals(pero2));
		System.out.println("pero.object == pero2.object: " + (pero==pero2));
		System.out.println("pero.object == pero3.object: " + (pero==pero3));

		System.out.println("Create pero4 and pero5.");
		String pero4 = "Pero";
		System.out.println("pero.string == pero4.string: " + pero.equals(pero4));
		System.out.println("pero.object == pero4.object: " + (pero==pero4));

		String pero5 = "Pero";
		System.out.println("pero.string == pero5.string: " + pero.equals(pero5));
		System.out.println("pero.object == pero5.object: " + (pero==pero5));
		
		for (int i=0; i<100; i++) {
			pero += i + " ";
		}
		System.out.println("Pero:" + pero);
		System.out.println("Pero2:" + pero2);
		System.out.println("Pero3:" + pero3);
		System.out.println("Pero4:" + pero4);
		System.out.println("Pero5:" + pero5);
		
		StringBuilder sb = new StringBuilder("Pero");
		for (int i=0; i<100; i++) {
			sb.append(i).append(" ");
		}
		System.out.println(sb.toString());
		// ili System.out.println(sb);
	}

}
