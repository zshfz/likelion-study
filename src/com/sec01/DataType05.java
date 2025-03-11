package com.sec01;

public class DataType05 {
	public static void main(String[] args) {
		float f = 3.141f;
		double d = 3.141d;
		double d2 = 3.141;
		System.out.println(f);
		System.out.println(d);
		System.out.println(d2);
		
		System.out.println("float 타입 확인 : " + ((Object)f).getClass().getSimpleName());
		System.out.println("double 타입 확인 : " + ((Object)d).getClass().getSimpleName());
	}
}


