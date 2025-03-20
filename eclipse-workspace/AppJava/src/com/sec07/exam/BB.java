package com.sec07.exam;

public class BB extends AA {
	private int c;

	public BB() {
		System.out.println("BB 기본 생성자");
	}

	public BB(int i, int j, int k) {
		super(i, j);
		this.c = k;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	public int getRes() {
		return (getA() + getB()) - getC();
	}

}
