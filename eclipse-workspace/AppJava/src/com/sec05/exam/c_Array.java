package com.sec05.exam;

public class c_Array {

	public static void main(String[] args) {
		Test();
	}

	private static void Test() {
		//동적할당
		int[] ar02 = new int[10];
		
		
		for(int i = 0;i<ar02.length;i++) {
			ar02[i] = i + 1;
		}
		
		prn(ar02);
		
		reversePrn(ar02);

	}

	public static void prn(int[] ar) {
		System.out.println("===ar출력===");
		for (int i = 0; i < ar.length; i++) {
			System.out.printf("%5d", ar[i]);
		}
		System.out.println();
	}
	
	public static void reversePrn(int[] ar) {
		System.out.println("===ar역순출력===");
		for (int i = ar.length-1; i >= 0; i--) {
			System.out.printf("%5d", ar[i]);
		}
		System.out.println();
	}

}
