package com.sec08.mytest03;

/*
 public interface IDraw {
 	public abstract int getDraw();
 }

 abstract class my implements IDraw { //my 클래스는 IDraw의 추상메소드를 오버라이드 하지 않아서 추상 클래스여 함
 }
 */

public interface IDraw {
	public static final int line = 1;
	public static final int circle = 2;
	public static final int rect = 3;

	int getDraw();

	default int getPoint() {
		return 10;
	}
	static void foo() {
		System.out.println("foo");
	}
}



