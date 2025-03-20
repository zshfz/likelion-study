package com.sec01;

public class DataType07 {

	public static void main(String[] args) {		 
		 double  d= 3.14F;		//묵시형 형변환 
		  int  res=(int)d;		//명시적 형변
		  
		  System.out.println( "promotion d="+ d) ;		  
		  System.out.println(" casting res ="+ res);	 
	}
}
