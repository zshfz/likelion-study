package workshop.com.work4;

public class Test03 {

	public static void main(String[] args) {
		int[][] arr2 = {
				{ 5, 5, 5, 5, 5},
				{10,10,10,10,10},
				{20,20,20,20,20},
				{30,30,30,30,30}
				};
		
		int sum = 0;
		
		for(int i=0;i<arr2.length;i++) {
			for(int j=0;j<arr2[i].length;j++) {
				sum += arr2[i][j];
			}
		}
		
		System.out.println("total="+sum);
		System.out.println("average="+sum/20.0);
	}
	
}
