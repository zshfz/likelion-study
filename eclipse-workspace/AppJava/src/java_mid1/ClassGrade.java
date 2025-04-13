package java_mid1;

public class ClassGrade {
	public static final ClassGrade BASIC = new ClassGrade();
	public static final ClassGrade GOLD = new ClassGrade();
	public static final ClassGrade DIAMOND = new ClassGrade();
	
	private ClassGrade() {}
}

class DiscountService {
	public int discount(ClassGrade classGrade, int price) {
		int discountPercent = 0;

		if (classGrade == ClassGrade.BASIC) {
			discountPercent = 10;
		} else if (classGrade == ClassGrade.GOLD) {
			discountPercent = 20;
		} else if (classGrade == ClassGrade.DIAMOND) {
			discountPercent = 30;
		} else {
			System.out.println("할인X");
		}

		return price * discountPercent / 100;
	}
}

class main {
	public static void main(String[] args) {
		int price = 10000;
		
		DiscountService discountService = new DiscountService();
		
		int basic = discountService.discount(ClassGrade.BASIC, price);
		int gold = discountService.discount(ClassGrade.GOLD, price);
		int diamond = discountService.discount(ClassGrade.DIAMOND, price);
		
		System.out.println("BASIC 등급의 할인 금액: " + basic);
		System.out.println("GOLD 등급의 할인 금액: " + gold);
		System.out.println("DIAMOND 등급의 할인 금액: " + diamond);
	}
}
