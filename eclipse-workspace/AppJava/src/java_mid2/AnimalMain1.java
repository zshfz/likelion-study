package java_mid2;

public class AnimalMain1 {

	public static void main(String[] args) {
		Animal animal = new Animal("동물", 0);
		Dog dog = new Dog("멍멍이", 100);
		Cat cat = new Cat("냐옹이", 50);
		
		GenericBox<Dog> dogBox = new GenericBox<Dog>();
		dogBox.set(dog);
		System.out.println("findDog = " + dogBox.get());
		
		GenericBox<Cat> catBox = new GenericBox<Cat>();
		catBox.set(cat);
		System.out.println("findCat = " + catBox.get());
		
		GenericBox<Animal> animalBox = new GenericBox<Animal>();
		animalBox.set(animal);
		System.out.println("findAnimal = " + animalBox.get());
	}

}
