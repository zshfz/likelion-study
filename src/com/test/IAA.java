package com.test;

public interface IAA {
	int a = 10;
	public static final int b = 20;
	
	void prn();
	public abstract void disp();
	
	default void view() { //재정의 가능
		System.out.println(a);
	}
	
	static void view02() { //재정의 불가능
		System.out.println(a);
	}
}
