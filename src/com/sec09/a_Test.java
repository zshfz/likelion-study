package com.sec09;

public class a_Test {
	public static void main(String[] args) {
		int a = 100;
		int b = 0;
		int res = 0;
		
		try {
			res = a / b;
		}catch(ArithmeticException e) { // ArithmeticException e = new java.lang.ArithmeticException("/ by zero");
			b = 2;
			System.out.println("예외 처리 했다 : " + e.getMessage());
		}catch(RuntimeException e) {
			System.out.println("또 다른 경우 RuntimeException");
		}catch(Exception e) {
			System.out.println("또 다른 경우 RuntimeException");
		}finally {
			System.out.println("반드시 수행해야 할 구문");
		}
		
		System.out.printf("a = %5d b = %5d res = %5d\n",a,b,res);
	}
}
