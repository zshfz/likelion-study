package com.sec01.exam;

public class a_exam {
	//전역변수 영역 
	public static void main(String[] args) {
		//지역변수 영역 -> 지역변수는 반드시 선언과 동시에 초기화 해야 	
		int a; //4바이트 메모리를 a라는 이름으로 만들고 초기화 -> 초기
		a = 100; //재대입

		int b = 200; //초기화하면서 값 대
		System.out.println(a);
		System.out.println(b);
	}

}
