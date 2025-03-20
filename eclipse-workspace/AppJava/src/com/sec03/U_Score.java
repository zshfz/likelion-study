package com.sec03;

public class U_Score {

	private String name;
	private int kor;
	private int eng;
	private int mat;

	
	
	public U_Score() {
		//super(); 주석 지우면 에러남
		//내부 생성자 호출 가능 생성자의 첫줄에 명시
		this("noname", 50, 50, 50);
	}

	public U_Score(String name, int kor, int eng, int mat) {
		super();
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKor() {
		return kor;
	}

	public void setKor(int kor) {
		this.kor = kor;
	}

	public int getEng() {
		return eng;
	}

	public void setEng(int eng) {
		this.eng = eng;
	}

	public int getMat() {
		return mat;
	}

	public void setMat(int mat) {
		this.mat = mat;
	}
	
	public int getTot() {
		return this.getKor() + this.getEng() + this.getMat();
	}
	
	public int getAvg() {
		return this.getTot() / 3;
	}

	@Override
	public String toString() {
		return String.format("U_Score [getName()=%s, getKor()=%d, getEng()=%d, getMat()=%d, getTot()=%d, getAvg()=%d]",
				getName(), getKor(), getEng(), getMat(), getTot(), getAvg());
	}

	public static void main(String[] args) {
		U_Score a1 = new U_Score();
		U_Score b1 = new U_Score();
		U_Score c1 = new U_Score();
		
		a1.setName("홍길동");
		a1.setKor(100);
		a1.setEng(100);
		a1.setMat(100);
		
		b1.setName("정길동");
		b1.setKor(90);
		b1.setEng(90);
		b1.setMat(90);
		
		c1.setName("박길동");
		c1.setKor(80);
		c1.setEng(80);
		c1.setMat(80);
		
		System.out.println(a1);
		System.out.println(b1);
		System.out.println(c1);
		
		System.out.printf("%10s %10s %10s\n", a1.getName(), b1.getName(), c1.getName());
		int total = a1.getTot()  + b1.getTot() + c1.getTot();
		System.out.println("total score = " + total);
	}

}
