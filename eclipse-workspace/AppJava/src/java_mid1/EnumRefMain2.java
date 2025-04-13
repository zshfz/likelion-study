package java_mid1;

enum Grade {
	BASIC(10), GOLD(20), DIAMOND(30);

	private final int discountPercent;

	Grade(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public int getDiscountPercent() {
		return discountPercent;
	}
	
	public int discount(int price) {
		return price * discountPercent / 100;
	}
}

public class EnumRefMain2 {

	public static void main(String[] args) {
		int price = 10000;
		
		Grade[] grades = Grade.values();
		for(Grade grade : grades){
			System.out.println(grade.name() + "등급의 할인 금액: " + grade.discount(price));
		}
		
		System.out.println("BASIC 등급의 할인 금액: " + Grade.BASIC.discount(price));
		System.out.println("GOLD 등급의 할인 금액: " + Grade.GOLD.discount(price));
		System.out.println("DIAMOND 등급의 할인 금액: " + Grade.DIAMOND.discount(price));
	}

}