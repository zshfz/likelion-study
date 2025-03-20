package workshop.com.work7;

public class Airplane extends Plane {

	public Airplane() {
		super();
	}

	public Airplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	
	public void flight(int distance) {
		setFuelSize(getFuelSize()-(distance * 3));
	}
	
}
