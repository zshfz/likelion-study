package com.sec01.exam;
//사칙연산 방법 1. 직접출력, 2. 변수를 통해 연산, 3. 사용자 자료형_class, 4. 네트워크 처리

public class c_exam {

	public static void main(String[] args) {
		int a, b, add, sub, mul, div; //지역변수 선
		
		a = 100; //값 대입
		b = 200;
		add = sub = mul = div = 0;
		
		add = a + b;
		sub = a - b;
		mul = a * b;
		div = a / b;
		
		System.out.println(a + " + " + b  + " = " + add);
		System.out.println(a + "-" + b  + " = " + sub);
		System.out.println(a + " * " + b  + " = " + mul);
		System.out.println(a + " / " + b  + " = " + div);
	}

}
