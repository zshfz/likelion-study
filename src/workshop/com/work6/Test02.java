package workshop.com.work6;

public class Test02 {

	public static void main(String[] args) {
		Calc c = new Calc();
		int[] intArg = new int[args.length];
		
		for(int i=0;i<args.length;i++) {
			intArg[i] = Integer.parseInt(args[i]);
		}
		
		System.out.print("짝수 : ");
		for(int i : intArg) {
			if(i % 2 == 0) {
			System.out.printf("%3d", i);
			}
		}
		
		System.out.println();
		int result = c.calculate(intArg);
		System.out.println("결과 : " + result);
	}

}

class Calc{
	public int calculate(int[] data) {
		int sum = 0;
		for(int i=0;i<data.length;i++) {
			if(data[i] % 2 == 0) {
				sum += data[i];
			}
		}
		return sum;
	}
}