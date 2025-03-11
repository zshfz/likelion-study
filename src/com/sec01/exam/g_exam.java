package com.sec01.exam;

public class g_exam {

	public static void prn01(int res) { //메소드 호출할 때 정수값 받으면서 지역변수 생성해서 값 대입 
		System.out.println("정수 res = " + res);
	}
	
	public static void prn02(char res) { 
		System.out.println("정수 res = " + res);
	}
	
	public static void prn03(double res, int a) { 
		System.out.println("정수 res = " + res + " 정수 a = " + a);
	}
	
	public static void main(String[] args) {
//		prn01();
		prn01(100);
		prn01(200);
		
		prn02('a');
		prn03(90.1, 100);

	}

}
