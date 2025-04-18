package java_mid2;

public class MethodMain2 {

	public static void main(String[] args) {
		Dog dog = new Dog("멍멍이", 100);
		Cat cat = new Cat("냐옹이", 100);
		
		AnimalMethod.checkup(dog);
		AnimalMethod.checkup(cat);
		
		Dog targetDog = new Dog("큰 멍멍이", 200);
		
		
		System.out.println("bigger = " + AnimalMethod.getBigger(dog, targetDog));
	}

}
