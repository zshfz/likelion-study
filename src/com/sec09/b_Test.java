package com.sec09;

public class b_Test {
	public static void prn() throws ArithmeticException {
		// 코드 만줄 있다고 가정
		throw new ArithmeticException(); // 명시로 예외 발생
	}

	public static void prn01() throws ArithmeticException {
		prn();
	}

	public static void prn02() throws ArithmeticException {
		prn01();
	}

	public static void main(String[] args) {
		try {
			prn02();
		} catch (ArithmeticException e) {

		}

	}
}
