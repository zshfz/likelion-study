package com.sec03;

class Test {
	//두개의 정수를 관리하는 클래스
	private int a;
	private int b;

	// setter
	public void setA(int a) {
		this.a = a; // 전달 및 변경
	}

	public void setB(int b) {
		this.b = b; // 전달 및 변경
	}

	// getter
	public int getA() {
		return a;
	}

	public int getB() {
		return b;
	}
}

public class MTest {

	public static void main(String[] args) {
		//메모리 할당 객체 생성
		Test m = new Test();
		Test m1 = new Test();
		Test m2 = new Test();
		
		//할당된 주소를 확인
		System.out.println("각 주소를 출력해보자");
		System.out.println(m);
		System.out.println(m1);
		System.out.println(m2);
		
		//할당된 초기값 확인 => 멤버 변수는 객체가 생성될 때 생성자에 의해서 초기값을 대입 후 메모리 할당한다
		System.out.printf("m    a = %5d    b = %5d\n",m.getA(), m.getB());
		System.out.printf("m1    a = %5d    b = %5d\n",m1.getA(), m1.getB());
		System.out.printf("m2    a = %5d    b = %5d\n",m2.getA(), m2.getB());
		
	}

}
