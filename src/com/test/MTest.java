package com.test;

abstract class ABC{
	public abstract void prn();
	public abstract void disp();
}

class XX extends ABC{

	@Override
	public void prn() {
		System.out.println("XX prn");
	}

	@Override
	public void disp() {
		System.out.println("XX disp");
	}
	
}

class YY extends ABC {

	@Override
	public void prn() {
		System.out.println("YY prn");
		
	}

	@Override
	public void disp() {
		System.out.println("YY disp");
		
	}
	
}

public class MTest {

	public static void view(ABC obj) {
		switch(obj) {
			case XX xx->{
				xx.disp();
				xx.prn();
			}
			case YY yy->{
				yy.disp();
				yy.prn();
			}
			default -> System.out.println("알 수 없는 타입이야");
		}
	}
	
	public static void main(String[] args) {
		ABC a1 = new XX();
		ABC a2 = new YY();
		view(a1);
		view(a2);
		
//		XX x1 = new XX();
//		YY y1 = new YY();
	}

}
