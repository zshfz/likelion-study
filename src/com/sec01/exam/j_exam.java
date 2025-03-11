package com.sec01.exam;
//사칙연산 방법 1. 직접출력, 2. 변수를 통해 연산, 3. 사용자 자료형_class, 4. 네트워크 처리

public class j_exam {

	public static void main(String[] args) {
		int a, b, add, sub, mul;
		double div; //지역변수 선언
		
		a = 100; //값 대입
		b = 200;
		add = sub = mul = 0;
		div = 0.0;
		
		add = Calc.getAdd(a, b); //클래스명.메소드명으로 호
		sub = Calc.getSub(a, b);
		mul = Calc.getMul(a, b);
		div = Calc.getDiv(a, b);
		
		System.out.println(a + " + " + b  + " = " + add);
		System.out.println(a + "-" + b  + " = " + sub);
		System.out.println(a + " * " + b  + " = " + mul);
		System.out.println(a + " / " + b  + " = " + div);
	}

}
