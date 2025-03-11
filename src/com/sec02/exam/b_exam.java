package com.sec02.exam;

public class b_exam {
	public void prn() { //Instance Methods
		System.out.println("b_exam'prn -> non-static");
	}
	
	public static void main(String[] args) {
		b_exam m = new b_exam(); //new 연산자를 만나면 객체를 동적할당 = 클래스 객체를 생성한
		
		System.out.println(m.toString());
		System.out.println(m);
		m.prn(); 
	}

}
