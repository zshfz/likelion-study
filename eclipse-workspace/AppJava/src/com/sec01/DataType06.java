package com.sec01;

public class DataType06 {
	public static void main(String[] args) {
		   byte b1=3;
	       byte b2=4;
	       int b3=b1+b2;     // 더하기는 기본 정수형 타입으로 계산되기 때문에 int로 캐스팅 해줘야 
	       //short sh = b1+b2;  // error 발생      
	       //char ch = b1+b2;   // error 발생
	       int i=b1+b2;
	       long l = b1+b2;
	       float f = b1+b2;
	       double d = b1+b2;
	}
}
