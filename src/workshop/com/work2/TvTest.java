package workshop.com.work2;

public class TvTest {

	public static void main(String[] args) {
		//배열 초기화
		Tv[] tvArray = new Tv[] {
				new Tv("INFINIA", 1500000, "LED TV"),
				new Tv("XCANVAS", 1000000, "LCD TV"),
				new Tv("CINEMA", 2000000, "3D TV")
		};
		
		//제품 정보 출력
		for(int i = 0;i<tvArray.length;i++) {
			System.out.println(tvArray[i]);
		}
		
		//가장 비싼 제품 찾
		int max = tvArray[0].getPrice();
		int min = tvArray[0].getPrice();
		
		String expensiveTv= "";
		String cheapTv= "";
		
		for(int i = 0;i<tvArray.length;i++) {
			if(tvArray[i].getPrice() > max) {
				max = tvArray[i].getPrice();
			}
			
			if(tvArray[i].getPrice() < min) {
				min = tvArray[i].getPrice();
			}
		}
		
		for(int i = 0;i<tvArray.length;i++) {
			if(tvArray[i].getPrice() == max) {
				expensiveTv = tvArray[i].getName();
			}
		}
		
		for(int i = 0;i<tvArray.length;i++) {
			if(tvArray[i].getPrice() == min) {
				cheapTv = tvArray[i].getName();
			}
		}
		
		System.out.println("가장 비싼 제품 : " + expensiveTv);
		System.out.println("가장 싼 제품 : " + cheapTv);
		
	}

}

class Tv {
	private String name;
	private int price;
	private String description;
	
	Tv(String name, int price, String description){
		this.name = name;
		this.price = price;
		this.description = description;
	}
	
	public String getName() {
		return name;
	}
	
	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return String.format("%10s %10s %10s", this.name, this.price, this.description);
	}
	
	
	
}
