package com.sec04;

public class WhileTest {

	public static void test01() {
		int i = 1;
		while (i <= 5) {
			System.out.printf("%5d", i);
			i++;
		}
		System.out.println(" end i = " + i);
	}

	public static void test02() {
		int i = 1;

		while (i <= 5) {
			i++;
			System.out.printf("%5d", i);
		}
		System.out.println(" end i = " + i);
	}

	//1~100까지 숫자 
	//조건1 짝수
	//조건2 짝수의 개수를 출력하라
	public static void test03() {
		int i = 1;
		int cnt = 0; //개수 변수
		while (i <= 100) {
			if(i % 2 == 0) {
				System.out.printf("%5d", i);
				cnt++;
			}
			i++;
		}
		System.out.println(" end i = " + i);
		System.out.println("짝수의 개수는 " + cnt);
	}
	
		//1~100까지 숫자 
		//조건1 5의 배수에는 하트
		//조건2 5의 배수 단위로 줄바꿈하자
		//조건3 하트의 개수는 몇개일까
		public static void test04() {
			int i = 1;
			int cnt = 0;
			while (i <= 100) {
				if(i % 5 == 0) {
					System.out.printf("%5c\n", 'h');
					cnt++;
				}else {
					System.out.printf("%5d", i);
				}
				i++;
			}
			System.out.println("(하트의 개수)cnt : " + cnt);
		}
	
	public static void main(String[] args) {
		test01();
		System.out.println();
		test02();
		System.out.println();
		test03();
		System.out.println();
		test04();
	}

}
