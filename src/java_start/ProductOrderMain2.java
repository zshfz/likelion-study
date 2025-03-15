package java_start;

import java.util.Scanner;

public class ProductOrderMain2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("입력할 주문의 개수를 입력하세요: ");
		int count = sc.nextInt();
		ProductOrder[] orders = new ProductOrder[count];
		
		
		for(int i=0;i<count;i++) {
			System.out.println((i+1) + "번째 주문 정보를 입력하세요");
			 sc.nextLine(); 
			System.out.print("상품명: ");
			String productName = sc.nextLine();
			System.out.print("가격: ");
			int price = sc.nextInt();
			System.out.print("수량: ");
			int quantity = sc.nextInt();
			orders[i] = createOrder(productName, price, quantity);
		}
		
		printOrders(orders);
		System.out.println("총 가격: " + getTotalAmount(orders));
		
		
	}
	
	static ProductOrder createOrder(String productName, int price, int quantity) {
		ProductOrder p = new ProductOrder();
		p.productName = productName;
		p.price = price;
		p.quantity = quantity;
		
		return p;
	}
	
	static void printOrders(ProductOrder[] orders) {
		for(ProductOrder order : orders) {
			System.out.println("상품명: " + order.productName + ", 가격: " + order.price + ", 수량: " + order.quantity);
		}
	}
	
	static int getTotalAmount(ProductOrder[] orders) {
		int tot = 0;
		for(ProductOrder p : orders) {
			tot += p.price * p.quantity;
		}
		return tot;
	}

}


