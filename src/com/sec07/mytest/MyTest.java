package com.sec07.mytest;

import java.util.Calendar;
import java.util.GregorianCalendar;

//API 확인 후 상속 받자
public class MyTest extends GregorianCalendar{
	
	
	
	public MyTest(int i, int j, int k) {
		super(i, j, k);
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "내꺼"	;
	}

	public static void main(String[] args) {
		MyTest m1= new MyTest(2025, 3, 11);
		System.out.println(m1.toString());
		System.out.println(m1.get(Calendar.YEAR)+":"+m1.get(Calendar.MONTH));
		
	}

}
