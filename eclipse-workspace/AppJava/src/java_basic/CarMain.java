package java_basic;

public class CarMain {

	public static void main(String[] args) {
		Car car1 = new Car("K3");
		Car car2 = new Car("G80");
		Car car3 = new Car("Model Y");
		Car.showTotalCars(); 
	}

}

class Car{
	private String name;
	static int count;
	
	public Car(String name) {
		this.name = name;
		System.out.println("차량 구입, 이름: " + name);
		count++;
		
	}
	
	public static void showTotalCars() {
		System.out.println("구매한 차량 수:" + count);
	}
}
