package java_mid1;

import java.util.Scanner;

public class MainV1 {

	public static void main(String[] args) {
		NetworkServiceV1_1 networkService = new NetworkServiceV1_1();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("전송할 문자 : ");
			String data = sc.nextLine();
			if(data.equals("exit")){
				break;
			}
			networkService.sendMessage(data);
			System.out.println();
		}
		System.out.println("프로그램을 정상 종료합니다");
	}

}
