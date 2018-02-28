package ja.oop.principles;

import java.util.Map;

@FunctionalInterface
public interface OnEventHandler<K, V> {
	void onEvent(Object sender, Map<K, V> args);
}
