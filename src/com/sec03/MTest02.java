package com.sec03;


public class MTest02 {

	public static void main(String[] args) {
		Integer i = 100; //Integer i = new Integer(100);
		System.out.println(i.doubleValue());
		Integer i2 = new Integer("100");
		System.out.println(i2.doubleValue());
		
		String str = "abcdefg"; //String str = new String("abcdefg");
		System.out.println("length = " + str.length());
		System.out.println("upper = " + str.toUpperCase());
		
		String res = str.toUpperCase();
		System.out.println(res + " 소문자로 -> " + res.toLowerCase());
		
		java.util.Random r = new java.util.Random();
		System.out.println(r.nextInt(101));
		
		java.util.Random r2 = new java.util.Random();
		System.out.println(r.nextInt(101));
		
		int r3 = (int)(Math.random() * 101);
		System.out.println(r.nextInt(r3));
	}

}
