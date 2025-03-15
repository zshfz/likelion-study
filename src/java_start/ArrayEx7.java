package java_start;

import java.util.Scanner;

public class ArrayEx7 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("학생 수를 입력하세요:");
		int student = sc.nextInt();
		int[][] arr = new int[student][3];
		String[] subjects = { "국어", "영어", "수학" };
		
		for (int i = 0; i < student; i++) {
			System.out.println((i+1) + "번 학생의 성적을 입력하세요");
			for (int j = 0; j < 3; j++) {
				System.out.print(subjects[j] + "점수: ");
				arr[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 0; i < student; i++) {
			int tot = 0;
			for (int j = 0; j < 3; j++) {
				tot += arr[i][j];
			}
			System.out.println((i+1) + "번 학생의 총점: " + tot + " 평균: " + tot/3.0);
		}
	}

}
