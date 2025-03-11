package workshop.com.work3;

import java.util.Scanner;

public class Test06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum = 0;
		int a = sc.nextInt();
		for (int i = a; i <= 100; i++) {
			if(i % 5 == 0) {
				sum += i;
			}
			
		}
		System.out.println(sum);
		sc.close();
	}

}
