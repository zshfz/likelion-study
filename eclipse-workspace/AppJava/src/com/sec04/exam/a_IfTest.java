package com.sec04.exam;

public class a_IfTest {

	public static void main(String[] args) {
		int a = 100;
		
		if(a > 0) {
			System.out.println(a);
		}else {
			System.out.println("양수 아님");
		}
		
		
		int num = 100;
		
		if(num > 0) {
			System.out.println("양수");
		}else if(num < 0){
			System.out.println("음수");
		}else {
			System.out.println("0 입니다");
		}
		
	}

}
