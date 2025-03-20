package java_start;

import java.util.Scanner;

public class ScannerWhileEx3 {

	public static void main(String[] args) {
//		문제 - 입력한 숫자의 합계와 평균
//		사용자로부터 여러 개의 숫자를 입력 받고, 그 숫자들의 합계와 평균을 계산하는 프로그램을 작성하세요. 사용자
//		는 숫자를 입력하고, 마지막에는 -1을 입력하여 숫자 입력을 종료한다고 가정합니다.
//		모든 숫자의 입력이 끝난 후에는, 숫자들의 합계 `sum` 과 평균 `average` 를 출력하세요. 평균은 소수점 아래까지
//		계산해야 합니다.
//		다음 실행 결과 예시를 참고해주세요.
		Scanner sc = new Scanner(System.in);
		
		int sum = 0;
		int count = 0;
		
		System.out.println("숫자를 입력하세요. 입력을 중단하려면 -1 입력하세요");
		while(true) {
			int input = sc.nextInt();
			if(input == -1) {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			sum += input;
			count++;
			
		}
		
		/*
		while ((input = scanner.nextInt()) != -1) {
		sum += input;
		count++;
		}
		*/
		
		System.out.println("합계 : " + sum);
		System.out.println("평균: " + (double)sum/count);

	}

}
