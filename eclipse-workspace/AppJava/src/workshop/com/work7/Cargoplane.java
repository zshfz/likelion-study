package workshop.com.work7;

public class Cargoplane extends Plane {

	public Cargoplane() {
		super();
	}

	public Cargoplane(String planeName, int fuelSize) {
		super(planeName, fuelSize);
	}
	
	public void flight(int distance) {
		setFuelSize(getFuelSize()-(distance * 5));
	}
	
}
