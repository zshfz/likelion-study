package java_start;

import java.util.Scanner;

public class ProductAdminEx {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String[] productNames = new String[10];
		int[] productPrices = new int[10];
		int productCount = 0;
		
		while(true) {
			System.out.println("1. 상품등록 | 2. 상품 목록 | 3. 종료");
			System.out.print("메뉴를 선택하세요: ");
			int menu = sc.nextInt();
			if(menu == 1) {
				if(productCount >= 10) {
					System.out.println("더이상 상품 등록 할 수 없습니다");
					continue;
				}else {
					System.out.print("상품 이름을 입력하세요: ");
					sc.nextLine();
					productNames[productCount] = sc.nextLine();
					System.out.print("상품 가격 입력하세요: ");
					productPrices[productCount] = sc.nextInt();
					productCount++;
				}
				
			}else if(menu == 2){
				if(productCount == 0) {
					System.out.println("등록된 상품이 없습니다");
				}else {
					for(int i=0;i<productCount;i++) {
						System.out.println(productNames[i] + " : " + productPrices[i]);
					}
				}
			}else if(menu == 3){
				System.out.println("프로그램을 종료합니다");
				break;
			}
		}
	}

}
