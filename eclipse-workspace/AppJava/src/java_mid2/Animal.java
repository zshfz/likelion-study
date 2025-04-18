package java_mid2;

public class Animal {
	private String name;
	private int size;

	public Animal(String name, int size) {
		this.name = name;
		this.size = size;
	}

	public String getName() {
		return name;
	}

	public int getSize() {
		return size;
	}

	public void sound() {
		System.out.println("동물 울음 소리");
	}

	@Override
	public String toString() {
		return "Animal{" + "name='" + name + '\'' + ", size=" + size + '}';
	}
}

class Dog extends Animal {
	public Dog(String name, int size) {
		super(name, size);
	}

	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}

class Cat extends Animal {
	public Cat(String name, int size) {
		super(name, size);
	}

	@Override
	public void sound() {
		System.out.println("냐옹");
	}
}