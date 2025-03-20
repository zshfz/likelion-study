package com.sec01.exam;
//사칙연산 방법 1. 직접출력, 2. 변수를 통해 연산, 3. 사용자 자료형_class, 4. 네트워크 처리

public class e_exam {

	public static void calc() { //println 사용
		int a, b, add, sub, mul;
		double div; //지역변수 선
		
		a = 100; //값 대입
		b = 200;
		add = sub = mul = 0;
		div = 0.0;
		
		add = a + b;
		sub = a - b;
		mul = a * b;
		div = a / b;
		
		System.out.println(a + " + " + b  + " = " + add);
		System.out.println(a + "-" + b  + " = " + sub);
		System.out.println(a + " * " + b  + " = " + mul);
		System.out.println(a + " / " + b  + " = " + div);
	}
	
	public static void calc02() { //printf 사용
		int a, b, add, sub, mul;
		double div; //지역변수 선
		
		a = 100; //값 대입
		b = 200;
		add = sub = mul = 0;
		div = 0.0;
		
		add = a + b;
		sub = a - b;
		mul = a * b;
		div = a / b;
		
		System.out.println(a + " + " + b  + " = " + add);
		System.out.printf("%5d + %5d = %5d\n", a, b, add);
		
		System.out.println(a + "-" + b  + " = " + sub);
		System.out.println(a + " * " + b  + " = " + mul);
		
		System.out.println(a + " / " + b  + " = " + div);
		System.out.printf("%5d / %5d = %.2f\n", a, b, div);
	}
	
	
public static void main(String[] args) {
	calc();
	calc02();
}

}
