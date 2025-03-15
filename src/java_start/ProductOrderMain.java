package java_start;

public class ProductOrderMain {

	public static void main(String[] args) {
		ProductOrder p1 = new ProductOrder();
		ProductOrder p2 = new ProductOrder();
		ProductOrder p3 = new ProductOrder();
		
		p1.productName = "두부";
		p1.price = 2000;
		p1.quantity = 2;
		
		p2.productName = "김치";
		p2.price = 5000;
		p2.quantity = 1;
		
		p3.productName = "콜라";
		p3.price = 1500;
		p3.quantity = 2;
		
		ProductOrder[] product = new ProductOrder[3];
		product[0] = p1;
		product[1] = p2;
		product[2] = p3;
		
		int total=0;
		for(ProductOrder p : product) {
			total += (p.price * p.quantity);
		}
		
		System.out.println(total);
		
	}

}

class ProductOrder {
	String productName;
	int price;
	int quantity;
}
