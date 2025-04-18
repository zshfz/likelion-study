package java_mid2;

public class BoxMain3 {

	public static void main(String[] args) {
		GenericBox<Integer> integerBox = new GenericBox<Integer>();
		integerBox.set(10);
		System.out.println("integer = " + integerBox.get());
		
		GenericBox<String> stringBox = new GenericBox<String>();
		stringBox.set("hello");
		System.out.println("string = " + stringBox.get());
	}

}
