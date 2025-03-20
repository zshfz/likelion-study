package com.sec04.exam;
import java.util.Scanner;

public class b_Scanner {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		System.out.print("input i : ");
////	     int i = sc.nextInt();
//	     double i =  sc.nextDouble();
//	     System.out.println("입력받은 값 : " + i);
//	     
//	     sc.close();
		
		//이름 주소 전화번호 입력받아 출력해보
		Scanner sc = new Scanner(System.in); //System.in 표준 입력장치로 스캔하겠다라는 의미
		System.out.print("이름을 입력하세요 : ");
		String name = sc.nextLine(); //엔터로 구분, 한 라인에 있는 줄은 하나로 구분
		System.out.print("주소을 입력하세요 : ");
		String addr = sc.nextLine();
		System.out.print("전화번호을 입력하세요 : ");
		String tel = sc.nextLine();
		
		System.out.printf("%10s %10s %10s\n", name, addr, tel);
		sc.close();
	}

}
