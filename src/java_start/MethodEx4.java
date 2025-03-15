package java_start;

import java.util.Scanner;

public class MethodEx4 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int money = 0;

		while (true) {
			System.out.println("1.입금 | 2.출금 | 3.잔액확인 | 4.종료");
			System.out.print("선택: ");
			int option = sc.nextInt();
			if (option == 1) {
				System.out.print("입금액을 입력하세요: ");
				int add = sc.nextInt();
				money = deposit(money, add);
			} else if (option == 2) {
				System.out.print("출금액을 입력하세요: ");
				int sub = sc.nextInt();
				money = withdraw(money, sub);
			} else if (option == 3) {
				System.out.println("현재 잔액: " + money);
			} else if (option == 4) {
				System.out.println("프로그램을 종료합니다");
				break;
			} else {
				System.out.println("잘못된 입력입니다");
				continue;
			}
		}

	}

	public static int deposit(int money, int add) {
		money += add;
		System.out.println(add + "원을 입금하였습니다. 현재 잔액: " + money);
		return money;
	}

	public static int withdraw(int money, int sub) {
		if(sub > money) {
			System.out.println(sub + "원을 출금하려 했으나 잔액이 부족합니다");
			return money;
		}else {
			money -= sub;
			System.out.println(sub + "원을 출금하셨습니다. 현재 잔액: " + money);
			return money;
		}
	}

}
