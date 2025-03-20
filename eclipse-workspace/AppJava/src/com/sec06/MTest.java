package com.sec06;

//toString(), equals(), hashcode() 오버라이드
//record는 불변객체
record Address(String name, String address, String telNum) {}
public class MTest {

	public static void main(String[] args) {
		Address a1 = new Address("홍길동", "서울", "010-9999");
		Address a2 = new Address("홍길동", "서울", "010-9999");
		
		System.out.println(a1.equals(a2));
	}

}
