package workshop.com.work7;

public abstract class Plane {
	private String planeName;
	private int fuelSize;
	
	public Plane() {
		super();
	}

	public Plane(String planeName, int fuelSize) {
		super();
		this.planeName = planeName;
		this.fuelSize = fuelSize;
	}
	
	
	public String getPlaneName() {
		return planeName;
	}

	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}

	public int getFuelSize() {
		return fuelSize;
	}

	public void setFuelSize(int fuelSize) {
		this.fuelSize = fuelSize;
	}

	public void refuel(int fuel) {
		setFuelSize(getFuelSize() + fuel);
	}
	
	void flight(int distance) {}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%5s %5d",getPlaneName(), getFuelSize());
	}
	
	
}
