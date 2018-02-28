package ja.oop.interfaces;

import java.util.ArrayList;
import java.util.List;


public class ISwitchableTest {

	public static void main(String[] args) {
		String closure = "Closure on";
		List<ISwitchable> list = new ArrayList<>();

		list.add(new Spouse());
		list.add(new Oven());
		list.add(new ISwitchable() {
			
			@Override
			public void turnOn() {
				System.out.println(closure + " turns on");
			}
			
			@Override
			public void turnOff() {
				System.out.println(closure + " turns off");
			}
		});
		list.add(()-> {
			System.out.println("lambda turns on");
		});
		
		printList(list);
	}

	private static void printList(List<ISwitchable> list) {

/*		
		list.forEach( new Consumer<ISwitchable>() {

			@Override
			public void accept(ISwitchable t) {
				// TODO Auto-generated method stub
				
			}
		});
*/		
		list.forEach(t-> {
			System.out.println(t.getClass());
			t.turnOn();
			t.turnOff();
			t.turnMiddle();
		});
	}

}
