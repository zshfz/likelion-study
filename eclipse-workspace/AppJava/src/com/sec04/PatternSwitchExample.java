package com.sec04;

public class PatternSwitchExample {

	public static void main(String[] args) {
		Object obj = 20.1;
		switch (obj) {
		case Double d -> System.out.println("실수 : " + d);
		case Integer i -> System.out.println("정수 : " + i);
		case String s -> System.out.println("문자열 : " + s);
		case null -> System.out.println("Null");
		default -> System.out.println("기타 값 : " + obj);
		}

	}

}
