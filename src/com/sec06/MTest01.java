package com.sec06;

record Person(String name, int age) {
}

public class MTest01 {

	public static void main(String[] args) {

		Person[] people = { new Person("Alice", 30), new Person("Bob", 25) };

		Person[] people2 = new Person[2];
		people2[0] = new Person("Alice", 30);
		people2[1] = new Person("Bob", 20);
		
		prn(people);
		prn(people2);
	}

	private static void prn(Person[] people) {
		for(Person res : people) {
			System.out.println(res);
		}
		System.out.println();
	}
}
