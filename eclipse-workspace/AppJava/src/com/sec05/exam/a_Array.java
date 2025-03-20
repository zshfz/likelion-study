package com.sec05.exam;

public class a_Array {

	public static void main(String[] args) {
		Test();
	}

	private static void Test() {
		// 1 배열 선언 생성 출력 확인
		int[] ar = { 10, 20, 30, 40, 50 };
		int ar02[] = { 10, 20, 30, 40, 50 };
		System.out.println("===ar출력 (직접)===");
		System.out.println(ar[0]);
		System.out.println(ar[1]);
		System.out.println(ar[2]);
		System.out.println(ar[3]);
		System.out.println(ar[4]);
		
		System.out.println("===ar출력 (반복문)===");
		for(int i = 0;i < 5;i++) {
			System.out.println(ar[i]);
		}
		
		System.out.println("===ar출력 (for-each, 제네릭 for)===");
		for(int res : ar) {
			System.out.println(res);
		}
	}

}
