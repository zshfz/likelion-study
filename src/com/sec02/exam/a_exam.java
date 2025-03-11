package com.sec02.exam;

public class a_exam {

	public static void main(String[] args) {
		//Integer 클래스를 이용해서 다양한 기능 호출해보자
		//정수 100을 다양한 기능으로 호출 Integer class 찾아가자
		int a = 100;
		
		System.out.println(Integer.toBinaryString(a)); //2진수 문자열 출력
		System.out.println(Integer.toOctalString(a)); //8진수 문자열 출력
		System.out.println(Integer.toHexString(a)); //16진수 문자열 출력
		
		System.out.println("int의 범위는 " + Integer.MIN_VALUE + " ~ " + Integer.MAX_VALUE);
		
		
	}

}
