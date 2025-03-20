package com.test;

public class Doit01 {

	public static void main(String[] args) {
		try {
			Thread.sleep(1000);
		System.out.println("asd");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
