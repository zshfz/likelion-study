package workshop.com.work7;

public class PlaneTest {

	public static void main(String[] args) {
		Plane[] p = new Plane[] {
				new Airplane("L747", 1000),
				new Cargoplane("C40", 1000),
		};
		
		for(Plane plane : p) {
			System.out.println(plane.toString());
		}
		
		
		for(Plane plane : p) {
			plane.flight(100);
		}
		
		System.out.println("100 운항");
		
		for(Plane plane : p) {
			System.out.println(plane.toString());
		}
		
		for(Plane plane : p) {
			plane.refuel(200);
		}
		
		System.out.println("200 주유");
		
		for(Plane plane : p) {
			System.out.println(plane.toString());
		}
	}

}
