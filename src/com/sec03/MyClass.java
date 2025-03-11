package com.sec03;

public class MyClass {
	private int a;
	
	public MyClass() {
		System.out.println("i am basic constructor " + this.a);
	}
	
	public MyClass(int a) {
		this.a = a;
		System.out.println("i am basic overload constructor " + this.a);
	}

	public static void main(String[] args) {
		MyClass m = new MyClass();
//		MyClass m = new MyClass(1);
	}

}
