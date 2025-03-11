package com.sec07.mytest;

public class MTest01 {

	public static void main(String[] args) {
		
		DD d1 = new DD();
		
		System.out.println("초기값 확인 : " + d1.getRes());
		
		prn(d1);
		prn02(d1);
		
		BB b1 = new BB();
		prn02(b1);
		
	}
	public static void prn(DD res) { //정적 바인딩
		res.setA(100);
		res.setB(20);
		res.setC(1);
		res.setD(1);
		System.out.println(res.getRes());
	}
	
	public static void prn02(AA res) { //동적 바인딩
		res.setA(100);
		res.setB(20);
		((BB) res).setC(1);
		((DD) res).setD(1);
		System.out.println(((DD) res).getRes());
	}

}
