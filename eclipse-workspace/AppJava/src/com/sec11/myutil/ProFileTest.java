package com.sec11.myutil;

public class ProFileTest {
	public static void main(String[] args) {
		ProFile<String> p1 = new ProFile<String>("Dominica", "관리자");
		ProFile<Integer> p2 = new ProFile<Integer>("Dominico", 1111);
		ProFile<Double> p3 = new ProFile<>("Dominico", 1111.0);
		System.out.println(p1.getName() + "   " + p1.getDept());
		System.out.println(p2.getName() + "   " + p2.getDept());
		System.out.println(p3.getName() + "   " + p3.getDept());
	}
}
