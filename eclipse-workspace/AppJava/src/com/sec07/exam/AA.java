package com.sec07.exam;

//a, b ,a + b를 계산하는 클래스 
public class AA {
	private int a;
	private int b;
	
	public AA() {
		System.out.println("AA 기본 생성자");
	}

	public AA(int i, int j) {
		this.a = i;
		this.b = j;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	protected int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getHap() {
		return getA() + getB();
	}

}
