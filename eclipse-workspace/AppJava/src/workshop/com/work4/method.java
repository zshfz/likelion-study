package workshop.com.work4;

public class method {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		int sum = 0;
		
		for(int res : arr) {
			sum += res;
		}
		
		System.out.println("sum=" + sum);
		System.out.println("avg=" + sum/5.0);
	}

}
