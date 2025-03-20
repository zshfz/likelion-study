package com.sec04;
import java.util.Scanner;

public class IfTest03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("한문자를 입력하세요: ");
		char ch = sc.next().charAt(0);

		if (Character.isLowerCase(ch)) {
			System.out.println("ch=" + ch + " 소문자");
			System.out.println("대문자로 변환 : " + Character.toUpperCase(ch));
		} else if (Character.isUpperCase(ch)) {
			System.out.println("ch=" + ch + " 대문자");
			System.out.println("소문자로 변환 : " + Character.toLowerCase(ch));
		} else if (Character.isDigit(ch)) {
			System.out.println("ch=" + ch + " 숫자");
		} else {
			System.out.println("이도저도 아님");
		}
	}
}


