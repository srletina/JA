package tests;


public class GenericSingleton<T> {

	private GenericSingleton<T> instance = null;
	private T t = null;

    public GenericSingleton<T> getInstance() {
        if (instance == null)
            instance = new GenericSingleton<T>();

        return instance;
    }

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}
}

