package com.sec07.mytest;

//생성자 확인, 상속시 주소 영역 확인
public class MTest {

	public static void main(String[] args) {
		AA a1 = new DD(); //AA(), BB(), DD() 객체생성됨
		
		BB b1 = new DD(); //AA(), BB(), DD() 객체생성됨
		b1.getRes(); //이건 DD꺼
		
		BB b2 = new BB(); //AA(), BB() 객체생성됨
		
		AA c1 = new BB(); //AA(), BB() 객체생성됨
		
//		BB b3 = new AA(); //이거 에러
		
		System.out.println("==============================");
		check_instance(a1);
		check_instance(b1);
		check_instance(b2);
		check_instance(c1);
		
		
	}
	
	public static void check_instance(AA obj) {
		if(obj instanceof DD) {
			System.out.println("객체는 DD 클래스의 인스턴스");
		}else if(obj instanceof BB) {
			System.out.println("객체는 BB 클래스의 인스턴스");
		}else if(obj instanceof AA) {
			System.out.println("객체는 AA 클래스의 인스턴스");
		}
	}

}
