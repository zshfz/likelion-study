package java_mid2;

public class GenericBox<T> {
	private T value;
	
	public void set(T value) {
		this.value = value;
	}
	
	public T get() {
		return value;
	}
}
