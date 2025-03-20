package com.sec01.exam;
//각 리터럴에 맞는 값을 주면서 메소드 호출을 해보
public class f_exam {

	public static void prn01(long res) { //메소드 호출할 때 정수값 받으면서 지역변수 생성해서 값 대입 
		System.out.println("정수 res = " + res);
	}
	
	public static void main(String[] args) {

		prn01(100);
		prn01('a');
		prn01((long)90.1); 


	}

}
