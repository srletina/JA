package ja.oop.principles;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Publisher {
//	private OnEventHandler<Integer, String> eventHandler;

//	public OnEventHandler<Integer, String> getEventHandler() {
//		return eventHandler;
//	}
//
//	public void setEventHandler(OnEventHandler<Integer, String> eventHandler) {
//		this.eventHandler = eventHandler;
//	}
	
	private List<OnEventHandler<Integer, String>> subscribers = new ArrayList<>();
	
	public void addSubscriber(OnEventHandler<Integer, String> subscriber) {
		subscribers.add(subscriber);
	}
	
	public void removeSubscriber(OnEventHandler<Integer, String> subscriber) {
		subscribers.remove(subscriber);
	}
	
	public void doWork() {
		new Thread(new Runnable() {
			@Override
			public void run() {
				int counter = 0;
				while(true) {
					try {
						Publisher.this.notify(counter++);
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}).start();
	}
	
	protected void notify(int counter) {

//		for (OnEventHandler<Integer, String> subscriber : subscribers) {
//			Map<Integer, String> args = new HashMap<>();
//			args.put(counter, DateTimeFormatter
//								.ofPattern("hh:mm:ss")
//								.format(LocalDateTime.now()));
//			subscriber.onEvent(this, args);
//		}	
//		
		subscribers.forEach(new Consumer<OnEventHandler<Integer, String>>() {
			@Override
			public void accept(OnEventHandler<Integer, String> t) {
				Map<Integer, String> args = new HashMap<>();
				args.put(counter, DateTimeFormatter
									.ofPattern("hh:mm:ss")
									.format(LocalDateTime.now()));
				t.onEvent(this, args);
				
			}
		});
		
//		subscribers.forEach(t-> {
//			Map<Integer, String> args = new HashMap<>();
//			args.put(counter, DateTimeFormatter
//									.ofPattern("hh:mm:ss")
//									.format(LocalDateTime.now()));
//			t.onEvent(this, args);			
//		});		
	}

//	private void notify(int counter) {
//		if (eventHandler != null) {
//			Map<Integer, String> args = new HashMap<>();
//			args.put(counter, DateTimeFormatter
//								.ofPattern("hh:mm:ss")
//								.format(LocalDateTime.now()));
//			eventHandler.onEvent(this, args);
//		}
//	}
}
