package java_start;

import java.util.Scanner;

public class ScannerWhileEx4 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalPrice = 0;
		
		while(true) {
			System.out.println("1: 상품입력, 2: 결제, 3: 프로그렘 종료");
			int option = sc.nextInt();
			
			if(option == 1) {
				sc.nextLine(); //위에서 nextInt가 \n를 가져가 주지 않기 때문에
				System.out.println("상품명을 입력하세요 : ");
				String product = sc.nextLine();
				
				System.out.println("상품의 가격을 입력하세요 : ");
				int price = sc.nextInt();
				
				System.out.println("구매 수량을 입력하세요 : ");
				int quantity = sc.nextInt();
				System.out.println("상품명 : " + product + " 수량 : " + quantity + " 합계 : " + (price * quantity));
				totalPrice += (price * quantity);
			}else if(option == 2) {
				System.out.println("총비용 : " + totalPrice);
				totalPrice = 0;
			}else if(option == -1) {
				System.out.println("프로그램을 종료합니다");
				break;
			}
		}
		
	}
}
