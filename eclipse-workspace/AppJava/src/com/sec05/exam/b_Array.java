package com.sec05.exam;

public class b_Array {

	public static void main(String[] args) {
		Test();
	}

	private static void Test() {
		int[] ar = { 10, 20, 30, 40, 50 };
		int ar02[] = { 10, 20, 30, 40, 50, 70, 80, 90, 100 };

		System.out.println("===ar02출력===");
		System.out.println("호출전 : " + ar02[0]);
		prn(ar02);
		System.out.println(ar02[0]);

	}

	public static void prn(int[] ar) {
		System.out.println("===ar출력 (반복문)===");
		ar[0] = 1000;
		for (int i = 0; i < ar.length; i++) {
			System.out.printf("%5d", ar[i]);
		}
		System.out.println();
	}

}
