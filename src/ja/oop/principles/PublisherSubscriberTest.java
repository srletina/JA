package ja.oop.principles;

import java.util.Map;

public class PublisherSubscriberTest {

	public static void main(String[] args) {

		Publisher p = new Publisher();
		Subscriber s = new Subscriber();
		// p.setEventHandler(s);
		p.addSubscriber(s);

		p.addSubscriber(new OnEventHandler<Integer, String>() {

			@Override
			public void onEvent(Object sender, Map<Integer, String> args) {
				System.out.println(sender + " sent to anonymous: " + args);
			}
		});
		p.addSubscriber((sender, argss) -> {
			System.out.println(sender + " sent to lambda " + argss);

		});

		p.doWork();
	}
}
