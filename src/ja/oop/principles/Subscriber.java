package ja.oop.principles;

import java.util.Map;

public class Subscriber implements OnEventHandler<Integer, String> {

	@Override
	public void onEvent(Object sender, Map<Integer, String> args) {
		System.out.println(sender + " sent to subscriber: " + args);
		
	}

}
