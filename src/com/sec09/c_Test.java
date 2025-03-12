package com.sec09;

import java.util.Scanner;

public class c_Test {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int r = 0;
		try {
			r = sc.nextInt();
		} catch (java.util.InputMismatchException e) {
			r = 0;
		}
		System.out.println("r = " + r);
	}
}
